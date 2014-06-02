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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.jface.bindings.keys.KeyLookupFactory;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.formatting.KeyFormatterFactory;

public class KeyStrokeUtil {

	public static String formatKey(KeyStroke key) {
		return KeyFormatterFactory.getFormalKeyFormatter().format(key);
	}

	public static String formatModifier(KeyStroke key) {
		String mask = formatKey(key);
		int instance = KeyLookupFactory.getDefault().formalModifierLookup(
				mask.toUpperCase());
		if (instance == KeyStroke.NO_KEY)
			return String.valueOf(key.getNaturalKey());
		return mask;
	}

	public static String formatKeyWithMeta(int mask, int keyCode, int meta) {
		if (meta == 0) {
			return KeyFormatterFactory.getFormalKeyFormatter().format(
					KeyStroke.getInstance(mask, keyCode));
		} else {
			String strKey = "";

			final int M1 = 1;
			final int M2 = 2;
			final int M3 = 4;
			final int M4 = 8;

			if ((meta & M1) != 0)
				strKey += "M1";
			if ((meta & M2) != 0) {
				if (!strKey.equals(""))
					strKey += "+";
				strKey += "M2";
			}
			if ((meta & M3) != 0) {
				if (!strKey.equals(""))
					strKey += "+";
				strKey += "M3";
			}
			if ((meta & M4) != 0) {
				if (!strKey.equals(""))
					strKey += "+";
				strKey += "M4";
			}
			if (!strKey.equals(""))
				strKey += "+";
			strKey += KeyFormatterFactory.getFormalKeyFormatter().format(
					keyCode);
			return strKey;
		}
	}

	private KeyStrokeUtil() {
		throw new AssertionError();
	}
}
