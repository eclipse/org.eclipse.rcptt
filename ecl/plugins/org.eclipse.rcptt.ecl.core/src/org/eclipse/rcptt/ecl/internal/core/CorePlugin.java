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

package org.eclipse.rcptt.ecl.internal.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.framework.BundleContext;

public class CorePlugin extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.ecl.core";

	public static final String ECL_EDITOR_LINE_WIDTH = "ECL_EDITOR_LINE_WIDTH";
	public static final int ECL_EDITOR_LINE_WIDTH_DEFAULT = 120;
	public static final String ECL_EDITOR_INDENT = "ECL_EDITOR_INDENT";
	public static final int ECL_EDITOR_INDENT_DEFAULT = 4;

	private static CorePlugin plugin;

	private ScriptletManager manager;

	/**
	 * The constructor
	 */
	public CorePlugin() {
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
		manager = new ScriptletManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		manager = null;
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static CorePlugin getDefault() {
		return plugin;
	}

	public static ScriptletManager getScriptletManager() {
		if (plugin != null) {
			return plugin.manager;
		}
		return null;
	}

	public static IStatus err(String message) {
		return err(message, null);
	}

	public static IStatus err(String message, Throwable throwable) {
		return new Status(IStatus.ERROR, PLUGIN_ID, message, throwable);
	}

	public static IStatus err(Throwable throwable) {
		return new Status(IStatus.ERROR, PLUGIN_ID, throwable.getMessage(),
				throwable);
	}

	public static void log(IStatus status) {
		if (getDefault() != null) {
			getDefault().getLog().log(status);
		}
	}

	public static void log(String message) {
		log(err(message));
	}

	public static void log(String message, Throwable throwable) {
		log(err(message, throwable));
	}

	public static void log(Throwable throwable) {
		log(err(throwable.getMessage(), throwable));
	}

	@SuppressWarnings("deprecation")
	public static IEclipsePreferences getPreferences() {
		return new InstanceScope().getNode(PLUGIN_ID);
	}

	public static int getECLEditorLineWidth() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.getInt(ECL_EDITOR_LINE_WIDTH, ECL_EDITOR_LINE_WIDTH_DEFAULT);
	}

	public static void setECLEditorLineWidth(final int width) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.putInt(ECL_EDITOR_LINE_WIDTH, width);
		try {
			preferences.flush();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static int getECLEditorIndent() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.getInt(ECL_EDITOR_INDENT, ECL_EDITOR_INDENT_DEFAULT);
	}

	public static void setECLEditorIndent(final int width) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.putInt(ECL_EDITOR_INDENT, width);
		try {
			preferences.flush();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
