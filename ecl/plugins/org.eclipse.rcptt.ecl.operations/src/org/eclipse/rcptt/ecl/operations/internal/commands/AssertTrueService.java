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
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.operations.AssertTrue;
import org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class AssertTrueService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof AssertTrue)) {
			return Status.CANCEL_STATUS;
		}
		AssertTrue assertTrue = (AssertTrue) command;
		String message = assertTrue.getMessage();
		if (message == null || message.length() == 0) {
			message = "Assertion failed: expected 'true' but was 'false'";
		}
		if (!assertTrue.isInput()) {
			return new Status(IStatus.ERROR, OperationsPlugin.PLUGIN_ID,
					message);
		}
		return Status.OK_STATUS;
	}
}
