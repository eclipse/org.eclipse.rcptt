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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

import com.google.common.base.Preconditions;

public abstract class Executable implements IExecutable {

	protected static final Executable[] EMPTY = new Executable[0];
	private static final IStatus cancelledForPreviousFailures = new Status(IStatus.CANCEL, PLUGIN_ID,
			"Execution was canceled due to previous failures");

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
	}

	final void executeAndRememberResult(Listener listener) throws InterruptedException {
		if (state != State.WAITING)
			throw new IllegalStateException("Can't start in " + state + " state");
		state = State.LAUNCHING;
		long startTime = System.currentTimeMillis();
		try {
			startLaunching();
			listener.onStatusChange(this);
			result = execute();
			if (result == null)
				throw new NullPointerException("Null result");
			if (overridingResult != null)
				result = overridingResult;
			if (!result.isOK()) {
				return;
			}
			for (final Executable child : getChildren()) {
				if (!result.isOK()) {
					child.cancel(listener, cancelledForPreviousFailures);
					continue;
				}
				child.executeAndRememberResult(listener);
				IStatus rv = handleChildResult(child.getResultStatus());
				if (!rv.isOK()) {
					result = rv;
				}
			}
		} catch (InterruptedException e) {
			state = State.FAILED;
			result = Status.CANCEL_STATUS;
			throw e;
		} catch (Throwable e) {
			state = State.FAILED;
			result = Q7LaunchingPlugin.createStatus(e);
		} finally {
			time = System.currentTimeMillis() - startTime;
			try {
				Preconditions.checkNotNull(result);
				try {
					result = postExecute(listener, result);
				} catch (Throwable e) {
					result = Q7LaunchingPlugin.createStatus(e);
				}
			} finally {
				state = (result != null && result.isOK()) ? State.PASSED : State.FAILED;
				listener.onStatusChange(this);
			}
		}
	}

	public void cancel(Listener listener, IStatus status) {
		switch (state) {
		case LAUNCHING:
			state = State.FAILED;
		case WAITING:
			result = status;
			listener.onStatusChange(this);
		case PASSED:
		case FAILED:
			break;
		}
		for (final Executable child : getChildren()) {
			child.cancel(listener, status);
		}
	}

	/** @return OK status if execution should continue, resulting parent status otherwise */
	protected IStatus handleChildResult(IStatus resultStatus) {
		return resultStatus;
	}

	/** Should only be called from org.eclipse.rcptt.internal.launching.Executable.executeAndRememberResult() */
	protected abstract IStatus execute() throws InterruptedException;

	private IStatus result;
	private State state = State.WAITING;
	private long time;

	private Executable parent;
	private final ExecutionPhase phase;

	protected Executable getParent() {
		return parent;
	}

	protected void setParent(Executable parent) {
		this.parent = parent;
	}

	protected Executable(boolean debug) {
		this(debug, ExecutionPhase.AUTO);
	}

	protected Executable(boolean debug, ExecutionPhase phase) {
		this.debug = debug;
		this.phase = phase;
	}

	public boolean isDebug() {
		return debug;
	}

	public void dispose() {
		Executable[] childs = getChildren();
		if (childs != null) {
			for (Executable child : childs) {
				child.dispose();
			}
		}
	}

	/**
	 * Should only be called from org.eclipse.rcptt.internal.launching.Executable.postExecuteAndRememberResult()
	 * 
	 * @param listener
	 * @param result
	 */
	protected IStatus postExecute(Listener listener, IStatus result) {
		return result;
	}

	public Report getResultReport() {
		return null;
	}

	public String getId() {
		return null;
	}

	private final boolean debug;
	private IStatus overridingResult = null;

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

	public void terminateWithResult(IStatus status) {
		Preconditions.checkState(overridingResult == null);
		for (Executable child : getChildren()) {
			child.terminateWithResult(status);
		}
		overridingResult = status;
	}
}
