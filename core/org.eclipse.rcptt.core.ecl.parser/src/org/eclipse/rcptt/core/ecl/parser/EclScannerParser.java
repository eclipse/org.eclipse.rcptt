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
package org.eclipse.rcptt.core.ecl.parser;

import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.CurlyClose;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.CurlyOpen;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.Eof;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.Identifier;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.Linebreak;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.MlComment;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.Option;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.Pipe;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.SlComment;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.Spacing;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.SquareClose;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.SquareOpen;
import static org.eclipse.rcptt.core.ecl.scanner.EclToken.Type.Variable;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.rcptt.core.ecl.parser.ast.Arg;
import org.eclipse.rcptt.core.ecl.parser.ast.BoolArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.Comment;
import org.eclipse.rcptt.core.ecl.parser.ast.Id;
import org.eclipse.rcptt.core.ecl.parser.ast.LiteralArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Pipeline;
import org.eclipse.rcptt.core.ecl.parser.ast.PipelineArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.parser.ast.ScriptArg;
import org.eclipse.rcptt.core.ecl.scanner.EclScanner;
import org.eclipse.rcptt.core.ecl.scanner.EclToken;
import org.eclipse.rcptt.core.ecl.scanner.EclToken.Type;

public class EclScannerParser {
	public static Script parse(String script) {
		EclScannerParser parser = new EclScannerParser(script);

		try {
			return parser.parse();
		} catch (ParseException e) {
			return new Script(script, 0, script.length());
		}
	}

	private EclScanner scanner;
	private String script;

	private EclScannerParser(String script) {
		this.scanner = new EclScanner(script, true, true);
		this.script = script;
	}

	public Script parse() throws ParseException {
		return script(Eof);
	}

	private void addComment(Comment comment) {
		commentStack.peek().add(comment);
	}

	private List<Comment> popComments() {
		return commentStack.pop();
	}

	private Deque<List<Comment>> commentStack = new LinkedList<List<Comment>>();

	private String text(int begin, int end) {
		return script.substring(begin, end);
	}

	private Script script(Type terminal) {
		int begin = peek().begin;
		commentStack.push(new ArrayList<Comment>());
		List<Pipeline> pipelines = new ArrayList<Pipeline>();
		EclToken current = peek();

		while (peek().type != terminal) {
			consumeAll(Linebreak, Spacing);
			current = peek();
			if (current.type == Eof) {
				break;
			}
			switch (current.type) {
			case SlComment:
			case MlComment:
				consume();
				addComment(new Comment((String) current.value, current.begin, current.end));
				break;
			case Identifier:
			case Variable:
				pipelines.add(pipeline());
				break;
			default:
				if (peek().type != terminal) {
					consume();
				}
			}
		}
		int end = peek().type == Eof ? script.length() : peek().end;
		Script result = new Script(text(begin, end), begin, end);
		result.comments.addAll(popComments());
		result.pipelines.addAll(pipelines);
		return result;
	}

	private PipelineArg pipelineArg(EclToken name) {
		consumeOne(SquareOpen);
		Pipeline pipeline = pipeline();
		consumeAll(Spacing, Linebreak);
		if (peek().type == SquareClose) {
			consume();
		}

		int begin = name == null ? pipeline.begin : name.begin;
		int end = pipeline.end;

		PipelineArg result = new PipelineArg(text(begin, end), pipeline, begin, end);
		if (name != null) {
			result.name = idFromToken(name);
		}
		return result;
	}

	private LiteralArg literalArg(EclToken name, EclToken value) {
		int begin = name == null ? value.begin : name.begin;
		int end = value.end;

		LiteralArg result = new LiteralArg(text(begin, end),
				idFromToken(value),
				begin, end);
		if (name != null) {
			result.name = idFromToken(name);
		}
		return result;
	}

	private LiteralArg stringArg(EclToken name) {
		List<EclToken> strs = new ArrayList<EclToken>();
		boolean stringGoesOn = true;

		while (stringGoesOn) {
			// QS-3232: Don't consume line break here, as it is an indicator of the next command.
			consumeAll(Spacing);
			EclToken current = peek();
			switch (current.type) {
			case String:
				strs.add(current);
				consume();
				break;
			case Plus:
				consume();
				break;
			case MlComment:
			case SlComment:
				consume();
				addComment(new Comment((String) current.value, current.begin, current.end));
				break;
			default:
				stringGoesOn = false;
			}
		}
		int begin = name == null ? strs.get(0).begin : name.begin;
		int end = strs.get(strs.size() - 1).end;
		StringBuilder sb = new StringBuilder();
		sb.append("\"");
		for (EclToken t : strs) {
			sb.append(t.value);
		}
		sb.append("\"");
		String value = sb.toString();
		LiteralArg arg = new LiteralArg(text(begin, end), new Id(value, begin, end), begin, end);
		if (name != null) {
			arg.name = idFromToken(name);
		}
		return arg;
	}

	private ScriptArg scriptArg(EclToken name) {
		consumeOne(CurlyOpen);
		Script script = script(CurlyClose);
		consumeOne(CurlyClose);

		int begin = name == null ? script.begin : name.begin;
		int end = script.end;

		ScriptArg result = new ScriptArg(text(begin, end), script, begin, end);
		if (name != null) {
			result.name = idFromToken(name);
		}
		return result;
	}

	private Pipeline pipeline() {
		List<Command> commands = new ArrayList<Command>();
		boolean pipeEnd = false;
		boolean pendingPipe = false;
		while (!pipeEnd) {
			consumeAll(Spacing);
			EclToken current = peek();
			switch (current.type) {
			case Variable:
			case Identifier:
				commands.add(command());
				pendingPipe = false;
				break;
			case Pipe:
				consume();
				consumeAll(Spacing, Linebreak);
				pendingPipe = true;
				break;
			case Linebreak:
				EclToken next = peekForward(Spacing, Linebreak, SlComment, MlComment);
				if (next.type != Pipe && !pendingPipe) {
					pipeEnd = true;
				} else {
					consumeAll(Spacing, Linebreak);
				}
				break;
			case MlComment:
			case SlComment:
				consume();
				addComment(new Comment((String) current.value, current.begin, current.end));
				break;
			default:
				pipeEnd = true;
			}

		}
		int begin = commands.isEmpty() ? peek().begin : commands.get(0).begin;
		int end = commands.isEmpty() ? peek().begin : commands.get(commands.size() - 1).end;
		Pipeline result = new Pipeline(text(begin, end), begin, end);
		result.commands.addAll(commands);
		return result;
	}

	private BoolArg boolFromToken(EclToken token) {
		return new BoolArg(token.text, idFromToken(token), token.begin, token.end);
	}

	private Id idFromToken(EclToken token) {
		return new Id(token.text, token.begin, token.end);
	}

	private Command command() {
		EclToken current = peek();
		consumeOne(Variable, Identifier);
		Id id = new Id(current.text, current.begin, current.end);
		List<Arg> args = new ArrayList<Arg>();

		boolean commandEnd = false;

		EclToken argName = null;
		Arg pendingArg = null;
		while (!commandEnd) {
			consumeAll(Spacing);
			current = peek();
			switch (current.type) {
			case Identifier:
			case Variable:
			case Number:
				pendingArg = literalArg(argName, current);
				consume();
				break;
			case String:
				pendingArg = stringArg(argName);
				break;
			case Option:
				if (argName != null) {
					args.add(boolFromToken(argName));
				}
				argName = current;
				consume();
				break;
			case Linebreak:
				EclToken token = peekForward(Linebreak, Spacing);
				if (token.type != Option && token.type != SquareOpen && token.type != CurlyOpen) {
					commandEnd = true;
				} else {
					consumeAll(Linebreak, Spacing);
				}
				break;
			case SquareOpen:
				pendingArg = pipelineArg(argName);
				break;
			case CurlyOpen:
				pendingArg = scriptArg(argName);
				break;
			case SlComment:
			case MlComment:
				consume();
				addComment(new Comment((String) current.value, current.begin, current.end));
				break;
			default:
				commandEnd = true;
			}
			if (pendingArg != null) {
				args.add(pendingArg);
				pendingArg = null;
				argName = null;
			}
		}

		if (argName != null) {
			args.add(boolFromToken(argName));
			argName = null;
		}

		int end = lastConsumed == null ? 0 : lastConsumed.end;
		Command result = new Command(script.substring(id.begin, end), id, id.begin, end);
		result.args.addAll(args);
		return result;
	}

	private List<EclToken> buffer = new LinkedList<EclToken>();

	private EclToken peek() {
		return peek(0);
	}

	private EclToken peek(int offset) {
		while (buffer.size() < offset + 1) {
			EclToken token = scanner.next();
			buffer.add(token);
		}

		return buffer.get(offset);
	}

	private EclToken peekForward(Type... types) {
		int i = 0;
		while (is(peek(i), types)) {
			i++;
		}
		return peek(i);
	}

	private EclToken lastConsumed = null;

	private void consume() {
		peek();
		lastConsumed = buffer.remove(0);
	}

	private boolean is(EclToken token, Type... types) {
		Type t = token.type;
		for (int i = 0; i < types.length; i++) {
			if (t == types[i]) {
				return true;
			}
		}
		return false;
	}

	private void consumeAll(Type... types) {
		while (is(peek(), types)) {
			consume();
		}
	}

	private void consumeOne(Type... types) {
		if (is(peek(), types)) {
			consume();
		}
	}
}
