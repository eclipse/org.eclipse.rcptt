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
package org.eclipse.rcptt.tesla.jface.text;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.text.AbstractHoverInformationControlManager;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.rcptt.util.WeakMap;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;

public final class JFaceTextManager {
	private JFaceTextManager() {
	}

	private static WeakMap<StyledText, TextViewer> viewersMap = new WeakMap<StyledText, TextViewer>();
	private static WeakMap<Canvas, IVerticalRuler> rulersMap = new WeakMap<Canvas, IVerticalRuler>();
	private static WeakMap<IVerticalRuler, ITextViewer> rulersViewerMap = new WeakMap<IVerticalRuler, ITextViewer>();
	private static Set<WeakReference<AbstractHoverInformationControlManager>> hoverManagers = new HashSet<WeakReference<AbstractHoverInformationControlManager>>();

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

	public static ITextViewer getViewer(IVerticalRuler ruler) {
		return rulersViewerMap.get(ruler);
	}

	public static void registerHoverManager(
			AbstractHoverInformationControlManager manager) {
		hoverManagers
				.add(new WeakReference<AbstractHoverInformationControlManager>(
						manager));
	}

	@SuppressWarnings("unchecked")
	private static final WeakReference<AbstractHoverInformationControlManager>[] EMPTY_MANAGERS = new WeakReference[0];

	public static List<AbstractHoverInformationControlManager> isSomeHoverManagerActive() {
		WeakReference<AbstractHoverInformationControlManager>[] managers = hoverManagers
				.toArray(EMPTY_MANAGERS);
		List<AbstractHoverInformationControlManager> results = new ArrayList<AbstractHoverInformationControlManager>();
		for (WeakReference<AbstractHoverInformationControlManager> r : managers) {
			AbstractHoverInformationControlManager m = r.get();

			if (m == null) {
				hoverManagers.remove(r);
				continue;
			}

			if (!m.getClass().getName()
					.equals("org.eclipse.jface.text.TextViewerHoverManager"))
				continue;

			try {
				Field field = m.getClass().getDeclaredField("fThread");
				field.setAccessible(true);
				Object value = field.get(m);
				if (!(value instanceof Thread))
					continue;

				Thread thread = (Thread) value;
				if (thread.getState() != Thread.State.TERMINATED) {
					results.add(m);
				}

			} catch (Exception e) {
				// just continue
			}
		}

		return results;
	}
}
