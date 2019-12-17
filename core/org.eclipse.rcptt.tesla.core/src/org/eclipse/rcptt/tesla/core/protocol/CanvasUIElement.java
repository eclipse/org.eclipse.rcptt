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
package org.eclipse.rcptt.tesla.core.protocol;

import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramFactory;
import org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class CanvasUIElement extends CompositeUIElement {

	public CanvasUIElement(Element e, UIPlayer player) {
		super(e, player);
	}

	public void executeMouseCommand(int x, int y, int button,
			MouseCommandKind kind) {
		MouseCommand command = DiagramFactory.eINSTANCE.createMouseCommand();
		command.setKind(kind);
		command.setButton(button);
		command.setElement(getElement());
		command.setX(x);
		command.setY(y);
		player.safeExecuteCommand(command);
	}

	public void executeFigureMouseCommand(int x, int y, int button,
			MouseCommandKind kind, List<Integer> partPath,
			List<Integer> figurePath, int width, int height, int figureWidth,
			int figureHeight, int stateMask) {
		FigureMouseCommand command = DiagramFactory.eINSTANCE
				.createFigureMouseCommand();
		command.setKind(kind);
		command.setButton(button);
		command.setElement(getElement());
		command.setX(x);
		command.setY(y);
		command.setBoundsWidth(width);
		command.setBoundsHeight(height);
		command.setFigureHeight(figureHeight);
		command.setFigureWidth(figureWidth);
		command.setStateMask(stateMask);
		if (figurePath != null) {
			command.getFigurePath().addAll(figurePath);
		}
		if (partPath != null) {
			command.getPartPath().addAll(partPath);
		}
		player.safeExecuteCommand(command);
	}

	public void mouseDown(int x, int y, int button) {
		executeMouseCommand(x, y, button, MouseCommandKind.DOWN);
	}

	public void mouseUp(int x, int y, int button) {
		executeMouseCommand(x, y, button, MouseCommandKind.UP);
	}

	public void mouseDrag(int x, int y, int button) {
		executeMouseCommand(x, y, button, MouseCommandKind.DRAG);
	}

	public void mouseDoubleClick(int x, int y, int button) {
		executeMouseCommand(x, y, button, MouseCommandKind.DOUBLE_CLICK);
	}

	public void mouseNativeDragStarted(int x, int y) {
		executeMouseCommand(x, y, 0, MouseCommandKind.NATIVE_DRAG_STARTED);
	}

	public void mouseNativeDragFinished(int x, int y) {
		executeMouseCommand(x, y, 0, MouseCommandKind.NATIVE_DRAG_FINISHED);
	}

	public void mouseMove(int x, int y) {
		executeMouseCommand(x, y, 0, MouseCommandKind.MOVE);
	}
}
