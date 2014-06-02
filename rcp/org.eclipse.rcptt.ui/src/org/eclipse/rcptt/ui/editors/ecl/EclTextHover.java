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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;

import org.eclipse.rcptt.core.ecl.model.Q7ElementContainer;
import org.eclipse.rcptt.core.ecl.parser.ast.Reference;
import org.eclipse.rcptt.core.ecl.parser.model.Resolver;

public class EclTextHover implements ITextHover, ITextHoverExtension2 {
	public EclTextHover() {
		super();
	}

	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		throw new UnsupportedOperationException("deprecated");
	}

	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		Q7ElementContainer container = ((EclSourceViewer)textViewer).getElementContainer();
		container.includeBuildins(true);
		container.setOffset(offset);
		Reference reference = Resolver.resolve(container.script, offset, container);
		return reference == null ? null : EclTextHyperLinkDetector.toRegion(reference.src);
	}

	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		int offset = hoverRegion.getOffset();
		Q7ElementContainer container = ((EclSourceViewer)textViewer).getElementContainer();
		container.includeBuildins(true);
		container.setOffset(offset);
		Reference reference = Resolver.resolve(container.script, offset, container);
		if (reference == null) {
			return null;
		}

		return reference.dest.doc();
	}
}
