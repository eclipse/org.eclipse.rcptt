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
package org.eclipse.rcptt.tesla.internal.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;

public class SWTElementMapper extends BasicElementMapper<SWTUIElement> {
	private static Map<String, SWTElementMapper> mappers = new HashMap<String, SWTElementMapper>();

	public synchronized static SWTElementMapper getMapper(String id) {
		SWTElementMapper swtElementMapper = mappers.get(id);
		if (swtElementMapper == null) {
			swtElementMapper = new SWTElementMapper();
			mappers.put(id, swtElementMapper);
		}
		return swtElementMapper;
	}

	public synchronized static void remove(String id) {
		mappers.remove(id);
	}

}
