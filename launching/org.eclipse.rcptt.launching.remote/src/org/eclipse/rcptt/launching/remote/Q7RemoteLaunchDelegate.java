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
package org.eclipse.rcptt.launching.remote;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate2;
import org.eclipse.rcptt.core.launching.events.AutReconnect;
import org.eclipse.rcptt.core.launching.events.EventsFactory;
import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;
import org.eclipse.rcptt.internal.launching.aut.BaseAutManager;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.rcptt.launching.events.AutEventManager;

/**
 * Version of this plugin is strictly requires eclipse 3.6
 * 
 * @author haiodo
 * 
 */
public class Q7RemoteLaunchDelegate implements ILaunchConfigurationDelegate2 {

	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		int ecl = configuration.getAttribute(IQ7Launch.ATTR_ECL_PORT, -1);
		int tesla = configuration.getAttribute(IQ7Launch.ATTR_TESLA_PORT, -1);
		String host = configuration.getAttribute(IQ7Launch.ATTR_HOST,
				IQ7Launch.DEFAULT_HOST);

		BaseAutLaunch aut = BaseAutManager.INSTANCE.getByLaunch(launch);
		aut.activate(host, ecl, tesla, 2, monitor);

		AutReconnect reconnect = EventsFactory.eINSTANCE.createAutReconnect();
		reconnect.setQ7EclPort(AutEventManager.INSTANCE.getPort());
		reconnect.setId(aut.getId());
		try {
			aut.execute(reconnect);
		} catch (InterruptedException e) {
			Q7RemoteLaunchingPlugin.getDefault().log(e);
		}

		EclActivityMonitor process = new EclActivityMonitor(aut);
		process.startMonitor();
		launch.addProcess(process);
	}

	public ILaunch getLaunch(ILaunchConfiguration configuration, String mode)
			throws CoreException {
		return null;
	}

	public boolean buildForLaunch(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
		return false;
	}

	public boolean finalLaunchCheck(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
		return true;
	}

	public boolean preLaunchCheck(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
		return true;
	}
}
