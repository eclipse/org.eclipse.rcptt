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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.core.model.index.IIndexer;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class IndexerManager {
	private List<IIndexer> indexers = null;
	private static IndexerManager instance = null;

	private IndexerManager() {
	}

	private synchronized void initialize() {
		if (indexers != null) {
			return;
		}
		indexers = new ArrayList<IIndexer>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(RcpttPlugin.PLUGIN_ID + ".indexer");
		for (IConfigurationElement cfg : elements) {
			IIndexer provider;
			try {
				provider = (IIndexer) cfg.createExecutableExtension("class");
				indexers.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public IIndexer[] getIndexers() {
		initialize();
		return indexers.toArray(new IIndexer[indexers.size()]);
	}

	public synchronized static IndexerManager getInstance() {
		if (instance == null) {
			instance = new IndexerManager();
		}
		return instance;
	}
}
