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
package org.eclipse.rcptt.tesla.gmf.aspects;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class GMFAspectsActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.tesla.gmf.aspects";

	// The shared instance
	private static GMFAspectsActivator plugin;

	/**
	 * The constructor
	 */
	public GMFAspectsActivator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		AspectManager.activateBundle(PLUGIN_ID);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
	public static GMFAspectsActivator getDefault() {
		return plugin;
	}
	public static void log(Throwable t) {
		log(t.getMessage(), t);
	}

	public static void log(String message, Throwable t) {
		getDefault().getLog().log(createStatus(message, t));
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
}
