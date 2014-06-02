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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.operations.AssertEmpty;
import org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class AssertEmptyService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		AssertEmpty assertEmpty = (AssertEmpty) command;

		Object contents = context.getInput()
				.take(ISession.DEFAULT_TAKE_TIMEOUT);
		if (contents != null && !(contents instanceof IStatus)) {
			return new Status(IStatus.ERROR, OperationsPlugin.PLUGIN_ID,
					getMessage(assertEmpty));
		}
		return Status.OK_STATUS;
	}

	private String getMessage(AssertEmpty assertEmpty) {
		String message = assertEmpty.getMessage();
		return message == null || message.length() == 0 ? "Assertion failed: expected empty pipe"
				: message;
	}

}
