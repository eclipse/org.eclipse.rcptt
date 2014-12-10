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
package org.eclipse.rcptt.launching.multiaut;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class MultiAutLaunchPlugin extends Plugin {
	private static MultiAutLaunchPlugin plugin = null;
	public static final String PLUGIN_ID = "org.eclipse.rcptt.launching.multiaut";

	public static MultiAutLaunchPlugin getDefault() {
		return plugin;
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

	public static void log(int severity, Throwable cause, String format, Object... args) {
		getDefault().getLog().log(status(severity, cause, format, args));
	}

	public static IStatus status(int severity, Throwable cause, String format, Object... args) {
		return new Status(severity, PLUGIN_ID, String.format(format, args), cause);
	}

	public static IStatus errStatus(Throwable cause, String format, Object... args) {
		return status(IStatus.ERROR, cause, format, args);
	}

	public static IStatus errStatus(String format, Object... args) {
		return errStatus(null, format, args);
	}

	public static void logWarn(Throwable cause, String format, Object... args) {
		log(IStatus.WARNING, cause, format, args);
	}

	public static void logWarn(String format, Object... args) {
		logWarn(null, format, args);
	}

	public static void logErr(Throwable cause, String format, Object... args) {
		log(IStatus.ERROR, cause, format, args);
	}

	public static void logErr(String format, Object... args) {
		logErr(null, format, args);
	}

}
