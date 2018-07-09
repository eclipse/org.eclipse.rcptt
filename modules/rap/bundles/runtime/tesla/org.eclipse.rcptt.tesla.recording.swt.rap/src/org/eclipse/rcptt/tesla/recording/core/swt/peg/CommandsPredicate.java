/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.core.swt.peg;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

class CommandsPredicate implements Predicate<List<Command>> {
	private final int[] indices;
	private final Predicate<List<Command>> predicate;

	public CommandsPredicate(int[] indices, Predicate<List<Command>> predicate) {
		this.indices = indices;
		this.predicate = predicate;
	}

	public boolean apply(List<Command> input) {
		List<Command> commands = new ArrayList<Command>();
		for (int index : indices) {
			Command cmd = MatcherProcessingRule.get(index, input);
			if (cmd == null) {
				return false;
			}
			commands.add(cmd);
		}
		return predicate.apply(commands);
	}
}
