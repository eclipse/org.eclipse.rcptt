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
package org.eclipse.rcptt.ecl.internal.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

public class EclDebugThread extends EclDebugElement implements IThread {

	private EclDebugTarget target;
	private IBreakpoint[] breakpoints;

	public EclDebugThread(EclDebugTarget target) {
		this.target = target;
	}

	public IDebugTarget getDebugTarget() {
		return target;
	}

	public boolean canResume() {
		return !isTerminated() && isSuspended();
	}

	public boolean canSuspend() {
		return !isTerminated() && !isSuspended();
	}

	public boolean isSuspended() {
		return getDebugTarget().isSuspended();
	}

	public void resume() throws DebugException {
		getDebugTarget().resume();
	}

	public void suspend() throws DebugException {
		getDebugTarget().suspend();
	}

	public boolean canStepInto() {
		return !isTerminated() && isSuspended();
	}

	public boolean canStepOver() {
		return !isTerminated() && isSuspended();
	}

	public boolean canStepReturn() {
		return !isTerminated() && isSuspended();
	}

	public boolean isStepping() {
		return target.isStepping();
	}

	public void stepInto() throws DebugException {
		target.step();
	}

	public void stepOver() throws DebugException {
		target.stepOver();
	}

	public void stepReturn() throws DebugException {
		target.stepReturn();
	}

	public boolean canTerminate() {
		return !isTerminated();
	}

	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	public void terminate() throws DebugException {
		getDebugTarget().terminate();
	}

	public IStackFrame[] getStackFrames() throws DebugException {
		return target.getFrames();
	}

	public boolean hasStackFrames() throws DebugException {
		return getStackFrames().length > 0;
	}

	public int getPriority() throws DebugException {
		return 0;
	}

	public IStackFrame getTopStackFrame() throws DebugException {
		IStackFrame[] frames = getStackFrames();
		if (frames.length > 0) {
			return frames[0];
		}
		return null;
	}

	public String getName() throws DebugException {
		return "ECL Thread";
	}

	public IBreakpoint[] getBreakpoints() {
		if (breakpoints == null) {
			return new IBreakpoint[0];
		}
		return breakpoints;
	}

	public void setBreakpoints(IBreakpoint[] breakpoints) {
		this.breakpoints = breakpoints;
	}

}
