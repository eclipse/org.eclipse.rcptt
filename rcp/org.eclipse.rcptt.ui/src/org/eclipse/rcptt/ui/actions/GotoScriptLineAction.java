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
package org.eclipse.rcptt.ui.actions;

import java.text.MessageFormat;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.custom.StyledText;

import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class GotoScriptLineAction extends Action {

	private static final String ACTION_TEXT = "Go to Line..."; //$NON-NLS-1$
	private static final String DIALOG_INVALIG_RANGE = "Line number out of range"; //$NON-NLS-1$
	private static final String DIALOG_INVALIG_INPUT = "Not a number"; //$NON-NLS-1$
	private static final String DIALOG_TITLE = "Go to Line"; //$NON-NLS-1$
	private static final String DIALOG_MESSAGE = "Enter line number (1..{0}):"; //$NON-NLS-1$	

	public static final String GOTOLINE_ACTION_ID = "org.eclipse.rcptt.ui.actions.goto.line"; //$NON-NLS-1$	

	private int fLastLine;
	private TextViewer fTextViewer;

	public GotoScriptLineAction(TextViewer textViewer) {
		super();
		fTextViewer = textViewer;
		setText(ACTION_TEXT);
	}

	protected TextViewer getTextViewer() {
		return fTextViewer;
	}

	public void setTextViewer(TextViewer textViewer) {
		fTextViewer = textViewer;
	}

	private void gotoLine(int line) {

		TextViewer viewer = getTextViewer();

		IDocument document = viewer.getDocument();

		try {
			int start = document.getLineOffset(line);

			StyledText widget = viewer.getTextWidget();
			widget.setRedraw(false);
			{
				viewer.revealRange(start, 0);
				viewer.setSelectedRange(start, 0);
				widget.setFocus();
			}
			widget.setRedraw(true);
		} catch (BadLocationException e) {
			// ignore
		}

	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled() && (getTextViewer() != null);
	}

	public void run() {

		TextViewer viewer = getTextViewer();
		if (viewer == null)
			return;

		IDocument document = viewer.getDocument();
		if (document == null)
			return;

		try {
			fLastLine = document.getLineOfOffset(document.getLength()) + 1;
		} catch (BadLocationException ex) {
			IStatus status = new Status(IStatus.ERROR, Q7UIPlugin.PLUGIN_ID,
					IStatus.OK, "Go to Line failed", ex); //$NON-NLS-1$
			Q7UIPlugin.getDefault().getLog().log(status);
			return;
		}

		String title = DIALOG_TITLE;
		String message = MessageFormat.format(DIALOG_MESSAGE, new Integer(
				fLastLine));

		String currentLineStr = ""; //$NON-NLS-1$
		StyledText textWidget = viewer.getTextWidget();
		int currentLine = textWidget.getLineAtOffset(textWidget
				.getCaretOffset());
		if (currentLine > -1)
			currentLineStr = Integer.toString(currentLine + 1);

		InputDialog d = new InputDialog(viewer.getTextWidget().getShell(),
				title, message, currentLineStr, new NumberValidator());
		if (d.open() == Window.OK) {
			try {
				int line = Integer.parseInt(d.getValue());
				gotoLine(line - 1);
			} catch (NumberFormatException x) {
			}
		}
	}

	class NumberValidator implements IInputValidator {

		public String isValid(String input) {

			if (input == null || input.length() == 0)
				return " "; //$NON-NLS-1$

			try {
				int i = Integer.parseInt(input);
				if (i <= 0 || fLastLine < i)
					return DIALOG_INVALIG_RANGE;

			} catch (NumberFormatException x) {
				return DIALOG_INVALIG_INPUT;
			}

			return null;
		}
	}
}
