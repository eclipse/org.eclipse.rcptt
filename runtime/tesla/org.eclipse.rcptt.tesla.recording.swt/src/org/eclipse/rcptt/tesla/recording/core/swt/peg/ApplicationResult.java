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

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

public class ApplicationResult {
	public ApplicationResult(int drop, Command... add) {
		this.add = add;
		this.drop = drop;
	}

	public ApplicationResult(int drop) {
		this(drop, new Command[0]);
	}

	public ApplicationResult(Command[] add) {
		this(0, add);
	}

	public ApplicationResult() {
		this(0, new Command[0]);
	}

	public ApplicationResult remove(int... indexes) {
		remove = indexes;
		return this;
	}

	public final int drop;
	public final Command[] add;
	public int[] remove = new int[0];
}