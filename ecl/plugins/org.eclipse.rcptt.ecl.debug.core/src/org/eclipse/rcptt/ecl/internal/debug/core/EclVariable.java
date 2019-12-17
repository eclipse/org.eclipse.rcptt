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
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.rcptt.ecl.debug.model.Variable;
import org.eclipse.rcptt.ecl.debug.model.VariableKind;

public class EclVariable extends EclDebugElement implements IVariable {

	private final EclDebugThread thread;
	private final Variable arg;
	private final EclValue value;

	public EclVariable(EclDebugThread thread, Variable arg) {
		this.thread = thread;
		this.arg = arg;

		this.value = new EclValue(thread, arg);
	}

	public IDebugTarget getDebugTarget() {
		return thread.getDebugTarget();
	}

	public void setValue(String expression) throws DebugException {
		// not supported
	}

	public void setValue(IValue value) throws DebugException {
		// not supported
	}

	public boolean supportsValueModification() {
		return false;
	}

	public boolean verifyValue(String expression) throws DebugException {
		return false;
	}

	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}

	public IValue getValue() throws DebugException {
		return value;
	}

	public String getName() throws DebugException {
		return arg.getName();
	}

	public String getReferenceTypeName() throws DebugException {
		return arg.getType();
	}

	public boolean hasValueChanged() throws DebugException {
		return false;
	}
	public VariableKind getVariableKind() {
		return arg.getKind();
	}
}
