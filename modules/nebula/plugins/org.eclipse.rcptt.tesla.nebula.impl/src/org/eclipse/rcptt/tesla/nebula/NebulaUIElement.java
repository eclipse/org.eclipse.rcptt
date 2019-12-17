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
package org.eclipse.rcptt.tesla.nebula;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.grid.selection.GridSetSelectionViewers;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;

public class NebulaUIElement extends SWTUIElement {

	public NebulaUIElement(Widget w, SWTUIPlayer p) {
		super(w, p);
	}

	@Override
	public boolean isSuitableForKind(GenericElementKind kind) {

		if (widget instanceof Grid && kind.is(ElementKind.Canvas))
			return true;

		return super.isSuitableForKind(kind);
	}

	@Override
	public boolean setSelection(java.util.List<String[]> selection,
			boolean selectAll) {
		return GridSetSelectionViewers.setSelection(this, selection);
	}

	@Override
	public boolean setSelection(String[] selection, String pattern,
			Integer index, boolean selectAll) {
		return GridSetSelectionViewers.setSelection(this, selection, pattern, index);
	}

	@Override
	public String[] getPathSelection() {
		return NebulaViewers.getPathSelection(this);
	}

	@Override
	public int expandSelection(String[] selection, String pattern, Integer index) {
		return NebulaViewers.expandSelection(this, selection, pattern, index);
	}

	@Override
	public boolean isSupportMultipleSelections() {
		if (super.isSupportMultipleSelections()) {
			return true;
		}
		if (widget instanceof Grid && (widget.getStyle() & SWT.MULTI) != 0) {
			return true;
		}
		return false;
	}

	@Override
	public String[][] getMultiPathSelection() {
		return NebulaViewers.getMultiPathSelection(this);
	}

}
