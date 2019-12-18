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
package org.eclipse.rcptt.launching.configuration;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	/**
	 * Launch configuration attribute key. The value is a string specifying
	 * source configuration of an Eclipse application.
	 */
	public final static String TARGET_CONFIGURATION = "target-configuration"; //$NON-NLS-1$
	public final static String ATTR_ECL_PORT = "aut-ecl-port"; //$NON-NLS-1$	
	public final static String ATTR_TESLA_PORT = "aut-tesla-port"; //$NON-NLS-1$	

	public final static String Q7_LAUNCH_CONFIGURATION_ID = "org.eclipse.rcptt.launching.configuration"; //$NON-NLS-1$		
	public final static String PDE_LAUNCH_CONFIG_ID = "org.eclipse.pde.ui.RuntimeWorkbench"; //$NON-NLS-1$

	public static final String PLUGIN_ID = "org.eclipse.rcptt.launching.configuration"; //$NON-NLS-1$

	private static Activator plugin;

	public Activator() {
		// Create a listener to track changes in launch configurations.
		LaunchConfigurationListener listener = new LaunchConfigurationListener();
		DebugPlugin.getDefault().getLaunchManager()
				.addLaunchConfigurationListener(listener);
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
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
