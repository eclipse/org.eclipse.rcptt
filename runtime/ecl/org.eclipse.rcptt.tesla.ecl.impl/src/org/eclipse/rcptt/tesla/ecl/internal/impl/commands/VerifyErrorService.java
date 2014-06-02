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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.util.CommandToStringConverter;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.VerifyError;
import org.eclipse.rcptt.tesla.internal.core.queue.TeslaQClient;

public class VerifyErrorService implements ICommandService {

	public IStatus service(Command command, IProcess process)
			throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		VerifyError verify = (VerifyError) command;
		ISession session = process.getSession();
		Command c = verify.getCommand();
		TeslaBridge.beginNoErrorMode();
		try {
			IStatus result = session.execute(c, process.getInput(), null)
					.waitFor();
			final TeslaQClient client = TeslaBridge.getClient();
			if (client != null) {
				client.clearLastFailureInformation();
			}
			TeslaBridge.getLastInfo();
			if (result.isOK()) {
				TeslaBridge.endNoErrorMode();
				if (client != null) {
					PlatformUI.getWorkbench().getDisplay()
							.syncExec(new Runnable() {
								public void run() {
									client.collectLastFailureInformation();
								}
							});
				}
				String msg = "Command "
						+ new CommandToStringConverter().convert(c)
						+ " succeed, but expected error.";
				TeslaBridge.makeScreenshot(true, msg);
				return TeslaImplPlugin.err(msg);
			}
		} finally {
			TeslaBridge.endNoErrorMode();
		}
		return Status.OK_STATUS;
	}
}