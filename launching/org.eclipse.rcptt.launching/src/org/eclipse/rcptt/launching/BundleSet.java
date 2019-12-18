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
package org.eclipse.rcptt.launching;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BundleSet {

	private HashMap<String, Boolean> bundles; // true means it is a wildcard,
												// false -- it is not

	public BundleSet(Collection<String> bundles) {
		this.bundles = new HashMap<String, Boolean>();
		for (String bundle : bundles) {
			add(bundle);
		}
	}

	private void add(String bundle) {
		if (bundle.endsWith("*"))
			bundles.put(bundle.replace(".", "\\.").replace("*", ".*"), true);
		else
			bundles.put(bundle, false);
	}

	public boolean contains(String bundle) {
		for (Map.Entry<String, Boolean> e : bundles.entrySet()) {
			if (e.getValue()) {
				// regex pattern
				if (bundle.matches(e.getKey()))
					return true;
			} else {
				// not a pattern
				if (bundle.equals(e.getKey()))
					return true;
			}
		}

		return false;
	}

	public boolean isEmpty() {
		return bundles.isEmpty();
	}

	public static final BundleSet ALL = new BundleSet(Arrays.<String> asList()) {
		public boolean contains(String bundle) {
			return true;
		};
	};
}
