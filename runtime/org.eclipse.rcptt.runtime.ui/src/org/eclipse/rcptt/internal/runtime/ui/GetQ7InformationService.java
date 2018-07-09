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
package org.eclipse.rcptt.internal.runtime.ui;

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
import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.core.server.TeslaServerManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class GetQ7InformationService implements ICommandService {

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		IPipe output = context.getOutput();
		final Q7Information info = Q7CoreFactory.eINSTANCE.createQ7Information();
		// eclipse 3.4 compatibility:
		// getVersion().toString() replaced with
		// getHeaders().get("Bundle-Version")
		info.setVersion(Platform.getBundle(RcpttPlugin.PLUGIN_ID).getHeaders().get("Bundle-Version").toString());
		IStatus result = AspectManager.initialize();
		info.setTeslaActive(result.isOK() && TeslaServerManager.getServer() != null);
		if (info.isTeslaActive()) {
			info.setTeslaPort(TeslaServerManager.getServer().getPort());
		}
		info.setWindowCount(PlatformUI.getWorkbench().getWorkbenchWindowCount());
		if (info.getWindowCount() == 0) {
			Display display = PlatformUI.getWorkbench().getDisplay();
			if (display != null) {
				display.syncExec(new Runnable() {
					@Override
					public void run() {
						info.setWindowCount(PlatformUI.getWorkbench().getWorkbenchWindowCount());
						if (info.getWindowCount() == 0
								&& PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
							info.setWindowCount(1);
						}
					}
				});
			}
		}

		output.write(info);
		return result;
	}
}
