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
package org.eclipse.rcptt.core.ecl.model;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;

public class Declaration {
	public Declaration(String name, SrcLoc location) {
		this.name = name;
		this.location = location;
	}

	public final SrcLoc location;

	public final String name;

	public IDeclContainer container;

	public String doc() {
		return null;
	}

	protected static String getResourcePath(String resourceId) {
		IQ7NamedElement element = Q7SearchCore.findById(resourceId);
		if (element == null) {
			return null;
		}
		return element.getResource().getFullPath().toString();
	}

	protected static String defaultValueForDoc(String value) {
		return value.isEmpty() ? "&lt;empty string&gt;" : value;
	}
}
