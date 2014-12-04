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
package org.eclipse.rcptt.ecl.filesystem;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class EclFilesystemPlugin extends Plugin implements BundleActivator {
	
	private static EclFilesystemPlugin plugin = null;
	
	public static final String PLUGIN_ID = "org.eclipse.rcptt.ecl.filesystem";

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		EclFilesystemPlugin.context = bundleContext;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		EclFilesystemPlugin.context = null;
	}
	
	public static void logWarning(String message, Throwable e) {
		EclFilesystemPlugin plugin = getDefault();
		if (null != plugin) {
			plugin.getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, message, e));
			plugin = null;
		}
	}
	
	public static void logWarning(String message) {
		logWarning(message, null);
	}
	
	public static EclFilesystemPlugin getDefault() {
		return plugin;
	}
	
	public static Status createError(String message, Object... args) {
		return createError(null, message, args);
	}

	public static Status createError(Throwable throwable, String message, Object... args) {
		if (message == null)
			message = "";
		if (args == null)
			args = new Object[0];
		return new Status(IStatus.ERROR, EclFilesystemPlugin.PLUGIN_ID, String.format(message, args), throwable);
	}

}
