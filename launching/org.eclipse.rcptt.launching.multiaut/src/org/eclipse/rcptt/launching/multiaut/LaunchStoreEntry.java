/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.launching.multiaut;

import static org.eclipse.rcptt.launching.multiaut.MultiAutLaunchPlugin.logWarn;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

/**
 * Persistence entry
 */
public class LaunchStoreEntry {
	public LaunchStoreEntry(String testId, String autName, boolean restart) {
		this.testId = testId;
		this.autName = autName;
		this.restart = restart;
	}

	public final boolean restart;
	public final String autName;
	public final String testId;

	public static JsonObject toJson(LaunchStoreEntry entry) {
		JsonObject result = new JsonObject();
		result.addProperty(PROP_TEST, entry.testId);
		result.addProperty(PROP_AUT, entry.autName);
		result.addProperty(PROP_RESTART, entry.restart);
		return result;
	}

	public static LaunchStoreEntry fromJson(JsonElement element) {
		if (!element.isJsonObject()) {
			return UNITIALIZED;
		}

		JsonObject object = (JsonObject) element;
		return new LaunchStoreEntry(getSafeString(object, PROP_TEST, null),
				getSafeString(object, PROP_AUT, null),
				getSafeBool(object, PROP_RESTART, false));
	}

	public static LaunchStoreEntry[] entriesFromConfig(ILaunchConfiguration config) {
		String jsonString = null;
		try {
			jsonString = config.getAttribute(ATTR_ENTRIES, "[]");
		} catch (CoreException e) {
			logWarn(e, "Error getting attribute from config %s. Empty list will be used.", config.getName());
			return NO_ENTRIES;
		}
		JsonElement element = null;
		try {
			element = new JsonParser().parse(jsonString);
		} catch (JsonParseException e) {
			logWarn(e, "Error parsing json from config %s. Empty list will be used.", config.getName());
			return NO_ENTRIES;
		}

		if (!element.isJsonArray()) {
			logWarn("json is not an array in config %s. Empty list will be used.", config.getName());
			return NO_ENTRIES;
		}

		JsonArray entries = (JsonArray) element;
		List<LaunchStoreEntry> result = new ArrayList<LaunchStoreEntry>();
		for (JsonElement entry : entries) {
			result.add(fromJson(entry));
		}
		return result.toArray(new LaunchStoreEntry[result.size()]);
	}

	public static void entriesToConfig(LaunchStoreEntry[] entries, ILaunchConfigurationWorkingCopy config) {
		JsonArray array = new JsonArray();
		for (LaunchStoreEntry entry : entries) {
			array.add(toJson(entry));
		}
		config.setAttribute(ATTR_ENTRIES, array.toString());
	}

	private static String getSafeString(JsonObject object, String property, String def) {
		if (!object.has(property)) {
			return def;
		}
		try {
			return object.get(property).getAsString();
		} catch (Exception e) {
			return def;
		}
	}

	private static boolean getSafeBool(JsonObject object, String property, boolean def) {
		if (!object.has(property)) {
			return def;
		}
		try {
			return object.get(property).getAsBoolean();
		} catch (Exception e) {
			return def;
		}
	}

	private static final LaunchStoreEntry UNITIALIZED = new LaunchStoreEntry(null, null, false);
	private static final LaunchStoreEntry[] NO_ENTRIES = new LaunchStoreEntry[0];
	private static final String PROP_TEST = "testId";
	private static final String PROP_AUT = "autName";
	private static final String PROP_RESTART = "restart";
	private static final String ATTR_ENTRIES = "q7.multilaunch.entries";
}
