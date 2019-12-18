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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.AbstractTextEditor;

import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class LineEndAction extends EclTextNavigationAction {

	/**
	 * boolean flag which tells if the text up to the line end should be
	 * selected.
	 */
	protected boolean fDoSelect;

	/**
	 * Create a new line end action.
	 * 
	 * @param textWidget
	 *            the styled text widget
	 * @param doSelect
	 *            a boolean flag which tells if the text up to the line end
	 *            should be selected
	 */
	public LineEndAction(EclEditor editor, StyledText textWidget,
			boolean doSelect) {
		super(editor, textWidget, ST.LINE_END);
		fDoSelect = doSelect;
	}

	/**
	 * Computes the offset of the line end position.
	 * 
	 * @param document
	 *            the document where to compute the line end position
	 * @param line
	 *            the line to determine the end position of
	 * @param length
	 *            the length of the line
	 * @param offset
	 *            the caret position in the document
	 * @return the offset of the line end
	 * @since 3.4 protected, was added in 3.3 as private method
	 */
	protected int getLineEndPosition(final IDocument document,
			final String line, final int length, final int offset) {
		int index = length - 1;
		while (index > -1 && Character.isWhitespace(line.charAt(index)))
			index--;
		index++;

		LinkedModeModel model = LinkedModeModel.getModel(document, offset);
		if (model != null) {
			LinkedPosition linkedPosition = model
					.findPosition(new LinkedPosition(document, offset, 0));
			if (linkedPosition != null) {
				int linkedPositionEnd = linkedPosition.getOffset()
						+ linkedPosition.getLength();
				int lineOffset;
				try {
					lineOffset = document.getLineInformationOfOffset(offset)
							.getOffset();
					if (offset != linkedPositionEnd
							&& linkedPositionEnd - lineOffset < index)
						index = linkedPositionEnd - lineOffset;
				} catch (BadLocationException e) {
					// should not happen
				}
			}
		}
		return index;
	}

	/*
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	public void internalRun(TextViewer viewer) {
		boolean isSmartHomeEndEnabled = false;
		IPreferenceStore store = eclEditor.doGetPreferenceStore();
		if (store != null)
			isSmartHomeEndEnabled = store
					.getBoolean(AbstractTextEditor.PREFERENCE_NAVIGATION_SMART_HOME_END);

		StyledText st = viewer.getTextWidget();
		if (st == null || st.isDisposed())
			return;
		int caretOffset = st.getCaretOffset();
		int lineNumber = st.getLineAtOffset(caretOffset);
		int lineOffset = st.getOffsetAtLine(lineNumber);

		int lineLength;
		int caretOffsetInDocument;
		final IDocument document = viewer.getDocument();

		try {
			caretOffsetInDocument = eclEditor.doWidgetOffset2ModelOffset(
					viewer, caretOffset);
			lineLength = document.getLineInformationOfOffset(
					caretOffsetInDocument).getLength();
		} catch (BadLocationException ex) {
			return;
		}
		int lineEndOffset = lineOffset + lineLength;

		int delta = lineEndOffset - st.getCharCount();
		if (delta > 0) {
			lineEndOffset -= delta;
			lineLength -= delta;
		}

		String line = ""; //$NON-NLS-1$
		if (lineLength > 0)
			line = st.getText(lineOffset, lineEndOffset - 1);

		// Remember current selection
		Point oldSelection = st.getSelection();

		// The new caret position
		int newCaretOffset = -1;

		if (isSmartHomeEndEnabled) {
			// Compute the line end offset
			int i = getLineEndPosition(document, line, lineLength,
					caretOffsetInDocument);

			if (caretOffset - lineOffset == i)
				// to end of line
				newCaretOffset = lineEndOffset;
			else
				// to end of text
				newCaretOffset = lineOffset + i;

		} else {

			if (caretOffset < lineEndOffset)
				// to end of line
				newCaretOffset = lineEndOffset;

		}

		if (newCaretOffset == -1)
			newCaretOffset = caretOffset;
		else
			st.setCaretOffset(newCaretOffset);

		st.setCaretOffset(newCaretOffset);
		if (fDoSelect) {
			if (caretOffset < oldSelection.y)
				st.setSelection(oldSelection.y, newCaretOffset);
			else
				st.setSelection(oldSelection.x, newCaretOffset);
		} else
			st.setSelection(newCaretOffset);

		fireSelectionChanged(oldSelection);
	}
}