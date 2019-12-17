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

import org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.DeactivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ProcessingRule;

public class CollapseApplyDeactivate extends ProcessingRule {

	@Override
	public boolean matches(List<Command> commands) {
		Command prev = get(-2, commands);
		Command last = get(-1, commands);
		if ((prev instanceof ApplyCellEditor && last instanceof DeactivateCellEditor)) {
			return true;
		}
		return false;
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		ApplyCellEditor apply = (ApplyCellEditor) get(-2, commands);
		apply.setDeactivate(true);
		return new ApplicationResult(2, apply);
	}

}
