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
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.AbstractHyperlink;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.internal.forms.widgets.FormTextModel;
import org.eclipse.ui.internal.forms.widgets.FormUtil;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

@SuppressWarnings("restriction")
public class EclipseFormsSupport {
	public static String unify(String value) {
		return PlayerTextUtils.unifyMultilines(value);
	}

	public static Widget SWTModelMapperMap(org.eclipse.swt.widgets.Widget widget) {
		if (widget instanceof AbstractHyperlink) {
			return fillHyperLink((AbstractHyperlink) widget);
		}
		if (widget instanceof org.eclipse.swt.widgets.Link) {
			return fillLink((org.eclipse.swt.widgets.Link) widget);
		}
		return null;
	}

	private static Widget fillHyperLink(AbstractHyperlink widget) {
		org.eclipse.rcptt.tesla.core.ui.Link label = UiFactory.eINSTANCE.createLink();
		label.setCaption(unify(widget.getText()));
		label.setToltip(unify(widget.getToolTipText()));
		SWTModelMapper.fillControl(label, widget);
		return label;
	}

	private static Widget fillLink(org.eclipse.swt.widgets.Link widget) {
		org.eclipse.rcptt.tesla.core.ui.Link label = UiFactory.eINSTANCE.createLink();
		label.setCaption(unify(widget.getText()));
		label.setToltip(unify(widget.getToolTipText()));
		SWTModelMapper.fillControl(label, widget);
		return label;
	}

	public static Object unwrap(SWTUIElement element) {
		if (element instanceof FormTextLinkUIElement) {
			return ((FormTextLinkUIElement) element).segment;
		}
		return null;
	}

	public static SWTUIElement searchExpandable(SWTUIPlayer player,
			PlayerSelectionFilter filter) {
		return player.selectWidget(filter,
				org.eclipse.ui.forms.widgets.ExpandableComposite.class);
	}

	public static SWTUIElement searchLink(SWTUIPlayer player,
			PlayerSelectionFilter filter) {
		return player.selectWidget(filter, Link.class,
				org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment.class,
				org.eclipse.ui.forms.widgets.AbstractHyperlink.class);
	}

	public static SWTUIElement searchFormText(SWTUIPlayer swtuiPlayer,
			PlayerSelectionFilter filter) {
		return swtuiPlayer.selectWidget(filter,
				org.eclipse.ui.forms.widgets.FormText.class);
	}

	public static boolean isHyperLinkSegment(SWTUIElement w) {
		return unwrap(w) instanceof org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment;
	}

	public static void clickOnFormText(SWTUIElement w) {
		org.eclipse.ui.forms.widgets.FormText fText = (org.eclipse.ui.forms.widgets.FormText)
				PlayerWrapUtils.unwrapWidget(w);
		org.eclipse.ui.internal.forms.widgets.FormTextModel model = getFormTextModel(fText);
		if (model.getHyperlinkCount() < 1)
			return;
		model.selectLink(model.getHyperlink(0));
		callActivateSelectLink(fText);
	}

	public static void clickOnLink(SWTUIElement w, boolean doubleClick) {
		org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment segment = (org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment)
				PlayerWrapUtils.unwrap(w);
		org.eclipse.ui.forms.widgets.FormText fText = (org.eclipse.ui.forms.widgets.FormText) ((FormTextLinkUIElement) w).widget;
		org.eclipse.ui.internal.forms.widgets.FormTextModel model = getFormTextModel(fText);
		if (model.getHyperlinkCount() < 1)
			return;
		model.selectLink(segment);
		callActivateSelectLink(fText);
	}

	public static void clickOnExpandable(SWTUIElement w) {
		org.eclipse.ui.forms.widgets.ExpandableComposite ec = (org.eclipse.ui.forms.widgets.ExpandableComposite)
				PlayerWrapUtils.unwrapWidget(w);
		boolean newState = !ec.isExpanded();
		TeslaSWTAccess.callMethod(
				org.eclipse.ui.forms.widgets.ExpandableComposite.class, ec,
				"fireExpanding", new Class[] { boolean.class, boolean.class },
				newState, true);
		ec.setExpanded(newState);
		TeslaSWTAccess.callMethod(
				org.eclipse.ui.forms.widgets.ExpandableComposite.class, ec,
				"fireExpanding", new Class[] { boolean.class, boolean.class },
				newState, false);
		if (newState)
			FormUtil.ensureVisible(ec);
	}

	public static SWTUIElement wrapSegment(SWTUIPlayer player, Object s) {
		if (s instanceof org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment) {
			return new FormTextLinkUIElement(
					null,
					(org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment) s,
					player);
		}
		return null;
	}

	public static void formsChildren(SWTUIPlayer swtuiPlayer,
			List<SWTUIElement> results, org.eclipse.swt.widgets.Widget widget,
			SWTUIElement[] ignores, Class<?>[] classes) {
		if (widget instanceof org.eclipse.ui.forms.widgets.FormText) {
			org.eclipse.ui.forms.widgets.FormText fText = (org.eclipse.ui.forms.widgets.FormText) widget;
			org.eclipse.ui.internal.forms.widgets.FormTextModel model = getFormTextModel(fText);
			if (PlayerWidgetUtils.isVisible(fText))
				for (int i = 0; i < model.getHyperlinkCount(); i++) {
					SWTUIElement wrap = new FormTextLinkUIElement(fText,
							model.getHyperlink(i), swtuiPlayer);
					ChildrenCollector.addItem(results, wrap, ignores, classes);
				}
		}
	}

	public static String getText(Object widget) {
		if (widget instanceof org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment) {
			return ((org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment) widget)
					.getText();
		}
		if (widget instanceof org.eclipse.ui.forms.widgets.ExpandableComposite) {
			return ((org.eclipse.ui.forms.widgets.ExpandableComposite) widget)
					.getText();
		}
		if (widget instanceof org.eclipse.ui.forms.widgets.Hyperlink) {
			return ((org.eclipse.ui.forms.widgets.Hyperlink) widget).getText();
		}
		if (widget instanceof org.eclipse.ui.forms.widgets.FormText) {
			org.eclipse.ui.forms.widgets.FormText fText = (org.eclipse.ui.forms.widgets.FormText) widget;
			org.eclipse.ui.internal.forms.widgets.FormTextModel model = getFormTextModel(fText);
			return model.getAccessibleText();
		}
		return null;
	}

	public static void addKinds(Map<Class<?>, ElementKind> elementKinds) {
		elementKinds.put(
				org.eclipse.ui.forms.widgets.ExpandableComposite.class,
				ElementKind.Expandable);
		elementKinds.put(
				org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment.class,
				ElementKind.Link);
		elementKinds.put(org.eclipse.ui.forms.widgets.Hyperlink.class,
				ElementKind.Link);
	}

	public static Class<?> getSearchableClass(Object w) {
		if (w instanceof org.eclipse.ui.forms.widgets.AbstractHyperlink) {
			return org.eclipse.ui.forms.widgets.AbstractHyperlink.class;
		}
		if (w instanceof org.eclipse.ui.forms.widgets.ExpandableComposite) {
			return org.eclipse.ui.forms.widgets.ExpandableComposite.class;
		}
		return null;
	}

	public static ElementKind getKind(Object w) {
		if (w instanceof org.eclipse.ui.forms.widgets.AbstractHyperlink) {
			return ElementKind.Link;
		}
		// Check all items
		// Fix for expandables treated as canvas
		if (w instanceof org.eclipse.ui.forms.widgets.ExpandableComposite) {
			return ElementKind.Expandable;
		}
		return null;
	}

	// Access
	public static FormTextModel getFormTextModel(FormText fText) {
		FormTextModel model = null;
		try {
			Field field;
			field = FormText.class.getDeclaredField("model");

			field.setAccessible(true);

			model = (FormTextModel) field.get(fText);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}

	public static void callActivateSelectLink(FormText fText) {
		Method selectlink;
		try {
			selectlink = FormText.class.getDeclaredMethod(
					"activateSelectedLink", new Class[] {});
			selectlink.setAccessible(true);
			selectlink.invoke(fText, new Object[] {});
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
	}

	public static Widget mapFormText(org.eclipse.swt.widgets.Widget widget) {
		if (widget instanceof FormText) {
			return fillFormText((FormText) widget);
		}
		return null;
	}

	private static Widget fillFormText(FormText widget) {
		org.eclipse.rcptt.tesla.core.ui.FormText formText = UiFactory.eINSTANCE
				.createFormText();
		SWTModelMapper.fillControl(formText, widget);

		String text = "";
		FormTextModel model = TeslaSWTAccess.getField(FormTextModel.class,
				widget, "model");
		if (model != null)
			text = model.getAccessibleText();

		formText.setText(text);
		return formText;
	}
}
