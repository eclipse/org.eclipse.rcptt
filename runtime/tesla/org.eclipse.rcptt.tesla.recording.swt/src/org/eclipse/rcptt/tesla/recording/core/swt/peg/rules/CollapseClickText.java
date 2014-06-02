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

import org.eclipse.rcptt.tesla.core.protocol.ClickText;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ProcessingRule;

public class CollapseClickText extends ProcessingRule {

	@Override
	public boolean matches(List<Command> commands) {
		if (!(get(-1, commands) instanceof ClickText && get(-2, commands) instanceof ClickText))
			return false;

		ClickText last = (ClickText) get(-1, commands);
		ClickText prev = (ClickText) get(-2, commands);

		if (last.getElement() == null || prev.getElement() == null)
			return false;

		if (!last.getElement().getId().equals(prev.getElement().getId()))
			return false;

		return true;
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return new ApplicationResult(2, get(-1, commands));
	}

}
