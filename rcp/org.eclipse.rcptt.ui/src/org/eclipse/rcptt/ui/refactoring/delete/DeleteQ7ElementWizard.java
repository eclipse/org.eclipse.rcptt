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
package org.eclipse.rcptt.ui.refactoring.delete;

import org.eclipse.core.resources.IResource;
import org.eclipse.ltk.core.refactoring.participants.DeleteRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

import org.eclipse.rcptt.internal.ui.Messages;

public class DeleteQ7ElementWizard extends RefactoringWizard {

	public DeleteQ7ElementWizard(IResource[] resources) {
		super(new DeleteRefactoring(new DeleteQ7ElementProcessor(resources)),
				DIALOG_BASED_USER_INTERFACE);
		setDefaultPageTitle(Messages.DeleteContextWizard_PageTitle);
		setWindowTitle(Messages.DeleteContextWizard_Title);
	}

	@Override
	protected void addUserInputPages() {
		DeleteQ7ElementProcessor processor = (DeleteQ7ElementProcessor) getRefactoring()
				.getAdapter(DeleteQ7ElementProcessor.class);
		addPage(new DeleteQ7ElementInputPage(processor));
	}

}
