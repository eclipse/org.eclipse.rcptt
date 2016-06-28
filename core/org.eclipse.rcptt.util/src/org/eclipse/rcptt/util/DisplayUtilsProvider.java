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
package org.eclipse.rcptt.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

public class DisplayUtilsProvider {
	private static DisplayUtils utils = null;

	synchronized public static DisplayUtils getDisplayUtils() throws CoreException {
		if (utils == null) {
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(
							UtilPlugin.PLUGIN_ID + ".displayUtils");
			if (elements.length == 0)
				throw new CoreException(new Status(IStatus.ERROR, UtilPlugin.PLUGIN_ID,
						"None  implementations of " + ShellUtils.class.getName()));
			else
				utils = (DisplayUtils) elements[0].createExecutableExtension("class");
		}
		return utils;
	}
}
