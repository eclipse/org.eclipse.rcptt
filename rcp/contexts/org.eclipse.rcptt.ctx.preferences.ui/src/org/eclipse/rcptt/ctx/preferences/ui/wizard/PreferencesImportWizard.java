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
package org.eclipse.rcptt.ctx.preferences.ui.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import org.eclipse.rcptt.ui.editors.IQ7Editor;

public class PreferencesImportWizard extends Wizard implements IImportWizard {

	private WizardPreferencesPage mainPage;
	private final IQ7Editor contextEditor;

	public PreferencesImportWizard(IQ7Editor contextEditor) {
		this.contextEditor = contextEditor;
	}

	@Override
	public void addPages() {
		super.addPages();
		mainPage = new WizardPreferencesPage();
		addPage(mainPage);
	}

	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		setWindowTitle("Import Preferences");
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean performFinish() {
		return mainPage.finish(contextEditor);
	}
	@Override
	public String getWindowTitle() {
		return mainPage.getTitle();
	}
}
