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
package org.eclipse.rcptt.tesla.properties.view;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class PropertiesViewPlugin extends Plugin {

	private static PropertiesViewPlugin plugin;
	public static final String PLUGIN_ID = "org.eclipse.rcptt.tesla.properties.view";

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static PropertiesViewPlugin getDefault() {
		return plugin;
	}

	public static void logErr(Throwable cause, String message, Object... args) {
		getDefault().getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, String.format(message,
						args)));
	}

}
