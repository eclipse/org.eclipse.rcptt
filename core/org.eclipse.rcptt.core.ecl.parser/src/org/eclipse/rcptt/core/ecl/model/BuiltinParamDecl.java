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

import org.eclipse.rcptt.ecl.doc.EclDocParameter;
import org.eclipse.rcptt.ecl.doc.EclDocWriter;

public class BuiltinParamDecl extends ArgDecl {
	protected EclDocParameter doc;

	public BuiltinParamDecl(EclDocParameter param, BuiltinProcDecl parent) {
		super(param.getName(), null);
		this.parent = parent;
		this.doc = param;
		this.isInput = param.isInput();
		this.simpleValue = param.getEFeature().getDefaultValueLiteral();
		this.hasDefaultValue = simpleValue != null;
	}

	@Override
	public String doc() {
		return EclDocWriter.writeToString(doc, "Error while formating documentation.");
	}
}
