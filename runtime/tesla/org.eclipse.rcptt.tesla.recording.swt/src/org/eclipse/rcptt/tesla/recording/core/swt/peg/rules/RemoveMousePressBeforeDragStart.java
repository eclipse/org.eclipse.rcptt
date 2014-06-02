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

import org.eclipse.rcptt.tesla.core.protocol.DragCommand;
import org.eclipse.rcptt.tesla.core.protocol.DragKind;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ProcessingRule;

public class RemoveMousePressBeforeDragStart extends ProcessingRule {

	@Override
	public boolean matches(List<Command> commands) {
		if (!(get(-1, commands) instanceof DragCommand && get(-2, commands) instanceof MouseCommand))
			return false;

		DragCommand dragCommand = (DragCommand) get(-1, commands);
		MouseCommand mouseCommand = (MouseCommand) get(-2, commands);

		if (dragCommand.getKind() != DragKind.START
				|| mouseCommand.getKind() != MouseCommandKind.DOWN)
			return false;

		if (dragCommand.getX() != mouseCommand.getX()
				|| dragCommand.getY() != mouseCommand.getY()
				|| mouseCommand.getButton() != 1)
			return false;

		return true;
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return new ApplicationResult(2, get(-1, commands));
	}

}
