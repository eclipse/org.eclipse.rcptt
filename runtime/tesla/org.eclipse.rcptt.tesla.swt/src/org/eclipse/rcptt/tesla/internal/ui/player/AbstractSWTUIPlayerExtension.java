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

import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.swt.widgets.Widget;

public abstract class AbstractSWTUIPlayerExtension implements
		ISWTUIPlayerExtension {

	@Override
	public SWTUIElement wrap(Object s, SWTUIPlayer p) {
		return null;
	}

	@Override
	public GenericElementKind getKind(Object w) {
		return null;
	}

	@Override
	public SWTUIElement select(SWTUIPlayer swtuiPlayer, PlayerSelectionFilter f) {
		return null;
	}

	@Override
	public String getRawText(SWTUIElement element) {
		return null;
	}

	@Override
	public IChildrenCollectingExtension getChildrenCollectingExtension(ChildrenCollectingSession s) {
		return null;
	}

	@Override
	public SWTUIElement getShell(SWTUIElement element) {
		return null;
	}

	@Override
	public Widget getIndirectParent(Widget current) {
		return null;
	}

	@Override
	public Class<?> getSearchableClass(Object widget) {
		return null;
	}

	@Override
	public boolean canClick(final SWTUIElement widget, final boolean isDefault,
			final boolean doubleClick, final boolean arrow) {
		return false;
	}

	@Override
	public void click(final SWTUIElement widget, final boolean isDefault, final boolean doubleClick,
			final boolean arrow, final int stateMask) {
	}

	@Override
	public boolean isCollectable(SWTUIElement element, Class<?>[] collectableTypes) {
		return false;
	}

}
