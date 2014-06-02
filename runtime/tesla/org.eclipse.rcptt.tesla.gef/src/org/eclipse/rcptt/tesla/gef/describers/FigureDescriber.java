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
package org.eclipse.rcptt.tesla.gef.describers;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.ui.describers.IWidgetDescriber;
import org.eclipse.rcptt.tesla.ui.describers.WidgetDescriber;

public class FigureDescriber implements IWidgetDescriber {

	private final IFigure figure;
	private final GraphicalViewer viewer;
	private final EditPart editPart;

	public FigureDescriber(IFigure figure, EditPart editPart,
			GraphicalViewer viewer) {
		this.figure = figure;
		this.editPart = editPart;
		this.viewer = viewer;
	}

	public Rectangle getBounds() {
		org.eclipse.draw2d.geometry.Rectangle bounds = figure.getBounds()
				.getCopy();
		figure.translateToAbsolute(bounds);
		return new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	public Display getDisplay() {
		return getWidget().getDisplay();
	}

	public Point getPoint() {
		org.eclipse.draw2d.geometry.Rectangle bounds = figure.getBounds()
				.getCopy();
		figure.translateToAbsolute(bounds);
		IFigure parent = figure.getParent();
		org.eclipse.draw2d.geometry.Rectangle pbounds = parent.getBounds()
				.getCopy();
		parent.translateToAbsolute(pbounds);
		if (bounds.x < pbounds.x && bounds.y < pbounds.y) { // Strange bug fix
			bounds = pbounds;
		}
		return getDisplay().map((Control)getWidget(), null, bounds.x, bounds.y);
	}

	public Point getRealPoint() {
		return getPoint();
	}

	public Widget getWidget() {
		return viewer.getControl();
	}

	public Widget getItemWidget() {
		return null;
	}

	public void redraw() {
	}

	public IWidgetDescriber getControl() {
		return new WidgetDescriber(viewer.getControl());
	}

	public EditPart getEditPart() {
		return editPart;
	}

	public IFigure getFigure() {
		return figure;
	}

	public GraphicalViewer getViewer() {
		return viewer;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((editPart == null) ? 0 : editPart.hashCode());
		result = prime * result + ((figure == null) ? 0 : figure.hashCode());
		result = prime * result + ((viewer == null) ? 0 : viewer.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FigureDescriber other = (FigureDescriber) obj;
		if (editPart == null) {
			if (other.editPart != null)
				return false;
		} else if (!editPart.equals(other.editPart))
			return false;
		if (figure == null) {
			if (other.figure != null)
				return false;
		} else if (!figure.equals(other.figure))
			return false;
		if (viewer == null) {
			if (other.viewer != null)
				return false;
		} else if (!viewer.equals(other.viewer))
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
		return true;
	}
}
