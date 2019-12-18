/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.core.swt.peg.rules;

import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.DragCommand;
import org.eclipse.rcptt.tesla.core.protocol.DragKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ProcessingRule;

public class KeepOnlyLastDragSetData extends ProcessingRule {

	@Override
	public boolean matches(List<Command> commands) {
		if (!(get(-1, commands) instanceof DragCommand))
			return false;

		DragCommand dragCommand = (DragCommand) get(-1, commands);
		return dragCommand.getKind() == DragKind.SET_DATA;
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		for (int i = commands.size() - 2; i >= 0; --i) {
			Command c = commands.get(i);
			if (!(c instanceof DragCommand))
				continue;

			DragCommand dragCommand = (DragCommand) c;
			switch (dragCommand.getKind()) {
			case SET_DATA:
				return new ApplicationResult().remove(i);
			case START:
				return new ApplicationResult();
			}
		}

		return new ApplicationResult();
	}

}
