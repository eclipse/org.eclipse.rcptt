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
package org.eclipse.rcptt.ui.panels;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;

public class ActionToolbar {
	public Control create(Composite parent) {
		final ToolBarManager manager = new ToolBarManager(SWT.FLAT
				| SWT.HORIZONTAL);
		final ToolBar toolbar = manager.createControl(parent);
		fill(manager);
		manager.update(true);
		return toolbar;
	}

	protected void fill(ToolBarManager manager) {

	}
}
