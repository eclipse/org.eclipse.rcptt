/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.search.tags;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.rcptt.core.tags.Tag;

public class TagsContentAssist {

	public static final String OPERATOR_OR = "OR";
	public static final String OPERATOR_AND = "AND";
	public static final String REGEX_LAST_SEGMENT = "^.*(\\(| or | OR | \\| | and | AND | & | not | NOT |!)(.*)$";
	public static final String REGEX_SPEC_CHARS = ".*[ ()!].*";

	private static class LastSegment {
		public final String operator;
		public final String segment;

		public LastSegment(String operator, String segment) {
			this.operator = operator;
			this.segment = segment;
		}
	}

	public static ArrayList<String> getOffers(String search, List<Tag> tags) {
		ArrayList<String> results = new ArrayList<String>(0);

		if (search == null || search.trim().isEmpty()) {
			// If empty -> return all roots
			getAllRootTags("", results, tags);
		} else {
			LastSegment last = getLastSegment(search);
			if (search.endsWith(" ")) {
				if (last.operator == null) { // tagName<space>
					findAllTags(search, "", results, tags);
					results.add(search + OPERATOR_OR);
					results.add(search + OPERATOR_AND);
				} else if (!last.segment.trim().isEmpty()) { // ..<or|and|(> tagName<space>
					String prefix = search.substring(0, search.length() - last.segment.length());
					findAllTags(last.segment, prefix, results, tags);
					results.add(search + OPERATOR_OR);
					results.add(search + OPERATOR_AND);
				} else { // ..<or|and><space>
					getAllRootTags(search, results, tags);
				}
			} else if (search.endsWith("(") || search.endsWith("!")) { // ..( or ..!
				getAllRootTags(search, results, tags);
			} else {
				if (last.operator == null) { // tagNa..
					findAllTags(search.replaceAll("^\\s+", ""), "", results, tags);
				} else if (!last.segment.trim().isEmpty()) { // ..<or|and|(> tagNa..
					String prefix = search.substring(0, search.length() - last.segment.length());
					findAllTags(last.segment.replaceAll("^\\s+", ""), prefix, results, tags);
				}
			}
		}

		return results;
	}

	private static LastSegment getLastSegment(String text) {
		Pattern pattern = Pattern.compile(REGEX_LAST_SEGMENT);
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			return new LastSegment(matcher.group(1), matcher.group(2) == null ? "" : matcher.group(2));
		} else {
			return new LastSegment(null, null);
		}
	}

	private static void getAllRootTags(String prefix, ArrayList<String> results, List<Tag> tags) {
		if (tags != null) {
			for (Tag tag : tags) {
				if (tag.getPath().matches(REGEX_SPEC_CHARS)) {
					results.add(prefix + "\"" + tag.getPath() + "\"");
				} else {
					results.add(prefix + tag.getPath());
				}
			}
		}
	}

	private static void findAllTags(String search, String prefix, ArrayList<String> results, List<Tag> tags) {
		if (tags != null) {
			for (Tag tag : tags) {
				if (tag.getPath().toLowerCase().startsWith(search.toLowerCase())) {
					if (tag.getPath().matches(REGEX_SPEC_CHARS)) {
						results.add(prefix + "\"" + tag.getPath() + "\"");
					} else {
						results.add(prefix + tag.getPath());
					}
				}
				findAllTags(search, prefix, results, tag.getTags());
			}
		}
	}

}
