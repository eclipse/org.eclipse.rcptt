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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableTreeItemPathUtil {

	public static final String COLUMN_DELIMITER = "#@&#@";
	private static final String COLUMN_ITEM_REGEX = String
			.format("(.*?)%s(.*)%s", COLUMN_DELIMITER, COLUMN_DELIMITER);
	private static final Pattern columnItemPattern = Pattern
			.compile(COLUMN_ITEM_REGEX);

	public static String appendSegmentColumnName(String segment, String columnName) {
		if (findColumnName(segment) == null && columnName != null) {
			return segment + COLUMN_DELIMITER + columnName + COLUMN_DELIMITER;
		}
		return segment;
	}

	public static String getAppendingColumnName(String columnName) {
		if (columnName != null) {
			return COLUMN_DELIMITER + columnName + COLUMN_DELIMITER;
		} else {
			return "";
		}
	}

	public static List<String> appendSegmentsColumnName(List<String> path, String columnName) {
		List<String> result = new ArrayList<String>();
		for (String segment : path) {
			result.add(appendSegmentColumnName(segment, columnName));
		}
		return result;
	}

	public static String appendFullPathColumnName(List<String> path, String columnName) {
		StringBuilder res = new StringBuilder();
		for (String segment : path) {
			res.append(appendSegmentColumnName(segment, columnName)).append('/');
		}
		res.deleteCharAt(res.length() - 1);
		return res.toString();
	}

	public static String appendFullPathColumnName(String path, String columnName) {
		if (columnName == null) {
			return path;
		}
		List<String> segments = splitPath(path);
		return appendFullPathColumnName(segments, columnName);
	}

	public static List<String> splitPath(String path) {
		List<String> segments = new ArrayList<String>();
		StringBuilder segment = new StringBuilder();

		for (int i = 0; i < path.length(); i++) {
			char ch = path.charAt(i);
			if (ch == '/') {
				segments.add(segment.toString());
				segment = new StringBuilder();
				continue;
			}
			if (ch == '\\') {
				if (i + 1 < path.length()) {
					char next = path.charAt(i + 1);
					if (next == '/') {
						i++;
						segment.append('\\');
						segment.append(next);
						continue;
					}
				}
			}
			segment.append(ch);
		}
		segments.add(segment.toString());
		return segments;
	}

	public static String findColumnName(String segment) {
		if (segment == null) {
			return null;
		}
		Matcher m = columnItemPattern.matcher(segment);
		if (!m.matches()) {
			return null;
		}
		return m.group(2);
	}

	public static String excludeColumnName(String segment) {
		if (segment == null) {
			return null;
		}
		Matcher m = columnItemPattern.matcher(segment);
		if (!m.matches()) {
			return segment;
		}
		return m.group(1);
	}

}
