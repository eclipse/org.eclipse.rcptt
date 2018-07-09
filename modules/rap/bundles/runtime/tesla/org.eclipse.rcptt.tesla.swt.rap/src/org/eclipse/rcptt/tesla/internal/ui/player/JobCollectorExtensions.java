/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.tesla.ui.SWTTeslaActivator;
import org.eclipse.rcptt.tesla.ui.IJobCollector;

public class JobCollectorExtensions {
	private static JobCollectorExtensions instance;
	private List<IJobCollector> collectors = new ArrayList<IJobCollector>();

	public JobCollectorExtensions() {
		inializeProcessors();
	}

	private void inializeProcessors() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						SWTTeslaActivator.PLUGIN_ID + ".jobCollector");
		for (IConfigurationElement config : configurationElements) {
			try {
				IJobCollector processor = (IJobCollector) config
						.createExecutableExtension("class");
				collectors.add(processor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized static JobCollectorExtensions getDefault() {
		if (instance == null) {
			instance = new JobCollectorExtensions();
		}
		return instance;
	}

	public IJobCollector[] getCollectors() {
		return collectors.toArray(new IJobCollector[collectors.size()]);
	}
}
