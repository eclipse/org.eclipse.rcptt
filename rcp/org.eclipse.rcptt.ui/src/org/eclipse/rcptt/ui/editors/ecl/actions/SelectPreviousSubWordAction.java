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
package org.eclipse.rcptt.ui.editors.ecl.actions;

import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;

import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class SelectPreviousSubWordAction extends PreviousSubWordAction {
	/**
	 * Creates a new select previous sub-word action.
	 * 
	 * @param eclEditor
	 *            TODO
	 */
	public SelectPreviousSubWordAction(EclEditor eclEditor) {
		super(eclEditor, ST.SELECT_WORD_PREVIOUS);
	}

	/*
	 * @see
	 * org.eclipse.jdt.internal.ui.javaeditor.JavaEditor.PreviousSubWordAction
	 * #setCaretPosition(int)
	 */
	@Override
	protected void setCaretPosition(TextViewer viewer, final int position) {
		final StyledText text = viewer.getTextWidget();
		if (text != null && !text.isDisposed()) {

			final Point selection = text.getSelection();
			final int caret = text.getCaretOffset();
			final int offset = eclEditor.doModelOffset2WidgetOffset(viewer,
					position);

			if (caret == selection.x)
				text.setSelectionRange(selection.y, offset - selection.y);
			else
				text.setSelectionRange(selection.x, offset - selection.x);
		}
	}
}