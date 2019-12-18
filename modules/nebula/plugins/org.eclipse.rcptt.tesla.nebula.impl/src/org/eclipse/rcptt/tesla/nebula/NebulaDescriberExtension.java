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
package org.eclipse.rcptt.tesla.nebula;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.ui.describers.IDescriberExtension;
import org.eclipse.rcptt.tesla.ui.describers.IWidgetDescriber;
import org.eclipse.rcptt.tesla.ui.describers.WidgetDescriber;

public class NebulaDescriberExtension implements IDescriberExtension {

	public IWidgetDescriber getDescriber(Widget widget,
			IWidgetDescriber previous, int x, int y) {
		return getItemAt(new WidgetDescriber(widget), x, y);
	}

	public IWidgetDescriber getDescriber(Element element,
			AbstractTeslaClient client) {
		NebulaUIProcessor processor = client
				.getProcessor(NebulaUIProcessor.class);
		SWTUIElement swtuiElement = processor.getMapper().get(element);
		if (swtuiElement != null) {
			Widget widget = PlayerWrapUtils.unwrapWidget(swtuiElement);
			if (widget instanceof Grid)
				return new NebulaDescriber(widget);
			else if (widget instanceof GridItem)
				return new NebulaDescriber(widget);
		}

		return null;
	}

	// --

	private IWidgetDescriber getItemAt(IWidgetDescriber descr, int x, int y) {
		Widget base = descr.getWidget();

		if (base instanceof Grid) {
			Grid grid = (Grid) base;
			GridItem item = grid.getItem(new Point(x, y));
			if (item != null)
				return new NebulaDescriber(item);
		}

		return descr;
	}
}
