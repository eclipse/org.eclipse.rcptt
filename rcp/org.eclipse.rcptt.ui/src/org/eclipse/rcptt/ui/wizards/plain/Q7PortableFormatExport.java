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
package org.eclipse.rcptt.ui.wizards.plain;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.workspace.RcpttCore;

public class Q7PortableFormatExport extends Wizard implements IExportWizard {

	private IStructuredSelection selection;
	private Q7PortableFormatExportPage page;

	public Q7PortableFormatExport() {
		setWindowTitle("Export");
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	@Override
	public void addPages() {
		Object firstElement = selection.getFirstElement();
		ITestCase res = null;
		if (firstElement instanceof IResource) {
			IQ7Element el = RcpttCore.create((IResource) firstElement);
			if (el instanceof ITestCase) {
				res = (ITestCase) el;
			}
		} else if (firstElement instanceof ITestCase) {
			res = (ITestCase) firstElement;
		}
		if (res != null) {
			page = new Q7PortableFormatExportPage("Q7ExportToPortablePage", res);
			addPage(page);
		} else {
			addPage(new Q7PortableFormatExportFailurePage(
					"Q7ExportToPortablePage", res));
		}
	}

	@Override
	public boolean performFinish() {
		if( page.isPageComplete()) {
			return page.finish();
		}
		return false;
	}
}
