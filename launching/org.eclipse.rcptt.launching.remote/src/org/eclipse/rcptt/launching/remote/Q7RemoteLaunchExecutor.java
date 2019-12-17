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
package org.eclipse.rcptt.launching.remote;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;
import org.eclipse.rcptt.launching.AutLaunchState;
import org.eclipse.rcptt.launching.ILaunchExecutor;

public class Q7RemoteLaunchExecutor implements ILaunchExecutor {

	public ILaunch launch(String mode, ILaunchConfiguration config,
			IProgressMonitor monitor) throws CoreException {
		return config.launch(mode, monitor);
	}

	public void waitForRestart(BaseAutLaunch launch, IProgressMonitor monitor)
			throws CoreException {
		// remote connection just monitor connection state
		BaseAutLaunch l = (BaseAutLaunch) launch;
		// mark as restart
		l.setState(AutLaunchState.RESTART);

		EclActivityMonitor process = (EclActivityMonitor) launch.getLaunch()
				.getProcesses()[0];
		try {
			process.waitForRestart(monitor);
			l.setState(AutLaunchState.ACTIVE);
		} catch (CoreException e) {
			l.terminated(e.getStatus());
			throw e;
		}
	}
}
