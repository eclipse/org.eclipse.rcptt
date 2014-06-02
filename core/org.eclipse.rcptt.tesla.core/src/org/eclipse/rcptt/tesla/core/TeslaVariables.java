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
package org.eclipse.rcptt.tesla.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

public class TeslaVariables {
	private static final String TESLA_VARIABLES_KEY = "org.eclipse.rcptt.tesla.variables.";

	private static final Map<String, String> variables = new HashMap<String, String>();

	private static final Map<String, String> defaults = new HashMap<String, String>();
	static {
		defaults.put("q7.current_test", "unnamed-test");
	}

	public static void updateFromFeatureList(EList<String> list) {
		variables.clear();

		for (String s : list) {
			if (!s.startsWith(TESLA_VARIABLES_KEY))
				continue;
			int equalsPos = s.indexOf('=');
			if (equalsPos < 0)
				continue;

			String name = s.substring(TESLA_VARIABLES_KEY.length(), equalsPos);
			String value = s.substring(equalsPos + 1);

			variables.put(name, value);
		}
	}

	public static String getValueOf(String name) {
		String value = variables.get(name);
		if (value == null)
			return defaults.get(name);
		return value;
	}
}
