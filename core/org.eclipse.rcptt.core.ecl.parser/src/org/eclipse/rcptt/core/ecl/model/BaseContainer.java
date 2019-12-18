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
package org.eclipse.rcptt.core.ecl.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class BaseContainer implements IDeclContainer {
	protected String resource;

	protected Map<String, ProcDecl> procs = new LinkedHashMap<String, ProcDecl>();
	protected Map<String, VarDecl> vars = new LinkedHashMap<String, VarDecl>();

	/**
	 * adds if no decl with such name
	 */
	public void addProc(ProcDecl proc) {
		if (procs.containsKey(proc.name)) {
			return;
		}
		procs.put(proc.name, proc);
		proc.container = this;
		for (ArgDecl param : proc.getArgs()) {
			param.container = this;
		}
	}

	public void addVar(VarDecl var) {
		if (vars.containsKey(var.name)) {
			return;
		}
		vars.put(var.name, var);
		var.container = this;
	}

	public void addAllVars(Iterable<VarDecl> vars) {
		for (VarDecl var : vars) {
			addVar(var);
		}
	}

	public void addAllProcs(Iterable<ProcDecl> procs) {
		for (ProcDecl proc : procs) {
			addProc(proc);
		}
	}

	@Override
	public ProcDecl[] getProcs() {
		return procs.values().toArray(new ProcDecl[procs.size()]);
	}

	@Override
	public VarDecl[] getVars() {
		return vars.values().toArray(new VarDecl[vars.size()]);
	}

	public int procCount() {
		return procs.size();
	}

	public int varCount() {
		return vars.size();
	}

	@Override
	public ProcDecl resolveProc(String name) {
		return procs.get(name);
	}

	@Override
	public VarDecl resolveVar(String name) {
		return vars.get(name);
	}

	@Override
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
}
