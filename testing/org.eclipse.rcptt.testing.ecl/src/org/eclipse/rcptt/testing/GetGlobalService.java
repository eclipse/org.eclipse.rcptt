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
package org.eclipse.rcptt.testing;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.testing.commands.GetGlobal;

public class GetGlobalService implements ICommandService {
	
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof GetGlobal)) {
			return Status.CANCEL_STATUS;
		}

		String name = ((GetGlobal) command).getName();
		List<Object> objects = TestingPlugin.getDefault().getGlobals()
				.get(name);
		if (objects == null) {
			return TestingPlugin.createErrStatus(String.format(
					"Key %s is not mapped", name));
		}

		for (Object object : objects) {
			context.getOutput().write(object);
		}
		return Status.OK_STATUS;
	}
}
