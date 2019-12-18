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
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.tesla.ecl.model.ShowAlert;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public class ShowAlertService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		final ShowAlert showAlert = (ShowAlert) command;

		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				TeslaEventManager.getManager().setShowingAlert(true);

				Shell shell = PlatformUI.getWorkbench().getDisplay()
						.getShells()[0];
				MessageBox mb = new MessageBox(shell);
				mb.setMessage(showAlert.getMessage());
				mb.open();

				TeslaEventManager.getManager().setShowingAlert(false);
			}
		});

		return Status.OK_STATUS;
	}

}
