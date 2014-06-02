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
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

public final class JFaceTextEventManager {
	private JFaceTextEventManager() {
	}

	private static WeakHashMap<StyledText, TextViewer> viewersMap = new WeakHashMap<StyledText, TextViewer>();
	private static WeakHashMap<Canvas, IVerticalRuler> rulersMap = new WeakHashMap<Canvas, IVerticalRuler>();
	private static WeakHashMap<IVerticalRuler, ITextViewer> rulersViewerMap = new WeakHashMap<IVerticalRuler, ITextViewer>();

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
		return new ArrayList<IVerticalRuler>(rulersMap.values());
	}
}
