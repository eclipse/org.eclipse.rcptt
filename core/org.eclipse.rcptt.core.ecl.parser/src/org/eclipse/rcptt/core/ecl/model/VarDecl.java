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

import java.io.IOException;
import java.io.StringWriter;

import org.eclipse.rcptt.ecl.doc.EclDocWriter;

public class VarDecl extends Declaration {
	public VarDecl(String name, SrcLoc location) {
		super(name, location);
	}

	public boolean isInput;

	public boolean hasDefaultValue;

	public String simpleValue;

	public boolean isGlobal = false;

	@Override
	public String doc() {
		StringWriter sw = new StringWriter();
		EclDocWriter dw = new EclDocWriter(sw);
		try {
			dw.text(String.format("%s variable <b>%s</b>", isGlobal ? "Global" : "Local", name));
			dw.dl();
			if (hasDefaultValue && simpleValue != null) {
				dw.dt("Default value:");
				dw.dd(defaultValueForDoc(simpleValue));
			}
			if (isGlobal) {
				String path = getResourcePath(container.getResource());
				if (path != null) {
					dw.dt("Defined in:");
					dw.dd(path);
				}
			}
			dw.close(); // dl
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
