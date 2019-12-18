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



import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.runtime.ui.rap.AutEventManager;
import org.eclipse.rcptt.runtime.ui.rap.Q7ServerStarter;
import org.eclipse.rcptt.tesla.ui.RWTUtils;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;

public class Q7RuntimeStartup implements IStartup {
	public void earlyStartup() {
		try {

			if(RWTUtils.getWorkbench()!= null)
			{
			RWTUtils.getWorkbench().addWorkbenchListener(
					new IWorkbenchListener() {
						public boolean preShutdown(IWorkbench workbench,
								boolean forced) {
							Activator.info(new Exception(
									"Just to get a current stack trace logged. This is not an error."),
									"Workbench is about to shut down");
							return true;
						}

						public void postShutdown(IWorkbench workbench) {
						//	ReportManager.storeState();
							tryTerminateLaunches();
						}
					});
			}
		} finally {
			//Q7ServerStarter.INSTANCE.start();
//			// Send a started object
		//	AutEventManager.getInstance().sendStartup();
		}
	}

	private void tryTerminateLaunches() {
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
}
