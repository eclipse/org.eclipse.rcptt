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
package org.eclipse.rcptt.ui.commons.listcelleditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class ChangeListDialog extends Dialog {

	private ListControl control;
	private List<StringWrapper> values;
	private final String title;

	public ChangeListDialog(Shell parent, List<StringWrapper> values,
			String title) {
		super(parent);
		setShellStyle(getShellStyle() | SWT.RESIZE | SWT.MAX);
		this.values = values;
		this.title = title;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(title);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout());
		if (values == null)
			values = new ArrayList<StringWrapper>();
		control = new ListControl(composite, SWT.BORDER, true, values);
		control.setLayoutData(new GridData(GridData.FILL_BOTH));
		return composite;
	}

	public List<StringWrapper> getResult() {
		return control.getValues();
	}

	@Override
	public int open() {
		return super.open();
	}

}
