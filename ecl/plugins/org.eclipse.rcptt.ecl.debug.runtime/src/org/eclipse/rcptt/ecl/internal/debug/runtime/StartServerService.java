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
package org.eclipse.rcptt.ecl.internal.debug.runtime;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.debug.commands.CommandsFactory;
import org.eclipse.rcptt.ecl.debug.commands.ServerInfo;
import org.eclipse.rcptt.ecl.debug.commands.StartServer;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class StartServerService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		try {
			StartServer startCommand = ((StartServer) command);
			DebugServer server = DebugServer.start(startCommand.getId());
			ServerInfo info = CommandsFactory.eINSTANCE.createServerInfo();
			info.setPort(server.getPort());
			context.getOutput().write(info);
		} catch (IOException e) {
			throw new CoreException(Log.status(e));
		}
		return Status.OK_STATUS;
	}

}
