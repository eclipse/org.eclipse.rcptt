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
package org.eclipse.rcptt.ui.builder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.ISearchScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;
import org.eclipse.rcptt.core.workspace.RcpttCore;

public class NamedElementReferencesResolver {
	public static Map<IProject, Set<IQ7NamedElement>> resolveMissingReferences(
			IQ7NamedElement element) throws ModelException {
		Map<IProject, Set<IQ7NamedElement>> missing = new HashMap<IProject, Set<IQ7NamedElement>>();
		if (element == null) {
			return missing;
		}
		IFile file = (IFile) element.getResource();
		if (file == null) {
			return missing;
		}
		IProject project = file.getProject();
		if (!project.exists() || !project.isOpen()) {
			return missing;
		}
		IQ7Project q7Project = RcpttCore.create(project);
		resolveReferences(element, q7Project, missing);
		IProject[] referenced = null;
		try {
			referenced = project.getReferencedProjects();
		} catch (CoreException e) {
			// At this point we sure project exists and it is opened.
			// Exception cannot happen. So ignore it.
		}
		for (IProject p : referenced) {
			if (missing.containsKey(p)) {
				missing.remove(p);
			}
		}
		return missing;
	}

	private static void resolveReferences(IQ7NamedElement element,
			IQ7Project current, Map<IProject, Set<IQ7NamedElement>> references)
			throws ModelException {
		if (element instanceof ITestCase) {
			String[] contexts = ((ITestCase) element).getContexts();
			for (String contextId : contexts) {
				resolveElementReferences(contextId, current, references);
			}

			String[] verifications = ((ITestCase) element).getVerifications();
			for (String verificationId : verifications) {
				resolveElementReferences(verificationId, current, references);
			}
		} else if (element instanceof IContext) {
			for (String contextId : RcpttCore.getInstance().getContextReferences((IContext) element)) {
				resolveElementReferences(contextId, current, references);
			}
		} else if (element instanceof ITestSuite) {
			TestSuiteItem[] items = ((ITestSuite) element).getItems();
			for (TestSuiteItem item : items) {
				resolveElementReferences(item.getNamedElementId(), current,
						references);
			}
		}
	}

	private static void resolveElementReferences(String elementId,
			IQ7Project current, Map<IProject, Set<IQ7NamedElement>> references)
			throws ModelException {
		if (current.findNamedElement(elementId).length != 0) {
			return;
		}

		for (final IProject p : RcpttCore.getQ7Projects()) {
			IQ7NamedElement[] elements = Q7SearchCore.findById(elementId,
					new ISearchScope() {
						@Override
						public IPath[] getPaths() {
							return new IPath[] { p.getFullPath() };
						}

						@Override
						public boolean contains(IPath path) {
							return false;
						}
					}, new NullProgressMonitor());
			if (elements != null) {
				for (IQ7NamedElement iq7NamedElement : elements) {
					Set<IQ7NamedElement> set = references.get(p);
					if (set == null) {
						set = new HashSet<IQ7NamedElement>();
					}
					IResource resource = iq7NamedElement.getResource();
					if (resource.isAccessible()) {
						IProject project = resource.getProject();
						set.add(iq7NamedElement);
						references.put(project, set);
						break;
					}
				}
			}
		}
	}

	private NamedElementReferencesResolver() {
	}
}
