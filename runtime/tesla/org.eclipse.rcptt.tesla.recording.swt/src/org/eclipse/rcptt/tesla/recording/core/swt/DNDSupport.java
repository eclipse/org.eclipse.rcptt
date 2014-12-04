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
package org.eclipse.rcptt.tesla.recording.core.swt;

import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.core.protocol.DragKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

public class DNDSupport {
	private TeslaRecorder recorder;

	private Element enterWidget;

	public DNDSupport() {
	}

	public void setRecorder(TeslaRecorder recorder) {
		this.recorder = recorder;
	}

	public void processUniversalDND(Event event) {
		if (recorder == null) {
			return;
		}

		SWTWidgetLocator locator = SWTRecordingHelper.getHelper().getLocator();

		String style = "";
		style += "detail:" + event.detail + ",";
		style += "button:" + event.button + ",";
		style += "mask:" + event.stateMask + ",";
		style += "operations:-1";

		if (event.widget instanceof DragSource) {
			DragSource source = (DragSource) event.widget;
			Control widget = source.getControl();

			ControlUIElement control = new ControlUIElement(
					locator.findElement(widget, true, false, false).element,
					locator.getRecorder());
			switch (event.type) {
			case DND.DragStart:
				control.drag(DragKind.START, event.x, event.y, style);
				break;
			case DND.DragSetData:
				control.drag(DragKind.SET_DATA, null, null, style);
				break;
			case DND.DragEnd:
				control.drag(DragKind.END, null, null, style);
				break;
			}
		} else if (event.widget instanceof DropTarget) {
			DropTarget target = (DropTarget) event.widget;
			Control widget = target.getControl();

			if (widget instanceof Shell) {
				return;
			}

			FindResult el = locator.findElement(widget, true, false, false);
			if (el == null) {
				return;
			}
			ControlUIElement control = new ControlUIElement(el.element,
					locator.getRecorder());
			Point clientPoint = widget.toControl(event.x, event.y);
			switch (event.type) {
			case DND.DragEnter:
				control.drag(DragKind.ENTER, clientPoint.x, clientPoint.y,
						style);
				break;
			case DND.DragOver:
				control.drag(DragKind.OVER, clientPoint.x, clientPoint.y, style);
				break;
			case DND.DragLeave:
				control.drag(DragKind.LEAVE, null, null, style);
				break;
			case DND.DropAccept:
				control.drag(DragKind.ACCEPT, clientPoint.x, clientPoint.y,
						style);
				break;
			case DND.Drop:
				control.drag(DragKind.DROP, clientPoint.x, clientPoint.y, style);
				break;
			}
		}
	}

	public void processDND(Event event) {
		if (recorder == null) {
			return;
		}
		Control realWidget = null;
		if (event.widget instanceof DropTarget) {
			realWidget = ((DropTarget) event.widget).getControl();
		} else if (event.widget instanceof DragSource) {
			realWidget = ((DragSource) event.widget).getControl();
		}

		if (realWidget == null)
			return;

		Widget item = event.item;
		if (item == null) {
			item = realWidget;
		}

		// System.out.println(event + " " + realWidget + " " + item);

		Point controlPoint = new Point(event.x, event.y);
		if (event.widget instanceof DropTarget) {
			controlPoint = realWidget.toControl(event.x, event.y);
		}
		// if( event.type == DND.DragLeave) {
		// controlPoint = new Point(0, 0);
		// }
		IRecordingDescriber describer = null;
		describer = RecordingDescriberManager.getDescriber(item,
				controlPoint.x, controlPoint.y, false);
		Point point = null;
		Point offset = null;
		Element itemElement = null;
		if (describer != null) {

			if (!describer.supportsDND()) {
				processUniversalDND(event);
				return;
			}

			point = describer.getRealPoint();
			point = realWidget.toControl(point);

			offset = new Point(controlPoint.x - point.x, controlPoint.y
					- point.y);
			if (event.type == DND.DragLeave || event.type == DND.DragSetData
					|| event.type == DND.DragEnd) {
				offset = new Point(0, 0);
			}
			itemElement = describer.searchForElement(recorder);
		} else {
			TeslaCore.log("Failed to locate element for drag&drop operation:"
					+ realWidget.getClass().getCanonicalName());
			return;
		}

		ControlUIElement control;
		if (event.type != DND.DragEnd && event.type != DND.DragSetData)
			control = new ControlUIElement(itemElement, recorder);
		else {
			SWTWidgetLocator locator = SWTRecordingHelper.getHelper()
					.getLocator();
			control = new ControlUIElement(locator.findElement(realWidget,
					false, false, false).element, locator.getRecorder());
		}

		String style = "";
		style += "detail:" + event.detail + ",";
		style += "button:" + event.button + ",";
		style += "mask:" + event.stateMask + ",";
		style += "operations:-1";

		switch (event.type) {
		case DND.DragStart:
			control.drag(DragKind.START, offset.x, offset.y, style);
			break;
		case DND.DragEnd:
			control.drag(DragKind.END, null, null, style);
			break;
		case DND.DragOver:
			control.drag(DragKind.OVER, offset.x, offset.y, style);
			break;
		case DND.DragEnter:
			enterWidget = itemElement;
			control.drag(DragKind.ENTER, offset.x, offset.y, style);
			break;
		case DND.DragSetData:
			control.drag(DragKind.SET_DATA, null, null, style);
			break;
		case DND.DropAccept:
			control.drag(DragKind.ACCEPT, offset.x, offset.y, style);
			break;
		case DND.DragLeave:
			control = new ControlUIElement(enterWidget, recorder);
			control.drag(DragKind.LEAVE, null, null, style);
			break;
		case DND.Drop:
			control.drag(DragKind.DROP, offset.x, offset.y, style);
			break;
		}
	}
}
