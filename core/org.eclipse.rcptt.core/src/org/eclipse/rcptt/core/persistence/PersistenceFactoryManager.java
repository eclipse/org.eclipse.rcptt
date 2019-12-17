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
package org.eclipse.rcptt.core.persistence;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.core.persistence.zip.PersistenceZipModelFactory;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class PersistenceFactoryManager {
	private List<IPersistenceModelFactory> managers = null;
	private static PersistenceFactoryManager instance = null;
	private IPersistenceModelFactory topPriority = null;

	private PersistenceFactoryManager() {
	}

	private void initialize() {
		if (managers != null) {
			return;
		}
		managers = new ArrayList<IPersistenceModelFactory>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						RcpttPlugin.PLUGIN_ID + ".persistence");
		int top = -1;
		for (IConfigurationElement cfg : elements) {
			if ("persistence".equals(cfg.getName())) {
				IPersistenceModelFactory provider;
				try {
					provider = (IPersistenceModelFactory) cfg
							.createExecutableExtension("class");
					String priority = cfg.getAttribute("priority");
					int prio = 0;
					if (priority != null) {
						try {
							prio = Integer.parseInt(priority);
						} catch (NumberFormatException e) {
							RcpttPlugin.log(e);
						}
					}
					if (prio > top) {
						top = prio;
						topPriority = provider;
					}
					managers.add(provider);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public IPersistenceModelFactory getDefaultFactory() {
		if (topPriority != null) {
			return topPriority;
		}
		return new PersistenceZipModelFactory();
	}

	public synchronized IPersistenceModelFactory[] getFactories() {
		initialize();
		return managers.toArray(new IPersistenceModelFactory[managers.size()]);
	}

	public synchronized static PersistenceFactoryManager getInstance() {
		if (instance == null) {
			instance = new PersistenceFactoryManager();
		}
		return instance;
	}
}
