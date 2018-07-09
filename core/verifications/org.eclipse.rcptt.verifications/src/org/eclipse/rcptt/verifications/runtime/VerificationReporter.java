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
package org.eclipse.rcptt.verifications.runtime;

import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.tesla.core.ui.Color;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError;
import org.eclipse.rcptt.verifications.status.TreeItemVerificationError;
import org.eclipse.rcptt.verifications.status.VerificationStatusData;

public class VerificationReporter {
	public static StyledMessage getStyledMessage(VerificationStatus status) {
		StringBuilder sb = new StringBuilder();
		LinkedHashMap<StyleRangeEntry, Object> styles = new LinkedHashMap<StyleRangeEntry, Object>();

		sb.append(status.getMessage()).append('\n');
		for (VerificationStatusData data : status.getData()) {
			appendVerificationStatusData(data, styles, sb);
		}
		return new StyledMessage(sb.toString(), styles);
	}

	private static void appendVerificationStatusData(VerificationStatusData data,
			LinkedHashMap<StyleRangeEntry, Object> ranges, StringBuilder buffer) {
		if (data instanceof TreeItemStyleVerificationError) {
			buffer.append(data.getMessage());
			appendTreeItemStyleVerificationErrorData((TreeItemStyleVerificationError) data, ranges, buffer);
			appendTreeItemVerificationErrorData((TreeItemVerificationError) data, ranges, buffer);
		} else if (data instanceof TreeItemVerificationError) {
			buffer.append(data.getMessage());
			appendTreeItemVerificationErrorData((TreeItemVerificationError) data, ranges, buffer);
		} else {
			buffer.append(data.getMessage());
		}
		buffer.append("\n");
	}

	private static void appendTreeItemStyleVerificationErrorData(TreeItemStyleVerificationError error,
			LinkedHashMap<StyleRangeEntry, Object> ranges, StringBuilder buffer) {
		buffer.append(" Expected ");
		if (error.getExpectedStyle() != null) {
			appendStyleRange(buffer, ranges, error.getExpectedStyle(),
					getRangeEntryDescription(error.getExpectedStyle(), "start", "length", "text"));
		} else {
			buffer.append("no style");
		}
		buffer.append(", but was ");
		if (error.getActualStyle() != null) {
			appendStyleRange(buffer, ranges, error.getActualStyle(),
					getRangeEntryDescription(error.getActualStyle(), "start", "length", "text"));
		} else {
			buffer.append("no style");
		}
	}

	private static void appendStyleRange(StringBuilder buffer, LinkedHashMap<StyleRangeEntry, Object> ranges,
			StyleRangeEntry rangeEntry, String text) {
		int start = buffer.length();
		buffer.append(text);
		int length = buffer.length() - start;
		StyleRangeEntry range = EcoreUtil.copy(rangeEntry);

		range.setStart(start);
		range.setLength(length);
		ranges.put(range, null);
	}

	private static void appendTreeItemVerificationErrorData(TreeItemVerificationError error,
			LinkedHashMap<StyleRangeEntry, Object> ranges, StringBuilder buffer) {
		if (error.getColumn() != null) {
			buffer.append(" in column ");
			buffer.append("\"");
			buffer.append(error.getColumn());
			buffer.append("\"");
		}
		if (error.getItemPath() != null) {
			if ("".equals(error.getItemPath())) {
				buffer.append(" at the root item");
			} else {
				buffer.append(" at item ");
				buffer.append("\"");
				int start = buffer.length();
				buffer.append(error.getItemPath());
				int length = buffer.length() - start;
				ranges.put(createLinkStyle(start, length), error);
				buffer.append("\"");
			}
		}
	}

	private static StyleRangeEntry createLinkStyle(int start, int length) {
		StyleRangeEntry style = UiFactory.eINSTANCE.createStyleRangeEntry();

		style.setUnderline("verification_link");
		style.setStart(start);
		style.setLength(length);
		return style;
	}

	public static String getRangeEntryDescription(StyleRangeEntry entry, String... ignoredAttrs) {
		StringBuilder sb = new StringBuilder();

		for (EStructuralFeature feature : entry.eClass().getEStructuralFeatures()) {
			boolean accepted = true;
			for (String attr : ignoredAttrs) {
				if (feature.getName().equals(attr)) {
					accepted = false;
					break;
				}
			}
			if (accepted) {
				Object val = entry.eGet(feature);

				if (val != null) {
					if (sb.length() > 0) {
						sb.append(", ");
					}
					sb.append(feature.getName()).append(": ");
					if (val instanceof Color) {
						Color col = (Color) val;
						sb.append(String.format("#%02X%02X%02X%02X",
								col.getAlfa(),
								col.getRed(),
								col.getGreen(),
								col.getBlue()));
					} else {
						sb.append(val.toString());
					}
				}
			}
		}
		return sb.toString();
	}
}
