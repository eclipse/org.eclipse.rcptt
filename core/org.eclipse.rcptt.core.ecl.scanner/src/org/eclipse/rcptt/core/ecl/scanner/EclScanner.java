/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.ecl.scanner;

import org.eclipse.rcptt.core.ecl.scanner.EclToken.Type;

public class EclScanner {

	private final String source;
	private int p = 0;

	private final char EOF = '\uFFFF';

	private boolean allowEmptyVar = false;
	private boolean allowEmptyOption = false;

	public EclScanner(String source) {
		this(source, false, false);
	}

	public EclScanner(String source, boolean allowEmptyVar, boolean allowEmptyOption) {
		this.source = source;
		this.allowEmptyVar = allowEmptyVar;
		this.allowEmptyOption = allowEmptyOption;
	}

	private char c0;
	private StringBuilder valueBuilder = new StringBuilder();

	private EclToken.Type type;
	private Object value;
	private String message;

	public EclToken next() {
		type = Type.Invalid;
		value = null;
		message = null;
		valueBuilder.setLength(0);

		int start = p;
		peek();

		switch (c0) {
		case EOF:
			eof();
			break;
		case ' ':
		case '\t':
			spacing();
			break;
		case '\n':
		case '\r':
			linebreak();
			break;
		case '/':
			comment();
			break;

		case '|':
			single(Type.Pipe);
			break;
		case ';':
			single(Type.Semicolon);
			break;
		case '+':
			single(Type.Plus);
			break;

		case '[':
			single(Type.SquareOpen);
			break;
		case ']':
			single(Type.SquareClose);
			break;
		case '{':
			single(Type.CurlyOpen);
			break;
		case '}':
			single(Type.CurlyClose);
			break;

		case '"':
			// case '\'':
			string();
			break;
		case '-':
			option();
			break;
		case '$':
			variable();
			break;

		default:
			if (EclCharClasses.isDigit(c0))
				number();
			else if (EclCharClasses.isIdentifierStart(c0))
				identifier();
			else
				eat();
		}

		EclToken token = new EclToken();
		token.type = message == null ? type : Type.Invalid;
		token.begin = start;
		token.end = p;
		token.text = type != Type.Eof ? source.substring(start, p) : null;
		token.value = value;
		token.message = message;
		return token;
	}

	// --

	private void eof() {
		type = Type.Eof;

		eat();
	}

	private void single(Type type) {
		this.type = type;
		eat();
	}

	private void spacing() {
		type = Type.Spacing;

		do {
			eat();
		} while (c0 == ' ' || c0 == '\t');
	}

	private void linebreak() {
		type = Type.Linebreak;

		if (c0 == '\n') {
			eat();
			if (c0 == '\r')
				eat();
		} else if (c0 == '\r') {
			eat();
			if (c0 == '\n')
				eat();
		}
	}

	private void comment() {
		eat();

		if (c0 == '/')
			slComment();
		else if (c0 == '*')
			mlComment();
	}

	private void slComment() {
		type = Type.SlComment;

		eat();

		while (c0 != '\n' && c0 != '\r' && c0 != EOF)
			valueBuilder.append(eat());

		value = valueBuilder.toString();
	}

	private void mlComment() {
		type = Type.MlComment;

		eat();

		boolean skipNextAsterisk = true;
		while (true) {
			if (c0 == EOF) {
				message = "Unterminated multiline comment.";
				return;
			} else if (c0 == '*') {
				eat();
				if (c0 == '/') {
					eat();
					break;
				}
				else {
					if (skipNextAsterisk) {
						skipNextAsterisk = false;
					} else {
						valueBuilder.append('*');
					}
				}
			} else {
				if (c0 == '\n' || c0 == '\r') {
					// Starting from new line we skips next *
					skipNextAsterisk = true;
				} else if (c0 != ' ' && c0 != '\t' && skipNextAsterisk == true) {
					// If detected non space char before skipping -> we don't skip next *
					skipNextAsterisk = false;
				}
				valueBuilder.append(eat());
			}
		}

		value = valueBuilder.toString();
	}

	private void number() {
		type = Type.Number;

		do {
			valueBuilder.append(eat());
		} while (EclCharClasses.isDigit(c0));

		String v = valueBuilder.toString();
		try {
			long l = Long.parseLong(v);
			value = l;
		} catch (NumberFormatException e) {
			value = v;
		}
	}

	private void string() {
		type = Type.String;

		char openQuote = eat();
		while (true) {
			if (c0 == EOF) {
				message = "Unterminated string literal.";
				return;
			} else if (c0 == '\\') {
				eat();

				if (c0 == EOF) {
					message = "Unterminated string literal.";
					return;
				}

				switch (c0) {
				case 'b':
					valueBuilder.append('\b');
					break;
				case 't':
					valueBuilder.append('\t');
					break;
				case 'n':
					valueBuilder.append('\n');
					break;
				case 'f':
					valueBuilder.append('\f');
					break;
				case 'r':
					valueBuilder.append('\r');
					break;
				case '\"':
					valueBuilder.append('\"');
					break;
				case '\'':
					valueBuilder.append('\'');
					break;
				case '\\':
					valueBuilder.append('\\');
					break;
				default:
					message = "Unknown string literal escape sequence.";
					break;
				}
				eat();
			} else if (c0 == openQuote) {
				eat();
				break;
			} else
				valueBuilder.append(eat());
		}

		value = valueBuilder.toString();
	}

	private void identifier() {
		type = Type.Identifier;

		scanIdentifier();
		value = valueBuilder.toString();
	}

	private void option() {
		type = Type.Option;

		eat();
		if (c0 == '-')
			eat();

		if (scanIdentifier())
			value = valueBuilder.toString();
		else {
			if (allowEmptyOption) {
				value = "";
			} else {
				message = "Invalid option name.";
			}
		}
	}

	private void variable() {
		type = Type.Variable;

		eat();

		if (scanIdentifier())
			value = valueBuilder.toString();
		else {
			if (allowEmptyVar) {
				value = "";
			} else {
				message = "Invalid variable name.";
			}
		}
	}

	// --

	private boolean scanIdentifier() {
		if (!EclCharClasses.isIdentifierStart(c0))
			return false;

		do {
			valueBuilder.append(eat());
		} while (EclCharClasses.isIdentifier(c0));

		return true;
	}

	// --

	private void peek() {
		c0 = p < source.length() ? source.charAt(p) : EOF;
	}

	private char eat() {
		char c1 = c0;

		++p;
		peek();

		return c1;
	}
}
