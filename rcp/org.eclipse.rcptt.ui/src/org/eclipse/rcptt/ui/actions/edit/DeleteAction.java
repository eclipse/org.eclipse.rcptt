/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.actions.edit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.Q7ProjectMetadata;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.refactoring.delete.DeleteQ7ElementWizard;
import org.eclipse.rcptt.ui.refactoring.delete.DeleteTagWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.DeleteResourceAction;

public class DeleteAction extends DeleteResourceAction {

	private final IShellProvider provider;

	public DeleteAction(IShellProvider provider) {
		super(provider);
		this.provider = provider;
		ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		setDisabledImageDescriptor(images
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		setImageDescriptor(images
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setActionDefinitionId(IWorkbenchCommandConstants.EDIT_DELETE);
	}

	@Override
	public void run() {
		if (LaunchUtils.hasLaunchedTestCases()) {
			MessageDialog.openWarning(provider.getShell(),
					Messages.DeleteAction_ErrorDialogTitle,
					Messages.DeleteAction_ErrorDialogMsg);
			return;
		}
		if (containsOnlyTags(getStructuredSelection())) {
			run(new DeleteTagWizard(getSelectedTags()), provider.getShell());
		} else {
			IResource[] resources = getSelectedResourcesArray();
			run(new DeleteQ7ElementWizard(resources), provider.getShell());
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

	private boolean containsQ7Elements(IResource[] resources) {
		for (IResource resource : resources) {
			if (resource instanceof IFile) {
				if (RcpttCore.isQ7File(resource.getFullPath())) {
					return true;
				}
			}
			if (resource instanceof IContainer) {
				try {
					IResource[] members = ((IContainer) resource).members();
					if (containsQ7Elements(members)) {
						return true;
					}
				} catch (CoreException e) {
					Q7UIPlugin.log(e);
				}
			}
		}
		return false;
	}

	/**
	 * Return an array of the currently selected resources.
	 * 
	 * @return the selected resources
	 */
	private IResource[] getSelectedResourcesArray() {
		List<?> selection = getSelectedResources();
		IResource[] resources = new IResource[selection.size()];
		selection.toArray(resources);
		return resources;
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
		if (containsOnlyTags(selection)) {
			return true;
		} else {
			return super.updateSelection(selection);
		}
	}

	private boolean containsOnlyTags(IStructuredSelection selection) {
		int count = 0;
		for (Object o : selection.toArray()) {
			if (!(o instanceof Tag)) {
				return false;
			}
			count++;
		}
		return count == 1;
	}

	private List<Tag> getSelectedTags() {
		List<Tag> tags = new ArrayList<Tag>();
		for (Object o : getStructuredSelection().toArray()) {
			if (o instanceof Tag) {
				tags.add((Tag) o);
			}
		}
		return tags;
	}

}
