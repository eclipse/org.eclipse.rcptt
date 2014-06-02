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
package org.eclipse.rcptt.ui.resources.imports;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;

import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.workspace.WorkspaceContext;

@SuppressWarnings("restriction")
public class ExternalProjectImportWizard extends Wizard implements
		IImportWizard {
	private static final String EXTERNAL_PROJECT_SECTION = "ExternalProjectImportWizard";//$NON-NLS-1$
	private WizardProjectsImportPage mainPage;
	private String initialPath = null;
	private WorkspaceContext context;

	/**
	 * Constructor for ExternalProjectImportWizard.
	 * 
	 * @param initialPath
	 *            Default path for wizard to import
	 * @since 3.5
	 */
	public ExternalProjectImportWizard(WorkspaceContext context,
			String initialPath) {
		super();
		this.initialPath = initialPath;
		this.context = context;
		setNeedsProgressMonitor(true);
		IDialogSettings workbenchSettings = Q7UIPlugin.getDefault()
				.getDialogSettings();

		IDialogSettings wizardSettings = workbenchSettings
				.getSection(EXTERNAL_PROJECT_SECTION);
		if (wizardSettings == null) {
			wizardSettings = workbenchSettings
					.addNewSection(EXTERNAL_PROJECT_SECTION);
		}
		setDialogSettings(wizardSettings);
	}

	/*
	 * (non-Javadoc) Method declared on IWizard.
	 */
	public void addPages() {
		super.addPages();
		mainPage = new WizardProjectsImportPage(context, initialPath); //$NON-NLS-1$
		addPage(mainPage);
	}

	/*
	 * (non-Javadoc) Method declared on IWorkbenchWizard.
	 */
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		setWindowTitle("Import");
		setDefaultPageImageDescriptor(IDEWorkbenchPlugin
				.getIDEImageDescriptor("wizban/importproj_wiz.png")); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc) Method declared on IWizard.
	 */
	public boolean performCancel() {
		mainPage.performCancel();
		return true;
	}

	/*
	 * (non-Javadoc) Method declared on IWizard.
	 */
	public boolean performFinish() {
		return mainPage.createProjects();
	}

}
