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
package org.eclipse.rcptt.tesla.gef;

import org.eclipse.gef.EditPart;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.internal.ui.IBasicMappingNode;

public class FigureUIElement implements IBasicMappingNode {
	private EditPart part;
	private DiagramViewerUIElement diagram;

	public FigureUIElement(EditPart part, DiagramViewerUIElement diagram) {
		super();
		this.part = part;
		this.diagram = diagram;
	}

	public String getGenerationKind() {
		return ElementKind.DiagramFigure.name();
	}

	public DiagramViewerUIElement getDiagram() {
		return diagram;
	}

	public EditPart getPart() {
		return part;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diagram == null) ? 0 : diagram.hashCode());
		result = prime * result + ((part == null) ? 0 : part.hashCode());
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
		FigureUIElement other = (FigureUIElement) obj;
		if (diagram == null) {
			if (other.diagram != null)
				return false;
		} else if (!diagram.equals(other.diagram))
			return false;
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		return true;
	}

}
