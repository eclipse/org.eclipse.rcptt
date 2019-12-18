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
package org.eclipse.rcptt.tesla.workbench.texteditor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.IVerticalRulerColumn;
import org.eclipse.rcptt.tesla.core.ui.Marker;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.jface.text.JFaceTextManager;
import org.eclipse.rcptt.tesla.recording.aspects.jface.text.JFaceTextEventManager;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.rulers.AbstractContributedRulerColumn;

public class TextEditorAnnotationFinder {

	public Map<String, EList<Marker>> findAnnotations(TextViewer viewer) {
		Map<String, EList<Marker>> markersAtEditor = new HashMap<String, EList<Marker>>();
		FoundResults rulers = findRulerColumn(viewer);
		if (rulers != null && rulers.getRulerColumn() instanceof AbstractContributedRulerColumn) {
			AbstractContributedRulerColumn contributedRuler = (AbstractContributedRulerColumn) rulers.getRulerColumn();
			detectAnnotations(markersAtEditor, contributedRuler);
		}
		return markersAtEditor;
	}

	private FoundResults findRulerColumn(TextViewer viewer) {
		List<IVerticalRuler> rulers = JFaceTextEventManager.getRulers();
		for (IVerticalRuler ruler : rulers) {
			if (ruler instanceof CompositeRuler) {
				Iterator<?> iterator = ((CompositeRuler) ruler)
						.getDecoratorIterator();

				while (iterator.hasNext()) {
					Object next = iterator.next();
					if (next instanceof AbstractContributedRulerColumn) {
						AbstractContributedRulerColumn column = (AbstractContributedRulerColumn) next;
						Control rulerParent = column.getControl().getParent().getParent();
						Control viewerParent = viewer.getControl();
						if (viewerParent.equals(rulerParent)) {
							return new FoundResults(ruler, column);
						}
					}
				}
			}
		}
		return null;
	}

	private void detectAnnotations(Map<String, EList<Marker>> markersAtEditor,
			AbstractContributedRulerColumn contributedRuler) {

		ITextEditor editor = contributedRuler.getEditor();
		IAnnotationModel model = editor.getDocumentProvider().getAnnotationModel(editor.getEditorInput());
		if (model == null) {
			return;
		}

		Iterator<?> iterator = model.getAnnotationIterator();
		while (iterator.hasNext()) {
			Annotation annotation = (Annotation) iterator.next();
			Position position = model.getPosition(annotation);
			if (position == null) {
				continue;
			}
			int line;
			try {
				line = getLine(position, contributedRuler) + 1;
				Marker marker = UiFactory.eINSTANCE.createMarker();
				marker.setLine(line);
				marker.setType(annotation.getType());
				marker.setText(annotation.getText());
				marker.setColumn(contributedRuler.getClass().toString());
				putAnnotation(markersAtEditor, marker, line);
			} catch (BadLocationException e) {
				continue;
			}

		}
	}

	private int getLine(Position position, AbstractContributedRulerColumn contributedRuler) throws
			BadLocationException {
		ITextEditor editor = contributedRuler.getEditor();
		IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
		return document.getLineOfOffset(position.getOffset());
	}

	private void putAnnotation(Map<String, EList<Marker>> markersAtEditor, Marker marker,
			int line) {

		String key = "" + line;
		if (markersAtEditor.containsKey(key)) {
			EList<Marker> markers = markersAtEditor.get(key);
			boolean contains = false;
			for (Marker m : markers) {
				if (EcoreUtil.equals(m, marker)) {
					contains = true;
				}
			}
			if (!contains) {
				markers.add(marker);
			}
		} else {
			EList<Marker> markers = new BasicEList<Marker>();
			markers.add(marker);
			markersAtEditor.put(key, markers);
		}
	}

	protected int getVisibleCaretOffset(StyledText control, int line, int offset) {

		TextViewer viewer = JFaceTextManager.getViewer(control);
		IDocument document = viewer.getDocument();
		try {
			int lineOffset = document.getLineOffset(line - 1);
			int len = document.getLineLength(line - 1);
			document.get(lineOffset, len);
			int tabs = control.getTabs();
			int column = 0;
			for (int i = lineOffset; i <= lineOffset + len; i++) {
				if (column == offset - 1) {
					column = i - lineOffset;
					break;
				}
				if ('\t' == document.getChar(i))
					column += tabs - (tabs == 0 ? 0 : column % tabs);
				else
					column++;
			}
			return viewer.modelOffset2WidgetOffset(lineOffset + column);
		} catch (BadLocationException e) {
			// no need to log - it is fine
			return -1;
		} catch (Exception e) {
			TeslaCore.log(e);
			return -1;
		}
	}

	final class FoundResults {
		private final IVerticalRuler ruler;
		private final IVerticalRulerColumn rulerColumn;

		public FoundResults(IVerticalRuler ruler, IVerticalRulerColumn rulerColumn) {
			this.ruler = ruler;
			this.rulerColumn = rulerColumn;
		}

		public IVerticalRuler getRuler() {
			return ruler;
		}

		public IVerticalRulerColumn getRulerColumn() {
			return rulerColumn;
		}
	}

}
