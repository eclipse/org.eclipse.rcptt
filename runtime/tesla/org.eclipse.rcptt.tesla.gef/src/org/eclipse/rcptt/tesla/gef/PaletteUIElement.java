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

public class PaletteUIElement extends FigureUIElement {

	public PaletteUIElement(EditPart part, DiagramViewerUIElement diagram) {
		super(part, diagram);
	}

	@Override
	public String getGenerationKind() {
		return ElementKind.PaletteEntry.name();
	}
}
