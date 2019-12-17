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
package org.eclipse.rcptt.tesla.ecl;

import java.util.HashMap;
import java.util.Map;

public class TeslaEclUtils {
	private static Map<String, String> KeyAliasesMap = new HashMap<String, String>();

	static {
		KeyAliasesMap.put("ARROW_UP", "Up");
		KeyAliasesMap.put("ARROW_DOWN", "Down");
		KeyAliasesMap.put("ARROW_LEFT", "Left");
		KeyAliasesMap.put("ARROW_RIGHT", "Right");
		KeyAliasesMap.put("PAGE_UP", "PageUp");
		KeyAliasesMap.put("PAGE_DOWN", "PageDown");
		KeyAliasesMap.put("HOME", "Home");
		KeyAliasesMap.put("END", "End");
		KeyAliasesMap.put("DEL", "Del");
		KeyAliasesMap.put("BS", "BackSpace");
		KeyAliasesMap.put("CR", "Enter");
		KeyAliasesMap.put("SPACE", "Space");
		KeyAliasesMap.put("INSERT", "Insert");
		KeyAliasesMap.put("TAB", "Tab");
		KeyAliasesMap.put("CAPS_LOCK", "CapsLock");
	}

	public static String getKeyAlias(String keyName) {
		String alias = keyName;
		for (Map.Entry<String, String> entry : KeyAliasesMap.entrySet()) {
			if (alias.equals(entry.getKey())) {
				alias = entry.getValue();
			}
			// alias = alias.replace(entry.getKey(), entry.getValue());
		}
		return alias;
	}

	public static String getKeyByAlias(String keyAlias) {
		String keyName = keyAlias;
		for (Map.Entry<String, String> entry : KeyAliasesMap.entrySet()) {
			if (keyName.equals(entry.getValue())) {
				keyName = entry.getKey();
			}
			// keyName = keyName.replace(entry.getValue(), entry.getKey());
		}
		return keyName;
	}
}
