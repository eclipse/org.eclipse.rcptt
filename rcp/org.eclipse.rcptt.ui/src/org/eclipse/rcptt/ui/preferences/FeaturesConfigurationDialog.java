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

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.utils.AbstractFeatureManager;
import org.eclipse.rcptt.tesla.core.utils.AbstractFeatureManager.Option;

public class FeaturesConfigurationDialog extends Dialog {
	private FeaturesComposite features = new FeaturesComposite();

	protected FeaturesConfigurationDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.FeaturesConfigurationDialog_0);
		newShell.setImage(Images.getImageDescriptor(Images.CONFIG)
				.createImage());
	}

	@Override
	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite content = (Composite) super.createDialogArea(parent);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		// data.widthHint = 600;
		// data.heightHint = 300;
		content.setLayoutData(data);
		content.setLayout(new GridLayout(1, false));
		features.createOptions(content, TeslaFeatures.ADV_OPTIONS, false, null);
		return content;
	}

	private static final int RUNNER_OPTIONS_ID = IDialogConstants.CLIENT_ID + 1;

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, RUNNER_OPTIONS_ID, "Runner arg", false);
		super.createButtonsForButtonBar(parent);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		switch (buttonId) {
		case RUNNER_OPTIONS_ID:
			features.apply();
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

			break;
		default:
			super.buttonPressed(buttonId);
		}
	}

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

	@Override
	protected void okPressed() {
		features.apply();
		super.okPressed();
	}
}
