/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.internal.validators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.parser.EclValidator;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;

import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7ProblemReporter.ProblemType;
import org.eclipse.rcptt.core.builder.Q7ProblemSources;
import org.eclipse.rcptt.core.ecl.parser.EclScannerParser;
import org.eclipse.rcptt.core.ecl.parser.ast.Arg;
import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.Pipeline;
import org.eclipse.rcptt.core.ecl.parser.ast.PipelineArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.parser.ast.ScriptArg;

public class ScriptValidator {
	private final static String GET_PARAM_CMD = "get-param";
	private final static String SET_PARAM_CMD = "set-param";

	public static void validateErrors(String eclCode, IQ7ProblemReporter reporter, IFile element) {
		IStatus status = EclValidator.Instanse.validate(eclCode);
		if (status != null && status instanceof ScriptErrorStatus) {
			ScriptErrorStatus error = (ScriptErrorStatus) status;
			int offset = calcOffset(eclCode, error.getLine(), error.getColumn());
			reporter.reportProblem(element, ProblemType.Error, "Syntax error at "
					+ error.getLine() + ":" + (error.getColumn() + 1),
					error.getLine(), offset, error.getLength(), Q7ProblemSources.ERR_SYNTAX.getSourceId());
		}
	}

	public static void validateWarnings(String eclCode, IQ7ProblemReporter reporter, IFile element) {
		org.eclipse.rcptt.core.ecl.parser.ast.Script script = EclScannerParser.parse(eclCode);

		for (Pipeline pipe : script.pipelines) {
			validateWarningPipeline(eclCode, pipe, reporter, element);
		}
	}

	private static class TextPosition {
		int line;
		int col;

		public TextPosition(int line, int col) {
			this.line = line;
			this.col = col;
		}
	}

	private static int calcOffset(String text, int line, int column) {
		int offset = 0;
		int l = 1;
		int col = 0;
		while (l < line) {
			if (text.charAt(offset) == '\n') {
				l++;
			}
			offset++;
		}
		while (col < column) {
			if (text.charAt(offset) == '\t') {
				offset += 4;
				col += 4;
			} else {
				offset++;
				col++;
			}
		}
		return offset;
	}

	private static TextPosition calcPosition(String text, int offset) {
		int line = 1;
		int col = 0;
		int i = 0;

		while (i < offset) {
			if (text.charAt(i) == '\n') {
				line++;
				col = 0;
			} else if (text.charAt(i) == '\t') {
				col += 4;
			} else {
				col++;
			}
			i++;
		}
		return new TextPosition(line, col);
	}

	private static void validateWarningPipeline(String eclCode, Pipeline pipe, IQ7ProblemReporter reporter,
			IFile element) {
		for (Command cmd : pipe.commands) {
			if (cmd.name.text.equals(GET_PARAM_CMD)) {
				TextPosition pos = calcPosition(eclCode, cmd.begin);

				reporter.reportProblem(element, ProblemType.Warning,
						"Command \"" + GET_PARAM_CMD + "\" is obsolete (use '$' annotation instead) at "
								+ pos.line + ":" + (pos.col + 1),
						pos.line, cmd.begin, GET_PARAM_CMD.length(),
						Q7ProblemSources.WARN_OBSOLETE_GETPARAM_CMD.getSourceId());
			} else if (cmd.name.text.equals(SET_PARAM_CMD)) {
				TextPosition pos = calcPosition(eclCode, cmd.begin);

				reporter.reportProblem(
						element,
						ProblemType.Warning,
						"Command \""
								+ SET_PARAM_CMD
								+ "\" is obsolete (consider switching to parameters context or using ECL commands 'let' or 'global' instead) at "
								+ pos.line + ":" + (pos.col + 1),
						pos.line, cmd.begin, SET_PARAM_CMD.length(),
						Q7ProblemSources.WARN_OBSOLETE_SETPARAM_CMD.getSourceId());
			}
			for (Arg arg : cmd.args) {
				if (arg instanceof PipelineArg) {
					validateWarningPipeline(eclCode, ((PipelineArg) arg).pipeline, reporter, element);
				} else if (arg instanceof ScriptArg) {
					for (Pipeline subpipe : ((ScriptArg) arg).script.pipelines) {
						validateWarningPipeline(eclCode, subpipe, reporter, element);
					}
				}
			}
		}
	}

	public static Command findCommand(String eclCode, int offset) {
		Script script = EclScannerParser.parse(eclCode);

		for (Pipeline pipe : script.pipelines) {
			Command cmd = findCommand(pipe, offset);
			if (cmd != null) {
				return cmd;
			}
		}
		return null;
	}

	private static Command findCommand(Pipeline pipe, int offset) {
		for (Command cmd : pipe.commands) {
			if (cmd.begin > offset) {
				return null;
			}
			if (cmd.name.text.equals(GET_PARAM_CMD) && cmd.begin == offset) {
				return cmd;
			}
			for (Arg arg : cmd.args) {
				if (arg.begin > offset) {
					return null;
				}
				if (arg instanceof PipelineArg) {
					Command pipeCmd = findCommand(((PipelineArg) arg).pipeline, offset);
					if (pipeCmd != null) {
						return pipeCmd;
					}
				} else if (arg instanceof ScriptArg) {
					for (Pipeline subpipe : ((ScriptArg) arg).script.pipelines) {
						if (subpipe.begin > offset) {
							return null;
						}
						Command subCmd = findCommand(subpipe, offset);
						if (subCmd != null) {
							return subCmd;
						}
					}
				}
			}
		}
		return null;
	}
}
