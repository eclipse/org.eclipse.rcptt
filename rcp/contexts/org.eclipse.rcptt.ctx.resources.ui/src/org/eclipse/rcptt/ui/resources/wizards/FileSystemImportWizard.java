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
package org.eclipse.rcptt.ui.resources.wizards;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;

import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.workspace.WSContainer;

@SuppressWarnings("restriction")
public class FileSystemImportWizard extends Wizard implements IImportWizard {

	private WizardFileSystemResourceImportPage1 mainPage;

	private WSContainer container;

	/**
	 * Creates a wizard for importing resources into the workspace from the file
	 * system.
	 */
	public FileSystemImportWizard(WSContainer container) {
		this.container = container;
		IDialogSettings workbenchSettings = Q7UIPlugin.getDefault()
				.getDialogSettings();
		IDialogSettings section = workbenchSettings
				.getSection("FileSystemImportWizard");//$NON-NLS-1$
		if (section == null) {
			section = workbenchSettings.addNewSection("FileSystemImportWizard");//$NON-NLS-1$
		}
		setDialogSettings(section);
	}

	/*
	 * (non-Javadoc) Method declared on IWizard.
	 */
	public void addPages() {
		super.addPages();
		mainPage = new WizardFileSystemResourceImportPage1(container);
		addPage(mainPage);
	}

	/*
	 * (non-Javadoc) Method declared on IWorkbenchWizard.
	 */
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		setWindowTitle(DataTransferMessages.DataTransfer_importTitle);
		setDefaultPageImageDescriptor(IDEWorkbenchPlugin
				.getIDEImageDescriptor("wizban/importdir_wiz.png"));//$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/*
	 * (non-Javadoc) Method declared on IWizard.
	 */
	public boolean performFinish() {
		return mainPage.finish();
	}
}
