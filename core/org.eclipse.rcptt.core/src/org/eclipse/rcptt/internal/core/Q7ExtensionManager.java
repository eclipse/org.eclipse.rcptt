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
package org.eclipse.rcptt.internal.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.core.IQ7Extension;

public class Q7ExtensionManager {
	private List<IQ7Extension> managers = null;
	private static Q7ExtensionManager instance = null;

	private Q7ExtensionManager() {
	}

	private synchronized void initialize() {
		if (managers != null) {
			return;
		}
		managers = new ArrayList<IQ7Extension>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						RcpttPlugin.PLUGIN_ID + ".q7Extension");
		for (IConfigurationElement cfg : elements) {
			IQ7Extension provider;
			try {
				provider = (IQ7Extension) cfg
						.createExecutableExtension("class");
				managers.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public IQ7Extension[] getExtensions() {
		initialize();
		return managers.toArray(new IQ7Extension[managers.size()]);
	}

	public synchronized static Q7ExtensionManager getInstance() {
		if (instance == null) {
			instance = new Q7ExtensionManager();
		}
		return instance;
	}
}
