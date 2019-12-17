/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.impl.rap;

import static org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin.PLUGIN_ID;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;
import org.eclipse.rcptt.tesla.core.TeslaLimits;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.internal.core.queue.TeslaQClient;
import org.eclipse.rcptt.tesla.internal.ui.player.ReportScreenshotProvider;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.UIJobCollector;
import org.eclipse.rcptt.tesla.swt.events.ITeslaEventListener;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager.HasEventKind;
import org.eclipse.rcptt.tesla.ui.RWTUtils;
import org.eclipse.swt.widgets.Display;

public abstract class UIRunnable<T> {
	private enum RunningState {
		Starting, Execution, Done, Finished
	}

	@SuppressWarnings("unchecked")
	public static <T> T exec(final UIRunnable<T> runnable) throws CoreException {
		final Object[] result = new Object[1];
		final AtomicReference processed = new AtomicReference(RunningState.Starting);
		final Throwable[] exception = new Throwable[] { null };
		final UIJobCollector collector = new UIJobCollector();
		final Display display = RWTUtils.findDisplay();
		Job.getJobManager().addJobChangeListener(collector);
		collector.enable();
		ITeslaEventListener listener = null;
		final IStatus[] dialogCloseStatus = new IStatus[1];
		try {
			listener = new ITeslaEventListener() {
				public synchronized boolean doProcessing(
						org.eclipse.rcptt.tesla.core.context.ContextManagement.Context currentContext) {
					boolean tick = processed.get().equals(RunningState.Starting) || processed.get().equals(RunningState.Execution);
					Q7WaitInfoRoot info = TeslaBridge.getCurrentWaitInfo(tick);

					boolean resultValue = true;

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
					if (processed.get().equals(RunningState.Starting)) {
						processed.set(RunningState.Execution);
						try {
							result[0] = runnable.run();
						} catch (Throwable e) {
							exception[0] = e;
							// Do not collect anything on error
							collector.setNeedDisable();
							// collector.clean();
							processed.set(RunningState.Finished);
							return true;
						}
						processed.set(RunningState.Done);
						return true;
					}
					if (processed.get().equals(RunningState.Done)) {
						collector.setNeedDisable();
						processed.set(RunningState.Finished);
						return true;
					}
					return false;
				}

				public void hasEvent(HasEventKind kind, String run) {
				}
			};
			TeslaEventManager.getManager().addEventListener(listener);
			long start = System.currentTimeMillis();
			while (!processed.get().equals(RunningState.Finished)) {
				if (display.isDisposed())
					throw new CoreException(Status.CANCEL_STATUS);
				// Perform wakeup async
				SWTUIPlayer.notifyUI(display);
				Thread.sleep(1);// Just to wait min time.
				if (exception[0] != null) {
					if (exception[0] instanceof CoreException)
						throw (CoreException)exception[0];
					throw new CoreException(createError(exception[0]));
				}
				long time = System.currentTimeMillis();
				if (time > start + (getTimeout() / 2)) {
					if (processed.get().equals(RunningState.Starting)) {
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
					MultiStatus status = new MultiStatus(PLUGIN_ID, 0, "Timeout during execution of " + runnable, null) {
						{
							setSeverity(ERROR);
						}
					};
					if (dialogCloseStatus[0] != null)
						status.add(dialogCloseStatus[0]);
					throw new CoreException(status);
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
			UIJobCollector collector) throws InterruptedException {
		final ReportBuilder currentBuilder = ReportManager.getBuilder();
		final boolean infoCollected[] = { false };
		display.asyncExec(new Runnable() {
			public void run() {
				TeslaQClient client = TeslaBridge.getClient();
				if (client != null) {
					client.collectLastFailureInformation();
				}
				ReportScreenshotProvider.takeScreenshot(display, true,
						"timeout");
			}
		});
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
