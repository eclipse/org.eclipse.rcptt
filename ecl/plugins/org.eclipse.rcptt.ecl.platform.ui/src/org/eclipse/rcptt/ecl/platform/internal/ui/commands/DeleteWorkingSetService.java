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
package org.eclipse.rcptt.ecl.platform.internal.ui.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.ui.commands.DeleteWorkingSet;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;

public class DeleteWorkingSetService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if(!(command instanceof DeleteWorkingSet)) {
			return Status.CANCEL_STATUS;
		}
		DeleteWorkingSet dws = (DeleteWorkingSet) command;
		IWorkingSetManager m = PlatformUI.getWorkbench().getWorkingSetManager();
		m.removeWorkingSet(m.getWorkingSet(dws.getInput().getName()));
		return Status.OK_STATUS;
	}

}
