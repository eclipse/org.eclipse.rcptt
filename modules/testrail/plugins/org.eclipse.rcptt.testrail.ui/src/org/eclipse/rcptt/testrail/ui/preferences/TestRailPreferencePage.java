/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.testrail.ui.preferences;

import java.net.URL;
import java.text.MessageFormat;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.rcptt.internal.testrail.TestRailAPIClient;
import org.eclipse.rcptt.internal.testrail.TestRailPlugin;
import org.eclipse.rcptt.testrail.internal.ui.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.forms.widgets.Section;

public class TestRailPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private Button testRailCheckBox;
	private Text testRailAddress;
	private Text testRailUsername;
	private Text testRailPassword;
	private Text testRailProjectId;
	private Button testConnectionButton;
	private Button useUnicodeButton;

	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	public boolean performOk() {
		if (testRailCheckBox.getSelection())
			TestRailPlugin.setTestRailState(1);
		else
			TestRailPlugin.setTestRailState(0);

		TestRailPlugin.setTestRailAddress(testRailAddress.getText());
		TestRailPlugin.setTestRailUsername(testRailUsername.getText());
		TestRailPlugin.setTestRailPassword(testRailPassword.getText());
		TestRailPlugin.setTestRailProjectId(testRailProjectId.getText());

		if (useUnicodeButton.getSelection())
			TestRailPlugin.setTestRailUseUnicode(1);
		else
			TestRailPlugin.setTestRailUseUnicode(0);

		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		boolean state = TestRailPlugin.DEFAULT_TESTRAIL_STATE == 1;
		testRailCheckBox.setSelection(state);
		testRailAddress.setText("");
		testRailUsername.setText("");
		testRailPassword.setText("");
		testRailProjectId.setText(TestRailPlugin.DEFAULT_TESTRAIL_PROJECTID);
		testConnectionButton.setEnabled(state && isValid());
		useUnicodeButton.setSelection(TestRailPlugin.DEFAULT_TESTRAIL_USEUNICODE == 1);
		super.performDefaults();
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		testRailCheckBox = createCheckBoxButton(composite, Messages.TestRailPreferencePage_EnableIntegration,
				TestRailPlugin.getTestRailState());
		testRailAddress = createText(composite, Messages.TestRailPreferencePage_Address,
				TestRailPlugin.getTestRailAddress());
		testRailUsername = createText(composite, Messages.TestRailPreferencePage_Username,
				TestRailPlugin.getTestRailUsername());
		testRailPassword = createText(composite, Messages.TestRailPreferencePage_Password,
				TestRailPlugin.getTestRailPassword());
		testRailPassword.setEchoChar('*');
		testRailProjectId = createText(composite, Messages.TestRailPreferencePage_ProjectId,
				TestRailPlugin.getTestRailProjectId());

		testConnectionButton = createButton(composite, Messages.TestRailPreferencePage_TestConnection);
		boolean state = TestRailPlugin.getTestRailState();
		testConnectionButton.setEnabled(state && isValid());

		// Advanced configuration
		Section advancedExpander = new Section(composite, Section.TWISTIE);
		advancedExpander.setText(Messages.TestRailPreferencePage_AdvancedSectionLabel);
		advancedExpander.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		Composite advancedComposite = new Composite(advancedExpander, SWT.NONE);
		advancedComposite.setLayout(new GridLayout(1, false));
		advancedExpander.setClient(advancedComposite);

		useUnicodeButton = new Button(advancedComposite, SWT.CHECK);
		useUnicodeButton.setText(Messages.TestRailPreferencePage_UseUnicode);
		useUnicodeButton.setSelection(TestRailPlugin.getTestRailUseUnicode());

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

				boolean state = testRailCheckBox.getSelection();
				testConnectionButton.setEnabled(state && isValid());
			}
		});

		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return text;
	}

	private Button createCheckBoxButton(Composite parent, String labelText, boolean state) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(labelText);
		Button button = new Button(parent, SWT.CHECK);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				validate();

				boolean state = testRailCheckBox.getSelection();
				testConnectionButton.setEnabled(state && isValid());
			}
		});

		button.setSelection(state);
		return button;
	}

	private Button createButton(Composite parent, String labelText) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(labelText);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				testConnection();
			}
		});

		return button;
	}

	private void validate() {
		String message = doValidate();
		setMessage(null);
		setErrorMessage(message);
		setValid(message == null);
	}

	private String doValidate() {
		if (!testRailCheckBox.getSelection()) {
			return null;
		}
		if (!isValidURL(testRailAddress.getText())) {
			return Messages.TestRailPreferencePage_IncorrectAddressMsg;
		}
		if (!testRailAddress.getText().endsWith("/")) {
			return Messages.TestRailPreferencePage_AddressEndsWithSlashMsg;
		}
		if (testRailUsername.getText() == null || testRailUsername.getText().equals("")) {
			return MessageFormat.format(Messages.TestRailPreferencePage_FieldNotSpecifiedMsg,
					Messages.TestRailPreferencePage_Username);
		}
		if (testRailPassword.getText() == null || testRailPassword.getText().equals("")) {
			return MessageFormat.format(Messages.TestRailPreferencePage_FieldNotSpecifiedMsg,
					Messages.TestRailPreferencePage_Password);
		}
		if (!isValidId(testRailProjectId.getText())) {
			return Messages.TestRailPreferencePage_IncorrectProjectIdMsg;
		}
		return null;
	}

	private boolean isValidURL(String urlString) {
		try {
			URL url = new URL(urlString);
			return !url.getHost().equals("");
		} catch (Exception e) {
			// ignore
		}
		return false;
	}

	private boolean isValidId(String idString) {
		if (!idString.startsWith("P")) {
			return false;
		}
		try {
			idString = idString.substring(1); // remove "P"
			int parsedValue = Integer.parseInt(idString);
			if (parsedValue > 0) {
				return true;
			}
		} catch (Exception e) {
			// ignore
		}
		return false;
	}

	private void testConnection() {
		BusyIndicator.showWhile(Display.getDefault(), new Runnable() {
			public void run() {
				String address = testRailAddress.getText();
				String username = testRailUsername.getText();
				String password = testRailPassword.getText();
				String projectId = testRailProjectId.getText();

				TestRailAPIClient client = new TestRailAPIClient(address, username, password, projectId);
				boolean isAvailable = client.isAvailable();
				if (!isAvailable) {
					setMessage(null);
					setErrorMessage(Messages.TestRailPreferencePage_FailedToConnectMsg);
				} else {
					setErrorMessage(null);
					setMessage(Messages.TestRailPreferencePage_SuccessfullyConnectedMsg, INFORMATION);
				}
			}
		});
	}
}
