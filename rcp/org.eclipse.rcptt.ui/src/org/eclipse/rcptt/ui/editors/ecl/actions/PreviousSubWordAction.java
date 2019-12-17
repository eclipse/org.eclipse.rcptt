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
package org.eclipse.rcptt.ui.editors.ecl.actions;

import java.text.BreakIterator;
import java.text.CharacterIterator;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.swt.custom.StyledText;

import org.eclipse.rcptt.ui.editors.ecl.DocumentCharacterIterator;
import org.eclipse.rcptt.ui.editors.ecl.EclEditor;
import org.eclipse.rcptt.ui.editors.ecl.EclWordIterator;

abstract class PreviousSubWordAction extends EclTextNavigationAction {
	protected EclWordIterator fIterator = new EclWordIterator();

	/**
	 * Creates a new previous sub-word action.
	 * 
	 * @param code
	 *            Action code for the default operation. Must be an action code
	 *            from @see org.eclipse.swt.custom.ST.
	 * @param eclEditor
	 *            TODO
	 */
	protected PreviousSubWordAction(EclEditor eclEditor, final int code) {
		super(eclEditor, eclEditor.doGetSourceViewer().getTextWidget(), code);
	}

	/*
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	@SuppressWarnings("unused")
	@Override
	public void internalRun(TextViewer viewer) {
		// Check whether we are in a java code partition and the preference
		// is enabled
		final IPreferenceStore store = this.eclEditor.doGetPreferenceStore();
		// if
		// (!store.getBoolean(PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION))
		// {
		// super.run();
		// return;
		// }

		final IDocument document = viewer.getDocument();
		try {
			fIterator
					.setText((CharacterIterator) new DocumentCharacterIterator(
							document));
			int position = eclEditor.doWidgetOffset2ModelOffset(viewer, viewer
					.getTextWidget().getCaretOffset());
			if (position == -1)
				return;

			int previous = findPreviousPosition(viewer, position);
			if (this.eclEditor.isBlockSelectionModeEnabled()
					&& document.getLineOfOffset(previous) != document
							.getLineOfOffset(position)) {
				super.run(); // may navigate into virtual white space
			} else if (previous != BreakIterator.DONE) {
				setCaretPosition(viewer, previous);
				((StyledText) viewer.getTextWidget()).showSelection();
				fireSelectionChanged();
			}
		} catch (BadLocationException x) {
			// ignore - getLineOfOffset failed
		}

	}

	/**
	 * Finds the previous position before the given position.
	 * 
	 * @param position
	 *            the current position
	 * @return the previous position
	 */
	protected int findPreviousPosition(TextViewer viewer, int position) {
		int widget = -1;
		int previous = position;
		while (previous != BreakIterator.DONE && widget == -1) { // XXX:
																	// optimize
			previous = fIterator.preceding(previous);
			if (previous != BreakIterator.DONE)
				widget = eclEditor.doModelOffset2WidgetOffset(viewer, previous);
		}

		IDocument document = viewer.getDocument();
		LinkedModeModel model = LinkedModeModel.getModel(document, position);
		if (model != null) {
			LinkedPosition linkedPosition = model
					.findPosition(new LinkedPosition(document, position, 0));
			if (linkedPosition != null) {
				int linkedPositionOffset = linkedPosition.getOffset();
				if (position != linkedPositionOffset
						&& previous < linkedPositionOffset)
					previous = linkedPositionOffset;
			} else {
				LinkedPosition previousLinkedPosition = model
						.findPosition(new LinkedPosition(document, previous, 0));
				if (previousLinkedPosition != null) {
					int previousLinkedPositionEnd = previousLinkedPosition
							.getOffset() + previousLinkedPosition.getLength();
					if (position != previousLinkedPositionEnd
							&& previous < previousLinkedPositionEnd)
						previous = previousLinkedPositionEnd;
				}
			}
		}

		return previous;
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