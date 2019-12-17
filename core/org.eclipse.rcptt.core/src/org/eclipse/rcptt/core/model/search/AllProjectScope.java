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
package org.eclipse.rcptt.core.model.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;

import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.core.model.ModelManager;

public class AllProjectScope implements ISearchScope {
	private IPath[] paths = null;

	public IPath[] getPaths() {
		if (paths == null) {
			List<IPath> result = new ArrayList<IPath>();
			IQ7Project[] projects;
			try {
				projects = ModelManager.getModelManager().getModel()
						.getProjects();
				for (IQ7Project iq7Project : projects) {
					result.add(iq7Project.getPath());
				}
			} catch (ModelException e) {
				RcpttPlugin.log(e);
			}
			paths = (IPath[]) result.toArray(new IPath[result.size()]);
		}
		return paths;
	}

	public boolean contains(IPath path) {
		getPaths();
		for (IPath p : paths) {
			if (p.isPrefixOf(path)) {
				return true;
			}
		}
		return false;
	}
}
