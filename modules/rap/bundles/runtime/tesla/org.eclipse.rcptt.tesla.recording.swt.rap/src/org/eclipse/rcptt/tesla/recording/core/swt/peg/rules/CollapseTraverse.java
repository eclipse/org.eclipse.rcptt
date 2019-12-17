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

import org.eclipse.rcptt.tesla.core.protocol.Type;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ProcessingRule;
import org.eclipse.rcptt.tesla.recording.core.swt.rap.SWTEventRecorder;

public class CollapseTraverse extends ProcessingRule {

	@Override
	public boolean matches(List<Command> commands) {
		if (SWTEventRecorder.keysSeen)
			return false;

		if (!(get(-1, commands) instanceof Type && get(-2, commands) instanceof Type))
			return false;

		Type last = (Type) get(-1, commands);
		Type prev = (Type) get(-2, commands);

		if (!(last.isTraverse() && prev.isTraverse()))
			return false;

		return true;
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return new ApplicationResult(2, get(-1, commands));
	}

}
