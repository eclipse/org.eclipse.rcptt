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

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.core.model.index.IQ7IndexConstants;
import org.eclipse.rcptt.internal.core.model.index.Index;

public class PathIDSearchPattern implements ISearchPattern {
	private String path;

	public PathIDSearchPattern(String path) {
		this.path = path;
	}

	public void findIndexMatches(Index index, IProgressMonitor monitor,
			IIndexRequestor requestor) {
		String name = index.queryID(path);
		if (name != null) {
			requestor.acceptMatch(null, IQ7IndexConstants.NAME, name);
		}
	}
}
