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
package org.eclipse.rcptt.core.versioning;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class Q7VersionManager {
	private List<IQ7VersionManager> managers = null;
	private static Q7VersionManager instance = null;

	private Q7VersionManager() {
	}

	private synchronized void initialize() {
		if (managers != null) {
			return;
		}
		managers = new ArrayList<IQ7VersionManager>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						RcpttPlugin.PLUGIN_ID + ".versionManager");
		for (IConfigurationElement cfg : elements) {
			IQ7VersionManager provider;
			try {
				provider = (IQ7VersionManager) cfg
						.createExecutableExtension("class");
				managers.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public IQ7VersionManager[] getManagers() {
		initialize();
		return managers.toArray(new IQ7VersionManager[managers.size()]);
	}

	public static Q7VersionManager getInstance() {
		if (instance == null) {
			instance = new Q7VersionManager();
		}
		return instance;
	}
}
