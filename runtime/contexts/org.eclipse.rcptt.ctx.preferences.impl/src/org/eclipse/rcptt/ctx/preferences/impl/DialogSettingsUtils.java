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
package org.eclipse.rcptt.ctx.preferences.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.rcptt.internal.preferences.PrefUtils;
import org.eclipse.rcptt.preferences.ListPrefData;
import org.eclipse.rcptt.preferences.PrefData;
import org.eclipse.rcptt.preferences.PrefNode;
import org.eclipse.rcptt.preferences.PreferencesFactory;
import org.eclipse.rcptt.preferences.StringPrefData;
import org.eclipse.rcptt.runtime.ui.preferences.DialogSettingsManager;
import org.osgi.framework.Bundle;

@SuppressWarnings("restriction")
public final class DialogSettingsUtils {

	private static final String FN_DIALOG_SETTINGS = "dialog_settings.xml";

	private DialogSettingsUtils() {
	}

	public static void applyDialogSettings(Bundle bundle, PrefNode prefNode)
			throws IOException {
		IDialogSettings settings = getDialogSettings(bundle);

		if (settings != null) {
			applyPrefData(prefNode, settings);
			List<PrefNode> nodes = prefNode.getChilds();
			for (PrefNode node : nodes) {
				applyDialogSettings(settings, node);
			}

			if (bundle.getState() != Bundle.ACTIVE
					|| DialogSettingsManager.getInstance().getSettings(bundle) == null) {
				saveDialogSettings(bundle, settings);
			}
		}
	}

	public static PrefNode collectDialogSettings(Bundle bundle)
			throws IOException {
		IDialogSettings settings = getDialogSettings(bundle);
		if (settings != null) {
			return convertDialogSettings(settings);
		}

		return null;
	}

	private static void applyDialogSettings(IDialogSettings parentSettings,
			PrefNode prefNode) {
		IDialogSettings settings = parentSettings
				.getSection(prefNode.getName());
		if (settings == null) {
			settings = parentSettings.addNewSection(prefNode.getName());
		}

		applyPrefData(prefNode, settings);

		for (PrefNode child : prefNode.getChilds()) {
			applyDialogSettings(settings, child);
		}
	}

	private static void applyPrefData(PrefNode node, IDialogSettings settings) {
		for (PrefData data : node.getData()) {
			if (data instanceof StringPrefData) {
				StringPrefData stringData = (StringPrefData) data;
				PrefUtils.decodeWorkspaceLocation(stringData);
				PrefUtils.substituteVariables(stringData);
				settings.put(stringData.getKey(), stringData.getValue());
			} else if (data instanceof ListPrefData) {
				ListPrefData listData = (ListPrefData) data;
				EList<String> valuesList = listData.getValues();
				String[] values = valuesList.toArray(new String[valuesList
						.size()]);
				for (int i = 0; i < values.length; i++) {
					values[i] = PrefUtils.decodeWorkspaceLocation(values[i]);
					values[i] = PrefUtils.substituteVariables(values[i]);
				}
				settings.put(listData.getKey(), values);
			}
		}
	}

	private static IDialogSettings getDialogSettings(Bundle bundle)
			throws IOException {
		IDialogSettings settings = null;

		if (Bundle.ACTIVE == bundle.getState()) {
			IDialogSettings dialogSettings = DialogSettingsManager
					.getInstance().getSettings(bundle);
			if (dialogSettings != null) {
				settings = dialogSettings;
			}
		}

		if (settings == null) {
			settings = loadDialogSettings(bundle);
		}

		return settings;
	}

	private static PrefNode convertDialogSettings(IDialogSettings settings) {
		List<PrefNode> childNodes = null;
		List<PrefData> data = null;

		IDialogSettings[] childs = settings.getSections();
		for (IDialogSettings child : childs) {
			PrefNode childNode = convertDialogSettings(child);
			if (childNode != null) {
				if (childNodes == null) {
					childNodes = new ArrayList<PrefNode>();
				}
				childNodes.add(childNode);
			}
		}

		Object[] itemKeys = getItemKeys(settings);
		Object[] arrayItemKeys = getArrayItemKeys(settings);
		if (itemKeys.length > 0 || arrayItemKeys.length > 0) {
			data = new ArrayList<PrefData>();

			for (Object key : itemKeys) {
				String itemKey = (String) key;
				StringPrefData stringData = PreferencesFactory.eINSTANCE
						.createStringPrefData();
				stringData.setKey(itemKey);
				String value = settings.get(itemKey);
				value = PrefUtils.encodeWorkspaceLocation(value);
				stringData.setValue(value);
				data.add(stringData);
			}

			for (Object key : arrayItemKeys) {
				String arrayItemKey = (String) key;
				ListPrefData listPrefData = PreferencesFactory.eINSTANCE
						.createListPrefData();
				listPrefData.setKey(arrayItemKey);
				String[] values = settings.getArray(arrayItemKey);
				for (String value : values) {
					value = PrefUtils.encodeWorkspaceLocation(value);
					listPrefData.getValues().add(value);
				}
				data.add(listPrefData);
			}
		}

		if (childNodes != null || data != null) {
			PrefNode prefNode = PreferencesFactory.eINSTANCE.createPrefNode();
			prefNode.setName(settings.getName());
			if (childNodes != null) {
				prefNode.getChilds().addAll(childNodes);
			}
			if (data != null) {
				prefNode.getData().addAll(data);
			}
			return prefNode;
		}
		return null;
	}

	@SuppressWarnings(value = { "rawtypes" })
	private static Object[] getItemKeys(IDialogSettings settings) {
		if (settings instanceof DialogSettings) {
			Map items = (Map) getPrivateFieldValue(settings,
					DialogSettings.class, "items");
			return items.keySet().toArray();
		}
		return new String[0];
	}

	@SuppressWarnings(value = { "rawtypes" })
	private static Object[] getArrayItemKeys(IDialogSettings settings) {
		if (settings instanceof DialogSettings) {
			Map items = (Map) getPrivateFieldValue(settings,
					DialogSettings.class, "arrayItems");
			return items.keySet().toArray();
		}
		return new String[0];
	}

	private static Object getPrivateFieldValue(Object object,
			Class<?> targetClass, String fieldName) {
		try {
			Field field = targetClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(object);
		} catch (NoSuchFieldException e) {
			Activator.log(e);
		} catch (IllegalAccessException e) {
			Activator.log(e);
		}
		return null;
	}

	private static IDialogSettings loadDialogSettings(Bundle bundle)
			throws IOException {
		IPath dataLocation = getStateLocationOrNull(bundle);

		if (dataLocation != null) {
			String readWritePath = dataLocation.append(FN_DIALOG_SETTINGS)
					.toOSString();
			File settingsFile = new File(readWritePath);
			if (settingsFile.exists()) {
				try {
					IDialogSettings settings = new DialogSettings(
							bundle.getSymbolicName());
					settings.load(readWritePath);
					return settings;
				} catch (IOException e) {
					Activator.log(e);
				}
				return new DialogSettings(bundle.getSymbolicName());
			}
		}

		URL dsURL = FileLocator
				.find(bundle, new Path(FN_DIALOG_SETTINGS), null);
		if (dsURL == null) {
			// File are not exist. Create new empty settings.
			return new DialogSettings(bundle.getSymbolicName());
		}

		InputStream is = null;
		try {
			is = dsURL.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "utf-8"));
			IDialogSettings settings = new DialogSettings(
					bundle.getSymbolicName());
			settings.load(reader);
			return settings;
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
			}
		}
	}

	private static IPath getStateLocationOrNull(Bundle bundle) {
		try {
			// TODO: creates the location if it doesn't exist
			// return Platform.getStateLocation(bundle);
			return InternalPlatform.getDefault()
					.getStateLocation(bundle, false);
		} catch (IllegalStateException e) {
			return null;
		}
	}

	private static void saveDialogSettings(Bundle bundle,
			IDialogSettings dialogSettings) throws IOException {
		if (dialogSettings == null) {
			return;
		}

		IPath path = getStateLocationOrNull(bundle);
		if (path == null) {
			return;
		}
		String readWritePath = path.append(FN_DIALOG_SETTINGS).toOSString();
		File file = path.toFile();
		file.mkdirs();
		dialogSettings.save(readWritePath);
	}

	public static void clearDialogSettings(Bundle bundle) {
		try {
			IDialogSettings settings = null;
			if (Bundle.ACTIVE == bundle.getState()) {
				IDialogSettings dialogSettings = DialogSettingsManager
						.getInstance().getSettings(bundle);
				if (dialogSettings != null) {
					settings = dialogSettings;
				}
			}

			if (settings != null && settings instanceof DialogSettings) {
				setDialogSettingsFieldTo(settings, "items");
				setDialogSettingsFieldTo(settings, "arrayItems");
				setDialogSettingsFieldTo(settings, "sections");
			}
			// Remove dialog settings file if exists
			IPath path = getStateLocationOrNull(bundle);
			if (path == null) {
				return;
			}
			File readWritePath = path.append(FN_DIALOG_SETTINGS).toFile();
			if (readWritePath.exists()) {
				readWritePath.delete();
			}
		} catch (Throwable e) {
			Activator.log(e);
		}
	}

	@SuppressWarnings("rawtypes")
	private static void setDialogSettingsFieldTo(IDialogSettings settings,
			String name) throws NoSuchFieldException, IllegalAccessException {
		Field field = DialogSettings.class.getDeclaredField(name);
		field.setAccessible(true);
		field.set(settings, new HashMap());
	}
}
