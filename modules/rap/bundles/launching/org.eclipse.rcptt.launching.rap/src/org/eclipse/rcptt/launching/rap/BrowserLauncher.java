/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2019 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v2.0
 *  * which accompanies this distribution, and is available at
 *  * https://www.eclipse.org/legal/epl-v20.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.launching.rap;

import static org.eclipse.rcptt.launching.rap.Activator.PLUGIN_ID;

import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class BrowserLauncher {

	private final static String POINT_ID = PLUGIN_ID + ".browserLaunchDelegate"; //$NON-NLS-1$
	private IBrowserLaunchDelegate[] delegates = null;

	public void launch(URL uri, RAPLaunchConfig config) throws CoreException {
		for (IBrowserLaunchDelegate delegate : getLaunchers()) {
			delegate.launch(uri, config);
		}
	}

	private synchronized IBrowserLaunchDelegate[] getLaunchers() throws CoreException {
		if (delegates == null) {
			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			final IConfigurationElement[] elements = registry.getConfigurationElementsFor(POINT_ID);

			final IBrowserLaunchDelegate[] result = new IBrowserLaunchDelegate[elements.length];
			for (int i = 0; i < elements.length; i++) {
				result[i] = (IBrowserLaunchDelegate) elements[i].createExecutableExtension("class"); //$NON-NLS-1$
			}

			delegates = result;
		}
		return delegates;
	}
}
