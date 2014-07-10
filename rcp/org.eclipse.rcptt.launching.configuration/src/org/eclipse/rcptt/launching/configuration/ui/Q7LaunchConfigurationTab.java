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
package org.eclipse.rcptt.launching.configuration.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.internal.ui.launchConfigurations.LaunchConfigurationsDialog;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import org.eclipse.rcptt.launching.configuration.Activator;
import org.eclipse.rcptt.launching.configuration.LaunchConfigurationUtils;

@SuppressWarnings("restriction")
public class Q7LaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	private final static String TAB_NAME = "Main"; //$NON-NLS-1$
	private final static String SOURCE_CONF_GROUP_LABEL = "&Target Launch Configuration"; //$NON-NLS-1$
	private final static String SOURCE_CONF_LINK_LABEL = "<a>Target:</a>"; //$NON-NLS-1$
	private final static String SELECT_CONF_BUTTON_LABEL = "Select..."; //$NON-NLS-1$

	private final static String SELECT_DIALOG_TITLE = "Select Configuration"; //$NON-NLS-1$
	private final static String SELECT_DIALOG_MESSAGE = "Select existing launch configuration"; //$NON-NLS-1$	

	private final static String TARGET_LAUNCH_NOT_EXISTS_MESSAGE = "Target launch configuration does not exists"; //$NON-NLS-1$
	private final static String SELECT_LAUNCH_MESSAGE = "Select target launch configuration"; //$NON-NLS-1$	

	private final Image fImage;
	private Combo accountCombo;

	public Q7LaunchConfigurationTab() {
		super();
		fImage = Activator.getImageDescriptor("icons/main_tab.gif")
				.createImage();
	}

	private Text sourceConfField;

	public void createControl(Composite parent) {
		final ScrolledComposite scrollContainer = new ScrolledComposite(parent,
				SWT.V_SCROLL);
		scrollContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite composite = new Composite(scrollContainer, SWT.NONE);
		scrollContainer.setContent(composite);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		createSelectPDEConfControls(composite);

		// Add listener for each control to recalculate scroll bar when it is
		// entered.
		// This results in scrollbar scrolling when user tabs to a control that
		// is not in the field of view.
		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				Control child = (Control) e.widget;
				Rectangle bounds = child.getBounds();
				Rectangle area = scrollContainer.getClientArea();
				Point origin = scrollContainer.getOrigin();
				if (origin.x > bounds.x)
					origin.x = Math.max(0, bounds.x);
				if (origin.y > bounds.y)
					origin.y = Math.max(0, bounds.y);
				if (origin.x + area.width < bounds.x + bounds.width)
					origin.x = Math
							.max(0, bounds.x + bounds.width - area.width);
				if (origin.y + area.height < bounds.y + bounds.height)
					origin.y = Math.max(0, bounds.y + bounds.height
							- area.height);
				scrollContainer.setOrigin(origin);
			}
		};
		Control[] controls = composite.getChildren();
		for (int i = 0; i < controls.length; i++)
			controls[i].addListener(SWT.Activate, listener);

		Dialog.applyDialogFont(composite);
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrollContainer.setExpandHorizontal(true);
		setControl(scrollContainer);
	}

	ModifyListener modifyListener = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			scheduleUpdateJob();
		}
	};

	private void createSelectPDEConfControls(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(SOURCE_CONF_GROUP_LABEL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		group.setLayout(layout);
		group.setLayoutData(gridData);

		createSourceConfLink(group);
		createSourceConfText(group);
		createSelectConfButton(group);
	}

	private void selectAccount(String account) {
		if (accountCombo == null) {
			return;
		}

		if (accountCombo.indexOf(account) == -1) {
			accountCombo.deselectAll();
		} else {
			accountCombo.setText(account);
		}
	}

	private void createSourceConfLink(Composite parent) {
		Link sourceLink = new Link(parent, SWT.NONE);
		sourceLink.setText(SOURCE_CONF_LINK_LABEL);

		sourceLink.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String sourceConfName = getTargetConfName();
				if (sourceConfName.length() > 0) {
					ILaunchConfiguration config = LaunchConfigurationUtils
							.findLaunchConfiguration(sourceConfName,
									Activator.PDE_LAUNCH_CONFIG_ID);
					if (config != null) {
						navigateToLaunchConfiguration(config);
					}
				}
			}
		});
	}

	private void navigateToLaunchConfiguration(ILaunchConfiguration config) {
		LaunchConfigurationsDialog mainDialog = (LaunchConfigurationsDialog) getLaunchConfigurationDialog();
		mainDialog.setInitialSelection(new StructuredSelection(config));
		mainDialog.doInitialTreeSelection();
	}

	private void createSourceConfText(Composite parent) {
		sourceConfField = new Text(parent, SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		sourceConfField.setLayoutData(gridData);
		sourceConfField.setEditable(false);

		sourceConfField.addModifyListener(modifyListener);
	}

	private void createSelectConfButton(Composite parent) {
		Composite buttonComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		buttonComposite.setLayout(layout);
		buttonComposite.setLayoutData(gridData);
		buttonComposite.setFont(parent.getFont());

		Button button = new Button(buttonComposite, SWT.PUSH);
		button.setFont(buttonComposite.getFont());
		button.setText(SELECT_CONF_BUTTON_LABEL);
		GridData gd = new GridData();
		button.setLayoutData(gd);
		gd.widthHint = IDialogConstants.BUTTON_WIDTH;
		gd.horizontalAlignment = GridData.FILL;

		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectSourceConfig();
			}
		});
	}

	private void selectSourceConfig() {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				getShell(), new ConfigurationLabelProvider());

		ILaunchConfiguration[] launches = LaunchConfigurationUtils
				.getLaunches(Activator.PDE_LAUNCH_CONFIG_ID);
		dialog.setElements(launches);
		dialog.setTitle(SELECT_DIALOG_TITLE);
		dialog.setMessage(SELECT_DIALOG_MESSAGE);
		dialog.setMultipleSelection(false);

		if (dialog.open() == Window.OK) {
			Object[] selected = dialog.getResult();
			if (selected.length > 0) {
				sourceConfField.setText(((ILaunchConfiguration) selected[0])
						.getName());
			}
		}
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(Activator.ATTR_ECL_PORT, 5378);
		configuration.setAttribute(Activator.ATTR_TESLA_PORT, 7926);
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		String source = null;
		String account = null;
		try {
			source = configuration.getAttribute(Activator.TARGET_CONFIGURATION,	""); //$NON-NLS-1$
		} catch (CoreException e) {
			Activator.log(e);
		}
		sourceConfField.setText(source);
		selectAccount(account);
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(Activator.TARGET_CONFIGURATION,
				getTargetConfName());
	}

	@Override
	public boolean isValid(ILaunchConfiguration configuration) {
		String targetName = ""; //$NON-NLS-1$
		try {
			targetName = configuration.getAttribute(
					Activator.TARGET_CONFIGURATION, "");
		} catch (CoreException e) {
			// Ignore
		}

		if (targetName.length() > 0) {
			ILaunchConfiguration target = LaunchConfigurationUtils
					.findLaunchConfiguration(targetName,
							Activator.PDE_LAUNCH_CONFIG_ID);
			if (target == null) {
				setErrorMessage(TARGET_LAUNCH_NOT_EXISTS_MESSAGE);
			} else {
				setErrorMessage(null);
				return true;
			}
		} else {
			setErrorMessage(SELECT_LAUNCH_MESSAGE);
		}
		return false;
	}

	private String getTargetConfName() {
		return sourceConfField.getText();
	}

	public String getName() {
		return TAB_NAME;
	}

	@Override
	public Image getImage() {
		return fImage;
	}

	@Override
	public void dispose() {
		fImage.dispose();
		super.dispose();
	}

	class ConfigurationLabelProvider extends LabelProvider {

		@Override
		public Image getImage(Object element) {

			if (element instanceof ILaunchConfiguration) {
				ILaunchConfiguration config = (ILaunchConfiguration) element;
				Image image = null;
				try {
					ILaunchConfigurationType type = config.getType();
					image = DebugUITools.getImage(type.getIdentifier());
				} catch (CoreException e) {
					// Do nothing
				}
				return image;
			}
			return null;
		}

		@Override
		public String getText(Object element) {
			if (element instanceof ILaunchConfiguration) {
				ILaunchConfiguration config = (ILaunchConfiguration) element;
				return config.getName();
			}
			return null;
		}

	}
}
