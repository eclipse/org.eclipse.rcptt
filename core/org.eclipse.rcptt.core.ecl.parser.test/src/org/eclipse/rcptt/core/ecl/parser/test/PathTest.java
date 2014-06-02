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
package org.eclipse.rcptt.core.ecl.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import org.eclipse.rcptt.core.ecl.parser.ast.Arg;
import org.eclipse.rcptt.core.ecl.parser.ast.Id;
import org.eclipse.rcptt.core.ecl.parser.ast.LiteralArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Node;
import org.eclipse.rcptt.core.ecl.parser.ast.Parser;
import org.eclipse.rcptt.core.ecl.parser.ast.PipelineArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.parser.ast.ScriptArg;
import org.eclipse.rcptt.core.ecl.parser.model.NodePath;
import org.eclipse.rcptt.core.ecl.parser.model.PathBuilder;

public class PathTest {
	@Test
	public void testFindCommands() {
		String text = "with a { with b { let {  //marker } } }";
		int offset = text.indexOf("//marker") - 1;
		Script script = Parser.parse(text);
		NodePath path = PathBuilder.path(script, offset);
		assertEquals(2, path.findCommands("with").size());
	}

	@Test
	public void testFindLiteralArgName() {
		String text = "command -argName argValue";
		int offset = text.indexOf("-argName") + 1;
		Script script = Parser.parse(text);
		NodePath path = PathBuilder.path(script, offset);
		Node last = path.lastNode();
		assertTrue(last instanceof Id);
		Arg parent = (Arg) path.fromEnd(1);
		assertTrue(parent instanceof LiteralArg);
		assertEquals(parent.name, last);
	}

	@Test
	public void testFindPipeArgName() {
		String text = "command -argName [argValue]";
		int offset = text.indexOf("-argName") + 1;
		Script script = Parser.parse(text);
		NodePath path = PathBuilder.path(script, offset);
		Node last = path.lastNode();
		assertTrue(last instanceof Id);
		Arg parent = (Arg) path.fromEnd(1);
		assertTrue(parent instanceof PipelineArg);
		assertEquals(parent.name, last);
	}

	@Test
	public void testFindScriptArgName() {
		String text = "command -argName { argValue }";
		int offset = text.indexOf("-argName") + 1;
		Script script = Parser.parse(text);
		NodePath path = PathBuilder.path(script, offset);
		Node last = path.lastNode();
		assertTrue(last instanceof Id);
		Arg parent = (Arg) path.fromEnd(1);
		assertTrue(parent instanceof ScriptArg);
		assertEquals(parent.name, last);
	}

	@Test
	public void testLast() {
		NodePath path = new NodePath(Arrays.<Node> asList(new Id("a", 0, 0), new Id("b", 0, 0)), null, 0);
		assertEquals("b", ((Id) path.lastNode()).text);
		assertEquals("b", ((Id) path.fromEnd(0)).text);
		assertEquals("a", ((Id) path.fromEnd(1)).text);
		assertEquals(null, path.fromEnd(2));
	}
}
