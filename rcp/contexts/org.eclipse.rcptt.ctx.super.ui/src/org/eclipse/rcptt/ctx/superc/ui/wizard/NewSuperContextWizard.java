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
package org.eclipse.rcptt.ctx.superc.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Folder;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.scenario.SuperContext;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.ide.IDE;

public class NewSuperContextWizard extends Wizard implements INewWizard {

	private IWorkbench workbench;
	private IStructuredSelection selection;
	private SuperWizardContextPage selectContextPage;
	private IContext context;

	public NewSuperContextWizard() {
		setWindowTitle("New Super Context Wizard");
	}

	public IContext getContext() {
		return context;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	@Override
	public void addPages() {
		selectContextPage = new SuperWizardContextPage(selection);
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
			WriteAccessChecker writeAccessChecker = new WriteAccessChecker(getShell());
			if (!writeAccessChecker.makeResourceWritable(folder.getResource())) {
				return false;
			}
			context = folder.createContext(name, ContextTypeManager
					.getInstance()
					.getTypeById("org.eclipse.rcptt.ctx.super"), true,
					new NullProgressMonitor());
			IQ7NamedElement copy = context
					.getWorkingCopy(new NullProgressMonitor());
			try {
				SuperContext superCtx = (SuperContext) copy.getNamedElement();
				superCtx.setChildType(type.getId());
				if (!writeAccessChecker.makeResourceWritable(copy)) {
					return false;
				}
				copy.commitWorkingCopy(true, new NullProgressMonitor());
			} finally {
				copy.discardWorkingCopy();
			}
			IDE.openEditor(
					workbench.getActiveWorkbenchWindow().getActivePage(),
					(IFile) context.getResource());
		} catch (Exception e) {
			Q7UIPlugin.log(e);
			return false;
		}
		return true;
	}

	public IProject getProject() {
		return selectContextPage.getProject();
	}
}
