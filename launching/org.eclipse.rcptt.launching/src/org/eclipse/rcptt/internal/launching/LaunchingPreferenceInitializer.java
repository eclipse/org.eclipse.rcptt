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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.osgi.service.prefs.BackingStoreException;

import org.eclipse.rcptt.launching.Q7Launcher;

public class LaunchingPreferenceInitializer extends
		AbstractPreferenceInitializer {

	@SuppressWarnings("deprecation")
	@Override
	public void initializeDefaultPreferences() {
		IEclipsePreferences preferences = new DefaultScope()
				.getNode(Q7LaunchingPlugin.PLUGIN_ID);
		preferences.putInt(Q7LaunchingPlugin.EXECUTION_TIMEOUT,
				Q7Launcher.DEFAULT_LAUNCH_TIMEOUT);
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			Q7LaunchingPlugin.log(e);
		}
	}

}
