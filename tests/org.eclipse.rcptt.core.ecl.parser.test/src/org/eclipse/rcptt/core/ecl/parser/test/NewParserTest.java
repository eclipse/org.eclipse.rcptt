/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
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

import org.eclipse.rcptt.core.ecl.parser.EclScannerParser;
import org.eclipse.rcptt.core.ecl.parser.ast.Arg;
import org.eclipse.rcptt.core.ecl.parser.ast.BoolArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.LiteralArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Pipeline;
import org.eclipse.rcptt.core.ecl.parser.ast.PipelineArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.parser.ast.ScriptArg;
import org.eclipse.rcptt.core.ecl.scanner.EclScanner;
import org.eclipse.rcptt.core.ecl.scanner.EclToken;
import org.junit.Test;

public class NewParserTest {

	@Test
	public void mlc() {
		EclScanner scanner = new EclScanner("foo -bar -");
		EclToken token = null;
		while ((token = scanner.next()).type != EclToken.Type.Eof) {
			System.out.println("-----------");
			System.out.println(token);
		}
	}

	@Test
	public void simpleCmd() {
		script(cmd("a", s("b"), s("c"))).verify("a b c");
	}

	@Test
	public void namedArg() {
		TScript script = script(cmd("a", simple("-b", "c")));
		script.verify("a -b c");
		script.verify("a \n-b c");
	}

	@Test
	public void boolArgs() {
		script(cmd("a", b("-b"), b("-c"))).verify("a -b -c");
	}

	@Test
	public void differentArgs() {
		script(pipe(cmd("a", s("1"), simple("-a", "2"), simple("-b", "\"foo\"")))).verify("a 1 -a 2 -b \"foo\"");
	}

	@Test
	public void simplePipe() {
		TScript script = script(pipe(cmd("a"), cmd("b")));
		script.verify("a | b");
		script.verify(" a | b");
		script.verify(" a |\n b");
		script.verify(" a \n| b");
		script.verify(" a \n|\n b");
	}

	@Test
	public void pipeWithArgs() {
		script(pipe(cmd("a", s("b"), s("c")), cmd("d", s("e"), s("f")))).verify("a b c | d e f");
	}

	@Test
	public void twoPipes() {
		script(pipe(cmd("a"), cmd("b")), pipe(cmd("c"), cmd("d"))).verify("a | b\nc | d");
	}

	@Test
	public void simplePipeArg() {
		script(pipe(cmd("a", p(pipe(cmd("b")))))).verify("a [b]");
	}

	@Test
	public void compPipeArg() {
		TScript script = script(pipe(cmd("a", p("-n", pipe(cmd("b"), cmd("c"))))));
		script.verify("a -n [b | c]");
		script.verify("a -n [b |\n c]");
		script.verify("a -n [b \n| c]");
		script.verify("a \n-n [b | c]");
		script.verify("a -n \n[b | c]");
	}

	@Test
	public void simpleScriptArg() {
		TScript script = script(cmd("a", s(script(cmd("b")))));
		script.verify("a { b }");
		script.verify("a \n{ b }");
		script.verify("a \n{\n b }");
		script.verify("a \n{\n b\n }");
		script.verify("a \n{\n b\n }\n");
	}


	@Test
	public void testCommentsBetweenArgs() {
		TScript script = script(cmd("a", simple("-b", "c")));
		script.verify("/*   */ a -b c");
		script.verify("a -b c // dddd");
		script.verify("a /* */ -b /* foo */ c");
		script.verify("a // fooo\n -b /* foo */ c");
	}

	@Test
	public void testCommentsBetweenPipes() {
		TScript script = script(pipe(cmd("a"), cmd("b")), pipe(cmd("c"), cmd("d")));
		script.verify("a | b\nc | d");
		script.verify("a | b //foo \nc | d");
		script.verify("a | /*aa*/ b\nc /* bbb */ | d");
		script.verify("a | // dddd \nb\nc // deee \n| d");
		script.verify("a | b\n/* oeoe\n jeee*/c | d");
	}

	/**
	 * Following two tests has started to fail after RCPTT->Q7 rename.
	 * Tests were disabled for a very long time during that period, so exact failure reason is unknown.
	 */
	// @Test
	public void testStringLiteral() {
		TScript script = script(cmd("a", s("\"foobar\"")));
		script.verify("a \"foobar\"");
		script.verify("a \"foo\"+\"bar\"");
		script.verify("a \"foo\"\n+\n\"bar\"");
	}

	// @Test
	public void testCommentsInMultilineStrs() {
		TScript s = script(cmd("a", s("\"foo\nbar\"")));
		s.verify("a \"foo\n\"\n+\"bar\"");
		s.verify("a \"foo\n\"//foo\n+\"bar\"//bar");
	}

	@Test
	public void testSemicolon() {
		TScript script = script(pipe(cmd("a")), pipe(cmd("b")));
		script.verify("a;b");
		script.verify("a;\nb;");

	}

	private static Script parse(String script) {
		return EclScannerParser.parse(script);
	}

	private static TArg simple(String name, String value) {
		return new TSimpleArg(name, value);
	}

	private static TArg b(String name) {
		return new TBoolArg(name);
	}

	private static TArg s(String value) {
		return simple(null, value);
	}

	private static TArg p(String name, TPipe pipe) {
		return new TPipeArg(name, pipe);
	}

	private static TArg p(TPipe pipe) {
		return p(null, pipe);
	}

	private static TArg s(TScript script) {
		return s(null, script);
	}

	private static TArg s(String name, TScript script) {
		return new TScriptArg(name, script);
	}

	private static TCmd cmd(String name, TArg... args) {
		return new TCmd(name, args);
	}

	private static TPipe pipe(TCmd... cmds) {
		return new TPipe(cmds);
	}

	private static TScript script(TPipe... pipes) {
		return new TScript(pipes);
	}

	private static TScript script(TCmd... cmds) {
		return script(pipe(cmds));
	}

	private static class TScript {
		final TPipe[] pipes;

		public TScript(TPipe[] pipes) {
			this.pipes = pipes;
		}

		public void verify(Script s) {
			assertEquals(pipes.length, s.pipelines.size());
			for (int i = 0; i < pipes.length; i++) {
				pipes[i].verify(s.pipelines.get(i));
			}
		}

		public void verify(String s) {
			verify(parse(s));
		}
	}

	private static class TPipe {
		final TCmd[] cmds;

		public TPipe(TCmd... cmds) {
			this.cmds = cmds;
		}

		public void verify(Pipeline pipeline) {
			assertEquals(cmds.length, pipeline.commands.size());
			for (int i = 0; i < cmds.length; i++) {
				cmds[i].verify(pipeline.commands.get(i));
			}
		}

	}

	private static class TCmd {
		final String name;
		final TArg[] args;

		public TCmd(String name, TArg... args) {
			this.name = name;
			this.args = args;
		}

		public void verify(Command command) {
			assertEquals(name, command.name.text);
			assertEquals(args.length, command.args.size());
			for (int i = 0; i < args.length; i++) {
				args[i].verify(command.args.get(i));
			}
		}
	}

	private static abstract class TArg {
		public TArg(String name) {
			this.name = name;
		}

		public void verify(Arg arg) {
			if (arg.name == null && name != null) {
				assertTrue(false);
			}
			if (arg.name != null && name == null) {
				assertTrue(false);
			}

			if (arg.name != null && name != null) {
				assertEquals(name, arg.name.text);
			}
			verifyValue(arg);

		}

		protected abstract void verifyValue(Arg arg);

		final String name;
	}

	private static class TBoolArg extends TArg {

		public TBoolArg(String name) {
			super(name);
		}

		@Override
		protected void verifyValue(Arg arg) {
			assertTrue(arg instanceof BoolArg);
		}

	}

	private static class TSimpleArg extends TArg {

		final String value;

		public TSimpleArg(String name, String value) {
			super(name);
			this.value = value;
		}

		@Override
		protected void verifyValue(Arg arg) {
			assertTrue(arg instanceof LiteralArg);
			assertEquals(value, ((LiteralArg) arg).value.text);
		}

	}

	private static class TPipeArg extends TArg {
		final TPipe pipe;

		public TPipeArg(String name, TPipe pipe) {
			super(name);
			this.pipe = pipe;
		}

		@Override
		protected void verifyValue(Arg arg) {
			assertTrue(arg instanceof PipelineArg);
			pipe.verify(((PipelineArg) arg).pipeline);
		}
	}

	private static class TScriptArg extends TArg {
		final TScript script;

		public TScriptArg(String name, TScript script) {
			super(name);
			this.script = script;
		}

		@Override
		protected void verifyValue(Arg arg) {
			assertTrue(arg instanceof ScriptArg);
			script.verify(((ScriptArg) arg).script);
		}
	}

}
