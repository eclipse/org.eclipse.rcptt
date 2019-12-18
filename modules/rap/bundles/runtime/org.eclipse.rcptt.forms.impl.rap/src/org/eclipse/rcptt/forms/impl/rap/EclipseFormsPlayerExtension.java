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

import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;
import static org.eclipse.rcptt.forms.impl.internal.Plugin.UTILS;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.internal.ui.player.AbstractSWTUIPlayerExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.ChildrenCollectingSession;
import org.eclipse.rcptt.tesla.internal.ui.player.FormTextLinkUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.IChildrenCollectingExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerSelectionFilter;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWidgetUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTEvents;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.util.swt.rap.Events;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.AbstractHyperlink;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.internal.forms.widgets.FormTextModel;
import org.eclipse.ui.internal.forms.widgets.FormUtil;
import org.eclipse.ui.internal.forms.widgets.IHyperlinkSegment;

@SuppressWarnings("restriction")
public class EclipseFormsPlayerExtension extends AbstractSWTUIPlayerExtension {

	@Override
	public SWTUIElement wrap(Object s, SWTUIPlayer player) {
		if (s instanceof IHyperlinkSegment) {
			return new FormTextLinkUIElement(
					null,
					(IHyperlinkSegment) s,
					player);
		}
		return null;
	}

	@Override
	public GenericElementKind getKind(Object w) {
		if (w instanceof IHyperlinkSegment) {
			return new GenericElementKind(ElementKind.Link);
		} else if (w instanceof Hyperlink) {
			return new GenericElementKind(ElementKind.Link);
		} else if (w instanceof AbstractHyperlink) {
			return new GenericElementKind(ElementKind.Link);
		} else if (w instanceof ExpandableComposite) {
			return new GenericElementKind(ElementKind.Expandable);
		}
		return null;
	}

	@Override
	public SWTUIElement select(SWTUIPlayer player, PlayerSelectionFilter filter) {
		SWTUIElement result = null;
		switch (filter.kind.kind) {
		case Expandable:
			result = searchExpandable(player, filter);
			break;
		case Link:
			result = searchLink(player, filter);
			break;
		case FormText:
			result = searchFormText(player, filter);
			break;
		default:
			break;
		}
		return result;
	}

	@Override
	public Widget getIndirectParent(Widget widget) {
		if (widget instanceof Hyperlink) {
			return ((Hyperlink) widget).getParent();
		} else if (widget instanceof AbstractHyperlink) {
			return ((AbstractHyperlink) widget).getParent();
		} else if (widget instanceof ExpandableComposite) {
			return ((ExpandableComposite) widget).getParent();
		}
		return super.getIndirectParent(widget);
	}

	@Override
	public Class<?> getSearchableClass(Object widget) {
		if (widget instanceof AbstractHyperlink) {
			return AbstractHyperlink.class;
		} else if (widget instanceof ExpandableComposite) {
			return ExpandableComposite.class;
		}
		return null;
	}

	@Override
	public boolean canClick(final SWTUIElement widget, final boolean isDefault, final boolean doubleClick,
			final boolean arrow) {
		switch (widget.getKind().kind) {
		case FormText:
			return true;
		case Expandable:
			return true;
		case Link:
			if (widget instanceof FormTextLinkUIElement) {
				return true;
			} else if (PlayerWrapUtils.unwrap(widget) instanceof IHyperlinkSegment) {
				return true;
			}
			return widget.unwrap() instanceof AbstractHyperlink && !doubleClick;
		default:
			break;
		}
		return false;
	}

	@Override
	public void click(final SWTUIElement widget, final boolean isDefault, final boolean doubleClick,
			final boolean arrow) {
		switch (widget.getKind().kind) {

		case FormText:
			clickToFormText(widget);
			break;
		case Expandable:
			clickToExpandable(widget);
			break;
		case Link:
			if (widget instanceof FormTextLinkUIElement
					|| PlayerWrapUtils.unwrap(widget) instanceof IHyperlinkSegment) {
				clickFormTextLinkUIElement(widget);
			}
			if (widget.unwrap() instanceof AbstractHyperlink) {
				clickToHiperlink(widget.unwrap());
			}
			break;
		default:
			break;
		}
	}

	private void clickToHiperlink(Widget widget) {
		final SWTEvents events = new SWTEvents(widget.getDisplay());

		final List<Event> sending = new ArrayList<Event>(4);
		sending.add(Events.createMouseDown());
		sending.add(Events.createSelection(true));
		if (widget.getListeners(SWT.Selection).length > 0) {
			sending.add(Events.createSelection(false));
		}
		sending.add(Events.createMouseUp());

		events.sendAll(widget, sending.toArray(new Event[sending.size()]));
	}

	public static FormTextModel getFormTextModel(Canvas fText) {
		FormTextModel model = null;
		try {
			Field field;
			field = FormText.class.getDeclaredField("model");

			field.setAccessible(true);

			model = (FormTextModel) field.get(fText);
		} catch (Throwable e) {
			UTILS.log(UTILS.createError(e));
		}
		return model;
	}

	private void clickFormTextLinkUIElement(final SWTUIElement widget) {
		IHyperlinkSegment segment = (IHyperlinkSegment)
				PlayerWrapUtils.unwrap(widget);
		FormText fText = (FormText) ((FormTextLinkUIElement) widget).widget;
		FormTextModel model = getFormTextModel(fText);
		if (model.getHyperlinkCount() < 1)
			return;
		model.selectLink(segment);
		callActivateSelectLink(fText);
	}

	private void clickToExpandable(final SWTUIElement widget) {
		ExpandableComposite ec = (ExpandableComposite)
				PlayerWrapUtils.unwrapWidget(widget);
		boolean newState = !ec.isExpanded();
		TeslaSWTAccess.callMethod(
				ExpandableComposite.class, ec,
				"fireExpanding", new Class[] { boolean.class, boolean.class },
				newState, true);
		ec.setExpanded(newState);
		TeslaSWTAccess.callMethod(
				ExpandableComposite.class, ec,
				"fireExpanding", new Class[] { boolean.class, boolean.class },
				newState, false);
		if (newState)
			FormUtil.ensureVisible(ec);
	}

	private void clickToFormText(final SWTUIElement widget) {
		FormText fText = (FormText)
				PlayerWrapUtils.unwrapWidget(widget);
		FormTextModel model = getFormTextModel(fText);
		if (model.getHyperlinkCount() < 1)
			return;
		model.selectLink(model.getHyperlink(0));
		callActivateSelectLink(fText);
	}

	private SWTUIElement searchExpandable(SWTUIPlayer player,
			PlayerSelectionFilter filter) {
		return player.selectWidget(filter,
				ExpandableComposite.class);
	}

	private SWTUIElement searchLink(SWTUIPlayer player,
			PlayerSelectionFilter filter) {
		return player.selectWidget(filter, Link.class,
				IHyperlinkSegment.class,
				AbstractHyperlink.class);
	}

	private SWTUIElement searchFormText(SWTUIPlayer swtuiPlayer,
			PlayerSelectionFilter filter) {
		return swtuiPlayer.selectWidget(filter,
				FormText.class);
	}

	private void callActivateSelectLink(Canvas fText) {
		Method selectlink;
		try {
			selectlink = FormText.class.getDeclaredMethod(
					"activateSelectedLink", new Class[] {});
			selectlink.setAccessible(true);
			selectlink.invoke(fText, new Object[] {});
		} catch (Throwable e) {
			UTILS.log(UTILS.createError(e));
		}
	}
	
	@Override
	public String getRawText(SWTUIElement element) {
		Object widget = PlayerWrapUtils.unwrap(element);
		if (widget instanceof IHyperlinkSegment) {
			return ((IHyperlinkSegment) widget)
					.getText();
		}
		if (widget instanceof ExpandableComposite) {
			return ((ExpandableComposite) widget)
					.getText();
		}
		if (widget instanceof Hyperlink) {
			return ((Hyperlink) widget).getText();
		}
		if (widget instanceof FormText) {
			FormText fText = (FormText) widget;
			FormTextModel model = getFormTextModel(fText);
			return model.getAccessibleText();
		}
		return null;
	}
	
	@Override
	public IChildrenCollectingExtension getChildrenCollectingExtension(final ChildrenCollectingSession session) {
		return new IChildrenCollectingExtension() {
			@Override
			public void collect() {
				if (session.w == null) {
					return;
				}
				Widget widget = unwrapWidget(session.w);
				if (widget instanceof FormText) {
					FormText fText = (FormText) widget;
					FormTextModel model = getFormTextModel(fText);
					if (PlayerWidgetUtils.isVisible(fText))
						for (int i = 0; i < model.getHyperlinkCount(); i++) {
							SWTUIElement wrap = new FormTextLinkUIElement(fText,
									model.getHyperlink(i), session.player);
							session.addItem(wrap);
						}
				}
			}
		};
	}

}
