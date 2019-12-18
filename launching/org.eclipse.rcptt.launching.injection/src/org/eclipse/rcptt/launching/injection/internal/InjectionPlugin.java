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
package org.eclipse.rcptt.launching.injection.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class InjectionPlugin extends Plugin {
	public static final String PLUGIN_ID = "org.eclipse.rcptt.launching.injection";

	private static InjectionPlugin plugin;
	
	public static InjectionPlugin getDefault() {
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
	
	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}
	
	public static void logWarn(String message) {
		log(createStatus(IStatus.WARNING, message, null));
	}
	
	public static IStatus createStatus(int severity, String message, Throwable cause) {
		return new Status(severity, PLUGIN_ID, message, cause);
	}

}
