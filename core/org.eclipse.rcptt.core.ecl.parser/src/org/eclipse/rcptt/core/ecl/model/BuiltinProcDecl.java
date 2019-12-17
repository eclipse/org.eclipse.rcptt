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
package org.eclipse.rcptt.core.ecl.model;

import org.eclipse.rcptt.ecl.doc.EclDocCommand;
import org.eclipse.rcptt.ecl.doc.EclDocParameter;
import org.eclipse.rcptt.ecl.doc.EclDocWriter;

public class BuiltinProcDecl extends ProcDecl {

	protected EclDocCommand doc;

	public BuiltinProcDecl(EclDocCommand cmd, BuiltinContainer container) {
		super(cmd.getName(), null);
		this.container = container;
		this.doc = cmd;
		for (EclDocParameter param : cmd.getParameters()) {
			if (!param.isInternal()) {
				this.addArg(new BuiltinParamDecl(param, this));
			}
		}
	}

	@Override
	public String doc() {
		return EclDocWriter.writeToString(doc, "Error while formating documentation.");
	}

}
