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
import org.eclipse.rcptt.tesla.core.protocol.ViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.ISWTModelMapperExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.nebula.nattable.NatTableHelper;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellPosition;
import org.eclipse.rcptt.tesla.nebula.nattable.processors.NatTableProcessor;
import org.eclipse.rcptt.tesla.recording.aspects.IBasicSWTEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.SWTEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTWidgetLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

public class NatTableRecordingProcessor implements IRecordingProcessor, IBasicSWTEventListener,
		ISWTModelMapperExtension {

	private static int[] interestingEvents = { SWT.Selection, SWT.MouseDoubleClick, SWT.MouseDown, SWT.MouseUp };

	private Event mouseDownEvent;
	private SWTWidgetLocator locator;

	public SWTWidgetLocator getLocator() {
		if (locator == null) {
			locator = SWTRecordingHelper.getHelper().getLocator();
		}
		return locator;
	}

	public NatTableRecordingProcessor() {
		super();
		SWTEventManager.addListener(this);
	}


	@Override
	public void recordEvent(Widget widget, int type, Event event) {
		// ignoring not interesting events,
		// it is essential to filter some event types like focusing
		// to correctly determine menu source
		if (widget instanceof NatTable && isInterestingEvent(type)) {
			FindResult result = getLocator().findElement(widget, true, false, false);
			NatTable natTable = (NatTable) widget;
			switch (type) {
			case SWT.Selection:
				break;

			case SWT.MouseDown:
				if (NatTableHelper.isNatTableCell(natTable, event.x, event.y)) {
					// store where mouse click was started
					mouseDownEvent = event;
				}

				break;

			case SWT.MouseUp:

				// handle events only if event started on NatTable widget
				if (mouseDownEvent != null) {
					if (NatTableHelper.isNatTableCell(natTable, event.x, event.y)) {
						NatTableCellPosition clickStartPosition = NatTableHelper.getCellPosition(natTable,
								mouseDownEvent.x, mouseDownEvent.y);
						NatTableCellPosition clickEndPosition = NatTableHelper.getCellPosition(natTable, event.x,
								event.y);
						if (clickStartPosition.equals(clickEndPosition)) {
							if (NatTableHelper.isEditable(natTable, clickEndPosition)) {
								recordActivateCellEditor(natTable, result, clickEndPosition);
							} else {
								recordCellSelection(natTable, result, clickEndPosition);
							}

						} else {
							// TODO: support multi selection
							recordCellSelection(natTable, result, clickStartPosition);
						}

					}
					mouseDownEvent = null;
				}

				break;
			}

		}
	}

	private void recordActivateCellEditor(NatTable natTable, FindResult result, NatTableCellPosition position) {
		ViewerUIElement element = new ViewerUIElement(result.element, getLocator().getRecorder());
		boolean isPositionCooridinateRequired = NatTableHelper.isHeaderLayer(natTable, position.getCol(),
				position.getRow());
		String path = NatTableHelper.getPath(natTable, position, isPositionCooridinateRequired);
		element.setSelection(path);
		element.activateCellEditor(path);
	}

	private void recordCellSelection(NatTable natTable, FindResult result, NatTableCellPosition position) {
		ViewerUIElement element = new ViewerUIElement(result.element, getLocator().getRecorder());
		boolean isPositionCooridinateRequired = NatTableHelper.isHeaderLayer(natTable, position.getCol(),
				position.getRow());
		String path = NatTableHelper.getPath(natTable, position, isPositionCooridinateRequired);
		element.setSelection(path);
	}

	private boolean isInterestingEvent(int type) {
		for (Integer u : interestingEvents)
			if (u == type)
				return true;
		return false;
	}


	// IRecordingProcessor implementation

	@Override
	public void initialize(TeslaRecorder teslaRecorder) {

	}

	@Override
	public void clear() {
		mouseDownEvent = null;
		NatTableRecordingHelper.getHelper().clear();
		SWTModelMapper.initializeExtensions(getLocator().getRecorder().getProcessors(
				ISWTModelMapperExtension.class));
		getLocator().cleanMenuSources();
		locator = null;
	}

	@Override
	public void setFreeze(boolean value, SetMode command) {
	}

	@Override
	public void resetAssertSelection() {
	}

	@Override
	public IRecordingHelper<?> getHelper() {
		return NatTableRecordingHelper.getHelper();
	}

	@Override
	public boolean isExclusiveEventHandle(Widget widget, int type, Event event) {
		return (widget instanceof NatTable) && (type == SWT.MouseDown || type == SWT.MouseUp || type == SWT.MouseMove);
	}

	@Override
	public int getInitLevel() {
		return 20;
	}

	//


	@Override
	public org.eclipse.rcptt.tesla.core.ui.Widget mapExtraValues(SWTUIElement element,
			org.eclipse.rcptt.tesla.core.ui.Widget result) {
		return mapWidget(element, result);
	}

	public static org.eclipse.rcptt.tesla.core.ui.Widget mapWidget(
			SWTUIElement element, org.eclipse.rcptt.tesla.core.ui.Widget result) {
		return NatTableProcessor.mapWidget(element, result);
	}

}
