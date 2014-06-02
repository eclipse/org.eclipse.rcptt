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

import org.eclipse.rcptt.core.ecl.model.Declaration;
import org.eclipse.rcptt.core.ecl.model.IDeclContainer;
import org.eclipse.rcptt.core.ecl.model.ProcDecl;
import org.eclipse.rcptt.core.ecl.parser.ast.Arg;
import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.Id;
import org.eclipse.rcptt.core.ecl.parser.ast.LiteralArg;
import org.eclipse.rcptt.core.ecl.parser.ast.Node;
import org.eclipse.rcptt.core.ecl.parser.ast.Reference;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;

public class Resolver {
	public static Reference resolve(Script script, int offset, IDeclContainer cont) {
		NodePath path = PathBuilder.path(script, offset);
		Node lastNode = path.lastNode();
		if (!(lastNode instanceof Id)) {
			return null;
		}

		Id id = (Id) lastNode;
		Node parent = path.fromEnd(1);
		boolean isCommand = parent instanceof Command;
		boolean isArgValue = parent instanceof LiteralArg && ((LiteralArg) parent).value.contains(offset);
		boolean isArgName = parent instanceof Arg && ((Arg) parent).name != null
				&& ((Arg) parent).name.contains(offset);

		if (!isCommand && !isArgValue && !isArgName) {
			return null;
		}

		boolean dollar = id.text.startsWith("$");
		if (isArgValue && !dollar) {
			return null;
		}

		boolean dash = id.text.startsWith("-");
		if (isArgName && !dash) {
			return null;
		}

		Declaration decl = null;
		if (isCommand) {
			decl = dollar ? cont.resolveVar(id.text.substring(1)) : cont.resolveProc(id.text);
		} else if (isArgName) {
			Command command = path.lastOf(Command.class);
			if (command == null) {
				return null;
			}
			ProcDecl proc = cont.resolveProc(command.name.text);
			if (proc == null) {
				return null;
			}

			decl = proc.resolveArg(id.text.substring(1));
		} else if (isArgValue) {
			decl = cont.resolveVar(id.text.substring(1));
		}

		if (decl == null) {
			return null;
		}
		return new Reference(id, decl);

	}
}
