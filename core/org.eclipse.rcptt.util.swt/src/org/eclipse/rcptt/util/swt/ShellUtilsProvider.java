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
package org.eclipse.rcptt.util.swt;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.util.swt.internal.ui.DefaultShellUtils;
import org.eclipse.rcptt.util.swt.internal.SwtUtilPlugin;

public class ShellUtilsProvider {
	private static ShellUtils utils = null;
	synchronized public static ShellUtils getShellUtils() throws CoreException {
		if (utils == null) {
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(
							SwtUtilPlugin.PLUGIN_ID + ".shellUtils");
			if (elements.length == 0)
				utils = new DefaultShellUtils();
			else if (elements.length > 1)
				throw new CoreException(new Status(IStatus.ERROR, SwtUtilPlugin.PLUGIN_ID, "Too many implementations of " + ShellUtils.class.getName()));
			else	
				utils = (ShellUtils) elements[0].createExecutableExtension("class");
		}
		return utils;
	}
}
