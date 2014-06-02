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
package org.eclipse.rcptt.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Folder;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.actions.ContextSnapshotAction;
import org.eclipse.rcptt.ui.context.ContextUIManager;
import org.eclipse.rcptt.ui.context.ContextViewer;
import org.eclipse.rcptt.ui.editors.IQ7Editor;

public class NewContextWizard extends Wizard implements INewWizard {

	private IWorkbench workbench;
	private IStructuredSelection selection;
	private WizardContextPage selectContextPage;
	private IContext context;
	private boolean takeSnapshot = false;
	private ContextType defaultType = null;

	public NewContextWizard() {
		setWindowTitle(Messages.NewContextWizard_WindowTitle);
	}

	public IContext getContext() {
		return context;
	}

	public void setTakeSnapshot(boolean snapshot) {
		this.takeSnapshot = snapshot;
	}

	public void setDefaultType(ContextType type) {
		this.defaultType = type;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	@Override
	public void addPages() {
		selectContextPage = new WizardContextPage(selection, defaultType);
		selectContextPage.setTakeSnapshot(takeSnapshot);
		addPage(selectContextPage);
	}

	@Override
	public boolean performFinish() {
		try {
			IProject project = selectContextPage.getProject();
			final ContextType type = selectContextPage.getContextType();
			String name = selectContextPage.getContextName();
			IPath containerPath = selectContextPage.getPathInProject();
			IQ7Folder folder = RcpttCore.create(project).getFolder(containerPath);
			context = folder.createContext(name, type, true,
					new NullProgressMonitor());
			if (takeSnapshot) {
				ContextViewer viewer = ContextUIManager.getInstance()
						.getViewer(type);
				IQ7NamedElement workingCopy = context
						.getWorkingCopy(new NullProgressMonitor());
				try {
					final IQ7Editor<Context> editor = viewer.getViewer()
							.createEditor();
					editor.setElement(workingCopy);
					ContextSnapshotAction action = new ContextSnapshotAction(
							editor);
					action.setJoin(true);
					action.run();
					if (action.getStatus() == Status.CANCEL_STATUS) {
						ResourcesPlugin.getWorkspace().getRoot().findMember(context.getPath()).delete(true, null);
						return false;
					}
					final IWorkspaceRunnable operation = new IWorkspaceRunnable() {
						public void run(IProgressMonitor monitor)
								throws CoreException {
							editor.save();
						}
					};
					try {
						ResourcesPlugin.getWorkspace().run(operation,
								new NullProgressMonitor());
						workingCopy.commitWorkingCopy(true,
								new NullProgressMonitor());
					} catch (CoreException e) {
						Q7UIPlugin.log(e.getCause());
					} finally {
						editor.dispose();
					}
				} finally {
					workingCopy.discardWorkingCopy();
				}
			} else {
				IDE.openEditor(getPage(), (IFile) context.getResource());
			}
		} catch (Exception e) {
			Q7UIPlugin.log(e);
			return false;
		}
		return true;
	}

	private IWorkbenchPage getPage() {
		return workbench.getActiveWorkbenchWindow().getActivePage();
	}

	public IProject getProject() {
		return selectContextPage.getProject();
	}
}
