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
package org.eclipse.rcptt.ecl.parser;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Block;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.ExecutableParameter;
import org.eclipse.rcptt.ecl.core.Parameter;
import org.eclipse.rcptt.ecl.core.util.ScriptletFactory;
import org.eclipse.rcptt.ecl.gen.ast.AstExec;
import org.eclipse.rcptt.ecl.gen.ast.AstLiteral;
import org.eclipse.rcptt.ecl.internal.parser.EclLexer;
import org.eclipse.rcptt.ecl.internal.parser.EclParser;
import org.eclipse.rcptt.ecl.internal.parser.EclParserPlugin;
import org.eclipse.rcptt.ecl.internal.parser.SyntaxErrorException;

public class EclCoreParser {

	public static Command newCommand(String content) throws CoreException {
		return newCommand(content, null);
	}

	public static Command newCommand(String content, String resource) throws CoreException {
		return newCommand(content, resource, 1, 1);
	}

	public static Command newCommand(String content, String resource, int line, int pos) throws CoreException {
		if (content == null || content.trim().length() == 0)
			return ScriptletFactory.makeSeq();
		ANTLRStringStream input = new ANTLRStringStream(content);
		input.setLine(line);
		input.setCharPositionInLine(pos - 1);
		EclLexer lexer = new EclLexer(input);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EclParser parser = new EclParser(stream);
		try {
			return setResource(parser.commands(), resource);
		} catch (RecognitionException e) {
			throw emitErr(resource, e.line, e.charPositionInLine, 1, e);
		} catch (SyntaxErrorException e) {
			throw emitErr(resource, e.line, e.col, 1, e);
		} catch (Throwable t) {
			EclParserPlugin.logErr(t.getMessage(), t);
			throw new CoreException(new Status(IStatus.ERROR,
					EclParserPlugin.PLUGIN_ID, "Parse error"));
		}
	}

	public static Command newCommand(String content, int line, int pos)
			throws CoreException {
		return newCommand(content, null, line, pos);
	}

	private static Command setResource(Command cmd, String id) {
		if (id == null) {
			return cmd;
		}

		if (cmd instanceof AstExec) {
			((AstExec) cmd).setResourceID(id);

			List<Parameter> parameters = ((AstExec) cmd).getParameters();
			for (Parameter param : parameters) {
				if (param instanceof AstLiteral) {
					((AstLiteral) param).setResourceID(id);
				} else if (param instanceof ExecutableParameter) {
					Command cmdParam = ((ExecutableParameter) param).getCommand();
					setResource(cmdParam, id);
				}
			}
		} else if (cmd instanceof Block) {
			List<Command> commands = ((Block) cmd).getCommands();
			for (Command command : commands) {
				setResource(command, id);
			}
		}
		return cmd;
	}

	private static CoreException emitErr(String resource, int line, int pos, int len, Throwable e)
			throws CoreException {
		ScriptErrorStatus status = new ScriptErrorStatus(EclParserPlugin.PLUGIN_ID, "Syntax error", resource, line,
				pos, len);
		status.add(EclParserPlugin.createStatus(e));
		return new CoreException(status);
	}
}
