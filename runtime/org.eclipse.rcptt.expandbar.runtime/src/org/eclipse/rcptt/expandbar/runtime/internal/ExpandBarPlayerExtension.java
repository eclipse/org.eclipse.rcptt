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
package org.eclipse.rcptt.expandbar.runtime.internal;

import static org.eclipse.rcptt.expandbar.ExpandBarConstants.EXPAND_BAR_KIND;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.internal.ui.player.AbstractSWTUIPlayerExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.ChildrenCollectingSession;
import org.eclipse.rcptt.tesla.internal.ui.player.IChildrenCollectingExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerSelectionFilter;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;

public class ExpandBarPlayerExtension extends AbstractSWTUIPlayerExtension {
	@Override
	public GenericElementKind getKind(Object w) {
		return w instanceof ExpandBar ? new GenericElementKind(EXPAND_BAR_KIND) :
				w instanceof ExpandItem ? new GenericElementKind(ElementKind.Item) :
						super.getKind(w);
	}

	@Override
	public SWTUIElement select(SWTUIPlayer p, PlayerSelectionFilter f) {
		if (f.kind.is(EXPAND_BAR_KIND)) {
			return p.selectWidget(f.withoutPattern(), ExpandBar.class);
		}

		if (f.kind.is(ElementKind.Item)) {
			Widget parent = f.parent.unwrap();
			if (!(parent instanceof ExpandBar)) {
				return null;
			}

			ExpandBar bar = (ExpandBar) parent;
			ExpandItem result = ItemLocation.fromSelectionFilter(f).findMatch(bar);
			return result == null ? null : p.wrap(result);
		}
		return null;
	}

	@Override
	public Widget getIndirectParent(Widget current) {
		if (current instanceof ExpandItem) {
			return ((ExpandItem) current).getParent();
		}
		if (!(current instanceof Composite)) {
			return null;
		}

		Composite currentComposite = (Composite) current;

		Composite parent = currentComposite.getParent();

		if (!(parent instanceof ExpandBar)) {
			return null;
		}

		ExpandBar expandBar = (ExpandBar) parent;
		for (ExpandItem item : expandBar.getItems()) {
			if (item.getControl() == currentComposite) {
				return item;
			}
		}
		return null;
	}

	@Override
	public IChildrenCollectingExtension getChildrenCollectingExtension(final ChildrenCollectingSession s) {

		return new IChildrenCollectingExtension() {

			@Override
			public void collect() {
				if (s.w == null) {
					return;
				}
				Widget widget = s.w.unwrap();
				if (!(widget instanceof ExpandItem)) {
					return;
				}

				Control content = ((ExpandItem) widget).getControl();
				SWTUIElement contentElement = s.player.wrap(content);
				s.addItem(contentElement);
				if (content instanceof Composite && s.goIntoComposites) {
					for (SWTUIElement element : s.collector.collectFor(contentElement, s.ignores, s.goIntoComposites,
							s.classes)) {
						s.addItem(element);
					}
				}

			}
		};
	}
}