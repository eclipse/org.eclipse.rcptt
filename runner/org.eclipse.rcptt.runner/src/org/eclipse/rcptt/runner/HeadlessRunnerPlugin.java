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
package org.eclipse.rcptt.runner;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class HeadlessRunnerPlugin extends Plugin {
	public static final String PLUGIN_ID = "org.eclipse.rcptt.runner";

	private static HeadlessRunnerPlugin plugin;

	public static HeadlessRunnerPlugin getDefault() {
		return plugin;
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);

		plugin = this;
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;

		super.stop(context);
	}

	public void info(final String message) {
		getLog().log(new Status(IStatus.INFO, PLUGIN_ID, message));
	}

	public void info(final String message, Throwable e) {
		getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message, e));
	}

	public static void log(IStatus status) {
		HeadlessRunnerPlugin p = getDefault();
		if (p == null) {
			return;
		}
		p.getLog().log(status);
	}

	public static void logErr(String message) {
		logErr(message, null);
	}

	public static void logErr(String message, Throwable e) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, message, e));
	}
}
