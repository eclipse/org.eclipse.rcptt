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
package org.eclipse.rcptt.ctx.extensions;

import org.eclipse.rcptt.core.ecl.model.BaseContainer;
import org.eclipse.rcptt.core.ecl.model.ProcDecl;
import org.eclipse.rcptt.core.ecl.model.SrcLoc;
import org.eclipse.rcptt.core.ecl.model.VarDecl;
import org.eclipse.rcptt.parameters.Parameter;
import org.eclipse.rcptt.parameters.ParametersContext;

public class ParamContextContainer extends BaseContainer {
	public ParamContextContainer(ParametersContext ctx) {
		this.resource = ctx.getId();
		for (int i = 0; i < ctx.getParameters().size(); i++) {
			super.addVar(new ParamVarDecl(ctx.getParameters().get(i), i, this));
		}
	}

	@Override
	public void addVar(VarDecl var) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addProc(ProcDecl proc) {
		throw new UnsupportedOperationException();
	}

	private static class ParamVarDecl extends VarDecl {
		public ParamVarDecl(Parameter param, int index, ParamContextContainer parent) {
			super(param.getName(), new SrcLoc(index, -1));
			this.container = parent;
			this.isInput = false;
			this.hasDefaultValue = true;
			this.simpleValue = param.getValue();
			this.isGlobal = true;
		}

		@Override
		public String doc() {
			return String.format("<p>Parameter <b>%s</b></p>" +
					"<dl>" +
					"	<dt>Value:</dt>" +
					"	<dd>%s</dd>" +
					"	<dt>Defined in:</dt>" +
					"	<dd>%s</dd>" +
					"</dl>", name, simpleValue, getResourcePath(container.getResource()));
		}
	}
}
