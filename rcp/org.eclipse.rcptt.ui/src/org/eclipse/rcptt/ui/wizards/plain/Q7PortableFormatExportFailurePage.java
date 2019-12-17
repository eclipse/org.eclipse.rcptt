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
package org.eclipse.rcptt.ui.wizards.plain;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.rcptt.core.model.IQ7Element;

public class Q7PortableFormatExportFailurePage extends WizardPage {
	protected Q7PortableFormatExportFailurePage(String pageName,
			IQ7Element element) {
		super(pageName);
	}

	public void createControl(Composite parent) {
		Composite cp = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().applyTo(cp);
		setControl(cp);
		setPageComplete(false);
		setErrorMessage("No testcase selected");
	}
}
