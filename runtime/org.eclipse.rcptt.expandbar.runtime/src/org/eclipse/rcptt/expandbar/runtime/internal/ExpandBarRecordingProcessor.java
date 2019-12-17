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

import static org.eclipse.rcptt.expandbar.runtime.internal.ExpandBarUIProcessor.mapWidget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.ItemUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.ISWTModelMapperExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.recording.aspects.IBasicSWTEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.SWTEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTWidgetLocator;

public class ExpandBarRecordingProcessor implements IRecordingProcessor, IBasicSWTEventListener,
		ISWTModelMapperExtension {
	public ExpandBarRecordingProcessor() {
		SWTEventManager.addListener(this);
		getLocator().addExtension(new ExpandBarWidgetLocatorExtension(getLocator()));
	}

	private TeslaRecorder recorder = null;

	protected TeslaRecorder getRecorder() {
		return recorder;
	}

	@Override
	public void initialize(TeslaRecorder recorder) {
		this.recorder = recorder;
	}

	@Override
	public void clear() {
		ExpandBarRecordingHelper.getHelper().clear();
		SWTModelMapper.initializeExtensions(getLocator().getRecorder().getProcessors(ISWTModelMapperExtension.class));
	}

	@Override
	public void setFreeze(boolean value, SetMode command) {
	}

	@Override
	public void resetAssertSelection() {
	}

	@Override
	public IRecordingHelper<?> getHelper() {
		return ExpandBarRecordingHelper.getHelper();
	}

	@Override
	public int getInitLevel() {
		return 20;
	}

	@Override
	public boolean isExclusiveEventHandle(Widget widget, int type, Event event) {
		return widget instanceof ExpandBar || widget instanceof ExpandItem;
	}

	@Override
	public void recordEvent(Widget widget, int type, Event event) {
		if (getRecorder() == null || !getRecorder().hasListeners()) {
			return;
		}
		if (!ExpandBarUtil.isRelatedWidget(widget)) {
			return;
		}
		if (type == SWT.Expand || type == SWT.Collapse) {
			ExpandItem item = (ExpandItem) event.item;
			FindResult result = getLocator().findElement(item, true, false, false);
			ItemUIElement itemElement = new ItemUIElement(result.element, getLocator().getRecorder());
			if (type == SWT.Expand) {
				itemElement.expand();
			} else {
				itemElement.collapse();
			}
		}

	}

	private static SWTWidgetLocator getLocator() {
		return SWTRecordingHelper.getHelper().getLocator();
	}

	@Override
	public org.eclipse.rcptt.tesla.core.ui.Widget mapExtraValues(SWTUIElement element, org.eclipse.rcptt.tesla.core.ui.Widget result) {
		return mapWidget(element, result);
	}
}
