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
package org.eclipse.rcptt.ecl.platform.internal.ui.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.ui.commands.CreateWorkingSet;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;

public class CreateWorkingSetService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof CreateWorkingSet)) {
			return Status.CANCEL_STATUS;
		}
		CreateWorkingSet cws = (CreateWorkingSet) command;
		IWorkingSetManager wsm = PlatformUI.getWorkbench()
				.getWorkingSetManager();
		IWorkingSet ws = wsm.createWorkingSet(cws.getName(), new IAdaptable[0]);

		String type = cws.getType();
		if (SHORT_NAMES.containsKey(type)) {
			type = SHORT_NAMES.get(type);
		}
		ws.setId(type);
		wsm.addWorkingSet(ws);
		return Status.OK_STATUS;
	}

	private static final Map<String, String> SHORT_NAMES = new HashMap<String, String>();
	static {
		SHORT_NAMES.put("java", "org.eclipse.jdt.ui.JavaWorkingSetPage");
	}

}
