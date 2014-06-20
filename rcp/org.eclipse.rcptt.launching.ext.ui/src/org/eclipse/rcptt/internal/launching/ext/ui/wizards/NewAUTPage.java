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
package org.eclipse.rcptt.internal.launching.ext.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.internal.debug.ui.jres.JREsPreferencePage;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMInstallType;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.progress.UIJob;

import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.ext.JDTUtils;
import org.eclipse.rcptt.internal.launching.ext.OSArchitecture;
import org.eclipse.rcptt.internal.launching.ext.Q7TargetPlatformManager;
import org.eclipse.rcptt.internal.launching.ext.ui.Activator;
import org.eclipse.rcptt.internal.launching.ext.ui.SyncProgressMonitor;
import org.eclipse.rcptt.internal.launching.ext.ui.TimeTriggeredProgressMonitorDialog;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutLaunchState;
import org.eclipse.rcptt.launching.AutManager;
import org.eclipse.rcptt.launching.ext.Q7LaunchingUtil;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;
import org.eclipse.rcptt.launching.target.TargetPlatformManager;
import org.eclipse.rcptt.ui.commons.SWTFactory;
import org.eclipse.rcptt.util.FileUtil;

@SuppressWarnings("restriction")
public class NewAUTPage extends WizardPage {
	private static final int FIELD_TIMEOUT = 500;
	private DataBindingContext dbc = new DataBindingContext();
	private Shell shell;

	private WritableValue nameValue = new WritableValue("", String.class);
	private WritableValue locationValue = new WritableValue("", String.class);
	private WritableValue info = new WritableValue(null,
			ITargetPlatformHelper.class);
	private WritableValue platformArchitecture64 = new WritableValue(
			Boolean.FALSE, Boolean.class);
	private WritableValue platformArchitecture32 = new WritableValue(
			Boolean.TRUE, Boolean.class);

	private WritableValue architectureError = new WritableValue(Boolean.FALSE,
			Boolean.class);

	private WritableValue archEnabled = new WritableValue(Boolean.TRUE,
			Boolean.class);
	private WritableValue showAdvanced = new WritableValue(Boolean.FALSE,
			Boolean.class);

	private WritableValue detailsValue = new WritableValue("", String.class);

	private WritableValue warningMessageValue = new WritableValue("",
			String.class);
	private String JobFamily = "";
	private OSArchitecture architecture;
	private IVMInstall jvmInstall;
	private OSArchitecture jvmArch;
	private String currentName = null;
	private Runnable advancedHandler;
	private IObservableValue delayedName;
	private ISWTObservableValue locationModifyObservable;
	private ISWTObservableValue nameModifyObservable;

	protected NewAUTPage(String pageName, String title,
			ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	public void validate(boolean clean) {
		setErrorMessage(null);
		setMessage(null);

		final String location = (String) locationValue.getValue();
		if (location.trim().length() == 0) {
			setErrorMessage("Please specify your Eclipse application installation directory.");
			setPageComplete(false);
			archEnabled.setValue(Boolean.FALSE);
			return;
		}

		ITargetPlatformHelper helper = (ITargetPlatformHelper) info.getValue();

		if (clean) {
			if (helper != null) {
				helper.delete();
			}
			runInDialog(new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					monitor.beginTask("Validate AUT", 100);

					TargetPlatformManager.clearTargets();

					final ITargetPlatformHelper platform = Q7TargetPlatformManager
							.createTargetPlatform(location, monitor, false);
					if (!monitor.isCanceled()) {
						shell.getDisplay().asyncExec(new Runnable() {
							public void run() {
								info.setValue(platform);
							}
						});
					}
				}
			});
		} else if (helper != null) {
			validatePlatform();
		}
	}

	private void validatePlatform() {
		ITargetPlatformHelper helper = (ITargetPlatformHelper) info.getValue();

		if (helper == null) {
			archEnabled.setValue(Boolean.FALSE);
			setErrorMessage("Please specify correct Application installation directory...");
			setPageComplete(false);
			return;
		}

		if (!helper.isValid()) {
			archEnabled.setValue(Boolean.FALSE);
			setErrorMessage(helper.getErrorMessage());
			setPageComplete(false);
			return;
		}

		setMessage(helper.getWarningMessage());
		setErrorMessage(null);
		// setPageComplete(true);
		if (((String) nameValue.getValue()).trim().length() == 0) {
			String defaultProduct = helper.getDefaultProduct();
			if (defaultProduct != null) {
				nameValue.setValue(helper.getDefaultProduct());
				int i = 2;
				while (!validateAUTName()) {
					nameValue.setValue(helper.getDefaultProduct()
							+ Integer.toString(i));
					i++;
				}
			}
		}
		// Extract some details

		StringBuilder builder = new StringBuilder();
		architecture = helper.detectArchitecture(false, new StringBuilder());
		builder.append("name:").append(architecture).append("\n");

		switch (architecture) {
		case Unknown:
			archEnabled.setValue(Boolean.TRUE);
			// obtain architecture from UI
			if (Boolean.TRUE.equals(platformArchitecture32.getValue())) {
				architecture = OSArchitecture.x86;
			} else {
				architecture = OSArchitecture.x86_64;
			}
			break;// Do not change value
		case x86:
			archEnabled.setValue(Boolean.FALSE);
			platformArchitecture32.setValue(Boolean.TRUE);
			platformArchitecture64.setValue(Boolean.FALSE);
			break;
		case x86_64:
			archEnabled.setValue(Boolean.FALSE);
			platformArchitecture32.setValue(Boolean.FALSE);
			platformArchitecture64.setValue(Boolean.TRUE);
			break;
		}

		boolean haveArch = findJVM();
		if (!haveArch) {
			// try to register current JVM, it may help
			try {
				JDTUtils.registerCurrentJVM();
				haveArch = findJVM();
			} catch (CoreException e) {
				// no special actions, error message will be set by lines below
				Q7UIPlugin.log(e);
			}
		}

		architectureError.setValue(!haveArch);
		if (!haveArch) {
			setPageComplete(false);
			setErrorMessage("The selected AUT requires "
					+ ((OSArchitecture.x86.equals(architecture)) ? "32 bit"
							: "64 bit") + " Java VM which cannot be found.");
			return;
		}

		detailsValue.setValue(builder.toString());
		if (validateAUTName()) {
			setPageComplete(true);
		}
	}

	private boolean findJVM() {
		// Check for existing JVM to be found
		boolean haveArch = false;
		if (!architecture.equals(OSArchitecture.Unknown)) {

			IVMInstallType[] types = JavaRuntime.getVMInstallTypes();
			for (IVMInstallType ivmInstallType : types) {
				IVMInstall[] installs = ivmInstallType.getVMInstalls();
				for (IVMInstall ivmInstall : installs) {
					jvmArch = JDTUtils.detect(ivmInstall);
					if (jvmArch != null
							&& (jvmArch.equals(architecture) || (jvmArch
									.equals(OSArchitecture.x86_64) && JDTUtils
									.canRun32bit(ivmInstall)))) {
						jvmInstall = ivmInstall;
						haveArch = true;
						break;
					}
				}
				if (haveArch)
					break;
			}
		}
		return haveArch;
	}

	private boolean validateAUTName() {
		String name = ((String) nameValue.getValue()).trim();
		if (name.length() == 0) {
			setErrorMessage("The name of Application Under Test (AUT) can not be empty.");
			setPageComplete(false);
			archEnabled.setValue(Boolean.FALSE);
			return false;
		}
		for (char c : name.toCharArray()) {
			if (FileUtil.isInvalidFileNameChar(c)) {
				setErrorMessage("Symbol \"" + c
						+ "\" is not acceptable in AUT name.");
				setPageComplete(false);
				archEnabled.setValue(Boolean.FALSE);
				return false;
			}
		}
		if (currentName != null && currentName.equals(name)) {
			return true;
		}
		try {
			ILaunchManager launchManager = DebugPlugin.getDefault()
					.getLaunchManager();
			ILaunchConfigurationType type = launchManager
					.getLaunchConfigurationType(Q7LaunchingUtil.EXTERNAL_LAUNCH_TYPE);
			ILaunchConfiguration[] configurations = launchManager
					.getLaunchConfigurations(type);
			for (ILaunchConfiguration iLaunchConfiguration : configurations) {
				if (name.equals(iLaunchConfiguration.getName())) {
					setErrorMessage(MessageFormat
							.format("Application {0} already exists. Please specify a different name.",
									name));
					archEnabled.setValue(Boolean.FALSE);
					setPageComplete(false);
					return false;
				}
			}
		} catch (Throwable e) {
			Q7UIPlugin.log(e);
		}
		return true;
	}

	private Job runInDialog(final IRunnableWithProgress run) {
		Job.getJobManager().cancel(JobFamily);
		Job myJob = new UIJob("Validate install location") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				final TimeTriggeredProgressMonitorDialog dialog = new TimeTriggeredProgressMonitorDialog(
						shell, 500);
				try {
					dialog.run(true, false, new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor)
								throws InvocationTargetException,
								InterruptedException {
							run.run(new SyncProgressMonitor(monitor, dialog
									.getShell().getDisplay()));
						}
					});
				} catch (InvocationTargetException e) {
					Activator.log(e);
				} catch (InterruptedException e) {
					Activator.log(e);
				}
				return Status.OK_STATUS;
			}

			@Override
			public boolean belongsTo(Object family) {
				return JobFamily.equals(family);
			}
		};
		myJob.schedule();
		return myJob;
	}

	public void createControl(Composite sparent) {
		initializeDialogUnits(sparent);
		this.shell = sparent.getShell();
		Composite parent = new Composite(sparent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(parent);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);

		Label l = new Label(parent, SWT.NONE);
		l.setText("Location:");

		Text locationField = new Text(parent, SWT.BORDER);
		GridDataFactory.swtDefaults().grab(true, false)
				.align(SWT.FILL, SWT.CENTER)
				.hint(IDialogConstants.ENTRY_FIELD_WIDTH, SWT.DEFAULT)
				.applyTo(locationField);

		locationModifyObservable = SWTObservables.observeText(locationField,
				SWT.Modify);
		locationModifyObservable.addChangeListener(new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				setPageComplete(false);
			}
		});
		dbc.bindValue(
				Observables.observeDelayedValue(500, locationModifyObservable),
				locationValue);

		Button fileLocationButton = new Button(parent, SWT.PUSH);
		fileLocationButton.setText("&Browse...");
		fileLocationButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleSelectLocation();
			}
		});
		GridDataFactory.fillDefaults().grab(false, false)
				.applyTo(fileLocationButton);
		SWTFactory.setButtonDimensionHint(fileLocationButton);

		l = new Label(parent, SWT.NONE);
		l.setText("Name:");
		Text nameField = new Text(parent, SWT.BORDER);
		GridDataFactory.swtDefaults().grab(true, false)
				.align(SWT.FILL, SWT.CENTER)
				.hint(IDialogConstants.ENTRY_FIELD_WIDTH, SWT.DEFAULT)
				.span(2, 1).applyTo(nameField);

		nameModifyObservable = SWTObservables
				.observeText(nameField, SWT.Modify);
		nameModifyObservable.addChangeListener(new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				setPageComplete(false);
			}
		});
		delayedName = Observables.observeDelayedValue(FIELD_TIMEOUT,
				nameModifyObservable);
		dbc.bindValue(delayedName, nameValue);

		l = new Label(parent, SWT.NONE);
		l.setText("Architecture:");
		Composite archGroup = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(true)
				.applyTo(archGroup);
		GridDataFactory.fillDefaults().span(1, 1).grab(true, false)
				.applyTo(archGroup);
		Button b32 = new Button(archGroup, SWT.RADIO);
		Button b64 = new Button(archGroup, SWT.RADIO);
		b32.setText("32bit");
		b64.setText("64bit");

		dbc.bindValue(SWTObservables.observeEnabled(b32), archEnabled);
		dbc.bindValue(SWTObservables.observeEnabled(b64), archEnabled);
		dbc.bindValue(SWTObservables.observeSelection(b64),
				platformArchitecture64);
		dbc.bindValue(SWTObservables.observeSelection(b32),
				platformArchitecture32);

		Link link = new Link(parent, SWT.UNDERLINE_LINK);
		link.setText("There is no appropriate JVM configured. <a>Configure JVM...</a>");
		GridDataFactory.fillDefaults().span(3, 1).grab(true, false)
				.applyTo(link);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PreferenceDialog dialog = PreferencesUtil
						.createPreferenceDialogOn(shell, JREsPreferencePage.ID,
								new String[] { JREsPreferencePage.ID }, null);
				if (dialog.open() == PreferenceDialog.OK) {
					validatePlatform();
				}
			}
		});
		Link advanced = new Link(parent, SWT.UNDERLINE_LINK);
		advanced.setText("<a>Advanced...</a>");
		GridDataFactory.fillDefaults().align(SWT.END, SWT.CENTER).span(3, 1)
				.grab(true, false).applyTo(advanced);
		advanced.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (advancedHandler != null) {
					advancedHandler.run();
				}
			}
		});
		Label warning = new Label(parent, SWT.WRAP);
		warning.setText("");
		GridDataFactory.fillDefaults().span(3, 1).grab(true, false)
				.applyTo(warning);

		dbc.bindValue(SWTObservables.observeText(warning), warningMessageValue);

		dbc.bindValue(SWTObservables.observeVisible(advanced), showAdvanced);

		dbc.bindValue(SWTObservables.observeVisible(link), architectureError);

		// Label details = new Label(parent, SWT.NONE);
		// GridDataFactory.fillDefaults().grab(true, true).span(2, 1)
		// .applyTo(details);
		// dbc.bindValue(SWTObservables.observeText(details), detailsValue);

		locationValue.addChangeListener(new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				validate(true);
			}
		});
		IChangeListener validatePlatformListener = new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				validatePlatform();
			}
		};
		nameValue.addChangeListener(validatePlatformListener);
		info.addChangeListener(validatePlatformListener);
		platformArchitecture32.addChangeListener(validatePlatformListener);
		platformArchitecture64.addChangeListener(validatePlatformListener);

		setControl(parent);
		validate(info.getValue() == null);
		Dialog.applyDialogFont(parent);
	}

	protected void handleSelectLocation() {
		DirectoryDialog fileDialog = new DirectoryDialog(shell, SWT.NONE);
		fileDialog.setFilterPath((String) locationValue.getValue());
		String text = fileDialog.open();
		if (text != null) {
			locationValue.setValue(text);
		}
	}

	public ITargetPlatformHelper getTarget() {
		return (ITargetPlatformHelper) info.getValue();
	}

	public String getTargetName() {
		return (String) nameValue.getValue();
	}

	public String getTargetLocation() {
		return (String) locationValue.getValue();
	}

	public IVMInstall getJVMInstall() {
		return jvmInstall;
	}

	public OSArchitecture getJVMArch() {
		return jvmArch;
	}

	public OSArchitecture getArchitecture() {
		if (Boolean.TRUE.equals(platformArchitecture32.getValue())) {
			return OSArchitecture.x86;
		} else {
			return OSArchitecture.x86_64;
		}
	}

	public void initializeExisting(String configName, String autLocation,
			String targetName, final ILaunchConfiguration configuration) {
		// Remove existing target platform
		this.currentName = configName;
		// TargetPlatformManager.deleteTargetPlatform(targetName);
		final ITargetPlatformHelper helper[] = { null };
		final TimeTriggeredProgressMonitorDialog dialog = new TimeTriggeredProgressMonitorDialog(
				shell, 500);
		try {
			dialog.run(true, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					try {
						helper[0] = Q7TargetPlatformManager.loadTarget(
								configuration, monitor);
					} catch (CoreException e) {
						RcpttPlugin.log(e);
					}
				}
			});
		} catch (InvocationTargetException e) {
			Activator.log(e);
		} catch (InterruptedException e) {
			Activator.log(e);
		}
		if (helper[0] != null && helper[0].isValid()) {
			info.setValue(helper[0]);
		}
		nameValue.setValue(configName);
		locationValue.setValue(autLocation);
		if (configuration != null) {
			Aut launch = AutManager.INSTANCE.getByLaunch(configuration);
			if (launch != null) {
				List<AutLaunch> list = launch.getLaunches();
				for (AutLaunch autLaunch : list) {
					if (autLaunch.getState().equals(AutLaunchState.ACTIVE)) {
						warningMessageValue
								.setValue("Running AUT is detected.\nPlease restart AUT manually, after configuration update, if required.");
						break;
					}
				}
			}
		}
	}

	public void addAdvancedHandler(Runnable runnable) {
		this.showAdvanced.setValue(Boolean.TRUE);
		this.advancedHandler = runnable;
	}
}