/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.runtime.ui;

import static org.eclipse.rcptt.internal.runtime.ui.Activator.PLUGIN_ID;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;
import org.eclipse.rcptt.tesla.core.TeslaLimits;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.internal.core.info.GeneralInformationCollector;
import org.eclipse.rcptt.tesla.internal.core.queue.TeslaQClient;
import org.eclipse.rcptt.tesla.internal.ui.player.ReportScreenshotProvider;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.UIJobCollector;
import org.eclipse.rcptt.tesla.swt.events.ITeslaEventListener;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager.HasEventKind;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public abstract class UIRunnable<T> {
	private enum RunningState {
		Starting, Execution, Done, Finished
	}

	@SuppressWarnings("unchecked")
	public static <T> T exec(final UIRunnable<T> runnable) throws CoreException {
		final Object[] result = new Object[1];
		final RunningState[] processed = new RunningState[] { RunningState.Starting };
		final Throwable[] exception = new Throwable[] { null };
		final UIJobCollector collector = new UIJobCollector();
		final Display display = PlatformUI.getWorkbench().getDisplay();
		Job.getJobManager().addJobChangeListener(collector);
		collector.enable();
		ITeslaEventListener listener = null;
		final IStatus[] dialogCloseStatus = new IStatus[1];  
		try {
			listener = new ITeslaEventListener() {
				public synchronized boolean doProcessing(
						org.eclipse.rcptt.tesla.core.context.ContextManagement.Context currentContext) {
					boolean tick = processed[0].equals(RunningState.Starting) || processed[0].equals(RunningState.Execution);
					Q7WaitInfoRoot info = TeslaBridge.getCurrentWaitInfo(tick);
					
					boolean resultValue = true;
					
					if (!PlatformUI.getWorkbench().getDisplay()
							.equals(Display.getCurrent())) {
						resultValue = false;
					}
					// Return false if we have SWT observable in timers
					if (SWTUIPlayer.hasTimers(display, info)) {
						resultValue = false;
					}
					// Check for asyncs in synchronizer
					if (SWTUIPlayer.hasRunnables(display)) {
						//Q7WaitUtils.updateInfo("display", "runnables", info);
						resultValue = false;
					}
					if (!collector.isEmpty(currentContext, info)) {
						resultValue = false;
					}
					if( !resultValue ) {
						return false;
					}
					if (processed[0].equals(RunningState.Starting)) {
						processed[0] = RunningState.Execution;
						try {
							result[0] = runnable.run();
						} catch (Throwable e) {
							exception[0] = e;
							// Do not collect anything on error
							collector.setNeedDisable();
							// collector.clean();
							processed[0] = RunningState.Finished;
							return true;
						}
						processed[0] = RunningState.Done;
						return true;
					}
					if (processed[0].equals(RunningState.Done)) {
						collector.setNeedDisable();
						processed[0] = RunningState.Finished;
						return true;
					}
					return false;
				}

				public void hasEvent(HasEventKind kind, String run) {
				}
			};
			TeslaEventManager.getManager().addEventListener(listener);
			long start = System.currentTimeMillis();
			while (!processed[0].equals(RunningState.Finished)) {
				if (display.isDisposed())
					throw new CoreException(Status.CANCEL_STATUS);
				// Perform wakeup async
				SWTUIPlayer.notifyUI(display);
				Thread.sleep(50);
				if (exception[0] != null) {
					if (exception[0] instanceof CoreException)
						throw (CoreException)exception[0];
					throw new CoreException(createError(exception[0]));
				}
				long time = System.currentTimeMillis();
				if (time > start + (getTimeout() / 2)) {
					if (processed[0].equals(RunningState.Starting)) {
						// try to close all modal dialogs and clean job
						// processor
						display.asyncExec(new Runnable() {
							public void run() {
								dialogCloseStatus[0] = Utils.closeDialogs();
							}
						});
						collector.clean();
					}
				}
				if (time > start + getTimeout()) {
					// Lets also capture all thread dump.
					storeTimeoutInReport(display, collector);
					MultiStatus status = new MultiStatus(PLUGIN_ID, 0, "Timeout during context execution...", null) {
						{
							setSeverity(ERROR);
						}
					};
					if (dialogCloseStatus[0] != null)
						status.add(dialogCloseStatus[0]);
				}
			}
			long timeoutLeft = System.currentTimeMillis() - start;
			long timeLeft = getTimeout() - timeoutLeft;
			if (timeLeft < 0) {
				timeLeft = 5000;
			}
			collector.join(timeLeft);
		} catch (InterruptedException e) {
			throw new CoreException(Status.CANCEL_STATUS);
		} finally {
			Job.getJobManager().removeJobChangeListener(collector);
			TeslaEventManager.getManager().removeEventListener(listener);
		}
		return (T) result[0];
	}

	private static IStatus createError(final Throwable exception) {
		return new Status(Status.ERROR, PLUGIN_ID, exception.getMessage(), exception);
	}

	private static int getTimeout() {
		return TeslaLimits.getContextRunnableTimeout();
	}

	private static void storeTimeoutInReport(final Display display,
			UIJobCollector collector) {
		final ReportBuilder currentBuilder = ReportManager.getBuilder();
		final boolean infoCollected[] = { false };
		display.asyncExec(new Runnable() {
			public void run() {
				ReportScreenshotProvider.takeScreenshot(display, true,
						"timeout");

				TeslaQClient client = TeslaBridge.getClient();
				if (client != null) {
					client.collectLastFailureInformation();

					currentBuilder.takeSnapshot(null,
							ReportManager.eventProviders);
				}
				infoCollected[0] = true;
			}
		});

		long waitStart = System.currentTimeMillis();
		while (!infoCollected[0]
				&& (System.currentTimeMillis() - waitStart) < 5000) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// Ignore
			}
		}
		if (!infoCollected[0]) {
			// At least add Thread dump.
			AdvancedInformation info = TeslaBridge.getLastInfo();
			if (info == null) {
				info = InfoFactory.eINSTANCE.createAdvancedInformation();
				GeneralInformationCollector.collectInformation(info);
			}
			if (info != null && currentBuilder != null) {
				ReportHelper.addSnapshotWithData(currentBuilder.getCurrent(), info);
			}
		}
	}

	public static <T> T safeExec(final UIRunnable<T> runnable) {
		try {
			return exec(runnable);
		} catch (CoreException e) {
			// ignore exceptions
			return null;
		}
	}

	public abstract T run() throws CoreException;

}
