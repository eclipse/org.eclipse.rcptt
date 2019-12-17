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
package org.eclipse.rcptt.core.internal.builder;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.osgi.framework.BundleContext;

import com.google.common.base.Preconditions;

/**
 * The activator class controls the plug-in life cycle
 */
public class Q7BuilderActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.core.builder"; //$NON-NLS-1$

	// The shared instance
	private static Q7BuilderActivator plugin;

	/**
	 * The constructor
	 */
	public Q7BuilderActivator() {
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
		// Ensures dependency is loaded (to enable logging in async builders)
		Preconditions.checkNotNull(RcpttPlugin.getDefault().getLog());
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
	public static Q7BuilderActivator getDefault() {
		return plugin;
	}
}
