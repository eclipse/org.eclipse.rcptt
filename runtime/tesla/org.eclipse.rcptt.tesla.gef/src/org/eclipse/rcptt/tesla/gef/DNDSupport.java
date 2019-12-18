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

import java.util.List;
import java.util.Set;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Tool;
import org.eclipse.gef.tools.SelectEditPartTracker;
import org.eclipse.gef.tools.SelectionTool;

import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;

public class DNDSupport {
	@SuppressWarnings("rawtypes")
	public static void fillDragParts(EditPart editPart,
			Set<EditPart> dragParts, EditPartViewer viewer,
			AbstractTeslaClient client) {
		dragParts.clear();
		if (editPart != null) {
			dragParts.add(editPart);
		}
		// Add all selected edit parts to list
		// List parts = viewer.getSelectedEditParts();
		// dragParts.addAll(parts);

		Tool tool = viewer.getEditDomain() != null ? viewer.getEditDomain().getActiveTool() : null;
		if (tool != null && tool instanceof SelectionTool) {
			DragTracker dragTracker = TeslaGefAccess.getDragTracker(tool);
			if (dragTracker != null) {
				if (dragTracker instanceof SelectEditPartTracker) {
					Object field = TeslaGefAccess.getEditPartField(dragTracker);
					if (field != null) {
						dragParts.add((EditPart) field);
					}
				}
				List<IGefReplayHelper> processors = client
						.getProcessors(IGefReplayHelper.class);
				for (IGefReplayHelper pr : processors) {
					pr.updateDragParts(dragParts, dragTracker);
				}

				// Check abstarct tool operations also
				List operationSet = TeslaGefAccess.getOperationSet(dragTracker);
				if (operationSet != null) {
					for (Object object : operationSet) {
						if (object instanceof EditPart) {
							dragParts.add((EditPart) object);
						}
					}
				}
			}
		}
		// Remove diagram itself
		if (viewer.getRootEditPart() != null) {
			dragParts.remove(viewer.getContents());
		}
	}
}
