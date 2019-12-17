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
package org.eclipse.rcptt.reporting.internal;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.framework.BundleContext;

import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.util.FileUtil;

public class Q7ReportingPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.reporting";

	private static Q7ReportingPlugin plugin;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		plugin = this;
		ReportManager.reload();
		}

	public static File getConfigStateLocation() {
		File result = null;
		Location configurationLocation = Platform.getConfigurationLocation();
		if (configurationLocation == null) {
			result = getDefault().getStateLocation().toFile();
		} else {
			result = new File(
					new File(configurationLocation.getURL().getFile()),
					Q7ReportingPlugin.PLUGIN_ID);
		}

		result.mkdirs();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		super.stop(bundleContext);
	}

	public static Q7ReportingPlugin getDefault() {
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

	public static void logWarn(String message, Throwable t) {
		IStatus status = new Status(Status.WARNING, PLUGIN_ID, message, t);
		getDefault().getLog().log(status);
	}
}
