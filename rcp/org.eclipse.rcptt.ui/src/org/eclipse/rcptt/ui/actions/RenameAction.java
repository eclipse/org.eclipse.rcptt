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
package org.eclipse.rcptt.ui.actions;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.actions.RenameResourceAction;

import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.Q7ProjectMetadata;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.refactoring.RefactoringSaveHelper;
import org.eclipse.rcptt.ui.refactoring.rename.Q7RenameResourceWizard;
import org.eclipse.rcptt.ui.refactoring.rename.RenameTagWizard;

public class RenameAction extends RenameResourceAction {

	private IShellProvider provider;

	public RenameAction(IShellProvider provider) {
		super(provider);
		this.provider = provider;
		setActionDefinitionId(IWorkbenchCommandConstants.FILE_RENAME);
	}

	public RenameAction(IShellProvider provider, Tree tree) {
		super(provider, tree);
		this.provider = provider;
		setActionDefinitionId(IWorkbenchCommandConstants.FILE_RENAME);
	}

	@Override
	public void run() {
		if (LaunchUtils.hasLaunchedTestCases()) {
			MessageDialog.openWarning(provider.getShell(),
					Messages.RenameAction_ErrorDialogTitle,
					Messages.RenameAction_ErrorDialogMsg);
			return;
		}
		if (!RefactoringSaveHelper.checkDirtyEditors(provider.getShell())) {
			return;
		}
		if (containsSingleTag(getStructuredSelection())) {
			RenameTagWizard wizard = new RenameTagWizard(getSelectedTag());
			run(wizard, provider.getShell());
		} else {
			List<?> resources = getSelectedResources();
			if (resources.size() == 1) {
				IResource resource = (IResource) resources.get(0);
				Q7RenameResourceWizard wizard = new Q7RenameResourceWizard(
						resource);
				run(wizard, provider.getShell());
			}
		}
	}

	public void run(RefactoringWizard wizard, Shell parent) {
		try {
			RefactoringWizardOpenOperation operation = new RefactoringWizardOpenOperation(
					wizard);
			operation.run(parent, wizard.getWindowTitle());
		} catch (InterruptedException exception) {
			// Do nothing
		}
	}

	protected boolean updateSelection(IStructuredSelection selection) {
		for (Object o : selection.toArray()) {
			if (o instanceof IFile
					&& RcpttCore.isQ7ProjectMetadata(((IFile) o).getFullPath())
					|| o instanceof Q7ProjectMetadata) {
				return false;
			}
		}
		if (containsSingleTag(selection)) {
			return true;
		} else {
			return super.updateSelection(selection);
		}
	}

	private boolean containsSingleTag(IStructuredSelection selection) {
		int count = 0;
		for (Object o : selection.toArray()) {
			if (!(o instanceof Tag)) {
				return false;
			}
			count++;
		}
		return count == 1;
	}

	private Tag getSelectedTag() {
		for (Object o : getStructuredSelection().toArray()) {
			if (o instanceof Tag) {
				return (Tag) o;
			}
		}
		return null;
	}
}
