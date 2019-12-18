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
package org.eclipse.rcptt.tesla.recording.gef;

import java.util.List;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.diagram.FigureUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.gef.GefModelMapper;
import org.eclipse.rcptt.tesla.gef.GefUtils;
import org.eclipse.rcptt.tesla.gef.RawFigureUIElement;
import org.eclipse.rcptt.tesla.gef.describers.FigureDescriber;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.gef.GefRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.swt.BasicRecordingHelper.ElementEntry;
import org.eclipse.rcptt.tesla.recording.core.swt.IRecordingDescriber;

public class RecordingFigureDescriber extends FigureDescriber implements
		IRecordingDescriber {

	private FigureCanvas canvas;

	public RecordingFigureDescriber(IFigure figure, EditPart editPart,
			GraphicalViewer viewer, FigureCanvas canvas) {
		super(figure, editPart, viewer);
		this.canvas = canvas;
	}

	public Element searchForElement(TeslaRecorder recorder) {
		RawFigureUIElement uiEl = new RawFigureUIElement(getEditPart(),
				getFigure(), getViewer());
		ElementEntry e = GefRecordingHelper.getHelper().get(uiEl);
		if (e != null) {
			return e.getElement();
		}
		if (getEditPart() != null) {
			RecordingEditPartDescriber partDescr = new RecordingEditPartDescriber(
					getEditPart(), (GraphicalViewer) getEditPart().getViewer());
			Element element = partDescr.searchForElement(recorder);
			FigureUIElement partElement = new FigureUIElement(element, recorder);
			List<Integer> figureAddress = GefUtils.getAddress(getFigure(),
					((GraphicalEditPart) getEditPart()).getFigure());
			if (figureAddress.size() != 0) {
				recorder.setControls(GefModelMapper.figureMap(getFigure()));
				FigureUIElement rawFigure = partElement
						.rawFigure(figureAddress);
				GefRecordingHelper.getHelper().put(uiEl,
						new ElementEntry(rawFigure.getElement()));
				return rawFigure.getElement();
			} else {
				return element;
			}
		} else {

		}
		return null;
	}
	
	@Override
	public Widget getWidget() {
		return canvas;
	}

	public IRecordingDescriber getParent() {
		if (getEditPart() == null) {
			IFigure parent = getFigure().getParent();
			if (parent != null) {
				return new RecordingFigureDescriber(parent, null, getViewer(), canvas);
			}
			return this;
		} else {
			IFigure fig = ((GraphicalEditPart) getEditPart()).getFigure();
			if (fig.equals(getFigure())) {
				return new RecordingEditPartDescriber(getEditPart(),
						getViewer());
			} else {
				IFigure parent = getFigure().getParent();
				if (parent != null) {
					return new RecordingFigureDescriber(parent, getEditPart(),
							getViewer(), canvas);
				}

			}
		}
		return this;
	}

	protected boolean needLogging;

	public void setNeedLogging(boolean need) {
		this.needLogging = need;
	}
}
