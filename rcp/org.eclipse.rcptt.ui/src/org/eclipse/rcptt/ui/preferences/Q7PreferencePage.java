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

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.rcptt.core.Q7;
import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.launching.Q7Launcher;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.utils.AbstractFeatureManager;
import org.eclipse.rcptt.tesla.core.utils.AbstractFeatureManager.Option;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
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
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.ExpandableComposite;

public class Q7PreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Text textLaunchTimeout;
	private Text textCommandsDelay;
	private FeaturesComposite features = new FeaturesComposite();

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		textLaunchTimeout = createText(composite,
				Messages.Q7PreferencePage_LaunchTimeoutLabel,
				Integer.toString(Q7Launcher.getLaunchTimeout()));
		textCommandsDelay = createText(composite,
				Messages.Q7PreferencePage_CommandDelayLabel,
				Integer.toString(Q7.INSTANCE.getCommandsExecutionDelay()));

		// Advanced configuration
		ExpandableComposite advancedExpander = new ExpandableComposite(parent, SWT.NONE,
				ExpandableComposite.TWISTIE);
		advancedExpander.setText(Messages.Q7PreferencePage_AdvancedSectionLabel);
		advancedExpander.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Composite advancedComposite = new Composite(advancedExpander, SWT.NONE);

		advancedComposite.setLayout(new GridLayout(1, false));
		advancedExpander.setClient(advancedComposite);

		Link runnerArg = new Link(advancedComposite, SWT.NONE);
		runnerArg.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, true, false, 2, 1));
		runnerArg.setText(Messages.Q7PreferencePage_AdvancedRunnerArgLink);
		runnerArg.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new MessageDialog(getShell(), "-testOptions arg for RCPTT Runner",
						null, buildTestOptionsLine(), MessageDialog.INFORMATION,
						new String[] { "Copy to Clipboard", "Close" }, 1) {
					protected void buttonPressed(int buttonId) {
						switch (buttonId) {
						case 0:
							Clipboard cb = new Clipboard(getShell().getDisplay());
							cb.setContents(new Object[] { message },
									new Transfer[] { TextTransfer.getInstance() });
							cb.dispose();
							break;
						default:
							super.buttonPressed(buttonId);
						}
					};
				}.open();
			}
		});

		final Control control = features.createOptions(advancedComposite, TeslaFeatures.ADV_OPTIONS, false, null);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
		advancedExpander.addExpansionListener(new IExpansionListener() {
			public void expansionStateChanging(ExpansionEvent e) {
			}

			public void expansionStateChanged(ExpansionEvent e) {
				if (e.getState()) {
					control.setFocus();
				}
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

		features.apply();

		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		textLaunchTimeout.setText(Integer
				.toString(Q7Launcher.DEFAULT_LAUNCH_TIMEOUT));
		textCommandsDelay.setText(Integer
				.toString(Q7.DEFAULT_COMMANDS_EXECUTION_DELAY));

		features.setDefaults();

		super.performDefaults();
	}

	public void init(IWorkbench workbench) {
	}

	/**
	 * "Runner arg" methods.
	 */

	private static final List<String> DISABLED_OPTIONS = Arrays
			.asList(TeslaFeatures.PROTOCOL_VERSION);

	private static final String[] TRIM_PREFIXES = new String[] { "ui",
			"org.eclipse.rcptt.tesla.protocol.", "org.eclipse.rcptt.tesla.", "com.xored." };

	private String buildTestOptionsLine() {
		AbstractFeatureManager[] managers = new AbstractFeatureManager[] {
				TeslaFeatures.getInstance(), Q7Features.getInstance() };

		Map<String, Option> nonDefaultOptions = new LinkedHashMap<String, Option>();
		for (AbstractFeatureManager manager : managers) {
			for (String optionKey : manager.getOptionNames()) {
				if (DISABLED_OPTIONS.contains(optionKey)) {
					continue;
				}
				Option option = manager.getOption(optionKey);
				if ((option.getValue() == null && option.getDefaultValue() != null)
						|| !option.getValue().equals(option.getDefaultValue())) {
					nonDefaultOptions.put(optionKey, option);
				}
			}
		}

		if (nonDefaultOptions.size() == 0) {
			return "All options are set to defaults, no need to specify -testOptions arg";
		}

		StringBuilder result = new StringBuilder();
		result.append("-testOptions ");

		for (Entry<String, Option> option : nonDefaultOptions.entrySet()) {
			result.append(String.format("%s=%s;", optionNameToArgName(option
					.getKey()), option.getValue().getValue()));
		}
		result.setLength(result.length() - 1); // trim last semicolon
		return result.toString();
	}

	private static final String optionNameToArgName(String optionName) {
		StringBuilder result = new StringBuilder();
		for (String prefix : TRIM_PREFIXES) {
			if (optionName.startsWith(prefix)) {
				optionName = optionName.substring(prefix.length());
				break;
			}
		}
		String[] parts = optionName.split("\\.");

		boolean isFirst = true;
		for (String part : parts) {
			if (part.length() == 0) {
				continue;
			}

			if (isFirst) {
				isFirst = false;
				result.append(part);
			} else {
				result.append(Character.toUpperCase(part.charAt(0)));
				result.append(part.substring(1));
			}
		}

		return result.toString();
	}

}
