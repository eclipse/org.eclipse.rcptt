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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class PipelineService implements ICommandService {

	public IStatus service(Command command, IProcess process)
			throws InterruptedException, CoreException {
		Pipeline seq = (Pipeline) command;
		IPipe in = process.getInput();
		IPipe out = null;
		IProcess child = null;
		IStatus status = null;
		int size = seq.getCommands().size();
		for (int i = 0; i < size; i++) {
			if (i == size - 1)
				out = process.getOutput();
			else
				out = process.getSession().createPipe();
			child = process.getSession().execute(seq.getCommands().get(i), in,
					out);
			status = child.waitFor();
			if (!status.isOK())
				return status;
			in = out;
		}
		return status;
	}

}
