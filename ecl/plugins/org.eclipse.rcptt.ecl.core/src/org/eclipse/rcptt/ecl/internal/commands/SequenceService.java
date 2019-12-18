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

package org.eclipse.rcptt.ecl.internal.commands;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class SequenceService implements ICommandService {

	public IStatus service(Command command, IProcess process) throws InterruptedException, CoreException {
		IStatus status = Status.OK_STATUS;
		Sequence seq = (Sequence) command;
		List<Object> content = CoreUtils.readPipeContent(process.getInput());
		List<Command> commands = seq.getCommands();
		if (commands.isEmpty()) {
			return status;
		}
		IPipe lastChildOutput = process.getSession().createPipe();
		int commandCount = commands.size();
		for (int i = 0; i < commands.size(); ++i) {
			Command cmd = commands.get(i);
			IPipe pipe = process.getSession().createPipe();
			for (Object o : content)
				pipe.write(o);
			pipe.close(Status.OK_STATUS);
			IProcess child = process.getSession().execute(cmd, pipe, i == commandCount - 1 ? lastChildOutput : null);
			status = child.waitFor();

			if (!status.isOK()) {
				return status;
			}
		}

		for (Object object : CoreUtils.readPipeContent(lastChildOutput)) {
			process.getOutput().write(object);
		}
		return status;
	}
}
