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
package org.eclipse.rcptt.internal.launching;

import static org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin.PLUGIN_ID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.SuperContextSupport;
import org.eclipse.rcptt.core.model.SuperContextSupport.ContextConfiguration;
import org.eclipse.rcptt.core.model.search.ISearchScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.core.scenario.SuperContext;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;
import org.eclipse.rcptt.core.scenario.UnresolvedContext;
import org.eclipse.rcptt.core.scenario.UnresolvedVerification;
import org.eclipse.rcptt.core.utils.ModelCycleDetector;
import org.eclipse.rcptt.core.utils.SortingUtils;
import org.eclipse.rcptt.core.workspace.IWorkspaceFinder;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.core.workspace.WorkspaceFinder;
import org.eclipse.rcptt.internal.launching.ecl.EclContextExecutable;
import org.eclipse.rcptt.internal.launching.ecl.EclDebugContextExecutable;
import org.eclipse.rcptt.internal.launching.ecl.EclDebugTestExecutable;
import org.eclipse.rcptt.internal.launching.ecl.EclDebugVerificationExecutable;
import org.eclipse.rcptt.internal.launching.ecl.EclScenarioExecutable;
import org.eclipse.rcptt.internal.launching.ecl.EclVerificationExecutable;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutable.State;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.launching.ILaunchListener;
import org.eclipse.rcptt.launching.TestCaseDebugger;

import com.google.common.base.Preconditions;

public class Q7LaunchManager {

	public static final String Q7_TEST_SUITE_LAUNCH_ID = "org.eclipse.rcptt.launching.scenarios"; //$NON-NLS-1$

	public static class SessionRunnable implements Runnable, IDebugEventSetListener {
		private final String launchId;
		private final ExecutionSession session;
		private final Q7Process q7Process;

		public SessionRunnable(final String launchId,
				final ExecutionSession session, final Q7Process q7Process) {
			this.launchId = launchId;
			this.session = session;
			this.q7Process = q7Process;
		}

		public void handleDebugEvents(DebugEvent[] events) {
			for (DebugEvent event : events) {
				Object source = event.getSource();
				if (q7Process == source
						&& event.getKind() == DebugEvent.TERMINATE) {
					Q7LaunchManager.getInstance().stop();
				}
			}
		}

		public void run() {
			session.resetCounters();
			session.setStartTime(new Date());
			session.start();
			DebugPlugin.getDefault().addDebugEventListener(this);
			final Executable[] executables = session.getExecutables();

			Q7LaunchManager.getInstance().fireStarted(session);
			try {
				List<Executable> massUpdateOnTerminate = new ArrayList<Executable>();
				final Executable.Listener listener = new Executable.Listener() {
					@Override
					public void onStatusChange(Executable executable) {
						Q7LaunchManager.getInstance().fireLaunchStatusChanged(executable);
						if (executable.getStatus() == State.LAUNCHING)
							session.setActive(executable);
					}

					@Override
					public void updateSessionCounters(Executable executable, IStatus status) {
						Q7LaunchManager.getInstance().updateSessionCounters(session, executable, status);
					}
				};
				for (final Executable executable : executables) {
					if (!session.isRunning()) {
						// break full execution
						massUpdateOnTerminate.add(executable);
						// fireLaunchStatusChanged(executable);
						executable.cancel(new Status(IStatus.CANCEL, PLUGIN_ID, "Execution is stopped"));
						continue;
					}
					executable.addListener(listener);
					try {
						executable.executeAndRememberResult();
					} finally {
						executable.removeListener(listener);
						session.setActive(null);
						Q7LaunchManager.getInstance().fireLaunchStatusChanged(executable);
					}
					Q7LaunchManager.getInstance().fireLaunchStatusChanged(executable);
				}
				if (massUpdateOnTerminate.size() > 0) {
					Q7LaunchManager.getInstance().fireLaunchStatusChanged(massUpdateOnTerminate
							.toArray(new Executable[massUpdateOnTerminate
									.size()]));
				}
			} catch (final InterruptedException e) {
				// ignore interruption
			} catch (final Exception e) {
				Q7LaunchingPlugin.log(e);
			} finally {
				DebugPlugin.getDefault().removeDebugEventListener(this);
				synchronized (Q7LaunchManager.getInstance()) {
					Q7LaunchManager.getInstance().threads.remove(launchId);
				}
				session.stop();
				session.setEndTime(new Date());
				Q7LaunchManager.getInstance().fireFinished(session);
				try {
					session.getLaunch().terminate();
				} catch (DebugException e) {
					Q7LaunchingPlugin.log(e);
				}
			}
		}
	}

	public static boolean isConnectionException(IStatus status) {
		if (status.getMessage().equals("Connection reset")
				|| status.getMessage().equals("Connection refused: connect")) {
			return true;
		}
		return false;
	}

	private static class SingletonHolder {
		private static Q7LaunchManager INSTANCE = null;
	}

	private static boolean headless = false;

	public static void makeHeadless() {
		headless = true;
	}

	public synchronized static Q7LaunchManager getInstance() {
		if (SingletonHolder.INSTANCE == null) {
			SingletonHolder.INSTANCE = new Q7LaunchManager();
		}
		return SingletonHolder.INSTANCE;
	}

	private final Map<String, ExecThread> threads = new HashMap<String, ExecThread>();
	private final List<ILaunchListener> listeners;

	private Q7LaunchManager() {
		final List<ILaunchListener> list = new ArrayList<ILaunchListener>();
		final IConfigurationElement[] elements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(EXPT_ID);
		for (final IConfigurationElement element : elements) {
			String uiAttr = element.getAttribute("ui");
			if (headless) {
				if ("true".equals(uiAttr)) {
					continue;// skip ui listener
				}
			}
			try {
				final ILaunchListener listener = (ILaunchListener) element
						.createExecutableExtension(ATTR_CLASS);
				list.add(listener);
			} catch (final CoreException e) {
				Q7LaunchingPlugin.log(e);
			}
		}
		listeners = list;
	}

	public synchronized boolean isRunning() {
		return !threads.isEmpty();
	}

	public synchronized void stop() {
		for (final String launch : new HashSet<String>(threads.keySet())) {
			ExecThread thread = threads.get(launch);
			if (thread != null) {
				thread.stop();
				threads.remove(launch);
			}
		}
	}

	public synchronized void addListener(final ILaunchListener listener) {
		listeners.add(listener);
	}

	public synchronized void removeListener(final ILaunchListener listener) {
		listeners.add(listener);
	}

	public void execute(IQ7NamedElement[] elements, AutLaunch aut,
			Q7TestLaunch launch, IWorkspaceFinder finder,
			Map<IQ7NamedElement, List<List<String>>> namedVariants)
			throws CoreException {
		// avoid circles
		if (ModelCycleDetector.hasCycles(elements)) {
			throw new CoreException(new Status(IStatus.ERROR,
					Q7LaunchingPlugin.PLUGIN_ID,
					"Can't execute testcases/testsuites. Circles detected."));
		}
		// init finder
		if (finder == null) {
			finder = WorkspaceFinder.getInstance();
		}

		// create process
		Q7Process process = new Q7Process(launch, aut);

		// create executable elements
		ExecutableFabric executableFabric = new ExecutableFabric(aut, finder,
				process.getDebugger());
		Executable[] executables = executableFabric
				.map(elements, namedVariants);
		if (executableFabric.unresolvedItems.size() > 0) {
			if (!checkContinueOnUnresolved())
				return;
		}

		// create session
		final ExecutionSession session = new ExecutionSession(launch
				.getLaunchConfiguration().getName(), executables, aut);
		final int maxEntries = getMaxHistoryEntries();
		while (sessions.size() >= maxEntries) {
			final ExecutionSession rSession = sessions.remove(0);
			rSession.dispose();
		}

		// Cancel debug for this AUT.
		if (!cancelDebugExecution(aut, null)) {
			// If user choose not to cancel
			launch.terminate();
			return;
		}

		launch.setSession(session);

		// start execution
		execute(session, process);
	}

	private boolean checkContinueOnUnresolved() {
		IStatus status = new Status(
				IStatus.ERROR,
				Q7LaunchingPlugin.PLUGIN_ID,
				AutStatusConstants.UNRESOLVED_REFERENCES,
				"There are unresolved test suite items. Build the project to find them.",
				null);
		IStatusHandler prompter = DebugPlugin.getDefault().getStatusHandler(
				status);
		if (prompter != null) {
			try {
				Object result = prompter.handleStatus(status, null);
				if (result instanceof Boolean) {
					return (Boolean) result;
				}
			} catch (CoreException e) {
				Q7LaunchingPlugin.log(e);
			}
		}
		return true;
	}

	public boolean cancelDebugExecution(AutLaunch aut, Object shell)
			throws DebugException {
		// Terminate launched debug sessions for same aut
		List<ExecutionSession> toDispose = new ArrayList<ExecutionSession>();
		for (ExecutionSession rSession : sessions) {
			if (rSession.isDebugging(aut)) {
				toDispose.add(rSession);
			}
		}
		if (toDispose.size() > 0) {
			// Ask user for disposing.
			if (!checkCancelDebugExecutionStatus(shell)) {
				return false;
			}
		}

		sessions.removeAll(toDispose);
		for (ExecutionSession executionSession : toDispose) {
			executionSession.getLaunch().terminate();
			while (executionSession.isRunning()) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					Q7LaunchingPlugin.log(e);
				}
			}
		}
		return true;
	}

	private boolean checkCancelDebugExecutionStatus(Object shell) {
		IStatus status = new Status(IStatus.INFO, Q7LaunchingPlugin.PLUGIN_ID,
				AutStatusConstants.CANCEL_DEBUG_SESSIONS_CODE,
				"Debug session are active.", null);
		IStatusHandler prompter = DebugPlugin.getDefault().getStatusHandler(
				status);
		if (prompter != null) {
			try {
				Object result = prompter.handleStatus(status, shell);
				if (result instanceof Boolean && !((Boolean) result)) {
					return false;
				}
			} catch (CoreException e) {
				Q7LaunchingPlugin.log(e);
			}
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	public int getMaxHistoryEntries() {
		final IEclipsePreferences node = new InstanceScope()
				.getNode(Q7LaunchingPlugin.PLUGIN_ID);
		int count = node.getInt(PREFERENCE_HISTORY_MAX_EXECUTIONS_COUNT, 0);
		if (count == 0) {
			count = HISTORY_MAX_EXECUTIONS_DEFAULT;
		}
		return count;
	}

	@SuppressWarnings("deprecation")
	public void setMaxHistoryEntries(final int maxEntries) {
		final IEclipsePreferences node = new InstanceScope()
				.getNode(Q7LaunchingPlugin.PLUGIN_ID);
		node.put(PREFERENCE_HISTORY_MAX_EXECUTIONS_COUNT, maxEntries + "");
	}

	public IExecutionSession[] getExecutionSessions() {
		return sessions.toArray(new IExecutionSession[sessions.size()]);
	}

	public boolean removeExecutionSession(final IExecutionSession session) {
		final ExecutionSession es = (ExecutionSession) session;
		final boolean result = sessions.remove(es);
		if (result) {
			es.dispose();
		}
		return result;
	}

	public void shutdown() {
		for (ExecutionSession session : sessions) {
			session.dispose();
		}
	}

	private synchronized void execute(final ExecutionSession session,
			Q7Process process) {
		sessions.add(session);
		final String launchId = process.getLaunch().getLaunchConfiguration()
				.getName();

		// if something is already running on that SUT, terminate it
		final ExecThread existing = threads.get(launchId);
		if (existing != null) {
			existing.stop();
		}

		final SessionRunnable sessionRunnable = new SessionRunnable(launchId,
				session, process);

		final ExecThread execThread = new ExecThread(session, sessionRunnable,
				launchId);
		threads.put(launchId, execThread);
		execThread.start();
	}

	public void execute(String launchId, ExecutionSession session, Runnable runnable) {
		sessions.add(session);
		// if something is already running on that SUT, terminate it
		final ExecThread existing = threads.get(launchId);
		if (existing != null) {
			existing.stop();
		}

		final ExecThread execThread = new ExecThread(session, runnable,
				launchId);
		threads.put(launchId, execThread);
		execThread.start();
	}

	public static boolean isTestSuiteLauch(ILaunch launch) {
		if (launch != null && launch.getLaunchConfiguration() != null) {
			try {
				return launch.getLaunchConfiguration().getType()
						.getIdentifier().equals(Q7_TEST_SUITE_LAUNCH_ID);
			} catch (CoreException e) {
				Q7LaunchingPlugin.log(e);
			}
		}
		return false;
	}

	public static class ExecutableFabric {
		private final AutLaunch launch;
		private final IWorkspaceFinder finder;
		private final TestCaseDebugger debugger;
		private final Set<ITestSuite> unresolvedItems = new HashSet<ITestSuite>();

		public ExecutableFabric(AutLaunch launch, IWorkspaceFinder finder,
				TestCaseDebugger debugger) {
			this.launch = launch;
			this.finder = finder;
			this.debugger = debugger;

		}

		private Executable makeContextExecutable(IContext context) throws ModelException {
			boolean debug = debugger != null;
			if (context.getNamedElement() instanceof SuperContext) {
				return new EmptySuperContextExecutable(launch,
						context, debug);
			} else if (context.getNamedElement() instanceof GroupContext) {
				List<Executable> children = new ArrayList<Executable>();
				for (String contextId : ((GroupContext) context.getNamedElement()).getContextReferences()) {
					children.add(makeContextExecutable(RcpttCore.getInstance().findContext(context, false, contextId,
							finder)));
				}
				Executable root = !debug ?
						new EclContextExecutable(launch, context, debug)
						: new EclDebugContextExecutable(launch, context, debugger);
				return new GroupExecutable(root, children);
			} else if (context.getNamedElement() instanceof UnresolvedContext) {
				return new UnresolvedContextExecutable(launch,
						context, debug);
			} else {
				return !debug ?
						new EclContextExecutable(launch, context, debug)
						: new EclDebugContextExecutable(launch, context, debugger);
			}

		}

		private Executable makeVerificationExecutable(IVerification verification,
				ExecutionPhase phase)
				throws ModelException {
			boolean debug = debugger != null;
			if (verification.getNamedElement() instanceof UnresolvedVerification) {
				return new UnresolvedVerificationExecutable(launch, verification, debug, phase);
			} else {
				return !debug ?
						new EclVerificationExecutable(launch, verification, debug, phase)
						: new EclDebugVerificationExecutable(launch, verification, debugger, phase);
			}

		}

		private Executable makeExecutionPlan(Executable parent,
				IContext[] contexts, IVerification[] verifications) {
			List<Executable> plan = new ArrayList<Executable>();
			Preconditions.checkNotNull(parent);
			if (contexts == null)
				contexts = new IContext[0];
			if (verifications == null)
				verifications = new IVerification[0];

			for (IVerification v : verifications)
				try {
					if (v == null)
						throw new NullPointerException();
					if (v.getType() == null)
						throw new NullPointerException();

					if (v.getType().supportsPhase(VerificationType.PHASE_START))
						plan.add(makeVerificationExecutable(v, ExecutionPhase.START));
				} catch (ModelException e) {
					Q7LaunchingPlugin.log(
							"Failed to populate verifications for executable: "
									+ parent.getName(), e);
				}

			for (IContext c : contexts)
				try {
					plan.add(makeContextExecutable(c));
				} catch (ModelException e) {
					Q7LaunchingPlugin.log(
							"Failed to populate contexts for executable: "
									+ parent.getName(), e);
				}

			for (IVerification v : verifications)
				try {
					if (v.getType().supportsPhase(VerificationType.PHASE_RUN))
						plan.add(makeVerificationExecutable(v, ExecutionPhase.RUN));
				} catch (ModelException e) {
					Q7LaunchingPlugin.log(
							"Failed to populate verifications for executable: "
									+ parent.getName(), e);
				}

			plan.add(parent);

			for (IVerification v : verifications)
				try {
					if (v.getType().supportsPhase(VerificationType.PHASE_FINISH))
						plan.add(makeVerificationExecutable(v, ExecutionPhase.FINISH));
				} catch (ModelException e) {
					Q7LaunchingPlugin.log(
							"Failed to populate verifications for executable: "
									+ parent.getName(), e);
				}

			return plan.size() > 1 ? new GroupExecutable(parent, plan) : parent;
		}

		public Executable[] map(final IQ7NamedElement[] elements,
				Map<IQ7NamedElement, List<List<String>>> namedVariants)
				throws CoreException {
			List<Executable> executables = new ArrayList<Executable>();
			boolean debug = debugger != null;
			for (int i = 0; i < elements.length; i++) {
				final IQ7NamedElement element = elements[i];
				if (element instanceof ITestCase) {
					final ITestCase test = (ITestCase) element;

					IContext[] contexts = RcpttCore.getInstance().getContexts(
							test, finder, false);
					IVerification[] verifications = RcpttCore.getInstance().getVerifications(
							test, finder, false);
					assert !Arrays.asList(verifications).contains(null) : "Null verification in "
							+ test.getElementName();

					List<IContext> superContexts = SuperContextSupport
							.findSuperContexts(contexts);
					if (superContexts.size() == 0) {
						final Executable exec = debugger == null ? new EclScenarioExecutable(
								launch, test) : new EclDebugTestExecutable(
								launch, test, debugger);
						executables.add(makeExecutionPlan(exec, contexts, verifications));
					} else {
						// Create One executable per super context
						List<ContextConfiguration> variants = SuperContextSupport
								.findContextVariants(superContexts, contexts);
						List<List<String>> supportedVariants = null;
						if (namedVariants != null) {
							supportedVariants = namedVariants.get(element);
						}
						for (ContextConfiguration contextConfiguration : variants) {
							if (supportedVariants != null
									&& !supportedVariants
											.contains(contextConfiguration
													.getVariantName())) {
								continue; // Skip variant if it is not required.
							}

							final EclScenarioExecutable exec = debugger == null ? new EclScenarioExecutable(
									launch, test) : new EclDebugTestExecutable(
									launch, test, debugger);
							exec.setVariantName(contextConfiguration
									.getVariantName());
							executables.add(makeExecutionPlan(exec,
									contextConfiguration.getContexts(), verifications));
						}
					}
				} else if (element instanceof ITestSuite) {
					ITestSuite suite = (ITestSuite) element;
					ISearchScope scope = Q7SearchCore.getSearchScope(suite);
					ArrayList<IQ7NamedElement> testSuiteItems = new ArrayList<IQ7NamedElement>();
					for (TestSuiteItem item : suite.getItems()) {
						IQ7NamedElement q7Element = Q7SearchCore
								.getTestSuiteItemElement(item, scope);
						if (q7Element == null) {
							unresolvedItems.add(suite);
							continue;
						}
						testSuiteItems.add(q7Element);
					}

					if (!suite.getTestSuite().isManuallyOrdered())
						SortingUtils.sortNamedElements(testSuiteItems);

					Executable[] children = map(
							testSuiteItems.toArray(new IQ7NamedElement[testSuiteItems.size()]), namedVariants);
					executables.add(new TestSuiteExecutable(launch,
							(ITestSuite) element, children, debug));
				} else if (element instanceof IContext) {
					IContext context = (IContext) element;
					executables.add(makeContextExecutable(context));
				} else {
					// Call prepare context for execution logic

					IVerification verification = (IVerification) element;
					executables.add(debugger == null ? new EclVerificationExecutable(
							launch, verification, debug, ExecutionPhase.AUTO)
							: new EclDebugVerificationExecutable(launch, verification,
									debugger, ExecutionPhase.AUTO));
				}

			}
			for (int i = 0; i < executables.size(); i++) {
				if (!(executables.get(i) instanceof TestSuiteExecutable)) {
					executables.set(i, new PrepareExecutionWrapper(launch,
							executables.get(i)));
				}
			}
			return executables.toArray(new Executable[executables.size()]);
		}
	}

	private void updateSessionCounters(final ExecutionSession session,
			final IExecutable executable, IStatus status) {
		if (!status.isOK()) {
			session.oneFailed();
		} else {
			session.oneFinished();
		}
	}

	private final List<ExecutionSession> sessions = new ArrayList<ExecutionSession>();

	private static final String EXPT_ID = Q7LaunchingPlugin.PLUGIN_ID
			+ ".listeners";
	private static final String ATTR_CLASS = "class";

	private static final String PREFERENCE_HISTORY_MAX_EXECUTIONS_COUNT = "history_max_executions_count";
	private static final int HISTORY_MAX_EXECUTIONS_DEFAULT = 30;

	private static class ExecThread {

		// public final String launchId;
		public final ExecutionSession session;
		public final Thread thread;
		public final Job job;
		private boolean complete = false;

		public ExecThread(final ExecutionSession session,
				final Runnable runnable, final String launchId) {
			super();
			this.session = session;
			this.thread = new Thread(new Runnable() {
				public void run() {
					try {
						runnable.run();
					} catch (Exception e) {
						Q7LaunchingPlugin.log(e);
					} finally {
						complete = true;
					}
				}
			}, "RCPTT Execution-" + launchId);
			this.job = new Job("Executing " + launchId) {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					thread.start();
					monitor.beginTask(getName(), -1);
					try {
						while (!complete) {
							if (monitor.isCanceled()) {
								return Status.CANCEL_STATUS;
							}
							Thread.sleep(100);
							monitor.worked(-1);
						}
					} catch (InterruptedException e) {
						return Status.CANCEL_STATUS;
					} finally {
						stop();
					}
					return Status.OK_STATUS;
				}
			};
			// this.launchId = launchId;
		}

		public void start() {
			this.job.schedule();
		}

		public void stop() {
			session.stop();
			// thread.interrupt();
			job.cancel();
		}
	}

	// --

	private boolean debuggingActive = false;

	public synchronized boolean isDebuggingActive() {
		return debuggingActive;
	}

	private void updateDebuggingActive(IExecutionSession exclude) {
		for (IExecutionSession es : sessions) {
			if (es.isTerminated() || es == exclude)
				continue;
			for (IExecutable e : es.getExecutables()) {
				if (e.isDebug()) {
					debuggingActive = true;
					return;
				}
			}
		}

		debuggingActive = false;
	}

	public synchronized boolean isElementUnderDebugging(IQ7Element element) {
		for (ExecutionSession es : sessions) {
			if (es.isTerminated())
				continue;
			for (IExecutable e : es.getExecutables()) {
				if (e.isDebug()
						&& e.getActualElement().getResource()
								.equals(element.getResource())) {
					return true;
				}
			}
		}

		return false;
	}

	// --

	private synchronized void fireStarted(final IExecutionSession session) {
		updateDebuggingActive(null);
		for (final ILaunchListener listener : listeners) {
			listener.started(session);
		}
	}

	private synchronized void fireLaunchStatusChanged(
			final IExecutable... executable) {
		for (final ILaunchListener listener : listeners) {
			listener.launchStatusChanged(executable);
		}
	}

	private synchronized void fireFinished(final IExecutionSession session) {
		updateDebuggingActive(session);
		for (final ILaunchListener listener : listeners) {
			listener.finished();
		}
	}

	public synchronized boolean isDebuggingActive(AutLaunch aut) {
		for (ExecutionSession s : sessions) {
			if (s.isDebugging(aut)) {
				return true;
			}
		}
		return false;
	}
}
