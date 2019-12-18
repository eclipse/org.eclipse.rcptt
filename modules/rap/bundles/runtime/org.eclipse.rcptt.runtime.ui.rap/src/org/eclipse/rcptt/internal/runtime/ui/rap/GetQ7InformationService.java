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
package org.eclipse.rcptt.internal.runtime.ui.rap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.ecl.core.model.Q7Information;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.core.server.TeslaServerManager;
import org.eclipse.rcptt.tesla.ui.RWTUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class GetQ7InformationService implements ICommandService {

	private static final int TIMEOUT = 1000;

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		IPipe output = context.getOutput();
		final Q7Information info = Q7CoreFactory.eINSTANCE.createQ7Information();
		info.setVersion(Platform.getBundle(RcpttPlugin.PLUGIN_ID).getHeaders().get("Bundle-Version").toString());
		IStatus result = AspectManager.initialize();
		info.setTeslaActive(result.isOK() && TeslaServerManager.getServer() != null);
		if (info.isTeslaActive()) {
			info.setTeslaPort(TeslaServerManager.getServer().getPort());
		}

		final IWorkbench workbench = RWTUtils.getWorkbench();
		if (workbench != null && !workbench.isClosing()) {
			info.setWindowCount(workbench.getWorkbenchWindowCount());
			if (info.getWindowCount() == 0) {
				Display display = RWTUtils.findDisplay();
				if (display != null) {
					display.syncExec(new Runnable() {
						@Override
						public void run() {
							info.setWindowCount(workbench.getWorkbenchWindowCount());
							if (info.getWindowCount() == 0
									&& workbench.getActiveWorkbenchWindow() != null) {
								info.setWindowCount(1);
							}
						}
					});
				}
			}
		}
		else if(RWTUtils.findDisplay() != null)
		{
			info.setWindowCount(1);
		}
		checkActiveClient(info);
		output.write(info);
		return result;
	}

	private void checkActiveClient(final Q7Information info) {
		final Display display = RWTUtils.findDisplay();
		if (display == null) {
			return;
		}
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				info.setClientActive(true);
				synchronized (info) {
					info.notifyAll();
				}
			}
		});
		synchronized (info) {
			try {
				info.wait(TIMEOUT);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
