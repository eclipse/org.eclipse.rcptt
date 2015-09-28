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
package org.eclipse.rcptt.tesla.core.utils;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.Arrays;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.ui.Color;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;

public class WidgetModels {
	public static String getTextWithoutStyle(Iterable<StyleRangeEntry> entries, String text) {
		if (text == null) {
			return null;
		}
		char[] chars = text.toCharArray();
		boolean[] mask = new boolean[chars.length];
		Arrays.fill(mask, true);

		for (StyleRangeEntry entry : entries) {
			int start = entry.getStart();
			Arrays.fill(mask, start, start + entry.getLength(), false);
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (mask[i]) {
				result.append(chars[i]);
			}
		}
		return result.toString();
	}
	
	public static String getStyledText(Iterable<StyleRangeEntry> entries, String text) {
		if (text == null) {
			return null;
		}
		char[] chars = text.toCharArray();
		boolean[] mask = new boolean[chars.length];
		Arrays.fill(mask, false);

		boolean isEmpty = true;

		for (StyleRangeEntry entry : entries) {
			isEmpty = false;
			int start = entry.getStart();
			Arrays.fill(mask, start, start + entry.getLength(), true);
		}

		StringBuilder styledResult = new StringBuilder();
		if (!isEmpty) {
			for (int i = 0; i < chars.length; i++) {
				if (mask[i]) {
					styledResult.append(chars[i]);
				}
			}
		}
		return styledResult.toString();
	}

	public static StyleDiff getDiff(int start, int length, Iterable<StyleRangeEntry> left,
			Iterable<StyleRangeEntry> right) {

		StyleWithoutPos[] leftStyles = getStyleArray(start, length, left);
		StyleWithoutPos[] rightStyles = getStyleArray(start, length, right);

		for (int i = 0; i < length; i++) {
			StyleWithoutPos leftStyle = leftStyles[i];
			StyleWithoutPos rightStyle = rightStyles[i];

			if (leftStyle == null && rightStyle == null) {
				continue;
			}

			if ((leftStyle == null && rightStyle != null) ||
					(leftStyle != null && rightStyle == null)) {
				return new StyleDiff(i + start,
						leftStyle == null ? null : leftStyle.source,
						rightStyle == null ? null : rightStyle.source);
			}

			if (!leftStyle.equals(rightStyle)) {
				return new StyleDiff(i + start, leftStyle.source, rightStyle.source);
			}
		}
		return null;
	}

	private static StyleWithoutPos[] getStyleArray(int start, int length, Iterable<StyleRangeEntry> styles) {
		StyleWithoutPos[] result = new StyleWithoutPos[length];
		for (StyleRangeEntry entry : styles) {
			int from = entry.getStart() - start;
			int to = entry.getStart() + entry.getLength() - start;
			if (to < 0 || from >= length) {
				continue;
			}

			from = max(from, 0);
			to = min(to, length);

			Arrays.fill(result, from, to, new StyleWithoutPos(entry));
		}
		return result;
	}

	private static class StyleWithoutPos {
		public final Color backgroundColor;
		public final Color borderColor;
		public final String borderStyle;
		public final String font;
		public final String fontStyle;
		public final Color foregroundColor;
		public final String metrics;
		public final Integer rise;
		public final Boolean strikeout;
		public final String underline;
		public final Color underlineColor;
		public final StyleRangeEntry source;

		public StyleWithoutPos(StyleRangeEntry entry) {
			backgroundColor = entry.getBackgroundColor();
			borderColor = entry.getBorderColor();
			borderStyle = entry.getBorderStyle();
			font = entry.getFont();
			fontStyle = entry.getFontStyle();
			foregroundColor = entry.getForegroundColor();
			metrics = entry.getMetrics();
			rise = entry.getRise();
			strikeout = entry.getStrikeout();
			underline = entry.getUnderline();
			underlineColor = entry.getUnderlineColor();
			source = entry;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((backgroundColor == null) ? 0 : backgroundColor.hashCode());
			result = prime * result + ((borderColor == null) ? 0 : borderColor.hashCode());
			result = prime * result + ((borderStyle == null) ? 0 : borderStyle.hashCode());
			result = prime * result + ((font == null) ? 0 : font.hashCode());
			result = prime * result + ((fontStyle == null) ? 0 : fontStyle.hashCode());
			result = prime * result + ((foregroundColor == null) ? 0 : foregroundColor.hashCode());
			result = prime * result + ((metrics == null) ? 0 : metrics.hashCode());
			result = prime * result + ((rise == null) ? 0 : rise.hashCode());
			result = prime * result + ((strikeout == null) ? 0 : strikeout.hashCode());
			result = prime * result + ((underline == null) ? 0 : underline.hashCode());
			result = prime * result + ((underlineColor == null) ? 0 : underlineColor.hashCode());
			return result;
		}

		/**
		 * Autogenerated method with manual replacement of color.equals(other) to ECoreUtil.equals(color, other)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			StyleWithoutPos other = (StyleWithoutPos) obj;
			if (backgroundColor == null) {
				if (other.backgroundColor != null)
					return false;
			} else if (!EcoreUtil.equals(backgroundColor, other.backgroundColor))
				return false;
			if (borderColor == null) {
				if (other.borderColor != null)
					return false;
			} else if (!EcoreUtil.equals(borderColor, other.borderColor))
				return false;
			if (borderStyle == null) {
				if (other.borderStyle != null)
					return false;
			} else if (!borderStyle.equals(other.borderStyle))
				return false;
			if (font == null) {
				if (other.font != null)
					return false;
			} else if (!font.equals(other.font))
				return false;
			if (fontStyle == null) {
				if (other.fontStyle != null)
					return false;
			} else if (!fontStyle.equals(other.fontStyle))
				return false;
			if (foregroundColor == null) {
				if (other.foregroundColor != null)
					return false;
			} else if (!EcoreUtil.equals(foregroundColor, other.foregroundColor))
				return false;
			if (metrics == null) {
				if (other.metrics != null)
					return false;
			} else if (!metrics.equals(other.metrics))
				return false;
			if (rise == null) {
				if (other.rise != null)
					return false;
			} else if (!rise.equals(other.rise))
				return false;
			if (strikeout == null) {
				if (other.strikeout != null)
					return false;
			} else if (!strikeout.equals(other.strikeout))
				return false;
			if (underline == null) {
				if (other.underline != null)
					return false;
			} else if (!underline.equals(other.underline))
				return false;
			if (underlineColor == null) {
				if (other.underlineColor != null)
					return false;
			} else if (!EcoreUtil.equals(underlineColor, other.underlineColor))
				return false;
			return true;
		}

	}

	public static class StyleDiff {
		public final int at;
		public final StyleRangeEntry expected;
		public final StyleRangeEntry actual;

		public StyleDiff(int at, StyleRangeEntry expected, StyleRangeEntry actual) {
			this.at = at;
			this.expected = expected;
			this.actual = actual;
		}
	}
}
