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
package org.eclipse.rcptt.tesla.nebula.grid.selection;

import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTEvents;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.WorkbenchUIElement;
import org.eclipse.rcptt.tesla.nebula.NebulaUIElement;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;
import org.eclipse.rcptt.tesla.ui.SWTTeslaActivator;

public class GridSetSelectionViewers {

	public static boolean setSelection(NebulaUIElement element,
			String[] selection, String pattern, Integer index) {
		Boolean result = null;
		Widget widget = unwrapWidget(element);
		if (widget instanceof Grid) {
			if (selection == null && pattern != null) {
				selection = new String[] { pattern };
			}
			result = selectGridItems(element, new String[][] { selection });
		}
		if (result != null && !result.booleanValue()) {
			// makeScreenShot();
		}
		return result != null && result.booleanValue();
	}

	public static boolean setSelection(NebulaUIElement element,
			List<String[]> sels) {
		Widget widget = unwrapWidget(element);
		String[][] items = sels.toArray(new String[sels.size()][]);
		if (widget instanceof Grid) {
			return selectGridItems(element, items);
		}
		return false;
	}

	private static boolean selectGridItems(final NebulaUIElement parent, final String[][] paths) {
		if (paths == null)
			return true;

		Widget widget = unwrapWidget(parent);
		if (widget instanceof Grid) {
			GridItem[] items = gridItemsFromPaths(parent, paths);
			if (items.length > 0)
				return selectThings(parent, (Grid) widget, new SelectingItems(items));
		}
		return false;
	}

	private static GridItem[] gridItemsFromPaths(final NebulaUIElement parent, final String[][] paths) {
		List<GridItem> items = new ArrayList<GridItem>();
		for (String[] item : paths) {
			if (item == null)
				continue;

			Object current = NebulaViewers.searchGridItem(parent, item);
			if (current != null)
				items.add((GridItem) current);
		}
		return items.toArray(new GridItem[items.size()]);
	}


	// //


	public static boolean setSelectionEx(NebulaUIElement gridE, final ItemPart part) {
		return selectThings(gridE, new SelectingPart(part));
	}

	public static boolean setMultiSelectionEx(NebulaUIElement gridE, final List<ItemPart> parts) {
		return selectThings(gridE, new SelectingParts(parts));
	}

	public static boolean setSelectionRange(NebulaUIElement gridE, GridItem fromItem, GridItem toItem) {
		return selectThings(gridE, new SelectingRange(fromItem, toItem));
	}

	public static boolean setSelectionRangeEx(NebulaUIElement gridE, ItemPart from, ItemPart to) {
		return selectThings(gridE, new SelectingRangeEx(from, to));
	}

	private static boolean selectThings(NebulaUIElement gridE, SelectingThings things) {
		Widget widget = unwrapWidget(gridE);
		if (widget instanceof Grid) {
			final Grid grid = (Grid) widget;
			return selectThings(gridE, grid, things);
		}
		return false;
	}

	// TODO should be refactored with Viewers.selectItem
	private static boolean selectThings(final NebulaUIElement parent, final Grid grid, final SelectingThings things) {
		grid.forceFocus();
		grid.deselectAll();

		// We also need to pass selection to selection provider
		parent.getPlayer().exec("Send selection events", new Runnable() {
			public void run() {
				List<Object> data = things.selectionData();
				if (data != null)
					updateSelectionProviders(parent, data);
			}
		});

		final SWTEvents events = parent.getPlayer().getEvents();
		parent.getPlayer().exec("Set selection events", new Runnable() {
			public void run() {
				grid.forceFocus();
				things.selectUs(grid);

				events.sendEvent(grid, SWT.FocusIn);
				events.sendEvent(grid, SWT.MouseEnter);

				things.imitateMouseActions(events, grid);

				events.sendEvent(grid, SWT.MouseExit);
			}
		});
		return true;
	}

	private static void updateSelectionProviders(SWTUIElement element, List<Object> selectionData) {
		if (element != null) {
			final SWTUIPlayer player = element.getPlayer();

			List<SWTUIElement> list = player.getParentsList(element);
			list.add(element);
			for (SWTUIElement e : list) {
				final GenericElementKind kind = e.getKind();
				if (kind.is(ElementKind.View) || kind.is(ElementKind.Editor)) {
					if (e instanceof WorkbenchUIElement) {
						final IWorkbenchPartReference reference =
								(IWorkbenchPartReference) ((WorkbenchUIElement) e).getReference();
						IWorkbenchPart part = reference.getPart(true);
						ISelectionProvider provider = part.getSite().getSelectionProvider();
						if (provider != null) {
							try {
								provider.setSelection(new StructuredSelection(selectionData));
							} catch (Throwable ee) {
								SWTTeslaActivator.log(ee);
							}
						}
					}
					break;
				}
			}
		}
	}

}
