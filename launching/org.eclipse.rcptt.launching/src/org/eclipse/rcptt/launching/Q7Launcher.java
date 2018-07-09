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
package org.eclipse.rcptt.launching;

import static org.eclipse.rcptt.launching.utils.TestSuiteUtils.getElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.workspace.IWorkspaceFinder;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.launching.Q7LaunchManager;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.internal.launching.Q7TestLaunch;

import com.google.common.base.Joiner;

public class Q7Launcher {

	private static Q7Launcher instance = new Q7Launcher();

	public static final int DEFAULT_LAUNCH_TIMEOUT = 5 * 60;

	private Map<ILaunchConfiguration, LaunchData> launchData = new HashMap<ILaunchConfiguration, LaunchData>();

	public static class LaunchData {
		public IQ7NamedElement elements[];
		public IWorkspaceFinder finder;
	}

	public static Q7Launcher getInstance() {
		if (instance == null) {
			instance = new Q7Launcher();
		}
		return instance;
	}

	private Q7Launcher() {
	}

	public void addListener(final ILaunchListener listener) {
		getManager().addListener(listener);
	}

	public void removeListener(final ILaunchListener listener) {
		getManager().removeListener(listener);
	}

	public boolean isRunned() {
		return getManager().isRunning();
	}

	public void stop(IStatus result) {
		getManager().stop(result);
	}

	public IExecutionSession execute(final IQ7NamedElement[] elements, Aut aut,
			String name) throws CoreException {
		return execute(elements, aut, name, null);
	}

	public IExecutionSession execute(final IQ7NamedElement[] elements, Aut aut,
			final String name, final IWorkspaceFinder finder)
			throws CoreException {
		ILaunchConfiguration config = getLaunchConfiguration(elements, aut);
		LaunchData data = new LaunchData();
		data.elements = elements;
		data.finder = finder;
		launchData.put(config, data);
		try {
			Q7TestLaunch launch = (Q7TestLaunch) config.launch(
					ILaunchManager.RUN_MODE, new NullProgressMonitor());
			return launch.setSession(null);
		} finally {
			launchData.remove(config);
		}
	}

	public int getMaxHistoryEntries() {
		return getManager().getMaxHistoryEntries();
	}

	public IExecutionSession[] getExecutionSessions() {
		return getManager().getExecutionSessions();
	}

	public boolean removeExecutionSession(final IExecutionSession session) {
		return getManager().removeExecutionSession(session);
	}

	public void setMaxHistoryEntries(final int maxEntries) {
		getManager().setMaxHistoryEntries(maxEntries);
	}

	public static ILaunchConfiguration getLaunchConfiguration(
			IQ7NamedElement[] elements, Aut aut) throws CoreException {
		return getLaunchConfiguration(elements, aut, null, true, null);
	}

	private static void setMappedResources(ILaunchConfigurationWorkingCopy temporary,
			IQ7NamedElement[] elements) throws CoreException {
		if (elements.length > 0 && elements[0].getQ7Project() != null) {
			List<IResource> resources = elementsToResources(elements);

			List<IResource> extras = elementsToResources(collectReferences(
					elements, null, null));
			int resourcesToExec = resources.size();
			resources.addAll(extras);
			temporary.setAttribute(IQ7Launch.EXEC_RESOURCES, resourcesToExec);

			temporary.setMappedResources(resources
					.toArray(new IResource[resources.size()]));
		}
	}

	private static void setMappedResources(ILaunchConfigurationWorkingCopy temporary,
			IQ7NamedElement[] elements, String capability) throws CoreException {
		if (elements.length > 0 && elements[0].getQ7Project() != null) {
			List<IResource> resources = elementsToResources(elements);

			List<IResource> extras = elementsToResources(collectReferences(elements, null, capability));
			int resourcesToExec = resources.size();
			resources.addAll(extras);
			temporary.setAttribute(IQ7Launch.EXEC_RESOURCES, resourcesToExec);

			temporary.setMappedResources(resources
					.toArray(new IResource[resources.size()]));
		}
	}

	public static void setMappedResources(ILaunchConfiguration config,
			IQ7NamedElement[] elements) throws CoreException {
		ILaunchConfigurationWorkingCopy temporary = config.getWorkingCopy();
		setMappedResources(temporary, elements);
		temporary.doSave();
	}

	public static void setMappedResources(ILaunchConfiguration config,
			IQ7NamedElement[] elements, String capability) throws CoreException {
		ILaunchConfigurationWorkingCopy temporary = config.getWorkingCopy();
		setMappedResources(temporary, elements, capability);
		temporary.doSave();
	}

	public static ILaunchConfiguration getLaunchConfiguration(
			IQ7NamedElement[] elements, Aut aut, String name, boolean sort,
			Map<String, List<List<String>>> variants) throws CoreException {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();

		ILaunchConfigurationType configType = manager
				.getLaunchConfigurationType(IQ7Launch.ID_TYPE);
		if (name == null) {
			name = getLaunchName(elements);
		}

		boolean includeContexts = !hasScenarios(elements);

		ILaunchConfigurationWorkingCopy temporary = configType.newInstance(
				null, manager.generateLaunchConfigurationName(name));
		temporary.setAttribute(IQ7Launch.ATTR_INCLUDE_CONTEXT, includeContexts);
		if (aut != null)
			temporary.setAttribute(IQ7Launch.ATTR_AUT_NAME, aut.getName());
		temporary.setAttribute(IQ7Launch.ATTR_NO_SORT, !sort);
		if (variants != null && variants.size() > 0) {
			Map<String, String> strVariants = new HashMap<String, String>();
			for (Map.Entry<String, List<List<String>>> e : variants.entrySet()) {
				StringBuilder sb = new StringBuilder();
				List<List<String>> variantNames = e.getValue();
				for (int i = 0; i < variantNames.size(); i++) {
					sb.append(Joiner.on(IQ7Launch.VARIANT_NAME_SEPARATOR).join(variantNames.get(i)));
					if (i < variantNames.size() - 1)
						sb.append(IQ7Launch.VARIANTS_SEPARATOR);
				}
				strVariants.put(e.getKey(), sb.toString());
			}
			temporary.setAttribute(IQ7Launch.ATTR_VARIANTS, strVariants);
		}

		setMappedResources(temporary, elements);

		ILaunchConfiguration config = findExistingLaunchConfiguration(manager,
				temporary);

		if (config == null) {
			// no existing found: create a new one
			config = temporary.doSave();
		}
		return config;
	}

	/**
	 * Returns all named elements which are directly referenced from the given
	 * one. Thus, for test cases it returns its contexts, for tests suites it
	 * returns its tests, for group and super contexts returns its children.
	 *
	 * @param element
	 * @param resources
	 * @throws ModelException
	 */
	private static IQ7NamedElement[] findReferences(IQ7NamedElement element,
			IWorkspaceFinder finder, String capability) throws ModelException {
		if (element instanceof ITestSuite) {
			return Q7SearchCore.getTestSuiteContent((ITestSuite) element);
		}
		if (element instanceof ITestCase || element instanceof IContext) {
			return RcpttCore.getInstance().getContexts(element, finder, true, capability);
		}
		return new IQ7NamedElement[0];
	}

	private static IQ7NamedElement[] collectReferences(IQ7NamedElement[] elements, IWorkspaceFinder finder,
			String capability)
			throws ModelException {
		Set<IQ7NamedElement> result = new HashSet<IQ7NamedElement>();
		collectReferences(elements, result, new HashSet<IQ7NamedElement>(), finder, capability);
		return result.toArray(new IQ7NamedElement[result.size()]);
	}

	private static List<IResource> elementsToResources(
			IQ7NamedElement[] elements) {
		List<IResource> result = new ArrayList<IResource>();
		for (IQ7NamedElement element : elements) {
			if (element == null) {
				continue;
			}
			IResource resource = element.getResource();
			result.add(resource);
		}
		return result;
	}

	private static boolean hasScenarios(IQ7NamedElement[] elements) {
		return excludeNonScenarios(elements).length > 0;
	}

	private static IQ7NamedElement[] excludeNonScenarios(IQ7NamedElement[] elements) {
		List<IQ7NamedElement> result = new ArrayList<IQ7NamedElement>();
		for (IQ7NamedElement element : elements) {
			if (!(element instanceof IContext || element instanceof IVerification)) {
				result.add(element);
			}
		}
		return result.toArray(new IQ7NamedElement[result.size()]);
	}

	private static void collectReferences(IQ7NamedElement[] elements,
			Set<IQ7NamedElement> result, Set<IQ7NamedElement> traversed,
			IWorkspaceFinder finder, String capability) throws ModelException {
		for (IQ7NamedElement element : elements) {
			if (traversed.contains(element)) {
				continue;
			}
			traversed.add(element);
			IQ7NamedElement[] references = findReferences(element, finder, capability);
			result.addAll(Arrays.asList(references));
			collectReferences(references, result, traversed, finder, capability);
		}
	}

	public static String getLaunchName(IQ7NamedElement[] elements) {
		if (elements.length == 0) {
			return "Empty Test Suite";
		} else if (elements.length == 1) {
			try {
				return elements[0].getElementName();
			} catch (ModelException e) {
				return elements[0].getName();
			}
		} else {
			// Search common parent off all resource, if no common parent
			// return default name
			IPath commonPath = getCommonPath(elements);
			if (commonPath.segmentCount() > 0) {
				return commonPath.lastSegment();
			}
			return "Test Suite";
		}
	}

	public static int getLaunchTimeout() {
		final IEclipsePreferences preferences = Q7LaunchingPlugin
				.getPreferences();
		return preferences.getInt(Q7LaunchingPlugin.EXECUTION_TIMEOUT,
				DEFAULT_LAUNCH_TIMEOUT);
	}
	
	public static int getDebugTimeout() {
		return Integer.MAX_VALUE;
	}

	public static void setLaunchTimeout(final int timeout) {
		final IEclipsePreferences preferences = Q7LaunchingPlugin
				.getPreferences();
		preferences.putInt(Q7LaunchingPlugin.EXECUTION_TIMEOUT, timeout);
		try {
			preferences.flush();
		} catch (final Exception e) {
			Q7LaunchingPlugin.log(e);
		}
	}

	private static IPath getCommonPath(IQ7NamedElement[] elements) {
		IPath commonPath = elements[0].getPath().removeLastSegments(1);
		for (IQ7NamedElement element : elements) {
			IPath currentPath = element.getPath().removeLastSegments(1);
			for (int i = 0; i < commonPath.segmentCount(); i++) {
				if (i > currentPath.segmentCount()
						|| !commonPath.segment(i)
								.equals(currentPath.segment(i))) {
					commonPath = commonPath.removeLastSegments(commonPath
							.segmentCount() - i);
					if (commonPath.segmentCount() == 0) {
						return commonPath;
					}
				}
			}
		}
		return commonPath;
	}

	private static ILaunchConfiguration findExistingLaunchConfiguration(
			ILaunchManager manager, ILaunchConfigurationWorkingCopy temporary)
			throws CoreException {
		List<ILaunchConfiguration> candidateConfigs = findExistingLaunchConfigurations(
				manager, temporary);

		int candidateCount = candidateConfigs.size();
		if (candidateCount == 0) {
			return null;
		} else {
			ILaunchConfiguration result = candidateConfigs.get(0);

			// set AUT name for compatibility with old code
			ILaunchConfigurationWorkingCopy copy = result.getWorkingCopy();
			copy.setAttribute(IQ7Launch.ATTR_AUT_NAME,
					temporary.getAttribute(IQ7Launch.ATTR_AUT_NAME, ""));

			// Update variants, if found.
			copy.setAttribute(IQ7Launch.ATTR_VARIANTS, temporary.getAttribute(
					IQ7Launch.ATTR_VARIANTS, new HashMap<String, String>()));

			copy.doSave();

			return result;
		}
	}

	private static List<ILaunchConfiguration> findExistingLaunchConfigurations(
			ILaunchManager manager, ILaunchConfigurationWorkingCopy temporary)
			throws CoreException {
		ILaunchConfigurationType configType = temporary.getType();

		ILaunchConfiguration[] configs = manager
				.getLaunchConfigurations(configType);

		ArrayList<ILaunchConfiguration> candidateConfigs = new ArrayList<ILaunchConfiguration>(
				configs.length);
		for (int i = 0; i < configs.length; i++) {
			ILaunchConfiguration config = configs[i];
			if (hasSameAttributes(config, temporary)) {
				candidateConfigs.add(config);
			}
		}
		return candidateConfigs;
	}

	private static boolean hasSameAttributes(ILaunchConfiguration config1,
			ILaunchConfiguration config2) {
		try {
			boolean c1_includeContext = config1.getAttribute(
					IQ7Launch.ATTR_INCLUDE_CONTEXT, false);
			boolean c2_includeContext = config2.getAttribute(
					IQ7Launch.ATTR_INCLUDE_CONTEXT, false);
			if (c1_includeContext != c2_includeContext) {
				return false;
			}
			return Arrays.equals(getElements(config1, true), getElements(config2, true));
		} catch (CoreException e) {
			// ignore access problems here, return false
		}
		return false;
	}

	private Q7LaunchManager getManager() {
		return Q7LaunchManager.getInstance();
	}

	public LaunchData getRemoveLaunchData(ILaunchConfiguration config) {
		LaunchData data = launchData.get(config);
		launchData.remove(config);
		return data;
	}

}
