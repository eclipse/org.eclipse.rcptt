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

import org.eclipse.swt.widgets.Composite;

import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.recording.aspects.forms.FormsEventManager;
import org.eclipse.rcptt.tesla.recording.aspects.forms.IFormsEventListener;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;

public class EclipseFormsRecordingProcessor implements IRecordingProcessor,
		IFormsEventListener {

	private TeslaRecorder recorder;

	public EclipseFormsRecordingProcessor() {
		FormsEventManager.addListener(this);
	}

	private SWTEventRecorder getSWTProcessor() {
		return recorder.getProcessor(SWTEventRecorder.class);
	}

	public void clickOnExpandable(Composite composite) {
		FindResult element = getSWTProcessor().getLocator().findElement(
				composite, false, false, false);
		if (element != null) {
			ControlUIElement elem = new ControlUIElement(element.element,
					getSWTProcessor().getRecorder());
			elem.click();
		}
	}

	public void initialize(TeslaRecorder teslaRecorder) {
		this.recorder = teslaRecorder;
	}

	public int getInitLevel() {
		return 500;
	};

	public void clear() {
	}

	public void setFreeze(boolean value, SetMode command) {
	}

	public void resetAssertSelection() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IRecordingHelper getHelper() {
		return null;
	}
}
