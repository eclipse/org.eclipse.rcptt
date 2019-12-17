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
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;
import org.eclipse.rcptt.internal.ui.Messages;

public class WizardTestSuitePage extends WizardExecutablePage {

	private Text nameText;
	private String name;

	public WizardTestSuitePage(IStructuredSelection selection) {
		super(Messages.WizardTestSuitePage_PageName,
				Messages.WizardTestSuitePage_PageName, selection);
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
				if (iq7NamedElement instanceof ITestSuite) {
					setErrorMessage(Messages.WizardTestSuitePage_DuplicateTestCaseMsg);
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public String getTestSuiteName() {
		return name;
	}

	@Override
	protected String getDefaultMessage() {
		return Messages.WizardTestSuitePage_DefaultMsg;
	}
}
