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
package org.eclipse.rcptt.tesla.ui.describers;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;

public class WidgetDescriber implements IWidgetDescriber {

	private Widget widget;

	public WidgetDescriber(Widget widget) {
		this.widget = widget;
	}

	public Display getDisplay() {
		return widget.getDisplay();
	}

	public Widget getWidget() {
		return widget;
	}

	public Widget getItemWidget() {
		if (widget instanceof Item) {
			return widget;
		}
		return null;
	}

	public void redraw() {
		Control parent = getParent();
		if (parent != null) {
			parent.redraw();
		}
	}

	public Rectangle getBounds() {
		if (widget instanceof TreeItem) {
			TreeItem item = (TreeItem) widget;
			Rectangle bounds = item.getBounds();
			bounds.x = 5;
			Rectangle pBounds = item.getParent().getBounds();
			bounds.width = pBounds.width - 10;
			return bounds;
		}
		if (widget instanceof TableItem) {
			TableItem item = (TableItem) widget;
			Rectangle bounds = item.getBounds();
			bounds.x = 5;
			Rectangle pBounds = item.getParent().getBounds();
			bounds.width = pBounds.width - 10;
			return bounds;
		}
		return getRealBounds();
	}

	public Rectangle getRealBounds() {
		if (widget instanceof TreeItem) {
			return ((TreeItem) widget).getBounds();
		}
		if (widget instanceof TableItem) {
			return ((TableItem) widget).getBounds();
		}
		if (widget instanceof ToolItem) {
			return ((ToolItem) widget).getBounds();
		}
		if (widget instanceof CoolItem) {
			return ((CoolItem) widget).getBounds();
		}
		if (widget instanceof Control) {
			return ((Control) widget).getBounds();
		}
		return null;
	}

	public Point getPoint() {
		Display display = widget.getDisplay();
		Control parent = getParent();
		Rectangle bounds = getBounds();
		if (widget instanceof Shell) {
			return new Point(bounds.x, bounds.y);
		}
		if (display == null) {
			display = PlatformUI.getWorkbench().getDisplay();
		}
		// for menu item bounds can be null
		if (bounds != null) {
			return display.map(parent, null, bounds.x, bounds.y);
		}
		return null;
	}

	public Point getRealPoint() {
		Display display = widget.getDisplay();
		Control parent = getParent();
		Rectangle bounds = getRealBounds();
		if (bounds == null) {
			return null;
		}
		return display.map(parent, null, bounds.x, bounds.y);
	}

	public IWidgetDescriber getControl() {
		Widget control = null;
		if (widget instanceof TreeItem) {
			control = (((TreeItem) widget).getParent());
		}
		if (widget instanceof TableItem) {
			control = (((TableItem) widget).getParent());
		}
		if (widget instanceof ToolItem) {
			control = (((ToolItem) widget).getParent());
		}
		if (widget instanceof CoolItem) {
			control = (((CoolItem) widget).getParent());
		}
		if (control != null) {
			return new WidgetDescriber(control);
		}
		return this;
	}

	private Control getParent() {
		if (widget instanceof TreeItem) {
			return (((TreeItem) widget).getParent());
		}
		if (widget instanceof TableItem) {
			return (((TableItem) widget).getParent());
		}
		if (widget instanceof ToolItem) {
			return (((ToolItem) widget).getParent());
		}
		if (widget instanceof CoolItem) {
			return (((CoolItem) widget).getParent());
		}
		if (widget instanceof ScrollBar) {
			return (((ScrollBar) widget).getParent());
		}
		if (widget instanceof ToolTip) {
			return (((ToolTip) widget).getParent());
		}

		if (widget instanceof Control) {
			return (((Control) widget).getParent());
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((widget == null) ? 0 : widget.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WidgetDescriber other = (WidgetDescriber) obj;
		if (widget == null) {
			if (other.widget != null)
				return false;
		} else if (!widget.equals(other.widget))
			return false;
		return true;
	}

	public Image captureImage() {
		Widget widget = getControl().getWidget();
		Rectangle bounds = getBounds();
		if (widget instanceof Control) {
			return SWTUIPlayer.captureControlImageRaw((Control) widget, bounds);
		}
		return null;
	}

	public boolean supportsDND() {
		return widget instanceof Tree || widget instanceof TreeItem
				|| widget instanceof Table || widget instanceof TableItem
				|| /* widget instanceof ToolBar || */widget instanceof ToolItem
				|| /* widget instanceof CoolBar || */widget instanceof CoolItem;
	}
}
