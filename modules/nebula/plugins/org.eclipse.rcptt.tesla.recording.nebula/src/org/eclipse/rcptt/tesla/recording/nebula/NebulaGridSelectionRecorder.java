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
package org.eclipse.rcptt.tesla.recording.nebula;

import java.util.Collections;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.nebula.NebulaGridUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;

class NebulaGridSelectionRecorder extends NebulaRecordingDoodah {

	public static void processSelection(Widget widget, Event event, int type) {
		if (widget instanceof Grid) {
			FindResult result = getLocator().findElement(widget, true, false, false);
			if (result != null) {
				processViewers(event, type, result, (Grid) widget);
			}
		}

		// now, as we have the NebulaWidgetLocatorExtension & NebulaWidgetClassifierExtension,
		// the following case is processed by SWTEventRecorder
		//
		// else if (widget instanceof GridColumn)
		// processColumnHeaderSelection((GridColumn) widget);
	}

	//

	private static void processViewers(Event event, int type, FindResult result, Grid grid) {
		NebulaGridUIElement v = new NebulaGridUIElement(result.element, getRecorder());
		if (event.detail == SWT.CHECK)
			processItemChecking(event, v);
		else {
			// consider multi-selection case as more general,
			// so it covers the case when only single selections are permitted

			final String[][] selection = result.realElement.getMultiPathSelection();
			if (selection == null || selection.length == 0)
				return; // TODO should we record deselection too?

			if ((event.stateMask & (SWT.SHIFT | SWT.BUTTON1)) != 0) { // range
				if (grid.isCellSelectionEnabled()) {
					ItemPart from = NebulaGridSelectionManager.forGrid(grid).rangeFrom();
					ItemPart to = NebulaGridSelectionManager.forGrid(grid).handleRange(event);
					if (to != null) {
						if (from.equals(to)) // not range, actually
							v.setSelectionEx(Collections.singleton(from));
						else
							v.setSelectionRange(from, to);
					}
				} else {
					String[] from = selection[0];
					String[] to = selection[selection.length - 1];
					if (from.equals(to)) // not range, actually
						v.setSelection(from);
					else
						v.setSelectionRange(from, to);
				}
			} else {
				if (grid.isCellSelectionEnabled()) {
					Iterable<ItemPart> parts = NebulaGridSelectionManager.forGrid(grid).handle(event);
					v.setSelectionEx(parts);
				} else {
					if (selection.length > 1)
						v.setMultiSelection(selection);
					else
						v.setSelection(selection[0]);
				}
			}
		}
	}

	private static void processItemChecking(Event event, NebulaGridUIElement v) {
		if (event.item instanceof GridItem) {
			GridItem item = (GridItem) event.item;
			String[] sel = NebulaViewers.getPathByGridItem(item);

			v.checkItem(item.getChecked(), sel);
		}
	}

}
