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
package org.eclipse.rcptt.util;

import org.eclipse.core.runtime.Platform;

public class PrefixScheme implements FileSystemResolver.Scheme {

	public static final String AUT = "aut://";
	public static final String WORKSPACE = "workspace://";
	public static final String FILE = "file://";
	public static final String HOME = "home://";

	private final String prefix;
	private final String root;

	public PrefixScheme(String prefix, String root) {
		this.prefix = prefix;
		this.root = root != null ? FileSystemResolver.normalizeSlashes(root)
				: "";
	}

	public String getPrefix() {
		return prefix;
	}

	public String resolve(String path) {
		String unprefixed = FileSystemResolver.unprefix(prefix, path);
		if (unprefixed == null)
			return null;

		return root + FileSystemResolver.normalizeSlashes(unprefixed);
	}

	public String make(String path) {
		path = FileSystemResolver.normalizeSlashes(path);

		String workingRoot = root;
		String workingPath = path;
		if (Platform.getOS().equals(Platform.OS_WIN32)) {
			workingPath = path.toLowerCase();

			// that may be done once in constructor, but I would like to respect
			// user input casing
			workingRoot = root.toLowerCase();
		}

		if (!workingPath.startsWith(workingRoot))
			return null;

		path = path.substring(root.length());
		return prefix + path;
	}

}
