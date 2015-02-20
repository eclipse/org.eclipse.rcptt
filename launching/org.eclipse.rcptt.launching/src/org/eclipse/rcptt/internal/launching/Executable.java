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
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.internal.launching.aut.ConsoleOutputListener;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

public abstract class Executable implements IExecutable {

	protected static final Executable[] EMPTY = new Executable[0];
	private static final IStatus cancelledForPreviousFailures = new Status(IStatus.CANCEL, PLUGIN_ID,
			"Execution was canceled due to previous failures");
	protected Listener.Composite listeners = new Listener.Composite();
	private final ConsoleOutputListener consoleListener = new ConsoleOutputListener();

	private final boolean debug;
	private final boolean collectLog;
	private IStatus result;
	private State state = State.WAITING;
	private long time;

	private final ExecutionPhase phase;

	public abstract Executable[] getChildren();

	public interface Listener {
		void onStatusChange(Executable executable);

		void updateSessionCounters(Executable executable, IStatus status);

		static class Adapter implements Listener {
			@Override
			public void onStatusChange(Executable executable) {
			}

			@Override
			public void updateSessionCounters(Executable executable, IStatus status) {
			}
		}

		static class Composite implements Listener {
			private List<Listener> listeners = Collections.synchronizedList(new ArrayList<Listener>(2));

			public void add(Listener listener) {
				listeners.add(listener);
			}

			public void remove(Listener listener) {
				listeners.remove(listener);
			}

			private Listener[] copy() {
				synchronized (listeners) {
					return Iterables.toArray(listeners, Listener.class);
				}
			}

			@Override
			public void onStatusChange(Executable executable) {
				for (Listener listener : copy()) {
					listener.onStatusChange(executable);
				}
			}

			@Override
			public void updateSessionCounters(Executable executable, IStatus status) {
				for (Listener listener : copy()) {
					listener.updateSessionCounters(executable, status);
				}
			}
		}
	}

	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	public void removeListener(Listener listener) {
		listeners.remove(listener);
	}

	final void executeAndRememberResult() throws InterruptedException {
		if (state != State.WAITING)
			throw new IllegalStateException("Can't start in " + state + " state");
		if (collectLog)
			consoleListener.startLogging(getAut());
		state = State.LAUNCHING;
		long startTime = System.currentTimeMillis();
		try {
			startLaunching();
			listeners.onStatusChange(this);
			result = execute();
			if (result == null)
				throw new NullPointerException("Null result");
			if (!result.isOK()) {
				return;
			}
			for (final Executable child : getChildren()) {
				if (!result.isOK()) {
					child.cancel(cancelledForPreviousFailures);
					continue;
				}
				child.addListener(listeners);
				try {
					child.executeAndRememberResult();
					IStatus rv = handleChildResult(child.getResultStatus());
					if (!rv.isOK()) {
						result = rv;
					}
				} finally {
					child.removeListener(listeners);
				}
			}
		} catch (InterruptedException e) {
			result = Status.CANCEL_STATUS;
			state = State.FAILED;
			throw e;
		} catch (Throwable e) {
			result = Q7LaunchingPlugin.createStatus(e);
			state = State.FAILED;
		} finally {
			time = System.currentTimeMillis() - startTime;
			try {
				Preconditions.checkNotNull(result);
				try {
					result = postExecute(result);
				} catch (Throwable e) {
					result = Q7LaunchingPlugin.createStatus(e);
				}
			} finally {
				state = (result != null && result.isOK()) ? State.PASSED : State.FAILED;
				listeners.onStatusChange(this);
			}
			consoleListener.stopLogging();
		}
	}

	public void cancel(IStatus status) {
		switch (state) {
		case LAUNCHING:
		case WAITING:
			result = status;
			state = State.FAILED;
			listeners.onStatusChange(this);
		case PASSED:
		case FAILED:
			break;
		}
		for (final Executable child : getChildren()) {
			child.addListener(listeners);
			try {
				child.cancel(status);
			} finally {
				child.removeListener(listeners);
			}
		}
	}

	/** @return OK status if execution should continue, resulting parent status otherwise */
	protected IStatus handleChildResult(IStatus resultStatus) {
		return resultStatus;
	}

	/** Should only be called from org.eclipse.rcptt.internal.launching.Executable.executeAndRememberResult() */
	protected abstract IStatus execute() throws InterruptedException;

	protected Executable(boolean debug) {
		this(debug, ExecutionPhase.AUTO, false);
	}

	protected Executable(boolean debug, ExecutionPhase phase, boolean collectLog) {
		this.debug = debug;
		this.phase = phase;
		this.collectLog = collectLog;
	}

	public boolean isDebug() {
		return debug;
	}

	public void dispose() {
		cancel(new Status(IStatus.ERROR, PLUGIN_ID, "Disposed"));
		Executable[] childs = getChildren();
		if (childs != null) {
			for (Executable child : childs) {
				child.dispose();
			}
		}
	}

	/**
	 * Should only be called from org.eclipse.rcptt.internal.launching.Executable.postExecuteAndRememberResult()
	 * @param result
	 */
	protected IStatus postExecute(IStatus result) {
		return result;
	}

	public Report getResultReport() {
		return null;
	}

	public String getId() {
		return null;
	}


	public ExecutionPhase getPhase() {
		return phase;
	}

	public static State max(State a, State b) {
		return a.ordinal() >= b.ordinal() ? a : b;
	}

	public void startLaunching() {
	}

	@Override
	public final State getStatus() {
		State status = state;
		for (IExecutable child : getChildren()) {
			status = max(status, child.getStatus());
		}
		return status;
	}

	@Override
	public final IStatus getResultStatus() {
		switch (state) {
		case PASSED:
			return Status.OK_STATUS;
		case WAITING:
		case LAUNCHING:
			return result == null ? Status.OK_STATUS : result;
		case FAILED:
			return result;
		}
		throw new IllegalStateException("Unknown state");
	}

	@Override
	public long getTime() {
		return time;
	}

	public String getLog() {
		Preconditions.checkState(collectLog);
		return consoleListener.getLog();
	}
}
