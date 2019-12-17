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
package org.eclipse.rcptt.tesla.recording.aspects.gef;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.events.MouseEvent;

import org.eclipse.rcptt.tesla.gef.DirectEditorContainer;

public interface IGefEventListener {
	public void performRequest(EditPart part, Request request);

	public void toolActivate(Tool tool);

	public void setActiveTool(EditDomain domain, Tool tool);

	public void notifyAddChild(AbstractEditPart part, EditPart child, int index);

	public void mouseDown(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer);

	public void afterMouseDown(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer);

	public void mouseUp(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer);

	public void afterMouseUp(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer);

	public void mouseHover(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer);

	public void mouseMove(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer);

	public void mouseDrag(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer);

	public void mouseDoubleClick(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer);

	public void mouseWheelScrolled(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer);

	public void executeCommand(Command command);

	public void nativeDragStarted(EditDomain domain, DragSourceEvent event,
			EditPartViewer viewer);

	public void nativeDragFinished(EditDomain domain, DragSourceEvent event,
			EditPartViewer viewer);

	public void commitDirectEdit(DirectEditorContainer container);

	public void cancelDirectEdit(DirectEditorContainer container);

	public void forceDirectEdit(DirectEditManager manager);

	public void handleDelayedDirectEdit(Object helper);

	public void notifyRemoveChild(AbstractEditPart part, EditPart child,
			int index);
}
