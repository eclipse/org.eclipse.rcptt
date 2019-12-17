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
package org.eclipse.rcptt.tesla.recording.core.gef;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.handles.AbstractHandle;

import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.gef.GefUtils.FigureAddress;

public interface IGMFRecordingProcessor {
	FigureAddress getHandleAddress(AbstractHandle handle);

	EditPart getEditPart(IFigure figure);

	List<Integer> getFigureAddress(IFigure resultFigure);

	void updateDragParts(Set<EditPart> dragPart, DragTracker dragTracker);

	Widget getModel(EditPart part);

	boolean isGMFMapped(EditPart part);

	PropertyNodeList getNodeProperties(EditPart part, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException;

	boolean isIgnored(IFigure resultFigure);

	EObject getEMFMode(EditPart part);

}
