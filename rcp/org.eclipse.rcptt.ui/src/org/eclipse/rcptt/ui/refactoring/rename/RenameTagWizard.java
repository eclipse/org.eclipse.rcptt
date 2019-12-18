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
package org.eclipse.rcptt.ui.refactoring.rename;

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
import org.eclipse.rcptt.core.tags.Tag;

public class RenameTagWizard extends RefactoringWizard {

	public RenameTagWizard(Tag tag) {
		super(new RenameRefactoring(new RenameTagProcessor(tag)),
				DIALOG_BASED_USER_INTERFACE);
		setDefaultPageTitle(Messages.RenameTagWizard_PageTitle);
		setWindowTitle(Messages.RenameTagWizard_WindowTitle);
	}

	@Override
	protected void addUserInputPages() {
		RenameTagProcessor processor = (RenameTagProcessor) getRefactoring()
				.getAdapter(RenameTagProcessor.class);
		addPage(new RenameTagPage(processor));
	}

	final private static class RenameTagPage extends UserInputWizardPage {

		private final RenameTagProcessor processor;
		private Text nameText;

		public RenameTagPage(RenameTagProcessor processor) {
			super("RenameTagRefactoringInputPage"); //$NON-NLS-1$
			this.processor = processor;
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			composite.setLayout(gridLayout);

			setControl(composite);

			Label label = new Label(composite, SWT.LEFT);
			label.setText(Messages.RenameTagWizard_NewNameLabel);
			nameText = new Text(composite, SWT.BORDER);
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			nameText.setLayoutData(data);

			nameText.setText(processor.getTag().getValue());
			setPageComplete(false);
			nameText.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});
		}

		public void setVisible(boolean visible) {
			if (visible) {
				nameText.selectAll();
				nameText.forceFocus();
			}
			super.setVisible(visible);
		}

		protected final void validatePage() {
			String text = nameText.getText();
			RefactoringStatus status = processor.validateNewTagName(text);
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

		public IWizardPage getNextPage() {
			initializeRefactoring();
			storeSettings();
			return super.getNextPage();
		}

		private void storeSettings() {
		}

		private void initializeRefactoring() {
			processor.setNewTagName(nameText.getText());
		}
	}

}
