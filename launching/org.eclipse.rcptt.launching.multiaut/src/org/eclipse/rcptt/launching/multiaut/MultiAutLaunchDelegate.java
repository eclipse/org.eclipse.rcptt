package org.eclipse.rcptt.launching.multiaut;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Script;
import org.eclipse.rcptt.internal.launching.Executable;
import org.eclipse.rcptt.internal.launching.ExecutionSession;
import org.eclipse.rcptt.internal.launching.PrepareExecutionWrapper;
import org.eclipse.rcptt.internal.launching.Q7LaunchManager;
import org.eclipse.rcptt.internal.launching.Q7LaunchManager.ExecutableFabric;
import org.eclipse.rcptt.internal.launching.Q7LaunchManager.SessionRunnable;
import org.eclipse.rcptt.internal.launching.Q7Process;
import org.eclipse.rcptt.internal.launching.Q7TestLaunch;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutLaunchListener;
import org.eclipse.rcptt.launching.AutLaunchState;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.rcptt.launching.Q7Launcher;
import org.eclipse.rcptt.launching.TestCaseDebugger;

public class MultiAutLaunchDelegate extends LaunchConfigurationDelegate implements IQ7Launch {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		List<ResolvedEntry> entries = resolveEntries(configuration);
		if (entries.isEmpty()) {
			throw new CoreException(MultiAutLaunchPlugin.errStatus("Nothing to launch"));
		}

		List<IQ7NamedElement> elements = new ArrayList<IQ7NamedElement>();
		Map<Aut, AutLaunch> autLaunches = new HashMap<Aut, AutLaunch>();
		Map<Aut, Q7Process> processes = new HashMap<Aut, Q7Process>();
		List<Executable> executables = new ArrayList<Executable>();
		Q7TestLaunch q7launch = (Q7TestLaunch) launch;
		for (ResolvedEntry entry : entries) {
			AutLaunch autLaunch = getLaunch(entry.aut, monitor);
			elements.add(entry.element);
			autLaunches.put(entry.aut, autLaunch);
			Q7Process q7process = new Q7Process(launch, autLaunch);
			processes.put(entry.aut, q7process);

			ExecutableFabric f = new ExecutableFabric(autLaunch, null, q7process.getDebugger());
			Executable[] testExecs = f.map(new IQ7NamedElement[] { entry.element }, null);
			for (int i = 0; i < testExecs.length; i++) {
				Executable e = testExecs[i];
				if (e instanceof PrepareExecutionWrapper) {
					testExecs[i] = new MultiAutPrepareExecutionWrapper((PrepareExecutionWrapper) e, entry.restart);
				}
			}
			executables.addAll(Arrays.asList(testExecs));
		}

		IQ7NamedElement[] elementArray = elements.toArray(new IQ7NamedElement[elements.size()]);
		Q7Launcher.setMappedResources(configuration, elementArray);

		// create session
		final ExecutionSession session = new MultiAutExecutionSession(launch
				.getLaunchConfiguration().getName(),
				executables.toArray(new Executable[executables.size()]), autLaunches.values());

		final int maxEntries = Q7LaunchManager.getInstance().getMaxHistoryEntries();
		final IExecutionSession[] prevSessions = Q7LaunchManager.getInstance().getExecutionSessions();
		for (int i = 0; i <= prevSessions.length - maxEntries; i++) {
			Q7LaunchManager.getInstance().removeExecutionSession(prevSessions[i]);
		}

		for (AutLaunch autLaunch : autLaunches.values()) {
			if (!Q7LaunchManager.getInstance().cancelDebugExecution(autLaunch, null)) {
				// If user choose not to cancel
				launch.terminate();
				return;
			}
		}
		// Cancel debug for this AUT.

		q7launch.setSession(session);
		String launchId = launch.getLaunchConfiguration().getName();
		// start execution
		Q7LaunchManager.getInstance().execute(launchId, session,
				new MultiAutSessionRunnable(launchId, session, processes.values()));
	}

	private AutLaunch getLaunch(Aut aut, IProgressMonitor m) throws CoreException {
		AutLaunch result = aut.getActiveLaunch();
		if (result == null) {
			result = aut.launch(m);
		}
		return new ProxyLaunch(result);
	}

	private List<ResolvedEntry> resolveEntries(ILaunchConfiguration configuration) {
		List<ResolvedEntry> entries = new ArrayList<ResolvedEntry>();

		for (LaunchStoreEntry entry : LaunchStoreEntry.entriesFromConfig(configuration)) {
			ResolvedEntry resolved = ResolvedEntry.resolve(entry);
			if (!resolved.isOK()) {
				MultiAutLaunchPlugin.logErr("Ignored invalid test entry stored in launch config '%s'",
						configuration.getName());
				continue;
			}

			entries.add(resolved);
		}
		return entries;
	}

	@Override
	public ILaunch getLaunch(ILaunchConfiguration configuration, String mode) throws CoreException {
		return new Q7TestLaunch(configuration, mode);
	}

	private static class MultiAutSessionRunnable extends SessionRunnable {
		private Set<Q7Process> processes;

		public MultiAutSessionRunnable(String launchId, ExecutionSession session, Collection<Q7Process> processes) {
			super(launchId, session, null);
			this.processes = new HashSet<Q7Process>(processes);
		}

		@Override
		public void handleDebugEvents(DebugEvent[] events) {
			for (DebugEvent event : events) {
				if (event.getKind() == DebugEvent.TERMINATE && processes.contains(event.getSource())) {
					Q7LaunchManager.getInstance().stop();
				}
			}
		}

	}

	private static class MultiAutExecutionSession extends ExecutionSession {
		private Set<AutLaunch> auts;

		public MultiAutExecutionSession(String name, Executable[] executables, Collection<AutLaunch> auts) {
			super(name, executables, null);
			this.auts = new HashSet<AutLaunch>(auts);
		}

		@Override
		public void dispose() {
			super.dispose();
			auts.clear();
		}

		@Override
		public boolean isDebugging(AutLaunch aut) {
			return isRunning() && auts.contains(aut);
		}
	}

	private static class MultiAutPrepareExecutionWrapper extends PrepareExecutionWrapper {
		private boolean restartAut;
		private ProxyLaunch launch;

		public MultiAutPrepareExecutionWrapper(PrepareExecutionWrapper source, boolean restartAut) {
			super(source.getAut(), source.getExecutable());
			this.restartAut = restartAut;
			this.launch = (ProxyLaunch) getAut();
		}

		@Override
		public IStatus execute() throws InterruptedException {
			if (restartAut) {
				try {
					launch.restart();
				} catch (CoreException e) {
					MultiAutLaunchPlugin.getDefault().getLog().log(e.getStatus());
					throw new InterruptedException("Couldn't restart AUT");
				}
			}
			return super.execute();
		}
	}

	private static class ProxyLaunch implements AutLaunch {
		public void restart() throws CoreException {
			launch.terminate();
			launch = launch.getAut().launch(new NullProgressMonitor());
		}

		public ProxyLaunch(AutLaunch launch) {
			this.launch = launch;
		}

		private AutLaunch launch;

		public String getId() {
			return launch.getId();
		}

		public Aut getAut() {
			return launch.getAut();
		}

		public AutLaunchState getState() {
			return launch.getState();
		}

		public ILaunch getLaunch() {
			return launch.getLaunch();
		}

		public void addListener(AutLaunchListener listener) {
			launch.addListener(listener);
		}

		public void removeListener(AutLaunchListener listener) {
			launch.removeListener(listener);
		}

		public Object execute(Command command) throws CoreException, InterruptedException {
			return launch.execute(command);
		}

		public Object execute(Command command, long timeout) throws CoreException, InterruptedException {
			return launch.execute(command, timeout);
		}

		public Object execute(Command command, long timeout, IProgressMonitor monitor) throws CoreException,
				InterruptedException {
			return launch.execute(command, timeout, monitor);
		}

		public void run(IQ7NamedElement test, long timeout, IProgressMonitor monitor, ExecutionPhase phase)
				throws CoreException {
			launch.run(test, timeout, monitor, phase);
		}

		public void debug(IQ7NamedElement test, long timeout, IProgressMonitor monitor, TestCaseDebugger debugger,
				ExecutionPhase phase) throws CoreException {
			launch.debug(test, timeout, monitor, debugger, phase);
		}

		public void execute(Script script, long timeout, IProgressMonitor monitor) throws CoreException {
			launch.execute(script, timeout, monitor);
		}

		public void ping() throws CoreException {
			launch.ping();
		}

		public void waitForRestart(IProgressMonitor monitor) throws CoreException {
			launch.waitForRestart(monitor);
		}

		public void shutdown() {
			launch.shutdown();
		}

		public void terminate() {
			launch.terminate();
		}

		public void cancelTestExecution() {
			launch.cancelTestExecution();
		}

		public void resetState() {
			launch.resetState();
		}

		@Override
		public void handleAutEvent(org.eclipse.rcptt.core.launching.events.AutEvent autEvent) {
			launch.handleAutEvent(autEvent);
		}
		
		
	}
}
