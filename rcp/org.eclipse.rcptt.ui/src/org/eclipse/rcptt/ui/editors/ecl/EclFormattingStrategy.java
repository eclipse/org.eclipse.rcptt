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

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.formatter.FormattingContextProperties;
import org.eclipse.jface.text.formatter.IFormattingContext;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.formatter.IFormattingStrategyExtension;

import org.eclipse.rcptt.core.ecl.formatter.EclFormatter;

public class EclFormattingStrategy implements IFormattingStrategyExtension, IFormattingStrategy {

	IFormattingContext context;

	@Override
	public void format() {
		IDocument document = (IDocument) context.getProperty(FormattingContextProperties.CONTEXT_MEDIUM);
		document.set(new EclFormatter().format(document.get()));
	}

	@Override
	public void formatterStarts(IFormattingContext context) {
		this.context = context;
	}

	// -

	@Override
	public void formatterStops() {
	}

	// --

	@Override
	public void formatterStarts(String initialIndentation) {
		// deprecated and not used
	}

	@Override
	public String format(String content, boolean isLineStart, String indentation, int[] positions) {
		// deprecated and not used
		return content;
	}

}
