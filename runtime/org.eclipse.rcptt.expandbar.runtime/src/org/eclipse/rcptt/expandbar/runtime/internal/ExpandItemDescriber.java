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
package org.eclipse.rcptt.expandbar.runtime.internal;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.ui.describers.IWidgetDescriber;

public class ExpandItemDescriber implements IWidgetDescriber {
	private ExpandItem item;

	public ExpandItemDescriber(ExpandItem item) {
		this.item = item;
	}

	@Override
	public Display getDisplay() {
		return item.getDisplay();
	}

	@Override
	public Widget getWidget() {
		return item;
	}

	@Override
	public void redraw() {
		item.getParent().redraw();
	}

	@Override
	public Rectangle getBounds() {
		return ExpandBarUtil.getItemHeaderBounds(item);
	}

	@Override
	public Point getPoint() {
		Rectangle bounds = getBounds();
		return getDisplay().map(item.getParent(), null, bounds.x, bounds.y);
	}

	@Override
	public Point getRealPoint() {
		return getPoint();
	}

	@Override
	public IWidgetDescriber getControl() {
		return this;
	}

	@Override
	public Widget getItemWidget() {
		return item;
	}

	@Override
	public Image captureImage() {
		return SWTUIPlayer.captureControlImageRaw(item.getParent(), getBounds());
	}

	@Override
	public boolean supportsDND() {
		return false;
	}

}
