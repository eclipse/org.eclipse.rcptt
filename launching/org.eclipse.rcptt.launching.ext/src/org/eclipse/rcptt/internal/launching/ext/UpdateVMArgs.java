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
package org.eclipse.rcptt.internal.launching.ext;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;

public class UpdateVMArgs {
	public static void updateVMArgs(
			ILaunchConfigurationWorkingCopy configuration) {
		try {
			String attribute = configuration.getAttribute(
					IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS, "");
			String finalValue = updateAttr(attribute);
			if (finalValue != null) {
				configuration.setAttribute(
						IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,
						finalValue);
			}
		} catch (CoreException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		}
	}

	public static String updateAttr(String attribute) {
		if (!attribute.contains("-Xmx")) {
			attribute += " -Xmx512m";
		}
		if (!attribute.contains("-XX:MaxPermSize")) {
			attribute += " -XX:MaxPermSize=128m";
		}
		// -XstartOnFirstThread
		// -Dorg.eclipse.swt.internal.carbon.smallFonts
		if (Platform.getOS().equals(Platform.OS_MACOSX)) {
			if (!attribute.contains("-XstartOnFirstThread")) {
				attribute += " -XstartOnFirstThread";
			}
			if (!attribute
					.contains("-Dorg.eclipse.swt.internal.carbon.smallFonts")) {
				attribute += " -Dorg.eclipse.swt.internal.carbon.smallFonts";
			}
		}
		return attribute;
	}
}
