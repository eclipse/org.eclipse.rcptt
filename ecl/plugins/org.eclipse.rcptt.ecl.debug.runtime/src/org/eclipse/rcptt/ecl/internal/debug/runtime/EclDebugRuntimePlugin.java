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

package org.eclipse.rcptt.ecl.internal.debug.runtime;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class EclDebugRuntimePlugin extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.ecl.debug.runtime";

	private static EclDebugRuntimePlugin plugin;

	/**
	 * The constructor
	 */
	public EclDebugRuntimePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
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
	public static EclDebugRuntimePlugin getDefault() {
		return plugin;
	}

	public static IStatus err(String message) {
		return err(message, null);
	}

	public static IStatus err(String message, Throwable throwable) {
		return new Status(IStatus.ERROR, PLUGIN_ID, message, throwable);
	}

	public static IStatus err(Throwable throwable) {
		return new Status(IStatus.ERROR, PLUGIN_ID, throwable.getMessage(),
				throwable);
	}

	public static void log(IStatus status) {
		if (getDefault() != null) {
			getDefault().getLog().log(status);
		}
	}

	public static void log(String message) {
		log(err(message));
	}

	public static void log(String message, Throwable throwable) {
		log(err(message, throwable));
	}

	public static void log(Throwable throwable) {
		log(err(throwable.getMessage(), throwable));
	}

}
