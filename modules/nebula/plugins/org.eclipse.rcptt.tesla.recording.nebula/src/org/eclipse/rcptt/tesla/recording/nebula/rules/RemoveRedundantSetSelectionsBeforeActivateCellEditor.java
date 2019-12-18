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
package org.eclipse.rcptt.tesla.recording.nebula.rules;

import static org.eclipse.rcptt.util.Predicates.and;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.ACTIVATE_CELL_EDITOR;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SET_SELECTION;
import static org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage.Literals.SET_SELECTION_EX;

import java.util.List;

import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.MatcherProcessingRule;

@SuppressWarnings("unchecked")
public class RemoveRedundantSetSelectionsBeforeActivateCellEditor extends MatcherProcessingRule {

	public RemoveRedundantSetSelectionsBeforeActivateCellEditor() {
		super(and(
				command(-3, isSetSelectionEx),
				command(-2, isSetSelection),
				command(-1, isActivateCellEditor)
				));
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return new ApplicationResult(3,
				get(-1, commands));
	}

	//

	private static Predicate<Command> isSetSelection = type(SET_SELECTION);
	private static Predicate<Command> isSetSelectionEx = type(SET_SELECTION_EX);
	private static Predicate<Command> isActivateCellEditor = type(ACTIVATE_CELL_EDITOR);
	
}
