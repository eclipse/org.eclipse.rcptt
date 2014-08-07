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
package org.eclipse.rcptt.launching.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.utils.SortingUtils;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.AutStatusConstants;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;

public class TestSuiteUtils {

	public static IQ7NamedElement[] getElements(ILaunchConfiguration config) throws CoreException {
		return getElements(config, false);
	}

	public static IQ7NamedElement[] getElements(ILaunchConfiguration config, boolean excludeNonExistent)
			throws CoreException {
		boolean includeContext = config.getAttribute(
				IQ7Launch.ATTR_INCLUDE_CONTEXT, false);
		boolean noSort = config.getAttribute(IQ7Launch.ATTR_NO_SORT, false);
		IResource[] mappedResources = config.getMappedResources();

		int resources = config.getAttribute(IQ7Launch.EXEC_RESOURCES, -1);
		if (resources > 0) {

			List<IResource> result = new ArrayList<IResource>();
			for (int i = 0; i < resources; i++) {
				IResource resource = mappedResources[i];
				if (!resource.exists() || !resource.getProject().isOpen()) {
					continue;
				}
				result.add(resource);
			}
			return getElements(result.toArray(new IResource[result.size()]), !includeContext, !noSort);
		}
		return getElements(config.getMappedResources(), !includeContext,
				!noSort);
	}

	public static IQ7NamedElement[] getElements(IResource[] resources,
			boolean filterContext, boolean sort) {
		List<IQ7NamedElement> elements = new ArrayList<IQ7NamedElement>();
		Set<IResource> checked = new HashSet<IResource>();
		if (resources != null) {
			for (IResource resource : resources) {
				collect(resource, elements, checked, filterContext);
			}
			if (sort) {
				SortingUtils.sortNamedElements(elements);
			}
		}
		return elements.toArray(new IQ7NamedElement[elements.size()]);
	}

	public static IQ7NamedElement[] getElements(IResource[] resources,
			boolean filterContext) {
		return getElements(resources, filterContext, true);
	}

	private static void collect(IResource resource,
			List<IQ7NamedElement> elements, Set<IResource> checked,
			boolean filterContext) {
		if (checked.contains(resource))
			return;
		checked.add(resource);
		try {
			if (resource instanceof IFile) {
				IQ7NamedElement element = (IQ7NamedElement) RcpttCore
						.create(resource);
				if (element != null
						&& (!filterContext || element instanceof ITestCase || element instanceof ITestSuite)) {
					elements.add(element);
				}
			} else if (resource instanceof IContainer
					&& !(resource instanceof IProject && !((IProject) resource)
							.isOpen())) {
				IResource[] members = ((IContainer) resource).members();
				for (IResource member : members) {
					collect(member, elements, checked, filterContext);
				}
			}
		} catch (Exception e) {
			RcpttPlugin.log(e);
		}
	}

	public static Report generateFailedReport(ITestCase element,
			String errorMessage) throws ModelException {
		Report report = ReportFactory.eINSTANCE.createReport();
		Node root = ReportFactory.eINSTANCE.createNode();
		root.setName(element.getID());
		report.setRoot(root);
		Q7Info q7info = ReportingFactory.eINSTANCE.createQ7Info();
		q7info.setId(element.getID());
		q7info.setMessage(errorMessage);
		q7info.setResult(ResultStatus.FAIL);
		q7info.setType(ItemKind.TESTCASE);
		root.getProperties().put(IQ7ReportConstants.ROOT, q7info);
		root.setName(element.getElementName());
		Q7Info scenario = EcoreUtil.copy(q7info);
		scenario.setType(ItemKind.SCRIPT);
		Node scenarioNode = ReportFactory.eINSTANCE.createNode();
		scenarioNode.setName(root.getName());
		scenarioNode.getProperties().put(IQ7ReportConstants.ROOT, scenario);
		root.getChildren().add(scenarioNode);

		return report;
	}

	public static AutLaunch SelectAUT() throws CoreException {
		Status status = new Status(Status.ERROR, Q7LaunchingPlugin.PLUGIN_ID,
				AutStatusConstants.SELECT_AUT_CODE, "", null);
		IStatusHandler handler = DebugPlugin.getDefault().getStatusHandler(
				status);
		if (handler != null)
			return (AutLaunch) handler.handleStatus(status, null);
		else
			return null;
	}
}
