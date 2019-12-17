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

package org.eclipse.rcptt.ecl.internal.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Parallel;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ParallelService implements ICommandService {

	public IStatus service(Command command, IProcess process) throws InterruptedException, CoreException {
		List<IProcess> processes = new ArrayList<IProcess>();
		Parallel seq = (Parallel)command;
		for (Command cmd: seq.getCommands()) {
			processes.add(process.getSession().execute(cmd, null, null));
		}		
		for (IProcess p: processes) {
			p.waitFor();
		}
		return Status.OK_STATUS;
	}

}
