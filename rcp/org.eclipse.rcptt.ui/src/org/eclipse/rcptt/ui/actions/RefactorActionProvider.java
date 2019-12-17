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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

public class RefactorActionProvider extends CommonActionProvider {

	private RefactorActionGroup refactorGroup;
	
	public RefactorActionProvider() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
	 */
	public void init(ICommonActionExtensionSite anActionSite) {
		refactorGroup = new RefactorActionGroup(anActionSite.getViewSite().getShell(), (Tree)anActionSite.getStructuredViewer().getControl());
	}

	public void dispose() {
		refactorGroup.dispose();
	}

	public void fillActionBars(IActionBars actionBars) {
		refactorGroup.fillActionBars(actionBars);
	}

	public void fillContextMenu(IMenuManager menu) {
		refactorGroup.fillContextMenu(menu);
	}

	public void setContext(ActionContext context) {
		refactorGroup.setContext(context);
	}

	public void updateActionBars() {
		refactorGroup.updateActionBars();
	}
}
