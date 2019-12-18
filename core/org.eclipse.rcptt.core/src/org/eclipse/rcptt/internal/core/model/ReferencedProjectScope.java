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
package org.eclipse.rcptt.internal.core.model;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IPath;

import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.ISearchScope;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class ReferencedProjectScope implements ISearchScope {
	Set<IPath> paths = new HashSet<IPath>();

	public ReferencedProjectScope(IQ7Project q7Project) {
		calculatePaths(q7Project);
	}

	protected void calculatePaths(IQ7Project q7Project) {
		if (q7Project == null) {
			return;
		}
		Set<IQ7Project> projects = new HashSet<IQ7Project>();
		try {
			collectAllProjects(q7Project, projects);
		} catch (ModelException e) {
			RcpttPlugin.log(e);
		}
		for (IQ7Project iq7Project : projects) {
			paths.add(iq7Project.getPath());
		}
	}

	public IPath[] getPaths() {
		return (IPath[]) paths.toArray(new IPath[paths.size()]);
	}

	private void collectAllProjects(IQ7Project q7Project,
			Set<IQ7Project> projects) throws ModelException {
		if (projects.add(q7Project)) {
			for (IQ7Project ref : q7Project.getReferences()) {
				if (projects.add(ref)) {
					collectAllProjects(ref, projects);
				}
			}
		}
	}

	public boolean contains(IPath path) {
		for (IPath p : paths) {
			if (p.isPrefixOf(path)) {
				return true;
			}
		}
		return false;
	}

}
