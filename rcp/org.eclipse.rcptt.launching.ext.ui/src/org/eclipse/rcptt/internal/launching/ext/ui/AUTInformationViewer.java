/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.launching.ext.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;

public class AUTInformationViewer {
	private TableViewer informationViewer;

	public void create(Composite parent) {
		informationViewer = new TableViewer(parent);

		informationViewer.getTable().setHeaderVisible(true);
		TableColumn col1 = new TableColumn(informationViewer.getTable(),
				SWT.NONE);
		col1.setText("Property");
		col1.setWidth(150);

		TableColumn col2 = new TableColumn(informationViewer.getTable(),
				SWT.NONE);
		col2.setText("Value");
		col2.setWidth(300);

		GridData infoGD = new GridData(SWT.FILL, SWT.DEFAULT, true, false, 3, 1);
		infoGD.heightHint = 100;
		informationViewer.getControl().setLayoutData(infoGD);
		informationViewer.setContentProvider(new ArrayContentProvider());
		informationViewer.setLabelProvider(new MapLabelProvider());
	}

	public void updateInfo(ITargetPlatformHelper info) throws CoreException {
		// Initialize viewer with status
		informationViewer.setInput(info.getVersions().entrySet());
		informationViewer.refresh();
	}
}
