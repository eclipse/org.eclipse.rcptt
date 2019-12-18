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
package org.eclipse.rcptt.tesla.recording.canvas;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.features.IMLFeatures;
import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.recording.aspects.IBasicSWTEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.SWTEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTEventRecorder;

public class CanvasRecordingProcessor implements IRecordingProcessor,
		IBasicSWTEventListener {

	private TeslaRecorder recorder;
	private SWTEventRecorder eventRecorder;
	private Set<Widget> workingWidgets = new HashSet<Widget>();

	public CanvasRecordingProcessor() {
		SWTEventManager.addListener(this);
	}

	public int getInitLevel() {
		return 1000;
	};

	public void initialize(TeslaRecorder teslaRecorder) {
		this.recorder = teslaRecorder;
	}

	public TeslaRecorder getRecorder() {
		return recorder;
	}

	private synchronized SWTEventRecorder getSWTEventRecorder() {
		if (eventRecorder == null) {
			eventRecorder = recorder.getProcessor(SWTEventRecorder.class);
		}
		return eventRecorder;
	}

	public void recordEvent(Widget widget, int type, Event event) {
		if (getRecorder() == null) {
			return;
		}
		if (!getRecorder().hasListeners()) {
			return;
		}
		SWTEventRecorder swtRecorder = getSWTEventRecorder();
		if (swtRecorder == null) {
			return;
		}
		if (swtRecorder.isIgnored(widget)) {
			return;
		}
		if (swtRecorder.isNotNative(widget)) {
			return;
		}
		if (TeslaFeatures.getInstance().isTrue(IMLFeatures.USE_IMAGING)) {
			return;
		}
		if (widget instanceof Canvas && swtRecorder.isCanvas(widget, type)) {
			if (type != SWT.MouseEnter && type != SWT.MouseExit
					&& type != SWT.MouseHover) {
				if (type != SWT.MouseMove) {
					workingWidgets.add(widget);
				}
				if (workingWidgets.contains(widget)) {
					FindResult canvas = swtRecorder.getLocator().findElement(
							widget, false, false, false);
					if (canvas != null) {
						processCavas(widget, type, event, canvas);
					}
				}
			}
		}
	}

	private void processCavas(Widget widget, int type, Event event,
			FindResult canvas) {
		if (canvas != null) {

			ControlUIElement canvasCtrl = new ControlUIElement(canvas.element,
					getRecorder());
			Canvas cv = (Canvas) widget;
			final Rectangle bounds = cv.getBounds();
			switch (type) {
			case SWT.MouseEnter:
				// canvasCtrl.executeMouseCommand(event.x, event.y,
				// event.button,
				// MouseCommandKind.ENTER, bounds.width, bounds.height,
				// event.stateMask);
				break;
			case SWT.MouseExit:
				// canvasCtrl.executeMouseCommand(event.x, event.y,
				// event.button,
				// MouseCommandKind.EXIT, bounds.width, bounds.height,
				// event.stateMask);
				break;
			case SWT.MouseHover:
				canvasCtrl.executeMouseCommand(event.x, event.y, event.button,
						MouseCommandKind.HOVER, bounds.width, bounds.height,
						event.stateMask);
				break;
			case SWT.MouseDown:
				canvasCtrl.executeMouseCommand(event.x, event.y, event.button,
						MouseCommandKind.DOWN, bounds.width, bounds.height,
						event.stateMask);
				break;
			case SWT.MouseUp:
				canvasCtrl.executeMouseCommand(event.x, event.y, event.button,
						MouseCommandKind.UP, bounds.width, bounds.height,
						event.stateMask);
				break;
			case SWT.MouseMove:
				canvasCtrl.executeMouseCommand(event.x, event.y, event.button,
						MouseCommandKind.MOVE, bounds.width, bounds.height,
						event.stateMask);
				break;
			case SWT.MouseDoubleClick:
				canvasCtrl.executeMouseCommand(event.x, event.y, event.button,
						MouseCommandKind.DOUBLE_CLICK, bounds.width,
						bounds.height, event.stateMask);
				break;

			}
		}
	}

	public void clear() {
		workingWidgets.clear();
	}

	public void setFreeze(boolean value, SetMode command) {
	}

	public void resetAssertSelection() {
	}

	public IRecordingHelper<?> getHelper() {
		return null;
	}

	public boolean isExclusiveEventHandle(Widget widget, int type, Event event) {
		return false;
	}
}
