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
package org.eclipse.rcptt.internal.core.model.index;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;

import org.eclipse.rcptt.internal.core.jobs.JobManager;

public class IndexManager extends JobManager {
	private Map<IPath, Index> indexes = new HashMap<IPath, Index>();

	@Override
	public String processName() {
		return "Q7 Indexer";
	}

	public Index getIndex(IPath fullPath) {
		if (indexes.containsKey(fullPath)) {
			return indexes.get(fullPath);
		}
		Index index = new Index(fullPath);
		try {
			index.load();
		} catch (Throwable e) {
			index.dispose(); // Clean index file
		}
		indexes.put(fullPath, index);
		return index;
	}

	public void removeIndex(IPath path) {
		Index index = getIndex(path);
		index.dispose();
		indexes.remove(path);
	}
}
