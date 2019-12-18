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

import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class NavigateNextSubWordAction extends NextSubWordAction {

	/**
	 * Creates a new navigate next sub-word action.
	 * 
	 * @param eclEditor
	 *            TODO
	 */
	public NavigateNextSubWordAction(EclEditor eclEditor) {
		super(eclEditor, ST.WORD_NEXT);
	}

	/*
	 * @see org.eclipse.jdt.internal.ui.javaeditor.JavaEditor.NextSubWordAction
	 * #setCaretPosition(int)
	 */
	@Override
	protected void setCaretPosition(TextViewer viewer, final int position) {
		((StyledText)viewer.getTextWidget()).setCaretOffset(
				eclEditor.doModelOffset2WidgetOffset(viewer, position));
	}
}