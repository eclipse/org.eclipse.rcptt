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
package org.eclipse.rcptt.sherlock.core;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.sherlock.core.internal.SherlockLogListener;
import org.osgi.framework.BundleContext;

public class SherlockCore extends Plugin {
	public static final String PLUGIN_ID = "org.eclipse.rcptt.watson.core";

	private static SherlockCore plugin;

	public SherlockCore() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Platform.addLogListener(logListener);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		Platform.removeLogListener(logListener);
		plugin = null;
		super.stop(context);
	}

	public static SherlockCore getDefault() {
		return plugin;
	}

	// ILogListener
	private final SherlockLogListener logListener = new SherlockLogListener();

	public static void addLogListener(ILogListener listener,
			IStatusFilter statusFilter, IPluginFilter pluginFilter) {
		getDefault().logListener.addLogListener(listener, statusFilter,
				pluginFilter);
	}

	public static void removeLogListener(ILogListener listener) {
		getDefault().logListener.removeLogListener(listener);
	}

	public static void log(String msg) {
		getDefault().getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, msg, null));
	}

	public static void log(Throwable e) {
		getDefault().getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
	}

	public static void log(String msg, Throwable e) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, msg, e));
	}

	public static String rlimitSize(String id, int len) {
		if (id.length() > len) {
			return id.substring(0, len);
		}
		return id;
	}

	public static String getID(String value) {
		if (value == null) {
			return null;
		}
		String textResult = "";
		for (char c : value.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				textResult += '_';
			} else {
				textResult += c;
			}
		}
		return textResult;
	}
}
