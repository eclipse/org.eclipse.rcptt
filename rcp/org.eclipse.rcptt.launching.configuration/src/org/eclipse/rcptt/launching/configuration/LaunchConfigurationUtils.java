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
package org.eclipse.rcptt.launching.configuration;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;

public class LaunchConfigurationUtils {

	public static ILaunchConfiguration findLaunchConfiguration(String name,
			String typeId) {
		if (name != null) {
			ILaunchConfiguration[] configs = getLaunches(typeId);
			for (ILaunchConfiguration config : configs) {
				if (name.equals(config.getName())) {
					return config;
				}
			}
		}
		return null;
	}

	public static ILaunchConfiguration[] getLaunches(String typeId) {
		ILaunchManager launchManager = DebugPlugin.getDefault()
				.getLaunchManager();
		ILaunchConfiguration[] launches = new ILaunchConfiguration[0];
		try {
			if (typeId.length() > 0) {
				launches = launchManager.getLaunchConfigurations(launchManager
						.getLaunchConfigurationType(typeId));
			} else {
				launches = launchManager.getLaunchConfigurations();
			}
		} catch (CoreException e) {
			Activator.log(e);
		}
		return launches;
	}
}
