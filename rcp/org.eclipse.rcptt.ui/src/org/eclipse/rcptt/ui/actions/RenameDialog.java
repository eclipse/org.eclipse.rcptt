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
package org.eclipse.rcptt.ui.actions;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.internal.ui.Messages;

public class RenameDialog extends Dialog {

	private Text nameText;
	private String oldName;
	private Text fileName;
	private Set<String> scenarious;
	private IFile file;
	private String resultName;
	private String resultFileName;
	private String dialogName;
	private Set<IPath> fileSkip;
	private String newNameProposal;

	public RenameDialog(Shell parentShell, String oldName,
			Set<String> scenarios, IFile file, String dialogName,
			Set<IPath> filesSkip, String newNameProposal) {
		super(parentShell);
		this.dialogName = dialogName;
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.scenarious = scenarios;
		this.file = file;
		this.fileSkip = filesSkip;
		this.oldName = oldName;
		if (oldName == null) {
			oldName = ""; //$NON-NLS-1$
		}
		this.newNameProposal = newNameProposal;
	}

	private String convert(String text) {
		StringBuilder result = new StringBuilder();
		String invalidChars;
		if (Platform.getOS().equals(Platform.OS_WIN32)) {
			invalidChars = "\\/:*?\"<>|"; //$NON-NLS-1$
		} else if (Platform.getOS().equals(Platform.OS_MACOSX)) {
			invalidChars = "/:"; //$NON-NLS-1$
		} else { // assume Unix/Linux
			invalidChars = "/"; //$NON-NLS-1$
		}

		for (char c : text.toCharArray()) {
			if (invalidChars.contains("" + c)) { //$NON-NLS-1$
				result.append("_"); //$NON-NLS-1$
			} else {
				result.append(c);
			}
		}
		result.append("." + file.getFileExtension()); //$NON-NLS-1$
		return result.toString();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		((GridLayout) composite.getLayout()).numColumns = 2;
		Label label = new Label(composite, SWT.LEFT);
		label.setText(Messages.RenameDialog_NewNameLabel);
		nameText = new Text(composite, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		nameText.setLayoutData(data);
		Label fName = new Label(composite, SWT.LEFT);
		fName.setText(Messages.RenameDialog_FileNameLabel);
		fileName = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		fileName.setEnabled(false);
		GridDataFactory.fillDefaults().applyTo(fileName);

		if (newNameProposal != null) {
			int index = 0;
			do {
				String pt = (index == 0) ? "" : "(" + Integer.valueOf(index) //$NON-NLS-1$ //$NON-NLS-2$
						+ ")"; //$NON-NLS-1$
				nameText.setText(newNameProposal + " " + oldName + pt); //$NON-NLS-1$
				fileName.setText(convert(nameText.getText()));
				index++;
			} while (!isValid());
		} else {
			nameText.setText(oldName);
		}
		fileName.setText(convert(nameText.getText()));
		nameText.selectAll();
		nameText.forceFocus();
		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				fileName.setText(convert(nameText.getText()));
				validate();
			}

		});
		return composite;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);
		validate();
		return result;
	}

	private void validate() {
		getButton(IDialogConstants.OK_ID).setEnabled(isValid());
	}

	private boolean isValid() {
		String text = nameText.getText();
		if (text == null || text.length() == 0)
			return false;

		// Check for file with same name already exist
		if (scenarious.contains(text)) {
			return false;
		}
		IPath newFileName = file.getFullPath().removeLastSegments(1)
				.append(fileName.getText());
		if (this.fileSkip != null && this.fileSkip.contains(newFileName)) {
			return false;
		}
		if (file.getParent().getFile(new Path(fileName.getText())).exists()) {
			return false;
		}
		return !text.equals(oldName);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(dialogName);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(400, 180);
	}

	@Override
	protected void okPressed() {
		resultName = nameText.getText();
		resultFileName = fileName.getText();
		super.okPressed();
	}

	public String getResultName() {
		return resultName;
	}

	public String getResultFileName() {
		return resultFileName;
	}

	public IPath getNewFileName() {
		return file.getFullPath().removeLastSegments(1).append(resultFileName);
	}

}
