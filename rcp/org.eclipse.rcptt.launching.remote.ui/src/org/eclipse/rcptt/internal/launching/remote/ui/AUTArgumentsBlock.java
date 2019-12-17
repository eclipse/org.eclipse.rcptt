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
package org.eclipse.rcptt.internal.launching.remote.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.rcptt.launching.Q7LaunchUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public final class AUTArgumentsBlock {

	private RemoteAUTMainTab fTab;

	private Text eclPortField;
	private Text teslaPortField;

	private Text hostField;

	ModifyListener listener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent e) {
			// fT3ab.validateTab();
			fTab.updateLaunchConfigurationDialog();
		}
	};

	public AUTArgumentsBlock(RemoteAUTMainTab tab) {
		fTab = tab;
	}

	public void createControl(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		String locationLabel = "&Remote Application Under Test (AUT)";
		group.setText(locationLabel);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		group.setLayout(layout);
		group.setLayoutData(gridData);

		Label l = new Label(group, SWT.WRAP);
		l.setText("Host:");
		hostField = new Text(group, SWT.BORDER);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		hostField.setLayoutData(gridData);
		hostField.addModifyListener(listener);
		// hostField.setEnabled(false);

		l = new Label(group, SWT.WRAP);
		l.setText("ECL port:");
		eclPortField = new Text(group, SWT.BORDER);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		eclPortField.setLayoutData(gridData);
		eclPortField.addModifyListener(listener);

		l = new Label(group, SWT.WRAP);
		l.setText("Tesla port:");
		teslaPortField = new Text(group, SWT.BORDER);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		teslaPortField.setLayoutData(gridData);
		teslaPortField.addModifyListener(listener);

		VerifyListener verity = new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				for (char c : e.text.toCharArray()) {
					if (!Character.isDigit(c)) {
						e.doit = false;
					}
				}
			}
		};
		eclPortField.addVerifyListener(verity);
		teslaPortField.addVerifyListener(verity);
	}

	public String validate() {
		final String hostName[] = { null };
		final int port[] = { 0 };
		if (hostField != null && !hostField.isDisposed()) {
			hostField.getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					hostName[0] = getHostName();
					port[0] = getECLPort();
				}
			});
			if (hostName[0] == null || hostName[0].trim().length() == 0) {
				return "Please specify Remote AUT host...";
			}

			try {
				Q7LaunchUtils.verifyConnection(hostName[0], port[0]);
			} catch (CoreException e) {
				return "AUT connection is not available...";
			}
		}
		return null;
	}

	public void performApply(ILaunchConfigurationWorkingCopy config) {
		try {
			config.setAttribute(IQ7Launch.ATTR_HOST, hostField.getText());
			config.setAttribute(IQ7Launch.ATTR_TESLA_PORT,
					Integer.valueOf(teslaPortField.getText()));
		} catch (NumberFormatException e) {

		}
		config.setAttribute(IQ7Launch.ATTR_ECL_PORT, getECLPort());
	}

	private Integer getECLPort() {
		try {
			return Integer.valueOf(eclPortField.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private String getHostName() {
		return hostField.getText();
	}

	public void initializeFrom(final ILaunchConfiguration config) {
		eclPortField.setText(getValue(config, IQ7Launch.ATTR_ECL_PORT));
		teslaPortField.setText(getValue(config, IQ7Launch.ATTR_TESLA_PORT));
		try {
			hostField.setText(config.getAttribute(IQ7Launch.ATTR_HOST, ""));
		} catch (CoreException e) {
		}
	}

	private String getValue(final ILaunchConfiguration config, String attr) {
		String location = null;
		try {
			location = Integer.toString(config.getAttribute(attr, 0));
		} catch (CoreException e) {
			Activator.getDefault().log(e);
		}
		return location;
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(IQ7Launch.ATTR_TESLA_PORT,
				IQ7Launch.TESLA_DEFAULT_PORT);
		config.setAttribute(IQ7Launch.ATTR_ECL_PORT, IQ7Launch.ECL_DEFAULT_PORT);
		config.setAttribute(IQ7Launch.ATTR_HOST, IQ7Launch.DEFAULT_HOST);
	}
}
