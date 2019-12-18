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
package org.eclipse.rcptt.ui.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.actions.RenameResourceAction;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import org.eclipse.rcptt.ui.actions.edit.MoveAction;

public class RefactorActionGroup extends ActionGroup {

	private RenameResourceAction renameAction;

	private MoveAction moveAction;

	private Shell shell;

	private Tree tree;

	/**
	 * 
	 * @param aShell
	 * @param aTree
	 */
	public RefactorActionGroup(Shell aShell, Tree aTree) {
		shell = aShell;
		tree = aTree;
		makeActions();
	}

	public void fillContextMenu(IMenuManager menu) {
		IStructuredSelection selection = (IStructuredSelection) getContext()
				.getSelection();

		boolean anyResourceSelected = !selection.isEmpty()
				&& ResourceSelectionUtil.allResourcesAreOfType(selection,
						IResource.PROJECT | IResource.FOLDER | IResource.FILE);

		if (anyResourceSelected) {
			moveAction.selectionChanged(selection);
			menu.appendToGroup(ICommonMenuConstants.GROUP_REORGANIZE,
					moveAction);
			renameAction.selectionChanged(selection);
			menu.insertAfter(moveAction.getId(), renameAction);
		}
	}

	public void fillActionBars(IActionBars actionBars) {
		updateActionBars();

		actionBars.setGlobalActionHandler(ActionFactory.MOVE.getId(),
				moveAction);
		actionBars.setGlobalActionHandler(ActionFactory.RENAME.getId(),
				renameAction);
	}

	/**
	 * Handles a key pressed event by invoking the appropriate action.
	 * 
	 * @param event
	 *            The Key Event
	 */
	public void handleKeyPressed(KeyEvent event) {

		if (event.keyCode == SWT.F2 && event.stateMask == 0) {
			if (renameAction.isEnabled()) {
				renameAction.run();
			}

			// Swallow the event.
			event.doit = false;
		}
	}

	protected void makeActions() {
		IShellProvider sp = new IShellProvider() {
			public Shell getShell() {
				return shell;
			}
		};

		moveAction = new MoveAction(sp);
		moveAction.setActionDefinitionId(IWorkbenchCommandConstants.FILE_MOVE);

		renameAction = new RenameAction(sp, tree);
	}

	public void updateActionBars() {
		IStructuredSelection selection = (IStructuredSelection) getContext()
				.getSelection();

		moveAction.selectionChanged(selection);
		renameAction.selectionChanged(selection);
	}

}
