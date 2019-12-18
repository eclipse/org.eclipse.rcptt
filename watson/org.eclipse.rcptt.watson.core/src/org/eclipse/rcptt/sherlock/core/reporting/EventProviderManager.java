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
package org.eclipse.rcptt.sherlock.core.reporting;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.SherlockCore;

public class EventProviderManager {
	private Map<String, IEventProvider> managers = null;
	private static EventProviderManager instance = null;

	private EventProviderManager() {
	}

	private synchronized void initialize() {
		if (managers != null) {
			return;
		}
		managers = new HashMap<String, IEventProvider>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						SherlockCore.PLUGIN_ID + ".eventProvider");
		for (IConfigurationElement cfg : elements) {
			IEventProvider provider;
			try {
				String id = cfg.getAttribute("id");
				provider = (IEventProvider) cfg
						.createExecutableExtension("class");
				if (id == null || managers.containsKey(id)) {
					SherlockCore
							.log("Duplicate or invalid id for event provider:"
									+ provider.getClass().getName() + " id:"
									+ id);
					id = "" + System.currentTimeMillis();
				}
				managers.put(id, provider);
			} catch (CoreException e) {
				SherlockCore.log(e);
			}
		}
	}

	public synchronized IEventProvider[] getExtensions() {
		initialize();
		return managers.values().toArray(new IEventProvider[managers.size()]);
	}

	public synchronized static EventProviderManager getInstance() {
		if (instance == null) {
			instance = new EventProviderManager();
		}
		return instance;
	}

	/**
	 * Listen for providers with id is starting with 'id', or for all providers
	 * if id == null
	 */
	public synchronized void register(IReportBuilder reportBuilder, String id) {
		initialize();
		for (Map.Entry<String, IEventProvider> provider : managers.entrySet()) {
			if (id == null || provider.getKey().startsWith(id)) {
				provider.getValue().removeListener(reportBuilder);
				provider.getValue().addListener(reportBuilder);
			}
		}
	}

	public synchronized void unregister(IReportBuilder reportBuilder, String id) {
		initialize();
		for (Map.Entry<String, IEventProvider> provider : managers.entrySet()) {
			if (id == null || provider.getKey().startsWith(id)) {
				provider.getValue().removeListener(reportBuilder);
			}
		}
	}

	/**
	 * Store snaphot for providers with ids starting with id
	 * 
	 * @param reportBuilder
	 * @param id
	 */
	public void takeSnapshot(INodeBuilder node) {
		initialize();
		for (Map.Entry<String, IEventProvider> provider : managers.entrySet()) {
			provider.getValue().storeSnapshot(node);
		}
	}
}
