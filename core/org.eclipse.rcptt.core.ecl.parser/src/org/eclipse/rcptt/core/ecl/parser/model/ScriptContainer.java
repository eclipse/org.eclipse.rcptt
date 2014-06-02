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
package org.eclipse.rcptt.core.ecl.parser.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.core.ecl.model.ArgDecl;
import org.eclipse.rcptt.core.ecl.model.BaseContainer;
import org.eclipse.rcptt.core.ecl.model.ProcDecl;
import org.eclipse.rcptt.core.ecl.model.SrcLoc;
import org.eclipse.rcptt.core.ecl.model.VarDecl;
import org.eclipse.rcptt.core.ecl.parser.ast.Arg;
import org.eclipse.rcptt.core.ecl.parser.ast.BoolArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.Id;
import org.eclipse.rcptt.core.ecl.parser.ast.LiteralArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Node;
import org.eclipse.rcptt.core.ecl.parser.ast.Pipeline;
import org.eclipse.rcptt.core.ecl.parser.ast.PipelineArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;

public class ScriptContainer extends BaseContainer {

	public static ScriptContainer fromScript(Script script, String id) {
		ScriptContainer result = new ScriptContainer();
		result.resource = id;
		for (Pipeline pipeline : script.pipelines) {
			ProcDecl proc = procFromPipeline(pipeline);
			if (proc != null) {
				result.addProc(proc);
			}
			result.addAllVars(globalVars(pipeline));
		}
		return result;
	}

	protected static List<VarDecl> globalVars(Pipeline line) {
		List<VarDecl> result = new ArrayList<VarDecl>();
		if (line.commands.size() != 1) {
			return result;
		}
		Command cmd = line.commands.get(0);
		if (!cmd.name.text.equals("global")) {
			return result;
		}

		for (Arg arg : cmd.args) {
			VarDecl var = varFromArg(arg);
			if (var != null) {
				var.isGlobal = true;
				result.add(var);
			}
		}

		return result;
	}

	protected static ProcDecl procFromPipeline(Pipeline line) {
		if (line.commands.size() != 1) {
			return null;
		}
		Command cmd = line.commands.get(0);
		if (!cmd.name.text.equals("proc")) {
			return null;
		}
		if (cmd.args.size() == 0) {
			return null;
		}
		Arg nameArg = cmd.args.get(0);
		if (!(nameArg instanceof LiteralArg)) {
			return null;
		}
		Id procName = unquote(((LiteralArg) nameArg).value);
		if (procName.text.startsWith("$")) {
			return null;
		}
		ProcDecl result = new ProcDecl(procName.text, fromNode(procName));

		for (int i = 1; i < cmd.args.size() - 1; i++) {
			Arg arg = cmd.args.get(i);
			ArgDecl param = paramFromArg(arg);
			if (param != null) {
				result.addArg(param);
			}
		}

		return result;
	}

	protected static ArgDecl paramFromArg(Arg arg) {
		VarDecl var = varFromArg(arg);
		if (var == null) {
			return null;
		}
		ArgDecl result = new ArgDecl(var.name, var.location);
		result.hasDefaultValue = var.hasDefaultValue;
		result.isInput = var.isInput;
		result.simpleValue = var.simpleValue;
		return result;
	}

	protected static VarDecl varFromArg(Arg arg) {
		if (!(arg instanceof PipelineArg)) {
			return null;
		}

		Pipeline pipeline = ((PipelineArg) arg).pipeline;
		if (pipeline.commands.size() != 1) {
			return null;
		}

		Command command = pipeline.commands.get(0);

		if (!(command.name.text.equals("val"))) {
			return null;
		}

		if (command.args.size() == 0) {
			return null;
		}

		Arg nameArg = command.args.get(0);
		if (!(nameArg instanceof LiteralArg)) {
			return null;
		}

		Id name = unquote(((LiteralArg) nameArg).value);

		VarDecl result = new VarDecl(name.text, fromNode(name));

		if (command.args.size() > 1) {
			Arg second = command.args.get(1);
			if (second instanceof BoolArg && second.name.text.equals("-input")) {
				result.isInput = true;
			} else {
				result.hasDefaultValue = true;
				if (second instanceof LiteralArg) {
					result.simpleValue = unquote(((LiteralArg) second).value).text;
				}
			}
		}

		return result;
	}

	private static Id unquote(Id id) {
		if (id.text.startsWith("\"")) {
			return new Id(id.text.substring(1, id.text.length() - 1), id.begin + 1, id.end - 1);
		}
		return id;
	}

	private static SrcLoc fromNode(Node node) {
		return new SrcLoc(node.begin, node.end);
	}
}
