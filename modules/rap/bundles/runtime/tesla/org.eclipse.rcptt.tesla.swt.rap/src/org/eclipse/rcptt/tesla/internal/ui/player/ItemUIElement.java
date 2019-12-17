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
package org.eclipse.rcptt.tesla.internal.ui.player;

import org.eclipse.rcptt.util.swt.rap.TableTreeUtil;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class ItemUIElement extends SWTUIElement {
	private int column = -1;

	public ItemUIElement(Widget w, SWTUIPlayer p, int column) {
		super(w, p);
		this.column = column;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + column;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemUIElement other = (ItemUIElement) obj;
		if (column != other.column)
			return false;
		return true;
	}

	@Override
	public Rectangle getBounds() {
		if (widget instanceof TableItem || widget instanceof TreeItem) {
			return TableTreeUtil.getItemBounds(widget, column);
		}
		return super.getBounds();
	}
}
