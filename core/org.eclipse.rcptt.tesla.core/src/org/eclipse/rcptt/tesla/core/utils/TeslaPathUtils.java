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
package org.eclipse.rcptt.tesla.core.utils;

import java.util.List;

public class TeslaPathUtils {

	public static String makePathFromList(List<String> path) {
		StringBuilder pathStr = new StringBuilder();
		for (String segment : path) {
			if (pathStr.length() != 0)
				pathStr.append("/");
			segment = segment.replace("/", "\\/");
			pathStr.append(segment);
		}
		return pathStr.toString();
	}

}
