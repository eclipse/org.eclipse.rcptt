/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
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
import org.eclipse.rcptt.ecl.platform.ui.commands.GetWorkingSet;
import org.eclipse.rcptt.ecl.platform.ui.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.platform.ui.objects.WorkingSet;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;

public class GetWorkingSetService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof GetWorkingSet)) {
			return Status.CANCEL_STATUS;
		}

		IWorkingSet ws = PlatformUI.getWorkbench().getWorkingSetManager()
				.getWorkingSet(((GetWorkingSet) command).getName());
		if(ws == null) {
			return Status.OK_STATUS;
		}
		WorkingSet result = ObjectsFactory.eINSTANCE.createWorkingSet();
		result.setName(ws.getName());
		result.setType(ws.getId());
		context.getOutput().write(result);
		context.getOutput().close(Status.OK_STATUS);
		return Status.OK_STATUS;
	}

}
