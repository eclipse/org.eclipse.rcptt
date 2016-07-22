/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.ui.player;

import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWidgetUtils.isVisible;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.swt.workbench.EclipseWorkbenchProvider;
import org.eclipse.rcptt.util.swt.rap.TableTreeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.internal.WorkbenchPartReference;

@SuppressWarnings("restriction")
public class ChildrenCollectingSession {

	public final SWTUIPlayer player;
	public final ChildrenCollector collector;

	public final SWTUIElement w;
	public final SWTUIElement[] ignores;
	public final boolean goIntoComposites;
	private final boolean menuIsShown;
	public final Class<?>[] classes;

	public ChildrenCollectingSession(SWTUIPlayer player, ChildrenCollector collector,
			final SWTUIElement w, final SWTUIElement[] ignores, final boolean goIntoComposites,
			boolean menuIsShown, final Class<?>... classes) {

		this.player = player;
		this.collector = collector;

		this.w = w;
		this.ignores = ignores;
		this.goIntoComposites = goIntoComposites;
		this.menuIsShown = menuIsShown;
		this.classes = classes;
	}

	//

	private boolean started = false;
	private final List<SWTUIElement> results = new ArrayList<SWTUIElement>();

	// only this method should me called by clients,
	// all other public methods and fields are to be used only by extensions
	// TODO change the interface to reflect above note
	public SWTUIElement[] collect() {
		if (started)
			throw new IllegalStateException("collect() should be called once only");
		started = true;

		// check extensions
		for (ISWTUIPlayerExtension ext : SWTUIPlayer.getExtensions()) {
			IChildrenCollectingExtension cce = ext.getChildrenCollectingExtension(this);
			if (cce != null)
				cce.collect();
		}

		//

		if (w == null) {
			Shell[] shells = player.display.getShells();
			for (Shell shell : shells) {
				addItem(wrap(shell));
			}
		}

		if (w instanceof WorkbenchUIElement && w.isView()) {
			WorkbenchUIElement wbelement = (WorkbenchUIElement) w;
			if (needToCollectMenuItems()) {
				collectMenuItems(wbelement.getViewMenu(), null);
			}
		}

		Widget widget = unwrapWidget(w);
		if (widget != null && widget.isDisposed()) {
			return new SWTUIElement[0];
		}
		if (widget instanceof Shell) {
			Shell[] shells = ((Shell) widget).getShells();
			for (Shell shell : shells) {
				addItem(wrap(shell));
			}
		}
		if (w instanceof WorkbenchUIElement) {
			WorkbenchPartReference reference = (WorkbenchPartReference) ((WorkbenchUIElement) w)
					.getReference();
			Control toolBar = EclipseWorkbenchProvider.getProvider()
					.getToolbar(reference);
			if (toolBar != null) {
				addItem(wrap(toolBar));
				SWTUIElement[] children = collector.collectFor(wrap(toolBar), ignores,
						goIntoComposites, classes);
				results.addAll(Arrays.asList(children));
			}

		}

		if ((widget instanceof TreeColumn || widget instanceof TableColumn)
				&& needToCollectMenuItems()) {
			Control tableOrTree = (Control) TableTreeUtil.getParent(widget);
			Rectangle bounds = TableTreeUtil.getColumnBounds(widget);
			Point point = new Point(bounds.x + bounds.width / 2, bounds.y
					+ bounds.height / 2);
			point = tableOrTree.getDisplay().map(tableOrTree, null, point);

			player.getEvents().sendFocus(tableOrTree);
			player.getEvents().sendEvent(tableOrTree, SWT.MenuDetect, point.x, point.y, 3);

			collectMenuItems(tableOrTree.getMenu(), point);
		}

		// CtabFolder should be before composite check
		if (widget instanceof CTabFolder) {
			CTabFolder tabFolder = (CTabFolder) widget;
			CTabItem[] items = tabFolder.getItems();
			if (isVisible(tabFolder))
				for (CTabItem control : items) {
					SWTUIElement wrap = wrap(control);
					addItem(wrap);
					if (goIntoComposites) {
						SWTUIElement[] cc = collector.collectFor(new SWTUIElement(control,
								player), ignores, true, classes);
						results.addAll(Arrays.asList(cc));
					}
				}
		}

		if (widget instanceof TabFolder) {
			TabFolder tabFolder = (TabFolder) widget;
			TabItem[] items = tabFolder.getItems();
			if (isVisible(tabFolder))
				for (TabItem control : items) {
					SWTUIElement wrap = wrap(control);
					addItem(wrap);
					if (goIntoComposites) {
						SWTUIElement[] cc = collector.collectFor(new SWTUIElement(control,
								player), ignores, true, classes);
						results.addAll(Arrays.asList(cc));
					}
				}
		}

		if (widget instanceof ToolBar) {
			ToolBar tb = (ToolBar) widget;
			ToolItem[] children = tb.getItems();
			for (ToolItem item : children) {
				if ((item.getStyle() & SWT.SEPARATOR) != 0) {
					continue;
				}
				addItem(wrap(item));
				if (goIntoComposites) {
					SWTUIElement[] cc = collector.collectFor(new SWTUIElement(item, player),
							ignores, true, classes);
					results.addAll(Arrays.asList(cc));
				}
			}
		}
		if (widget instanceof Composite) {
			Composite c = (Composite) widget;
			Control[] children = c.getChildren();
			for (Control control : children) {
				if (!isVisible(control))
					continue;
				addItem(wrap(control));
				if (goIntoComposites) {
					SWTUIElement[] cc = collector.collectFor(
							new SWTUIElement(control, player), ignores, true,
							classes);
					results.addAll(Arrays.asList(cc));
				}
			}
		}
		if (widget instanceof Control) {
			Control c = (Control) widget;
			if (needToCollectMenuItems()) {
				Point xy = player.getMousePos(c);

				Point p = c.getDisplay().map(c, null, xy);
				// events.sendEvent(c, SWT.FocusIn);
				if (c instanceof Tree || c instanceof Table) {
					player.getEvents().sendFocus(c);
				}
				player.getEvents().sendEvent(c, SWT.MenuDetect, p.x, p.y, SWT.BUTTON2);

				// events.sendEvent(c, SWT.MouseDown);
				collectMenuItems(c.getMenu(), p);
			}
		}

		if (widget instanceof Decorations) {
			Decorations d = (Decorations) widget;
			if (needToCollectMenuItems()) {
				collectMenuItems(d.getMenuBar(), null);
			}
		}
		if (widget instanceof Menu) {
			collectMenuItems((Menu) widget, null);
		}

		if (widget instanceof MenuItem) {
			MenuItem item = (MenuItem) widget;
			collectMenuItems(item.getMenu(), null);
		}
		// Check for popup menus
		List<Menu> popupMenus = TeslaEventManager.getManager().getAllRegisteredMenus();
		for (Menu menu : popupMenus) {
			if (menu != null && !menu.isDisposed()) {
				Control control = TeslaEventManager.getManager().getPopupMenuParents().get(menu);
				if (menu.getParent() != null && menu.getParent().equals(widget) || widget != null && widget.equals(control)) {
					collectMenuItems(menu, null);
				}
			}
		}
		if (widget instanceof Scrollable) {
			Scrollable s = (Scrollable) widget;
			ScrollBar horizontalBar = s.getHorizontalBar();
			ScrollBar verticalBar = s.getVerticalBar();
			if (horizontalBar != null) {
				addItem(wrap(horizontalBar));
			}
			if (verticalBar != null) {
				addItem(wrap(verticalBar));
			}
		}
		if (widget instanceof Tree) {
			Tree tree = (Tree) widget;
			TreeItem[] items = tree.getItems();
			for (TreeItem treeItem : items) {
				addItem(wrap(treeItem));
				if (goIntoComposites) {
					SWTUIElement[] cc = collector.collectFor(new SWTUIElement(treeItem,
							player), ignores, true, classes);
					results.addAll(Arrays.asList(cc));
				}
			}
		}
		if (widget instanceof TreeItem) {
			TreeItem item = (TreeItem) widget;
			if (item.getExpanded()) {
				TreeItem[] items = item.getItems();
				for (TreeItem treeItem : items) {
					addItem(wrap(treeItem));
					if (goIntoComposites) {
						SWTUIElement[] cc = collector.collectFor(new SWTUIElement(treeItem,
								player), ignores, true, classes);
						results.addAll(Arrays.asList(cc));
					}
				}
			}
		}
		if (widget instanceof Table) {
			Table tree = (Table) widget;
			TableItem[] items = tree.getItems();
			for (TableItem treeItem : items) {
				addItem(wrap(treeItem));
				if (goIntoComposites) {
					SWTUIElement[] cc = collector.collectFor(new SWTUIElement(treeItem,
							player), ignores, true, classes);
					results.addAll(Arrays.asList(cc));
				}
			}
		}

		return results.toArray(new SWTUIElement[results.size()]);
	}

	//

	private SWTUIElement wrap(Object s) {
		return player.wrap(s);
	}

	public void addItem(SWTUIElement control) {
		ChildrenCollector.addItem(results, control, ignores, classes);
	}

	private static boolean containClass(Class<?> cl, Class<?>[] classes) {
		if (classes != null) {
			boolean instanceOf = false;
			for (Class<?> class1 : classes) {
				if (class1.equals(cl)) {
					return true;
				}
			}
			return instanceOf;
		}
		return false;
	}

	//

	public boolean needToCollectMenuItems() {
		return containClass(Menu.class, classes) || containClass(MenuItem.class, classes);
	}

	public void collectMenuItems(Menu menu, Point point) {
		if (menu != null) {
			if (point != null)
				menu.setLocation(point);

			SWTUIElement wrappedMenu = wrap(menu);
			addItem(wrappedMenu);
			if (!menuIsShown)
				player.show(wrappedMenu, // ?? or maybe -1, -1 for Control case
						point != null ? point.x : -1,
						point != null ? point.y : -1);

			MenuItem[] items = menu.getItems();
			for (MenuItem control : items) {
				addItem(wrap(control));
				if (goIntoComposites) {
					SWTUIElement[] cc = collector.collectFor(
							new SWTUIElement(control, player), ignores, true, classes);
					results.addAll(Arrays.asList(cc));
				}
			}
		}
	}

}
