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

import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.Click;
import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.MatcherProcessingRule;

public class MouseUpSameCellAsMouseDown extends MatcherProcessingRule {

	@SuppressWarnings("unchecked")
	public MouseUpSameCellAsMouseDown() {

		super(and(command(-1, isMouseUp, isDefaultButton),
				command(-2, isGetItem),
				command(-3, isMouseDown, isDefaultButton, isEmptyStateMask),
				command(-4, isGetItem), commands(-2, -4, isSameCellInGetItem)));
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		Click click = ProtocolFactory.eINSTANCE.createClick();
		click.setElement(((ElementCommand) get(-3, commands)).getElement());
		return new ApplicationResult(3, click);
	}
}
