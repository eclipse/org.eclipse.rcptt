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
package org.eclipse.rcptt.core.model.search;

import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.index.Index;
import org.eclipse.rcptt.internal.core.model.index.QueryResult;

public class IDSearchPattern implements ISearchPattern {
	private String id;

	public IDSearchPattern(String id) {
		this.id = id;
	}

	public void findIndexMatches(Index index, IProgressMonitor monitor,
			IIndexRequestor requestor) {
		List<QueryResult> results = index.queryIDs(id);
		final IPath path = index.getPath();
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		for (final QueryResult queryResult : results) {
			Path fullPath = new Path(queryResult.path);
			IQ7Element q7Element = RcpttCore.create(root.findMember(path
					.append(fullPath)));
			requestor
					.acceptMatch(q7Element, queryResult.key, queryResult.value);
		}
	}
}
