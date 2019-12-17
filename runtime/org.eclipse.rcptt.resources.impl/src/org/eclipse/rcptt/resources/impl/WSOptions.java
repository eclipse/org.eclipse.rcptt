/*******************************************************************************
 * Copyright (c) 2009, 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.resources.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.rcptt.util.StringUtils;

public class WSOptions {

	public static String[] resolveIgnoredPattern(String root, String ignoredPattern) {
		if (ignoredPattern == null) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		String prefix = StringUtils.isEmpty(root) ? "" : Pattern.quote(root.replace('\\', '/'));
		for (String pattern : ignoredPattern.split(",")) {
			pattern = pattern.trim();
			// as our patterns don't support escaping, backslashes
			// only can appear as windows-style path separators
			pattern = pattern.replace('\\', '/');
			if (pattern.isEmpty()) {
				continue;
			}

			// remove leading slashes
			while (pattern.charAt(0) == '/') {
				pattern = pattern.substring(1);
			}
			pattern = StringUtils.globToRegex(pattern);
			result.add(StringUtils.isEmpty(prefix) ? pattern : String.format("%s/%s", prefix, pattern));
		}
		return result.toArray(new String[result.size()]);
	}

	public static boolean isIgnored(String fileName, String[] ignoredPatterns) {
		if (ignoredPatterns == null) {
			return false;
		}
		for (String pattern : ignoredPatterns) {
			fileName = fileName.replace('\\', '/');
			String fileNameWithSlash = fileName + "/";
			if (fileName.matches(pattern) || fileNameWithSlash.matches(pattern)) {
				return true;
			}
		}
		return false;
	}

}
