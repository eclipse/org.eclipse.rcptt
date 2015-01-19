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

import org.junit.Test;

import org.eclipse.rcptt.core.ecl.parser.ast.Arg;
import org.eclipse.rcptt.core.ecl.parser.ast.BoolArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.Id;
import org.eclipse.rcptt.core.ecl.parser.ast.LiteralArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Parser;
import org.eclipse.rcptt.core.ecl.parser.ast.Pipeline;
import org.eclipse.rcptt.core.ecl.parser.ast.PipelineArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.parser.ast.ScriptArg;

public class ParserTest {

	@Test
	public void testEmpty() {
		Script script = Parser.parse("");
		assertEquals(0, script.pipelines.size());
		assertEquals(0, script.comments.size());
	}

	@Test
	public void testNoArgsCommand() {
		Script script = Parser.parse("cmd");
		assertEquals(1, script.pipelines.size());
		assertEquals(0, script.comments.size());

		Pipeline pipeline = script.pipelines.get(0);
		assertEquals(1, pipeline.commands.size());

		Command command = pipeline.commands.get(0);
		assertEquals(0, command.args.size());

		assertEquals("cmd", command.name.getText("cmd"));
	}

	@Test
	public void testTwoNoArgsCommands() {
		Script script = Parser.parse("cmd1\ncmd2");
		assertEquals(2, script.pipelines.size());
		assertEquals("cmd1", script.pipelines.get(0).commands.get(0).name.text);
		assertEquals("cmd2", script.pipelines.get(1).commands.get(0).name.text);
	}

	@Test
	public void testNoArgPipeline() {
		Script script = Parser.parse("a | b | c");
		assertEquals(1, script.pipelines.size());
		Pipeline p = script.pipelines.get(0);
		assertEquals(3, p.commands.size());
		assertEquals("a", p.commands.get(0).name.text);
		assertEquals("b", p.commands.get(1).name.text);
		assertEquals("c", p.commands.get(2).name.text);
	}

	@Test
	public void testNoArg2Pipes() {
		Script script = Parser.parse("a | b | c\n\nd | e ");
		assertEquals(2, script.pipelines.size());
		assertEquals(3, script.pipelines.get(0).commands.size());
		assertEquals(2, script.pipelines.get(1).commands.size());
	}

	@Test
	public void testSimpleNumArg() {
		Script script = Parser.parse("a 1");
		Command cmd = script.pipelines.get(0).commands.get(0);
		assertEquals("a", cmd.name.text);
		assertEquals(1, cmd.args.size());
		Arg arg = cmd.args.get(0);
		assertTrue(arg instanceof LiteralArg);
		assertEquals("1", ((LiteralArg) arg).value.text);
	}

	@Test
	public void testSimpleIdArg() {
		Script script = Parser.parse("a b");
		Command cmd = script.pipelines.get(0).commands.get(0);
		assertEquals("a", cmd.name.text);
		assertEquals(1, cmd.args.size());
		Arg arg = cmd.args.get(0);
		assertTrue(arg instanceof LiteralArg);
		assertEquals("b", ((LiteralArg) arg).value.text);
	}

	@Test
	public void testSimpleRefArg() {
		Script script = Parser.parse("a $b");
		Command cmd = script.pipelines.get(0).commands.get(0);
		assertEquals("a", cmd.name.text);
		assertEquals(1, cmd.args.size());
		Arg arg = cmd.args.get(0);
		assertTrue(arg instanceof LiteralArg);
		assertEquals("$b", ((LiteralArg) arg).value.text);
	}

	@Test
	public void testSimpleStrArg() {
		Script script = Parser.parse("a \"b\"");
		Command cmd = script.pipelines.get(0).commands.get(0);
		assertEquals("a", cmd.name.text);
		assertEquals(1, cmd.args.size());
		Arg arg = cmd.args.get(0);
		assertTrue(arg instanceof LiteralArg);
		assertEquals("\"b\"", ((LiteralArg) arg).value.text);
	}

	@Test
	public void testNamedArg() {
		Script script = Parser.parse("a -b c");
		Arg arg = script.pipelines.get(0).commands.get(0).args.get(0);
		assertEquals("-b", arg.name.text);
		assertEquals("c", ((LiteralArg) arg).value.text);
	}

	@Test
	public void testBoolArg() {
		Script script = Parser.parse("a -b");
		BoolArg arg = (BoolArg) script.pipelines.get(0).commands.get(0).args.get(0);
		assertEquals("-b", arg.name.text);

	}

	@Test
	public void testPipeArg() {
		Script script = Parser.parse("a [b]");
		PipelineArg arg = (PipelineArg) script.pipelines.get(0).commands.get(0).args.get(0);
		assertEquals(1, arg.pipeline.commands.size());
		Command command = arg.pipeline.commands.get(0);
		assertEquals(0, command.args.size());
		assertEquals("b", command.name.text);
	}

	@Test
	public void testScriptArg() {
		Script script = Parser.parse("a { b }");
		Script inner = ((ScriptArg) script.pipelines.get(0).commands.get(0).args.get(0)).script;

		Id cmd = inner.pipelines.get(0).commands.get(0).name;
		assertEquals("b", cmd.text);
		assertEquals(4, cmd.begin);
		assertEquals(5, cmd.end);
	}

	@Test
	public void testRealScript() {
		Script script = Parser.parse("with [get-editor \"Foo.txt\"] {\n" +
				"   get-editbox -after [get-label \"label\"] | set-text aaa\n" +
				"}");

		assertEquals(1, script.pipelines.size());
		assertEquals(1, script.pipelines.get(0).commands.size());
		Command cmd = script.pipelines.get(0).commands.get(0);
		assertEquals("with", cmd.name.text);
		assertEquals(2, cmd.args.size());
		PipelineArg objArg = (PipelineArg) cmd.args.get(0);
		ScriptArg doArg = (ScriptArg) cmd.args.get(1);
		assertEquals(1, objArg.pipeline.commands.size());
		Command getEditor = objArg.pipeline.commands.get(0);
		assertEquals("get-editor", getEditor.name.text);
		assertEquals(1, getEditor.args.size());
		assertEquals("\"Foo.txt\"", ((LiteralArg) getEditor.args.get(0)).value.text);

		assertEquals(1, doArg.script.pipelines.size());
		assertEquals(2, doArg.script.pipelines.get(0).commands.size());
		Command getEditbox = doArg.script.pipelines.get(0).commands.get(0);
		Command setText = doArg.script.pipelines.get(0).commands.get(1);
		assertEquals("get-editbox", getEditbox.name.text);
		assertEquals(1, getEditbox.args.size());
		PipelineArg afterArg = (PipelineArg) getEditbox.args.get(0);
		assertEquals("-after", afterArg.name.text);
		Command getLabel = afterArg.pipeline.commands.get(0);
		assertEquals("get-label", getLabel.name.text);
		assertEquals("\"label\"", ((LiteralArg) getLabel.args.get(0)).value.text);
		assertEquals("set-text", setText.name.text);
		assertEquals("aaa", ((LiteralArg) setText.args.get(0)).value.text);
	}

	@Test
	public void testArgLineBreak() {
		Script script = Parser.parse("a [b]\n\t[c]");
		assertEquals(1, script.pipelines.size());
		Command cmd = script.pipelines.get(0).commands.get(0);
		assertEquals(2, cmd.args.size());
	}

	@Test
	public void testSLComment() {
		Script script = Parser.parse("a //cmd");
		assertEquals(1, script.comments.size());
		assertEquals(1, script.pipelines.size());
		assertEquals("a", script.pipelines.get(0).commands.get(0).name.text);
	}

	@Test
	public void testStrangeCrash() {
		Parser.parse("let [val foo 44] {\n" +
				"	$/\n" +
				"}");
	}
}
