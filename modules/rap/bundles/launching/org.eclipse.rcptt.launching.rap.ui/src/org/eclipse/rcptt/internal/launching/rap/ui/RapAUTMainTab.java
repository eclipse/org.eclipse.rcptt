/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.launching.rap.ui;

import static org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin.log;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationListener;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.pde.internal.ui.IHelpContextIds;
import org.eclipse.pde.internal.ui.PDEPluginImages;
import org.eclipse.pde.ui.launcher.AbstractLauncherTab;
import org.eclipse.rcptt.launching.rap.RAPLaunchConfig;
import org.eclipse.rcptt.launching.rap.RAPLaunchConfig.BrowserMode;
import org.eclipse.rcptt.launching.rap.RAPLaunchConfigValidator;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;

@SuppressWarnings("restriction")
public class RapAUTMainTab extends AbstractLauncherTab {

	private static final int MIN_PORT_NUMBER = 0;
	private static final int MAX_PORT_NUMBER = 65535;
	private static final int MIN_SESSION_TIMEOUT = 0;
	private static final int MAX_SESSION_TIMEOUT = Integer.MAX_VALUE;
	private static final String BROWSER_PREFERENCE_PAGE = "org.eclipse.ui.browser.preferencePage"; //$NON-NLS-1$
	static final String SLASH = "/"; //$NON-NLS-1$
	private static final String PROTOCOL = "http"; //$NON-NLS-1$
	private static final String HOST = "127.0.0.1"; //$NON-NLS-1$

	private final SelectionListener selectionListener;
	private final GridDataFactory fillHorizontal;
	private final Image fImage;

	private final ModifyListener modifyListener;
	private AUTLocationBlock fLocationBlock;
	private ITargetPlatformHelper currentTargetPlatform;

	private Button internalBrowserRadioButton;
	private Button externalBrowserRadioButton;
	private Text servletPathTextField;
	private Text applicationUrlTextField;
	private Spinner portSpinner;
	private Button useSessionTimeoutCheckBox;
	private Spinner sessionTimeoutSpinner;
	private Button useFixedPortCheckBox;
	private Button contextPathCheckBox;
	private Text contextPathTextField;
	private DataLocationBlock dataLocationBlock;
	private ILaunchConfigurationListener launchConfigListener;

	public RapAUTMainTab(RcpttRapTabGroup group) {
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		fillHorizontal = GridDataFactory.createFrom(gridData);
		selectionListener = createDialogSelectionListener();
		modifyListener = createDialogModifyListener();
		fImage = PDEPluginImages.DESC_MAIN_TAB.createImage();
		createLocationBlock();

		addLaunchConfigListener();
	}

	@Override
	public Image getImage() {
		return fImage;
	}

	private ModifyListener createDialogModifyListener() {
		ModifyListener result = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		return result;
	}

	@Override
	public void dispose() {
		ILaunchManager launchManager = getLaunchManager();
		launchManager.removeLaunchConfigurationListener(launchConfigListener);
		super.dispose();

	}

	private void createLocationBlock() {
		fLocationBlock = new AUTLocationBlock(this);
	}

	public void createControl(Composite parent) {
		final ScrolledComposite scrollContainer = new ScrolledComposite(parent, SWT.V_SCROLL);
		scrollContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite composite = new Composite(scrollContainer, SWT.NONE);
		scrollContainer.setContent(composite);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		fLocationBlock.createControl(composite);

		createBrowserModeSection(composite);
		createRuntimeSettingsSection(composite);
		createDataLocationSection(composite);

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
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(composite, IHelpContextIds.LAUNCHER_BASIC);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration config) {
		try {
			fLocationBlock.initializeFrom(config);

			RAPLaunchConfig rapConfig = new RAPLaunchConfig(config);
			servletPathTextField.setText(rapConfig.getServletPath());
			useFixedPortCheckBox.setSelection(rapConfig.getUseManualPort());
			portSpinner.setSelection(rapConfig.getPort());
			contextPathCheckBox.setSelection(rapConfig.getUseManualContextPath());
			contextPathTextField.setText(rapConfig.getContextPath());
			boolean openBrowser = rapConfig.getOpenBrowser();
			internalBrowserRadioButton.setEnabled(openBrowser);
			externalBrowserRadioButton.setEnabled(openBrowser);
			if (org.eclipse.rcptt.launching.rap.RAPLaunchConfig.BrowserMode.EXTERNAL
					.equals(rapConfig.getBrowserMode())) {
				externalBrowserRadioButton.setSelection(true);
				internalBrowserRadioButton.setSelection(false);
			} else {
				externalBrowserRadioButton.setSelection(false);
				internalBrowserRadioButton.setSelection(true);
			}
			useSessionTimeoutCheckBox.setSelection(rapConfig.getUseSessionTimeout());
			sessionTimeoutSpinner.setSelection(rapConfig.getSessionTimeout());
			dataLocationBlock.initializeFrom(rapConfig);

		} catch (CoreException e) {
			Activator.log(e);
		}
	}

	void setStatus(final IStatus status) {
		if (!status.isOK() && !status.matches(IStatus.CANCEL)) {
			log(status);
		}
		Shell shell = getShell();
		if (shell == null)
			return;
		if (shell.getDisplay() != null)
			shell.getDisplay().syncExec(new Runnable() {

				@Override
				public void run() {
					if (status.isOK()) {
						setErrorMessage(null);
						setMessage(null);
					} else if (status.matches(IStatus.ERROR)) {
						setMessage(null);
						setErrorMessage(status.getMessage());
					} else {
						setMessage(status.getMessage());
						setErrorMessage(null);
					}
				}
			});

	}

	@Override
	public void validateTab() {
		if (getErrorMessage() == null) {
			setStatus(fLocationBlock.getStatus());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy config) {
		try {
			fLocationBlock.performApply(config);

			RAPLaunchConfig rapConfig = new RAPLaunchConfig(config);
			rapConfig.setServletPath(servletPathTextField.getText());
			rapConfig.setOpenBrowser(true);
			rapConfig.setBrowserMode(getBrowserMode());
			portSpinner.setEnabled(useFixedPortCheckBox.getSelection());
			rapConfig.setUseManualPort(useFixedPortCheckBox.getSelection());
			rapConfig.setPort(portSpinner.getSelection());
			contextPathTextField.setEnabled(contextPathCheckBox.getSelection());
			rapConfig.setUseManualContextPath(contextPathCheckBox.getSelection());
			rapConfig.setContextPath(contextPathTextField.getText());
			sessionTimeoutSpinner.setEnabled(useSessionTimeoutCheckBox.getSelection());
			rapConfig.setUseSessionTimeout(useSessionTimeoutCheckBox.getSelection());
			rapConfig.setSessionTimeout(sessionTimeoutSpinner.getSelection());
			rapConfig.setDataLocation(dataLocationBlock.getLocation());
			boolean useDefaultDataLocation = dataLocationBlock.getUseDefaultDataLocation();
			rapConfig.setUseDefaultDataLocation(useDefaultDataLocation);
			rapConfig.setDoClearDataLocation(dataLocationBlock.getDoClearDataLocation());
			rapConfig.setAskClearDataLocation(false);
			// validate(rapConfig);
			setDirty(true);

		} catch (CoreException e) {
			setStatus(e.getStatus());
		}
	}

	private void validate(RAPLaunchConfig config) {
		IStatus locationStatus = fLocationBlock.getStatus();
		if (!locationStatus.isOK()) {
			setStatus(locationStatus);
			return;
		}
		RAPLaunchConfigValidator validator = new RAPLaunchConfigValidator(config);
		IStatus[] states = validator.validate();
		String infoMessage = findMessage(states, IStatus.INFO);
		String warnMessage = findMessage(states, IStatus.WARNING);
		String errorMessage = findMessage(states, IStatus.ERROR);
		if (warnMessage != null) {
			setMessage(warnMessage);
		} else {
			setMessage(infoMessage);
		}
		setErrorMessage(errorMessage);
	}

	private static String findMessage(IStatus[] states, int severity) {
		String result = null;
		for (int i = 0; result == null && i < states.length; i++) {
			if (states[i].matches(severity)) {
				result = states[i].getMessage();
			}
		}
		return result;
	}

	private org.eclipse.rcptt.launching.rap.RAPLaunchConfig.BrowserMode getBrowserMode() {
		boolean selection = externalBrowserRadioButton.getSelection();
		return selection ? BrowserMode.EXTERNAL : BrowserMode.INTERNAL;
	}

	public void setCurrentTargetPlatform(ITargetPlatformHelper info) {
		this.currentTargetPlatform = info;
	}

	public ITargetPlatformHelper getTarget() {
		return currentTargetPlatform;
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		RAPLaunchConfig.setDefaults(config);
	}

	@Override
	public String getName() {
		return "&Main";
	}

	public void createBrowserModeSection(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setLayoutData(fillHorizontal.create());
		group.setText("Open in Browser");
		group.setLayout(new GridLayout());
		createBrowserActivationPart(group);
		createServletPathPart(group);
	}

	private void createBrowserActivationPart(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(fillHorizontal.span(2, 1).create());
		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 0;
		composite.setLayout(layout);
		Link browserPrefsLink = createBrowserPrefsLink(composite);
		browserPrefsLink.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));
		Composite modePart = createBrowserModePart(composite);
		modePart.setLayoutData(GridDataFactory.fillDefaults().span(2, 1).indent(17, 0).create());
	}

	private Link createBrowserPrefsLink(Composite composite) {
		Link link = new Link(composite, SWT.NONE);
		link.setText("<a>Configure Browsers...</a>");
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				openBrowserPrefs();
			}
		});
		return link;
	}

	private void openBrowserPrefs() {
		PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(getShell(), BROWSER_PREFERENCE_PAGE, null,
				null);
		dialog.open();
		dialog.close();
	}

	private Composite createBrowserModePart(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		internalBrowserRadioButton = new Button(composite, SWT.RADIO);
		internalBrowserRadioButton.setText("I&nternal web  browser");
		internalBrowserRadioButton.addSelectionListener(selectionListener);
		externalBrowserRadioButton = new Button(composite, SWT.RADIO);
		externalBrowserRadioButton.setText("E&xternal web  browser");
		externalBrowserRadioButton.addSelectionListener(selectionListener);
		return composite;
	}

	private void createServletPathPart(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(fillHorizontal.create());
		composite.setLayout(new GridLayout(2, false));
		Label lblServletPath = new Label(composite, SWT.NONE);
		lblServletPath.setText("&Servlet path:");
		servletPathTextField = new Text(composite, SWT.BORDER);
		servletPathTextField.addModifyListener(modifyListener);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(servletPathTextField);
		Label finalUrlLabel = new Label(composite, SWT.NONE);
		finalUrlLabel.setText("Application URL:");
		// Create a text area which is read-only but not disabled to allow the user to select the text
		// and copy it, set the background to make it clear to the user this is not a place to edit
		applicationUrlTextField = new Text(composite, SWT.SINGLE | SWT.READ_ONLY);
		applicationUrlTextField.setBackground(applicationUrlTextField.getParent().getBackground());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(applicationUrlTextField);
	}

	private SelectionAdapter createDialogSelectionListener() {
		SelectionAdapter result = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		};
		return result;
	}

	private void createRuntimeSettingsSection(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setLayoutData(fillHorizontal.create());
		group.setText("Server Settings");
		group.setLayout(new GridLayout(4, false));
		useFixedPortCheckBox = new Button(group, SWT.CHECK);
		useFixedPortCheckBox.setText("Use a fixed &port:");
		useFixedPortCheckBox.addSelectionListener(selectionListener);
		portSpinner = new Spinner(group, SWT.BORDER);
		portSpinner.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false));
		portSpinner.setMinimum(MIN_PORT_NUMBER);
		portSpinner.setMaximum(MAX_PORT_NUMBER);
		portSpinner.addModifyListener(modifyListener);
		useSessionTimeoutCheckBox = new Button(group, SWT.CHECK);
		GridDataFactory.fillDefaults().indent(25, 0).applyTo(useSessionTimeoutCheckBox);
		useSessionTimeoutCheckBox.setText("Session &timeout [s]:");
		useSessionTimeoutCheckBox.addSelectionListener(selectionListener);
		sessionTimeoutSpinner = new Spinner(group, SWT.BORDER);
		sessionTimeoutSpinner.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false));
		sessionTimeoutSpinner.setMinimum(MIN_SESSION_TIMEOUT);
		sessionTimeoutSpinner.setMaximum(MAX_SESSION_TIMEOUT);
		sessionTimeoutSpinner.addModifyListener(modifyListener);
		contextPathCheckBox = new Button(group, SWT.CHECK);
		contextPathCheckBox.setText("Context pat&h:");
		contextPathCheckBox.addSelectionListener(selectionListener);
		contextPathTextField = new Text(group, SWT.BORDER | SWT.SINGLE);
		GridDataFactory.fillDefaults().grab(true, false).span(3, 1).applyTo(contextPathTextField);
		contextPathTextField.addModifyListener(modifyListener);
	}

	private void createDataLocationSection(Composite container) {
		dataLocationBlock = new DataLocationBlock(this);
		Control blockControl = dataLocationBlock.createControl(container);
		blockControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	private void addLaunchConfigListener() {
		launchConfigListener = getLaunchConfigListener();
		ILaunchManager launchManager = getLaunchManager();
		launchManager.addLaunchConfigurationListener(launchConfigListener);
	}

	private ILaunchConfigurationListener getLaunchConfigListener() {
		ILaunchConfigurationListener result = new ILaunchConfigurationListener() {
			public void launchConfigurationChanged(ILaunchConfiguration configuration) {
				RAPLaunchConfig rapConfig = new RAPLaunchConfig(configuration);
				validate(rapConfig);
				updateApplicationUrl(rapConfig);
			}

			public void launchConfigurationAdded(ILaunchConfiguration configuration) {
				// Do nothing
			}

			public void launchConfigurationRemoved(ILaunchConfiguration configuration) {
				// Do nothing
			}
		};
		return result;
	}

	private void updateApplicationUrl(RAPLaunchConfig config) {
		String applicationUrl;
		try {
			applicationUrl = getApplicationUrl(config);
		} catch (Exception e) {
			setErrorMessage(e.getMessage());
			applicationUrl = "";
		}
		udpateApplicationUrlTextField(applicationUrl);
	}

	private String getApplicationUrl(RAPLaunchConfig config) throws CoreException {
		String result;
		if (config.getUseManualPort()) {
			int port = config.getPort();
			result = fromLaunchConfig(config, Integer.toString(port), false);
		} else {
			result = fromLaunchConfig(config, "<PORT>", false);
		}
		return result;
	}

	private void udpateApplicationUrlTextField(final String finalApplicationUrl) {
		if (applicationUrlTextField != null && !applicationUrlTextField.isDisposed()) {
			// could be called from a non UI thread
			applicationUrlTextField.getDisplay().syncExec(new Runnable() {
				public void run() {
					if (!finalApplicationUrl.equals(applicationUrlTextField.getText())) {
						applicationUrlTextField.setText(finalApplicationUrl);
					}
				}
			});
		}
	}

	public static String fromLaunchConfig(RAPLaunchConfig config, String port, boolean testMode)
			throws CoreException {
		String path = getUrlPath(config);
		return PROTOCOL + "://" + HOST + ":" + port + path;
	}

	private static String getUrlPath(RAPLaunchConfig config) throws CoreException {
		String contextPath = getContextPath(config);
		String servletPath = getServletPath(config);
		StringBuffer buffer = new StringBuffer();
		buffer.append(SLASH);
		if (!"".equals(contextPath)) {
			buffer.append(contextPath);
			buffer.append(SLASH);
		}
		buffer.append(servletPath);
		return buffer.toString();
	}

	private static String getServletPath(RAPLaunchConfig config) throws CoreException {
		String servletPath = config.getServletPath();
		return stripLeadingAndTrailingSlashes(servletPath);
	}

	private static String getContextPath(RAPLaunchConfig config) throws CoreException {
		String contextPath = "";
		if (config.getUseManualContextPath()) {
			contextPath = config.getContextPath();
		}
		return stripLeadingAndTrailingSlashes(contextPath);
	}

	private static String stripLeadingAndTrailingSlashes(String input) {
		String result = input;
		if (result.startsWith(SLASH)) {
			result = result.substring(1);
		}
		if (result.endsWith(SLASH)) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

}
