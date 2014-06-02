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
package org.eclipse.rcptt.ecl.internal.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Foreach;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class ForeachService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		Foreach foreach = (Foreach) command;
		IStatus status = Status.OK_STATUS;
		Val val = foreach.getItem();
		boolean valSet = val != null;
		for (EObject o : foreach.getInput()) {
			ISession session = context.getSession();
			IPipe in = null;
			if (valSet) {
				val.setValue(o);
				LetService.getLocals(context).declare(val.getName(), val, true);
			} else {
				in = session.createPipe();
				in.write(o);
				in.close(Status.OK_STATUS);
			}
			IPipe out = session.createPipe();
			Command doCommand = foreach.getDo();

			status = session.execute(doCommand, in, out).waitFor();
			if (status.getSeverity() != IStatus.OK) {
				break;
			}
			for (Object outObj : CoreUtils.readPipeContent(out)) {
				context.getOutput().write(outObj);
			}
		}
		return status;
	}
}
