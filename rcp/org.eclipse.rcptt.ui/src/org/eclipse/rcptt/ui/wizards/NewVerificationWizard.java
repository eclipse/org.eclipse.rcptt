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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ltk.core.refactoring.resource.DeleteResourceChange;
import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.model.IQ7Folder;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.actions.VerificationSnapshotAction;
import org.eclipse.rcptt.ui.editors.IQ7Editor;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;
import org.eclipse.rcptt.ui.verification.VerificationUIManager;
import org.eclipse.rcptt.ui.verification.VerificationViewer;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;

public class NewVerificationWizard extends Wizard implements INewWizard {

	private IWorkbench workbench;
	private IStructuredSelection selection;
	private WizardVerificationPage verificationPage;
	private IVerification verification;
	private boolean takeSnapshot = false;
	private final VerificationType type;
	private final String widgetClass;
	private final String selector;

	public NewVerificationWizard() {
		this(null, null, null);
	}

	public NewVerificationWizard(VerificationType type, String widgetClass, String selector) {
		setWindowTitle(Messages.NewVerificationWizard_WindowTitle);

		this.type = type;
		this.widgetClass = widgetClass;
		this.selector = selector;
	}

	public IVerification getVerification() {
		return verification;
	}

	public void setTakeSnapshot(boolean snapshot) {
		this.takeSnapshot = snapshot;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	@Override
	public void addPages() {
		verificationPage = new WizardVerificationPage(selection, type, widgetClass);
		verificationPage.setTakeSnapshot(takeSnapshot);
		addPage(verificationPage);
	}

	@Override
	public boolean performFinish() {
		try {
			IProject project = verificationPage.getProject();
			final VerificationType type = verificationPage.getVerificationType();
			String name = verificationPage.getVerificationName();
			IPath containerPath = verificationPage.getPathInProject();
			IQ7Folder folder = RcpttCore.create(project).getFolder(containerPath);
			WriteAccessChecker writeAccessChecker = new WriteAccessChecker(getShell());
			if (!writeAccessChecker.makeResourceWritable(folder.getResource())) {
				return false;
			}
			verification = folder.createVerification(name, type, true,
					new NullProgressMonitor());
			if (takeSnapshot) {
				VerificationViewer viewer = VerificationUIManager.getInstance()
						.getViewer(type);
				IQ7NamedElement workingCopy = verification
						.getWorkingCopy(new NullProgressMonitor());
				try {
					final IQ7Editor<Verification> editor = viewer.getViewer()
							.createEditor();
					editor.setElement(workingCopy);
					VerificationSnapshotAction action =
							new VerificationSnapshotAction(getShell(), editor, selector);
					action.setJoin(true);
					action.run();
					if (action.getStatus().getSeverity() == IStatus.CANCEL) {
						workingCopy.discardWorkingCopy();
						workingCopy = null;
						new DeleteResourceChange(verification.getPath(), true, true).
								perform(new NullProgressMonitor());
						return false;
					}
					final IWorkspaceRunnable operation = new IWorkspaceRunnable() {
						public void run(IProgressMonitor monitor) throws CoreException {
							editor.save();
						}
					};
					try {
						ResourcesPlugin.getWorkspace().run(operation,
								new NullProgressMonitor());
						if (!writeAccessChecker.makeResourceWritable(workingCopy)) {
							return false;
						}
						workingCopy.commitWorkingCopy(true, new NullProgressMonitor());
					} catch (CoreException e) {
						Q7UIPlugin.log(e.getCause());
					} finally {
						editor.dispose();
					}
				} finally {
					if (workingCopy != null)
						workingCopy.discardWorkingCopy();
				}
			} else {
				IDE.openEditor(getPage(), (IFile) verification.getResource());
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
		return verificationPage.getProject();
	}

}
