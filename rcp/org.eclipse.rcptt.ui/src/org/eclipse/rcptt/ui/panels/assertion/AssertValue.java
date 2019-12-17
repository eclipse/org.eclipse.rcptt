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
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.rcptt.tesla.core.protocol.Assert;
import org.eclipse.rcptt.tesla.core.protocol.AssertKind;

public enum AssertValue {
	BOOLEAN(AssertKind.EQUALS, AssertKind.NOT_EQUALS) {
		@Override
		protected boolean matches(String type) {
			return "EBoolean".equals(type) || "EBooleanObject".equals(type); //$NON-NLS-1$ //$NON-NLS-2$
		}
	},
	INTEGER(AssertKind.EQUALS, AssertKind.NOT_EQUALS) {
		@Override
		protected boolean matches(String type) {
			return "EInt".equals(type) || "EIntObject".equals(type); //$NON-NLS-1$ //$NON-NLS-2$
		}
	},
	STRING(AssertKind.EQUALS, AssertKind.NOT_EQUALS, AssertKind.CONTAINS,
			AssertKind.NOT_CONTAINS, AssertKind.IS_EMPTY, AssertKind.NOT_EMPTY),

	CONTAINS_TEXT(AssertKind.IMAGE_CONTAINS_TEXT), CONTAINS_IMAGE(
			AssertKind.CONTAINS_IMAGE);

	private List<String> names;

	public static AssertValue forAssert(Assert a) {
		if (a.getKind().equals(AssertKind.CONTAINS_IMAGE)) {
			return AssertValue.CONTAINS_IMAGE;
		}
		if (a.getKind().equals(AssertKind.IMAGE_CONTAINS_TEXT)) {
			return AssertValue.CONTAINS_TEXT;
		}
		EClassifier type = a.getValueType();
		if (type == null)
			return STRING;
		for (AssertValue v : values()) {
			if (v.matches(type.getName()))
				return v;
		}
		// Default
		return STRING;
	}

	private AssertValue(AssertKind... values) {
		names = new ArrayList<String>();
		for (AssertKind v : values) {
			names.add(v.getLiteral());
		}
	}

	public String[] getOperationNames() {
		return names.toArray(new String[names.size()]);
	}

	public int getOperationIndex(String name) {
		return names.indexOf(name);
	}

	protected boolean matches(String type) {
		return true;
	}
}
