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
package org.eclipse.rcptt.tesla.gef;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rcptt.tesla.internal.ui.BasicElementMapper;

public class FigureElementMapper extends BasicElementMapper<FigureUIElement> {
	private static Map<String, FigureElementMapper> mappers = new HashMap<String, FigureElementMapper>();

	public synchronized static FigureElementMapper getMapper(String id) {
		FigureElementMapper swtElementMapper = mappers.get(id);
		if (swtElementMapper == null) {
			swtElementMapper = new FigureElementMapper();
			mappers.put(id, swtElementMapper);
		}
		return swtElementMapper;
	}

	public synchronized static void remove(String id) {
		mappers.remove(id);
	}
}
