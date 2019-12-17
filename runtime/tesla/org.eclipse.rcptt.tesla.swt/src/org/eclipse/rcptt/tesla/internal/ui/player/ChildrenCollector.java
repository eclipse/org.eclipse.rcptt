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
package org.eclipse.rcptt.tesla.internal.ui.player;

import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrap;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.ui.internal.WorkbenchPartReference;

@SuppressWarnings("restriction")
public class ChildrenCollector {

	private final SWTUIPlayer player;

	public ChildrenCollector(SWTUIPlayer player) {
		this.player = player;
	}

	//

	public SWTUIElement[] collectFor(SWTUIElement w, SWTUIElement[] ignores,
			boolean goIntoComposites, Class<?>[] classes, SWTUIElement after) {
		if (after instanceof WorkbenchUIElement) {
			after = player.wrap(((WorkbenchPartReference) (((WorkbenchUIElement) after).reference))
					.getPane().getControl());

		}
		if (after == null) {
			return collectFor(w, ignores, goIntoComposites, classes);
		}
		Class<?>[] arg = null;
		SWTUIElement[] widgets = collectFor(w, null, goIntoComposites, arg);
		List<SWTUIElement> results = new ArrayList<SWTUIElement>();
		List<SWTUIElement> list = Arrays.asList(widgets);
		int i = list.indexOf(after);
		// int j = list.indexOf(widgets1[3]);
		if (i != -1) {
			List<SWTUIElement> subList = list.subList(i + 1, list.size());
			for (SWTUIElement widget : subList) {
				addItem(results, widget, ignores, classes, player);
			}
		}
		return results.toArray(new SWTUIElement[results.size()]);
	}

	public SWTUIElement[] collectFor(final SWTUIElement w,
			final SWTUIElement[] ignores, final boolean goIntoComposites,
			final Class<?>... classes) {
		return collectFor(w, ignores, goIntoComposites, false, classes);
	}

	public SWTUIElement[] collectFor(final SWTUIElement w,
			final SWTUIElement[] ignores, final boolean goIntoComposites,
			boolean menuIsShown, final Class<?>... classes) {

		ChildrenCollectingSession ccs = new ChildrenCollectingSession(
				player, this, w, ignores, goIntoComposites, menuIsShown, classes);
		return ccs.collect();
	}

	//

	public static void addItem(List<SWTUIElement> results, SWTUIElement control,
			SWTUIElement[] ignores, Class<?>[] classes, SWTUIPlayer player) {
		if (ignores != null) {
			for (SWTUIElement widget : ignores) {
				if (widget.equals(control)) {
					return;
				}
			}
		}

		if (player.isCollectable(control, classes) || classes == null || isInstanceOf(control, classes)) {
			results.add(control);
		}
	}

	private static boolean isInstanceOf(SWTUIElement control, Class<?>[] classes) {
		if (classes != null && classes.length == 0) {
			return true;
		}
		if (classes != null) {
			for (Class<?> class1 : classes) {
				if (class1 == null) {
					continue;
				}
				if (class1.equals(Canvas.class)
						&& unwrapWidget(control) instanceof StyledText) {
					continue;
				}
				if (class1.equals(Canvas.class)
						&& unwrapWidget(control) instanceof CLabel) {
					continue;
				}
				if (class1.equals(Canvas.class)
						&& unwrapWidget(control)
								.getClass()
								.getName()
								.equals("org.eclipse.ui.forms.widgets.ExpandableComposite")) {
					continue;
				}
				if (class1 != null
						&& (class1.isInstance(unwrapWidget(control)) || class1
								.isInstance(unwrap(control)))) {
					return true;
				}
			}
		}
		return false;
	}

}
