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
package org.eclipse.rcptt.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class UtilPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.util";

	// The shared instance
	private static UtilPlugin plugin;

	/**
	 * The constructor
	 */
	public UtilPlugin() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static UtilPlugin getDefault() {
		return plugin;
	}

	public static IStatus createStatus(String message) {
		return createStatus(message, null);
	}

	public static IStatus createStatus(Throwable t) {
		return createStatus(t.getMessage(), t);
	}

	public static IStatus createStatus(String message, Throwable t) {
		return new Status(Status.ERROR, PLUGIN_ID, message, t);
	}

	public static void log(Throwable t) {
		getDefault().getLog().log(createStatus(t));
	}

	public static IEclipsePreferences getPreferences() {
		return new InstanceScope().getNode(PLUGIN_ID);
	}

	public static IEclipsePreferences getDefaultPreferences() {
		return new DefaultScope().getNode(PLUGIN_ID);
	}

	public static void log(String msg, Throwable e) {
		UtilPlugin def = getDefault();
		if (def != null) {
			def.getLog().log(createStatus(msg, e));
		}
	}
}
