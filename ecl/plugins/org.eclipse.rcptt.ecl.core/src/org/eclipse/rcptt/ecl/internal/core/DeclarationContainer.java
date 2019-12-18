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
package org.eclipse.rcptt.ecl.internal.core;

import static java.lang.String.format;
import static org.eclipse.rcptt.ecl.internal.core.CorePlugin.err;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Declaration;

public class DeclarationContainer {
	private final DeclarationContainer parent;

	public DeclarationContainer(DeclarationContainer parent) {
		this.parent = parent;
	}

	private Map<String, Declaration> declarations = new LinkedHashMap<String, Declaration>();

	public synchronized Iterable<Declaration> declarations() {
		return declarations.values();
	}

	public synchronized void declare(String name, Declaration decl)
			throws CoreException {
		declare(name, decl, false);
	}

	public synchronized Declaration lookup(String name) {
		Declaration decl = declarations.get(name);
		if (decl != null) {
			return decl;
		}

		if (parent == null) {
			return null;
		}

		return parent.lookup(name);
	}

	public synchronized void declare(String name, Declaration decl, boolean override) throws CoreException {
		if (declarations.containsKey(name) && !override) {
			throw new CoreException(err(format("'%s' already declared", name)));
		}
		declarations.put(name, decl);
	}

}
