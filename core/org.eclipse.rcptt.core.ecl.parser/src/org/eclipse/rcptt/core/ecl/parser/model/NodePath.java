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

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.Node;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;

public class NodePath {
	public final int offset;
	public final Script script;

	public NodePath(List<Node> nodes, Script script, int offset) {
		this.nodes = nodes;
		this.offset = offset;
		this.script = script;
	}

	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	public List<Node> nodes;

	public List<Command> findCommands(String... names) {
		List<Command> result = new ArrayList<Command>();
		List<String> namesList = asList(names);
		for (Node node : nodes) {
			if (node instanceof Command) {
				Command cmd = (Command) node;
				if (namesList.contains(cmd.name.text)) {
					result.add(cmd);
				}
			}
		}
		return result;
	}

	public Command lastCommand(String name) {
		List<Command> commands = findCommands(name);
		if (commands.isEmpty()) {
			return null;
		}
		return commands.get(commands.size() - 1);
	}

	public <T> boolean endsWith(Class<T> clazz) {
		return !isEmpty() && clazz.isAssignableFrom(lastNode().getClass());
	}

	public <T> T lastOf(Class<T> clazz) {
		for (int i = nodes.size() - 1; i >= 0; i--) {
			Node node = nodes.get(i);
			if (clazz.isAssignableFrom(node.getClass())) {
				return clazz.cast(node);
			}
		}
		return null;
	}

	public <T> T firstOf(Class<T> clazz) {
		for (Node node : nodes) {
			if (clazz.isAssignableFrom(node.getClass())) {
				return clazz.cast(node);
			}
		}
		return null;
	}

	public boolean endsWith(Class<?>... classes) {
		if (classes.length > nodes.size()) {
			return false;
		}

		int delta = nodes.size() - classes.length;
		for (int i = 0; i < classes.length; i++) {
			if (!(classes[i].isAssignableFrom(nodes.get(i + delta).getClass()))) {
				return false;
			}
		}
		return true;
	}

	public Node lastNode() {
		return nodes.isEmpty() ? null : nodes.get(nodes.size() - 1);
	}

	public Node fromEnd(int i) {
		int index = nodes.size() - 1 - i;
		if (index < 0 || index >= nodes.size()) {
			return null;
		}
		return nodes.get(index);
	}
}
