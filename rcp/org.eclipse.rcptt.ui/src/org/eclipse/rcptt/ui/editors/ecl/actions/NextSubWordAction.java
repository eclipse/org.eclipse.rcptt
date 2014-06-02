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

import java.text.BreakIterator;
import java.text.CharacterIterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.swt.custom.StyledText;

import org.eclipse.rcptt.ui.editors.ecl.DocumentCharacterIterator;
import org.eclipse.rcptt.ui.editors.ecl.EclEditor;
import org.eclipse.rcptt.ui.editors.ecl.EclWordIterator;

abstract class NextSubWordAction extends EclTextNavigationAction {
	protected EclWordIterator fIterator = new EclWordIterator();

	/**
	 * Creates a new next sub-word action.
	 * 
	 * @param code
	 *            Action code for the default operation. Must be an action code
	 *            from @see org.eclipse.swt.custom.ST.
	 * @param eclEditor
	 *            TODO
	 */
	protected NextSubWordAction(EclEditor eclEditor, int code) {
		super(eclEditor, eclEditor.doGetSourceViewer().getTextWidget(), code);
	}

	/*
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	@Override
	public void internalRun(TextViewer viewer) {
		// Check whether we are in a java code partition and the preference
		// is enabled
		// final IPreferenceStore store = this.eclEditor.doGetPreferenceStore();
		// if
		// (!store.getBoolean(PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION))
		// {
		// super.run();
		// return;
		// }

		// final ISourceViewer viewer = this.eclEditor.doGetSourceViewer();
		final IDocument document = viewer.getDocument();
		try {
			fIterator
					.setText((CharacterIterator) new DocumentCharacterIterator(
							document));
			int position = eclEditor.doWidgetOffset2ModelOffset(viewer, viewer
					.getTextWidget().getCaretOffset());
			if (position == -1)
				return;

			int next = findNextPosition(viewer, position);
			if (this.eclEditor.isBlockSelectionModeEnabled()
					&& document.getLineOfOffset(next) != document
							.getLineOfOffset(position)) {
				super.run(); // may navigate into virtual white space
			} else if (next != BreakIterator.DONE) {
				setCaretPosition(viewer, next);
				((StyledText) viewer.getTextWidget()).showSelection();
				fireSelectionChanged();
			}
		} catch (BadLocationException x) {
			// ignore
		}
	}

	/**
	 * Finds the next position after the given position.
	 * 
	 * @param position
	 *            the current position
	 * @return the next position
	 */
	protected int findNextPosition(TextViewer viewer, int position) {
		int widget = -1;
		int next = position;
		while (next != BreakIterator.DONE && widget == -1) { // XXX:
																// optimize
			next = fIterator.following(next);
			if (next != BreakIterator.DONE)
				widget = eclEditor.doModelOffset2WidgetOffset(viewer, next);
		}

		IDocument document = viewer.getDocument();
		LinkedModeModel model = LinkedModeModel.getModel(document, position);
		if (model != null) {
			LinkedPosition linkedPosition = model
					.findPosition(new LinkedPosition(document, position, 0));
			if (linkedPosition != null) {
				int linkedPositionEnd = linkedPosition.getOffset()
						+ linkedPosition.getLength();
				if (position != linkedPositionEnd && linkedPositionEnd < next)
					next = linkedPositionEnd;
			} else {
				LinkedPosition nextLinkedPosition = model
						.findPosition(new LinkedPosition(document, next, 0));
				if (nextLinkedPosition != null) {
					int nextLinkedPositionOffset = nextLinkedPosition
							.getOffset();
					if (position != nextLinkedPositionOffset
							&& nextLinkedPositionOffset < next)
						next = nextLinkedPositionOffset;
				}
			}
		}

		return next;
	}

	/**
	 * Sets the caret position to the sub-word boundary given with
	 * <code>position</code>.
	 * 
	 * @param position
	 *            Position where the action should move the caret
	 */
	protected abstract void setCaretPosition(TextViewer viewer, int position);
}