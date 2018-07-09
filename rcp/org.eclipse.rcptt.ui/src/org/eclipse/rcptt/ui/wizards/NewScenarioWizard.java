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
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;

public class NewScenarioWizard extends Wizard implements INewWizard {

	private IWorkbench workbench;
	private IStructuredSelection selection;
	private WizardScenarioPage scenarioPage;
	private boolean openEditor = true;
	private ITestCase testCase;

	public NewScenarioWizard() {
		setWindowTitle(Messages.NewScenarioWizard_WindowTitle);
	}

	public ITestCase getScenario() {
		return testCase;
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
		scenarioPage = new WizardScenarioPage(selection);
		addPage(scenarioPage);
	}

	@Override
	public boolean performFinish() {
		final boolean result[] = { false };
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					try {
						IProject project = scenarioPage.getProject();
						String name = scenarioPage.getScenarioName();
						IPath containerPath = scenarioPage.getPathInProject();
						IQ7Folder folder = RcpttCore.create(project).getFolder(containerPath);
						WriteAccessChecker writeAccessChecker = new WriteAccessChecker(getShell());
						if (!writeAccessChecker.makeResourceWritable(folder.getResource())) {
							result[0] = false;
							return;
						}
						testCase = folder.createTestCase(name, true, new NullProgressMonitor());
						ITestCase workingCopy = (ITestCase) testCase
								.getWorkingCopy(new NullProgressMonitor());
						try {
							workingCopy.setType(getType());
							if (!writeAccessChecker.makeResourceWritable(workingCopy)) {
								result[0] = false;
							} else {
								workingCopy.commitWorkingCopy(true,
										new NullProgressMonitor());
							}
						} finally {
							workingCopy.discardWorkingCopy();
						}
						if (openEditor) {
							IDE.openEditor(getPage(),
									(IFile) testCase.getResource());
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

	public String getType() {
		return "ecl"; //$NON-NLS-1$
	}

	private IWorkbenchPage getPage() {
		return workbench.getActiveWorkbenchWindow().getActivePage();
	}

	public IProject getProject() {
		return scenarioPage.getProject();
	}
}
