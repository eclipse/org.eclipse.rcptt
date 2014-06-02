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
package org.eclipse.rcptt.ui.utils;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;

import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;

/* 
 * I'm really not sure there to place these utility methods.
 * They should be placed under SWTModelMapper, but we cannot
 * use tesla.swt in UI plugins.
 */

public class RangeUtils {

	public static StyleRange[] fromEMF(List<StyleRangeEntry> entries, Device device) {
		StyleRange[] ranges = new StyleRange[entries.size()];
		for (int i = 0; i < entries.size(); i++) {
			ranges[i] = RangeUtils.fromEMF(entries.get(i), device);
		}
		return ranges;
	}

	public static StyleRange fromEMF(StyleRangeEntry entry,
			Device device) {
		StyleRange range = new StyleRange();

		range.background = colorFromEMF(entry.getBackgroundColor(), device);
		range.borderColor = colorFromEMF(entry.getBorderColor(), device);
		range.borderStyle = borderFromEMF(entry.getBorderStyle());
		range.font = null;
		range.fontStyle = fontFromEMF(entry.getFontStyle());
		range.foreground = colorFromEMF(entry.getForegroundColor(), device);
		range.length = entry.getLength();
		range.metrics = null;
		range.rise = entry.getRise() == null ? 0 : entry.getRise();
		range.start = entry.getStart();
		range.strikeout = entry.getStrikeout() == null ? false : entry.getStrikeout();
		range.strikeoutColor = colorFromEMF(entry.getStrikeoutColor(), device);
		range.underline = entry.getUnderline() == null ? false : true;
		range.underlineColor = colorFromEMF(entry.getUnderlineColor(), device);
		range.underlineStyle = underlineFromEMF(entry.getUnderline());

		return range;
	}

	private static int underlineFromEMF(String style) {
		int result = 0;

		if (style == null)
			return result;

		if (style.equals("single"))
			result = SWT.UNDERLINE_SINGLE;
		else if (style.equals("double"))
			result = SWT.UNDERLINE_DOUBLE;
		else if (style.equals("squiggle"))
			result = SWT.UNDERLINE_SQUIGGLE;
		else if (style.equals("error"))
			result = SWT.UNDERLINE_ERROR;
		else if (style.equals("link"))
			result = SWT.UNDERLINE_LINK;

		return result;
	}

	private static int fontFromEMF(String style) {
		int result = SWT.NORMAL;

		if (style == null)
			return result;

		if (style.equals("bold"))
			result = SWT.BOLD;
		else if (style.equals("italic"))
			result = SWT.ITALIC;
		else if (style.equals("bold-italic"))
			result = SWT.BOLD | SWT.ITALIC;

		return result;
	}

	public static int borderFromEMF(String style) {
		int result = 0;

		if (style == null)
			return result;

		if (style.equals("solid"))
			result = SWT.BORDER_SOLID;
		else if (style.equals("dot"))
			result = SWT.BORDER_DOT;
		else if (style.equals("dash"))
			result = SWT.BORDER_DASH;

		return result;
	}

	public static org.eclipse.swt.graphics.Color colorFromEMF(
			org.eclipse.rcptt.tesla.core.ui.Color color, Device device) {
		if (color == null)
			return null;

		return new Color(device,
				color.getRed(), color.getGreen(), color.getBlue());
	}

}
