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
		if (val == null) {
			throw new IllegalArgumentException("Not supposed to contain null values");
		}
		synchronized (map) {
			map.put(key, new WeakReference<V>(val));
		}

	}

	public V get(K key) {
		WeakReference<V> reference = null;
		synchronized (map) {
			reference = map.get(key);
		}
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
		List<WeakReference<V>> values;
		synchronized (map) {
			values = new ArrayList<WeakReference<V>>(map.values());
		}
		for (WeakReference<V> ref : values) {
			V val = ref.get();
			if (val == null) {
				continue;
			}
			result.add(val);
		}
		return result;
	}

}
