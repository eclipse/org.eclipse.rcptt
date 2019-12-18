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
package org.eclipse.rcptt.tesla.nebula.grid.parts;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;


public class ColumnHeader implements GridPart {

	public final GridColumn column;

	public ColumnHeader(GridColumn column) {
		this.column = column;
	}

	@Override
	public Grid grid() {
		return column.getParent();
	}

	@Override
	public Rectangle bounds() {
		return NebulaViewers.getColumnHeaderBounds(column);
	}

}
