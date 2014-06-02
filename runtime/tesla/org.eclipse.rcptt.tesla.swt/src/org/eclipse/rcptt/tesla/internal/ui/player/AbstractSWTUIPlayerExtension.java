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
package org.eclipse.rcptt.tesla.internal.ui.player;

import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;

public abstract class AbstractSWTUIPlayerExtension implements
		ISWTUIPlayerExtension {

	public SWTUIElement wrap(Object s, SWTUIPlayer p) {
		return null;
	}

	public GenericElementKind getKind(Object w) {
		return null;
	}

	public SWTUIElement select(SWTUIPlayer swtuiPlayer, PlayerSelectionFilter f) {
		return null;
	}

	public String getRawText(SWTUIElement element) {
		return null;
	}

	public IChildrenCollectingExtension getChildrenCollectingExtension(ChildrenCollectingSession s) {
		return null;
	}

	public SWTUIElement getShell(SWTUIElement element) {
		return null;
	}

	public Widget getIndirectParent(Widget current) {
		return null;
	}

}
