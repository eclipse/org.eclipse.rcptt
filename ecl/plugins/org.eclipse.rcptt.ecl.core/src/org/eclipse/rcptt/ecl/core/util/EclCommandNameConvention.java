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
package org.eclipse.rcptt.ecl.core.util;

public class EclCommandNameConvention {
	public static String toCommandName(String scriptletName) {
		StringBuffer result = new StringBuffer();
		for (int index = 0; index < scriptletName.length(); index++) {
			char symbol = scriptletName.charAt(index);
			if (Character.isUpperCase(symbol)) {
				if (index != 0)
					result.append('-');
				symbol = Character.toLowerCase(symbol);
			}
			result.append(symbol);
		}

		return result.toString();
	}

	public static String toScriptletName(String commandName) {
		StringBuffer result = new StringBuffer();
		for (int index = 0; index < commandName.length(); index++) {
			char ch = commandName.charAt(index);
			if (ch == '-') {
				index++;
				if (index >= commandName.length())
					return null;
				ch = Character.toUpperCase(commandName.charAt(index));
			}
			if (index == 0)
				ch = Character.toUpperCase(ch);
			result.append(ch);
		}
		return result.toString();
	}
}
