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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.texteditor.BasicTextEditorActionContributor;

import org.eclipse.rcptt.ui.actions.GotoScriptLineAction;
import org.eclipse.rcptt.ui.editors.context.ContextEditor;
import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class ScenarioEditorActionContributor extends
		BasicTextEditorActionContributor {

	private IEditorPart fActiveEditorPart;

	private GotoScriptLineAction fGotoLine;

	public ScenarioEditorActionContributor() {
		fGotoLine = new GotoScriptLineAction(null);
		fGotoLine
				.setActionDefinitionId(GotoScriptLineAction.GOTOLINE_ACTION_ID);
	}

	public void contributeToMenu(IMenuManager menu) {
		IMenuManager navigateMenu = menu
				.findMenuUsingPath(IWorkbenchActionConstants.M_NAVIGATE);
		if (navigateMenu != null) {
			navigateMenu.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS,
					fGotoLine);
		}
	}

	public void setActiveEditor(IEditorPart part) {
		if (fActiveEditorPart == part)
			return;
		fActiveEditorPart = part;

		EclEditor editor = null;
		if (part instanceof EclEditor) {
			editor = (EclEditor) part;
		} else if (part instanceof ContextEditor) {
			part = ((ContextEditor) part).getEditor();
			if (part instanceof EclEditor)
				editor = (EclEditor) part;
		}
		if (editor == null)
			return;
		fGotoLine.setTextViewer(editor.getViewer());
		IActionBars actionBars = getActionBars();
		actionBars.setGlobalActionHandler(
				GotoScriptLineAction.GOTOLINE_ACTION_ID, fGotoLine);
		super.setActiveEditor(editor);
	}
}
