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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileSystemResolver {

	public static interface Scheme {
		/**
		 * @return scheme prefix, "file:" or "workspace:" for example
		 */
		public String getPrefix();

		/**
		 * Resolves the path to absolute path
		 * 
		 * @return resolved path or null if cannot resolve
		 */
		public String resolve(String path);

		/**
		 * Makes scheme-relative path from absolute path
		 * 
		 * @return scheme-relative path or null if cannot make it
		 */
		public String make(String path);
	}

	private Map<String, Scheme> registry = new HashMap<String, Scheme>();

	public static String unprefix(String prefix, String value) {
		return value.startsWith(prefix) ? value.substring(prefix.length())
				: null;
	}

	public static String normalizeSlashes(String path) {
		path = path.replace('\\', '/');
		if (path.length() > 0 && !path.endsWith("/"))
			path += "/";

		return path;
	}

	public void register(Scheme scheme) {
		registry.put(scheme.getPrefix(), scheme);
	}

	public String resolve(String path) {
		// TODO: no need to iterate here, do map lookup instead

		for (Scheme s : registry.values()) {
			String result = s.resolve(path);
			if (result != null)
				return result;
		}

		// try to fix file:// w/o file://
		if (path.indexOf(':') < 2)
			return path; // lets pretend it just a raw path

		return null;
	}
	
	public boolean isDirectory(String path) {
		if (path != null) { 
			String resolvedPath = resolve(path);
			if (resolvedPath != null) {			
				try {
					File file = new File(resolvedPath);
					return file.isDirectory();
				} catch (SecurityException ex) {
					return false;
				}
			}
		}
		return false;
	}
	
	public String make(String path) {
		String best = null;
		int bestLength = 0;

		for (Scheme s : registry.values()) {
			String result = s.make(path);
			if (result == null)
				continue;

			// okay, lets pick the best one, I mean shortest
			String candidate = unprefix(s.getPrefix(), result);
			if (best == null || candidate.length() < bestLength) {
				best = result;
				bestLength = candidate.length();
			}
		}

		return best;
	}
}
