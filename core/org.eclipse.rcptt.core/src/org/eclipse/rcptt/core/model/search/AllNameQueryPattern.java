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
import org.eclipse.rcptt.core.model.search.SearchPattern.IKeyQuery;
import org.eclipse.rcptt.internal.core.model.index.Index;

public class AllNameQueryPattern implements ISearchPattern {
	public AllNameQueryPattern() {
	}

	public void findIndexMatches(Index index, IProgressMonitor monitor,
			final IIndexRequestor requestor) {
		index.query(new String[] { IQ7IndexConstants.NAME }, new IKeyQuery() {
			public boolean accept(String key, String value) {
				requestor.acceptMatch(null, IQ7IndexConstants.NAME, value);
				return true;
			}
		}, monitor);
	}
}
