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

import org.eclipse.core.runtime.IPath;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.index.IIndexDocument;

public class IndexDocument implements IIndexDocument {

	private String path;
	private IQ7NamedElement element;
	private Index index;

	public IndexDocument(IQ7NamedElement element,
			Index index) {
		this.element = element;
		this.path = element.getPath().removeFirstSegments(1).toString();
		this.index = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcptt.internal.core.model.index.IIndexDocument#
	 * getContainerRelativePath()
	 */
	public String getContainerRelativePath() {
		return path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcptt.internal.core.model.index.IIndexDocument#getElement()
	 */
	public IQ7NamedElement getElement() {
		return element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.rcptt.internal.core.model.index.IIndexDocument#addKey(java.lang
	 * .String, java.lang.String)
	 */
	public void addKey(String key, String value) {
		index.addKey(path, key, value);
	}

	public void updateModificationStamp(long stamp) {
		index.updateModificationstamp(path, stamp);
	}

	public Index getIndex() {
		return index;
	}

	public void remove() {
		index.remove(path);
	}
}
