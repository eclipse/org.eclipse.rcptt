/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
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
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.client.service.JavaScriptExecutor;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.ui.RWTUtils;
import org.eclipse.swt.widgets.Display;

public class ShutdownAutService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		try {
			tryTerminateLaunches();
			closeClient();
			// shutdown AUT itself
		} catch (Throwable e) {
			// ignore
		}
		return Status.OK_STATUS;
	}

	public static void tryTerminateLaunches() {
		try {
			// shutdown all launch configurations
//			ILaunchManager manager = DebugPlugin.getDefault()
//					.getLaunchManager();
//			for (ILaunch launch : manager.getLaunches()) {
//				launch.terminate();
//			}
		} catch (Throwable e) {
			// do nothing
		}
	}

	private void closeClient() {
		Display display = RWTUtils.findDisplay();
		if (display != null) {
			display.asyncExec(new Runnable() {
				@Override
				public void run() {
					JavaScriptExecutor executor = RWT.getClient().getService( JavaScriptExecutor.class );
					executor.execute("window.open('', '_self', ''); window.close()");
				}
			});
		}

	}

}
