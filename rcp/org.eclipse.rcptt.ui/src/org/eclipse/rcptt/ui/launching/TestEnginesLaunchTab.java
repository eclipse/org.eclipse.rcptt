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
package org.eclipse.rcptt.ui.launching;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.internal.launching.TestEngineManager;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.TestEngineLaunchConfigManager;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;

import com.ibm.icu.text.MessageFormat;

public class TestEnginesLaunchTab extends AbstractLaunchConfigurationTab {

	private static final String TAB_ID = "org.eclipse.rcptt.ui.launching.TestEnginesTab";

	private Map<String, Button> testEngineButtons;

	private List<TestEngineManager.TestEngineExtension> testEngines;
	private List<TestEngineLaunchConfigManager.TestEngineLaunchConfig> launchConfigs;

	public TestEnginesLaunchTab() {
		this.testEngines = TestEngineManager.getInstance()
				.getEngines();
		this.launchConfigs = TestEngineLaunchConfigManager.getInstance()
				.getLaunchConfigs();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, true));
		setControl(composite);
		
		Listener listener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				updateLaunchConfigurationDialog();
			}

		};

		this.testEngineButtons = new HashMap<String, Button>();
		for (TestEngineManager.TestEngineExtension engine : testEngines) {
			String id = engine.getId();
			String name = engine.getName();

			Group group = new Group(composite, SWT.NONE);
			group.setLayout(new GridLayout(2, false));
			group.setText(name);
			group.setFont(parent.getFont());
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			group.setLayoutData(gd);

			Button engineButton = new Button(group, SWT.CHECK);
			engineButton.setText(MessageFormat.format(Messages.TestEnginesLaunchTab_EngineButtonName, name));

			engineButton.addListener(SWT.Selection, listener);
			this.testEngineButtons.put(id, engineButton);

			ITestEngineLaunchConfig launchConfig = getLaunchConfig(id);
			if (launchConfig != null) {
				launchConfig.createControl(group, listener);
			}
		}
	}

	private ITestEngineLaunchConfig getLaunchConfig(String id) {
		for (TestEngineLaunchConfigManager.TestEngineLaunchConfig config : launchConfigs) {
			if (id.equals(config.getId())) {
				return config.getConfig();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
	 * debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		for (TestEngineLaunchConfigManager.TestEngineLaunchConfig config : launchConfigs) {
			config.getConfig().setDefaults(configuration);
		}
		configuration.setAttribute(IQ7Launch.ATTR_TEST_ENGINES, new HashMap<String, String>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		for (TestEngineLaunchConfigManager.TestEngineLaunchConfig config : launchConfigs) {
			config.getConfig().initializeFrom(configuration);
		}
		Map<String, String> testEngines = Collections.emptyMap();
		try {
			testEngines = configuration.getAttribute(IQ7Launch.ATTR_TEST_ENGINES, testEngines);
		} catch (CoreException e) {
			Q7LaunchingPlugin.log(e);
		}
		setTestEnginesStatuses(testEngines);
	}

	private void setTestEnginesStatuses(Map<String, String> statuses) {
		for (Map.Entry<String, Button> button : testEngineButtons.entrySet()) {
			String id = button.getKey();
			String enabled = statuses.get(id);
			button.getValue().setSelection(enabled != null && enabled.equals("true"));
		}
	}

	private Map<String, String> getTestEnginesStatuses() {
		Map<String, String> testEngines = new HashMap<String, String>();
		for (Map.Entry<String, Button> button : testEngineButtons.entrySet()) {
			String id = button.getKey();
			String enabled = String.valueOf(button.getValue().getSelection());
			testEngines.put(id, enabled);
		}
		return testEngines;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
	 * .debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		for (TestEngineLaunchConfigManager.TestEngineLaunchConfig config : launchConfigs) {
			config.getConfig().performApply(configuration);
		}
		Map<String, String> testEngines = getTestEnginesStatuses();
		configuration.setAttribute(IQ7Launch.ATTR_TEST_ENGINES, testEngines);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration configuration) {
		String message = validatePage();
		setMessage(null);
		setErrorMessage(message);
		validatePage();
		return getErrorMessage() == null;
	}

	private String validatePage() {
		for (TestEngineLaunchConfigManager.TestEngineLaunchConfig config : launchConfigs) {
			return config.getConfig().validatePage();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	@Override
	public String getName() {
		return Messages.TestEnginesLaunchTab_Name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getId()
	 */
	@Override
	public String getId() {
		return TAB_ID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return Images.getImage(Images.GEARS);
	}

}
