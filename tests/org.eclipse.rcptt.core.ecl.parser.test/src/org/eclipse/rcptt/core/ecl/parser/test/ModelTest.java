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

import static org.eclipse.rcptt.core.ecl.parser.ast.Parser.parse;
import static org.eclipse.rcptt.core.ecl.parser.model.LocalContainer.fromScript;
import static org.eclipse.rcptt.core.ecl.parser.model.ScriptContainer.fromScript;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.eclipse.rcptt.core.ecl.model.BaseContainer;
import org.eclipse.rcptt.core.ecl.model.ProcDecl;
import org.eclipse.rcptt.core.ecl.model.VarDecl;

public class ModelTest {
	@Test
	public void testSimpleProc() {
		BaseContainer container = fromScript(parse("proc foo {}"), null);
		assertEquals(1, container.procCount());
		ProcDecl proc = container.getProcs()[0];
		assertEquals("foo", proc.name);
		assertEquals(0, proc.argCount());
	}

	@Test
	public void testOneParamProc() {
		BaseContainer container = fromScript(parse("proc foo [val bar] {}"), null);
		assertEquals(1, container.procCount());
		ProcDecl proc = container.getProcs()[0];
		assertEquals("foo", proc.name);
		assertEquals(1, proc.argCount());
		VarDecl param = proc.getArgs()[0];
		assertEquals("bar", param.name);
		assertEquals(false, param.isInput);
		assertEquals(false, param.hasDefaultValue);
		assertEquals(null, param.simpleValue);
	}

	@Test
	public void testComplexProc() {
		BaseContainer container = fromScript(parse("   proc \"set-text-after-label\" [val parent -input]\n" +
				" [val label] [val text \"tt\"] {\n" +
				"       $parent | get-editbox -after [get-label $label] | set-text $text\n" +
				"   }\n" +
				""), null);
		assertEquals(1, container.procCount());
		ProcDecl proc = container.getProcs()[0];
		assertEquals(3, proc.argCount());
		assertEquals("set-text-after-label", proc.name);
		assertVar(proc.getArgs()[0], "parent", true, false, null);
		assertVar(proc.getArgs()[1], "label", false, false, null);
		assertVar(proc.getArgs()[2], "text", false, true, "tt");

	}

	@Test
	public void testTwoProcs() {
		BaseContainer container = fromScript(parse("proc foo [val bar] {}\nproc p {}"), null);
		assertEquals(2, container.procCount());
		ProcDecl proc1 = container.getProcs()[0];
		assertEquals("foo", proc1.name);
		assertVar(proc1.getArgs()[0], "bar", false, false, null);
		ProcDecl proc2 = container.getProcs()[1];
		assertEquals("p", proc2.name);
		assertEquals(0, proc2.argCount());
	}

	@Test
	public void testGlobal() {
		BaseContainer container = fromScript(parse("global [val one 1] [val two 2]"), null);
		assertEquals(2, container.varCount());
		assertVar(container.getVars()[0], "one", false, true, "1");
		assertVar(container.getVars()[1], "two", false, true, "2");
	}

	@Test
	public void testLocalBeforeLet() {
		BaseContainer container = local(" /*marker*/ let [val foo 42] {}");
		assertEquals(0, container.varCount() + container.procCount());
	}

	@Test
	public void testLocalAfterLet() {
		BaseContainer container = local("let [val foo 42] {}\n /*marker*/");
		assertEquals(0, container.varCount() + container.procCount());
	}

	@Test
	public void testSimpleInsideLet() {
		BaseContainer container = local("let [val foo 42] { /*marker*/ }");
		assertEquals(1, container.varCount());
		assertVar(container.getVars()[0], "foo", false, true, "42");
	}

	@Test
	public void testLetInProc() {
		BaseContainer container = local("proc p [val foo -input] { let [val bar 55] {  /*marker*/ } }");
		assertEquals(2, container.varCount());
		assertVar(container.getVars()[0], "bar", false, true, "55");
		assertVar(container.getVars()[1], "foo", true, false, null);
	}

	@Test
	public void testMaskParam() {
		BaseContainer container = local("proc p [val foo -input] { let [val foo 55] {  /*marker*/ } }");
		assertEquals(1, container.varCount());
		assertVar(container.getVars()[0], "foo", false, true, "55");
	}

	@Test
	public void testInLetArg() {
		BaseContainer container = local("proc p [val foo -input] { let [val /*marker*/ foo 55] {   } }");
		assertEquals(1, container.varCount());
		assertVar(container.getVars()[0], "foo", true, false, null);
	}

	private static void assertVar(VarDecl var, String name, boolean isInput, boolean hasDefault, String simple) {
		assertEquals(name, var.name);
		assertEquals(isInput, var.isInput);
		assertEquals(hasDefault, var.hasDefaultValue);
		assertEquals(simple, var.simpleValue);
	}

	private static final String MARKER = "/*marker*/";

	private static BaseContainer local(String text) {
		return fromScript(parse(text), text.indexOf(MARKER) - 1, null);
	}
}
