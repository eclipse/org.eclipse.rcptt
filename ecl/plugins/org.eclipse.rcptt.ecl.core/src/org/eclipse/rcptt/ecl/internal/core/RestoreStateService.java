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
package org.eclipse.rcptt.ecl.internal.core;

import static org.eclipse.rcptt.ecl.internal.core.ProcService.getProcs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Declaration;
import org.eclipse.rcptt.ecl.core.Proc;
import org.eclipse.rcptt.ecl.core.RestoreState;
import org.eclipse.rcptt.ecl.core.SessionState;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class RestoreStateService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof RestoreState)) {
			return Status.CANCEL_STATUS;
		}

		SessionState state = ((RestoreState) command).getState();

		LocalProcManager procs = getProcs(context);
		DeclarationContainer globals = GlobalService.getGlobals(context);

		for (Proc proc : state.getProcs()) {
			procs.declare(proc);
		}
		for (Declaration decl : state.getDecls()) {
			if (!(decl instanceof Val)) {
				continue; // TODO pipes support
			}
			globals.declare(((Val) decl).getName(), decl);
		}
		return Status.OK_STATUS;
	}

}
