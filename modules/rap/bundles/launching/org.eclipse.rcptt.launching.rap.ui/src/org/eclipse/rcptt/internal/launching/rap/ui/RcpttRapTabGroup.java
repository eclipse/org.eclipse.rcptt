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
package org.eclipse.rcptt.internal.launching.rap.ui;

import static org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.pde.ui.launcher.OSGiLauncherTabGroup;
import org.eclipse.rcptt.internal.launching.ext.UpdateVMArgs;

public class RcpttRapTabGroup extends OSGiLauncherTabGroup {

	private static final String NEW_LINE = "\n"; //$NON-NLS-1$
	private static final String JETTY_LOG_LEVEL = "-Dorg.eclipse.equinox.http.jetty.log.stderr.threshold=info"; //$NON-NLS-1$

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		super.createTabs(dialog, mode);

		ILaunchConfigurationTab[] tabs = insertTab(getTabs(), 0, new RapAUTMainTab(this));
		tabs = removeTab(tabs, 1); // remove bundles tab
		setTabs(tabs);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
		UpdateVMArgs.updateVMArgs(configuration);
		updateRapVmArgument(configuration);
		 configuration.setAttribute(IDebugUIConstants.ATTR_CAPTURE_IN_CONSOLE, false);
		 configuration.setAttribute(DebugPlugin.ATTR_CAPTURE_OUTPUT, false);
	}

	private static ILaunchConfigurationTab[] insertTab(ILaunchConfigurationTab[] tabs, int position,
			ILaunchConfigurationTab newTab) {
		ILaunchConfigurationTab[] result = new ILaunchConfigurationTab[tabs.length + 1];
		int offset = 0;
		for (int i = 0; i < result.length; i++) {
			if (i == position) {
				result[i] = newTab;
				offset = -1;
			} else {
				result[i] = tabs[i + offset];
			}
		}
		return result;
	}

	private static ILaunchConfigurationTab[] removeTab(ILaunchConfigurationTab[] tabs, int position) {
		ILaunchConfigurationTab[] result = new ILaunchConfigurationTab[tabs.length - 1];
		for (int i = 0; i < tabs.length; i++) {
			if (i < position) {
				result[i] = tabs[i];
			} else if (i > position) {
				result[i - 1] = tabs[i];
			} else
				tabs[i].dispose();
		}
		return result;
	}

	private static void updateRapVmArgument(ILaunchConfigurationWorkingCopy config) {
		String vmArguments = ""; //$NON-NLS-1$
		try {
			vmArguments = config.getAttribute(ATTR_VM_ARGUMENTS, ""); //$NON-NLS-1$
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(e.getStatus());
		}
		vmArguments = appendJettyLogLevel(vmArguments);
		config.setAttribute(ATTR_VM_ARGUMENTS, vmArguments);
	}

	private static String appendJettyLogLevel(String vmArguments) {
		String result = vmArguments;
		if (result.length() > 0) {
			result += NEW_LINE;
		}
		result += JETTY_LOG_LEVEL;
		return result;
	}
}
