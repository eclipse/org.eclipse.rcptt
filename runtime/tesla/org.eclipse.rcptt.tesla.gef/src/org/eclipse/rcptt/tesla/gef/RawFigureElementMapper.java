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

public class RawFigureElementMapper extends
		BasicElementMapper<RawFigureUIElement> {
	private static Map<String, RawFigureElementMapper> mappers = new HashMap<String, RawFigureElementMapper>();

	public synchronized static RawFigureElementMapper getMapper(String id) {
		RawFigureElementMapper rawMapper = mappers.get(id);
		if (rawMapper == null) {
			rawMapper = new RawFigureElementMapper();
			FigureElementMapper figureMapper = FigureElementMapper
					.getMapper(id);
			// Make generator same, because we have same element kind
			rawMapper.setGenerator(figureMapper.getGenerator());
			mappers.put(id, rawMapper);
		}
		return rawMapper;
	}

	public synchronized static void remove(String id) {
		mappers.remove(id);
	}

}
