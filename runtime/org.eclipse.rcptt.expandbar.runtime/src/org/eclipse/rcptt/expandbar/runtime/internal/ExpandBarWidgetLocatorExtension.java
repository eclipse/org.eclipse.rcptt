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
package org.eclipse.rcptt.expandbar.runtime.internal;

import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.BasicUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.ItemUIElement;
import org.eclipse.rcptt.tesla.core.protocol.UISelector;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.recording.core.swt.BasicRecordingHelper.ElementEntry;
import org.eclipse.rcptt.tesla.recording.core.swt.IWidgetClassifierExtension;
import org.eclipse.rcptt.tesla.recording.core.swt.IWidgetLocatorExtension;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTWidgetLocator;

public class ExpandBarWidgetLocatorExtension implements IWidgetLocatorExtension {
	private SWTWidgetLocator locator;

	public ExpandBarWidgetLocatorExtension(SWTWidgetLocator locator) {
		this.locator = locator;
	}

	@Override
	public FindResult findElement(SWTUIElement widget, boolean unknownAllowed, boolean alwaysFindLeaf,
			boolean supportEclipseWorkbench) {
		ElementEntry entry = ExpandBarRecordingHelper.getHelper().get(widget);
		if (entry != null && !alwaysFindLeaf) {
			return new FindResult(widget, entry.getElement());
		}

		BasicUIElement found = null;

		// Actual finding code
		Widget realWidget = widget.unwrap();
		if (realWidget instanceof ExpandItem) {
			found = findExpandItem((ExpandItem) realWidget);
		}

		if (realWidget instanceof ExpandBar) {

		}
		// End of actual finding code
		if (found != null) {
			ExpandBarRecordingHelper.getHelper().put(widget, new ElementEntry(found.getElement()));
			return new FindResult(widget, found.getElement());
		}
		return null;
	}

	private BasicUIElement findExpandItem(ExpandItem item) {
		ExpandBar bar = item.getParent();
		BasicUIElement expandBar = findExpandBar(bar);
		UISelector<ItemUIElement> itemSelector = new UISelector<ItemUIElement>(ElementKind.Item, locator.getRecorder(),
				ItemUIElement.class).parent(expandBar.getElement());
		locator.getRecorder().setControls(SWTModelMapper.map(locator.getPlayer().wrap(item)));
		return itemSelector.path(ItemLocation.fromItem(item).toPathFragment()).find();
	}

	private BasicUIElement findExpandBar(ExpandBar expandBar) {
		FindResult barResult = locator.findElement(locator.getPlayer().wrap(expandBar), false, false, false);
		return new BasicUIElement(barResult.element, locator.getRecorder());
	}

	@Override
	public IWidgetClassifierExtension getWidgetClassifierExtension() {
		// TODO Auto-generated method stub
		return null;
	}

}
