/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.zephyr.ui.preferences;

import java.net.URL;
import java.text.MessageFormat;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.rcptt.internal.zephyr.ZephyrPlugin;
import org.eclipse.rcptt.zephyr.ZephyrService;
import org.eclipse.rcptt.zephyr.internal.ui.Messages;
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

public final class ZephyrPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private Button zephyrCheckBox;
	private Text zephyrAddress;
	private Text zephyrUsername;
	private Text zephyrPassword;
	private Button testConnectionButton;

	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	public boolean performOk() {
		if (zephyrCheckBox.getSelection())
			ZephyrPlugin.setZephyrEnabled(true);
		else
			ZephyrPlugin.setZephyrEnabled(false);

		ZephyrPlugin.setZephyrAddress(zephyrAddress.getText());
		ZephyrPlugin.setZephyrUsername(zephyrUsername.getText());
		ZephyrPlugin.setZephyrPassword(zephyrPassword.getText());

		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		final boolean state = ZephyrPlugin.DEFAULT_ZEPHYR_ENABLED;
		zephyrCheckBox.setSelection(ZephyrPlugin.DEFAULT_ZEPHYR_ENABLED);
		zephyrAddress.setText("");
		zephyrUsername.setText("");
		zephyrPassword.setText("");
		testConnectionButton.setEnabled(state);
		super.performDefaults();
	}

	@Override
	protected Control createContents(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		zephyrCheckBox = createCheckBoxButton(composite, Messages.ZephyrPreferencePage_EnableIntegration,
				ZephyrPlugin.getZephyrEnabled());
		zephyrAddress = createText(composite, Messages.ZephyrPreferencePage_Address,
				ZephyrPlugin.getZephyrAddress());
		zephyrUsername = createText(composite, Messages.ZephyrPreferencePage_Username,
				ZephyrPlugin.getZephyrUsername());
		zephyrPassword = createText(composite, Messages.ZephyrPreferencePage_Password,
				ZephyrPlugin.getZephyrPassword());
		zephyrPassword.setEchoChar('*');


		testConnectionButton = createButton(composite, Messages.ZephyrPreferencePage_TestConnection);
		final boolean state = ZephyrPlugin.getZephyrEnabled();
		testConnectionButton.setEnabled(state && isValid());

		return null;
	}

	private Text createText(Composite parent, String labelText, String initialValue) {
		final Label label = new Label(parent, SWT.LEFT);
		label.setText(labelText);
		final Text text = new Text(parent, SWT.BORDER);
		text.setText(initialValue);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				validate();

				final boolean state = zephyrCheckBox.getSelection();
				testConnectionButton.setEnabled(state && isValid());
			}
		});

		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return text;
	}

	private Button createCheckBoxButton(Composite parent, String labelText, boolean state) {
		final Label label = new Label(parent, SWT.LEFT);
		label.setText(labelText);
		final Button button = new Button(parent, SWT.CHECK);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				validate();

				final boolean state = zephyrCheckBox.getSelection();
				testConnectionButton.setEnabled(state && isValid());
			}
		});

		button.setSelection(state);
		return button;
	}

	private Button createButton(Composite parent, String labelText) {
		final Button button = new Button(parent, SWT.PUSH);
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
		final String message = doValidate();
		setMessage(null);
		setErrorMessage(message);
		setValid(message == null);
	}

	private String doValidate() {
		if (!zephyrCheckBox.getSelection()) {
			return null;
		}
		if (!isValidURL(zephyrAddress.getText())) {
			return Messages.ZephyrPreferencePage_IncorrectAddressMsg;
		}
		if (zephyrUsername.getText() == null || zephyrUsername.getText().equals("")) {
			return MessageFormat.format(Messages.ZephyrPreferencePage_FieldNotSpecifiedMsg,
					Messages.ZephyrPreferencePage_Username);
		}
		if (zephyrPassword.getText() == null || zephyrPassword.getText().equals("")) {
			return MessageFormat.format(Messages.ZephyrPreferencePage_FieldNotSpecifiedMsg,
					Messages.ZephyrPreferencePage_Password);
		}
		return null;
	}

	private boolean isValidURL(String urlString) {
		try {
			final URL url = new URL(urlString);
			return !url.getHost().equals("");
		} catch (Exception e) {
			ZephyrPlugin.log(e);
		}
		return false;
	}

	private void testConnection() {
		BusyIndicator.showWhile(Display.getDefault(), new Runnable() {
			public void run() {

				final String address = zephyrAddress.getText();
				final String username = zephyrUsername.getText();
				final String password = zephyrPassword.getText();

				final ZephyrService service = new ZephyrService();
				final IStatus result = service.doTestConnection(address, username, password);

				if (result.isOK()) {
					setMessage(result.getMessage(), INFORMATION);
					setErrorMessage(null);
				} else {
					setMessage(null);
					setErrorMessage(result.getMessage());
				}

			}
		});
	}
}
