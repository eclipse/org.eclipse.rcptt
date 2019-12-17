/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.model.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.core.model.IQ7Element;

public class Q7NamedElementCollector implements IIndexRequestor {
	private List<IQ7Element> elements = new ArrayList<IQ7Element>();

	public void acceptMatch(IQ7Element q7Element, String key, String value) {
		elements.add(q7Element);
	}

	public List<IQ7Element> getElements() {
		return elements;
	}
}
