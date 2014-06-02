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

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.AbstractHyperlink;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.internal.forms.widgets.FormHeading;
import org.eclipse.ui.internal.forms.widgets.FormTextModel;
import org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment;
import org.eclipse.ui.internal.forms.widgets.TitleRegion;

import org.eclipse.rcptt.tesla.core.protocol.CompositeUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.ui.ExpandableComposite;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;

@SuppressWarnings("restriction")
public class EclipseFormsSupport {

	public static boolean isNotCanvas(Widget widget, Composite parent) {
		return !(widget instanceof ExpandableComposite)
				&& !(widget instanceof AbstractHyperlink)
				&& !(widget instanceof FormHeading)
				&& !(widget instanceof TitleRegion)
				&& !(widget instanceof FormText)
				&& !(parent instanceof org.eclipse.ui.forms.widgets.ExpandableComposite);
	}

	public static boolean isFormTextWidget(Widget widget) {
		return widget instanceof FormText;
	}

	public static void recordFormsMouseDown(Widget widget,
			SWTWidgetLocator locator, TeslaRecorder recorder,
			SWTUIPlayer player, Event event) {
		if (widget instanceof AbstractHyperlink) {
			Composite parent = ((AbstractHyperlink) widget).getParent();
			if (parent instanceof org.eclipse.ui.forms.widgets.ExpandableComposite) {
				Control client = ((org.eclipse.ui.forms.widgets.ExpandableComposite) parent)
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
			FormTextModel model = org.eclipse.rcptt.tesla.internal.ui.player.EclipseFormsSupport
					.getFormTextModel((FormText) widget);
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

	@SuppressWarnings("rawtypes")
	public static void addLinkClass(List<Class> classes) {
		classes.add(AbstractHyperlink.class);
	}

}
