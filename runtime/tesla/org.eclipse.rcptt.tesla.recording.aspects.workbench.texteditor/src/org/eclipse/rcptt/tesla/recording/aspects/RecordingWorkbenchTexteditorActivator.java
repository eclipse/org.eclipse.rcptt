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
package org.eclipse.rcptt.tesla.recording.aspects;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class RecordingWorkbenchTexteditorActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.tesla.recording.aspects.workbench.texteditor";

	// The shared instance
	private static RecordingWorkbenchTexteditorActivator plugin;

	/**
	 * The constructor
	 */
	public RecordingWorkbenchTexteditorActivator() {
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
		AspectManager.activateBundle(PLUGIN_ID);
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
	public static RecordingWorkbenchTexteditorActivator getDefault() {
		return plugin;
	}

	public static void log(Throwable t) {
		getDefault().getLog().log(
				new Status(Status.ERROR, PLUGIN_ID,
						"Tesla Recording SWT ERROR", t));
	}

}
