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
package org.eclipse.rcptt.tesla.nebula.nattable.describer;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.nebula.nattable.NatTableHelper;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellPosition;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTablePartElement;
import org.eclipse.rcptt.tesla.nebula.nattable.processors.NatTableProcessor;
import org.eclipse.rcptt.tesla.ui.describers.IDescriberExtension;
import org.eclipse.rcptt.tesla.ui.describers.IWidgetDescriber;
import org.eclipse.rcptt.tesla.ui.describers.WidgetDescriber;
import org.eclipse.swt.widgets.Widget;

public class NatTableDescriberExtension implements
		IDescriberExtension {

	@Override
	public IWidgetDescriber getDescriber(Widget widget, IWidgetDescriber previous, int x, int y) {
		return getItemAt(new WidgetDescriber(widget), x, y);
	}

	@Override
	public IWidgetDescriber getDescriber(Element element, AbstractTeslaClient client) {
		NatTableProcessor processor = client.getProcessor(NatTableProcessor.class);
		NatTablePartElement natTableElement = processor.getMapper().get(element);
		if (natTableElement != null) {
			Widget widget = PlayerWrapUtils.unwrapWidget(natTableElement.getNatTable());
			if (widget instanceof NatTable)
				return new WidgetDescriber(widget);
		}

		return null;
	}

	private IWidgetDescriber getItemAt(IWidgetDescriber descr, int x, int y) {
		Widget base = descr.getWidget();

		if (base instanceof NatTable) {
			NatTable natTable = (NatTable) base;
			NatTableCellPosition position = NatTableHelper.getCellPosition(natTable, x, y);
			if (position != null) {
				return new NatTableCellDescriber(natTable, position);
			}
		}

		return descr;
	}

}
