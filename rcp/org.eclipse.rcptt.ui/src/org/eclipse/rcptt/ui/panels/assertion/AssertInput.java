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
package org.eclipse.rcptt.ui.panels.assertion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class AssertInput {
	private static final List<AssertGroup> empty_list = new ArrayList<AssertGroup>();
	public static final AssertInput EMPTY = new AssertInput(empty_list, null);

	private final List<AssertGroup> asserts;
	private final Map<Object, AssertGroup> parents = new HashMap<Object, AssertGroup>();
	private Element element;

	private void indexChildren(AssertGroup group) {
		for (Object a : group.getAsserts()) {
			parents.put(a, group);
			if (a instanceof AssertGroup) {
				indexChildren((AssertGroup) a);
			}
		}
	}

	public AssertInput(List<AssertGroup> asserts, Element element) {
		this.asserts = asserts;
		this.element = element;

		reindex();
	}

	public Element getElement() {
		return element;
	}

	public void reindex() {
		parents.clear();
		for (AssertGroup group : asserts) {
			indexChildren(group);
		}
	}

	public AssertGroup getParent(Object a) {
		return parents.get(a);
	}

	public List<AssertGroup> getAsserts() {
		return asserts;
	}
}
