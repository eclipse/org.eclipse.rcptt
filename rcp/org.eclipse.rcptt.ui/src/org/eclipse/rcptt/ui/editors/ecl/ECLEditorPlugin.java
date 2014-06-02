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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

import org.eclipse.rcptt.core.ecl.parser.model.OccurrencesSettings;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class ECLEditorPlugin {
	public static final String PLUGIN_ID = "org.eclipse.rcptt.ui.editors.ecl";

	public static final String ECL_CONTENT_ASSIST_DELAY = "ECL_CONTENT_ASSIST_DELAY";
	public static final String ECL_CONTENT_ASSIST_TRIGGERS = "ECL_CONTENT_ASSIST_TRIGGERS";
	public static final String ECL_CONTENT_ASSIST_ACTIVATIONSTATE = "ECL_CONTENT_ASSIST_ACTIVATIONSTATE";
	public static final int DEFAULT_ECL_CONTENT_ASSIST_DELAY = 200;
	public static final String DEFAULT_ECL_CONTENT_ASSIST_TRIGGERS = " -[$";
	public static final int DEFAULT_ECL_CONTENT_ASSIST_ACTIVATION_STATE = 1;

	public static IEclipsePreferences getPreferences() {
		return InstanceScope.INSTANCE.getNode(PLUGIN_ID);
	}

	public static int getECLScriptContentAssistDelay() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.getInt(ECL_CONTENT_ASSIST_DELAY, DEFAULT_ECL_CONTENT_ASSIST_DELAY);
	}

	public static void setECLScriptContentAssistDelay(final int delay) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.putInt(ECL_CONTENT_ASSIST_DELAY, delay);
		try {
			preferences.flush();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static String getECLScriptContentAssistTriggers() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.get(ECL_CONTENT_ASSIST_TRIGGERS, DEFAULT_ECL_CONTENT_ASSIST_TRIGGERS);
	}

	public static void setECLScriptContentAssistTriggers(final String triggers) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.put(ECL_CONTENT_ASSIST_TRIGGERS, triggers);
		try {
			preferences.flush();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean getECLScriptContentAssistActivationState() {
		final IEclipsePreferences preferences = getPreferences();
		return preferences.getInt(ECL_CONTENT_ASSIST_ACTIVATIONSTATE, DEFAULT_ECL_CONTENT_ASSIST_ACTIVATION_STATE) == 1;
	}

	public static void setECLScriptContentAssistActivationState(final int state) {
		final IEclipsePreferences preferences = getPreferences();
		preferences.putInt(ECL_CONTENT_ASSIST_ACTIVATIONSTATE, state);
		try {
			preferences.flush();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private static IEclipsePreferences getPrefs() {
		return InstanceScope.INSTANCE.getNode(PLUGIN_ID);
	}

	public static OccurrencesSettings getMarkSettings() {
		return OccurrencesSettings.fromPrefs(getPreferences());
	}

	public static void setMarkSettings(OccurrencesSettings settings) {
		IEclipsePreferences prefs = getPrefs();
		settings.toPrefs(prefs);
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			Q7UIPlugin.log("Error saving preferences", e);
		}
	}
}
