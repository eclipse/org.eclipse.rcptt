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
package org.eclipse.rcptt.tesla.recording.core.gef;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.context.ContextManagement;
import org.eclipse.rcptt.tesla.core.features.IMLFeatures;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.diagram.FigureUIElement;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.recording.aspects.draw2d.Draw2DEventManager;
import org.eclipse.rcptt.tesla.recording.aspects.draw2d.IDraw2DEventListener;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessorExtension;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.BasicRecordingHelper.ElementEntry;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTEventRecorder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;

public class Draw2dEventRecorder implements IRecordingProcessor,
		IDraw2DEventListener, IRecordingProcessorExtension {

	private TeslaRecorder recorder;
	private SWTEventRecorder swtProcessor;

	// private boolean mouseDownActive = false;

	public Draw2dEventRecorder() {
		Draw2DEventManager.addListener(this);
	}

	public void clear() {
		Draw2DRecordingHelper.getHelper().clear();
	}

	public void initialize(TeslaRecorder teslaRecorder) {
		recorder = teslaRecorder;
	}

	public int getInitLevel() {
		return 900;
	};

	private synchronized SWTEventRecorder getSWTProcessor() {
		if (swtProcessor == null) {
			swtProcessor = recorder.getProcessor(SWTEventRecorder.class);
		}
		return swtProcessor;
	}

	public void setFreeze(boolean value, SetMode command) {
	}

	public void mouseDoubleClick(SWTEventDispatcher disp, MouseEvent event) {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		mouseOp(event, MouseCommandKind.DOUBLE_CLICK, disp);
	}

	public void mouseEntered(SWTEventDispatcher disp, MouseEvent event) {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		mouseOp(event, MouseCommandKind.ENTER, disp);
	}

	public void mouseExited(SWTEventDispatcher disp, MouseEvent event) {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		mouseOp(event, MouseCommandKind.EXIT, disp);
	}

	public void mouseHover(SWTEventDispatcher disp, MouseEvent event) {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		mouseOp(event, MouseCommandKind.HOVER, disp);
	}

	public void mouseMoved(SWTEventDispatcher disp, MouseEvent event) {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		if ((event.stateMask & SWT.BUTTON_MASK) != 0) {
			mouseOp(event, MouseCommandKind.DRAG, disp);
		}
		else {
			mouseOp(event, MouseCommandKind.MOVE, disp);
		}
	}

	public void mousePressed(SWTEventDispatcher disp, MouseEvent event) {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		mouseOp(event, MouseCommandKind.DOWN, disp);
	}

	private FigureUIElement getFigureByAddress(FigureUIElement diagramViewer,
			IFigure figure, List<Integer> address) {
		ElementEntry el = Draw2DRecordingHelper.getHelper().get(figure);
		FigureUIElement element = null;
		if (el != null) {
			element = new FigureUIElement(el.getElement(), recorder);
		} else {
			element = diagramViewer.rawFigure(address);
			Draw2DRecordingHelper.getHelper().put(figure,
					new ElementEntry(element.getElement()));
		}
		return element;
	}

	private void mouseOp(MouseEvent event, MouseCommandKind op,
			SWTEventDispatcher disp) {
		if (TeslaFeatures.getInstance().isTrue(IMLFeatures.USE_IMAGING)
				&& !TeslaFeatures.getInstance().isTrue(
						IMLFeatures.USE_IMAGING_RAW_CANVAS)) {
			return;
		}
		if (ContextManagement.currentContext().containsClass(
				"org.eclipse.gef.ui.parts.DomainEventDispatcher")) {
			return;
		}
		List<IRecordingProcessorExtension> list = recorder.getProcessors(
				IRecordingProcessorExtension.class);
		for (IRecordingProcessorExtension ext : list) {
			if (event.widget instanceof Canvas && ext.isNotDraw2d(event.widget)) {
				return;
			}
		}
		// check for mouse target, and if pressent if and only if record event
		FindResult canvas = getSWTProcessor().getLocator().findElement(
				event.widget, false, false, false);
		if (canvas != null) {
			DiagramViewerUIElement canvasCtrl = new DiagramViewerUIElement(
					canvas.element, recorder);
			if (event.widget instanceof FigureCanvas) {
				FigureCanvas cv = (FigureCanvas) event.widget;
				IFigure figure = cv.getContents();
				FigureAddress fa = getAddress(figure, event.x, event.y);
				if (op.equals(MouseCommandKind.DRAG)) {
					// Always record drags over a root figure
					fa.lastFigure = figure;
					fa.path.clear();
				}
				org.eclipse.draw2d.geometry.Rectangle bounds = fa.lastFigure
						.getBounds().getCopy();
				fa.lastFigure.translateToAbsolute(bounds);
				int px = event.x - bounds.x;
				int py = event.y - bounds.y;
				// Click over diagram operation.
				Rectangle bounds2 = cv.getBounds();

				if (fa.path != null && fa.path.size() > 0) {
					FigureUIElement element = getFigureByAddress(
							canvasCtrl, fa.lastFigure, fa.path);
					element.executeFigureMouseCommand(px, py, event.button,
							op, null, null, bounds2.width, bounds2.height,
							bounds.width, bounds.height, event.stateMask);
					return;
				}

				canvasCtrl.executeFigureMouseCommand(px, py, event.button,
						op, null, fa.path, bounds2.width, bounds2.height,
						bounds.width, bounds.height, event.stateMask);
			}
		}
	}

	public static class FigureAddress {
		public List<Integer> path;
		public IFigure lastFigure;
	}

	@SuppressWarnings("rawtypes")
	public static FigureAddress getAddress(IFigure figure, int x, int y) {
		List<Integer> path = new ArrayList<Integer>();
		while (figure != null) {
			List children = figure.getChildren();
			boolean changed = false;
			for (Object child : children) {
				if (child instanceof IFigure) {
					if (((IFigure) child).containsPoint(x, y)) {
						path.add(children.indexOf(child));
						figure = (IFigure) child;
						changed = true;
						break;
					}
				}
			}
			if (!changed) {
				break;
			}
		}
		FigureAddress fa = new FigureAddress();
		fa.lastFigure = figure;
		fa.path = path;
		return fa;
	}

	public void mouseReleased(SWTEventDispatcher disp, MouseEvent event) {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		mouseOp(event, MouseCommandKind.UP, disp);
	}

	public void resetAssertSelection() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IRecordingHelper getHelper() {
		return Draw2DRecordingHelper.getHelper();
	}

	@Override
	public boolean isIgnored(Object widget, int type, Object event) {
		return false;
	}

	@Override
	public boolean isNotCanvas(Object widget, int type, Object event) {
		if (widget instanceof FigureCanvas) {
			return true;
		}
		// Check if this one have light
		return false;
	}

	@Override
	public boolean isNotDraw2d(Object widget) {
		return false;
	}

	@Override
	public boolean isPartOfParent(Object widget, Object parent) {
		return false;
	}
}
