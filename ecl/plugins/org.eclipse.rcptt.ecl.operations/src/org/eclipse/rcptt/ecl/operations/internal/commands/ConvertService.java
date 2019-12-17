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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.operations.Convert;
import org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public abstract class ConvertService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof Convert)) {
			return Status.CANCEL_STATUS;
		}
		EObject input = ((Convert) command).getInput();
		if (!(input instanceof BoxedValue)) {
			return new Status(IStatus.ERROR, OperationsPlugin.PLUGIN_ID,
					String.format("Cannot convert value of type '%s'", input
							.eClass().getInstanceTypeName()));
		}
		context.getOutput().write(doConvert((BoxedValue) input));
		return Status.OK_STATUS;
	}

	abstract Object doConvert(BoxedValue input) throws CoreException;

}
