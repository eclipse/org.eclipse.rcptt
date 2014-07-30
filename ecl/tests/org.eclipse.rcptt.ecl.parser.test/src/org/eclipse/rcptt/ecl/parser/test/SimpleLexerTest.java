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

import java.lang.reflect.Field;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.rcptt.ecl.internal.parser.EclLexer;

public class SimpleLexerTest extends TestCase {
	public void testLexer001() throws Exception {
		String content = "set a beta";
		process(content);
	}

	public void testLexer002() throws Exception {
		String content = "set a \"string\"";
		process(content);
	}

	public void testLexer003() throws Exception {
		String content = "set a \"string\"|set b a\nset d 20";
		process(content);
	}

	public void testLexer004() throws Exception {
		String content = "set a \"string\"|set b a {This is COOL\n\nThis is too\n}\nset d 20";
		process(content);
	}

	// public void testLexer005() throws Exception {
	// String content =
	// "set a \"string\"|set b a {This is COOL\n\nThis is too\n\nset d 20";
	// process(content);
	// }

	public void testLexer006() throws Exception {
		process("cmd ruby:{N.new().format()}");
	}

	public void testLexer007() throws Exception {
		process("/*Alfa\nBeta\bGamma*/\na::b::get-length alfa");
	}
	
	public void testLexer008() throws Exception {
		process("first -flag\nsecond -secondFlag");
	}


	private void process(String content) throws IllegalAccessException {
		String method = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println("Test:" + method);
		EclLexer lexer = new EclLexer(new ANTLRStringStream(content));
		while (true) {
			Token token = lexer.nextToken();
			int type = token.getType();
			if (type == Token.EOF) {
				break;
			}
			printToken(token, lexer);
		}
	}

	public static void printToken(Token token, EclLexer lexer) throws IllegalArgumentException, IllegalAccessException {
		boolean found = false;
		Class<?> lexerClass = lexer.getClass();
		Field[] fields = lexerClass.getFields();
		int type = token.getType();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getType().getName().equals("int")) {
				int int1 = fields[i].getInt(lexer);
				if (int1 == type) {
					System.out.print("[" + fields[i].getName() + "(" + token.getText() + ")] ");
					found = true;
					break;
				}
			}
		}
		if (!found) {
			System.out.print("[" + type + "(" + token.getText() + ")] ");
		}
	}
}
