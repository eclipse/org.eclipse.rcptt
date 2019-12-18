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
package org.eclipse.rcptt.ui.panels.assertion;

import java.util.ArrayList;
import java.util.List;

public class AssertGroup {
	private final String name;
	private final List<Object> asserts;

	public AssertGroup(String name, List<Object> asserts) {
		this.name = name;
		this.asserts = new ArrayList<Object>(asserts);
	}

	public String getName() {
		return name;
	}

	public List<Object> getAsserts() {
		return asserts;
	}
}
