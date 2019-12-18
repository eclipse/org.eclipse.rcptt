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
package org.eclipse.rcptt.internal.launching;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.rcptt.util.FileUtil;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Q7LaunchingPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.launching";

	public static final String EXECUTION_TIMEOUT = "EXECUTION_TIMEOUT";
	public static final String SHUTDOWN_TIMEOUT = "SHUTDOWN_TIMEOUT";

	// The shared instance
	private static Q7LaunchingPlugin plugin;

	/**
	 * The constructor
	 */
	public Q7LaunchingPlugin() {
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
		Job cleanPreviousExecutionSessions = new Job(
				"RCPTT: Clean execution sessions") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				File root = getDefault().getStateLocation().toFile();
				if (root.exists()) {
					FileUtil.deleteFiles(root.listFiles());
				}
				return Status.OK_STATUS;
			}
		};
		cleanPreviousExecutionSessions.setSystem(true);
		cleanPreviousExecutionSessions.schedule();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		Q7LaunchManager.getInstance().shutdown();
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Q7LaunchingPlugin getDefault() {
		return plugin;
	}

	public static void abort(String message, Throwable t) throws CoreException {
		throw new CoreException(createStatus(message, t));
	}

	public static void abort(String message) throws CoreException {
		throw new CoreException(createStatus(message));
	}

	public static void log(Throwable t) {
		log(t.getMessage(), t);
	}

	public static void log(String message, Throwable t) {
		log(createStatus(message, t));
	}

	public static void log(String message) {
		log(createStatus(message));
	}

	public static void log(IStatus status) {
		if (getDefault() != null) {
			getDefault().getLog().log(status);
		}
	}

	public static void logInfo(String format, Object... args) {
		log(new Status(IStatus.INFO, PLUGIN_ID, String.format(format, args)));
	}

	public static IStatus createStatus(String message) {
		return createStatus(message, null);
	}

	@SuppressWarnings("deprecation")
	public static IEclipsePreferences getPreferences() {
		return new InstanceScope().getNode(PLUGIN_ID);
	}

	public static IStatus createStatus(String message, Throwable t) {
		if (t instanceof CoreException) {
			return new MultiStatus(PLUGIN_ID, 0, new IStatus[] { ((CoreException) t).getStatus() }, message, null);
		}
		return new Status(Status.ERROR, PLUGIN_ID, message, t);
	}
	
	public static IStatus createStatus(Throwable t) {
		if (t instanceof CoreException)
			return ((CoreException) t).getStatus();
		return new Status(Status.ERROR, PLUGIN_ID, t.getMessage(), t);
	}


	public static IStatus createStatus(int state, String message, Throwable t) {
		return new Status(state, PLUGIN_ID, message, t);
	}

	public synchronized static File getExecutionSessionRoot(String name,
			ExecutionSession executionSession) {
		File bundles = getDefault().getStateLocation().toFile();
		bundles.mkdirs();
		int index = 0;
		while (true) {
			File f = new File(bundles, FileUtil.rlimitSize("s_" + name,
					10) + "_" + index);
			if (!f.exists()) {
				return f;
			}
			index++;
		}
	}
}
