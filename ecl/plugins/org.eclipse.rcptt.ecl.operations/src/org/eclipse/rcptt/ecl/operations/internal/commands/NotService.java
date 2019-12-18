/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
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
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.operations.Not;
import org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class NotService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof Not)) {
			return Status.CANCEL_STATUS;
		}
		Not eq = (Not) command;
		if (eq.getLeft() instanceof BoxedValue) {
			context.getOutput().write(
					!BoxedValues.toBoolean((BoxedValue) eq.getLeft()));
		} else {
			Status st = new Status(IStatus.ERROR, OperationsPlugin.PLUGIN_ID,
					"Incorrect argument type for not: "
							+ eq.getLeft().getClass());
			return st;
		}
		context.getOutput().close(Status.OK_STATUS);
		return Status.OK_STATUS;
	}

}
