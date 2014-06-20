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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.pde.internal.launching.IPDEConstants;
import org.eclipse.pde.internal.launching.launcher.LaunchArgumentsHelper;
import org.eclipse.pde.launching.IPDELauncherConstants;
import org.eclipse.ui.IWorkbench;

import org.eclipse.rcptt.internal.launching.ext.OSArchitecture;
import org.eclipse.rcptt.internal.launching.ext.Q7TargetPlatformManager;
import org.eclipse.rcptt.internal.launching.ext.UpdateVMArgs;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.common.Q7LaunchingCommon;
import org.eclipse.rcptt.launching.ext.Q7LaunchingUtil;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;

@SuppressWarnings("restriction")
public class NewAUTWizard extends Wizard {
	private static final String ATTR_D32 = "-d32";
	private NewAUTPage page;

	public NewAUTWizard() {
		setWindowTitle("New Application Under Test");
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	@Override
	public void addPages() {
		page = new NewAUTPage("new", "New Application Under Test", null);
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		ITargetPlatformHelper target = page.getTarget();
		if (target.isValid()) {
			try {
				target.setTargetName(Q7TargetPlatformManager
						.getTargetPlatformName(page.getTargetName()));
				target.save();
				ILaunchConfigurationWorkingCopy workingCopy = Q7LaunchingUtil
						.createLaunchConfiguration(target, page.getTargetName());
				OSArchitecture autArch = page.getArchitecture();
				workingCopy.setAttribute(Q7LaunchingCommon.ATTR_ARCH,
						autArch.name());
				OSArchitecture jvmArch = page.getJVMArch();
				String vmArgs = target.getIniVMArgs();
				if (vmArgs == null) {
					// Lets use current runner vm arguments
					vmArgs = LaunchArgumentsHelper.getInitialVMArguments()
							.trim();
				} else {
					vmArgs = vmArgs.trim();
				}
				if (!autArch.equals(jvmArch)
						&& Platform.getOS().equals(Platform.OS_MACOSX)) {
					if (vmArgs != null && !vmArgs.contains(ATTR_D32)) {
						vmArgs += " " + ATTR_D32;
					} else {
						vmArgs = ATTR_D32;
					}
				}
				if (vmArgs != null && vmArgs.length() > 0) {
					vmArgs = UpdateVMArgs.updateAttr(vmArgs);
					workingCopy
							.setAttribute(
									IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,
									vmArgs);
				}

				IVMInstall install = page.getJVMInstall();
				if (install != null) {
					workingCopy
							.setAttribute(
									IJavaLaunchConfigurationConstants.ATTR_JRE_CONTAINER_PATH,
									String.format(
											"org.eclipse.jdt.launching.JRE_CONTAINER/%s/%s",
											install.getVMInstallType().getId(),
											install.getName()));
				}

				String programArgs = LaunchArgumentsHelper
						.getInitialProgramArguments().trim();
				if (programArgs.contains("${target.arch}")) {
					programArgs = programArgs.replace("${target.arch}",
							autArch.name());
				} else {
					programArgs = programArgs + " -arch " + autArch.name();
				}
				if (programArgs.length() > 0) {
					workingCopy
							.setAttribute(
									IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS,
									programArgs);
				}

				workingCopy.setAttribute(IPDEConstants.APPEND_ARGS_EXPLICITLY,
						true);
				String product = target.getDefaultProduct();
				if (product != null) {
					workingCopy.setAttribute(IPDELauncherConstants.USE_PRODUCT,
							true);
					workingCopy.setAttribute(IPDELauncherConstants.PRODUCT,
							product);
				}
				workingCopy.setAttribute(IPDELauncherConstants.DOCLEAR, false);
				workingCopy.setAttribute(IPDELauncherConstants.ASKCLEAR, true);
				workingCopy.setAttribute(IPDEConstants.DOCLEARLOG, false);
				workingCopy.setAttribute(IPDELauncherConstants.LOCATION,
						getDefaultWorkspaceLocation(workingCopy.getName()));

				// String config = target.getTemplateConfigLocation();
				// if (config != null) {
				// workingCopy.setAttribute(
				// IPDELauncherConstants.CONFIG_GENERATE_DEFAULT,
				// false);
				// workingCopy.setAttribute(
				// IPDELauncherConstants.CONFIG_TEMPLATE_LOCATION,
				// config);
				// }
				// Disable console by default
				workingCopy.setAttribute(
						IDebugUIConstants.ATTR_CAPTURE_IN_CONSOLE, false);
				workingCopy
						.setAttribute(DebugPlugin.ATTR_CAPTURE_OUTPUT, false);

				workingCopy.doSave();
				Q7TargetPlatformManager.setHelper(target.getName(), target);
				return true;
			} catch (CoreException e) {
				Q7UIPlugin.log(e);
			}
		}
		target.delete();
		return false;
	}

	public static String getDefaultWorkspaceLocation(String uniqueName) {
		return "${workspace_loc}/../aut-" + uniqueName.replaceAll("\\s", ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}