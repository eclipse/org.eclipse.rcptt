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
package org.eclipse.rcptt.tesla.core.protocol.nebula;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.IUIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.SetSelection;
import org.eclipse.rcptt.tesla.core.protocol.UISetSelector;
import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;
import org.eclipse.rcptt.tesla.protocol.nebula.NebulaFactory;
import org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionEx;

public class UISetSelectorEx extends UISetSelector {

	private List<MultiSelectionItemEx> additionalSelectionsEx;

	public UISetSelectorEx(IUIPlayer player) {
		super(player);
	}

	public UISetSelectorEx(UISetSelectorEx sel) {
		super(sel);

		if (sel.additionalSelectionsEx != null)
			this.additionalSelectionsEx = new ArrayList<MultiSelectionItemEx>(sel.additionalSelectionsEx);
	}

	//

	public UISetSelectorEx additional(List<MultiSelectionItemEx> msies) {
		UISetSelectorEx ns = (UISetSelectorEx) createClone();
		ns.additionalSelectionsEx = msies;
		return ns;
	}

	//

	@Override
	protected UISetSelector createClone() {
		return new UISetSelectorEx(this);
	}

	@Override
	protected SetSelection createSetSelection() {
		return NebulaFactory.eINSTANCE.createSetSelectionEx();
	}

	@Override
	protected void initSetSelection(SetSelection sel, boolean all) {
		super.initSetSelection(sel, all);

		SetSelectionEx sse = (SetSelectionEx) sel;
		
		// using only additional items feature for simplicity
		sse.getAdditionalItems().addAll(additionalSelectionsEx);
	}
}
