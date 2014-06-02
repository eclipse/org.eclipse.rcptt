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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import org.eclipse.rcptt.ui.editors.ecl.ECLEditorPlugin;

public class ECLPreferenceContentAssistPage extends PreferencePage implements IWorkbenchPreferencePage {

	private Button autoActivationCheckBox;
	private Text autoActivationTriggersForECLScript;
	private Text autoActivationDelayInMS;

	public boolean performCancel() {
		return false;
	}

	@Override
	public boolean performOk() {
		if (autoActivationCheckBox.getSelection())
			ECLEditorPlugin.setECLScriptContentAssistActivationState(1);
		else
			ECLEditorPlugin.setECLScriptContentAssistActivationState(0);

		ECLEditorPlugin.setECLScriptContentAssistDelay(Integer.parseInt(autoActivationDelayInMS.getText()));
		ECLEditorPlugin.setECLScriptContentAssistTriggers(autoActivationTriggersForECLScript.getText());
		return super.performOk();
	}

	public void init(IWorkbench workbench) {
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

	private String doValidate() {
		if (!isPositiveInteger(autoActivationDelayInMS.getText())) {
			return "Autoactivation delay should be positive number";
		}

		return null;
	}

	private void validate() {
		String message = doValidate();
		setErrorMessage(message);
		setValid(message == null);
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

	private Button createCheckBoxButton(Composite parent, String labelText, boolean state) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(labelText);
		Button button = new Button(parent, SWT.CHECK);

		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean state = autoActivationCheckBox.getSelection();
				autoActivationDelayInMS.setEnabled(state);
				autoActivationTriggersForECLScript.setEnabled(state);
			}
		});

		button.setSelection(state);
		return button;
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		autoActivationCheckBox = createCheckBoxButton(composite, "Enable Auto Activation",
				ECLEditorPlugin.getECLScriptContentAssistActivationState());
		autoActivationDelayInMS = createText(composite, "Auto Activation Delay (ms)",
				Integer.toString(ECLEditorPlugin.getECLScriptContentAssistDelay()));
		autoActivationTriggersForECLScript = createText(composite, "Auto Activation Triggers for ECL Script",
				ECLEditorPlugin.getECLScriptContentAssistTriggers());

		autoActivationDelayInMS.setEnabled(ECLEditorPlugin.getECLScriptContentAssistActivationState());
		autoActivationTriggersForECLScript.setEnabled(ECLEditorPlugin.getECLScriptContentAssistActivationState());

		return null;
	}

	@SuppressWarnings("unused")
	@Override
	protected void performDefaults() {
		if (ECLEditorPlugin.DEFAULT_ECL_CONTENT_ASSIST_ACTIVATION_STATE == 0)
			autoActivationCheckBox.setSelection(false);
		else
			autoActivationCheckBox.setSelection(true);

		autoActivationDelayInMS.setText(Integer.toString(ECLEditorPlugin.DEFAULT_ECL_CONTENT_ASSIST_DELAY));
		autoActivationTriggersForECLScript.setText(ECLEditorPlugin.DEFAULT_ECL_CONTENT_ASSIST_TRIGGERS);

		autoActivationDelayInMS.setEnabled(ECLEditorPlugin.getECLScriptContentAssistActivationState());
		autoActivationTriggersForECLScript.setEnabled(ECLEditorPlugin.getECLScriptContentAssistActivationState());
		super.performDefaults();
	}

}
