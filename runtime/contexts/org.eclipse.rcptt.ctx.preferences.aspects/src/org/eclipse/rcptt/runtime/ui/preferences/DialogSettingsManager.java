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
package org.eclipse.rcptt.runtime.ui.preferences;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.osgi.framework.Bundle;

public class DialogSettingsManager {
	private static DialogSettingsManager theInstance;
	private final Map<String, IDialogSettings> settings;

	private DialogSettingsManager() {
		settings = new HashMap<String, IDialogSettings>();
	}

	public static DialogSettingsManager getInstance() {
		if (theInstance == null) {
			theInstance = new DialogSettingsManager();
		}
		return theInstance;
	}

	public IDialogSettings getSettings(Bundle bundle) {
		return settings.get(getKey(bundle));
	}

	public void addSettings(Bundle bundle, IDialogSettings dialogSettings) {
		settings.put(getKey(bundle), dialogSettings);
	}

	public void removeSettings(Bundle bundle) {
		settings.remove(getKey(bundle));
	}

	private String getKey(Bundle bundle) {
		// eclipse 3.4 compatibility:
		// getVersion().toString() replaced with
		// getHeaders().get("Bundle-Version")
		return bundle.getSymbolicName() + ":" + bundle.getHeaders().get("Bundle-Version");
	}
}
