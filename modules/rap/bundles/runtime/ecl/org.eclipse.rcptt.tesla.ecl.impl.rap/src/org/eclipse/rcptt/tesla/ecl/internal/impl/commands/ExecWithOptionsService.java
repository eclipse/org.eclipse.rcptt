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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public class ExecWithOptionsService implements ICommandService {

	public ExecWithOptionsService() {
	}

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		ExecWithOptions with = (ExecWithOptions) command;

		// SetStatusDialogMode mode = ProtocolFactory.eINSTANCE
		// .createSetStatusDialogMode();
		// mode.setEnabled(with.isAllowStatusDialog());
		// TeslaBridge.getPlayer().safeExecuteCommand(mode);

		TeslaEventManager.getManager().setStatusDialogModeAllowed(
				with.isAllowStatusDialog());
		TeslaEventManager.getManager().setNoWaitForJobs(
				with.isDisableJobWaiting());
		try {
			ISession session = context.getSession();
			IProcess doProcess = session.execute(with.getCommand(),
					context.getInput(), null);
			IStatus result = doProcess.waitFor();
			TeslaBridge.waitExecution();
			return result;
		} finally {
			TeslaEventManager.getManager().setStatusDialogModeAllowed(false);
			TeslaEventManager.getManager().setNoWaitForJobs(false);
		}
	}
}
