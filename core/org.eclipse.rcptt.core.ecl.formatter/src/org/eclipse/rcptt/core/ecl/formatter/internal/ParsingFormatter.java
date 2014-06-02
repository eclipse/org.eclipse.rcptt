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
package org.eclipse.rcptt.core.ecl.formatter.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.core.ecl.formatter.EclFormatterOptions;
import org.eclipse.rcptt.core.ecl.formatter.internal.SourceBuilder.Part;
import org.eclipse.rcptt.core.ecl.formatter.internal.SourceBuilder.Quote;
import org.eclipse.rcptt.core.ecl.scanner.EclScanner;
import org.eclipse.rcptt.core.ecl.scanner.EclToken;
import org.eclipse.rcptt.core.ecl.scanner.EclToken.Type;

public class ParsingFormatter {

	private SourceBuilder builder;

	private EclScanner scanner;
	private List<EclToken> buffer = new ArrayList<EclToken>();

	public ParsingFormatter(EclFormatterOptions options) {
		builder = new SourceBuilder(options);
	}

	public String format(EclScanner scanner) {
		this.scanner = scanner;

		script();

		return builder.toString();
	}

	// --

	private void script() {
		emptyLines(true);

		while (!typeIs(Type.Eof))
			line(false, false);
	}

	private void line(boolean curly, boolean square) {
		// we are at generic line start

		emptyLines(false);

		switch (type()) {
		case Eof:
			break;
		case Invalid:
			invalid();
			break;
		case SlComment:
			builder.standaloneSlComment(eat(String.class));
			break;
		case MlComment:
			String comment = eat(String.class);
			if (typeIs(Type.Linebreak, Type.Eof))
				builder.standaloneMlComment(comment);
			else {
				builder.mlCommentAtLineStart(comment);

				while (typeIs(Type.MlComment)) {
					comment = eat(String.class);
					if (typeIs(Type.Linebreak, Type.Eof))
						builder.mlCommentAtLineEnd(comment);
					else
						builder.inlineMlComment(comment);
				}

				if (typeIs(Type.SlComment))
					builder.slCommentAtLineEnd(eat(String.class));
				else if (!typeIs(Type.Linebreak, Type.Eof))
					sequence(curly, square);
			}
			break;
		default:
			sequence(curly, square);
			break;
		}
	}

	private void sequence(boolean curly, boolean square) {
		// okay, now we are at ill-formed sequence start

		while (true) {
			pipeline(curly, square);
			if (typeIs(Type.Semicolon)) {
				eat();
				builder.semicolon();
			} else
				break;
		}

		if (!typeIs(Type.Eof) && !square)
			builder.linebreak();
	}

	private void pipeline(boolean curly, boolean square) {
		boolean first = true;

		while (true) {
			command(curly, square, !first);
			if (typeIs(Type.Pipe)) {
				eat();
				builder.pipe();
			} else
				break;
			first = false;
		}
	}

	private void command(boolean curly, boolean square, boolean pipe) {
		boolean atStart = true;
		boolean seenPlus = false;
		boolean seenNonWhitespace = false;
		List<Part> strings = new ArrayList<Part>();
		String lastCommandName = null;

		loop: while (true) {
			switch (type()) {
			case Semicolon:
			case Pipe:
				break loop;

			case SlComment:
				if (isCommandContinued(pipe)) {
					builder.softSlCommentAtLineEnd(eat(String.class));
					seenNonWhitespace = false;
				} else {
					builder.slCommentAtSequenceEnd(eat(String.class));
					break loop;
				}
				break;

			case MlComment:
				builder.softInlineMlComment(eat(String.class));
				break;

			case Linebreak:
				if (!isSequenceContinued(pipe))
					break loop;
				eat();
				break;

			case Identifier:
				seenNonWhitespace = true;
				if (seenPlus)
					seenPlus = setQuoteAlways(strings);

				if (atStart || pipe) {
					lastCommandName = eat(String.class);
					builder.commandName(lastCommandName);
				} else {
					builder.positionalLiteralArg(eat(String.class),
							isWrappableLiteral(lastCommandName));
					lastCommandName = null;
				}

				pipe = false;
				break;

			case String:
				if (seenNonWhitespace)
					strings.add(builder.positionalLiteralArg(String(),
							isWrappableLiteral(lastCommandName)));
				else
					builder.positionalQuotedLiteralArg(String(),
							isWrappableLiteral(lastCommandName));

				seenNonWhitespace = true;
				lastCommandName = null;
				if (seenPlus)
					seenPlus = setQuoteAlways(strings);
				break;
			case Plus:
				seenPlus = true;
				seenNonWhitespace = true;
				lastCommandName = null;

				eat();
				builder.plus();
				break;
			case Number:
				if (seenPlus)
					seenPlus = setQuoteAlways(strings);
				seenNonWhitespace = true;

				builder.positionalLiteralArg(eat().text,
						isWrappableLiteral(lastCommandName));

				lastCommandName = null;
				break;
			case Variable:
				if (seenPlus)
					seenPlus = setQuoteAlways(strings);
				seenNonWhitespace = true;
				lastCommandName = null;

				if (atStart || pipe)
					builder.variableEmit(eat(String.class));
				else
					builder.positionalVariableArg(eat(String.class));
				break;
			case Option:
				if (seenPlus)
					seenPlus = setQuoteAlways(strings);
				seenNonWhitespace = true;
				lastCommandName = null;

				String option = eat(String.class);
				switch (type()) {
				case Identifier:
					builder.namedLiteralArg(option, eat(String.class));
					break;
				case Number:
					builder.namedLiteralArg(option, eat().text);
					break;
				case String:
					strings.add(builder.namedLiteralArg(option, String()));
					break;
				case Variable:
					builder.namedVariableArg(option, eat(String.class));
					break;
				case CurlyOpen:
					builder.scriptArgName(option);
					block();
					break;
				case SquareOpen:
					builder.pipelineArgName(option);
					pipeline();
					break;
				default:
					builder.boolArg(option);
					break;
				}
				break;

			case CurlyOpen:
				seenNonWhitespace = true;
				lastCommandName = null;

				block();
				break;

			case CurlyClose:
				seenNonWhitespace = true;
				lastCommandName = null;

				if (curly)
					break loop;

				eat();
				builder.scriptArgClose();
				break;
			case SquareOpen:
				seenNonWhitespace = true;
				lastCommandName = null;

				pipeline();
				break;
			case SquareClose:
				seenNonWhitespace = true;
				lastCommandName = null;

				if (square)
					break loop;

				eat();
				builder.pipelineArgClose();
				break;

			case Eof:
				break loop;

			default:
				seenNonWhitespace = true;
				lastCommandName = null;

				invalid();
				break;
			}

			atStart = false;
		}

		if (seenPlus)
			setQuoteAlways(strings);
	}

	private String String() {
		StringBuilder result = new StringBuilder();

		result.append(eat(String.class));

		EclToken plus = null;

		int i = 0;
		loop: for (;; ++i) {
			EclToken token = peek(i);

			switch (token.type) {
			case Linebreak:
				// skip it
				break;
			case Plus:
				if (plus == null)
					plus = token;
				else
					break loop;
				break;
			case String:
				if (plus != null) {
					result.append((String) token.value);
					while (i-- >= 0)
						eat();

					i = -1;
					plus = null;
				} else
					break loop;
				break;
			default:
				break loop;
			}
		}

		return result.toString();
	}

	private boolean setQuoteAlways(List<Part> parts) {
		for (Part p : parts)
			p.setQuoting(Quote.Always);
		parts.clear();

		return false;
	}

	private void pipeline() {
		builder.pipelineArgOpen();

		eat();
		emptyLines(false);

		while (!typeIs(Type.Eof, Type.SquareClose))
			line(false, true);

		if (typeIs(Type.SquareClose)) {
			eat();
			builder.pipelineArgClose();
		}
	}

	private void block() {
		builder.scriptArgOpen();

		eat();
		emptyLines(false);

		while (!typeIs(Type.Eof, Type.CurlyClose))
			line(true, false);

		if (typeIs(Type.CurlyClose)) {
			eat();
			builder.scriptArgClose();
		}
	}

	private void invalid() {
		builder.invalid(eat().text);
	}

	private boolean isSequenceContinued(boolean pipe) {
		EclToken token = nextNon(Type.Linebreak, Type.SlComment, Type.MlComment);

		if (pipe && token.type == Type.Identifier)
			return true;

		return typeIs(token, Type.CurlyOpen, Type.Number, Type.Option,
				Type.Plus, Type.SquareOpen, Type.String, Type.Pipe,
				Type.Semicolon);
	}

	private boolean isCommandContinued(boolean pipe) {
		return isSequenceContinued(pipe);
	}

	private static boolean isWrappableLiteral(String lastCommandName) {
		if (lastCommandName == null)
			return false;

		lastCommandName = lastCommandName.toLowerCase();
		return !SourceBuilder.NO_WRAP_COMMANDS.contains(lastCommandName);

	}

	private void emptyLines(boolean removeLines) {
		int linebreaks = 0;
		while (true) {
			if (!typeIs(Type.Linebreak))
				break;

			eat();
			++linebreaks;
		}
		if (!removeLines && linebreaks > 1)
			builder.linebreak();
	}

	// --

	private EclToken nextNon(Type... types) {
		for (int i = 0;; ++i) {
			EclToken token = peek(i);
			if (!typeIs(token, types))
				return token;
		}
	}

	private Type type() {
		return peek().type;
	}

	private boolean typeIs(Type type) {
		return peek().type == type;
	}

	private boolean typeIs(Type... types) {
		return typeIs(peek(), types);
	}

	private boolean typeIs(EclToken token, Type... types) {
		final Type type = token.type;

		for (Type t : types)
			if (type == t)
				return true;

		return false;
	}

	private EclToken peek() {
		return peek(0);
	}

	private EclToken peek(int offset) {
		while (buffer.size() < offset + 1) {
			EclToken token = scanner.next();
			if (token.type != Type.Spacing)
				buffer.add(token);
		}

		return buffer.get(offset);
	}

	private EclToken eat() {
		peek();
		return buffer.remove(0);

	}

	private <T> T eat(Class<T> class_) {
		return class_.cast(eat().value);
	}
}
