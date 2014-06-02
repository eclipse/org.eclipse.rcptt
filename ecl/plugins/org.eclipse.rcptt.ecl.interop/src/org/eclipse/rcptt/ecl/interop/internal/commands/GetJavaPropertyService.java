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
package org.eclipse.rcptt.ecl.interop.internal.commands;

import static org.eclipse.rcptt.ecl.interop.internal.EclInteropPlugin.error;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.interop.GetJavaProperty;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetJavaPropertyService implements ICommandService {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		GetJavaProperty cmd = (GetJavaProperty) command;
		
		String key = cmd.getKey();
		String value = System.getProperty(key);
		
		if (value == null)
			value = cmd.getDefault();

		if (value == null)
			return error("There is no Java property with key \"%s\" and default value is not specified.", key);

		context.getOutput().write(value);
		return Status.OK_STATUS;
	}

}
