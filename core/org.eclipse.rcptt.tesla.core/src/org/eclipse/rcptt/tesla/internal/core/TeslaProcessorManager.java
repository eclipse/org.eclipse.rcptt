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
package org.eclipse.rcptt.tesla.internal.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;

public class TeslaProcessorManager {
	private List<ITeslaCommandProcessor> processors = null;

	public TeslaProcessorManager() {
	}

	private synchronized void initialize() {
		if (processors != null) {
			return;
		}
		processors = new ArrayList<ITeslaCommandProcessor>();

		IConfigurationElement[] elements = Platform
				.getExtensionRegistry()
				.getConfigurationElementsFor(TeslaCore.PLUGIN_ID + ".processor");
		for (IConfigurationElement cfg : elements) {
			ITeslaCommandProcessor provider;
			try {
				provider = (ITeslaCommandProcessor) cfg
						.createExecutableExtension("class");
				processors.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public ITeslaCommandProcessor[] getProcessors() {
		initialize();
		return processors
				.toArray(new ITeslaCommandProcessor[processors.size()]);
	}
}
