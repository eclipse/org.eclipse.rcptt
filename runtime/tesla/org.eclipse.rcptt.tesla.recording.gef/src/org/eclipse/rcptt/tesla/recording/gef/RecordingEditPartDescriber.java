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
package org.eclipse.rcptt.tesla.recording.gef;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;

import org.eclipse.rcptt.logging.IQ7ActivityLogs;
import org.eclipse.rcptt.logging.Q7LoggingManager;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.protocol.diagram.FigureUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.gef.describers.EditPartDescriber;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.gef.GefEventRecorder;
import org.eclipse.rcptt.tesla.recording.core.gef.GefRecordingHelper.GraphicalViewerEntry;
import org.eclipse.rcptt.tesla.recording.core.swt.IRecordingDescriber;
import org.eclipse.rcptt.tesla.recording.core.swt.RecordingWidgetDescriber;

public class RecordingEditPartDescriber extends EditPartDescriber implements
		IRecordingDescriber {
	public RecordingEditPartDescriber(EditPart editPart, GraphicalViewer viewer) {
		super(editPart, viewer);
	}

	public Element searchForElement(final TeslaRecorder recorder) {
		GefEventRecorder rec = recorder.getProcessor(GefEventRecorder.class);
		final EditPartViewer viewer = getPart().getViewer();
		if (rec.isSkipDiagramOperations()) {
			return null;
		}
		GraphicalViewerEntry entry = rec.getLocator().getDiagramUIElement(
				viewer);
		if (entry != null) {
			if (needLogging) {
				if (TeslaFeatures.isActivityLogging()) {
					Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS,
							"locking for identity for edit part: "
									+ getPart().getClass().getName());
				}
			}
			FigureUIElement element = rec.getLocator().find(getPart(), viewer,
					entry.diagramViewer, false);
			if (element != null) {
				return element.getElement();
			}
		}
		return null;
	}

	public IRecordingDescriber getParent() {
		EditPart editPart = getPart();
		EditPart parent = editPart.getParent();
		if (parent != null) {
			return new RecordingEditPartDescriber(parent, getViewer());
		}
		return new RecordingWidgetDescriber(getViewer().getControl());
	}

	protected boolean needLogging;

	public void setNeedLogging(boolean need) {
		this.needLogging = need;
	}
}
