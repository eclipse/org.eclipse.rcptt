/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2019 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v2.0
 *  * which accompanies this distribution, and is available at
 *  * https://www.eclipse.org/legal/epl-v20.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.internal.launching.rap.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.internal.ui.PDEUIMessages;
import org.eclipse.pde.internal.ui.launcher.BaseBlock;
import org.eclipse.pde.ui.launcher.AbstractLauncherTab;
import org.eclipse.rcptt.launching.rap.RAPLaunchConfig;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

@SuppressWarnings("restriction")
public class DataLocationBlock extends BaseBlock {

	private Button useDefaultLocationButton;
	private Button clearInstanceAreaButton;
	private String instanceName;

	public DataLocationBlock(AbstractLauncherTab launcherTab) {
		super(launcherTab);
	}

	public Control createControl(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText("Instance Area");
		group.setLayout(new GridLayout(2, false));
		useDefaultLocationButton = createDefaultLocationButton(group);
		useDefaultLocationButton.setLayoutData(createHFillGridDataWithHSpan(2));
		createText(group, PDEUIMessages.ConfigurationTab_configLog, 20);
		Control buttonArea = createButtonArea(group);
		buttonArea.setLayoutData(createHFillGridDataWithHSpan(2));
		return group;
	}

	public void initializeFrom(RAPLaunchConfig rapConfig)
			throws CoreException {
		instanceName = rapConfig.getName();
		boolean useDefaultDataLocation = rapConfig.getUseDefaultDatatLocation();
		useDefaultLocationButton.setSelection(useDefaultDataLocation);
		enableBrowseSection(!useDefaultDataLocation);
		fLocationText.setEditable(!useDefaultDataLocation);
		fLocationText.setEnabled(!useDefaultDataLocation);
		boolean doClear = rapConfig.getDoClearDataLocation();
		clearInstanceAreaButton.setSelection(doClear);
		String defaultLocation = RAPLaunchConfig.getDefaultDataLocation(instanceName);
		String dataLocation = rapConfig.getDataLocation();
		if (useDefaultDataLocation) {
			fLocationText.setText(defaultLocation);
		} else {
			fLocationText.setText(dataLocation);
		}
	}

	public boolean getUseDefaultDataLocation() {
		return useDefaultLocationButton.getSelection();
	}

	public boolean getDoClearDataLocation() {
		return clearInstanceAreaButton.getSelection();
	}

	@Override
	public String getLocation() {
		return super.getLocation();
	}

	@Override
	protected String getName() {
		return "instanceAreaBlock"; //$NON-NLS-1$
	}

	@Override
	protected boolean isFile() {
		return false;
	}

	private Button createDefaultLocationButton(Composite parent) {
		final Button button = new Button(parent, SWT.CHECK);
		button.setText(PDEUIMessages.ConfigurationTab_useDefaultLoc);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				updateUseDefaultLocation(button.getSelection());
			}
		});
		return button;
	}

	private void updateUseDefaultLocation(boolean useDefaultLocation) {
		if (useDefaultLocation) {
			String defaultLocation = RAPLaunchConfig.getDefaultDataLocation(instanceName);
			fLocationText.setText(defaultLocation);
		}
		enableBrowseSection(!useDefaultLocation);
		fLocationText.setEditable(!useDefaultLocation);
		fLocationText.setEnabled(!useDefaultLocation);
	}

	private Control createButtonArea(Composite parent) {
		Composite buttonsArea = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(4, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		buttonsArea.setLayout(layout);
		createInstanceAreaButton(buttonsArea);
		createButtons(buttonsArea, new String[] {
				PDEUIMessages.BaseBlock_workspace,
				PDEUIMessages.BaseBlock_filesystem,
				PDEUIMessages.BaseBlock_variables
		});
		return buttonsArea;
	}

	private void createInstanceAreaButton(Composite parent) {
		clearInstanceAreaButton = new Button(parent, SWT.CHECK);
		clearInstanceAreaButton.setText("Cle&ar the instance area before launching");
		GridData layoutData = createHFillGridDataWithHSpan(1);
		clearInstanceAreaButton.setLayoutData(layoutData);
		clearInstanceAreaButton.addSelectionListener(fListener);
	}

	private static GridData createHFillGridDataWithHSpan(int horizontalSpan) {
		GridData result = new GridData(SWT.FILL, SWT.CENTER, true, false);
		result.horizontalSpan = horizontalSpan;
		return result;
	}
}