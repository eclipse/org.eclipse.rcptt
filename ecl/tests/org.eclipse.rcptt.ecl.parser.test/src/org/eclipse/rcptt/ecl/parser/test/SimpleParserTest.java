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
package org.eclipse.rcptt.ecl.parser.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Block;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Exec;
import org.eclipse.rcptt.ecl.core.ExecutableParameter;
import org.eclipse.rcptt.ecl.core.GetVal;
import org.eclipse.rcptt.ecl.core.LiteralParameter;
import org.eclipse.rcptt.ecl.core.Parallel;
import org.eclipse.rcptt.ecl.core.Parameter;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.parser.EclCoreParser;

public class SimpleParserTest extends TestCase {
	public void testLexer001() throws Throwable {
		Command cmd = process("set1");
		Assert.assertTrue(cmd instanceof Exec);
		Exec command = (Exec) cmd;
		Assert.assertEquals("set1", command.getName());
	}

	private void check(String content, String checkCode) throws Throwable {
		Command cmd = process(content);
		String out = toString(cmd);
		System.out.println(out);
		Assert.assertEquals(checkCode == null ? content : checkCode, out);
	}

	public void testLexer001b() throws Throwable {
		check("set1&set2", "(set1&set2)");
		check("(set1&set2)", "(set1&set2)");
	}

	public void testLexer001c() throws Throwable {
		check("set1|set2", "(set1|set2)");
		check("(set1|set2)", "(set1|set2)");
	}

	public void testLexer001d() throws Throwable {
		check("set1\n|set2", "(set1|set2)");
	}
	
	public void testLexer001e() throws Throwable {
		check("(set1\n|set2)", "(set1|set2)");
	}

	public void testParser001d() throws Throwable {
		// check("set1;set2", "(set1;set2)");
		check("(set1;set2)", "(set1;set2)");
		// check("set1;set2;", "(set1;set2)");
	}

	public void testParser001e() throws Throwable {
		check("set1;set2&set3", "(set1;(set2&set3))");
		check("set1;(set2&set3)", "(set1;(set2&set3))");
	}

	public void testParser001f() throws Throwable {
		check("set1&set2;set3", "((set1&set2);set3)");
		check("(set1&set2);set3", "((set1&set2);set3)");
		check("set1&(set2;set3)", "(set1&(set2;set3))");
	}

	public void testParser001g() throws Throwable {
		check("set1|set2&set3", "((set1|set2)&set3)");
		check("(set1|set2)&set3", "((set1|set2)&set3)");
		check("set1|(set2&set3)", "(set1|(set2&set3))");
	}

	public void testParser001h() throws Throwable {
		check("set1&set2|set3", "(set1&(set2|set3))");
		check("(set1&set2|set3)", "(set1&(set2|set3))");
	}

	public void testParser002() throws Throwable {
		check("set1 a b c", "set1 a b c");
	}

	public void testParser003() throws Throwable {
		check("set1 c -a b", "set1 c -a=b");
	}

	public void testParser003a() throws Throwable {
		check("set1 \n-a b", "set1 -a=b");
	}

	public void testParser004() throws Throwable {
		check("set1 c --a b", "set1 c -a=b");
	}

	public void testParser005() throws Throwable {
		check("set1 c -a=b", "set1 c -a=b");
	}

	public void testParser006() throws Throwable {
		check("set1 c --a=b", "set1 c -a=b");
	}

	// public void testParser007() throws Throwable {
	// check("set1 \"C\" --a=b", "set1 C -a=b");
	// }

	// public void testParser008() throws Throwable {
	// check("set1 \"C\" --a={\nb\n}", "set1 C -a=\nb\n");
	// }

	public void testParser009() throws Throwable {
		check("set1 a b {\nc\n}", "set1 a b \nc\n");
	}

	public void testParser010() throws Throwable {
		check("set1 a b [set1]", "set1 a b [set1]");
	}

	public void testParser011() throws Throwable {
		check("set1 a b", "set1 a b");
	}

	public void testParser012() throws Throwable {
		check("set1 a b [set1&set2]", "set1 a b [(set1&set2)]");
	}

	// public void testParser013() throws Throwable {
	// check("http://www.eclipse.org/ecl/tests/model.ecore::TestCommand -hello=world",
	// "http://www.eclipse.org/ecl/tests/model.ecore::TestCommand -hello=world");
	// }

	// public void testParser014() throws Throwable {
	// check("A::B::c::TestCommand -hello=world",
	// "A::B::c::TestCommand -hello=world");
	// }

	// public void testParser015() throws Throwable {
	// check("ns::TestCommand -hello=1;ns::SlowCommand;ns::TestCommand -hello=3;",
	// "(ns::TestCommand -hello=1;ns::SlowCommand;ns::TestCommand -hello=3)");
	// }

	public void testParser016() throws Throwable {
		check("cmd ruby:{N.new().format()}", "cmd ruby:{N.new().format()}");
	}

	public void testParser017() throws Throwable {
		check("get-length alfa", "get-length alfa");
	}

	// public void testParser018() throws Throwable {
	// check("a::b::get-length alfa", "a::b::get-length alfa");
	// }

	// public void testParser019() throws Throwable {
	// check("#Alfa\na::b::get-length alfa", "a::b::get-length alfa");
	// }

	// public void testParser020() throws Throwable {
	// check("/*Alfa\nBeta\bGamma*/a::b::get-length alfa",
	// "a::b::get-length alfa");
	// }

	// public void testParser021() throws Throwable {
	// check("/*Alfa\nBeta\bGamma*/\na::b::get-length alfa",
	// "a::b::get-length alfa");
	// }

	public void testParser021() throws Throwable {
		check("get-string \"str1\\n\" + \"str2\"", "get-string str1\nstr2");
	}

	public void testParser022() throws Throwable {
		check("get-string \"bla\\'\"", "get-string bla\'");
	}
	
	public void testUnclosedBrace() throws Throwable {
		try {
			check("try {", "");
			fail();
		} catch (CoreException e) {
			assertEquals("Syntax error", e.getMessage());
		}
	}

	public void testCommentedClosedBrace() throws Throwable {
		try {
			process("try { //}");
			fail("Unclosed braces should emit error");
		} catch (CoreException e) {
			assertEquals("Syntax error", e.getMessage());
		}
	}

	public void testMultilineCommentedClosedBrace() throws Throwable {
		try {
			process("try { /*}*/");
			fail("Unclosed braces should emit error");
		} catch (CoreException e) {
			assertEquals("Syntax error", e.getMessage());
		}
	}

	public void testCurlyArgWithCommentInside() throws Throwable {
		check("try { //comment\nargument }", "try  //comment\nargument "); 
	}

	public void testClosedBraceWithRandomComments() throws Throwable {
		check("try { /*\nmultiline commment\n */\n// line comment \n command } //booh \n second command",
				"(try  /*\nmultiline commment\n */\n// line comment \n command ;second command)");
	}
	
	public void testCurlyArg() throws Throwable {
		check("try { argument }", "try  argument "); 
	}
	public void testWithConstruct() throws Throwable {
		String test = "first -flag\nsecond -secondFlag";
		check(test, "(first -flag=true;second -secondFlag=true)");
	}
	
	public void testVariableInPipe() throws Throwable {
		check("$x | command", "(get-val x|command)");
	}

	public void testVariableArgument() throws Throwable {
		check("command $x", "command [get-val x]");
	}
	
	public void testNewlineAtEOF() throws Throwable {
		check("command\n", "command");
	}

	public void testMultipleNewlinesBeforeCommand() throws Throwable {
		check("\n\n\ncommand", "command");
	}

	public void testMultipleNewlinesBetweenCommands() throws Throwable {
		check("command1\n\n\ncommand2", "(command1;command2)");
	}

	
	public void testNewlineBeforePlus() throws Throwable {
		check("command \"first\"\n+\"second\"", "command firstsecond");
	}

	public void testNewlineAfterPlus() throws Throwable {
		check("command \"first\"+\n\"second\"", "command firstsecond");
	}

	public void testCommandAfterNewLine() throws Throwable {
		check("command1\ncommand2", "(command1;command2)");
	}
	public void testCommandAfterNewLines() throws Throwable {
		check("command1\n\ncommand2", "(command1;command2)");
	}
	public void testCommandAfterCommandAndComment() throws Throwable {
		check("command1\n//comment\ncommand2", "(command1;command2)");
	}
	public void testCommandAfterComment() throws Throwable {
		check("//comment\ncommand2", "command2");
	}
	
	public void testNewLineAndSpaceCombinationAfterString() throws Throwable {
		check("command1 \"arg\"\n \ncommand2", "(command1 arg;command2)");
	}

	public void testStringArgOnNewLine() throws Throwable {
		check("command \"arg1\"\n \"arg2\"", "command arg1 arg2");
	}

	public void testCommentAndEolAtEof() throws Throwable {
		check("//comment1\n", "");
	}

	public void testCommentsAndEolAtEof() throws Throwable {
		check("//comment1//comment2\n", "");
	}

	public void testCommentsAtEof() throws Throwable {
		check("//comment1//comment2\n", "");
	}
	public void testCommandAndCommentsAtEof() throws Throwable {
		check("command\n//comment1\n", "command");
	}
	public void testNewLinesAfterCommand() throws Throwable {
		check("command\n\n\n", "command");
	}
	public void testScringEscape() throws Throwable {
		check("command \"}\\n\"", "command }\n");
	}
	public void testScringEscapeWithinCurly() throws Throwable {
		check("command {\"}\"}", "command \"}\"");
	}
	public void testSubCommandOnANewLine() throws Throwable {
		check("command\n[subcommand]", "command [subcommand]");
	}
	
	public void testNewLineWithSpacesAfterCommand() throws Throwable {
		check("command\n   \n", "command");
	}
	
	//https://bugs.eclipse.org/bugs/show_bug.cgi?id=440960
	public void testNoNestedSequences() throws Throwable {
		check("command1\nwait-until-eclipse-is-ready\ncommand2", 
				"(command1;wait-until-eclipse-is-ready;command2)");
	}
	
	//https://bugs.eclipse.org/bugs/show_bug.cgi?id=441083
	public void testVarDereference() throws Throwable {
		check("$a | command1 \n $a| command2", "((get-val a|command1);(get-val a|command2))"); 
	}
	
	public void testCommentAfterPipe() throws Throwable {
		check("command1|\n//comment\ncommand2", "(command1|command2)");
	}

	private Command process(String content) throws Throwable {
		String method = Thread.currentThread().getStackTrace()[3].getMethodName();
		System.out.println("Test:" + method);
		// EclParserErrorCollector collector = new EclParserErrorCollector();
		Command cmd = EclCoreParser.newCommand(content);
		// EclError[] errors = collector.getErrors();
		// for (int i = 0; i < errors.length; i++) {
		// System.out.println(errors[i].getMessage());
		// }
		return cmd;
	}

	public String pp(String pre, String val, String po) {
		if (val == null) {
			return "";
		}
		return nv(pre) + val + nv(po);
	}

	private String nv(String pre) {
		return pre != null ? pre : "";
	}

	public String pp(String pre, String val) {
		return pp(pre, val, null);
	}

	public String toString(Command command) {
		StringBuffer buffer = new StringBuffer();
		if (command instanceof Exec) {
			Exec exec = (Exec) command;
			String ns = exec.getNamespace();
			String host = exec.getHost();
			buffer.append(pp(null, ns, "::") + exec.getName() + pp("@", host));
			toString(exec.getParameters(), buffer);
		} else if (command instanceof Sequence) {
			toString((Sequence) command, buffer, ";");
		} else if (command instanceof Parallel) {
			toString((Parallel) command, buffer, "&");
		} else if (command instanceof Pipeline) {
			toString((Pipeline) command, buffer, "|");
		} else if (command instanceof GetVal) {
			buffer.append("get-val " + ((GetVal)command).getName());
		} else {
			buffer.append(command.getClass().getSimpleName());
		}
		return buffer.toString();
	}

	private void toString(EList<Parameter> list, StringBuffer buffer) {
		for (Parameter parameter : list) {
			buffer.append(' ');
			buffer.append(toString(parameter));
		}
	}

	private void toString(Block seq, StringBuffer buffer, String sep) {
		EList<Command> list = seq.getCommands();
		boolean first = true;
		if (list.size() > 1) {
			buffer.append('(');
		}
		for (Command command2 : list) {
			if (!first) {
				buffer.append(sep);
			}
			first = false;
			buffer.append(toString(command2));
		}
		if (list.size() > 1) {
			buffer.append(')');
		}
	}
	
	private String toString(Parameter parameter) {
		if (parameter instanceof LiteralParameter) {
			LiteralParameter literal = (LiteralParameter) parameter;
			String name = pp("-", literal.getName(), "=");
			String format = pp(null, literal.getFormat(), ":{");
			String formatEnd = literal.getFormat() != null ? "}" : "";
			return name + format + literal.getLiteral() + formatEnd;
		} else if (parameter instanceof ExecutableParameter) {
			ExecutableParameter ep = (ExecutableParameter) parameter;
			String name = pp("-", ep.getName(), "=");
			return name + "[" + toString(ep.getCommand()) + "]";
		}
		return "UNKNOWN";
	}
}
