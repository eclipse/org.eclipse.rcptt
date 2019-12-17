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
package org.eclipse.rcptt.search;

import static org.eclipse.search.ui.text.FileTextSearchScope.newSearchScope;
import static org.eclipse.search.ui.text.FileTextSearchScope.newWorkspaceScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.text.FileTextSearchScope;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.search.Q7SearchPageImpl.Q7SearchPageInput;
import org.eclipse.rcptt.ui.launching.LaunchUtils;

public class ShowDependenciesAction extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IResource[] resources = LaunchUtils.getContext(HandlerUtil
				.getCurrentSelection(event));
		if (resources.length == 1 && resources[0] instanceof IFile) {
			IQ7NamedElement element = (IQ7NamedElement) RcpttCore
					.create(resources[0]);
			try {
				int searchType;
				String[] extensions;
				if (element instanceof IContext) {
					searchType = Q7SearchQuery.CONTEXTS_BY_ID;
					extensions = Q7SearchPageImpl.Q7_SCENARIO_EXTS;
				} else if (element instanceof IVerification) {
					searchType = Q7SearchQuery.VERIFICATION_BY_ID;
					extensions = Q7SearchPageImpl.Q7_SCENARIO_EXTS;
				} else {
					searchType = Q7SearchQuery.TESTCASE_BY_ID;
					extensions = Q7SearchPageImpl.Q7_TESTSUITE_EXTS;
				}

				Q7SearchPageInput input = new Q7SearchPageInput(
						element.getID(), true, false, getSearchScope(
								resources[0], extensions), searchType);
				Q7SearchQueryProvider searchProvider = new Q7SearchQueryProvider();
				ISearchQuery searchQuery = searchProvider.createQuery(input);
				((Q7SearchQuery) searchQuery).setQ7ElementName(element
						.getElementName());
				NewSearchUI.runQueryInBackground(searchQuery);
			} catch (ModelException e) {
				Q7UIPlugin.log(e);
			}

		}
		return null;
	}

	private FileTextSearchScope getSearchScope(IResource resource,
			String[] extensions) {
		List<IProject> result = new ArrayList<IProject>();
		IProject project = resource.getProject();
		result.add(project);
		result.addAll(Arrays.asList(project.getReferencingProjects()));
		if (result.size() == ResourcesPlugin.getWorkspace().getRoot()
				.getProjects().length) {
			return newWorkspaceScope(extensions, false);
		}
		return newSearchScope(result.toArray(new IResource[0]), extensions,
				false);
	}
}
