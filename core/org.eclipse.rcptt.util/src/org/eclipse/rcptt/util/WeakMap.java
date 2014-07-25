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
package org.eclipse.rcptt.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.WeakHashMap;

/**
 * WeakHashMap with weak values. Used for storing back references
 * 
 * @author Ivan Inozemtsev
 * 
 */
public class WeakMap<K, V> {
	private WeakHashMap<K, WeakReference<V>> map = new WeakHashMap<K, WeakReference<V>>();

	public void put(K key, V val) {
		map.put(key, new WeakReference<V>(val));
	}

	public V get(K key) {
		WeakReference<V> reference = map.get(key);
		if (reference == null) {
			return null;
		}
		return reference.get();

	}

	public int size() {
		return map.size();
	}

	public Collection<V> values() {
		List<V> result = new ArrayList<V>();
		for (WeakReference<V> ref : map.values()) {
			if (ref.isEnqueued()) {
				// to distinguish removed entries from actual null values
				continue;
			}
			result.add(ref.get());
		}
		return result;
	}

}
