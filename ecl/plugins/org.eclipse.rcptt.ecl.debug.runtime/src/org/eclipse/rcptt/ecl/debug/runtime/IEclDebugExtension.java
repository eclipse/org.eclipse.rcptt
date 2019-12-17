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
package org.eclipse.rcptt.ecl.debug.runtime;

import org.eclipse.rcptt.ecl.core.CommandStack;
import org.eclipse.rcptt.ecl.debug.model.StackFrame;
import org.eclipse.rcptt.ecl.debug.model.Variable;
import org.eclipse.rcptt.ecl.internal.debug.runtime.EclStackSupport;

/**
 * Using this interface it is possible to extend ECL debugger variables
 * providing.
 * 
 * @author haiodo
 * 
 */
public interface IEclDebugExtension {

	/**
	 * Update current stack frame with variables etc.
	 * 
	 * @param stack
	 * @param frame
	 */
	void updateFrame(CommandStack stack, StackFrame frame);

	/**
	 * Flag to delegate variable value computation to extension.
	 */
	boolean supportVariableValue(Object value);

	/**
	 * Fill variable value based on object value.
	 */
	void processVariable(Variable var, Object value, boolean prepare);

	/**
	 * Return true if variable are complex one.
	 */
	boolean isComplexVariableValue(Object value);

	/**
	 * Return true if child is filtered.
	 */
	boolean isVariableChildFiltered(Object childValue);

	void prepareFrame(CommandStack stack, StackFrame frame, EclStackSupport eclStackSupport);

}
