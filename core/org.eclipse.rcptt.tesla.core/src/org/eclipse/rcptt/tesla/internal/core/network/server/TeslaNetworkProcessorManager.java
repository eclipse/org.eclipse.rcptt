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
package org.eclipse.rcptt.tesla.internal.core.network.server;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

public class TeslaNetworkProcessorManager {
	private List<ITeslaNetworkClientProcessor> processors = null;

	public TeslaNetworkProcessorManager() {
	}

	private synchronized void initialize() {
		if (processors != null) {
			return;
		}
		processors = new ArrayList<ITeslaNetworkClientProcessor>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						TeslaCore.PLUGIN_ID + ".networkProcessor");
		for (IConfigurationElement cfg : elements) {
			ITeslaNetworkClientProcessor provider;
			try {
				provider = (ITeslaNetworkClientProcessor) cfg
						.createExecutableExtension("class");
				processors.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public ITeslaNetworkClientProcessor[] getProcessors() {
		initialize();
		return processors.toArray(new ITeslaNetworkClientProcessor[processors
				.size()]);
	}
}
