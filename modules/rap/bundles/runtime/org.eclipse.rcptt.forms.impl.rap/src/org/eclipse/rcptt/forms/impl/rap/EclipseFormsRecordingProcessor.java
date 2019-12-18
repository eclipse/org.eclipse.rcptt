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
package org.eclipse.rcptt.forms.impl.rap;

import static org.eclipse.rcptt.forms.impl.internal.Plugin.UTILS;

import java.lang.reflect.Field;

import org.eclipse.rcptt.forms.impl.rap.EclipseFormsProcessor;
import org.eclipse.rcptt.tesla.core.protocol.CompositeUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.ISWTModelMapperExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.recording.aspects.forms.rap.FormsEventManager;
import org.eclipse.rcptt.tesla.recording.aspects.forms.rap.IFormsEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.swt.rap.IBasicSWTEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.swt.rap.SWTEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessorExtension;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.rap.SWTEventRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.rap.SWTRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.swt.rap.SWTWidgetLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.AbstractHyperlink;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.internal.forms.widgets.FormHeading;
import org.eclipse.ui.internal.forms.widgets.FormTextModel;
import org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment;
import org.eclipse.ui.internal.forms.widgets.TitleRegion;


@SuppressWarnings("restriction")
public class EclipseFormsRecordingProcessor implements IRecordingProcessor,
		IRecordingProcessorExtension, IBasicSWTEventListener, IFormsEventListener, ISWTModelMapperExtension {

	private TeslaRecorder recorder = null;

	protected TeslaRecorder getRecorder() {
		return recorder;
	}

	public EclipseFormsRecordingProcessor() {
		SWTEventManager.addListener(this);
		FormsEventManager.addListener(this);
	}

	@Override
	public void initialize(TeslaRecorder teslaRecorder) {
		this.recorder = teslaRecorder;
	}

	@Override
	public void clear() {
	}

	@Override
	public void setFreeze(boolean value, SetMode command) {
	}

	@Override
	public void resetAssertSelection() {
	}

	@Override
	public IRecordingHelper<?> getHelper() {
		return null;
	}

	@Override
	public int getInitLevel() {
		return 500;
	}

	@Override
	public boolean isNotCanvas(Object widget, int type, Object event) {
		Composite parent = null;
		try {
			parent = ((Control) widget).getParent();
			return !(widget instanceof ExpandableComposite)
					&& !(widget instanceof AbstractHyperlink)
					&& !(widget instanceof FormHeading)
					&& !(widget instanceof TitleRegion)
					&& !(widget instanceof FormText)
					&& !(parent instanceof ExpandableComposite);
		} catch (ClassCastException e) {
			return false;
		}
	}

	@Override
	public boolean isIgnored(Object widget, int type, Object event) {
		if (widget instanceof FormText) {
			if ((type == SWT.Selection || type == SWT.DefaultSelection)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isNotDraw2d(Object widget) {
		return false;
	}

	@Override
	public boolean isExclusiveEventHandle(Widget widget, int type, Event event) {
		return widget instanceof AbstractHyperlink || widget instanceof FormText;
	}

	@Override
	public void clickOnExpandable(Composite composite) {
		FindResult element = getSWTProcessor().getLocator().findElement(
				composite, false, false, false);
		if (element != null) {
			ControlUIElement elem = new ControlUIElement(element.element,
					getSWTProcessor().getRecorder());
			elem.click();
		}
	}

	@Override
	public void recordEvent(Widget widget, int type, Event event) {
		if (type != SWT.MouseDown) {
			return;
		}
		SWTWidgetLocator locator = getLocator();
		SWTUIPlayer player = locator.getPlayer();
		if (widget instanceof AbstractHyperlink) {
			Composite parent = ((AbstractHyperlink) widget).getParent();
			if (parent instanceof ExpandableComposite) {
				Control client = ((ExpandableComposite) parent)
						.getClient();
				if (!widget.equals(client)) {
					return;
				}
			}
			AbstractHyperlink linkWidget = (AbstractHyperlink) widget;
			if (!(linkWidget.getParent() instanceof ExpandableComposite)) {

				FindResult result = locator.findElement(widget, true, false,
						false);
				if (result != null
						&& result.realElement.getKind()
								.is(ElementKind.Link)) {
					ControlUIElement link = new ControlUIElement(
							result.element, recorder);
					link.clickAndWait();
				}
			}
		}
		if (widget instanceof FormText) {
			FormTextModel model = EclipseFormsPlayerExtension.getFormTextModel((FormText) widget);
			IHyperlinkSegment link = model.findHyperlinkAt(event.x, event.y);
			if (link != null) {
				SWTUIElement element = player.getParentElement(player
						.wrap(widget));
				FindResult result = locator.findElement(element, false, false,
						false);
				if (result != null) {
					ControlUIElement linkE = (new CompositeUIElement(
							result.element, recorder)).link(link.getText());
					linkE.click();
				}
			}
		}
	}

	@Override
	public boolean isPartOfParent(Object widget, Object parent) {
		if (parent instanceof ExpandableComposite) {
			Control label = getExpandableLabel(parent);
			if (label != null && label.equals(widget)) {
				return true;
			}
		}
		return false;
	}

	private SWTWidgetLocator getLocator() {
		return SWTRecordingHelper.getHelper().getLocator();
	}

	private SWTEventRecorder getSWTProcessor() {
		return recorder.getProcessor(SWTEventRecorder.class);
	}

	private Control getExpandableLabel(Object apUnwrap) {
		try {
			Field field = ExpandableComposite.class
					.getDeclaredField("textLabel");
			field.setAccessible(true);
			return (Control) field.get(apUnwrap);
		} catch (Throwable e) {
			UTILS.log(UTILS.createError(e));
		}
		return null;
	}

	@Override
	public org.eclipse.rcptt.tesla.core.ui.Widget mapExtraValues(
		SWTUIElement element, org.eclipse.rcptt.tesla.core.ui.Widget result
	) {
		return EclipseFormsProcessor.mapWidget(element, result);
	}
}
