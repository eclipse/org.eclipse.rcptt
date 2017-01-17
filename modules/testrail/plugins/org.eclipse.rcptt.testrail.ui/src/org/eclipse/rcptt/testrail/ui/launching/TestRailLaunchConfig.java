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
package org.eclipse.rcptt.testrail.ui.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.rcptt.internal.testrail.TestRailPlugin;
import org.eclipse.rcptt.testrail.internal.ui.Messages;
import org.eclipse.rcptt.ui.launching.ITestEngineLaunchConfig;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class TestRailLaunchConfig implements ITestEngineLaunchConfig {

	private Text testRunId;

	@Override
	public void createControl(Composite parent, Listener listener) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setFont(parent.getFont());
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		composite.setLayoutData(gd);

		testRunId = createText(composite, Messages.TestRailLaunchConfig_TestRunIdField);
		testRunId.addListener(SWT.Modify, listener);
	}

	private Text createText(Composite parent, String labelText) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(labelText);
		Text text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return text;
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		testRunId.setText("");
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			testRunId.setText(configuration.getAttribute(TestRailPlugin.LAUNCH_TESTRUNID, ""));
		} catch (CoreException e) {
			TestRailPlugin.log(e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(TestRailPlugin.LAUNCH_TESTRUNID, testRunId.getText());
	}

	@Override
	public String validatePage() {
		if (!isValidId(testRunId.getText())) {
			return Messages.TestRailLaunchConfig_IncorrectTestRunIdMsg;
		}
		return null;
	}

	private boolean isValidId(String idString) {
		if (idString == null || idString.equals("")) {
			return true;
		}
		if (!idString.startsWith("R")) {
			return false;
		}
		try {
			idString = idString.substring(1); // remove "R"
			int parsedValue = Integer.parseInt(idString);
			if (parsedValue > 0) {
				return true;
			}
		} catch (Exception e) {
			// ignore
		}
		return false;
	}

}
