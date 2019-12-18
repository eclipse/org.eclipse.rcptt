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
package org.eclipse.rcptt.ctx.preferences.impl.rap;

import java.io.IOException;

import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;

import org.eclipse.rcptt.internal.preferences.PrefUtils;
import org.eclipse.rcptt.preferences.PrefData;
import org.eclipse.rcptt.preferences.PrefNode;
import org.eclipse.rcptt.preferences.PreferencesFactory;
import org.eclipse.rcptt.preferences.SecurePrefNode;
import org.eclipse.rcptt.preferences.StringPrefData;

public class SecuritySupport {
	public static SecurePrefNode collectSecureSettings()
			throws StorageException {
		ISecurePreferences preferences = SecurePreferencesFactory.getDefault();

		return processSecurePreferences(preferences);

	}

	public static SecurePrefNode processSecurePreferences(
			ISecurePreferences preferences) throws StorageException {
		SecurePrefNode prefNode = PreferencesFactory.eINSTANCE
				.createSecurePrefNode();
		prefNode.setName(preferences.name());

		String[] childNames = preferences.childrenNames();
		for (String childName : childNames) {
			SecurePrefNode childNode = processSecurePreferences(preferences
					.node(childName));
			prefNode.getChilds().add(childNode);
		}

		String[] keys = preferences.keys();
		for (String key : keys) {
			try {
				String value = preferences.get(key, null);
				if (value != null) {
					StringPrefData prefData = PreferencesFactory.eINSTANCE
							.createStringPrefData();
					prefData.setKey(key);
					prefData.setValue(value);
					PrefUtils.encodeWorkspaceLocation(prefData);
					prefNode.getData().add(prefData);
				}
			} catch (StorageException e) {
				// Just log and continue collecting data
				Activator.log(e);
			}
		}

		return prefNode;
	}

	public static void applySecureSettings(SecurePrefNode securePrefNode,
			boolean clean) throws StorageException, IOException {
		ISecurePreferences root = SecurePreferencesFactory.getDefault();
		if (clean) {
			root.clear();
			String[] childs = root.childrenNames();
			for (String child : childs) {
				root.node(child).removeNode();
			}
		}

		applySecureSettings(securePrefNode, root);

		root.flush();
	}

	public static void applySecureSettings(PrefNode prefNode,
			ISecurePreferences secureNode) throws StorageException {
		for (PrefData data : prefNode.getData()) {
			if (data instanceof StringPrefData) {
				StringPrefData stringData = (StringPrefData) data;
				PrefUtils.decodeWorkspaceLocation(stringData);
				secureNode.put(stringData.getKey(), stringData.getValue(),
						false);
			}
		}

		for (PrefNode childNode : prefNode.getChilds()) {
			applySecureSettings(childNode, secureNode.node(childNode.getName()));
		}
	}
}
