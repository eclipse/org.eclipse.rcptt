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
package org.eclipse.rcptt.ecl.core.util;

import java.util.HashMap;
import java.util.Map;

public class EclTypeNameConvention {

	private static final Map<String, String> enameToName = new HashMap<String, String>();
	static {
		enameToName.put("EInt", "Integer");
		enameToName.put("EIntegerObject", "Integer");
		enameToName.put("EBooleanObject", "Boolean");

	}

	public static String toTypeName(String ename) {
		String result = enameToName.get(ename);
		if (result != null)
			return result;

		if (ename.length() > 1 && ename.charAt(0) == 'E'
				&& Character.isUpperCase(ename.charAt(1)))
			return ename.substring(1);

		return ename;
	}

}
