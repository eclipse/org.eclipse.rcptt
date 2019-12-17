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

import java.util.List;

import org.eclipse.rcptt.util.StringUtils;
import org.eclipse.rcptt.tesla.core.protocol.SetText;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ProcessingRule;

public class QuickAccessIgnoreEmptySetText extends ProcessingRule {

	@Override
	public boolean matches(List<Command> commands) {
		if (!(get(-1, commands) instanceof SetText))
			return false;

		SetText last = (SetText) get(-1, commands);
		if (last.getElement() == null
				|| last.getElement().getDescription() == null
				|| !last.getElement().getDescription().equals("quick-access"))
			return false;

		if (!StringUtils.isEmpty(last.getValue()))
			return false;

		return true;
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return new ApplicationResult(1);
	}

}
