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
package org.eclipse.rcptt.internal.core.model.index;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.internal.core.model.index.IProjectIndexer.Internal;

public abstract class IndexRequest extends AbstractJob {
	private IProjectIndexer indexer;

	public IndexRequest(IProjectIndexer indexer) {
		this.indexer = indexer;
	}

	public IProjectIndexer.Internal getIndexer() {
		return (Internal) indexer;
	}

	protected String[] queryDocumentNames(final Index index) throws IOException {
		final ReadWriteMonitor monitor = index.monitor;
		monitor.enterRead();
		try {
			return index.queryDocumentNames();
		} finally {
			monitor.exitRead();
		}
	}

	protected Map<String, IQ7NamedElement> collectElementPaths(
			Collection<IQ7NamedElement> elements) {
		final Map<String, IQ7NamedElement> paths = new HashMap<String, IQ7NamedElement>();
		for (Iterator<IQ7NamedElement> i = elements.iterator(); i.hasNext();) {
			final IQ7NamedElement element = i.next();
			paths.put(element.getPath().removeFirstSegments(1).toString(),
					element);
		}
		return paths;
	}

	protected List<Object> checkChanges(Index index,
			Collection<IQ7NamedElement> elements, boolean clearOther)
			throws ModelException, IOException {
		final String[] documents = queryDocumentNames(index);
		if (documents != null && documents.length != 0) {
			final List<Object> changes = new ArrayList<Object>();
			final Map<String, IQ7NamedElement> elementPaths = collectElementPaths(elements);
			for (int i = 0; i < documents.length; i++) {
				final String document = documents[i];
				final IQ7NamedElement element = elementPaths.remove(document);
				if (element == null) {
					if (clearOther) {
						changes.add(document);
					}
				} else {
					// check file timestamps
					IResource resource = element.getResource();
					if (resource != null && resource.isAccessible()) {
						long stamp = resource.getModificationStamp();
						long documentStamp = index
								.getModificationStamp(document);
						if (stamp != documentStamp) {
							changes.add(element);
						}
					}
				}
			}

			if (!elementPaths.isEmpty()) {
				changes.addAll(elementPaths.values());
			}
			return changes;
		} else {
			return new ArrayList<Object>(elements);
		}
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indexer == null) ? 0 : indexer.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndexRequest other = (IndexRequest) obj;
		if (indexer == null) {
			if (other.indexer != null)
				return false;
		} else if (!indexer.equals(other.indexer))
			return false;
		return true;
	}
}
