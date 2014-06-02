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
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.APPLY_CELL_EDITOR;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.ELEMENT_COMMAND__ELEMENT;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.TYPE;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.TYPE__CODE;
import static org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage.Literals.ELEMENT__ID;
import static org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage.Literals.ELEMENT__KIND;

import java.util.List;

import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTEventRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.MatcherProcessingRule;

/**
 * This rule removes redundant pressing of Enter key, which is recorded on KeyUp by {@link SWTEventRecorder}, because
 * its field 'pressed' is cleared on Modify event.
 */
@SuppressWarnings("unchecked")
public class RemoveRedundantEnterAfterApplyCellEditor extends MatcherProcessingRule {

	public RemoveRedundantEnterAfterApplyCellEditor() {
		super(and(
				command(-3, and(isType, isKeyEnter)),
				command(-2, isApplyCellEditor),
				command(-1, and(isType, isKeyEnter, isElementKindGrid)),
				commands(-1, -2, areElementsSame)
				));
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return new ApplicationResult(1);
	}

	//

	private static Predicate<Command> isType = type(TYPE);
	private static Predicate<Command> isApplyCellEditor = type(APPLY_CELL_EDITOR);
	
	private static Predicate<Command> isKeyEnter = field(13, TYPE__CODE);
	private static Predicate<Command> isElementKindGrid = field(NebulaElementKinds.GRID,
			ELEMENT_COMMAND__ELEMENT, ELEMENT__KIND);
	private static Predicate<List<Command>> areElementsSame = eq(ELEMENT_COMMAND__ELEMENT, ELEMENT__ID);

}
