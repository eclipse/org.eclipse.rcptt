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
package org.eclipse.rcptt.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.rcptt.core.model.IQ7Folder;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;

public class NewTestSuiteWizard extends Wizard implements INewWizard {

	private IWorkbench workbench;
	private IStructuredSelection selection;
	private WizardTestSuitePage testSuitePage;
	private boolean openEditor = true;
	private ITestSuite testSuite;

	public NewTestSuiteWizard() {
		setWindowTitle(Messages.NewTestSuiteWizard_WindowTitle);
	}

	public ITestSuite getTestSuite() {
		return testSuite;
	}

	public boolean openEditor() {
		return openEditor;
	}

	public void setOpenEditor(boolean openEditor) {
		this.openEditor = openEditor;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	@Override
	public void addPages() {
		testSuitePage = new WizardTestSuitePage(selection);
		addPage(testSuitePage);
	}

	@Override
	public boolean performFinish() {
		final boolean result[] = { false };
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					try {
						IProject project = testSuitePage.getProject();
						String name = testSuitePage.getTestSuiteName();
						IPath containerPath = testSuitePage.getPathInProject();
						IQ7Folder folder = RcpttCore.create(project).getFolder(containerPath);
						WriteAccessChecker writeAccessChecker = new WriteAccessChecker(getShell());
						if (!writeAccessChecker.makeResourceWritable(folder.getResource())) {
							result[0] = false;
							return;
						}
						testSuite = folder.createTestSuite(name, true,
										new NullProgressMonitor());
						if (openEditor) {
							IDE.openEditor(getPage(),
									(IFile) testSuite.getResource());
						}
						result[0] = true;
					} catch (Exception e) {
						Q7UIPlugin.log(e);
						result[0] = false;
					}
				}
			});
		} catch (Throwable e) {
			Q7UIPlugin.log(e);
		}
		return result[0];
	}

	private IWorkbenchPage getPage() {
		return workbench.getActiveWorkbenchWindow().getActivePage();
	}

	public IProject getProject() {
		return testSuitePage.getProject();
	}
}
