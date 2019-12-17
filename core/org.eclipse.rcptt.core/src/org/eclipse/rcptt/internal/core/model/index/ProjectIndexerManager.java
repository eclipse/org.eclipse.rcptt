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
package org.eclipse.rcptt.internal.core.model.index;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class ProjectIndexerManager {
	private static Q7ProjectIndexer indexer = new Q7ProjectIndexer();

	public static void indexProject(IProject res) {
		IQ7Project prj = RcpttCore.create(res);
		if (prj.exists()) {
			indexer.indexProject(prj);
		}
	}

	public static void removeProject(IPath projectPath) {
		indexer.removeProject(projectPath);
	}

	public static void indexProject(IQ7Project q7Project) {
		indexer.indexProject(q7Project);
	}

	public static boolean isIndexerEnabled(IProject project) {
		return true;
	}

	public static void indexNamedElement(IQ7NamedElement element) {
		indexer.indexNamedElement(element);
	}

	public static void removeNamedElement(IQ7Project project, String path) {
		indexer.removeNamedElement(project, path);
	}

	public static void startIndexing() {
		boolean wantRefresh = indexer.wantRefreshOnStart();
		if (wantRefresh) {
			final IQ7Project[] projects;
			try {
				projects = RcpttCore.create(
						ResourcesPlugin.getWorkspace().getRoot()).getProjects();
			} catch (Exception e) {
				RcpttPlugin.log(e);
				return;
			}
			for (int i = 0; i < projects.length; ++i) {
				final IQ7Project project = projects[i];
				indexer.indexProject(project);
			}
		}
	}

	public static void indexNamedElements(Collection<IQ7NamedElement> toIndex) {
		indexer.indexNamedElements(toIndex);
	}
}
