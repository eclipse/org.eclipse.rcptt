/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.nature.RcpttNature;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class NewQ7ProjectWizard extends BasicNewProjectResourceWizard {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard#addPages
	 * ()
	 */
	@Override
	public void addPages() {
		super.addPages();
		if (getPages().length > 0) {
			IWizardPage page = getPages()[0];
			page.setTitle(Messages.NewQ7ProjectWizard_Title);
			page.setDescription(Messages.NewQ7ProjectWizard_Description);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard#
	 * performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (super.performFinish()) {
			IProject project = getNewProject();
			try {
				RcpttNature.updateProjectNature(project, true);
				IQ7Project iq7Project = RcpttCore.create(project);
				iq7Project.getMetadata();
				return true;
			} catch (CoreException e) {
				Q7UIPlugin.log(e);
			}
		}
		return false;
	}
}