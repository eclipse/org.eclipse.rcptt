/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.util.swt;

import org.eclipse.swt.custom.StyleRange;

public class StyleRangeUtils {
	public static StylesDiffInfo getStylesDiffInd(int start, int length, StyleRange[] leftRanges,
			StyleRange[] rightRanges) {

		for (int i = start; i < start + length; i++) {
			StyleRange toComp = null;
			int expRangeInd = -1;
			int actRangeInd = -1;
			boolean same = false;

			for (int j = leftRanges.length - 1; j >= 0; j--) {
				if (i >= leftRanges[j].start
						&& i < leftRanges[j].start + leftRanges[j].length) {
					expRangeInd = j;
					toComp = leftRanges[j];
					break;
				}
			}
			for (int j = rightRanges.length - 1; j >= 0; j--) {
				if (i >= rightRanges[j].start
						&& i < rightRanges[j].start + rightRanges[j].length) {
					if (toComp != null && toComp.similarTo(rightRanges[j])) {
						same = true;
					} else {
						actRangeInd = j;
						break;
					}
				}
			}

			if (!same && (expRangeInd != -1 || actRangeInd != -1)) {
				return new StylesDiffInfo(i, expRangeInd, actRangeInd);
			}
		}
		return null;
	}

	public static String getNonStyledText(StyleRange[] ranges, String text) {
		if (text == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			boolean appendChar = true;
			for (StyleRange range : ranges) {
				if (i >= range.start && i < range.start + range.length) {
					appendChar = false;
					break;
				}
			}
			if (appendChar) {
				sb.append(text.charAt(i));
			}
		}
		return sb.toString();
	}
}
