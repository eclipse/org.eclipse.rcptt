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
package org.eclipse.rcptt.core.model.search;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.core.model.index.IQ7IndexConstants;
import org.eclipse.rcptt.internal.core.model.index.Index;

public class PathNameSearchPattern implements ISearchPattern {
	private String path;

	public PathNameSearchPattern(String path) {
		this.path = path;
	}

	public void findIndexMatches(Index index, IProgressMonitor monitor,
			IIndexRequestor requestor) {
		String name = index.queryName(path);
		if (name != null) {
			requestor.acceptMatch(null, IQ7IndexConstants.NAME, name);
		}
	}
}
