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
package org.eclipse.rcptt.internal.core.model.cache;

import java.util.Enumeration;

@SuppressWarnings("rawtypes")
public class LRUCacheEnumerator implements Enumeration {

	protected LRUEnumeratorElement fElementQueue;

	public static class LRUEnumeratorElement {

		public Object fValue;

		public LRUEnumeratorElement fNext;

		public LRUEnumeratorElement(Object value) {
			fValue = value;
		}
	}

	public LRUCacheEnumerator(LRUEnumeratorElement firstElement) {
		fElementQueue = firstElement;
	}

	public boolean hasMoreElements() {
		return fElementQueue != null;
	}

	public Object nextElement() {
		Object temp = fElementQueue.fValue;
		fElementQueue = fElementQueue.fNext;
		return temp;
	}
}
