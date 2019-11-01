/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.zephyr;

import java.io.IOException;
import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.osgi.framework.BundleContext;
import org.osgi.service.prefs.BackingStoreException;

public final class ZephyrPlugin extends Plugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.zephyr"; //$NON-NLS-1$

	public static final String LAUNCH_TESTRUNID = PLUGIN_ID + ".ATTR_ZEPHYR_TESTRUNID";

	public static final String ZEPHYR_ENABLED = "ZEPHYR_ENABLED";
	public static final String ZEPHYR_ADDRESS = "ZEPHYR_ADDRESS";
	public static final String ZEPHYR_USERNAME = "ZEPHYR_USERNAME";
	public static final String ZEPHYR_PASSWORD = "ZEPHYR_PASSWORD";
	public static final String ZEPHYR_PROJECT = "ZEPHYR_PROJECT";
	public static final String ZEPHYR_VERSION = "ZEPHYR_VERSION";
	public static final String ZEPHYR_CYCLE = "ZEPHYR_CYCLE";

	public static final boolean DEFAULT_ZEPHYR_ENABLED = false;

	// The shared instance
	private static ZephyrPlugin plugin;

	/**
	 * The constructor
	 */
	public ZephyrPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ZephyrPlugin getDefault() {
		return plugin;
	}

	public static void logInfo(String message) {
		final String loggingEnabled = TeslaFeatures.getInstance().getValue(TeslaFeatures.TESTENGINE_LOGS);
		if ("true".equals(loggingEnabled)) {
			log(createStatus(Status.INFO, message));
		}
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

	public static IStatus createStatus(String message) {
		return createStatus(Status.ERROR, message, null);
	}

	public static IStatus createStatus(int state, String message) {
		return createStatus(state, message, null);
	}

	public static IStatus createStatus(String message, Throwable t) {
		return createStatus(Status.ERROR, message, t);
	}

	public static IStatus createStatus(int state, String message, Throwable t) {
		return new Status(state, PLUGIN_ID, message, t);
	}

	public static IEclipsePreferences getPreferences() {
		return InstanceScope.INSTANCE.getNode(PLUGIN_ID);
	}

	public static ISecurePreferences getSecurePreferences() {
		return SecurePreferencesFactory.getDefault().node(PLUGIN_ID);
	}

	public static boolean getZephyrEnabled() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.getBoolean(ZEPHYR_ENABLED, DEFAULT_ZEPHYR_ENABLED);
	}

	public static void setZephyrEnabled(final boolean enabled) {
		final IEclipsePreferences preferences = getPreferences();
		try {
			preferences.putBoolean(ZEPHYR_ENABLED, enabled);
			preferences.flush();
		} catch (final BackingStoreException e) {
			throw new IllegalStateException(
					MessageFormat.format(Messages.ZephyrPlugin_ErrorWhileSaving, ZEPHYR_ENABLED), e);
		}
	}

	public static String getZephyrAddress() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.get(ZEPHYR_ADDRESS, "");
	}

	public static void setZephyrAddress(final String address) {
		final IEclipsePreferences preferences = getPreferences();
		try {
			preferences.put(ZEPHYR_ADDRESS, address);
			preferences.flush();
		} catch (final BackingStoreException e) {
			throw new IllegalStateException(
					MessageFormat.format(Messages.ZephyrPlugin_ErrorWhileSaving, ZEPHYR_ADDRESS), e);
		}
	}

	public static String getZephyrUsername() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.get(ZEPHYR_USERNAME, "");
	}

	public static void setZephyrUsername(final String username) {
		final IEclipsePreferences preferences = getPreferences();
		try {
			preferences.put(ZEPHYR_USERNAME, username);
			preferences.flush();
		} catch (final BackingStoreException e) {
			throw new IllegalStateException(
					MessageFormat.format(Messages.ZephyrPlugin_ErrorWhileSaving, ZEPHYR_USERNAME), e);
		}
	}

	public static String getZephyrPassword() {
		final ISecurePreferences preferences = getSecurePreferences();
		try {
			return preferences.get(ZEPHYR_PASSWORD, "");
		} catch (final StorageException e) {
			throw new IllegalStateException(
					MessageFormat.format(Messages.ZephyrPlugin_ErrorWhileSaving, ZEPHYR_PASSWORD), e);
		}
	}

	public static void setZephyrPassword(final String password) {
		final ISecurePreferences preferences = getSecurePreferences();
		try {
			preferences.put(ZEPHYR_PASSWORD, password, true);
			preferences.flush();
		} catch (final StorageException | IOException e) {
			throw new IllegalStateException(
					MessageFormat.format(Messages.ZephyrPlugin_ErrorWhileSaving, ZEPHYR_PASSWORD), e);
		}
	}

	public static String getZephyrProject(final IProject project) {
		final IEclipsePreferences preferences = getProperties(project);
		return preferences.get(ZEPHYR_PROJECT, "");
	}

	public static void setZephyrProject(final String zephyrProject, final IProject rcpttProject) {
		final IEclipsePreferences properties = getProperties(rcpttProject);
		try {
			properties.put(ZEPHYR_PROJECT, zephyrProject);
			properties.flush();
		} catch (final BackingStoreException e) {
			throw new IllegalStateException(
					MessageFormat.format(Messages.ZephyrPlugin_ErrorWhileSaving, ZEPHYR_PROJECT), e);
		}
	}

	public static String getZephyrVersion(final IProject project) {
		final IEclipsePreferences preferences = getProperties(project);
		return preferences.get(ZEPHYR_VERSION, "");
	}

	public static void setZephyrVersion(final String zephyrVersion, final IProject rcpttProject) {
		final IEclipsePreferences properties = getProperties(rcpttProject);
		try {
			properties.put(ZEPHYR_VERSION, zephyrVersion);
			properties.flush();
		} catch (final BackingStoreException e) {
			throw new IllegalStateException(
					MessageFormat.format(Messages.ZephyrPlugin_ErrorWhileSaving, ZEPHYR_VERSION), e);
		}
	}

	public static String getZephyrCycle(final IProject project) {
		final IEclipsePreferences preferences = getProperties(project);
		return preferences.get(ZEPHYR_CYCLE, "");
	}

	public static void setZephyrCycle(final String zephyrCycle, final IProject rcpttProject) {
		final IEclipsePreferences properties = getProperties(rcpttProject);
		try {
			properties.put(ZEPHYR_CYCLE, zephyrCycle);
			properties.flush();
		} catch (final BackingStoreException e) {
			throw new IllegalStateException(MessageFormat.format(Messages.ZephyrPlugin_ErrorWhileSaving, ZEPHYR_CYCLE),
					e);
		}
	}

	private static IEclipsePreferences getProperties(final IProject project) {
		return new ProjectScope(project).getNode(PLUGIN_ID);
	}
}
