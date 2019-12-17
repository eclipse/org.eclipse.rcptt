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
package org.eclipse.rcptt.core.workspace;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class WorkspaceFinder implements IWorkspaceFinder {
	private WorkspaceFinder() {
	}

	private static WorkspaceFinder instance = null;

	public static WorkspaceFinder getInstance() {
		if (instance == null) {
			instance = new WorkspaceFinder();
		}
		return instance;
	}

	public IContext[] findContext(IQ7NamedElement dependant, String id) {
		IQ7NamedElement[] elements = findNamedElements(dependant, id);
		List<IContext> result = new ArrayList<IContext>();
		for (IQ7NamedElement e : elements) {
			if (e instanceof IContext) {
				result.add((IContext) e);
			}
		}
		if (result.size() != 0) {
			return result.toArray(new IContext[result.size()]);
		}
		return null;
	}

	public ITestCase[] findTestcase(IQ7NamedElement dependant, String id) {
		IQ7NamedElement[] elements = findNamedElements(dependant, id);
		List<ITestCase> result = new ArrayList<ITestCase>();
		for (IQ7NamedElement e : elements) {
			if (e instanceof ITestCase) {
				result.add((ITestCase) e);
			}
		}
		if (result.size() != 0) {
			return result.toArray(new ITestCase[result.size()]);
		}
		return null;
	}

	public ITestSuite[] findTestsuites(IQ7NamedElement dependant, String id) {
		IQ7NamedElement[] elements = findNamedElements(dependant, id);
		List<ITestSuite> result = new ArrayList<ITestSuite>();
		for (IQ7NamedElement e : elements) {
			if (e instanceof ITestSuite) {
				result.add((ITestSuite) e);
			}
		}
		if (result.size() != 0) {
			return result.toArray(new ITestSuite[result.size()]);
		}
		return null;
	}

	public IQ7NamedElement[] findNamedElements(IQ7NamedElement dependant,
			String id) {
		if (dependant == null) {
			IProject[] q7Projects = RcpttCore.getQ7Projects();
			for (IProject iProject : q7Projects) {
				IQ7Project project = RcpttCore.create(iProject);
				try {
					IQ7NamedElement[] tests = project.findNamedElement(id);
					if (tests != null && tests.length > 0) {
						return tests;
					}
				} catch (ModelException e) {
					RcpttPlugin.log(e);
				}
			}
			return null;
		}
		IQ7Project project = dependant.getQ7Project();
		try {
			return project.findNamedElement(id);
		} catch (ModelException e) {
			RcpttPlugin.log(e);
		}
		return null;
	}

	public IVerification[] findVerification(IQ7NamedElement dependant, String id) {
		IQ7NamedElement[] elements = findNamedElements(dependant, id);
		List<IVerification> result = new ArrayList<IVerification>();
		for (IQ7NamedElement e : elements) {
			if (e instanceof IVerification) {
				result.add((IVerification) e);
			}
		}
		if (result.size() != 0) {
			return result.toArray(new IVerification[result.size()]);
		}
		return null;
	}

}
