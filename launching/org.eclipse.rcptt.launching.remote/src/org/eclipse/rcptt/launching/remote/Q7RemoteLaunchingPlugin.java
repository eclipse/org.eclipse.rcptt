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
package org.eclipse.rcptt.launching.remote;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class Q7RemoteLaunchingPlugin extends Plugin {

	public final static String PLUGIN_ID = "org.eclipse.rcptt.launching.remote";

	// The shared instance
	private static Q7RemoteLaunchingPlugin plugin;

	/**
	 * The constructor
	 */
	public Q7RemoteLaunchingPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
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
	public static Q7RemoteLaunchingPlugin getDefault() {
		return plugin;
	}

	public void log(Throwable e) {
		getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
	}

	public void log(String msg, Throwable e) {
		getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, msg, e));
	}

	public void logInfo(String msg) {
		getLog().log(new Status(IStatus.INFO, PLUGIN_ID, msg, null));
	}
}
