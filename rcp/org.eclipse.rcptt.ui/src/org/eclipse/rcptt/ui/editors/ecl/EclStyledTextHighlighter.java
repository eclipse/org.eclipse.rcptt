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
package org.eclipse.rcptt.ui.editors.ecl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import org.eclipse.rcptt.core.ecl.highlighter.EclHighlighter;
import org.eclipse.rcptt.core.ecl.highlighter.EclHighlighter.RunType;
import org.eclipse.rcptt.core.ecl.highlighter.EclHighlighter.Strategy;

public class EclStyledTextHighlighter {
	public void install(final StyledText styledText) {
		styledText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				EclHighlighter highlighter = new EclHighlighter();
				highlighter.highlight(styledText.getText(), new Strategy() {
					@Override
					public void highlight(RunType type, int start, int end) {
						StyleRange styleRange = getStyleRange(type);
						styleRange.start = start;
						styleRange.length = end - start;
						styleRange.fontStyle = getFontStyle(type);
						styledText.setStyleRange(styleRange);
					}
				});
			}
		});
	}

	private static StyleRange getStyleRange(RunType type) {
		StyleRange styleRange = new StyleRange();
		styleRange.foreground = getForegroundColor(type);

		switch (type) {
		case Invalid:
			styleRange.underline = true;
			styleRange.underlineStyle = SWT.UNDERLINE_ERROR;
			styleRange.underlineColor = COLOR_MANAGER.getColor(INVALID_UNDERLINE_COLOR);
			break;
		}

		return styleRange;
	}

	private static final Map<RunType, RGB> FOREGROUND_COLORS = new HashMap<RunType, RGB>();
	static {
		FOREGROUND_COLORS.put(RunType.Invalid, new RGB(0, 0, 0));

		FOREGROUND_COLORS.put(RunType.Spacing, new RGB(0, 0, 0));
		FOREGROUND_COLORS.put(RunType.Comment, new RGB(63, 127, 95));

		FOREGROUND_COLORS.put(RunType.Punctuation, new RGB(0, 0, 0));

		FOREGROUND_COLORS.put(RunType.Command, new RGB(127, 0, 85));
		FOREGROUND_COLORS.put(RunType.Option, new RGB(100, 100, 100));

		FOREGROUND_COLORS.put(RunType.Literal, new RGB(42, 0, 255));
		FOREGROUND_COLORS.put(RunType.Variable, new RGB(100, 100, 100));
	}

	private static int getFontStyle(RunType run) {
		switch (run) {
		case Command:
			return SWT.BOLD;
		default:
			return SWT.NORMAL;
		}
	}

	private static final RGB INVALID_UNDERLINE_COLOR = new RGB(255, 0, 0);

	private static final ColorManager COLOR_MANAGER = new ColorManager();

	private static Color getForegroundColor(RunType type) {
		return COLOR_MANAGER.getColor(FOREGROUND_COLORS.get(type));
	}
}
