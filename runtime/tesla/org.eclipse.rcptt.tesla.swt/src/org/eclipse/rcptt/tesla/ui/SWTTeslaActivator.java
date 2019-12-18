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
package org.eclipse.rcptt.tesla.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * The activator class controls the plug-in life cycle
 */

public class SWTTeslaActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.tesla.swt";

	// The shared instance
	private static SWTTeslaActivator plugin;

	public static boolean DEBUG_LOGGING_ENABLED = false;

	/**
	 * The constructor
	 */
	public SWTTeslaActivator() {
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
			DEBUG_LOGGING_ENABLED = service.getBooleanOption("org.eclipse.rcptt.tesla.swt/logging",
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
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static SWTTeslaActivator getDefault() {
		return plugin;
	}

	public static void info(String message) {
		getDefault().getLog().log(new Status(Status.INFO, PLUGIN_ID, message));
	}

	public static void log(Throwable t) {
		getDefault().getLog().log(
				new Status(Status.ERROR, PLUGIN_ID, t.getMessage(), t));
	}

	public static void log(String message, Throwable t) {
		getDefault().getLog().log(
				new Status(Status.ERROR, PLUGIN_ID, message, t));
	}

	public static void log(String msg) {
		getDefault().getLog().log(
				new Status(Status.WARNING, PLUGIN_ID, msg, null));
	}

	public static void err(String msg) {
		getDefault().getLog().log(
				new Status(Status.ERROR, PLUGIN_ID, msg, null));
	}

	public static IStatus createStatus(String message, Throwable t) {
		return new Status(Status.ERROR, PLUGIN_ID, message, t);
	}

	public static void debugLog(String message) {
		if (DEBUG_LOGGING_ENABLED) {
			System.out.println(message);
		}
	}

	/**
	 * Sends logs to the server using {@link LoggingCategory.NORMAL} category.
	 * */
	public static void logToReport(String message) {
		INodeBuilder nodeBuilder = ReportManager.getCurrentReportNode();
		nodeBuilder.appendLog(LoggingCategory.NORMAL, message);
	}

	/**
	 * Sends logs to the server.
	 * */
	public static void logToReport(LoggingCategory category, String message) {
		try {
			INodeBuilder nodeBuilder = ReportManager.getCurrentReportNode();
			nodeBuilder.appendLog(category, message);
		} catch (Throwable e) {
			log("Exception while writing to the report log.", e);
		}
	}
}
