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

import java.util.ResourceBundle;

import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextOperationTargetExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ResourceAction;
import org.eclipse.ui.texteditor.TextEditorAction;

import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public final class EclContentAssistAction extends TextEditorAction {

	/** The text operation target */
	private ITextOperationTarget fOperationTarget;
	private EclEditor eclEditor;

	/**
	 * Creates and initializes the action for the given text editor. The action
	 * configures its visual representation from the given resource bundle. The
	 * action works by asking the text editor at the time for its text operation
	 * target adapter (using <code>getAdapter(ITextOperationTarget.class)</code>
	 * . The action runs the content assist operation on this target.
	 * 
	 * @param bundle
	 *            the resource bundle
	 * @param prefix
	 *            a prefix to be prepended to the various resource keys
	 *            (described in <code>ResourceAction</code> constructor), or
	 *            <code>null</code> if none
	 * @param editor
	 *            the text editor
	 * @see ResourceAction#ResourceAction(ResourceBundle, String)
	 */
	public EclContentAssistAction(ResourceBundle bundle, String prefix,
			EclEditor editor) {
		super(bundle, prefix, editor);
		this.eclEditor = editor;
	}

	/**
	 * Runs the content assist operation on the editor's text operation target.
	 */
	public void run() {
		boolean editorsActive = !this.eclEditor.viewer.getControl()
				.isFocusControl()
				&& (this.eclEditor.header.isInFocus() || this.eclEditor.editorContent
						.isInFocus());
		if (editorsActive) {
			return;
		}
		if (fOperationTarget != null) {

			ITextEditor editor = getTextEditor();
			if (editor != null && validateEditorInputState()) {

				Display display = null;

				IWorkbenchPartSite site = editor.getSite();
				Shell shell = site.getShell();
				if (shell != null && !shell.isDisposed())
					display = shell.getDisplay();

				BusyIndicator.showWhile(display, new Runnable() {
					public void run() {
						fOperationTarget
								.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
					}
				});
			}
		}
	}

	/**
	 * The <code>ContentAssistAction</code> implementation of this
	 * <code>IUpdate</code> method discovers the operation through the current
	 * editor's <code>ITextOperationTarget</code> adapter, and sets the enabled
	 * state accordingly.
	 */
	public void update() {

		ITextEditor editor = getTextEditor();

		if (fOperationTarget == null && editor != null)
			fOperationTarget = (ITextOperationTarget) editor
					.getAdapter(ITextOperationTarget.class);

		if (fOperationTarget == null) {
			setEnabled(false);
			return;
		}

		if (fOperationTarget instanceof ITextOperationTargetExtension) {
			ITextOperationTargetExtension targetExtension = (ITextOperationTargetExtension) fOperationTarget;
			targetExtension.enableOperation(
					ISourceViewer.CONTENTASSIST_PROPOSALS, canModifyEditor());
		}

		setEnabled(fOperationTarget
				.canDoOperation(ISourceViewer.CONTENTASSIST_PROPOSALS));
	}

	/**
	 * @see TextEditorAction#setEditor(ITextEditor)
	 */
	public void setEditor(ITextEditor editor) {
		super.setEditor(editor);
		fOperationTarget = null;
	}
}
