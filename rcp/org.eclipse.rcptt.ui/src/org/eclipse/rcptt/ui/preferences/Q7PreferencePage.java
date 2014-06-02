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
package org.eclipse.rcptt.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import org.eclipse.rcptt.core.Q7;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.launching.Q7Launcher;

public class Q7PreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Text textLaunchTimeout;
	private Text textCommandsDelay;
	private Link advancedConfiguration;

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		textLaunchTimeout = createText(composite,
				Messages.Q7PreferencePage_LaunchTimeoutLabel,
				Integer.toString(Q7Launcher.getLaunchTimeout()));
		textCommandsDelay = createText(composite,
				Messages.Q7PreferencePage_CommandDelayLabel,
				Integer.toString(Q7.INSTANCE.getCommandsExecutionDelay()));

		advancedConfiguration = new Link(composite, SWT.NONE);
		advancedConfiguration.setLayoutData(new GridData(SWT.RIGHT,
				SWT.DEFAULT, true, false, 2, 1));
		advancedConfiguration
				.setText(Messages.Q7PreferencePage_AdvancedLinkText);
		advancedConfiguration.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FeaturesConfigurationDialog dialog = new FeaturesConfigurationDialog(
						advancedConfiguration.getShell());
				dialog.open();
			}
		});

		return null;
	}

	private void validate() {
		String message = doValidate();
		setErrorMessage(message);
		setValid(message == null);
	}

	private String doValidate() {
		if (!isPositiveInteger(textLaunchTimeout.getText())) {
			return Messages.Q7PreferencePage_IncorrectLaunchTimeoutMsg;
		}
		if (!isPositiveInteger(textCommandsDelay.getText())) {
			return Messages.Q7PreferencePage_IncorrectCommandDelayMsg;
		}
		return null;
	}

	private boolean isPositiveInteger(String value) {
		try {
			if (Integer.parseInt(value) >= 0) {
				return true;
			}
		} catch (Exception e) {
			// ignore
		}
		return false;
	}

	private Text createText(Composite parent, String labelText,
			String initialValue) {
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

	@Override
	public boolean performOk() {
		Q7Launcher.setLaunchTimeout(Integer.parseInt(textLaunchTimeout
				.getText()));
		Q7.INSTANCE.setCommandsExecutionDelay(Integer
				.parseInt(textCommandsDelay.getText()));
		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		textLaunchTimeout.setText(Integer
				.toString(Q7Launcher.DEFAULT_LAUNCH_TIMEOUT));
		textCommandsDelay.setText(Integer
				.toString(Q7.DEFAULT_COMMANDS_EXECUTION_DELAY));
		super.performDefaults();
	}

	public void init(IWorkbench workbench) {
	}

}
