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
package org.eclipse.rcptt.core.ecl.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.eclipse.rcptt.core.ecl.model.ArgDecl;
import org.eclipse.rcptt.core.ecl.model.BaseContainer;
import org.eclipse.rcptt.core.ecl.model.ProcDecl;
import org.eclipse.rcptt.core.ecl.model.SrcLoc;
import org.eclipse.rcptt.core.ecl.model.VarDecl;
import org.eclipse.rcptt.core.ecl.parser.ast.Id;
import org.eclipse.rcptt.core.ecl.parser.ast.Parser;
import org.eclipse.rcptt.core.ecl.parser.ast.Reference;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.parser.model.Resolver;

public class ResolverTest {

	private static final VarDecl param1 = new VarDecl("param1", new SrcLoc(1, 1));
	private static final VarDecl param2 = new VarDecl("param2", new SrcLoc(2, 2));

	private static final ArgDecl arg1 = new ArgDecl("arg1", new SrcLoc(4, 4));
	private static final ArgDecl arg2 = new ArgDecl("arg2", new SrcLoc(5, 5));
	private static final ArgDecl lastArg = new ArgDecl("lastArg", new SrcLoc(6, 6));
	
	private static final ArgDecl proc2Arg = new ArgDecl("proc2Arg", new SrcLoc(8,8));

	private static final ProcDecl proc1 = new ProcDecl("proc", new SrcLoc(3, 3)) {
		{
			addArg(arg1);
			addArg(arg2);
			addArg(lastArg);
		}
	};
	
	private static final ProcDecl proc2 = new ProcDecl("proc2", new SrcLoc(7,7)) {
		{
			addArg(proc2Arg);
		}
	};

	public static final BaseContainer cont = new BaseContainer() {
		{
			resource = "sample";

			addVar(param1);
			addVar(param2);
			addProc(proc1);

		}
	};
	
	public static final BaseContainer multiCommandCont = new BaseContainer() {
		{
			resource = "sample-multicommand";
			
			addVar(param1);
			addVar(param2);
			addProc(proc1);
			addProc(proc2);
		}
	};

	@Test
	public void testParamAsArg() {
		String text = "log $param1";
		Script script = Parser.parse(text);
		int offset = text.indexOf("$param1");
		Reference ref = Resolver.resolve(script, offset, cont);
		assertEquals(((Id) ref.src).text, "$param1");
		assertEquals(ref.dest, param1);
	}

}
