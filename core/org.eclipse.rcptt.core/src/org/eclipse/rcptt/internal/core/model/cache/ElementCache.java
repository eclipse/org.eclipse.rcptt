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
package org.eclipse.rcptt.internal.core.model.cache;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.internal.core.model.Openable;

public class ElementCache extends OverflowingLRUCache {
	private IQ7Element spaceLimitParent = null;

	public ElementCache(int size) {
		super(size);
	}

	public ElementCache(int size, int overflow) {
		super(size, overflow);
	}

	@Override
	protected boolean close(Object key, Object value) {
		// System.out.println("ElementCache.close(" + key + ", " + value + ")");
		Openable element = (Openable) key;
		try {
			if (!element.canBeRemovedFromCache()) {
				return false;
			} else {
				// We must close an entire external folder of zip.
				element.close();
				return true;
			}
		} catch (ModelException npe) {
			return false;
		}
	}

	public void ensureSpaceLimit(int childrenSize, IQ7Element parent) {
		// ensure the children can be put without closing other elements
		int spaceNeeded = 1 + (int) ((1 + fLoadFactor) * (childrenSize + fOverflow));
		if (fSpaceLimit < spaceNeeded) {
			// parent is being opened with more children than the space limit
			shrink(); // remove overflow
			setSpaceLimit(spaceNeeded);
			this.spaceLimitParent = parent;
		}
	}

	@Override
	protected LRUCache newInstance(int size, int overflow) {
		return new ElementCache(size, overflow);
	}

	public void resetSpaceLimit(int defaultLimit, IQ7Element parent) {
		if (parent.equals(this.spaceLimitParent)) {
			setSpaceLimit(defaultLimit);
			this.spaceLimitParent = null;
		}
	}

	@Override
	public Object put(Object key, Object value) {
		// System.out.println("ElementCache.put(" + key + ", " + value + ")");
		return super.put(key, value);
	}

}
