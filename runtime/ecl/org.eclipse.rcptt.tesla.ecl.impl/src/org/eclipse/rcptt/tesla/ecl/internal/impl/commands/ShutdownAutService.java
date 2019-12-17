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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ShutdownAutService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		try {
			tryTerminateLaunches();
			// shutdown AUT itself
			Runtime.getRuntime().exit(IStatus.OK);
		} catch (Throwable e) {
			// ignore
		}
		return Status.OK_STATUS;
	}

	public static void tryTerminateLaunches() {
		try {
			// shutdown all launch configurations
			ILaunchManager manager = DebugPlugin.getDefault()
					.getLaunchManager();
			for (ILaunch launch : manager.getLaunches()) {
				launch.terminate();
			}
		} catch (Throwable e) {
			// do nothing
		}
	}
}
