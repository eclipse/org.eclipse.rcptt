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
package org.eclipse.rcptt.tesla.recording.jface.text;

import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.jface.contentassist.IContentAssistSubjectControl;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.TextUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.recording.aspects.jface.text.IJFaceTextEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.jface.text.JFaceTextEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessorExtension;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTEventRecorder;

public class JFaceTextRecordingProcessor implements IRecordingProcessor,
		IJFaceTextEventListener {

	private TeslaRecorder recorder;
	private SWTEventRecorder eventRecorder;

	public JFaceTextRecordingProcessor() {
	}

	public void clear() {
	}

	public void initialize(TeslaRecorder teslaRecorder) {
		this.recorder = teslaRecorder;
		JFaceTextEventManager.addListener(this);
	}

	public int getInitLevel() {
		return 200;
	};

	public TeslaRecorder getRecorder() {
		return recorder;
	}

	public void setFreeze(boolean value, SetMode command) {
	}

	/**
	 * Retrive content assistant from CompletionProposalPopup
	 * 
	 * @param control
	 * @return
	 */
	public static ContentAssistant getContentAssistant(Object control) {
		try {
			Field field = control.getClass().getDeclaredField(
					"fContentAssistant");
			if (field != null) {
				field.setAccessible(true);
				Object value = field.get(control);
				if (value instanceof ContentAssistant) {
					return (ContentAssistant) value;
				}
			}
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public IContentAssistSubjectControl getSubjectControl(Object control) {
		try {
			Field field = control.getClass().getDeclaredField(
					"fContentAssistSubjectControlAdapter");
			if (field != null) {
				field.setAccessible(true);
				Object value = field.get(control);
				if (value instanceof IContentAssistSubjectControl) {
					return (IContentAssistSubjectControl) value;
				}
			}
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
		return null;
	}

	private synchronized SWTEventRecorder getSWTEventRecorder() {
		if (eventRecorder == null) {
			eventRecorder = recorder.getProcessor(SWTEventRecorder.class);
		}
		return eventRecorder;
	}

	public void showContentAssist(Object control, boolean autoActivation) {
		if (getRecorder() == null) {
			return;
		}
		if (!getRecorder().hasListeners()) {
			return;
		}
		if (autoActivation) {
			IContentAssistSubjectControl subjectControl = getSubjectControl(control);
			if (subjectControl != null) {
				Control subjControl = subjectControl.getControl();
				if (subjControl != null) {
					FindResult textWidget = getSWTEventRecorder().getLocator()
							.findElement(subjControl, false, false, true);
					if (textWidget != null) {
						TextUIElement text = new TextUIElement(
								textWidget.element, getRecorder());
						text.showContentAssist();
					}
				}
			}
		}
	}

	public void activateInfomationWindow(Widget widget, Rectangle subjectArea) {
		List<IRecordingProcessorExtension> processors = getRecorder()
				.getProcessors(IRecordingProcessorExtension.class);
		if (!(widget instanceof StyledText)) {
			return;
		}
		for (IRecordingProcessorExtension ext : processors) {
			if (ext.isIgnored(widget, SWT.Selection, null)) {
				return;
			}
		}
		FindResult findResult = getSWTEventRecorder().getLocator().findElement(
				widget, false, false, true);
		if (findResult != null) {
			StyledText text = (StyledText) widget;
			Point center = new Point(subjectArea.x + subjectArea.width / 2,
					subjectArea.y + subjectArea.height / 2);
			int offset = ((StyledText) widget).getOffsetAtLocation(center);
			int lineAtOffset = text.getLineAtOffset(offset);
			int offsetAtLine = offset - text.getOffsetAtLine(lineAtOffset);
			TextUIElement textElement = new TextUIElement(findResult.element,
					getRecorder());
			textElement.hoverAtOffset(lineAtOffset, offsetAtLine);
		}
	}

	public void resetAssertSelection() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IRecordingHelper getHelper() {
		return null;
	}

}
