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
package org.eclipse.rcptt.ecl.ast.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.gen.ast.AstExec;
import org.eclipse.rcptt.ecl.internal.commands.ExecService;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.internal.core.ProcErrorStatus;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

@SuppressWarnings("restriction")
public class AstExecService implements ICommandService {
	public IStatus service(Command command, IProcess process)
			throws InterruptedException, CoreException {
		AstExec exec = (AstExec) command;
		IStatus s = new ExecService().service(exec, process);

		if (!s.isOK() && !(s instanceof ScriptErrorStatus)) {
			IStatus cause = s instanceof ProcErrorStatus ? ((ProcErrorStatus) s).getStatus() : s;

			ScriptErrorStatus rv = new ScriptErrorStatus(CorePlugin.PLUGIN_ID, exec.getName(), exec.getResourceID(),
					exec.getLine(), exec.getColumn(), exec.getLength());
			rv.add(cause);
			return rv;
		}

		return s;
	}
}
