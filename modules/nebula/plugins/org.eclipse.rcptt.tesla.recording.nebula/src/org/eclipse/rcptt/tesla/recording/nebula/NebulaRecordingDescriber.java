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
package org.eclipse.rcptt.tesla.recording.nebula;

import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.logging.IQ7ActivityLogs;
import org.eclipse.rcptt.logging.Q7LoggingManager;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.NebulaDescriber;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.IRecordingDescriber;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTWidgetLocator;

public class NebulaRecordingDescriber extends NebulaDescriber implements
		IRecordingDescriber {

	private SWTUIElement uiElement;
	private boolean needLogging;

	public NebulaRecordingDescriber(Widget widget) {
		super(widget);
	}

	public NebulaRecordingDescriber(SWTUIElement element) {
		super(element.unwrap());
		uiElement = element;
	}

	public Element searchForElement(TeslaRecorder recorder) {
		SWTWidgetLocator locator = SWTRecordingHelper.getHelper().getLocator();
		FindResult result = null;
		if (uiElement != null) {
			if (needLogging) {
				if (TeslaFeatures.isActivityLogging()) {
					Q7LoggingManager.logMessage(
							IQ7ActivityLogs.ASSERTIONS,
							"looking identity for element: "
									+ uiElement.getClassName());
				}
			}
			result = locator.findElement(uiElement, true, false, true);
		} else {
			if (needLogging) {
				if (TeslaFeatures.isActivityLogging()) {
					Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS,
							"assert properties of element: "
									+ getWidget().getClass().getName());
				}
			}
			result = locator.findElement(getWidget(), true, false, true);
		}
		if (result != null) {
			return result.element;
		}
		return null;
	}

	public IRecordingDescriber getParent() {
		SWTWidgetLocator locator = SWTRecordingHelper.getHelper().getLocator();
		SWTUIPlayer pl = locator.getPlayer();
		SWTUIElement element = pl.getParentElement(pl.wrap(getWidget()));
		if (element == null) {
			return this;
		}
		return new NebulaRecordingDescriber(element);
	}

	public void setNeedLogging(boolean fixed) {
		needLogging = fixed;
	}
}
