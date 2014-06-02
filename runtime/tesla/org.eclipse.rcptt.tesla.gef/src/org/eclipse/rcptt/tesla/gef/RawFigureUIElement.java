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
package org.eclipse.rcptt.tesla.gef;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.widgets.Canvas;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.internal.ui.IBasicMappingNode;

public class RawFigureUIElement implements IBasicMappingNode {
	private EditPart part;
	private IFigure figure;
	private GraphicalViewer viewer;
	private Canvas canvas;

	public RawFigureUIElement(EditPart part, IFigure figure,
			GraphicalViewer diagram) {
		super();
		this.part = part;
		this.figure = figure;
		this.viewer = diagram;
		if (this.viewer != null) {
			this.canvas = (Canvas) viewer.getControl();
		}
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public String getGenerationKind() {
		return ElementKind.DiagramFigure.name();
	}

	public GraphicalViewer getViewer() {
		return viewer;
	}

	public EditPart getPart() {
		return part;
	}

	public IFigure getFigure() {
		return figure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((figure == null) ? 0 : figure.hashCode());
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result + ((viewer == null) ? 0 : viewer.hashCode());
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
		RawFigureUIElement other = (RawFigureUIElement) obj;
		if (figure == null) {
			if (other.figure != null)
				return false;
		} else if (!figure.equals(other.figure))
			return false;
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
}
