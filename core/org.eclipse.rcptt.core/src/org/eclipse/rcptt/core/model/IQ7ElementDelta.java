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
package org.eclipse.rcptt.core.model;

import org.eclipse.core.resources.IResourceDelta;

public interface IQ7ElementDelta {

	public int ADDED = 1;

	public int REMOVED = 2;

	public int CHANGED = 4;

	/**
	 * Change flag indicating that the content of the element has changed. This
	 * flag is only valid for elements which correspond to files.
	 */
	public int F_CONTENT = 0x00001;

	public int F_MODIFIERS = 0x00002;

	public int F_CHILDREN = 0x00008;

	public int F_MOVED_FROM = 0x00010;

	public int F_MOVED_TO = 0x00020;

	public int F_REORDER = 0x00100;
	public int F_OPENED = 0x000200;
	public int F_CLOSED = 0x000400;

	public int F_FINE_GRAINED = 0x04000;
	public int F_WORKING_COPY = 0x10000;
	public int F_MARKERS = 0x20000;
	public int F_PRIMARY_RESOURCE = 0x040000;
	public int F_DESCRIPTION = 0x80000;

	public IQ7Element getElement();

	public IQ7ElementDelta[] getAddedChildren();

	public IQ7ElementDelta[] getAffectedChildren();

	public int getKind();

	public int getFlags();

	public IResourceDelta[] getResourceDeltas();

	public IQ7Element getMovedFromElement();

	public IQ7Element getMovedToElement();

	public IQ7NamedElement[] getNamedElements();

	public IQ7ElementDelta getChildBy(IQ7NamedElement e);
}
