/*******************************************************************************
 * Copyright (c) 2009, 2020 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.rcptt.tesla.core.server.TeslaServerManager;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.Version;

/**
 * The activator class controls the plug-in life cycle
 */
public class TeslaCore extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.tesla.core";

	// The shared instance
	private static TeslaCore plugin;

	public static boolean LOGGING = false;

	private static Version platformVersion;

	/**
	 * The constructor
	 */
	public TeslaCore() {
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
			LOGGING = service.getBooleanOption("org.eclipse.rcptt.tesla.core/logging",
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
		TeslaServerManager.stopServer();
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static TeslaCore getDefault() {
		return plugin;
	}

	public static void log(Throwable t) {
		if (t instanceof java.lang.ClassNotFoundException
				|| t instanceof NoClassDefFoundError) {
			// Ignore
			return;
		}
		// Check if Eclipse is being restarted
		if (TeslaCore.getDefault() != null) {
			getDefault().getLog().log(createError(t));
		}
	}

	public static void log(String message) {
		getDefault().getLog().log(createError(message));
	}

	@SuppressWarnings("deprecation")
	public static IEclipsePreferences getPreferences() {
		return new InstanceScope().getNode(PLUGIN_ID);
	}

	/**
	 * Return platform version:
	 * 
	 * 3.103 - for Eclipse 4.2
	 * 
	 * @return
	 */
	public static Version getPlatformVersion() {
		if (platformVersion == null) {
			Bundle bundle = Platform.getBundle("org.eclipse.ui");
			if (bundle == null) {
				bundle = Platform.getBundle("org.eclipse.osgi");
			}
			platformVersion = bundle.getVersion();
		}
		return platformVersion;
	}

	public static boolean isEclipse4() {
		Version version = getPlatformVersion();
		return version.getMajor() == 3 && version.getMinor() >= 103;
	}

	public static IStatus createError(String message) {
		return createError(message, null);
	}

	public static IStatus createError(Throwable t) {
		return createError(t.getMessage(), t);
	}

	public static IStatus createError(String message, Throwable t) {
		return new Status(Status.ERROR, PLUGIN_ID, message, t);
	}

}
