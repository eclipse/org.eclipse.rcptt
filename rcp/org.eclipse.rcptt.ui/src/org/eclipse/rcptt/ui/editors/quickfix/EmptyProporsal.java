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
package org.eclipse.rcptt.ui.editors.quickfix;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class EmptyProporsal implements ICompletionProposal {
	@Override
	public Point getSelection(IDocument document) {
		return null;
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public String getDisplayString() {
		return "No suggestions avaiable";
	}

	@Override
	public IContextInformation getContextInformation() {
		return null;
	}

	@Override
	public String getAdditionalProposalInfo() {
		return null;
	}

	@Override
	public void apply(IDocument document) {
	}
}