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
package org.eclipse.rcptt.tesla.recording.core.swt.peg;

import java.util.List;

import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

public abstract class TwoCommandsPredicate implements Predicate<List<Command>> {
	public boolean apply(List<Command> input) {
		if (input.size() != 2) {
			return false;
		}
		return apply(input.get(0), input.get(1));
	}

	protected abstract boolean apply(Command c1, Command c2);
}
