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

import org.eclipse.rcptt.tesla.core.protocol.BasicUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ItemUIElement;
import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.UISelector;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds;

public class NebulaItemUIElement extends ItemUIElement {
	private static class Selector {
		public UISelector<BasicUIElement> rowHeader;
		public UISelector<BasicUIElement> itemCell;
		public UISelector<BasicUIElement> emptyArea;
	}

	private Selector selector = new Selector();

	public NebulaItemUIElement(Element e, UIPlayer player) {
		super(e, player);
		selector.rowHeader = new UISelector<BasicUIElement>(
				NebulaElementKinds.ROW_HEADER,
				player, BasicUIElement.class).parent(getElement());
		selector.itemCell = new UISelector<BasicUIElement>(
				NebulaElementKinds.ITEM_CELL,
				player, BasicUIElement.class).parent(getElement());
		selector.emptyArea = new UISelector<BasicUIElement>(
				NebulaElementKinds.EMPTY_AREA,
				player, BasicUIElement.class).parent(getElement());
	}

	//

	public BasicUIElement rowHeader() {
		return selector.rowHeader.find();
	}

	public BasicUIElement itemCell(String columnTitle) {
		return selector.itemCell.find(columnTitle);
	}

	public BasicUIElement emptyArea() {
		return selector.emptyArea.find();
	}

}
