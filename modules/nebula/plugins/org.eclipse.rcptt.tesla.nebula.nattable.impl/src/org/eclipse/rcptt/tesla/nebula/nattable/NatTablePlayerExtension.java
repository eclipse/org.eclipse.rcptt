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
package org.eclipse.rcptt.tesla.nebula.nattable;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.internal.ui.player.AbstractSWTUIPlayerExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.ChildrenCollectingSession;
import org.eclipse.rcptt.tesla.internal.ui.player.IChildrenCollectingExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerSelectionFilter;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.nattable.ecl.NebulaNatTableElementKinds;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableSWTElement;
import org.eclipse.swt.widgets.Widget;

public class NatTablePlayerExtension extends AbstractSWTUIPlayerExtension {

	@Override
	public SWTUIElement wrap(Object s, SWTUIPlayer p) {
		if (s instanceof NatTable)
			return new NatTableSWTElement((Widget) s, p);
		return null;
	}

	@Override
	public SWTUIElement select(SWTUIPlayer swtuiPlayer, PlayerSelectionFilter f) {
		if (f.kind.kind == ElementKind.Custom && f.kind.is(NebulaNatTableElementKinds.NAT_TABLE))
			return swtuiPlayer.selectWidget(f.withoutPattern(), false, NatTable.class);

		return null;
	}

	@Override
	public GenericElementKind getKind(Object w) {
		if (w instanceof NatTable)
			return new GenericElementKind(NebulaNatTableElementKinds.NAT_TABLE);

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
}
