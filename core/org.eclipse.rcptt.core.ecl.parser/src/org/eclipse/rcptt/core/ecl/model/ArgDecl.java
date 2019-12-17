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

import java.io.IOException;
import java.io.StringWriter;

import org.eclipse.rcptt.ecl.doc.EclDocWriter;

public class ArgDecl extends VarDecl {

	public ArgDecl(String name, SrcLoc location) {
		super(name, location);
	}

	public ProcDecl parent;

	@Override
	public String doc() {
		StringWriter sw = new StringWriter();
		EclDocWriter dw = new EclDocWriter(sw);

		try {
			dw.text(String.format("Argument <b>%s</b>", name));
			if (hasDefaultValue && simpleValue != null) {
				dw.dl();
				dw.dt("Default value:");
				dw.dd(simpleValue.isEmpty() ? "&lt;empty string&gt;" : simpleValue);
				dw.close();
			}
			if (isInput) {
				dw.text("<p>This parameter is marked as <i>input</i> parameter and may be omited." +
						" In this case, actual argument value will be taken from the pipe. " +
						"Typically, that will be a result of the previous command execution.</p>");
			}
			dw.finish();
		} catch (IOException e) {
			return null;
		}
		return sw.toString();
	}
}
