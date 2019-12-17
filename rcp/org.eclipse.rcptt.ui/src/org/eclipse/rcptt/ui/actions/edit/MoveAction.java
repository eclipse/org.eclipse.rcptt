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
package org.eclipse.rcptt.ui.actions.edit;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ui.actions.MoveResourceAction;

import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.Q7ProjectMetadata;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.refactoring.RefactoringSaveHelper;

public class MoveAction extends MoveResourceAction {

	public MoveAction(IShellProvider provider) {
		super(provider);
	}

	@Override
	public void run() {
		if (LaunchUtils.hasLaunchedTestCases()) {
			MessageDialog.openWarning(shellProvider.getShell(),
					Messages.MoveAction_ErrorDialogTitle,
					Messages.MoveAction_ErrorDialogMsg);
			return;
		}
		if (!RefactoringSaveHelper.checkDirtyEditors(shellProvider.getShell())) {
			return;
		}
		super.run();
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		for (Object o : selection.toArray()) {
			if (o instanceof IFile
					&& RcpttCore.isQ7ProjectMetadata(((IFile) o).getFullPath())
					|| o instanceof Q7ProjectMetadata) {
				return false;
			}
		}
		return super.updateSelection(selection);
	}

}
