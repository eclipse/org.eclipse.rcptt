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

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.MatcherProcessingRule;

public class DuplicateMouseMoveOverEditPart extends MatcherProcessingRule {

	@SuppressWarnings("unchecked")
	public DuplicateMouseMoveOverEditPart() {
		super(and(command(-1, isFigureMouseMoveNoButtons),
				command(-2, isSelectEditPart),
				command(-3, isFigureMouseMoveNoButtons),
				command(-4, isSelectEditPart)));
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		// Well, it's tricky, but because of current implementation
		// of SelectCommand we cannot just drop the first select command
		// as this might lead to the fact that selection data in
		// the last one is not enough. So we check whether two select commands
		// have the same parent, and if not, we preserve first select
		SelectCommand select1 = (SelectCommand) get(-4, commands);
		SelectCommand select2 = (SelectCommand) get(-2, commands);
		Command mouseMove = get(-1, commands);

		int toDrop = EcoreUtil.equals(select1.getData().getParent(), select2
				.getData().getParent()) ? 4 : 3;
		return new ApplicationResult(toDrop, select2, mouseMove);
	}

}
