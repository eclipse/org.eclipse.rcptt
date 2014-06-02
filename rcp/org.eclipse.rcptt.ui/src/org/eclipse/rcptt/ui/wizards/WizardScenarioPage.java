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

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;
import org.eclipse.rcptt.internal.ui.Messages;

public class WizardScenarioPage extends WizardExecutablePage {

	private Text nameText;
	private String name;
	// private Text authorText;
	protected String author;
	// private Text descrText;
	protected String description;

	public WizardScenarioPage(IStructuredSelection selection) {
		super(Messages.WizardScenarioPage_PageName, Messages.WizardScenarioPage_PageName, selection);
	}

	@Override
	protected void createContent(Composite parent) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(Messages.WizardScenarioPage_NameLabel);
		nameText = new Text(parent, SWT.BORDER);
		nameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).span(2, 1).applyTo(nameText);
		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				name = nameText.getText();
				validate();
			}
		});
		nameText.setFocus();

		// label = new Label(parent, SWT.LEFT);
		// label.setText("Author: ");
		// authorText = new Text(parent, SWT.BORDER);
		// authorText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// authorText.addModifyListener(new ModifyListener() {
		// public void modifyText(ModifyEvent e) {
		// author = authorText.getText();
		// validate();
		// }
		// });
		//
		// label = new Label(parent, SWT.LEFT);
		// label.setText("Description: ");
		// descrText = new Text(parent, SWT.BORDER | SWT.MULTI);
		// GridData dgd = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 2);
		// dgd.heightHint = 100;
		// descrText.setLayoutData(dgd);
		// descrText.addModifyListener(new ModifyListener() {
		// public void modifyText(ModifyEvent e) {
		// description = descrText.getText();
		// validate();
		// }
		// });
	}

	@Override
	protected boolean doValidate() {
		if (super.doValidate()) {
			if (name == null || name.length() == 0) {
				setErrorMessage(Messages.WizardScenarioPage_EmptyNameMsg);
				return false;
			}
			IQ7NamedElement[] elements = Q7SearchCore.findByName(name,
					new ReferencedProjectScope(RcpttCore.create(getProject())),
					new NullProgressMonitor());
			for (IQ7NamedElement iq7NamedElement : elements) {
				if (iq7NamedElement instanceof ITestCase) {
					setErrorMessage(Messages.WizardScenarioPage_DuplicateTestCaseMsg);
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public String getScenarioName() {
		return name;
	}

	@Override
	protected String getDefaultMessage() {
		return Messages.WizardScenarioPage_DefaultMsg;
	}

}
