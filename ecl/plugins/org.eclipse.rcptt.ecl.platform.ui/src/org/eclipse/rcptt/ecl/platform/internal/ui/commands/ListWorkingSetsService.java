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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.ui.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.platform.ui.objects.WorkingSet;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;

public class ListWorkingSetsService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		for(IWorkingSet ws : PlatformUI.getWorkbench().getWorkingSetManager().getAllWorkingSets()) {
			if(ws.isAggregateWorkingSet()) {
				continue;
			}
			WorkingSet obj = ObjectsFactory.eINSTANCE.createWorkingSet();
			obj.setName(ws.getName());
			obj.setType(ws.getId());
			context.getOutput().write(obj);
		}
		return Status.OK_STATUS;
	}

}
