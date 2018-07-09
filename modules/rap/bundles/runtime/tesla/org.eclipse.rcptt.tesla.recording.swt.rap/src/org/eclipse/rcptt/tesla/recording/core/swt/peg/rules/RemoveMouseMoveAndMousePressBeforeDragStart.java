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

import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.DragCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.ApplicationResult;

public class RemoveMouseMoveAndMousePressBeforeDragStart extends
		RemoveMousePressBeforeDragStart {

	@Override
	public boolean matches(List<Command> commands) {
		if (!super.matches(commands))
			return false;

		if (!(get(-3, commands) instanceof MouseCommand))
			return false;

		DragCommand dragCommand = (DragCommand) get(-1, commands);
		MouseCommand mouseCommand = (MouseCommand) get(-3, commands);

		if (mouseCommand.getKind() != MouseCommandKind.MOVE)
			return false;

		if (dragCommand.getX() != mouseCommand.getX()
				|| dragCommand.getY() != mouseCommand.getY())
			return false;

		return true;
	}

	@Override
	public ApplicationResult apply(List<Command> commands) {
		return new ApplicationResult(3, get(-1, commands));
	}

}
