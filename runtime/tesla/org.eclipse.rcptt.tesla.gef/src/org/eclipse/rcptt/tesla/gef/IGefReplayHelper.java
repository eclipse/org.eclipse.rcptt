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
package org.eclipse.rcptt.tesla.gef;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;

import org.eclipse.rcptt.tesla.core.ui.Widget;

public interface IGefReplayHelper {
	IFigure getFigure(List<Integer> path, GraphicalEditPart part);

	Widget getModel(EditPart part);

	public boolean isGMFMapped(EditPart part);

	public String getPropertyValue(EditPart part, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException;

	void updateDragParts(Set<EditPart> dragParts, DragTracker dragTracker);

	EObject getEMFMode(EditPart part);
}
