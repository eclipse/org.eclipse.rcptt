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
package org.eclipse.rcptt.ui.dialogs;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Folder;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.wizards.NewContextWizard;
import org.eclipse.rcptt.ui.wizards.NewQ7ProjectWizard;
import org.eclipse.rcptt.ui.wizards.NewScenarioWizard;
import org.eclipse.rcptt.ui.wizards.NewVerificationWizard;

public class DialogUtil {

	public static ITestCase openNewScenarioDialog(Shell shell,
			boolean openEditor) {
		return openNewScenarioDialog(shell, openEditor, null);
	}

	public static ITestCase openNewScenarioDialog(Shell shell,
			boolean openEditor, IQ7Folder folder) {
		Assert.isNotNull(shell);
		NewScenarioWizard wizard = new NewScenarioWizard();
		wizard.setOpenEditor(openEditor);
		IStructuredSelection selection = DialogUtil
				.getWorkingProjectSelection(shell);
		if (folder != null) {
			selection = new StructuredSelection(folder.getResource());
		}
		if (selection.isEmpty()) {
			return null;
		}
		wizard.init(PlatformUI.getWorkbench(), selection);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		if (dialog.open() == WizardDialog.OK) {
			workingProject = wizard.getProject();
			return wizard.getScenario();
		}
		return null;
	}

	public static IContext openNewContextDialog(Shell shell,
			boolean takeSnapshot, ContextType defaultType) {
		Assert.isNotNull(shell);
		NewContextWizard wizard = new NewContextWizard();
		wizard.setTakeSnapshot(takeSnapshot);
		wizard.setDefaultType(defaultType);
		IStructuredSelection selection = DialogUtil
				.getWorkingProjectSelection(shell);
		if (selection.isEmpty()) {
			return null;
		}
		wizard.init(PlatformUI.getWorkbench(), selection);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		int result = dialog.open();
		if (result == Window.OK) {
			workingProject = wizard.getProject();
			return wizard.getContext();
		}
		return null;
	}

	public static IVerification openNewVerificationDialog(Shell shell,
			boolean takeSnapshot) {
		return openNewVerificationDialog(shell, takeSnapshot, null, null, null);
	}

	public static IVerification openNewVerificationDialog(Shell shell,
			boolean takeSnapshot, VerificationType type, String widgetClass,
			String selector) {
		Assert.isNotNull(shell);
		NewVerificationWizard wizard =
				new NewVerificationWizard(type, widgetClass, selector);
		wizard.setTakeSnapshot(takeSnapshot);
		IStructuredSelection selection = DialogUtil
				.getWorkingProjectSelection(shell);
		if (selection.isEmpty()) {
			return null;
		}
		wizard.init(PlatformUI.getWorkbench(), selection);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		int result = dialog.open();
		if (result == Window.OK) {
			workingProject = wizard.getProject();
			return wizard.getVerification();
		}
		return null;
	}

	private static IProject workingProject = null;

	private static IStructuredSelection getWorkingProjectSelection(Shell shell) {
		return createProjectSelection(getWorkingProject(shell));
	}

	private static IProject getWorkingProject(Shell shell) {
		IStructuredSelection ss = getCurrentSelection();
		for (Object o : ss.toArray()) {
			if (o instanceof IResource) {
				IProject project = ((IResource) o).getProject();
				if (project.isAccessible()) {
					workingProject = project;
					return workingProject;
				}
			} else if (o instanceof IEditorPart) {
				IResource res = (IResource) ((IEditorPart) o)
						.getAdapter(IResource.class);
				if (res != null) {
					IProject project = res.getProject();
					if (project.isAccessible()) {
						workingProject = project;
						return workingProject;
					}
				}
			}
		}
		if (workingProject != null && workingProject.isAccessible()) {
			return workingProject;
		}
		RcpttCore.getInstance();
		IProject[] projects = RcpttCore.getQ7Projects();
		if (projects.length > 0) {
			if (projects[0].isAccessible()) {
				workingProject = projects[0];
				return workingProject;
			}
		}
		workingProject = openNewQ7ProjectDialog(shell);
		return workingProject;
	}

	private static IProject openNewQ7ProjectDialog(Shell shell) {
		MessageBox msg = new MessageBox(shell, SWT.OK | SWT.CANCEL);
		msg.setText(shell.getText());
		msg.setMessage(Messages.DialogUtil_NewQ7ProjectDialogMsg);
		if (msg.open() == SWT.OK) {
			NewQ7ProjectWizard wizard = new NewQ7ProjectWizard();
			IWorkbench workbench = PlatformUI.getWorkbench();
			wizard.init(workbench, new StructuredSelection(ResourcesPlugin
					.getWorkspace().getRoot()));
			wizard.setWindowTitle(Messages.DialogUtil_NewQ7ProjectDialogTitle);
			WizardDialog dialog = new WizardDialog(shell, wizard);
			if (dialog.open() == WizardDialog.OK) {
				return wizard.getNewProject();
			}
		}
		return null;
	}

	private static IStructuredSelection getCurrentSelection() {
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window != null) {
			IWorkbenchPage page = window.getActivePage();
			if (page != null) {
				IWorkbenchPart part = page.getActivePart();
				if (part instanceof IEditorPart) {
					return new StructuredSelection(part);
				} else if (part != null) {
					IWorkbenchSite site = part.getSite();
					if (site != null) {
						ISelectionProvider provider = site
								.getSelectionProvider();
						if (provider != null) {
							ISelection selection = provider.getSelection();
							if (selection instanceof IStructuredSelection) {
								return (IStructuredSelection) provider
										.getSelection();
							}
						}
					}
				}
			}
		}
		return StructuredSelection.EMPTY;
	}

	private static IStructuredSelection createProjectSelection(IProject project) {
		return project == null ? StructuredSelection.EMPTY
				: new StructuredSelection(project);
	}
}
