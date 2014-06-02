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
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.swt.custom.StyledText;

import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class EclScrollLinesAction extends Action {

	/** Number of lines to scroll. */
	private int fScrollIncrement;
	private EclEditor eclEditor;

	/**
	 * Creates a new scroll action that scroll the given number of lines. If the
	 * increment is &lt; 0, it's scrolling up, if &gt; 0 it's scrolling down.
	 * 
	 * @param scrollIncrement
	 *            the number of lines to scroll
	 */
	public EclScrollLinesAction(EclEditor editor, int scrollIncrement) {
		fScrollIncrement = scrollIncrement;
		this.eclEditor = editor;
	}

	/*
	 * @see IAction#run()
	 */
	public void run() {
		boolean editorsActive = !this.eclEditor.viewer.getControl()
				.isFocusControl()
				&& (this.eclEditor.header.isInFocus() || this.eclEditor.editorContent
						.isInFocus());
		if (!editorsActive) {
			if (eclEditor.doGetSourceViewer() instanceof ITextViewerExtension5) {
				ITextViewerExtension5 extension = (ITextViewerExtension5) eclEditor
						.doGetSourceViewer();
				StyledText textWidget = eclEditor.doGetSourceViewer()
						.getTextWidget();
				int topIndex = textWidget.getTopIndex();
				int newTopIndex = Math.max(0, topIndex + fScrollIncrement);
				eclEditor.doGetSourceViewer().setTopIndex(
						extension.widgetLine2ModelLine(newTopIndex));
			} else {
				int topIndex = eclEditor.doGetSourceViewer().getTopIndex();
				int newTopIndex = Math.max(0, topIndex + fScrollIncrement);
				eclEditor.doGetSourceViewer().setTopIndex(newTopIndex);
			}
		}
	}
}