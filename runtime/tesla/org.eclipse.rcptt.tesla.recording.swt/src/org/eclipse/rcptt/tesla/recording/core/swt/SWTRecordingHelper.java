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
package org.eclipse.rcptt.tesla.recording.core.swt;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.logging.IQ7ActivityLogs;
import org.eclipse.rcptt.logging.Q7LoggingManager;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;

public class SWTRecordingHelper extends BasicRecordingHelper<SWTUIElement> {
	private SWTUIPlayer player;
	private SWTWidgetLocator locator = null;

	private static SWTRecordingHelper mapper;

	public synchronized static SWTRecordingHelper getHelper() {
		if (mapper == null) {
			mapper = new SWTRecordingHelper();
		}
		return mapper;
	}

	public synchronized SWTUIPlayer getPlayer() {
		if (player == null) {
			player = SWTUIPlayer.getPlayer(PlatformUI.getWorkbench()
					.getDisplay());
		}
		return player;
	}

	public synchronized SWTWidgetLocator getLocator() {
		if (locator == null) {
			locator = new SWTWidgetLocator(getPlayer());
			locator.initialize(TeslaRecorder.getInstance());
		}
		return locator;
	}

	public void clearAllWithParent(SWTUIElement swtuiElement) {
		Set<SWTUIElement> keySet = new HashSet<SWTUIElement>(
				this.elements.keySet());
		for (SWTUIElement e : keySet) {
			if (e.unwrap() != null && !e.unwrap().isDisposed()
					&& !e.unwrap().getDisplay().equals(Display.getCurrent())) {
				continue;
			}
			List<SWTUIElement> list = getPlayer().getParentsList(e);
			if (list.contains(swtuiElement)) {
				this.elements.remove(e);
			}
		}
	}

	public synchronized void cleanDisposed() {
		Set<SWTUIElement> keySet = new HashSet<SWTUIElement>(
				this.elements.keySet());
		for (SWTUIElement swtuiElement : keySet) {
			if (swtuiElement.isDisposed()) {
				remove(swtuiElement);
				clearAllWithParent(swtuiElement);
			}
		}
	}

	@Override
	public PropertyNodeList getNodeProperties(Element element, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		SWTUIElement swtUiElement = findByElement(element);
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager
					.logMessage(
							IQ7ActivityLogs.PROPERTIES,
							"fill list of extra properties for element: "
									+ swtUiElement.getClassName()
									+ ((nodePath != null && nodePath.length() > 0) ? " with prefix: "
											+ nodePath
											: ""));
		}
		if (swtUiElement != null) {
			return SWTModelMapper.getPropertyNodes(swtUiElement, nodePath);
		}
		return null;
	}

	@Override
	public String getWidgetDetails(Element element) {
		SWTUIElement swtUiElement = findByElement(element);
		if (swtUiElement != null) {
			Widget widget = swtUiElement.unwrap();
			return new WidgetDetailsProvider().getDetails(widget, getPlayer());
		}
		return null;
	}
}
