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
package org.eclipse.rcptt.launching.target;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.pde.internal.core.target.DirectoryBundleContainer;
import org.eclipse.pde.internal.core.target.P2TargetUtils;
import org.eclipse.pde.internal.core.target.ProfileBundleContainer;
import org.eclipse.pde.internal.core.target.TargetPlatformService;
import org.eclipse.pde.internal.core.target.provisional.IBundleContainer;
import org.eclipse.pde.internal.core.target.provisional.ITargetDefinition;
import org.eclipse.pde.internal.core.target.provisional.ITargetHandle;
import org.eclipse.pde.internal.core.target.provisional.ITargetPlatformService;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin;
import org.eclipse.rcptt.launching.internal.target.PDEHelper;
import org.eclipse.rcptt.launching.internal.target.TargetPlatformHelper;
import org.osgi.framework.Version;

/**
 * AUT target platform management.
 * 
 */
@SuppressWarnings("restriction")
public class TargetPlatformManager {

	/**
	 * Creates new target platform based on specified AUT location
	 * */
	public static ITargetPlatformHelper createTargetPlatform(
			final String location, IProgressMonitor monitor) {
		final TargetPlatformHelper info = new TargetPlatformHelper();
		try {
			ITargetPlatformService service = PDEHelper.getTargetService();
			ITargetDefinition target = service.newTarget();
			info.setTarget(target);

			List<IBundleContainer> containers = new ArrayList<IBundleContainer>();
			IBundleContainer installationContainer = service
					.newProfileContainer(location, null);
			info.setTargetContainer(installationContainer);
			info.getQ7Target().setInstall(installationContainer);
			containers.add(installationContainer);

			IPath pluginsPath = new Path(location).append("plugins");
			File pluginsDir = new File(pluginsPath.toOSString());
			if (pluginsDir.exists() && pluginsDir.isDirectory()
					&& pluginsDir.canRead()) {
				IBundleContainer pluginsContainer = service
						.newDirectoryContainer(pluginsPath.toOSString());
				containers.add(pluginsContainer);
				info.getQ7Target().pluginsDir = pluginsContainer;
			}

			target.setBundleContainers(containers
					.toArray(new IBundleContainer[containers.size()]));
			target.resolve(monitor);

		} catch (Throwable t) {
			String message = t.getMessage();
			if (t instanceof StackOverflowError) {
				// StackOverflowError might happen in xerces
				message = String.format("Invalid eclipse product location: %s",
						location);
			} else {
				// unknown error, better log it
				Q7ExtLaunchingPlugin.getDefault().log(t);
			}

			info.setErrorMessage(message);

		}
		return info;
	}

	/**
	 * Restore target platform from existing configuration
	 * 
	 * @param attribute
	 * @return
	 */
	public static ITargetPlatformHelper getTargetPlatform(
			final String requiredName, final IProgressMonitor monitor,
			final boolean needResolve) {
		final TargetPlatformHelper info = new TargetPlatformHelper();
		ITargetHandle[] targets = PDEHelper.getTargetService().getTargets(
				monitor);
		for (ITargetHandle handle : targets) {
			if (monitor.isCanceled()) {
				return null;
			}
			ITargetDefinition def;

			def = getTargetDefinition(handle);
			String name = def.getName();
			if (name != null && name.equals(requiredName)) {
				info.setTarget(def);
				IBundleContainer[] bundleContainers = def
						.getBundleContainers();
				// Locate default bundle container
				for (IBundleContainer container : bundleContainers) {
					if (monitor.isCanceled()) {
						return null;
					}
					if (container instanceof ProfileBundleContainer) {
						info.setTargetContainer(container);
						info.getQ7Target().setInstall(container);
					} else if (container instanceof DirectoryBundleContainer) {
						info.getQ7Target().pluginsDir = container;
					} else {
						info.getQ7Target().addExtra(container);
					}
				}
				if (needResolve) {
					def.resolve(monitor);
				}
				break;
			}
		}
		return info;
	}

	/**
	 * Delete target platform with specific name.
	 * 
	 * @param tName
	 */
	public static void deleteTargetPlatform(String tName) {
		try {
			// Remove previous target platforms with
			// same name.

			ITargetPlatformService service = PDEHelper.getTargetService();
			ITargetHandle[] handles = service
					.getTargets(new NullProgressMonitor());
			List<ITargetHandle> toRemove = new ArrayList<ITargetHandle>();
			for (ITargetHandle iTargetHandle : handles) {
				if (iTargetHandle.exists()) {
					ITargetDefinition def = getTargetDefinition(iTargetHandle);
					if (def != null && def.getName() != null
							&& def.getName().equals(tName)) {
						toRemove.add(iTargetHandle);
					}
				}
			}
			for (ITargetHandle iTargetHandle : toRemove) {
				service.deleteTarget(iTargetHandle);
			}
		} catch (CoreException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		}
	}

	public static void clearTargets() {
		ITargetPlatformService targetService = PDEHelper.getTargetService();
		TargetPlatformService s = (TargetPlatformService) targetService;

		Version version = RcpttCore.getPlatformVersion();
		if (version.getMajor() == 3 && version.getMinor() == 6) {
			try {
				// s.cleanOrphanedTargetDefinitionProfiles();
				Method method = TargetPlatformService.class
						.getDeclaredMethod("cleanOrphanedTargetDefinitionProfiles");
				method.invoke(s);

				// s.garbageCollect();
				method = TargetPlatformService.class
						.getDeclaredMethod("garbageCollect");
				method.invoke(s);

			} catch (Throwable e) {
				RcpttPlugin.log(e);
			}
		} else if (version.getMajor() == 3 && version.getMinor() == 7) {
			try {
				P2TargetUtils.cleanOrphanedTargetDefinitionProfiles();
				P2TargetUtils.garbageCollect();
			} catch (Throwable e) {
				RcpttPlugin.log(e);
			}
		}
	}

	private static ITargetDefinition getTargetDefinition(ITargetHandle handle) {
		try {
			if (handle == null) {
				return null;
			}
			return handle.getTargetDefinition();
		} catch (CoreException e) {
			Q7ExtLaunchingPlugin.logWarn(e, "Error loading target definition of %s handle (%s)",
					handle.getClass().getName(), handle.toString());
			return null;
		}
	}

	public static ITargetPlatformHelper getCurrentTargetPlatform() {
		ITargetPlatformService targetService = PDEHelper.getTargetService();
		TargetPlatformService s = (TargetPlatformService) targetService;
		try {
			ITargetHandle handle = s.getWorkspaceTargetHandle();
			if (handle != null) {
				TargetPlatformHelper helper = new TargetPlatformHelper() {
					@Override
					public IStatus resolve(IProgressMonitor monitor) {
						// Always resolved platform
						return Status.OK_STATUS;
					};
				};
				ITargetDefinition definition = getTargetDefinition(handle);
				helper.setTarget(definition);
				if (helper.isValid()
						&& helper.getTargetPlatformProfilePath() != null) {
					return helper;
				}
			}
			TargetPlatformHelper helper = new TargetPlatformHelper() {
				@Override
				public IStatus resolve(IProgressMonitor monitor) {
					// Always resolved platform
					return Status.OK_STATUS;
				};
			};
			ITargetDefinition selfAUT = s.newDefaultTargetDefinition();
			selfAUT.setName("selfAUT_" + System.currentTimeMillis());
			s.saveTargetDefinition(selfAUT);
			helper.setTarget(selfAUT);
			return helper;
		} catch (CoreException e) {
			RcpttPlugin.log(e);
		}

		return null;
	}

	public static TargetPlatformHelper getCurrentTargetPlatformCopy(
			String copyName) {
		ITargetPlatformService targetService = PDEHelper.getTargetService();
		TargetPlatformService s = (TargetPlatformService) targetService;

		try {
			ITargetHandle handle = s.getWorkspaceTargetHandle();
			if (handle != null) {
				TargetPlatformHelper helper = new TargetPlatformHelper();
				ITargetDefinition targetCopy = s.newTarget();
				ITargetDefinition targetSource = getTargetDefinition(handle);
				if (targetSource == null) {
					return null;
				}
				s.copyTargetDefinition(targetSource, targetCopy);
				targetCopy.setName(copyName);
				helper.setTarget(targetCopy);
				return helper;
			}
		} catch (CoreException e) {
			RcpttPlugin.log(e);
		}
		return null;
	}
}
