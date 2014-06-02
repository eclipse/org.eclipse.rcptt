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

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.part.DrillDownAdapter;

public class LocationComposite extends Composite {
	private ToolBarManager toolBarMgr;

	private TreeViewer fChildTree;

	private DrillDownAdapter adapter;

	public LocationComposite(Composite parent, int style) {
		super(parent, style);
		createNavigationButtons();
	}

	protected void createNavigationButtons() {
		GridData gid;
		GridLayout layout;

		// Define layout.
		layout = new GridLayout();
		layout.marginHeight = layout.marginWidth = layout.horizontalSpacing = layout.verticalSpacing = 0;
		setLayout(layout);

		// Create a toolbar.
		toolBarMgr = new ToolBarManager(SWT.FLAT);
		ToolBar toolBar = toolBarMgr.createControl(this);
		
		gid = new GridData();
		gid.horizontalAlignment = GridData.FILL;
		gid.verticalAlignment = GridData.BEGINNING;
		toolBar.setLayoutData(gid);
	}

	public void fillToolItems(ToolBarManager toolBarMgr2) {
	}

	public void setChildTree(TreeViewer aViewer) {
		fillToolItems(toolBarMgr);
		// Save viewer.
		fChildTree = aViewer;

		// Create adapter.
		adapter = new DrillDownAdapter(fChildTree);
		adapter.addNavigationActions(toolBarMgr);
		toolBarMgr.update(true);

		// Set tree layout.
		fChildTree.getTree().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		layout();
	}
}