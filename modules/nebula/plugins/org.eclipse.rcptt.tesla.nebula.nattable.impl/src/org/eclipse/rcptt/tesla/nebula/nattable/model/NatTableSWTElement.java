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
package org.eclipse.rcptt.tesla.nebula.nattable.model;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.swt.widgets.Widget;

public class NatTableSWTElement extends SWTUIElement {

	public NatTableSWTElement(Widget w, SWTUIPlayer p) {
		super(w, p);
	}

	@Override
	public boolean isSuitableForKind(GenericElementKind kind) {

		if (widget instanceof NatTable && kind.is(ElementKind.Canvas))
			return true;

		return super.isSuitableForKind(kind);
	}

}
