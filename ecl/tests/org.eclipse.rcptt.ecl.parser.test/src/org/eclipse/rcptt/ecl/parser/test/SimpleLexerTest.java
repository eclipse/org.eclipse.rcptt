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

import static java.util.Collections.unmodifiableMap;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.rcptt.ecl.internal.parser.EclLexer;

public class SimpleLexerTest extends TestCase {
	private static final Map<Integer, String> tokenNamesById = unmodifiableMap(extractNamesById(EclLexer.class));

	public static String toString(Token token) {
		String name = tokenNamesById.get(token.getType());
		if (name != null) {
			switch (token.getType()) {
			case EclLexer.DIGIT:
			case EclLexer.DNAME:
			case EclLexer.IP4:
			case EclLexer.NAME:
			case EclLexer.NUMBER:
			case EclLexer.STRING:
				return name + "(" + token.getText() + ")";	
			default:
				return name;
			}
			
		} else {
			return token.getType() + "(" + token.getText() + ")";
		}
	}

	static void check(String pattern, String input) {
		EclLexer lexer = new EclLexer(new ANTLRStringStream(input));
		StringBuilder builder = new StringBuilder();
		while (true) {
			Token token = lexer.nextToken();
			int type = token.getType();
			if (type == Token.EOF) {
				break;
			}
			if (token.getChannel() == Token.HIDDEN_CHANNEL)
				continue; 
			if (builder.length() > 0)
				builder.append(" ");
			builder.append(toString(token));
		}
		Assert.assertEquals(pattern, builder.toString());
	}

	public void testLexer001() throws Exception {
		check("NAME(set) NAME(a) NAME(beta)", "set a beta");
	}

	public void testLexer002() throws Exception {
		check("NAME(set) NAME(a) STRING(\"string\")", "set a \"string\"");
	}

	public void testLexer003() throws Exception {
		String content = "set a \"string\"|set b a\nset d 20";
		check("NAME(set) NAME(a) STRING(\"string\") OR NAME(set) NAME(b) NAME(a) NEWLINE NAME(set) NAME(d) NUMBER(20)", content);
	}

	public void testLexer004() throws Exception {
		String content = "set a \"string\"|set b a {This is COOL\n\nThis is too\n}\nset d 20";
		String pattern = "NAME(set) NAME(a) STRING(\"string\") OR NAME(set) NAME(b) NAME(a) CURLY_STRING NEWLINE NAME(set) NAME(d) NUMBER(20)";
		check(pattern, content);
	}

	// public void testLexer005() throws Exception {
	// String content =
	// "set a \"string\"|set b a {This is COOL\n\nThis is too\n\nset d 20";
	// process(content);
	// }

	public void testLexer006() throws Exception {
		check("NAME(cmd) NAME(ruby) COLON CURLY_STRING", "cmd ruby:{N.new().format()}");
	}

	public void testLexer007() throws Exception {
		String pattern = "NEWLINE NAME(a) COLON COLON NAME(b) COLON COLON DNAME(get-length) NAME(alfa)";
		check(pattern, "/*Alfa\nBeta\bGamma*/\na::b::get-length alfa");
	}

	public void testLexer008() throws Exception {
		check("NAME(first) MINUS NAME(flag) NEWLINE NAME(second) MINUS NAME(secondFlag)", "first -flag\nsecond -secondFlag");
	}
	
	public void testNewLineWithSpaces() throws Exception {
		check("NAME(command) NEWLINE", "command\n  \t  \n   \n  //comment   \n  ");
	}

	private static Map<Integer, String> extractNamesById(Class<?> clazz) {
		try {
			Field[] fields = clazz.getFields();
			Map<Integer, String> rv = new HashMap<Integer, String>();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if (!field.getType().equals(int.class))
					continue;
				if (!Modifier.isStatic(field.getModifiers()))
					continue;
				rv.put(field.getInt(clazz), field.getName());
			}
			return rv;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
