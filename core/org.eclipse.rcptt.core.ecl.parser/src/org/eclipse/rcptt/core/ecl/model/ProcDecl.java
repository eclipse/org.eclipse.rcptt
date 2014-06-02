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
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.rcptt.ecl.doc.EclDocWriter;

public class ProcDecl extends Declaration {

	public ProcDecl(String name, SrcLoc location) {
		super(name, location);
	}

	private Map<String, ArgDecl> args = new LinkedHashMap<String, ArgDecl>();

	public ArgDecl[] getArgs() {
		return args.values().toArray(new ArgDecl[args.size()]);
	}

	public void addArg(ArgDecl param) {
		param.parent = this;
		param.container = this.container;
		args.put(param.name, param);
	}

	public int argCount() {
		return args.size();
	}

	public ArgDecl resolveArg(String name) {
		return args.get(name);
	}

	private ArgDecl getInputArg() {
		for (ArgDecl arg : args.values()) {
			if (arg.isInput) {
				return arg;
			}
		}
		return null;
	}

	@Override
	public String doc() {
		StringWriter sw = new StringWriter();
		EclDocWriter dw = new EclDocWriter(sw);

		try {
			dw.text(String.format("Procedure <b>%s</b>", name));
			ArgDecl input = getInputArg();
			dw.dl();
			if (input != null) {
				dw.dt("Input:");
				dw.dd();
				writeArg(input, dw);
				dw.close(); // dd
			}
			if (args.size() > (input == null ? 0 : 1)) {
				dw.dt("Arguments:");
				for (ArgDecl arg : args.values()) {
					if (arg == input) {
						continue;
					}
					dw.dd();
					writeArg(arg, dw);
					dw.close();// dd
				}
			}
			String path = getResourcePath(container.getResource());
			if (path != null) {
				dw.dt("Defined in:");
				dw.dd(path);
			}
			dw.close(); // dl
		} catch (IOException e) {
			return null;
		}
		return sw.toString();

	}

	private void writeArg(ArgDecl arg, EclDocWriter writer) throws IOException {
		writer.b(arg.name);
		if (arg.hasDefaultValue) {
			writer.raw(" optional");
		}
		if (arg.simpleValue != null) {
			writer.raw(" = ");
			writer.raw(defaultValueForDoc(arg.simpleValue));
		}
	}
}
