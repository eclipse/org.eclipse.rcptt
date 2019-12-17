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
package org.eclipse.rcptt.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ECLPreferenceEditorPage extends PreferencePage implements IWorkbenchPreferencePage {

	private Text textMaxLineWidth;
	private Text textIndent;

	@Override
	public boolean performOk() {
		CorePlugin.setECLEditorLineWidth(Integer.parseInt(textMaxLineWidth.getText()));
		CorePlugin.setECLEditorIndent(Integer.parseInt(textIndent.getText()));

		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		textMaxLineWidth.setText(Integer.toString(CorePlugin.ECL_EDITOR_LINE_WIDTH_DEFAULT));
		textIndent.setText(Integer.toString(CorePlugin.ECL_EDITOR_INDENT_DEFAULT));

		super.performDefaults();
	}

	public void init(IWorkbench workbench) {
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		textMaxLineWidth = createText(composite, Messages.ECLPreferenceEditorPage_MaximumLineWidth,
				Integer.toString(CorePlugin.getECLEditorLineWidth()));

		textIndent = createText(composite, Messages.ECLPreferenceEditorPage_Indent,
				Integer.toString(CorePlugin.getECLEditorIndent()));

		return null;
	}

	private Text createText(Composite parent, String labelText, String initialValue) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(labelText);
		Text text = new Text(parent, SWT.BORDER);
		text.setText(initialValue);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				validate();
			}
		});

		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return text;
	}

	private void validate() {
		String message = doValidate();
		setErrorMessage(message);
		setValid(message == null);
	}

	private String doValidate() {
		if (!isValidInteger(textMaxLineWidth.getText(), 0, 9999)) {
			return Messages.ECLPreferenceEditorPage_MaximumLineWidth + " should be positive number between 0 and 9999";
		}

		if (!isValidInteger(textIndent.getText(), 0, 32)) {
			return Messages.ECLPreferenceEditorPage_Indent + " should be positive number between 0 and 32";
		}

		return null;
	}

	private boolean isValidInteger(String value, int min, int max) {
		try {
			int parsedValue = Integer.parseInt(value);
			if (parsedValue >= min && parsedValue <= max) {
				return true;
			}
		} catch (Exception e) {
			// ignore
		}
		return false;
	}

}
