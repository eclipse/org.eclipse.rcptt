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

import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.debug.model.StackFrame;
import org.eclipse.rcptt.ecl.debug.model.Variable;

public class EclStackFrame extends EclDebugElement implements IStackFrame {

	private final EclDebugThread thread;
	private final StackFrame frame;
	private final IVariable[] variables;

	public EclStackFrame(EclDebugThread thread, StackFrame frame) {
		this.thread = thread;
		this.frame = frame;

		EList<Variable> vars = frame.getVariables();
		variables = new IVariable[vars.size()];
		for (int i = 0; i < variables.length; ++i) {
			variables[i] = new EclVariable(thread, vars.get(i));
		}
	}

	public StackFrame getFrame() {
		return frame;
	}

	public IDebugTarget getDebugTarget() {
		return thread.getDebugTarget();
	}

	public boolean canStepInto() {
		return thread.canStepInto();
	}

	public boolean canStepOver() {
		return thread.canStepOver();
	}

	public boolean canStepReturn() {
		return thread.canStepReturn();
	}

	public boolean isStepping() {
		return thread.isStepping();
	}

	public void stepInto() throws DebugException {
		thread.stepInto();
	}

	public void stepOver() throws DebugException {
		thread.stepOver();
	}

	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}

	public boolean canResume() {
		return thread.canResume();
	}

	public boolean canSuspend() {
		return thread.canSuspend();
	}

	public boolean isSuspended() {
		return thread.isSuspended();
	}

	public void resume() throws DebugException {
		thread.resume();
	}

	public void suspend() throws DebugException {
		thread.suspend();
	}

	public boolean canTerminate() {
		return thread.canTerminate();
	}

	public boolean isTerminated() {
		return thread.isTerminated();
	}

	public void terminate() throws DebugException {
		thread.terminate();
	}

	public IThread getThread() {
		return thread;
	}

	public IVariable[] getVariables() throws DebugException {
		return variables;
	}

	public boolean hasVariables() throws DebugException {
		return true;
	}

	public int getLineNumber() throws DebugException {
		return frame.getLine();
	}

	public int getCharStart() throws DebugException {
		return frame.getColumn();
	}

	public int getCharEnd() throws DebugException {
		return frame.getLength();
	}

	public String getName() throws DebugException {
		return  frame.getCommand() + " ("+new Path(frame.getFile()).removeFileExtension().lastSegment() + ": " + frame.getLine() + ")";
	}

	public String getFile() {
		return frame.getFile();
	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return new IRegisterGroup[0];
	}

	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frame == null) ? 0 : frame.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EclStackFrame other = (EclStackFrame) obj;
		if (frame == null) {
			if (other.frame != null)
				return false;
		} else if (!frame.equals(other.frame))
			return false;
		return true;
	}

}
