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
package org.eclipse.rcptt.tesla.nebula.grid.selection;

import java.util.ArrayList;

import org.eclipse.core.runtime.Assert;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.osgi.util.NLS;

import org.eclipse.rcptt.tesla.core.protocol.BooleanResponse;
import org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.ui.SWTElementMapper;
import org.eclipse.rcptt.tesla.nebula.NebulaUIElement;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemCell;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;
import org.eclipse.rcptt.tesla.nebula.grid.parts.RowHeader;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;
import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;
import org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionEx;
import org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange;
import org.eclipse.rcptt.tesla.swt.TeslaSWTMessages;

public class GridSetSelectionProcessor {

	public static Response executePartSelection(SetSelectionEx c, SWTElementMapper mapper) {
		final NebulaUIElement element = (NebulaUIElement) mapper.get(c.getElement());

		BooleanResponse response = ProtocolFactory.eINSTANCE.createBooleanResponse();
		try {
			ArrayList<ItemPart> parts = new ArrayList<ItemPart>();
			for (MultiSelectionItem msi : c.getAdditionalItems()) {
				Assert.isTrue(msi instanceof MultiSelectionItemEx);
				parts.add(gridPartFrom((MultiSelectionItemEx) msi, element));
			}

			boolean selected = GridSetSelectionViewers.setMultiSelectionEx(element, parts);
			response.setResult(selected);
		} catch (Exception e) {
			response.setResult(false);
			response.setStatus(ResponseStatus.FAILED);
			response.setMessage(NLS.bind(TeslaSWTMessages.SWTUIProcessor_CannotSetSelection, e.getMessage()));
		}
		return response;
	}

	public static ItemPart gridPartFrom(MultiSelectionItemEx msie, NebulaUIElement gridE) {
		GridItem item = NebulaViewers.searchGridItem(gridE, msie.getPath());
		if (msie.isRowHeader())
			return new RowHeader(item);
		else if (msie.getCellColumn() != null)
			return ItemCell.from(msie.getCellColumn(), item);

		throw new IllegalArgumentException("Cannot create an item part from the command");
	}

	//

	public static Response executeRangeSelection(SetSelectionRange c, SWTElementMapper mapper) {
		final NebulaUIElement grid = (NebulaUIElement) mapper.get(c.getElement());

		BooleanResponse response = ProtocolFactory.eINSTANCE.createBooleanResponse();

		if (c.getFrom() != null) {
			Assert.isNotNull(c.getTo());
			// item parts
			ItemPart from = gridPartFrom(c.getFrom(), grid);
			ItemPart to = gridPartFrom(c.getTo(), grid);
			
			boolean selected = GridSetSelectionViewers.setSelectionRangeEx(grid, from, to);
			response.setResult(selected);
		} else {
			// item paths
			GridItem fromItem = NebulaViewers.searchGridItem(grid, c.getPath());
			GridItem toItem = NebulaViewers.searchGridItem(grid, c.getToPath());

			boolean selected = GridSetSelectionViewers.setSelectionRange(grid, fromItem, toItem);
			response.setResult(selected);
		}

		return response;
	}

}
