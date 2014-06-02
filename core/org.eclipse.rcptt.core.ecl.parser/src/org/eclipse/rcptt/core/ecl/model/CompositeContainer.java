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

import java.util.LinkedHashMap;
import java.util.Map;

public class CompositeContainer implements IDeclContainer {
	private IDeclContainer[] children;

	public CompositeContainer(IDeclContainer... children) {
		this.children = children;
	}

	public void addProc(ProcDecl proc) {
		throw new UnsupportedOperationException();
	}

	public void addVar(VarDecl var) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ProcDecl[] getProcs() {
		return getProcMap().values().toArray(new ProcDecl[0]);
	}

	@Override
	public VarDecl[] getVars() {
		return getVarMap().values().toArray(new VarDecl[0]);
	}

	@Override
	public ProcDecl resolveProc(String name) {
		for (IDeclContainer child : children) {
			ProcDecl result = child.resolveProc(name);
			if (result != null) {
				return result;
			}
		}
		return null;
	}

	public VarDecl resolveVar(String name) {
		for (IDeclContainer child : children) {
			VarDecl result = child.resolveVar(name);
			if (result != null) {
				return result;
			}
		}
		return null;
	}

	private Map<String, VarDecl> getVarMap() {
		Map<String, VarDecl> result = new LinkedHashMap<String, VarDecl>();
		for (IDeclContainer child : children) {
			for (VarDecl var : child.getVars()) {
				if (!result.containsKey(var.name)) {
					result.put(var.name, var);
				}
			}
		}
		return result;
	}

	private Map<String, ProcDecl> getProcMap() {
		Map<String, ProcDecl> result = new LinkedHashMap<String, ProcDecl>();
		for (IDeclContainer child : children) {
			for (ProcDecl proc : child.getProcs()) {
				if (!result.containsKey(proc.name)) {
					result.put(proc.name, proc);
				}
			}
		}
		return result;
	}

	@Override
	public String getResource() {
		return null;
	}
}
