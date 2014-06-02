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

import org.eclipse.rcptt.core.ecl.model.BuiltinProcDecl;
import org.eclipse.rcptt.core.ecl.model.Declaration;
import org.eclipse.rcptt.core.ecl.model.IDeclContainer;
import org.eclipse.rcptt.core.ecl.model.ProcDecl;
import org.eclipse.rcptt.core.ecl.model.VarDecl;
import org.eclipse.rcptt.core.ecl.parser.ast.Id;
import org.eclipse.rcptt.core.ecl.parser.ast.Node;
import org.eclipse.rcptt.core.ecl.parser.ast.NodeVisitor;
import org.eclipse.rcptt.core.ecl.parser.ast.Reference;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;

public class Finder {
	private OccurrencesSettings settings;

	public Finder(OccurrencesSettings settings) {
		this.settings = settings;
	}

	private static Node[] empty = new Node[0];

	public Node[] find(final Script script, int offset, final IDeclContainer container) {
		if (!settings.enabled) {
			return empty;
		}
		Reference ref = Resolver.resolve(script, offset, container);
		if (ref == null) {
			return empty;
		}

		final Declaration decl = ref.dest;
		if (decl instanceof BuiltinProcDecl && !settings.commands) {
			return empty;
		}

		if (!(decl instanceof BuiltinProcDecl) && decl instanceof ProcDecl && !settings.procs) {
			return empty;
		}
		if (decl instanceof VarDecl && ((VarDecl) decl).isGlobal && !settings.globals) {
			return empty;
		}

		if (decl instanceof VarDecl && !((VarDecl) decl).isGlobal && !settings.locals) {
			return empty;
		}

		final List<Node> result = new ArrayList<Node>();
		script.accept(new NodeVisitor() {
			@Override
			public void exit(Node node) {
				// TODO inefficient, remake
				if (!(node instanceof Id)) {
					return;
				}
				Reference ref = Resolver.resolve(script, node.begin, container);
				if (ref != null && ref.dest == decl) {
					result.add(node);
				}
			}

			@Override
			public boolean enter(Node node) {
				return true;
			}
		});
		if (decl.container.getResource() != null && decl.container.getResource().equals(container.getResource())) {
			result.add(new Id(decl.name, decl.location.begin, decl.location.end));
		}
		return result.toArray(new Node[result.size()]);
	}
}
