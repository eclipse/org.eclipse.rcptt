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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.rcptt.core.ecl.model.ArgDecl;
import org.eclipse.rcptt.core.ecl.model.IDeclContainer;
import org.eclipse.rcptt.core.ecl.model.ProcDecl;
import org.eclipse.rcptt.core.ecl.model.VarDecl;
import org.eclipse.rcptt.core.ecl.parser.ast.Arg;
import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.Id;
import org.eclipse.rcptt.core.ecl.parser.ast.Node;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.parser.model.Proposal.ArgNameProposal;
import org.eclipse.rcptt.core.ecl.parser.model.Proposal.ProcNameProposal;
import org.eclipse.rcptt.core.ecl.parser.model.Proposal.VarValueProposal;

public class Completer {
	@SuppressWarnings("unchecked")
	public static List<Proposal> proposals(Script script, int offset, IDeclContainer container) {
		List<Proposal> result = new ArrayList<Proposal>();
		NodePath path = PathBuilder.path(script, offset, true);

		Suggestion isCommandName = isCommandName(path);
		if (isCommandName.isTrue) {
			return filter(topLevelProposals(container), isCommandName.prefix);
		}

		Suggestion isCommandArg = isCommandArg(path);
		if (isCommandArg.isTrue) {
			return filter(join(argNameProposals(isCommandArg.command, container), varValueProposals(container)),
					isCommandArg.prefix);
		}

		if (path.endsWith(Script.class)) {
			return topLevelProposals(container);
		}

		return result;
	}

	private static Suggestion isCommandArg(NodePath path) {
		if (path.endsWith(Command.class, Arg.class, Id.class)) {
			return pass(path.lastOf(Id.class).text, path.lastOf(Command.class));
		}
		if (path.endsWith(Command.class)) {
			// Since we already tested that it is not a command name,
			// we can assume that we are at argument now
			return pass("", path.lastOf(Command.class));
		}

		int offset = rollbackToNonSpace(path);
		if (offset == 0) {
			return fail;
		}

		NodePath lastCharPath = PathBuilder.path(path.script, offset);
		if (lastCharPath.lastNode() == path.lastNode()) {
			// same path
			return fail;
		}

		Command command = lastCharPath.lastOf(Command.class);
		if (command == null) {
			return fail;
		}

		return pass(command);

	}

	private static int rollbackToNonSpace(NodePath path) {
		String text = path.script.text;
		int offset = path.offset;
		while (spaceOrTabOrEOF(text, offset) && offset > 0) {
			offset--;
		}
		return offset;
	}

	private static boolean spaceOrTabOrEOF(String text, int offset) {
		return offset >= 0 && (text.length() <= offset || text.charAt(offset) == ' ' || text.charAt(offset) == '\t');
	}

	private static Suggestion isCommandName(NodePath path) {
		Node last = path.lastNode();
		Command lastCommand = path.lastOf(Command.class);
		if (!(last instanceof Id)) {
			return fail;
		}
		if (lastCommand == null) {
			return fail;
		}
		if (!lastCommand.name.containsOrEnds(path.offset)) {
			return fail;
		}

		return pass(upto(lastCommand.name, path.offset));
	}

	private static String upto(Id id, int offset) {
		return id.text.substring(0, offset - id.begin);
	}

	private static List<Proposal> filter(List<Proposal> proposals, String prefix) {
		if (prefix == null) {
			return proposals;
		}
		prefix = prefix.toLowerCase();
		List<Proposal> result = new ArrayList<Proposal>();
		for (Proposal p : proposals) {
			if (p.startsWith(prefix)) {
				result.add(p);
				p.prefixLength = prefix.length();
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private static List<Proposal> topLevelProposals(IDeclContainer cont) {
		return join(varValueProposals(cont), commandNameProposals(cont));
	}

	private static List<Proposal> argNameProposals(Command command, IDeclContainer cont) {
		List<Proposal> result = new ArrayList<Proposal>();
		ProcDecl proc = cont.resolveProc(command.name.text);
		if (proc == null) {
			return result;
		}

		Set<String> usedArgs = new HashSet<String>();
		for (Arg arg : command.args) {
			if (arg.name != null) {
				usedArgs.add(arg.name.text.substring(1));
			}
		}

		for (ArgDecl arg : proc.getArgs()) {
			if (usedArgs.contains(arg.name)) {
				continue;
			}
			result.add(new ArgNameProposal(arg));
		}
		return result;
	}

	private static List<Proposal> commandNameProposals(IDeclContainer cont) {
		List<Proposal> result = new ArrayList<Proposal>();
		for (ProcDecl proc : cont.getProcs()) {
			result.add(new ProcNameProposal(proc));
		}
		return result;
	}

	private static List<Proposal> varValueProposals(IDeclContainer cont) {
		List<Proposal> result = new ArrayList<Proposal>();
		for (VarDecl var : cont.getVars()) {
			result.add(new VarValueProposal(var));
		}
		return result;
	}

	private static List<Proposal> join(List<Proposal>... proposals) {
		List<Proposal> result = new ArrayList<Proposal>();
		for (List<Proposal> list : proposals) {
			result.addAll(list);
		}
		return result;
	}

	private static class Suggestion {
		public Suggestion(boolean isTrue, String prefix, Command command) {
			this.isTrue = isTrue;
			this.prefix = prefix;
			this.command = command;
		}

		final boolean isTrue;
		final String prefix;
		final Command command;
	}

	private static final Suggestion fail = new Suggestion(false, null, null);

	private static Suggestion pass(String prefix) {
		return new Suggestion(true, prefix, null);
	}

	private static Suggestion pass(Command command) {
		return new Suggestion(true, null, command);
	}

	private static Suggestion pass(String prefix, Command command) {
		return new Suggestion(true, prefix, command);
	}

}
