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
package org.eclipse.rcptt.tesla.recording.nebula.nattable;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.rcptt.logging.IQ7ActivityLogs;
import org.eclipse.rcptt.logging.Q7LoggingManager;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.nattable.describer.NatTableCellDescriber;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellElement;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellPosition;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableSWTElement;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.IRecordingDescriber;
import org.eclipse.rcptt.tesla.recording.core.swt.RecordingWidgetDescriber;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTWidgetLocator;

public class NatTableCellRecordingDescriber extends NatTableCellDescriber implements
		IRecordingDescriber {

	private boolean needLogging;

	public NatTableCellRecordingDescriber(NatTable widget, NatTableCellPosition cellPosition) {
		super(widget, cellPosition);
	}

	@Override
	public Element searchForElement(TeslaRecorder recorder) {
		SWTWidgetLocator locator = SWTRecordingHelper.getHelper().getLocator();
		FindResult result = null;
		NatTable natTable = (NatTable) getWidget();
		if (natTable != null) {
			if (needLogging) {
				if (TeslaFeatures.isActivityLogging()) {
					Q7LoggingManager.logMessage(
							IQ7ActivityLogs.ASSERTIONS,
							"looking identity for element: "
									+ natTable.getClass().getName());
				}
			}

			if (cellPosition != null) {
				NatTableSWTElement natTableElement = new NatTableSWTElement(natTable, SWTRecordingHelper.getHelper()
						.getPlayer());
				NatTableCellElement cell = new NatTableCellElement(natTableElement, cellPosition);
				result = locator.findElement(cell, true, false, true);
			} else {
				result = locator.findElement(natTable, true, false, true);
			}
		}
		if (result != null) {
			return result.element;
		}
		return null;
	}

	@Override
	public IRecordingDescriber getParent() {
		SWTWidgetLocator locator = SWTRecordingHelper.getHelper().getLocator();
		SWTUIPlayer pl = locator.getPlayer();
		SWTUIElement element = pl.getParentElement(pl.wrap(getWidget()));
		if (element == null) {
			return this;
		}
		return new RecordingWidgetDescriber(element);
	}

	@Override
	public void setNeedLogging(boolean fixed) {
		needLogging = fixed;
	}

}
