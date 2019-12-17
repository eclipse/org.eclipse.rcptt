/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.expandbar.runtime.internal;

import static org.eclipse.rcptt.logging.IQ7ActivityLogs.ASSERTIONS;
import static org.eclipse.rcptt.logging.Q7LoggingManager.logMessage;
import static org.eclipse.rcptt.tesla.core.TeslaFeatures.isActivityLogging;
import static java.lang.String.format;

import org.eclipse.swt.widgets.ExpandBar;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.IRecordingDescriber;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTWidgetLocator;

public class ExpandBarRecordingDescriber extends ExpandBarDescriber implements IRecordingDescriber {
	private SWTUIElement element;

	public ExpandBarRecordingDescriber(ExpandBar bar) {
		super(bar);
	}

	public ExpandBarRecordingDescriber(SWTUIElement element) {
		super((ExpandBar) element.unwrap());
		this.element = element;
	}

	@Override
	public Element searchForElement(TeslaRecorder recorder) {
		SWTWidgetLocator locator = SWTRecordingHelper.getHelper().getLocator();
		FindResult result = null;
		if (element != null) {
			if (needLogging && isActivityLogging()) {
				logMessage(ASSERTIONS, format("Looking for element: %s", element.getClassName()));
			}
			result = locator.findElement(element, false, false, true);
		} else {
			if (needLogging && isActivityLogging()) {
				logMessage(ASSERTIONS,
						String.format("assert properties of the element: %s", getWidget().getClass().getName()));
			}
			result = locator.findElement(getWidget(), true, false, true);
		}
		return result == null ? null : result.element;
	}

	@Override
	public IRecordingDescriber getParent() {
		// SWTWidgetLocator locator = SWTRecordingHelper.getHelper().getLocator();
		// SWTUIPlayer player = locator.getPlayer();
		// SWTUIElement element = player.getParentElement(player.wrap(getWidget()));
		return this;
	}

	private boolean needLogging;

	@Override
	public void setNeedLogging(boolean fixed) {
		this.needLogging = fixed;
	}

}
