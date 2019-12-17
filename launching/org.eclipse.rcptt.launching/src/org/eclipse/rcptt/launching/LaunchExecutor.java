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
package org.eclipse.rcptt.launching;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;

import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;

public enum LaunchExecutor {

	INSTANCE;

	public ILaunch launch(ILaunchConfiguration config, IProgressMonitor monitor)
			throws CoreException {
		return launch(ILaunchManager.RUN_MODE, config, monitor);
	}

	public ILaunch launch(String mode, ILaunchConfiguration config,
			IProgressMonitor monitor) throws CoreException {
		ILaunchExecutor executor = executors.get(config.getType()
				.getIdentifier());
		if (executor != null) {
			return executor.launch(mode, config, monitor);
		} else {
			return config.launch(mode, monitor);
		}
	}

	private LaunchExecutor() {
		executors = readExtensions();
	}

	private Map<String, ILaunchExecutor> executors;

	private static Map<String, ILaunchExecutor> readExtensions() {
		Map<String, ILaunchExecutor> executors = new HashMap<String, ILaunchExecutor>();
		IConfigurationElement[] configs = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTPT_EXECUTORS);
		for (IConfigurationElement config : configs) {
			try {
				ILaunchExecutor executor = (ILaunchExecutor) config
						.createExecutableExtension(ATTR_CLASS);
				String type = config.getAttribute(ATTR_TYPE);
				executors.put(type, executor);
			} catch (Exception e) {
				StringBuilder builder = new StringBuilder();
				builder.append("Problem while loading '");
				builder.append(EXTPT_EXECUTORS);
				builder.append("' extension");
				try {
					String plugin = config.getNamespaceIdentifier();
					builder.append(" from the '");
					builder.append(plugin);
					builder.append("' plugin");
				} catch (Exception exc) {
					// ignore exc
				}
				builder.append(": ");
				builder.append(e.getMessage());
				Q7LaunchingPlugin.log(builder.toString(), e);
			}
		}
		return executors;
	}

	private static final String ATTR_CLASS = "class";
	private static final String ATTR_TYPE = "type";

	private static final String EXTPT_EXECUTORS = Q7LaunchingPlugin.PLUGIN_ID
			+ ".executors";

}
