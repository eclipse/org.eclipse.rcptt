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
package org.eclipse.rcptt.tesla.recording.core.swt.peg.rules;

import static org.eclipse.rcptt.util.Predicates.and;

import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.MatcherProcessingRule;

public class SelectAfterMouseDownInTable extends MatcherProcessingRule {
	@SuppressWarnings("unchecked")
	public SelectAfterMouseDownInTable() {
		super(and(command(-1, isSetTreeOrTableSelection),
				command(-2, isMouseDown)));
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return drop(1);
	}
}