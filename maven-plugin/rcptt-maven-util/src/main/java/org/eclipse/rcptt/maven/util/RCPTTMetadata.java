/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.maven.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RCPTTMetadata {

	public static final Map<String, String> defaults = new HashMap<String, String>();

	static {
	}

	public static Map<String, String> createDefaults() {
		return new HashMap<String, String>(defaults);
	}

	public static Map<String, String> fillDefaults(Map<String, String> map) {
		Map<String, String> result = createDefaults();
		if (map != null) {
			result.putAll(map);
		}
		return result;
	}

	public static String get(Map<String, String> map, String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return defaults.get(key);
	}

	public static String toString(Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String> entry : map.entrySet()) {
			if (sb.length() > 0) {
				sb.append(";");
			}
			sb.append(String.format("%s=%s", entry.getKey(), entry.getValue()));
		}
		return sb.toString();
	}
}
