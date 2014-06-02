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
package org.eclipse.rcptt.tesla.variables;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class TeslaVariablesPlugin implements BundleActivator {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.tesla.variables";

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		TeslaVariablesPlugin.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		TeslaVariablesPlugin.context = null;
	}

}
