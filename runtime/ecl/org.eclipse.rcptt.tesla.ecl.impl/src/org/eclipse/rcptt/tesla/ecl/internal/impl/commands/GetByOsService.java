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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.tesla.ecl.model.GetByOs;

public class GetByOsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {

		GetByOs GetByOsCmd = (GetByOs) command;
		String response = null;
		if (Platform.getOS().equals(Platform.OS_MACOSX)) {
			response = GetByOsCmd.getMacosx();
		} else if (Platform.getOS().equals(Platform.OS_LINUX)) {
			response = GetByOsCmd.getLinux();
		} else if (Platform.getOS().equals(Platform.OS_WIN32)) {
			response = GetByOsCmd.getWin();
		}
		if (response == null || response.length() == 0) {
			response = GetByOsCmd.getDefault();
		}
		context.getOutput().write(response);

		return Status.OK_STATUS;
	}

}
