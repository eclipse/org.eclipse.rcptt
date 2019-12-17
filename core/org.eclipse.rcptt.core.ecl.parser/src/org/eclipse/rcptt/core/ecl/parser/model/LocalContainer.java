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
package org.eclipse.rcptt.core.ecl.parser.model;

import static org.eclipse.rcptt.core.ecl.parser.model.ScriptContainer.globalVars;
import static org.eclipse.rcptt.core.ecl.parser.model.ScriptContainer.procFromPipeline;
import static org.eclipse.rcptt.core.ecl.parser.model.ScriptContainer.varFromArg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.rcptt.core.ecl.model.BaseContainer;
import org.eclipse.rcptt.core.ecl.model.ProcDecl;
import org.eclipse.rcptt.core.ecl.model.VarDecl;
import org.eclipse.rcptt.core.ecl.parser.ast.Arg;
import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.Pipeline;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.parser.ast.ScriptArg;

/**
 * All variables and procs from current script visible from given offset
 */
public class LocalContainer extends BaseContainer {
	public static LocalContainer fromScript(Script script, int offset, String resource) {
		LocalContainer result = new LocalContainer();
		result.setResource(resource);
		NodePath path = PathBuilder.path(script, offset);
		result.addAllVars(findLocalVars(path, offset));

		boolean isInProc = isInProc(path);

		Pipeline firstInPath = path.firstOf(Pipeline.class);
		for (int i = 0; i < script.pipelines.size(); i++) {
			Pipeline pipeline = script.pipelines.get(i);
			if (pipeline == firstInPath && !isInProc) {
				break;
			}

			ProcDecl proc = procFromPipeline(pipeline);
			if (proc != null) {
				result.addProc(proc);
				proc.setDescription(script.findProcDescription(pipeline.begin));
			}

			if (pipeline == firstInPath) {
				// this is enclosing proc
				result.addAllVars(Arrays.<VarDecl> asList(proc.getArgs()));
			}
			result.addAllVars(globalVars(pipeline));
		}

		return result;
	}

	private static List<VarDecl> findLocalVars(NodePath path, int offset) {
		List<VarDecl> result = new ArrayList<VarDecl>();

		List<Command> commands = path.findCommands("let", "foreach", "each", "repeat", "loop");
		// for each 'let' command, we need to make sure that found
		// path is inside
		// the last arg
		List<Command> visibleCommands = new ArrayList<Command>();
		for (Command command : commands) {
			Arg last = command.lastArg();
			if (last == null) {
				continue;
			}
			if (last instanceof ScriptArg && last.contains(offset)) {
				visibleCommands.add(command);
			}
		}

		// Reversing so that inner variables with the same name 'override'
		// outer variables
		Collections.reverse(visibleCommands);

		Set<String> names = new HashSet<String>();
		for (Command command : visibleCommands) {
			for (Arg arg : command.args) {
				VarDecl var = varFromArg(arg);
				if (var == null) {
					continue;
				}
				if (names.contains(var.name)) {
					continue;
				}
				names.add(var.name);
				result.add(var);
			}
		}

		return result;
	}

	private static boolean isInProc(NodePath path) {
		Command procCmd = path.lastCommand("proc");
		if (procCmd == null) {
			return false;
		}

		Arg last = procCmd.lastArg();
		if (last == null) {
			return false;
		}
		if (!(last instanceof ScriptArg) || !last.contains(path.offset)) {
			return false;
		}
		return true;
	}
}
