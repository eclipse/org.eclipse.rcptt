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
package org.eclipse.rcptt.tesla.ui;

import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * The activator class controls the plug-in life cycle
 */

public class SWTTeslaActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.tesla.swt";

	// The shared instance
	private static SWTTeslaActivator plugin;

	public static boolean LOGGING = false;

	/**
	 * The constructor
	 */
	public SWTTeslaActivator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		DebugOptions service = null;
		final ServiceReference reference = context
				.getServiceReference(DebugOptions.class.getName());
		if (reference != null)
			service = (DebugOptions) context.getService(reference);
		if (service == null)
			return;
		try {
			LOGGING = service.getBooleanOption("org.eclipse.rcptt.tesla.swt/logging",
					false);
		} finally {
			// we have what we want - release the service
			context.ungetService(reference);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static SWTTeslaActivator getDefault() {
		return plugin;
	}

	public static void info(String message) {
		getDefault().getLog().log(new Status(Status.INFO, PLUGIN_ID, message));
	}

	public static void log(Throwable t) {
		getDefault().getLog().log(
				new Status(Status.ERROR, PLUGIN_ID, t.getMessage(), t));
	}

	public static void log(String message, Throwable t) {
		getDefault().getLog().log(
				new Status(Status.ERROR, PLUGIN_ID, message, t));
	}

	public static void log(String msg) {
		getDefault().getLog().log(
				new Status(Status.WARNING, PLUGIN_ID, msg, null));
	}

	public static void err(String msg) {
		getDefault().getLog().log(
				new Status(Status.ERROR, PLUGIN_ID, msg, null));
	}
}
