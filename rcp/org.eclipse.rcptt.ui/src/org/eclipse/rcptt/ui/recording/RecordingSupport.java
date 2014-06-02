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
package org.eclipse.rcptt.ui.recording;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.rcptt.ecl.core.Script;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.recording.CommandSet;
import org.eclipse.rcptt.core.recording.IRecordingListener;
import org.eclipse.rcptt.core.recording.IRecordingMonitor;
import org.eclipse.rcptt.core.recording.NetworkRecorder;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.core.utils.ModelCycleDetector;
import org.eclipse.rcptt.core.workspace.IWorkspaceFinder;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.core.workspace.Q7Utils;
import org.eclipse.rcptt.core.workspace.WorkspaceFinder;
import org.eclipse.rcptt.core.ecl.core.model.CreateReport;
import org.eclipse.rcptt.core.ecl.core.model.ExecVerification;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.ecl.core.model.SetQ7Features;
import org.eclipse.rcptt.internal.core.model.ModelManager;
import org.eclipse.rcptt.internal.core.model.Q7InternalTestCase;
import org.eclipse.rcptt.internal.launching.ExecutionStatus;
import org.eclipse.rcptt.internal.launching.PrepareExecutionWrapper;
import org.eclipse.rcptt.internal.launching.Q7LaunchManager;
import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutLaunchState;
import org.eclipse.rcptt.launching.Q7LaunchUtils;
import org.eclipse.rcptt.launching.Q7Launcher;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.launching.aut.AUTConnectionErrorDialog;
import org.eclipse.rcptt.ui.launching.aut.AutElement;
import org.eclipse.rcptt.ui.panels.main.ControlPanelWindow;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.TeslaScenarioContainer;
import org.eclipse.rcptt.tesla.core.features.IMLFeatures;
import org.eclipse.rcptt.tesla.core.network.TeslaNetworkReplayer;
import org.eclipse.rcptt.tesla.core.protocol.WaitForRestart;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.core.utils.TeslaUtils;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.internal.core.network.DefaultConnectionMonitor;
import org.eclipse.rcptt.tesla.recording.core.ecl.EclRecorder;

public class RecordingSupport {

	public enum RecordingMode {
		Stopped, Connecting, Replaying, WaitingForAUTRestart, Recording, Asserting, ImageRecognition
	}

	private static class PlanEntry {
		public IQ7NamedElement element;
		public ExecutionPhase phase;

		public PlanEntry(IQ7NamedElement element) {
			this(element, ExecutionPhase.AUTO);
		}

		public PlanEntry(IQ7NamedElement element, ExecutionPhase phase) {
			this.element = element;
			this.phase = phase;
		}
	}

	private final ControlPanelWindow window;
	private Scenario previous;
	private final Scenario scenarioWorkingCopy;
	private final Scenario originalScenario;
	private final WritableValue autObservable = new WritableValue(null,
			AutElement.class);
	private final WritableValue modeObservable = new WritableValue(
			RecordingMode.Stopped, RecordingMode.class);
	private TeslaNetworkReplayer player;
	private UiNetworkRecorder recorder;
	private final IRecordingMonitor recordingMonitor = new RecordingMonitor();
	private final List<IRecordingListener> recordingListeners = new ArrayList<IRecordingListener>();

	public RecordingSupport(ControlPanelWindow window,
			Scenario scenarioWorkingCopy, Scenario originalScenario) {
		this.window = window;
		this.scenarioWorkingCopy = scenarioWorkingCopy;
		this.originalScenario = originalScenario;
		addRecordingListener(new RecordingListener());
		this.modeObservable.addChangeListener(new RecordingModeListener());
		RecordingContextManager.Instance.observeRecordModeShortcuts()
				.addChangeListener(new IChangeListener() {
					public void handleChange(ChangeEvent event) {

					}
				});
		RecordingContextManager.Instance.observeAssertModeShortcuts()
				.addChangeListener(new IChangeListener() {
					public void handleChange(ChangeEvent event) {

					}
				});
		RecordingContextManager.Instance.observeStartRecordShortcuts()
				.addChangeListener(new IChangeListener() {
					public void handleChange(ChangeEvent event) {

					}
				});
		RecordingContextManager.Instance.observeStopRecordShortcuts()
				.addChangeListener(new IChangeListener() {
					public void handleChange(ChangeEvent event) {

					}
				});
		RecordingContextManager.Instance.observeReplayShortcuts()
				.addChangeListener(new IChangeListener() {
					public void handleChange(ChangeEvent event) {

					}
				});
	}

	public synchronized void addRecordingListener(IRecordingListener listener) {
		if (!recordingListeners.contains(listener)) {
			recordingListeners.add(listener);
		}
	}

	public synchronized void removeRecordingListener(IRecordingListener listener) {
		recordingListeners.remove(listener);
	}

	public AutLaunch getAUT() {
		final AutLaunch[] aut = new AutLaunch[1];
		Q7UIPlugin.getDisplay().syncExec(new Runnable() {
			public void run() {
				aut[0] = (AutLaunch) autObservable.getValue();
			}
		});
		return aut[0];
	}

	public void setAUT(AutLaunch aut) {
		autObservable.setValue(aut);
	}

	public IObservableValue observeAUT() {
		return autObservable;
	}

	public RecordingMode getMode() {
		final RecordingMode[] mode = new RecordingMode[1];
		Q7UIPlugin.getDisplay().syncExec(new Runnable() {
			public void run() {
				mode[0] = (RecordingMode) modeObservable.getValue();
			}
		});
		return mode[0];
	}

	public void setMode(final RecordingMode mode) {
		Q7UIPlugin.getDisplay().asyncExec(new Runnable() {
			public void run() {
				modeObservable.setValue(mode);
			}
		});
	}

	public IObservableValue observeMode() {
		return modeObservable;
	}

	public NetworkRecorder getRecorder() {
		return recorder;
	}

	private boolean selectAUT() {
		final boolean[] result = new boolean[1];
		Q7UIPlugin.getDisplay().syncExec(new Runnable() {
			public void run() {
				AutLaunch launch = (AutLaunch) autObservable.getValue();
				if (launch != null) {
					if (!launch.getState().equals(AutLaunchState.TERMINATE)) {
						result[0] = true;
						return;
					}
				}
				AutLaunch aut = LaunchUtils.selectAutLaunch(window.getShell());
				setAUT(aut);
				result[0] = aut != null;
			}
		});
		return result[0];
	}

	private void runWithProgress(final String name,
			final IRunnableWithProgress runnable, final boolean fork) {
		new Job(name) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				window.runWithProgress(name, runnable, fork);
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	private void replay() {
		ReplayRunnable runnable = new ReplayRunnable(
				Messages.RecordingSupport_ReplayingOp) {
			@Override
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				try {
					super.run(monitor);
				} finally {
					setMode(RecordingMode.Stopped);
				}
			}
		};
		runWithProgress(runnable.getName(), runnable, true);
	}

	private void record() {
		ReplayRunnable replaying = new ReplayRunnable(
				Messages.RecordingSupport_InitialStateOp) {
			@Override
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				try {
					super.run(monitor);
					if (monitor.isCanceled()
							|| getMode() == RecordingMode.Stopped) {
						if (monitor.isCanceled()) {
							setMode(RecordingMode.Stopped);
						}
						throw new InterruptedException();
					}
					connect();
				} catch (InvocationTargetException e) {
					setMode(RecordingMode.Stopped);
					throw e;
				} finally {
					monitor.done();
				}
			}
		};
		runWithProgress(replaying.getName(), replaying, true);
	}

	private void connect() {
		ConnectionRunnable connecting = new ConnectionRunnable();
		runWithProgress(Messages.RecordingSupport_ConnectingOp, connecting,
				true);
	}

	private void waitForAUTRestart() {
		WaitForAUTRestartRunnable restarting = new WaitForAUTRestartRunnable() {
			@Override
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				super.run(monitor);
				if (monitor.isCanceled() || getMode() == RecordingMode.Stopped) {
					throw new InterruptedException();
				}
				connect();
			}
		};
		runWithProgress(Messages.RecordingSupport_WaitingOp, restarting, true);
	}

	private synchronized void recordingMode() {
		try {
			recorder.toRecordMode();
			TeslaFeatures.getInstance().getOption(IMLFeatures.USE_IMAGING)
					.setValue("false"); //$NON-NLS-1$
			sendFeatures();
		} catch (Exception e) {
			Q7UIPlugin.log(e);
		}
	}

	private synchronized void assertingMode() {
		if (recorder == null) {
			return;
		}
		try {
			recorder.toAssertMode();
			TeslaFeatures.getInstance().getOption(IMLFeatures.USE_IMAGING)
					.setValue("false"); //$NON-NLS-1$
			sendFeatures();
		} catch (Exception e) {
			Q7UIPlugin.log(e);
		}
	}

	private synchronized void imageRecognitionMode() {
		try {
			setMode(RecordingMode.ImageRecognition);
			TeslaFeatures.getInstance().getOption(IMLFeatures.USE_IMAGING)
					.setValue("true"); //$NON-NLS-1$
			sendFeatures();
		} catch (Exception e) {
			Q7UIPlugin.log(e);
		}
	}

	public synchronized void sendFeatures() {
		SetQ7Features setQ7Features = Q7CoreFactory.eINSTANCE
				.createSetQ7Features();
		TeslaFeatures.getInstance().storeValues(setQ7Features.getFeatures());
		Q7Features.getInstance().storeValues(setQ7Features.getFeatures());
		if (originalScenario != null)
			Q7LaunchUtils.setQ7Variable(setQ7Features,
					Q7LaunchUtils.Q7_CURRENT_TEST_VAR,
					originalScenario.getName());
		try {
			getAUT().execute(setQ7Features);
		} catch (Exception e) {
			Q7UIPlugin.log(e);
		}
	}

	private synchronized void stop() {
		if (player != null && player.isConnected()) {
			player.cancelConnection();
		}
		if (recorder != null && recorder.isConnected()) {
			recorder.cancelConnection();
		}
		AutLaunch aut = getAUT();
		if (aut != null) {
			try {
				if (Q7LaunchManager.getInstance().isDebuggingActive(aut)) {
					// Cant do anything since debugging is active, and not
					// canceled by user.
					return;
				}
				((BaseAutLaunch)aut).unsafeExecute(TeslaFactory.eINSTANCE.createShoutdownPlayer(),
						10 * 1000, new NullProgressMonitor());
			} catch (CoreException e) {
				AUTConnectionErrorDialog.showAUTConnectionError(window
						.getShell(), e.getStatus(), aut.getAut().getConfig());
			} catch (InterruptedException e) {
				// ignore cancel
			}
		}
	}

	private IWorkspaceFinder getFinder() {
		return WorkspaceFinder.getInstance();
	}

	private synchronized void updateContent() {
		TeslaScenarioContainer container = recorder.getContainer();
		TeslaScenario recordedTesla = container.getScenarioCopy();
		TeslaScenario tesla = Scenarios.getTesla(previous);
		TeslaScenario newTeslaContent = tesla == null ? recordedTesla
				: TeslaUtils.merge(tesla, recordedTesla);
		Scenarios.setTesla(scenarioWorkingCopy, newTeslaContent);
		if (Scenarios.hasUserModifications(previous)) {
			Script script = Scenarios.getEcl(previous);
			String prevContent = script.getContent();
			String recordedContent = new EclRecorder()
					.generateCode(recordedTesla);
			if (prevContent == null || prevContent.length() == 0) {
				Scenarios.setEclContent(scenarioWorkingCopy, recordedContent);
			} else {
				Scenarios.setEclContent(scenarioWorkingCopy, prevContent + "\n" //$NON-NLS-1$
						+ recordedContent);
			}
		}
	}

	private final class RecordingModeListener implements IChangeListener {
		public void handleChange(ChangeEvent event) {
			switch (getMode()) {
			case Connecting:
				record();
				break;
			case Replaying:
				replay();
				break;
			case Stopped:
				stop();
				break;
			case WaitingForAUTRestart:
				waitForAUTRestart();
				break;
			case Recording:
				recordingMode();
				break;
			case Asserting:
				assertingMode();
				break;
			case ImageRecognition:
				imageRecognitionMode();
				break;
			}
		}
	}

	private class RecordingMonitor extends DefaultConnectionMonitor implements
			IRecordingMonitor {
		public void recordMode() {
			synchronized (RecordingSupport.this) {
				for (IRecordingListener listener : recordingListeners) {
					listener.recordMode();
				}
			}
		}

		public void startRecord() {
			synchronized (RecordingSupport.this) {
				for (IRecordingListener listener : recordingListeners) {
					listener.startRecord();
				}
			}
		}

		public void stopRecord() {
			synchronized (RecordingSupport.this) {
				for (IRecordingListener listener : recordingListeners) {
					listener.stopRecord();
				}
			}
		}

		public void replay() {
			synchronized (RecordingSupport.this) {
				for (IRecordingListener listener : recordingListeners) {
					listener.replay();
				}
			}
		}

		public void assertMode() {
			synchronized (RecordingSupport.this) {
				for (IRecordingListener listener : recordingListeners) {
					listener.assertMode();
				}
			}
		}

		public void assertAdded(CommandSet commands) {
			synchronized (RecordingSupport.this) {
				for (IRecordingListener listener : recordingListeners) {
					listener.assertAdded(commands);
				}
			}
		}

	}

	private final class RecordingListener implements IRecordingListener {
		public void handleContainerChange() {
			synchronized (RecordingSupport.this) {
				if (recorder == null) {
					return;
				}
				Job j = getUpdateContentJob();
				Job.getJobManager().cancel(RecordingSupport.class);
				j.schedule(50);
			}
		}

		public void assertAdded(final CommandSet commands) {
		}

		public void recordMode() {
			setMode(RecordingMode.Recording);
		}

		public void assertMode() {
			setMode(RecordingMode.Asserting);
		}

		public void startRecord() {
			setMode(RecordingMode.Connecting);
		}

		public void stopRecord() {
			setMode(RecordingMode.Stopped);
		}

		public void replay() {
			setMode(RecordingMode.Replaying);
		}

		public void disconnected() {
			TeslaScenario teslaScenario;
			synchronized (RecordingSupport.this) {
				teslaScenario = (TeslaScenario) scenarioWorkingCopy
						.getTeslaContent();
			}
			if (teslaScenario != null) {
				EList<org.eclipse.rcptt.tesla.core.protocol.raw.Command> commands = teslaScenario
						.getCommands();
				if (commands.size() > 0) {
					org.eclipse.rcptt.tesla.core.protocol.raw.Command lastCommand = commands
							.get(commands.size() - 1);
					if (lastCommand instanceof WaitForRestart
							&& !getMode().equals(RecordingMode.Stopped)) {
						// Wait for connection to host
						setMode(RecordingMode.WaitingForAUTRestart);
						return;
					}
				}
			}
			setMode(RecordingMode.Stopped);
		}
	}

	private class ReplayRunnable implements IRunnableWithProgress {
		private final String name;

		public ReplayRunnable(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			try {
				if (monitor.isCanceled() || getMode() == RecordingMode.Stopped) {
					throw new InterruptedException();
				}
				if (!selectAUT()) {
					setMode(RecordingMode.Stopped);
					monitor.done();
					return;
				}
				List<IQ7NamedElement> elements = getExecutableElements();
				if (elements.isEmpty()) {
					return;
				}
				monitor.beginTask(name, elements.size() + 3);
				synchronized (this) {
					if (ModelCycleDetector.hasCycles(
							new NamedElement[] { scenarioWorkingCopy },
							getFinder())) {
						IStatus status = new Status(
								IStatus.ERROR,
								Q7UIPlugin.PLUGIN_ID,
								Messages.RecordingSupport_CircularDependenciesMsg);
						monitor.setCanceled(true);
						throw new InvocationTargetException(new CoreException(
								status));
					}
					monitor.worked(1);
				}
				try {
					if (!Q7LaunchManager.getInstance().cancelDebugExecution(
							getAUT(), window.getShell())) {
						monitor.setCanceled(true);
						return;
					}
				} catch (DebugException e1) {
					ExecutionStatus status = new ExecutionStatus(e1.getStatus());
					throw new InvocationTargetException(new CoreException(
							status));
				}

				if (monitor.isCanceled() || getMode() == RecordingMode.Stopped) {
					throw new InterruptedException();
				}
				if (monitor.isCanceled() || getMode() == RecordingMode.Stopped) {
					throw new InterruptedException();
				}
				SetQ7Features setQ7Features = Q7CoreFactory.eINSTANCE
						.createSetQ7Features();
				if (originalScenario != null)
					Q7LaunchUtils.setQ7Variable(setQ7Features,
							Q7LaunchUtils.Q7_CURRENT_TEST_VAR,
							originalScenario.getName());
				TeslaFeatures.getInstance().storeValues(
						setQ7Features.getFeatures());
				Q7Features.getInstance().storeValues(
						setQ7Features.getFeatures());
				try {

					getAUT().execute(setQ7Features);
					ITestCase testCase = null;
					for (IQ7NamedElement element : elements) {
						if (element instanceof ITestCase) {
							testCase = (ITestCase) element;
							break;
						}
					}
					createReport(getAUT(), testCase);
					getAUT().resetState();

					IQ7NamedElement originalScenarioElement = (IQ7NamedElement) RcpttCore
							.create(Q7Utils.getLocation(originalScenario));
					IContext[] contexts = RcpttCore.getInstance().getContexts(originalScenarioElement,
							scenarioWorkingCopy.getContexts(), getFinder(),
							true);
					IVerification[] verifications = RcpttCore.getInstance().getVerifications(originalScenarioElement,
							scenarioWorkingCopy.getVerifications(), getFinder(),
							true);

					for (PlanEntry pe : makeExecutionPlan(testCase, contexts, verifications)) {
						try {
							executePlanEntry(pe, monitor);
						} catch (CoreException e) {
							ExecutionStatus status = new ExecutionStatus(
									e.getStatus());
							status.setElement(pe.element);
							throw new InvocationTargetException(
									new CoreException(status));
						}
					}
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				}
			} finally {
				monitor.done();
			}
		}

		private List<PlanEntry> makeExecutionPlan(ITestCase testcase,
				IContext[] contexts, IVerification[] verifications) {
			List<PlanEntry> plan = new ArrayList<PlanEntry>();

			// for (IVerification v : verifications)
			// try {
			// if (v.getType().supportsPhase(VerificationType.PHASE_START))
			// plan.add(new PlanEntry(v, ExecutionPhase.START));
			// } catch (ModelException e) {
			// Q7LaunchingPlugin.log(
			// "Failed to plan verification: " + v.getName(), e);
			// }

			for (IContext c : contexts)
				plan.add(new PlanEntry(c));

			// for (IVerification v : verifications)
			// try {
			// if (v.getType().supportsPhase(VerificationType.PHASE_RUN))
			// plan.add(new PlanEntry(v, ExecutionPhase.RUN));
			// } catch (ModelException e) {
			// Q7LaunchingPlugin.log(
			// "Failed to plan verification: " + v.getName(), e);
			// }

			if (testcase != null)
				plan.add(new PlanEntry(testcase));

			// for (IVerification v : verifications)
			// try {
			// if (v.getType().supportsPhase(VerificationType.PHASE_FINISH))
			// plan.add(new PlanEntry(v, ExecutionPhase.FINISH));
			// } catch (ModelException e) {
			// Q7LaunchingPlugin.log(
			// "Failed to plan verification: " + v.getName(), e);
			// }

			return plan;
		}

		private List<IQ7NamedElement> getExecutableElements() {
			synchronized (this) {
				List<IQ7NamedElement> elements = new ArrayList<IQ7NamedElement>();
				IQ7NamedElement element = (IQ7NamedElement) RcpttCore
						.create(Q7Utils.getLocation(originalScenario));
				IContext[] contexts = RcpttCore.getInstance().getContexts(element,
						scenarioWorkingCopy.getContexts(), getFinder(),
						true);
				elements.addAll(Arrays.asList(contexts));
				if (scenarioWorkingCopy.getContent() != null
						|| scenarioWorkingCopy.getTeslaContent() != null) {
					elements.add(new Q7InternalTestCase(ModelManager
							.getModelManager().getModel(), "scenario",
							scenarioWorkingCopy));
				}
				return elements;
			}
		}

		private void executePlanEntry(PlanEntry planEntry,
				IProgressMonitor monitor) throws CoreException,
				InterruptedException {
			if (monitor.isCanceled() || getMode() == RecordingMode.Stopped) {
				throw new InterruptedException();
			}
			final IQ7NamedElement element = planEntry.element;
			monitor.subTask(Messages.bind(
					Messages.RecordingSupport_ExecutingElementTask,
					element.getElementName()));
			if (element instanceof ITestCase || element instanceof IContext) {
				getAUT().run(element,
						Q7Launcher.getLaunchTimeout() * 1000, monitor, ExecutionPhase.AUTO);
				monitor.worked(1);
			} else if (element instanceof IVerification) {
				IVerification v = (IVerification) element;
				Verification verification = (Verification) v.getNamedElement();
				VerificationType type = v.getType();
				if (type != null) {
					try {
						type.getMaker().makeExecutable(verification, v);
					} catch (ModelException e) {
						Q7UIPlugin.log(e);
					}
				}
				executeVerification(verification, planEntry.phase, monitor);
				monitor.worked(1);
			}
		}

		private void executeVerification(Verification context, ExecutionPhase phase,
				IProgressMonitor monitor)
				throws CoreException, InterruptedException {
			ExecVerification execVerification = Q7CoreFactory.eINSTANCE
					.createExecVerification();
			execVerification.setVerification(context);
			execVerification.setPhase(phase);
			getAUT().execute(execVerification);
		}
	}

	private final class ConnectionRunnable implements IRunnableWithProgress {

		private static final int TIMEOUT = 30 * 5;

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			if (monitor.isCanceled() || getMode() == RecordingMode.Stopped) {
				throw new InterruptedException();
			}
			if (!selectAUT()) {
				setMode(RecordingMode.Stopped);
				monitor.done();
				return;
			}
			synchronized (this) {
				previous = EcoreUtil.copy(scenarioWorkingCopy);
				BaseAutLaunch launch = (BaseAutLaunch) getAUT();
				UiNetworkRecorder newNetworkRecorder = new UiNetworkRecorder(
						launch.getHost(), launch.getTeslaPort(),
						recordingMonitor);
				recorder = newNetworkRecorder;
				for (IRecordingListener listener : recordingListeners) {
					recorder.addListener(listener);
				}
				recorder.start();
			}
			waitForConnectionJob.schedule();
		}

		private final UIJob waitForConnectionJob = new UIJob(PlatformUI
				.getWorkbench().getDisplay(),
				Messages.RecordingSupport_ConnectingOp) {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				try {
					monitor.beginTask(Messages.RecordingSupport_ConnectingOp,
							TIMEOUT);
					long start = System.currentTimeMillis();
					while (true) {
						synchronized (this) {
							if (recorder.isConnected()) {
								return Status.OK_STATUS;
							}
						}
						if (monitor.isCanceled()) {
							return Status.CANCEL_STATUS;
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							return Status.CANCEL_STATUS;
						}
						if ((System.currentTimeMillis() - start) < TIMEOUT * 1000) {
							monitor.worked(1);
						} else {
							IStatus status = new Status(
									Status.ERROR,
									Q7UIPlugin.PLUGIN_ID,
									Messages.RecordingSupport_ConnectionTimeoutMsg);
							return status;
						}
					}
				} finally {
					synchronized (this) {
						if (recorder.isConnected()) {
							recorder.enableRawEvents(false);
							recorder.setAssertModeListener(new NetworkRecorder.IAssertModeListener() {
								public void doAssertMode() {
									setMode(RecordingMode.Asserting);
								}
							});
							setMode(RecordingMode.Recording);
							PlatformUI.getWorkbench().getDisplay()
									.asyncExec(new Runnable() {
										public void run() {
											RecordingContextManager.Instance
													.activateContext();
											recorder.setRecordModeShortcuts(RecordingContextManager.Instance
													.getRecordModeShortcuts());
											recorder.setAssertModeShortcuts(RecordingContextManager.Instance
													.getAssertModeShortcuts());
											recorder.setStartRecordShortcuts(RecordingContextManager.Instance
													.getStartRecordShortcuts());
											recorder.setStopRecordShortcuts(RecordingContextManager.Instance
													.getStopRecordShortcuts());
											recorder.setReplayShortcuts(RecordingContextManager.Instance
													.getReplayShortcuts());
										}
									});
						} else {
							for (IRecordingListener listener : recordingListeners) {
								recorder.removeListener(listener);
							}
							recorder.cancelConnection();
							recorder.close();
							recorder = null;
							setMode(RecordingMode.Stopped);
						}
					}
				}
			}
		};
	}

	private class WaitForAUTRestartRunnable implements IRunnableWithProgress {

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			if (monitor.isCanceled() || getMode() == RecordingMode.Stopped) {
				throw new InterruptedException();
			}
			if (!selectAUT()) {
				setMode(RecordingMode.Stopped);
				monitor.done();
				return;
			}
			AutLaunch aut = getAUT();
			try {
				aut.waitForRestart(monitor);
			} catch (CoreException e) {
				throw new InvocationTargetException(e);
			}
		}
	}

	public Job getUpdateContentJob() {
		return new Job("Update ECL content") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				updateContent();
				return Status.OK_STATUS;
			}

			@Override
			public boolean belongsTo(Object family) {
				if (RecordingSupport.class.equals(family)) {
					return true;
				}
				return false;
			}
		};
	}

	public void createReport(AutLaunch aut, ITestCase testCase)
			throws CoreException, InterruptedException {
		CreateReport createReport = Q7CoreFactory.eINSTANCE
				.createCreateReport();
		if (testCase != null) {
			createReport.setName(testCase.getName());
			createReport.setQ7info(PrepareExecutionWrapper.getQ7Info(testCase));
		} else {
			createReport.setName("q7.control.panel.recording");
			Q7Info info = ReportingFactory.eINSTANCE.createQ7Info();
			info.setType(ItemKind.TESTCASE);
			info.setId("some_id");
			info.setTags("");
			info.setDescription("");
			createReport.setQ7info(info);
		}
		getAUT().execute(createReport);
	}

	public void addVerification(IVerification verification) {
		try {
			scenarioWorkingCopy.getVerifications().add(verification.getID());
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
	}
}
