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
import org.eclipse.debug.core.ILaunchConfigurationListener;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

/**
 * Tracks changes of launch configurations to make batch configurations be
 * actual.
 */
public class LaunchConfigurationListener implements
		ILaunchConfigurationListener {

	/**
	 * Handles renaming of launch configurations.
	 */
	public void launchConfigurationAdded(ILaunchConfiguration newConfiguration) {

		ILaunchConfiguration oldConfiguration = DebugPlugin.getDefault()
				.getLaunchManager().getMovedFrom(newConfiguration);

		if (oldConfiguration != null) {
			try {
				String oldName = oldConfiguration.getName();
				String newName = newConfiguration.getName();

				ILaunchConfiguration[] q7Configs = LaunchConfigurationUtils
						.getLaunches(Activator.Q7_LAUNCH_CONFIGURATION_ID);

				for (ILaunchConfiguration config : q7Configs) {
					String sourceName = config.getAttribute(
							Activator.TARGET_CONFIGURATION, "");
					if (sourceName.equals(oldName)) {
						ILaunchConfigurationWorkingCopy batchWorkingCopy = config
								.getWorkingCopy();
						batchWorkingCopy.setAttribute(
								Activator.TARGET_CONFIGURATION, newName);
						batchWorkingCopy.doSave();
					}
				}
			} catch (CoreException e) {
				// Ignore
			}
		}
	}

	public void launchConfigurationChanged(ILaunchConfiguration configuration) {
		// Do nothing
	}

	/**
	 * Handles deleting of launch configurations.
	 */
	public void launchConfigurationRemoved(ILaunchConfiguration oldConfiguration) {
		// Do nothing
	}
}
