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

import org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.SetSelection;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ProcessingRule;

public class CollapseSelectAfterCellEdit extends ProcessingRule {

	@Override
	public boolean matches(List<Command> commands) {
		if ((get(-1, commands) instanceof SetSelection && get(-2, commands) instanceof ActivateCellEditor)) {
			return true;
		}
		return false;
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return new ApplicationResult(1);
	}

}
