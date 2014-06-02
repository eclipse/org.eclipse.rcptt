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

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.tesla.ecl.model.TakeScreenshot;
import org.eclipse.rcptt.tesla.internal.ui.player.ReportScreenshotProvider;

public class TakeScreenshotService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		TakeScreenshot cmd = (TakeScreenshot) command;

		List<Snaphot> snaphot = ReportScreenshotProvider.takeScreenshot(
				PlatformUI.getWorkbench().getDisplay(), true,
				"user take snapshot:" + System.currentTimeMillis());
		if (snaphot != null) {
			for (Snaphot shot : snaphot) {
				org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot sc = (org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot) shot
						.getData();
				sc.setMessage(cmd.getMessage());
			}
		}

		return Status.OK_STATUS;
	}

}
