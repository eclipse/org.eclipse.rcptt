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
package org.eclipse.rcptt.tesla.core.protocol.nebula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.BasicUIElement;
import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.UISelector;
import org.eclipse.rcptt.tesla.core.protocol.ViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemCell;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;
import org.eclipse.rcptt.tesla.nebula.grid.parts.RowHeader;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;
import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;
import org.eclipse.rcptt.tesla.protocol.nebula.NebulaFactory;

public class NebulaGridUIElement extends ViewerUIElement {
	private static class Selector {
		public UISelector<BasicUIElement> emptyArea;
		public UISetSelectorEx setItemEx;
		public UISetSelectorRange setItemRange;
	}

	private Selector selector = new Selector();

	public NebulaGridUIElement(Element e, UIPlayer player) {
		super(e, player);
		selector.emptyArea = new UISelector<BasicUIElement>(
				NebulaElementKinds.EMPTY_AREA,
				player, BasicUIElement.class).parent(getElement());
		selector.setItemEx = (UISetSelectorEx) new UISetSelectorEx(player).parent(element);
		selector.setItemRange = (UISetSelectorRange) new UISetSelectorRange(player).parent(element);
	}

	//

	public BasicUIElement emptyArea(String[] path) {
		return selector.emptyArea.path(path).find();
	}

	// for recording
	public boolean setSelectionEx(Iterable<ItemPart> parts) { // String[] selPath, GridPart part) {
		// path must not be null, as there is some code using that value:
		UISetSelectorEx sel = (UISetSelectorEx) selector.setItemEx.path("");

		List<MultiSelectionItemEx> msies = new ArrayList<MultiSelectionItemEx>(1);
		for (ItemPart part : parts)
			msies.add(msieFromItemPart(part));

		sel = sel.additional(msies);
		return sel.select();
	}

	// for replaying
	public boolean setMultiSelectionEx(List<MultiSelectionItemEx> msies) {
		UISetSelectorEx sel = selector.setItemEx;
		sel = sel.additional(msies);
		return sel.select();
	}

	//

	public boolean setSelectionRange(List<String> fromPath, List<String> toPath) {
		return selector.setItemRange.toPath(toPath).pathList(fromPath).select();
	}

	public boolean setSelectionRange(String[] fromPath, String[] toPath) {
		return setSelectionRange(Arrays.asList(fromPath), Arrays.asList(toPath));
	}

	// for replaying
	public boolean setSelectionRange(MultiSelectionItemEx from, MultiSelectionItemEx to) {
		return selector.setItemRange.to(to).from(from).select();
	}

	// for recording
	public boolean setSelectionRange(ItemPart from, ItemPart to) {
		return setSelectionRange(msieFromItemPart(from), msieFromItemPart(to));
	}

	//

	private static MultiSelectionItemEx msieFromItemPart(ItemPart part) {
		String[] selPath = NebulaViewers.getPathByGridItem(part.item);

		MultiSelectionItemEx msie = NebulaFactory.eINSTANCE.createMultiSelectionItemEx();
		msie.getPath().addAll(Arrays.asList(selPath));
		if (part instanceof RowHeader)
			msie.setRowHeader(true);
		if (part instanceof ItemCell)
			msie.setCellColumn(((ItemCell) part).column.getText());
		return msie;
	}

}
