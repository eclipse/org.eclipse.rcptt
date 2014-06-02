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
package org.eclipse.rcptt.tesla.internal.core.processing;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;

public class ElementGenerator {
	private Map<String, Integer> varCounters = new HashMap<String, Integer>();

	public synchronized Element generate(String kind) {
		String var = nextValue(kind);
		Element e = RawFactory.eINSTANCE.createElement();
		e.setKind(kind);
		e.setId(var);
		return e;
	}

	public synchronized String nextValue(String kind) {
		Integer val = varCounters.get(kind);
		if (val == null) {
			val = 0;
		}
		String var = kind + val;
		varCounters.put(kind, ++val);
		return var;
	}

	public synchronized void updateToNext(Element g) {
		g.setId(nextValue(g.getKind()));
	}

}
