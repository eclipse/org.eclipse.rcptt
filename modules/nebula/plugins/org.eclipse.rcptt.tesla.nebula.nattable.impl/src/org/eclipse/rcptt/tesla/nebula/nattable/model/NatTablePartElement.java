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

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;

public abstract class NatTablePartElement extends SWTUIElement {

	protected final NatTableSWTElement natTable;

	public NatTablePartElement(NatTableSWTElement natTable) {
		super(natTable.widget, natTable.getPlayer());
		this.natTable = natTable;
	}

	public NatTableSWTElement getNatTable() {
		return natTable;
	}

}
