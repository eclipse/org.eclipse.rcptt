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
package org.eclipse.rcptt.tesla.recording.core.swt.peg.rules;

import static org.eclipse.rcptt.util.Predicates.and;
import static org.eclipse.rcptt.util.Predicates.not;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.protocol.MouseEvent;
import org.eclipse.rcptt.tesla.core.protocol.MouseEventKind;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.MatcherProcessingRule;

public class MouseUpSameTableAsMouseDown extends MatcherProcessingRule {

	@SuppressWarnings("unchecked")
	public MouseUpSameTableAsMouseDown() {

		super(and(command(-1, isMouseUp), command(-2, isGetItem),
				command(-3, isMouseDown), command(-4, isGetItem),
				commands(-2, -4, sameParentInGetItem, not(sameSelectData))));
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		MouseEvent mouseUp = (MouseEvent) get(-1, commands);
		MouseEvent mouseMove = ProtocolFactory.eINSTANCE.createMouseEvent();
		mouseMove.setButton(0);
		mouseMove.setCount(0);
		mouseMove.setElement(EcoreUtil.copy(mouseUp.getElement()));
		mouseMove.setKind(MouseEventKind.MOVE);
		mouseMove.setStateMask(mouseUp.getStateMask());
		return new ApplicationResult(1, mouseMove, mouseUp);
	}
}
