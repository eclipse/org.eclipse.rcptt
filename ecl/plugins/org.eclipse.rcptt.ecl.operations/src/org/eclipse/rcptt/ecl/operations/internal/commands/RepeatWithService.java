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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.ecl.operations.RepeatWith;
import org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin;
import org.eclipse.rcptt.ecl.parser.EclCoreParser;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class RepeatWithService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof RepeatWith)) {
			return Status.CANCEL_STATUS;
		}

		RepeatWith repeatWith = (RepeatWith) command;
		Command todo = repeatWith.getCommand();
		ISession session = context.getSession();
		for (Object cmd : repeatWith.getCommands()) {
			Command prefix = getCommand(cmd);
			IPipe pipe = session.createPipe();
			IStatus status = session.execute(prefix, null, pipe).waitFor();
			if (!status.isOK()) {
				return status;
			}
			IPipe output = session.createPipe();
			status = session.execute(todo, pipe, output).waitFor();
			if (!status.isOK()) {
				return status;
			}
			for (Object obj : CoreUtils.readPipeContent(output)) {
				context.getOutput().write(obj);
			}
		}
		return Status.OK_STATUS;
	}

	private static Command getCommand(Object cmd) throws CoreException {
		if (cmd instanceof Command) {
			return (Command) cmd;
		}
		if (cmd instanceof EclString) {
			return EclCoreParser.newCommand(((EclString) cmd).getValue());
		}

		throw new CoreException(new Status(IStatus.ERROR,
				OperationsPlugin.PLUGIN_ID, String.format(
						"Cannot convert value of type %s to command", cmd
								.getClass().getName())));
	}
}
