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
package org.eclipse.rcptt.expandbar.runtime.internal;

import java.util.Arrays;

import org.eclipse.rcptt.expandbar.ExpandBarConstants;
import org.eclipse.rcptt.expandbar.widgets.WidgetsFactory;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.protocol.Collapse;
import org.eclipse.rcptt.tesla.core.protocol.Expand;
import org.eclipse.rcptt.tesla.core.protocol.IElementProcessorMapper;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.ui.Image;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.internal.ui.SWTElementMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.ISWTModelMapperExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;

public class ExpandBarUIProcessor extends SWTUIProcessor implements ISWTModelMapperExtension {
	private final ExpandBarPlayerExtension ext = new ExpandBarPlayerExtension();

	public ExpandBarUIProcessor() {
		SWTUIPlayer.addExtension(ext);
	}

	@Override
	public void collectInformation(AdvancedInformation information, Command lastCommand) {
		// No information
	}

	@Override
	public void terminate() {
		SWTUIPlayer.removeExtension(ext);
		super.terminate();
	}

	@Override
	public Widget mapExtraValues(SWTUIElement element, Widget result) {
		return mapWidget(element, result);
	}

	public static Widget mapWidget(SWTUIElement element, Widget result) {
		org.eclipse.swt.widgets.Widget widget = element.unwrap();
		if (widget instanceof ExpandItem) {
			return mapItem((ExpandItem) widget);
		} else if (widget instanceof ExpandBar) {
			return mapBar((ExpandBar) widget);
		}
		return result;
	}

	private static org.eclipse.rcptt.expandbar.widgets.ExpandBar mapBar(ExpandBar bar) {
		org.eclipse.rcptt.expandbar.widgets.ExpandBar result = WidgetsFactory.eINSTANCE.createExpandBar();
		SWTModelMapper.fillControl(result, bar);
		for (ExpandItem item : bar.getItems()) {
			result.getItems().add(mapItem(item));
		}
		return result;

	}

	private static org.eclipse.rcptt.expandbar.widgets.ExpandItem mapItem(ExpandItem item) {
		int index = Arrays.asList(item.getParent().getItems()).indexOf(item);
		org.eclipse.rcptt.expandbar.widgets.ExpandItem result = WidgetsFactory.eINSTANCE.createExpandItem();
		result.setCaption(item.getText());
		result.setExpanded(item.getExpanded());
		result.setIndex(index);
		Image image = SWTModelMapper.mapImage(item.getImage());
		if (image != null) {
			result.setImage(image);
		}
		return result;
	}

	@Override
	public boolean isSelectorSupported(String kind) {
		return ExpandBarConstants.EXPAND_BAR_KIND.equals(kind);
	}

	@Override
	public boolean isCommandSupported(Command cmd) {
		return cmd instanceof Expand || cmd instanceof Collapse;
	}

	@Override
	public boolean canProceed(Context context, Q7WaitInfoRoot info) {
		return true;
	}

	@Override
	public void postSelect(Element element, IElementProcessorMapper processorMapper) {

		SWTElementMapper elementMapper = getMapper();
		if (elementMapper == null) {
			return;
		}

		SWTUIElement swtElement = elementMapper.get(element);

		if (swtElement == null) {
			return;
		}
		org.eclipse.swt.widgets.Widget widget = swtElement.unwrap();
		if (widget instanceof ExpandItem) {
			processorMapper.map(element, this);
		}

		super.postSelect(element, processorMapper);
	}

	@Override
	public Response executeCommand(Command command, IElementProcessorMapper mapper) {
		if (command instanceof Collapse) {
			final SWTUIElement element = getMapper().get(((Collapse) command).getElement());
			final org.eclipse.swt.widgets.Widget widget = PlayerWrapUtils.unwrapWidget(element);

			if (widget instanceof ExpandBar) {
				return failResponse("'collapse' can be used only with ExpandBar items. Use 'collapse-all' to collapse all items.");
			}
			if (!(widget instanceof ExpandItem)) {
				return null; // let other processor to handle this
			}
			final ExpandItem item = (ExpandItem) widget;
			getPlayer().exec("Collapsing ExpandItem", new Runnable() {
				public void run() {
					getPlayer().getEvents().sendEvent(item.getParent(), item, SWT.Collapse);
					item.setExpanded(false);
				}
			});

			return okResponse();
		} else if (command instanceof Expand) {
			final SWTUIElement element = getMapper().get(((Expand) command).getElement());
			final org.eclipse.swt.widgets.Widget widget = PlayerWrapUtils.unwrapWidget(element);

			if (widget instanceof ExpandBar) {
				return failResponse("'expand' can be used only with ExpandBar items. Use 'expand-all' to expand all items.");
			}

			if (!(widget instanceof ExpandItem)) {
				return null; // let other processor to handle this
			}
			final ExpandItem item = (ExpandItem) widget;
			getPlayer().exec("Expanding ExpandItem", new Runnable() {
				public void run() {
					getPlayer().getEvents().sendEvent(item.getParent(), item, SWT.Expand);
					item.setExpanded(true);
				}
			});
			return okResponse();
		}

		return null;
	}

}
