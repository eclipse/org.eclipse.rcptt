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
package org.eclipse.rcptt.ui.refactoring.rename;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.internal.ui.Messages;

public class Q7RenameResourceWizard extends RefactoringWizard {

	public Q7RenameResourceWizard(IResource resource) {
		super(new RenameRefactoring(new Q7RenameProcessor(resource)),
				DIALOG_BASED_USER_INTERFACE);
		setDefaultPageTitle(Messages.Q7RenameResourceWizard_PageTitle);
		setWindowTitle(Messages.Q7RenameResourceWizard_WindowTitle);
	}

	@Override
	protected void addUserInputPages() {
		Q7RenameProcessor processor = (Q7RenameProcessor) getRefactoring()
				.getAdapter(Q7RenameProcessor.class);
		if (processor.getNamedElement() != null) {
			addPage(new RenameNamedElementInputPage(processor));
		} else {
			addPage(new RenameResourceInputPage(processor));
		}
	}

	private static class RenameResourceInputPage extends UserInputWizardPage {

		private final Q7RenameProcessor fRefactoringProcessor;
		private Text fNameField;

		public RenameResourceInputPage(Q7RenameProcessor processor) {
			super("RenameResourceRefactoringInputPage"); //$NON-NLS-1$
			fRefactoringProcessor = processor;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt
		 * .widgets.Composite)
		 */
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, false));
			composite
					.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setFont(parent.getFont());

			Label label = new Label(composite, SWT.NONE);
			label.setText(Messages.Q7RenameResourceWizard_NewNameLabel);
			label.setLayoutData(new GridData());

			fNameField = new Text(composite, SWT.BORDER);
			fNameField.setText(fRefactoringProcessor.getNewResourceName());
			fNameField.setFont(composite.getFont());
			fNameField.setLayoutData(new GridData(GridData.FILL,
					GridData.BEGINNING, true, false));
			fNameField.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});

			fNameField.selectAll();
			setPageComplete(false);
			setControl(composite);
		}

		public void setVisible(boolean visible) {
			if (visible) {
				fNameField.setFocus();
			}
			super.setVisible(visible);
		}

		protected final void validatePage() {
			String text = fNameField.getText();

			RefactoringStatus status = fRefactoringProcessor
					.validateNewElementName(text, text);
			setPageComplete(status);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ltk.ui.refactoring.UserInputWizardPage#performFinish()
		 */
		protected boolean performFinish() {
			initializeRefactoring();
			storeSettings();
			return super.performFinish();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ltk.ui.refactoring.UserInputWizardPage#getNextPage()
		 */
		public IWizardPage getNextPage() {
			initializeRefactoring();
			storeSettings();
			return super.getNextPage();
		}

		private void storeSettings() {
		}

		private void initializeRefactoring() {
			fRefactoringProcessor.setNewResourceName(fNameField.getText());
		}
	}

}
