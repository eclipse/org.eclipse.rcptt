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
package org.eclipse.rcptt.core.persistence.plain;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class PlainTextPersistenceExtensionManager {
	private List<IPlainTextPersistenceExtension> extensions = null;
	private static PlainTextPersistenceExtensionManager instance = null;

	private PlainTextPersistenceExtensionManager() {
	}

	private synchronized void initialize() {
		if (extensions != null) {
			return;
		}
		extensions = new ArrayList<IPlainTextPersistenceExtension>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						RcpttPlugin.PLUGIN_ID + ".persistence");
		for (IConfigurationElement cfg : elements) {
			if ("plainExtension".equals(cfg.getName())) {
				IPlainTextPersistenceExtension provider;
				try {
					provider = (IPlainTextPersistenceExtension) cfg
							.createExecutableExtension("class");
					extensions.add(provider);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public IPlainTextPersistenceExtension[] getExtensions() {
		initialize();
		return extensions.toArray(new IPlainTextPersistenceExtension[extensions
				.size()]);
	}

	public synchronized static PlainTextPersistenceExtensionManager getInstance() {
		if (instance == null) {
			instance = new PlainTextPersistenceExtensionManager();
		}
		return instance;
	}
}
