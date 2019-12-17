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
package org.eclipse.rcptt.expandbar.runtime.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class ExpandBarRuntimePlugin extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.expandbar.runtime";
	private static ExpandBarRuntimePlugin plugin;

	public static ExpandBarRuntimePlugin getDefault() {
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

	public static IStatus status(int severity, Throwable cause, String format, Object... args) {
		return new Status(severity, PLUGIN_ID, String.format(format, args), cause);
	}

	public static IStatus err(Throwable cause, String format, Object... args) {
		return status(IStatus.ERROR, cause, format, args);
	}

	public static IStatus err(String format, Object... args) {
		return err(null, format, args);
	}
}
