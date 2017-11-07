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
package org.eclipse.rcptt.tesla.recording.aspects.jface.text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.rcptt.util.WeakMap;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

public final class JFaceTextEventManager {
	private JFaceTextEventManager() {
	}

	private static WeakMap<StyledText, TextViewer> viewersMap = new WeakMap<StyledText, TextViewer>();
	private static WeakMap<Canvas, IVerticalRuler> rulersMap = new WeakMap<Canvas, IVerticalRuler>();
	private static WeakMap<IVerticalRuler, ITextViewer> rulersViewerMap = new WeakMap<IVerticalRuler, ITextViewer>();

	private static Set<IJFaceTextEventListener> listeners = new HashSet<IJFaceTextEventListener>();

	public static void addListener(IJFaceTextEventListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(IJFaceTextEventListener listener) {
		listeners.remove(listener);
	}

	public static void showContentAssist(Object control, boolean autoActivation) {
		for (IJFaceTextEventListener listener : listeners) {
			listener.showContentAssist(control, autoActivation);
		}
	}

	public static void activateInfomationWindow(Widget widget,
			Rectangle subjectArea) {
		for (IJFaceTextEventListener listener : listeners) {
			listener.activateInfomationWindow(widget, subjectArea);
		}
	}

	public static void mapViewer(StyledText text, TextViewer viewer) {
		viewersMap.put(text, viewer);
	}

	public static TextViewer getViewer(StyledText widget) {
		return viewersMap.get(widget);
	}

	public static void mapRuler(IVerticalRuler ruler, Control widget,
			ITextViewer viewer) {
		if (widget instanceof Canvas) {
			rulersMap.put((Canvas) widget, ruler);
			rulersViewerMap.put(ruler, viewer);
		}
	}

	public static List<IVerticalRuler> getRulers() {
		List<IVerticalRuler> rv = new ArrayList<IVerticalRuler>(rulersMap.values());
		for (Iterator<IVerticalRuler> i = rv.iterator(); i.hasNext();) {
			IVerticalRuler ruler = i.next();
			if (ruler.getControl().isDisposed())
				i.remove();
		}
		return rv;
	}
}
