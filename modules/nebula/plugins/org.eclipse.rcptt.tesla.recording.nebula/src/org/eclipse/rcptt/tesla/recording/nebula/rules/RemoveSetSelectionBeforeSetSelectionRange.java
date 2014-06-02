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
package org.eclipse.rcptt.tesla.recording.nebula.rules;

import static org.eclipse.rcptt.util.Predicates.and;
import static org.eclipse.rcptt.util.Predicates.or;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SET_SELECTION;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SET_SELECTION__PATH;
import static org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage.Literals.SET_SELECTION_RANGE;
import static org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage.Literals.SET_SELECTION_RANGE__TO_PATH;

import java.util.List;

import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.MatcherProcessingRule;

@SuppressWarnings("unchecked")
public class RemoveSetSelectionBeforeSetSelectionRange extends MatcherProcessingRule {

	public RemoveSetSelectionBeforeSetSelectionRange() {
		super(and(
				commands(-1, -2, isSameElement),
				or(
						and(command(-2, isSetSelection), command(-1, isSetSelectionRange)),
						and(command(-2, isSetSelectionRange), command(-1, isSetSelection))
				)));
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return new ApplicationResult(2, get(-1, commands));
	}

	//

	private static Predicate<Command> isSetSelection = type(SET_SELECTION);
	private static Predicate<Command> isSetSelectionRange = type(SET_SELECTION_RANGE);
	
	private static Predicate<List<Command>> isSameFromPath = eq(SET_SELECTION__PATH);
	private static Predicate<List<Command>> isSameToPath = eq(SET_SELECTION_RANGE__TO_PATH);

	// TODO ?? write different matcher for this case
	private static Predicate<List<Command>> recordAllSelections = new Predicate<List<Command>>() {
		@Override
		public boolean apply(List<Command> input) {
			return TeslaFeatures.getInstance().isTrue(TeslaFeatures.RECORD_ALL_SELECTIONS);
		}
	};

}
