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
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.index.Index;
import org.eclipse.rcptt.internal.core.model.index.QueryResult;

public abstract class SearchPattern implements ISearchPattern {
	public static interface IKeyQuery {
		boolean accept(String key, String value);
	}

	// private static final int N_THREADS = 8;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.rcptt.core.model.search.ISearchPattern#findIndexMatches(com.xored
	 * .q7.internal.core.model.index.Index,
	 * org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.rcptt.core.model.search.IIndexRequestor)
	 */
	public void findIndexMatches(Index index, IProgressMonitor monitor,
			final IIndexRequestor requestor) {
		if (monitor != null && monitor.isCanceled())
			throw new OperationCanceledException();
		// ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);
		final List<QueryResult> results = index.query(getKeys(), getPattern(),
				monitor);
		final IPath path = index.getPath();
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		for (final QueryResult queryResult : results) {
			// executor.execute(new Runnable() {
			// public void run() {
			Path fullPath = new Path(queryResult.path);
			IQ7Element q7Element = RcpttCore.create(root.findMember(path
					.append(fullPath)));
			synchronized (requestor) {
				requestor.acceptMatch(q7Element, queryResult.key,
						queryResult.value);
			}
			// }
			// });
		}
		// executor.shutdown();
		// while (!executor.isTerminated()) {
		// try {
		// Thread.sleep(50);
		// } catch (Throwable e) {
		// ignore
		// }
		// }

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcptt.core.model.search.ISearchPattern#getPattern()
	 */
	public abstract IKeyQuery getPattern();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcptt.core.model.search.ISearchPattern#getKeys()
	 */
	public abstract String[] getKeys();
}
