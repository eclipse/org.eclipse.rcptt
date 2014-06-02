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
package org.eclipse.rcptt.tesla.recording.core.swt.peg;

import java.util.List;

import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.util.Predicates;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

public class CommandPredicate implements Predicate<List<Command>> {
	public CommandPredicate(int index, Predicate<Command> predicate) {
		this.index = index;
		this.predicate = predicate;
	}

	public CommandPredicate and(Predicate<Command> predicate) {
		return new CommandPredicate(index, Predicates.and(this.predicate,
				predicate));
	}

	public static CommandPredicate all(int index,
			Predicate<Command>... predicates) {
		return new CommandPredicate(index, Predicates.and(predicates));
	}

	public static CommandPredicate any(int index,
			Predicate<Command>... predicates) {
		return new CommandPredicate(index, Predicates.or(predicates));
	}

	public final boolean defVal = false;
	public final int index;
	public final Predicate<Command> predicate;

	public boolean apply(List<Command> input) {
		Command command = MatcherProcessingRule.get(index, input);
		if (command == null) {
			return defVal;
		}
		return predicate.apply(command);
	}

}