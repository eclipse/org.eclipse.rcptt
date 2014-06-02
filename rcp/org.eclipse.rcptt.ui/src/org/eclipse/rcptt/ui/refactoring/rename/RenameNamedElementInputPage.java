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
package org.eclipse.rcptt.ui.refactoring.rename;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.util.FileUtil;

public class RenameNamedElementInputPage extends UserInputWizardPage {

	private final Q7RenameProcessor fRefactoringProcessor;

	private Text nameText;
	private Text fileName;

	private IQ7NamedElement element;
	private IFile file;

	public RenameNamedElementInputPage(Q7RenameProcessor processor) {
		super("RenameResourceRefactoringInputPage"); //$NON-NLS-1$
		fRefactoringProcessor = processor;
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		composite.setLayout(gridLayout);

		setControl(composite);

		Label label = new Label(composite, SWT.LEFT);
		label.setText(Messages.RenameNamedElementInputPage_NewNameLabel);
		nameText = new Text(composite, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		nameText.setLayoutData(data);

		Label fName = new Label(composite, SWT.LEFT);
		fName.setText(Messages.RenameNamedElementInputPage_FileNameLabel);
		fileName = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		fileName.setEnabled(false);
		GridDataFactory.fillDefaults().applyTo(fileName);

		try {
			nameText.setText(getElement().getElementName());
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		fileName.setText(getFile().getName());
		setPageComplete(false);
		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				fileName.setText(FileUtil.escapeFileName(nameText.getText(),
						file.getFileExtension()));
				validatePage();
			}
		});
	}

	private IFile getFile() {
		if (file == null) {
			file = (IFile) fRefactoringProcessor.getResource();
		}
		return file;
	}

	private IQ7NamedElement getElement() {
		if (element == null) {
			element = (IQ7NamedElement) RcpttCore.create(getFile());
		}
		return element;
	}

	public void setVisible(boolean visible) {
		if (visible) {
			nameText.selectAll();
			nameText.forceFocus();
		}
		super.setVisible(visible);
	}

	protected final void validatePage() {
		String text = fileName.getText();
		String name = nameText.getText();
		RefactoringStatus status = fRefactoringProcessor
				.validateNewElementName(name, text);
		setPageComplete(status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.ui.refactoring.UserInputWizardPage#performFinish()
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
		fRefactoringProcessor.setNewElementName(nameText.getText());
		fRefactoringProcessor.setNewResourceName(fileName.getText());
	}
}
