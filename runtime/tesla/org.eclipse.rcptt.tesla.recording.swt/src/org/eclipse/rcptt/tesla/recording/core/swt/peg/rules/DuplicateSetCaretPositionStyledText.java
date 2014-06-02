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
package org.eclipse.rcptt.tesla.recording.core.swt.peg.rules;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import static org.eclipse.rcptt.util.Predicates.and;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.MatcherProcessingRule;

public class DuplicateSetCaretPositionStyledText extends MatcherProcessingRule {

	@SuppressWarnings("unchecked")
	public DuplicateSetCaretPositionStyledText() {
		super(and(command(-3, isSetTextOffset),
				command(-1, isSetTextOffset),
				commands(-1, -3, isSameOffsetOffset),
				commands(-1, -3, isSameOffsetLine)));
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		SelectCommand firstSelectCommand = (SelectCommand) get(-4, commands);
		SelectCommand secondSelectCommand = (SelectCommand) get(-2, commands);

		int elementsToDrop = 0;
		if (EcoreUtil.equals(firstSelectCommand.getData().getParent(), secondSelectCommand.getData().getParent()))
			elementsToDrop = 2;

		return drop(elementsToDrop);
	}
}
