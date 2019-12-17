/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.workbench.texteditor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.rcptt.tesla.core.ui.Text;
import org.eclipse.rcptt.tesla.core.ui.TextPosition;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.jface.text.JFaceTextManager;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Widget;

public class TextEditorMapper {
	public static org.eclipse.rcptt.tesla.core.ui.Widget mapExtraValues(
			SWTUIElement element, org.eclipse.rcptt.tesla.core.ui.Widget result) {
		Widget unwrap = element.unwrap();
		if (!(unwrap instanceof StyledText) || !isTextEditorStyledText(unwrap)
				|| !(result instanceof Text)) {
			return result;
		}
		StyledText t = (StyledText) unwrap;
		Text text = (Text) result;
		TextViewer viewer = JFaceTextManager.getViewer(t);
		int caretOffset = t.getCaretOffset();
		int tabWidth = t.getTabs();

		setCaretPosition(text, viewer, tabWidth, caretOffset);
		updateStyleEntry(text.getStyleAtCaret(), viewer, tabWidth);
		for (StyleRangeEntry styleEntry : text.getStyles()) {
			updateStyleEntry(styleEntry, viewer, tabWidth);
		}

		setMarkers(text, viewer, result);
		return result;
	}

	private static void setMarkers(Text text, TextViewer viewer,
			org.eclipse.rcptt.tesla.core.ui.Widget widget) {
		if (text == null) {
			return;
		}
		TextEditorAnnotationFinder finder = new TextEditorAnnotationFinder();
		text.getMarkers().putAll(finder.findAnnotations(viewer));
		text.setMarkersCount(text.getMarkers().size());
	}

	private static void updateStyleEntry(StyleRangeEntry entry,
			TextViewer viewer, int tabWidth) {
		if (entry == null) {
			return;
		}

		TextPosition start = offsetToPosition(viewer, tabWidth,
				entry.getStart());
		TextPosition end = offsetToPosition(viewer, tabWidth, entry.getStart()
				+ entry.getLength());
		if (start != null && end != null) {
			entry.setStartPos(start);
			entry.setEndPos(end);
		}
	}

	public static boolean isTextEditorStyledText(Object widget) {
		if (widget instanceof StyledText) {
			TextViewer viewer = JFaceTextManager.getViewer((StyledText) widget);
			if (viewer != null) {
				return true;
			}
		}
		return false;
	}

	private static void setCaretPosition(Text text, TextViewer viewer,
			int tabWidth, int offset) {
		TextPosition updatedPosition = offsetToPosition(viewer, tabWidth,
				offset);
		if (updatedPosition != null) {
			text.setCaretPosition(updatedPosition);
		}
	}

	private static TextPosition offsetToPosition(TextViewer viewer,
			int tabWidth, int offset) {
		TextPosition result = UiFactory.eINSTANCE.createTextPosition();
		try {
			IDocument document = viewer.getDocument();
			int realOffset = viewer.widgetOffset2ModelOffset(offset);
			int lineAtOffset = document.getLineOfOffset(realOffset);
			int offsetAtLine = document.getLineOffset(lineAtOffset);
			int column = 0;

			for (int i = offsetAtLine; i < realOffset; i++) {
				if ('\t' == document.getChar(i))
					column += tabWidth
							- (tabWidth == 0 ? 0 : column % tabWidth);
				else
					column++;
			}
			result.setLine(lineAtOffset + 1);
			result.setColumn(column + 1);
		} catch (BadLocationException e) {
			TeslaCore.log(e);
			return null;
		}
		return result;
	}

}
