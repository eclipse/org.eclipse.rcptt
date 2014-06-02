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
package org.eclipse.rcptt.tesla.recording.nebula;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.BasicUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.nebula.NebulaGridUIElement;
import org.eclipse.rcptt.tesla.core.protocol.nebula.NebulaItemUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.nebula.NebulaPartUIElement;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ColumnHeader;
import org.eclipse.rcptt.tesla.nebula.grid.parts.EmptyArea;
import org.eclipse.rcptt.tesla.nebula.grid.parts.GridPart;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemCell;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;
import org.eclipse.rcptt.tesla.nebula.grid.parts.RowHeader;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;
import org.eclipse.rcptt.tesla.recording.core.swt.BasicRecordingHelper.ElementEntry;
import org.eclipse.rcptt.tesla.recording.core.swt.IWidgetClassifierExtension;
import org.eclipse.rcptt.tesla.recording.core.swt.IWidgetLocatorExtension;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTWidgetLocator;

public class NebulaWidgetLocatorExtension implements IWidgetLocatorExtension {

	private SWTWidgetLocator wl;

	public NebulaWidgetLocatorExtension(SWTWidgetLocator wl) {
		this.wl = wl;
	}

	//

	@Override
	public FindResult findElement(SWTUIElement widget, boolean unknownAllowed,
			boolean alwaysFindLeaf, boolean supportEclipseWorkbench) {

		// has already been found
		ElementEntry element = NebulaRecordingHelper.getHelper().get(widget);
		if (element != null && !alwaysFindLeaf)
			return new FindResult(widget, element.getElement());
		//

		BasicUIElement found = null;
		if (widget.unwrap() instanceof GridItem)
			found = findGridItem(widget.unwrap(), alwaysFindLeaf, supportEclipseWorkbench);
		else if (widget.unwrap() instanceof GridColumn)
			found = findGridColumn(widget.unwrap(), alwaysFindLeaf, supportEclipseWorkbench);
		else if (widget instanceof NebulaPartUIElement)
			found = findGridPart(((NebulaPartUIElement) widget).part, alwaysFindLeaf, supportEclipseWorkbench);

		//
		if (found != null) {
			// cache the result in the helper
			NebulaRecordingHelper.getHelper().put(widget, new ElementEntry(found.getElement()));
			return new FindResult(widget, found.getElement());
		}
		return null;
	}

	private BasicUIElement findGridColumn(Widget widget, boolean alwaysFindLeaf,
			boolean supportEclipseWorkbench) {
		SWTUIElement uiElement = wl.getPlayer().wrap(widget);

		GridColumn column = (GridColumn) widget;
		ViewerUIElement gridView = gridView(column.getParent(), supportEclipseWorkbench);

		wl.getRecorder().setControls(SWTModelMapper.map(wl.getPlayer().wrap(column)));
		return gridView.column(column.getText(), wl.calculateIndex(uiElement, null));
	}

	private BasicUIElement findGridItem(Widget widget, boolean alwaysFindLeaf,
			boolean supportEclipseWorkbench) {

		GridItem item = (GridItem) widget;
		ViewerUIElement gridView = gridView(item.getParent(), supportEclipseWorkbench);

		wl.getRecorder().setControls(SWTModelMapper.map(wl.getPlayer().wrap(item)));
		return gridView.item(NebulaViewers.getPathByGridItem(item));
	}
	
	private ViewerUIElement gridView(Grid grid, boolean supportEclipseWorkbench) {
		FindResult gridSearch = wl.findElement(wl.getPlayer().wrap(grid), false, false, supportEclipseWorkbench);
		return new ViewerUIElement(gridSearch.element, wl.getRecorder());
	}

	private NebulaItemUIElement itemElement(GridItem item, boolean supportEclipseWorkbench) {
		BasicUIElement itemFound = findGridItem(item, false, supportEclipseWorkbench);
		return new NebulaItemUIElement(itemFound.getElement(), wl.getRecorder());
	}

	private BasicUIElement findGridPart(GridPart part,
			boolean alwaysFindLeaf, boolean supportEclipseWorkbench) {

		// it is not so easy to use polymorphism here
		if (part instanceof ItemPart) {
			NebulaItemUIElement itemElement = itemElement(((ItemPart) part).item, supportEclipseWorkbench);

			if (part instanceof RowHeader) {
				return itemElement.rowHeader();
			}
			else if (part instanceof ItemCell) {
				String columnTitle = ((ItemCell) part).column.getText();
				return itemElement.itemCell(columnTitle);
			}
		}
		else if (part instanceof EmptyArea) {
			EmptyArea area = (EmptyArea) part;
			ViewerUIElement gridView = gridView(area.grid, supportEclipseWorkbench);
			NebulaGridUIElement gridElement = new NebulaGridUIElement(gridView.getElement(), wl.getRecorder());

			if (area.item != null) {
				NebulaItemUIElement itemElement = itemElement(area.item, supportEclipseWorkbench);
				return itemElement.emptyArea();
			}
			return gridElement.emptyArea(area.path());
		}
		else if (part instanceof ColumnHeader) {
			return findGridColumn(((ColumnHeader) part).column, alwaysFindLeaf, supportEclipseWorkbench);
		}
		throw new IllegalArgumentException("part type is unknown");
	}

	//

	@Override
	public IWidgetClassifierExtension getWidgetClassifierExtension() {
		return new NebulaWidgetClassifierExtension();
	}

}
