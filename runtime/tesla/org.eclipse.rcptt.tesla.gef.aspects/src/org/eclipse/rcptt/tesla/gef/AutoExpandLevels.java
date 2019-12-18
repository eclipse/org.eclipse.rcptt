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
package org.eclipse.rcptt.tesla.gef;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.gef.tools.AbstractTool;

public class AutoExpandLevels {
	private static Map<Object, Integer> counter = new WeakHashMap<Object, Integer>();

	public static boolean check(Object tool) {
		Integer integer = counter.get(tool);
		if (integer == null) {
			counter.put(tool, Integer.valueOf(0));
		}
		if (integer != null) {
			if (integer < 0) {
				return false;
			}
			counter.put(tool, Integer.valueOf(integer.intValue() - 1));
		}
		return true;
	}

	public static void clear(AbstractTool tool) {
		counter.remove(tool);
	}
	public static void clear() {
		counter.clear();
	}
}
