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
package org.eclipse.rcptt.tesla.gef.describers;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.ui.describers.IWidgetDescriber;
import org.eclipse.rcptt.tesla.ui.describers.WidgetDescriber;

public class EditPartDescriber implements IWidgetDescriber {

	private final EditPart part;
	private final GraphicalViewer viewer;

	public EditPartDescriber(EditPart editPart, GraphicalViewer graphicalViewer) {
		this.part = editPart;
		this.viewer = graphicalViewer;
	}

	
	public Rectangle getBounds() {
		if (part instanceof GraphicalEditPart) {
			org.eclipse.draw2d.geometry.Rectangle bounds = ((GraphicalEditPart) part)
					.getFigure().getBounds().getCopy();
			((GraphicalEditPart) part).getFigure().translateToAbsolute(bounds);
			return new Rectangle(bounds.x, bounds.y, bounds.width,
					bounds.height);
		}
		return null;
	}

	public GraphicalViewer getViewer() {
		return viewer;
	}

	
	public Display getDisplay() {
		return part.getViewer().getControl().getDisplay();
	}

	
	public Point getPoint() {
		if (part instanceof GraphicalEditPart) {
			org.eclipse.draw2d.geometry.Rectangle bounds = ((GraphicalEditPart) part)
					.getFigure().getBounds().getCopy();
			((GraphicalEditPart) part).getFigure().translateToAbsolute(bounds);
			RootEditPart root = part.getRoot();
			FigureCanvas canvas = null;
			if (root != null) {
				canvas = (FigureCanvas) root.getViewer().getControl();
			}
			if (canvas == null) {
				canvas = (FigureCanvas) viewer.getControl();
			}
			if (canvas != null) {
				return getDisplay().map(canvas, null, bounds.x, bounds.y);
			}
		}
		return null;
	}

	
	public Point getRealPoint() {
		return getPoint();
	}

	
	public Widget getWidget() {
		return part.getViewer().getControl();
	}

	
	public Widget getItemWidget() {
		return null;
	}

	
	public void redraw() {
	}

	public EditPart getPart() {
		return part;
	}

	
	public IWidgetDescriber getControl() {
		return new WidgetDescriber(part.getViewer().getControl());
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((part == null) ? 0 : part.hashCode());
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
		EditPartDescriber other = (EditPartDescriber) obj;
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
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
