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

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.internal.core.model.index.Index;

public class KeyQueryPattern implements ISearchPattern {

	private String documentName;
	private String key;

	public KeyQueryPattern(IPath path, String key) {
		this.documentName = path.removeFirstSegments(1).toString();
		this.key = key;
	}

	public void findIndexMatches(Index index, IProgressMonitor monitor,
			IIndexRequestor requestor) {
		Map<String, List<String>> query = index.query(documentName);
		List<String> name = query.get(key);
		if (name != null) {
			for (String n : name) {
				requestor.acceptMatch(null, key, n);
			}
		}
	}
}
