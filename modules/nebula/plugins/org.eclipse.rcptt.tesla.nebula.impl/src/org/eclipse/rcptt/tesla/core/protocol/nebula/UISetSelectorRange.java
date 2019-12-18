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
import org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange;

public class UISetSelectorRange extends UISetSelector {

	private List<String> toPath = null;
	private MultiSelectionItemEx from = null;
	private MultiSelectionItemEx to = null;

	public UISetSelectorRange(IUIPlayer player) {
		super(player);
	}

	public UISetSelectorRange(UISetSelectorRange sel) {
		super(sel);

		UISetSelectorRange ssr = (UISetSelectorRange) sel;
		if (ssr.toPath != null)
			toPath = new ArrayList<String>(ssr.toPath);
		from = ssr.from;
		to = ssr.to;
	}

	//

	public UISetSelectorRange toPath(List<String> toPath) {
		UISetSelectorRange ns = (UISetSelectorRange) createClone();
		ns.toPath = toPath;
		return ns;
	}

	public UISetSelectorRange from(MultiSelectionItemEx from) {
		UISetSelectorRange ns = (UISetSelectorRange) createClone();
		ns.from = from;
		return ns;
	}

	public UISetSelectorRange to(MultiSelectionItemEx to) {
		UISetSelectorRange ns = (UISetSelectorRange) createClone();
		ns.to = to;
		return ns;
	}

	//

	@Override
	protected UISetSelector createClone() {
		return new UISetSelectorRange(this);
	}

	@Override
	protected SetSelection createSetSelection() {
		return NebulaFactory.eINSTANCE.createSetSelectionRange();
	}

	@Override
	protected void initSetSelection(SetSelection sel, boolean all) {
		super.initSetSelection(sel, all);

		SetSelectionRange ssr = (SetSelectionRange) sel;
		if (toPath != null)
			ssr.getToPath().addAll(toPath);
		ssr.setFrom(from);
		ssr.setTo(to);
	}

}
