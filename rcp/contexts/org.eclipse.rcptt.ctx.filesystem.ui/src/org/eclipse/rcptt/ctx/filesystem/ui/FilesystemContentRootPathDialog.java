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
package org.eclipse.rcptt.ctx.filesystem.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.ui.commons.OneSelectionListener;
import org.eclipse.rcptt.util.FileSystemResolver;

public class FilesystemContentRootPathDialog extends Dialog {
	Text rootText;
	String rootPath;
	FileSystemResolver resolver;

	protected FilesystemContentRootPathDialog(Shell parentShell,
			String path,
			FileSystemResolver resolver) {
		super(parentShell);
		rootPath = path;
		this.resolver = resolver;
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	public String getRootpath() {
		return rootPath;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setMinimumSize(550, 140);
		newShell.setText("Configure correct root path");
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		if (rootPath != null) {
			rootText.setText(rootPath);
		}
		validate();
		return control;

	}

	@Override
	protected void okPressed() {
		rootPath = rootText.getText();
		super.okPressed();
	}

	private void validate() {
		getButton(OK).setEnabled(resolver.isDirectory(rootText.getText()));
	}

	@Override
	protected Point getInitialSize() {
		return new Point(550, 140);
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		((GridLayout) composite.getLayout()).numColumns = 3;
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		Label rootLabel = new Label(composite, SWT.LEFT | SWT.WRAP);
		rootLabel.setText("Root path:");
		rootText = new Text(composite, SWT.BORDER);
		rootText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		rootText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validate();
			}
		});
		Button browseButton = new Button(composite, SWT.PUSH);
		browseButton.setText("Browse...");
		browseButton.addSelectionListener(new OneSelectionListener() {
			@Override
			public void selected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(parent.getShell());
				String result = dialog.open();
				if (result != null) {
					rootText.setText(resolver.make(result));
				}
			}
		});

		return composite;
	}

}
