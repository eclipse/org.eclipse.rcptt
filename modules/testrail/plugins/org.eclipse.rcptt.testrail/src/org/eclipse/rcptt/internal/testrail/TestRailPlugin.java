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
package org.eclipse.rcptt.internal.testrail;

import java.io.IOException;
import java.text.MessageFormat;

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

public class TestRailPlugin extends Plugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.testrail"; //$NON-NLS-1$

	public static final String LAUNCH_TESTRUNID = PLUGIN_ID + ".ATTR_TESTRAIL_TESTRUNID";

	public static final String TESTRAIL_STATE = "TESTRAIL_STATE";
	public static final String TESTRAIL_ADDRESS = "TESTRAIL_ADDRESS";
	public static final String TESTRAIL_USERNAME = "TESTRAIL_USERNAME";
	public static final String TESTRAIL_PASSWORD = "TESTRAIL_PASSWORD";
	public static final String TESTRAIL_PROJECTID = "TESTRAIL_PROJECTID";
	public static final String TESTRAIL_USEUNICODE = "TESTRAIL_USEUNICODE";
	public static final int DEFAULT_TESTRAIL_STATE = 0;
	public static final String DEFAULT_TESTRAIL_PROJECTID = "P1";
	public static final int DEFAULT_TESTRAIL_USEUNICODE = 0;

	// The shared instance
	private static TestRailPlugin plugin;

	/**
	 * The constructor
	 */
	public TestRailPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	public static TestRailPlugin getDefault() {
		return plugin;
	}
	
	public static void logInfo(String message) {
		String loggingEnabled = TeslaFeatures.getInstance()
				.getValue(TeslaFeatures.TESTENGINE_LOGS);
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

	public static boolean getTestRailState() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.getInt(TESTRAIL_STATE, DEFAULT_TESTRAIL_STATE) == 1;
	}

	public static void setTestRailState(final int state) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.putInt(TESTRAIL_STATE, state);
		try {
			preferences.flush();
		} catch (final BackingStoreException e) {
			log(MessageFormat.format(Messages.TestRailPlugin_ErrorWhileSaving, TESTRAIL_STATE), e);
		}
	}

	public static String getTestRailAddress() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.get(TESTRAIL_ADDRESS, "");
	}

	public static void setTestRailAddress(final String address) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.put(TESTRAIL_ADDRESS, address);
		try {
			preferences.flush();
		} catch (final BackingStoreException e) {
			log(MessageFormat.format(Messages.TestRailPlugin_ErrorWhileSaving, TESTRAIL_ADDRESS), e);
		}
	}

	public static String getTestRailUsername() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.get(TESTRAIL_USERNAME, "");
	}

	public static void setTestRailUsername(final String username) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.put(TESTRAIL_USERNAME, username);
		try {
			preferences.flush();
		} catch (final BackingStoreException e) {
			log(MessageFormat.format(Messages.TestRailPlugin_ErrorWhileSaving, TESTRAIL_USERNAME), e);
		}
	}

	public static String getTestRailPassword() {
		final ISecurePreferences preferences = getSecurePreferences();
		try {
			return preferences.get(TESTRAIL_PASSWORD, "");
		} catch (final StorageException e) {
			log(MessageFormat.format(Messages.TestRailPlugin_ErrorWhileGetting, TESTRAIL_PASSWORD), e);
			return null;
		}
	}

	public static void setTestRailPassword(final String password) {
		final ISecurePreferences preferences = getSecurePreferences();
		try {
			preferences.put(TESTRAIL_PASSWORD, password, true);
			preferences.flush();
		} catch (final StorageException | IOException e) {
			log(MessageFormat.format(Messages.TestRailPlugin_ErrorWhileSaving, TESTRAIL_PASSWORD), e);
		}
	}

	public static String getTestRailProjectId() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.get(TESTRAIL_PROJECTID, DEFAULT_TESTRAIL_PROJECTID);
	}

	public static void setTestRailProjectId(final String projectId) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.put(TESTRAIL_PROJECTID, projectId);
		try {
			preferences.flush();
		} catch (final BackingStoreException e) {
			log(MessageFormat.format(Messages.TestRailPlugin_ErrorWhileSaving, TESTRAIL_PROJECTID), e);
		}
	}

	public static boolean getTestRailUseUnicode() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.getInt(TESTRAIL_USEUNICODE, DEFAULT_TESTRAIL_USEUNICODE) == 1;
	}

	public static void setTestRailUseUnicode(final int state) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.putInt(TESTRAIL_USEUNICODE, state);
		try {
			preferences.flush();
		} catch (final BackingStoreException e) {
			log(MessageFormat.format(Messages.TestRailPlugin_ErrorWhileSaving, TESTRAIL_USEUNICODE), e);
		}
	}

}
