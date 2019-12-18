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

import org.eclipse.rcptt.ecl.doc.EclDocCommand;

public enum BuiltinContainer implements IDeclContainer {
	INSTANCE;

	private BuiltinContainer() {
		storage = new BaseContainer();
		for (EclDocCommand command : EclDocCommand.getAllPublicCommands()) {
			storage.addProc(new BuiltinProcDecl(command, this));
		}
	}

	private BaseContainer storage;

	@Override
	public String getResource() {
		return "built-in";
	}

	@Override
	public ProcDecl resolveProc(String name) {
		return storage.resolveProc(name);
	}

	@Override
	public VarDecl resolveVar(String name) {
		return storage.resolveVar(name);
	}

	@Override
	public ProcDecl[] getProcs() {
		return storage.getProcs();
	}

	@Override
	public VarDecl[] getVars() {
		return storage.getVars();
	}

}
