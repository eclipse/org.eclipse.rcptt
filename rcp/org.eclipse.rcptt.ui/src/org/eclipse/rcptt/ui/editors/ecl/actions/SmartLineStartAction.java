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

import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;

import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class SmartLineStartAction extends LineStartAction {

	/**
	 * Creates a new smart line start action
	 * 
	 * @param textWidget
	 *            the styled text widget
	 * @param doSelect
	 *            a boolean flag which tells if the text up to the beginning of
	 *            the line should be selected
	 */
	public SmartLineStartAction(EclEditor editor, final StyledText textWidget,
			final boolean doSelect) {
		super(editor, textWidget, doSelect);
	}

	protected int getAction() {
		if (fDoSelect) {
			return ST.SELECT_LINE_START;
		}
		return ST.LINE_START;
	}

	/*
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor.LineStartAction#
	 * getLineStartPosition(java.lang.String, int, java.lang.String)
	 */
	@Override
	protected int getLineStartPosition(final IDocument document,
			final String line, final int length, final int offset) {

		int index = super.getLineStartPosition(document, line, length, offset);

		if (index < length - 1 && line.charAt(index) == '/'
				&& line.charAt(index + 1) == '/') {
			index++;
			do {
				++index;
			} while (index < length
					&& Character.isWhitespace(line.charAt(index)));
		}
		return index;
	}

}