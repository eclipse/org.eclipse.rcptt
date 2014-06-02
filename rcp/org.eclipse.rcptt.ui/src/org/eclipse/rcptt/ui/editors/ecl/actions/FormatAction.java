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
package org.eclipse.rcptt.ui.editors.ecl.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.ISourceViewer;

public class FormatAction extends Action {

	private final TextViewer textViewer;

	public FormatAction(TextViewer sourceViewer) {
		super("Format Source Code");
		this.textViewer = sourceViewer;
	}

	@Override
	public void run() {
		textViewer.doOperation(ISourceViewer.FORMAT);
	}

}
