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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;

import org.eclipse.rcptt.core.ecl.model.Q7ElementContainer;
import org.eclipse.rcptt.core.ecl.parser.ast.Node;
import org.eclipse.rcptt.core.ecl.parser.ast.Reference;
import org.eclipse.rcptt.core.ecl.parser.model.Resolver;

public class EclTextHyperLinkDetector extends AbstractHyperlinkDetector {
	public static IRegion toRegion(Node node) {
		return new Region(node.begin, node.length());
	}

	public static Reference getReferenceAtPoint(ITextViewer viewer, int offset) {
		Q7ElementContainer container = ((EclSourceViewer) viewer).getElementContainer();
		container.includeBuildins(false);
		container.setOffset(offset);
		return Resolver.resolve(container.script, offset, container);
	}

	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {
		if (region == null) {
			return null;
		}

		final int offset = region.getOffset();
		Reference reference = getReferenceAtPoint(textViewer, offset);
		if (reference == null) {
			return null;
		}

		return new IHyperlink[] { new EclTextHyperLink(toRegion(reference.src), reference.dest) };
	}
}