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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;

import org.eclipse.rcptt.core.ecl.model.Declaration;
import org.eclipse.rcptt.ui.editors.ecl.actions.EclOpenDeclarationAction;

public class EclTextHyperLink implements IHyperlink {
	private Declaration dest;
	private IRegion source;

	public EclTextHyperLink(IRegion source, Declaration dest) {
		this.source = source;
		this.dest = dest;
	}

	public IRegion getHyperlinkRegion() {
		return source;
	}

	public String getTypeLabel() {
		return null;
	}

	public String getHyperlinkText() {
		return "Open Declaration";
	}

	public void open() {
		EclOpenDeclarationAction.openDeclaration(dest);
	}
}
