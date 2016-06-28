/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailUtils {
	@SuppressWarnings("rawtypes")
	public static String extractSupers(Class<? extends Object> cl) {
		StringBuilder result = new StringBuilder();
		Class<?> superclass = cl.getSuperclass();
		List<Class> interfaces = new ArrayList<Class>();
		while (superclass != null) {
			if (!superclass.getName().equals("java.lang.Object")) {
				if (result.length() == 0) {
					result.append("extends ");
				} else {
					result.append(", ");
				}
				Class<?>[] ints = superclass.getInterfaces();
				if (ints != null) {
					interfaces.addAll(Arrays.asList(ints));
				}
				result.append(superclass.getName());
			} else {
				break;
			}
			superclass = superclass.getSuperclass();
		}
		Class<?>[] ints = cl.getInterfaces();
		if (ints != null) {
			interfaces.addAll(Arrays.asList(ints));
		}
		if (interfaces.size() > 0) {
			if (result.length() > 0) {
				result.append("\n\t\t\t");
			}
			result.append("implements ");
			int i = 0;
			for (Class<?> class1 : interfaces) {
				if (i != 0) {
					result.append(", ");
				}
				result.append(class1.getName());
				i++;
			}
		}

		return result.toString();
	}
}
