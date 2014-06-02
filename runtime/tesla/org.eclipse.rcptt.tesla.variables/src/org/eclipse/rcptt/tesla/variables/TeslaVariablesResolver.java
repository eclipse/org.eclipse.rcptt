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
package org.eclipse.rcptt.tesla.variables;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.variables.IDynamicVariable;
import org.eclipse.core.variables.IDynamicVariableResolver;

import org.eclipse.rcptt.tesla.core.TeslaVariables;

public class TeslaVariablesResolver implements IDynamicVariableResolver {

	public String resolveValue(IDynamicVariable variable, String argument)
			throws CoreException {
		String value = TeslaVariables.getValueOf(variable.getName());
		if (value == null)
			throw new CoreException(new Status(IStatus.ERROR,
					TeslaVariablesPlugin.PLUGIN_ID, String.format(
							"Unable to resolve \"%s\" variable value.",
							variable.getName())));
		return value;
	}

}
