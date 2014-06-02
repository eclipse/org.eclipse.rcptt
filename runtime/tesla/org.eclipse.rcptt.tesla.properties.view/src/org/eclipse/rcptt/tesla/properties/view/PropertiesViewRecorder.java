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
package org.eclipse.rcptt.tesla.properties.view;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.internal.WorkbenchPartReference;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyList;
import org.osgi.framework.Bundle;

import org.eclipse.rcptt.tesla.core.protocol.PartUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.WorkbenchUIElement;
import org.eclipse.rcptt.tesla.recording.aspects.IBasicSWTEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.SWTEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTEventRecorder;

@SuppressWarnings("restriction")
public class PropertiesViewRecorder implements IRecordingProcessor,
		IBasicSWTEventListener {

	@SuppressWarnings("unused")
	private SWTUIPlayer internalPlayer;
	private TeslaRecorder teslaRecorder;
	private SWTEventRecorder swtRecorder;

	public PropertiesViewRecorder() {
		SWTEventManager.addListener(this);
	}

	// -- IRecordingProcessor

	public void initialize(TeslaRecorder teslaRecorder) {
		this.teslaRecorder = teslaRecorder;
	}

	public void clear() {
	}

	public void setFreeze(boolean value, SetMode command) {
	}

	public void resetAssertSelection() {
	}

	public IRecordingHelper<?> getHelper() {
		return null;
	}

	public int getInitLevel() {
		return 30;
	}

	// -- IBasicSWTEventListener

	public boolean isExclusiveEventHandle(Widget widget, int type, Event event) {
		try {
			return widget instanceof TabbedPropertyList.ListElement
					|| widget instanceof TabbedPropertyList.BottomNavigationElement
					|| widget instanceof TabbedPropertyList.TopNavigationElement;
		} catch (NoClassDefFoundError e) {
			logOnce(e);
			return false;
		}
	}

	private boolean noClassDefLogged = false;

	private void logOnce(NoClassDefFoundError e) {
		if (noClassDefLogged) {
			return;
		}

		noClassDefLogged = true;
		Bundle bundle = Platform
				.getBundle("org.eclipse.ui.views.properties.tabbed");
		String message;
		if (bundle == null) {
			message = "'org.eclipse.ui.views.properties.tabbed' is not found, but plugin activated";
		} else {
			String version = bundle.getVersion() == null ? "unknown" : bundle
					.getVersion().toString();
			message = "'org.eclipse.ui.views.properties.tabbed' has version "
					+ version;
		}
		PropertiesViewPlugin.logErr(e, message);
	}

	public void recordEvent(Widget widget, int type, Event event) {
		if (!(widget instanceof TabbedPropertyList.ListElement))
			return;
		if (type != SWT.MouseUp)
			return;

		TabbedPropertyList.ListElement listElement = (TabbedPropertyList.ListElement) widget;

		FindResult r = getSWTRecorder().getLocator().findElement(widget, false,
				false, false);
		if (r == null)
			return;
		SWTUIElement parent = getSWTRecorder().getPlayer().getParentElement(
				r.realElement);

		if (!(parent instanceof WorkbenchUIElement))
			return;

		WorkbenchUIElement workbenchUIElement = (WorkbenchUIElement) parent;
		IWorkbenchPartReference iWorkbenchPartReference = workbenchUIElement
				.getReference();
		if (!(iWorkbenchPartReference instanceof WorkbenchPartReference))
			return;

		WorkbenchPartReference workbenchPartReference = (WorkbenchPartReference) iWorkbenchPartReference;
		final Control control = workbenchPartReference.getPane().getControl();
		if (control == null || !(control instanceof Composite))
			return;

		PartUIElement partUIElement = getSWTRecorder().getLocator()
				.findPartElement(workbenchPartReference.getPart(true), false);
		partUIElement.propertyTab(listElement.getTabItem().getText()).click();
	}

	// --

	private SWTEventRecorder getSWTRecorder() {
		if (swtRecorder == null) {
			swtRecorder = teslaRecorder.getProcessor(SWTEventRecorder.class);
		}
		return swtRecorder;
	}

}
