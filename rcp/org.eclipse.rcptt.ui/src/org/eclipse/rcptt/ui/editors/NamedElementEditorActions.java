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
package org.eclipse.rcptt.ui.editors;

import java.util.ResourceBundle;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.texteditor.IAbstractTextEditorHelpContextIds;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ResourceAction;

public class NamedElementEditorActions {
	private ResourceAction undoAction;
	private ResourceAction redoAction;
	private ResourceAction copyAction;
	private ResourceAction cutAction;
	private ResourceAction pasteAction;

	private INamedElementActions actions;
	private IActionBars actionBars;

	public interface INamedElementActions {
		void undo();

		void redo();

		boolean canUndo();

		boolean canRedo();

		void copy();

		void paste();

		void cut();

		boolean canCopy();

		boolean canPaste();

		boolean canCut();
	}

	public NamedElementEditorActions(INamedElementActions actions, IActionBars actionBars) {
		this.actions = actions;
		this.actionBars = actionBars;
		createActions(actionBars);
	}

	protected void createActions(IActionBars actionBars) {
		if (actions != null) {
			ResourceBundle bundle = ResourceBundle
					.getBundle("org.eclipse.rcptt.ui.editors.ecl.EclEditorPluginResources"); //$NON-NLS-1$

			// Undo action
			undoAction = new ResourceAction(bundle, "Editor.Undo.") {
				@Override
				public void run() {
					actions.undo();
				}
			};
			register(undoAction, IAbstractTextEditorHelpContextIds.UNDO_ACTION, IWorkbenchCommandConstants.EDIT_UNDO);

			// Redo action
			redoAction = new ResourceAction(bundle, "Editor.Redo.") {
				@Override
				public void run() {
					actions.redo();
				}
			};
			register(redoAction, IAbstractTextEditorHelpContextIds.REDO_ACTION, IWorkbenchCommandConstants.EDIT_REDO);

			// Copy action
			copyAction = new ResourceAction(bundle, "Editor.Copy.") {
				@Override
				public void run() {
					actions.copy();
				}
			};
			register(copyAction, IAbstractTextEditorHelpContextIds.COPY_ACTION, IWorkbenchCommandConstants.EDIT_COPY);
			// Cut action
			cutAction = new ResourceAction(bundle, "Editor.Cut.") {
				@Override
				public void run() {
					actions.cut();
				}
			};
			register(cutAction, IAbstractTextEditorHelpContextIds.CUT_ACTION, IWorkbenchCommandConstants.EDIT_CUT);
			// Paste action
			pasteAction = new ResourceAction(bundle, "Editor.Paste.") {
				@Override
				public void run() {
					actions.paste();
				}
			};
			register(pasteAction, IAbstractTextEditorHelpContextIds.PASTE_ACTION,
					IWorkbenchCommandConstants.EDIT_PASTE);
		}
	}

	public void activate() {
		if (actionBars != null) {
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.UNDO, undoAction);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.REDO, redoAction);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.COPY, copyAction);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.PASTE, pasteAction);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.CUT, cutAction);
			actionBars.updateActionBars();
		}
	}

	public void deactivate() {
		if (actionBars != null) {
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.UNDO, null);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.REDO, null);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.COPY, null);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.PASTE, null);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.CUT, null);
			actionBars.updateActionBars();
		}
	}

	private void register(ResourceAction action, String helpContextId, String actionDefinitionId) {
		action
				.setHelpContextId(helpContextId);
		action
				.setActionDefinitionId(actionDefinitionId);
	}

	public void updateEnablement() {
		if (actions != null) {
			undoAction.setEnabled(actions.canUndo());
			redoAction.setEnabled(actions.canRedo());
			copyAction.setEnabled(actions.canCopy());
			pasteAction.setEnabled(actions.canPaste());
			cutAction.setEnabled(actions.canCut());
			actionBars.updateActionBars();
		}
	}
}
