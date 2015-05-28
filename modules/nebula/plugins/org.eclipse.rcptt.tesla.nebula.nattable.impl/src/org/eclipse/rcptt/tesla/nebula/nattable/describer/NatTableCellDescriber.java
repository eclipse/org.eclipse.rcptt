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
package org.eclipse.rcptt.tesla.nebula.nattable.describer;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellPosition;
import org.eclipse.rcptt.tesla.ui.describers.IWidgetDescriber;
import org.eclipse.rcptt.tesla.ui.describers.WidgetDescriber;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

public class NatTableCellDescriber implements IWidgetDescriber {

	private NatTable natTable;
	protected NatTableCellPosition cellPosition;

	public NatTableCellDescriber(NatTable natTable, NatTableCellPosition cellPosition) {
		this.natTable = natTable;
		this.cellPosition = cellPosition;
	}

	@Override
	public Display getDisplay() {
		return getWidget().getDisplay();
	}

	@Override
	public Widget getWidget() {
		return natTable;
	}

	@Override
	public void redraw() {
	}

	@Override
	public Rectangle getBounds() {
		ILayerCell cell = natTable.getCellByPosition(cellPosition.getCol(), cellPosition.getRow());
		return cell.getBounds();
	}

	@Override
	public Point getPoint() {
		Rectangle bounds = getBounds();
		return getDisplay().map(natTable, null, bounds.x, bounds.y);
	}

	@Override
	public Point getRealPoint() {
		return getPoint();
	}

	@Override
	public IWidgetDescriber getControl() {
		return new WidgetDescriber(natTable);
	}

	@Override
	public Widget getItemWidget() {
		return null;
	}

	@Override
	public Image captureImage() {
		return null;
	}

	@Override
	public boolean supportsDND() {
		return false;
	}

}
