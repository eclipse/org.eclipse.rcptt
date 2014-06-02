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
package org.eclipse.rcptt.tesla.nebula;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.ui.describers.IWidgetDescriber;

public class NebulaDescriber implements IWidgetDescriber {

	private Widget widget;

	public NebulaDescriber(Widget widget) {
		this.widget = widget;
	}

	public Display getDisplay() {
		return widget.getDisplay();
	}

	public Widget getWidget() {
		return widget;
	}

	public void redraw() {
		Control parent = getParent();
		if (parent != null)
			parent.redraw();
	}

	public Rectangle getBounds() {
		if (widget instanceof GridItem) {
			return getItemBounds((GridItem) widget);
		} else if (widget instanceof Grid) {
			return ((Grid) widget).getBounds();
		}

		return null;
	}

	public static Rectangle getItemBounds(GridItem item) {
		Grid grid = item.getParent();

		if (grid.getColumnCount() == 0)
			return null;

		Rectangle bounds = new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MIN_VALUE, Integer.MIN_VALUE);
		for (int column = 0; column < grid.getColumnCount(); ++column) {
			Rectangle b = item.getBounds(column);
			bounds.x = Math.min(bounds.x, b.x);
			bounds.y = Math.min(bounds.y, b.y);
			bounds.width = Math.max(bounds.width, b.x + b.width);
			bounds.height = Math.max(bounds.height, b.y + b.height);
		}
		bounds.width -= bounds.x;
		bounds.height -= bounds.y;
		return bounds;
	}

	public Point getPoint() {
		Rectangle bounds = getBounds();
		return getDisplay().map(getParent(), null, bounds.x, bounds.y);
	}

	public Point getRealPoint() {
		return getPoint();
	}

	public IWidgetDescriber getControl() {
		Control parent = getParent();
		if (parent != null)
			return new NebulaDescriber(parent);

		return null;
	}

	public Widget getItemWidget() {
		if (widget instanceof Item)
			return widget;
		return null;
	}

	public Image captureImage() {
		if (widget instanceof Control) {
			Control parent = getParent();
			if (parent == null)
				return null;

			Rectangle bounds = getBounds();
			return SWTUIPlayer.captureControlImageRaw((Control) widget, bounds);
		} else
			return null;
	}

	// --

	private Control getParent() {
		if (widget instanceof GridItem) {
			return (((GridItem) widget).getParent());
		}

		if (widget instanceof Control) {
			return (((Control) widget).getParent());
		}

		return null;
	}

	public boolean supportsDND() {
		return widget instanceof GridItem;
	}
}
