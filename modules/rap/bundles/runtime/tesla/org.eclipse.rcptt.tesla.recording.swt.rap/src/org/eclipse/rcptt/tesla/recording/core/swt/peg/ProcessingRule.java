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

import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

public abstract class ProcessingRule {

	public abstract boolean matches(List<Command> commands);

	public abstract ApplicationResult apply(List<Command> commands);

	protected static Command get(int index, List<Command> commands) {
		if (index < 0) {
			index = index + commands.size();
		}
		if (index < 0 || index >= commands.size()) {
			return null;
		}
		return commands.get(index);
	}

	protected static Command getLast(List<Command> commands) {
		return commands.get(-1);
	}

	protected static ApplicationResult drop(int index) {
		return new ApplicationResult(index);
	}
}