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
package org.eclipse.rcptt.tesla.nebula.ecl;

import static org.eclipse.rcptt.tesla.core.utils.TeslaPathUtils.makePathFromList;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea;

public abstract class NebulaEmptyAreaQualifiers {

	public static final String TOP = "TOP";
	public static final String LEFT = "LEFT";
	public static final String COLUMN = "COLUMN";


	public static String pathFromSelector(GetEmptyArea s) {
		List<String> path = new ArrayList<String>(2);

		if (s.getColumn() != null) {
			path.add(COLUMN);
			path.add(s.getColumn());
		} else {
			if (s.isTop())
				path.add(TOP);
			if (s.isLeft())
				path.add(LEFT);
		}

		return makePathFromList(path);
	}

}
