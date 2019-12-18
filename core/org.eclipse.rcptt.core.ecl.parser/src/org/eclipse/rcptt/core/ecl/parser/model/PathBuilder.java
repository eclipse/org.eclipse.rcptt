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
package org.eclipse.rcptt.core.ecl.parser.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.core.ecl.parser.ast.Node;
import org.eclipse.rcptt.core.ecl.parser.ast.NodeVisitor;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;

public class PathBuilder implements NodeVisitor {
	public static NodePath path(Script script, int offset) {
		return path(script, offset, false);
	}

	public static NodePath path(Script script, int offset, boolean inclusiveEnd) {
		PathBuilder visitor = new PathBuilder(offset, inclusiveEnd);
		script.accept(visitor);
		return new NodePath(visitor.nodes, script, offset);
	}

	private int offset;
	private boolean inclusiveEnd;
	private List<Node> nodes = new ArrayList<Node>();

	public PathBuilder(int offset, boolean inclusiveEnd) {
		this.offset = offset;
		this.inclusiveEnd = inclusiveEnd;
	}

	@Override
	public boolean enter(Node node) {
		if (node.begin > offset) {
			return false;
		}

		boolean after = inclusiveEnd ? node.end < offset : node.end <= offset;
		if (after) {
			return false;
		}
		nodes.add(node);
		return true;
	}

	@Override
	public void exit(Node node) {
	}

}