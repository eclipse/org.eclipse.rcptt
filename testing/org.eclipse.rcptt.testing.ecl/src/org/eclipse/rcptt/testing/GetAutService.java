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
package org.eclipse.rcptt.testing;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutManager;
import org.eclipse.rcptt.testing.commands.GetAut;

public class GetAutService implements ICommandService {

	
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		String name = ((GetAut) command).getName();
		Aut aut = AutManager.INSTANCE.getByName(name);
		if (aut == null) {
			return TestingPlugin.createErrStatus("There is no AUT: " + name);
		}
		AutLaunch launch = aut.getActiveLaunch();
		if (launch == null) {
			return TestingPlugin.createErrStatus("AUT '" + name
					+ "' is not launched");
		}
		context.getOutput().write(launch.getId());
		return Status.OK_STATUS;
	}

}
