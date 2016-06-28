/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.ui.player.viewers;

import static java.lang.Integer.parseInt;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerTextUtils.safeMatches;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrap;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;
import static org.eclipse.rcptt.util.swt.TableTreeUtil.deselectAll;
import static org.eclipse.rcptt.util.swt.TableTreeUtil.getColumn;
import static org.eclipse.rcptt.util.swt.TableTreeUtil.getParent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.TeslaFeatures.EscapeMode;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTEvents;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.jface.TeslaCellEditorManager;
import org.eclipse.rcptt.tesla.swt.workbench.EclipseWorkbenchProvider;
import org.eclipse.rcptt.tesla.ui.IViewerItem;
import org.eclipse.rcptt.util.TableTreeItemPathUtil;
import org.eclipse.rcptt.util.swt.Events;
import org.eclipse.rcptt.util.swt.TableTreeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class Viewers {

	public static void expandTreeItem(TreeItem item) {
		Object data = item.getData();

		if (!TeslaSWTAccess.ignoreMarkersView(data)) {
			Event e = new Event();

			e.item = item;
			e.widget = item.getParent();
			e.display = item.getDisplay();
			e.time = (int) System.currentTimeMillis();
			item.getParent().notifyListeners(SWT.Expand, e);
			item.setExpanded(true);
		}
	}

	public static TreeItem getTreeItem(Tree tree, String[] path) {
		TreeItem current = null;
		for (String part : path) {
			TreeItem[] items = null;
			if (current == null) {
				items = tree.getItems();
			} else {
				TreeItem item = current;
				items = item.getItems();
			}
			if (items == null) {
				break;
			}
			IViewerItem[] viewerItems = getViewerItems(items);
			boolean found = false;
			for (TreeItem treeItem : items) {
				String text = SWTUIPlayer.toSelectionItem(Viewers
						.getTreeItemText(new TreeViewerItem(treeItem), part,
								viewerItems));
				if (viewerMatchs(part, text)) {
					current = treeItem;
					found = true;
					break;
				}
				text = treeItem.getText(); // For compatibility
				if (viewerMatchs(part, text)) {
					current = treeItem;
					found = true;
					break;
				}
			}
			if (!found) {
				current = null;
				break;
			}
		}
		return current;
	}

	private static boolean viewerMatchs(String part, String text) {
		return text != null
				&& (text.equals(part) || safeMatches(text, part));
	}

	public static TableItem getTableItem(Table table, String path) {
		Item[] items = TableTreeUtil.getItems(table);
		IViewerItem[] viewerItems = getViewerItems(items);
		if (items == null) {
			return null;
		}
		for (Item tableItem : items) {
			String text = SWTUIPlayer.toSelectionItem(getTableItemText(
					new TableViewerItem((TableItem) tableItem), path,
					viewerItems));
			if (viewerMatchs(path, text)) {
				return (TableItem) tableItem;
			}
		}

		return null;
	}

	public static String getTreeItemText(TreeViewerItem treeItem,
			String searchPath, IViewerItem[] items) {
		treeItem.getControl();

		return getIndexedItemText(treeItem, searchPath, items, null);
	}

	public static String createTreeItemPathText(TreeViewerItem treeItem,
			String columnToSelect,
			boolean autoColumnSelect) {
		Tree parent = treeItem.getControl();
		int col = parent.getColumnCount();
		int columnInd = -1;
		String columnName = columnToSelect;
		TreeItem item = treeItem.getItem();

		if (autoColumnSelect) {
			for (int i = 0; i < col; i++) {
				if (!item.getText(i).equals("")) {
					columnInd = i;
					columnName = parent.getColumn(columnInd).getText();
					break;
				}
			}
		} else {
			columnInd = TableTreeUtil.getColumnIndex(parent, columnName);
		}
		return getIndexedItemText(treeItem, null, null, columnName);
	}

	public static String getTableItemText(TableViewerItem tableItem,
			String searchPath, IViewerItem[] items) {
		tableItem.getControl();
		return getIndexedItemText(tableItem, searchPath, items, null);
	}

	public static String createTableItemPathText(TableViewerItem tableItem,
			String columnToSelect,
			boolean autoColumnSelect) {
		Table parent = tableItem.getControl();
		int col = parent.getColumnCount();
		int columnInd = -1;
		String columnName = columnToSelect;
		TableItem item = tableItem.getItem();

		if (autoColumnSelect) {
			for (int i = 0; i < col; i++) {
				if (!item.getText(i).equals("")) {
					columnInd = i;
					columnName = parent.getColumn(columnInd).getText();
					break;
				}
			}
		} else {
			columnInd = TableTreeUtil.getColumnIndex(parent, columnName);
		}

		return getIndexedItemText(tableItem, null, null, columnName);
	}

	private static String getItemText(Item item, String pattern,
			IViewerItem[] items) {
		return (item instanceof TableItem) ? getTableItemText(
				new TableViewerItem((TableItem) item), pattern, items)
				: getTreeItemText(new TreeViewerItem((TreeItem) item),
						pattern,
						items);
	}

	private static int getColumnInd(String columnName, IViewerItem item) {
		if (columnName == null) {
			return -1;
		}
		Widget parent = null;
		if (item instanceof TableViewerItem) {
			parent = ((TableViewerItem) item).getItem().getParent();
		} else if (item instanceof TreeViewerItem) {
			parent = ((TreeViewerItem) item).getItem().getParent();
		}
		if (parent != null) {
			return TableTreeUtil.getColumnIndex(parent, columnName);
		} else {
			return -1;
		}
	}

	static String getIndexedItemText(IViewerItem item,
			String searchPath, IViewerItem[] items, String column) {
		// added for correct search items with commands like:
		// get-item ".*" -index 1
		String columnName = searchPath == null ? column : TableTreeItemPathUtil.findColumnName(searchPath);
		int columnInd = getColumnInd(columnName, item);

		boolean dontUseColumn = searchPath == null && columnInd == 0;

		searchPath = TableTreeItemPathUtil.excludeColumnName(searchPath);
		int idx = findIndex(searchPath);
		if (idx > -1) {
			searchPath = stripIndex(searchPath);
		}

		String value = (columnInd == -1) ? item.getText() : item.getText(columnInd);
		if (items == null) {
			items = item.getParentItems();
		}
		if (items != null) {
			int index = 0;
			for (int i = 0; i < items.length; i++) {
				if (item.matches(items[i])) {
					break;
				}
				String val2 = (columnInd == -1) ? items[i].getText() : items[i]
						.getText(columnInd);
				if (val2.equals(value)
						|| (searchPath != null && safeMatches(val2,
								searchPath))) {
					index++;
				}
			}
			// adding index if item is not first, or explicit index was set in
			// search pattern
			if (index > 0 || idx != -1) {
				value = value + "%" + index + "%";
				if (columnName != null && !dontUseColumn) {
					value = TableTreeItemPathUtil.appendSegmentColumnName(value, columnName);
				}
				return value;
			}
		}
		if (value.endsWith("%")) {
			value = value + "%0%";
		}
		if (columnName != null && !dontUseColumn) {
			value = TableTreeItemPathUtil.appendSegmentColumnName(value, columnName);
		}
		return value; // Indicate using first column
	}

	private static final Pattern indexedItemPattern = Pattern
			.compile("(.*)\\%(\\d+)\\%");

	/**
	 * @return -1 when no index in path
	 */
	private static int findIndex(String itemPath) {
		if (itemPath == null) {
			return -1;
		}
		Matcher m = indexedItemPattern.matcher(itemPath);
		if (!m.matches()) {
			return -1;
		}
		return parseInt(m.group(2));
	}

	public static String stripIndex(String itemPath) {
		if (itemPath == null) {
			return null;
		}
		Matcher m = indexedItemPattern.matcher(itemPath);
		if (!m.matches()) {
			return itemPath;
		}
		return m.group(1);
	}

	static TreeItem[] getParentItems(TreeItem treeItem) {
		TreeItem parentItem = treeItem.getParentItem();
		if (parentItem != null) {
			return parentItem.getItems();
		}
		return treeItem.getParent().getItems();
	}

	public static String[] getPathByListItem(String... selection) {
		List<String> path = new ArrayList<String>();
		for (int i = 0; i < selection.length; i++) {
			path.add(selection[i]);
		}
		return path.toArray(new String[path.size()]);
	}

	public static String[] getPathByItem(Object selection) {
		if (selection instanceof TreeItem) {
			return getPathByTreeItem((TreeItem) selection);
		}
		return getPathByTableItem((TableItem) selection);
	}

	public static String[] getPathByTreeItem(TreeItem selection) {
		List<String> path = new ArrayList<String>();
		path.add(SWTUIPlayer.toSelectionItem(createTreeItemPathText(
				new TreeViewerItem(selection), null, true)));
		String columnToSelect = TableTreeItemPathUtil.findColumnName(path.get(0));
		TreeItem parentItem = selection.getParentItem();
		while (parentItem != null && !parentItem.isDisposed()) {
			path.add(0, SWTUIPlayer.toSelectionItem(createTreeItemPathText(
					new TreeViewerItem(parentItem), columnToSelect, false)));
			parentItem = parentItem.getParentItem();
		}
		return path.toArray(new String[path.size()]);
	}

	public static String[] getPathByTableItem(TableItem selection) {
		List<String> path = new ArrayList<String>();
		path.add(SWTUIPlayer.toSelectionItem(createTableItemPathText(
				new TableViewerItem(selection), null, true)));
		return path.toArray(new String[path.size()]);
	}

	public static String[][] getMultiPathSelection(SWTUIElement uiElement) {
		Widget widget = unwrapWidget(uiElement);
		if (widget instanceof Tree) {
			Tree tree = (Tree) widget;
			TreeItem[] selection = tree.getSelection();
			if (selection != null) {
				List<String[]> paths = new ArrayList<String[]>();
				for (int i = 0; i < selection.length; i++) {
					List<String> path = new ArrayList<String>();
					String text = createTreeItemPathText(
							new TreeViewerItem(selection[i]), null, true);
					path.add(escapePath(text));
					String columnToSelect = TableTreeItemPathUtil.findColumnName(text);
					TreeItem parentItem = selection[i].getParentItem();
					while (parentItem != null) {
						String parentText = createTreeItemPathText(new TreeViewerItem(parentItem),
								columnToSelect, false);
						path.add(0, escapePath(parentText));
						parentItem = parentItem.getParentItem();
					}
					paths.add(path.toArray(new String[path.size()]));
				}
				return paths.toArray(new String[paths.size()][]);
			}
		}
		if (widget instanceof Table) {
			Table tree = (Table) widget;
			TableItem[] selection = tree.getSelection();
			if (selection != null) {
				List<String[]> path = new ArrayList<String[]>();
				for (TableItem item : selection) {
					String text = createTableItemPathText(new TableViewerItem(item), null, true);
					path.add(new String[] { escapePath(text) });
				}
				return path.toArray(new String[path.size()][]);
			}
		}
		if (widget instanceof org.eclipse.swt.widgets.List) {
			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) widget;
			String[] selection = list.getSelection();
			if (selection != null) {
				List<String[]> path = new ArrayList<String[]>();
				for (String item : selection) {
					path.add(new String[] { SWTUIPlayer.toSelectionItem(item) });
				}
				return path.toArray(new String[path.size()][]);
			}
		}
		return null;
	}

	private static String escapePath(String path) {
		String escapeMode = TeslaFeatures.getInstance().getValue(TeslaFeatures.ESCAPE_TREES_TABLES_MODE);
		if (escapeMode.equals(EscapeMode.EscapedRegex.toString())) {
			path = SWTUIPlayer.toSelectionItem(path);
		}
		return path;
	}

	/**
	 * Selects item in {@link Tree} or {@link Table}
	 */
	public static boolean selectItem(final SWTUIElement parent,
			final String[][] path, final boolean selectAll) {
		if (path == null || path.length == 0 || parent == null) {
			return false;
		}
		final Control tableOrTree = (Control) unwrapWidget(parent);

		Set<Item> selection = new HashSet<Item>();
		for (String[] p : path) {
			Set<Item> pathSelection = findItems(new String[][] { p },
					tableOrTree, !selectAll);
			if (pathSelection.isEmpty())
				return false;
			selection.addAll(pathSelection);
		}

		deselectAll(tableOrTree);

		final Item[] resultItems = selection
				.toArray(new Item[selection.size()]);

		// We also need to pass selection to selection provider
		final List<Object> selectionData = new ArrayList<Object>();
		for (Widget item : resultItems) {
			Object data = item.getData();
			if (data != null) {
				selectionData.add(data);
			}
		}

		final SWTEvents player = parent.getPlayer().getEvents();

		parent.getPlayer().exec("Send selection events", new Runnable() {
			public void run() {
				player.sendFocus(tableOrTree);
				Item lastItem = resultItems[resultItems.length - 1];
				Rectangle bounds = TableTreeUtil.getBounds(lastItem);
				parent.getPlayer().addMouseWidgetInfo(tableOrTree,
						bounds.x + bounds.width / 2,
						bounds.y + bounds.height / 2);
				TableTreeUtil.setSelection(tableOrTree, resultItems);
				player.sendEvent(tableOrTree, lastItem, SWT.Selection);

				if (tableOrTree.isDisposed()) {
					return;
				}
				player.sendEvent(tableOrTree, SWT.MouseMove);
				if (!tableOrTree.isDisposed()) {
					player.sendEvent(tableOrTree, SWT.MouseExit);
				}
				parent.getPlayer().exec("Update selection", new Runnable() {
					public void run() {
						EclipseWorkbenchProvider.getProvider()
								.updateActiveSelection(selectionData, parent);
					}
				});
			}
		});
		return true;
	}

	/**
	 * Selects item described by UI element
	 * 
	 * @param item
	 * @return
	 */
	public static boolean selectItem(SWTUIElement item, boolean selectAll) {
		Widget widget = item.widget;
		return selectItem(item.getPlayer()
				.wrap(TableTreeUtil.getParent(widget)),
				new String[][] { getPathByItem(widget) }, selectAll);
	}

	public static boolean selectListItem(final SWTUIElement parent,
			final String[] parts) {
		if (parent != null
				&& unwrapWidget(parent) instanceof org.eclipse.swt.widgets.List) {
			// Try to obtain list viewer
			final ListViewer viewer = TeslaSWTAccess.getListViewer((org.eclipse.swt.widgets.List) unwrapWidget(parent));
			if (viewer != null) {
				IContentProvider provider = viewer.getContentProvider();
				IBaseLabelProvider labelProvider = viewer.getLabelProvider();
				Object input = viewer.getInput();

				if (provider instanceof IStructuredContentProvider
						&& labelProvider instanceof ILabelProvider) {
					IStructuredContentProvider listProvider = (IStructuredContentProvider) provider;
					ILabelProvider labels = (ILabelProvider) labelProvider;
					final List<Object> selection = new ArrayList<Object>();
					Object[] children = listProvider.getElements(input);
					for (String part : parts) {
						for (Object object : children) {
							String text = labels.getText(object);
							if (viewerMatchs(part, text)) {
								selection.add(object);
								break;
							}
						}
					}
					if (!selection.isEmpty()) {
						parent.getPlayer().exec("setSelection", new Runnable() {
							public void run() {
								viewer.setSelection(new StructuredSelection(
										selection.toArray()));
							}
						});
						return true;
					}
					return false;
				}
			}
		}
		/*
		 * This case work only with non dynamic lists.
		 */
		if (parent != null
				&& unwrapWidget(parent) instanceof org.eclipse.swt.widgets.List
				&& parts != null && parts.length != 0) {
			final org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) unwrapWidget(parent);
			Object current = unwrapWidget(parent);
			String[] items = ((org.eclipse.swt.widgets.List) current)
					.getItems();
			Set<Integer> selection = new HashSet<Integer>();
			if (items == null) {
				return false;

			}
			int index = -1;
			for (String item : items) {
				for (String part : parts) {
					if (item.equals(part)
							|| safeMatches(item, part)) {
						index = list.indexOf(item);
						selection.add(index);
						break;
					}
				}
			}
			if (selection.size() > 0) {
				int[] sels = new int[selection.size()];
				Integer[] values = selection.toArray(new Integer[selection
						.size()]);
				for (int i = 0; i < values.length; i++) {
					sels[i] = values[i].intValue();
				}
				list.deselectAll();
				list.select(sels);
			}
			else {
				list.deselectAll();
				list.select(index);
				list.setSelection(index);
			}
			SWTEvents player = parent.getPlayer().getEvents();

			player.sendFocus(list);
			player.sendEvent(list, SWT.MouseEnter);
			player.sendEvent(list, SWT.MouseMove);
			player.sendEvent(list, SWT.MouseDown);
			player.sendEvent(list, SWT.Selection);
			player.sendEvent(list, SWT.MouseUp, 0, 0, 1);
			if (!list.isDisposed()) { // In case of quick access dialog
				player.sendEvent(list, SWT.MouseExit);
			}
			return true;
		}
		return false;
	}

	public static int countTreeItemChildren(final SWTUIElement parent,
			final String[] path) {
		if (path == null || path.length == 0) {
			final Object widget = unwrap(parent);
			return ((Tree) widget).getItemCount();
		}
		if (parent != null && unwrapWidget(parent) instanceof Tree) {
			// Try to obtain tree viewer
			final TreeViewer viewer = TeslaSWTAccess
					.getTreeViewer((Tree) unwrapWidget(parent));
			if (viewer != null) {
				IContentProvider provider = viewer.getContentProvider();
				IBaseLabelProvider labelProvider = viewer.getLabelProvider();
				Object input = viewer.getInput();
				if (provider instanceof ITreeContentProvider
						&& labelProvider instanceof ILabelProvider) {
					ITreeContentProvider treeProvider = (ITreeContentProvider) provider;
					ILabelProvider labels = (ILabelProvider) labelProvider;
					Object current = input;
					final List<Object> selection = new ArrayList<Object>();
					for (String part : path) {
						Object[] children = null;
						if (current == input) {
							children = treeProvider.getElements(current);
						} else {
							children = treeProvider.getChildren(current);
						}
						boolean found = false;
						for (Object object : children) {
							String text = labels.getText(object);
							if (viewerMatchs(part, text)) {
								current = object;
								selection.add(current);
								found = true;
								break;
							}
						}
						if (!found) {
							return -1;
						}
					}
					if (selection.size() > 1) {
						return treeProvider.getChildren(selection.get(selection
								.size() - 1)).length;
					} else if (selection.size() == 1) {
						return treeProvider.getChildren(current).length;
					}
					return -1;
				}
			}
		}
		/*
		 * This case work only with non dynamic trees.
		 */
		if (parent != null && unwrapWidget(parent) instanceof Tree
				&& path != null) {
			// final Tree tree = (Tree) unwrapWidget(parent);
			Widget current = unwrapWidget(parent);
			for (String part : path) {
				TreeItem[] items = (TreeItem[]) TableTreeUtil.getItems(current);
				if (items == null) {
					return -1;
				}
				boolean found = false;
				for (TreeItem treeItem : items) {
					String text = treeItem.getText();
					if (viewerMatchs(part, text)) {
						current = treeItem;
						found = true;
						break;
					}
				}
				if (found == false) {
					return -1;
				}
			}
			return ((TreeItem) current).getItemCount();
		}
		return -1;
	}

	private static Set<Item> findTreeItems(final String[][] paths,
			final Tree tree, boolean onePerPath) {
		Set<Item> result = new LinkedHashSet<Item>();
		if (tree == null || tree.isDisposed()) {
			return result;
		}

		for (String[] path : paths) {
			Set<Item> items = findTreeItems(path, tree);
			if (onePerPath) {
				Item first = first(items);
				if (first != null) {
					result.add(first);
				}
			} else {
				result.addAll(items);
			}
		}

		return result;
	}

	private static Set<Item> findTreeItems(final String[] path, final Tree tree) {
		Set<Item> result = new LinkedHashSet<Item>();
		if (path == null || path.length == 0) {
			return result;
		}

		Set<Widget> parents = new LinkedHashSet<Widget>();
		parents.add(tree);
		for (String segment : path) {
			Set<Widget> newParents = new LinkedHashSet<Widget>();
			for (Widget parent : parents) {
				newParents.addAll(findMatchingItems(parent, segment));
			}
			parents = newParents;

		}
		// all widgets in parents must be items at this point
		// since empty path has filtered
		for (Widget element : parents) {
			result.add((Item) element);
		}
		return result;
	}

	private static Set<Item> findMatchingItems(Widget parent, String pattern) {
		Set<Item> result = new LinkedHashSet<Item>();
		if (parent.isDisposed()) {
			return result;
		}
		Item[] items = TableTreeUtil.getItems(parent);
		IViewerItem[] viewerItems = getViewerItems(items);

		for (Item item : items) {
			if (item.isDisposed()) {
				continue;
			}
			if (itemMatches(item, pattern, viewerItems)) {
				result.add(item);
			}

		}
		return result;
	}

	private static boolean itemMatches(Item item, String pattern,
			IViewerItem[] items) {
		String text;
		String columnName = TableTreeItemPathUtil.findColumnName(pattern);
		int columnInd;
		if (columnName != null) {
			columnInd = TableTreeUtil.getColumnIndex(
					TableTreeUtil.getParent(item), columnName);
		} else {
			columnInd = -1;
		}
		if (columnName != null && columnInd == -1) {
			return false;
		}
		if (columnInd < 1) {
			text = TableTreeUtil.getValue(item);
		} else {
			String columnValue = TableTreeUtil.getValue(item, columnInd);
			if (columnValue.equals("")) {
				Object value = getColumnValue(
						item, columnInd);
				if (value != null) {
					columnValue = value.toString();
				}
			}
			text = TableTreeItemPathUtil.appendSegmentColumnName(columnValue,
					columnName);
		}
		return viewerMatchs(pattern, text)
				|| viewerMatchs(pattern,
						SWTUIPlayer.toSelectionItem(getItemText(item, pattern,
								items)));
	}

	private static Object getColumnValue(Widget widget,
			int index) {
		Widget column = getColumn(getParent(widget),
				index);
		Object columnViewer = column.getData(Policy.JFACE + ".columnViewer");
		EditingSupport es = TeslaSWTAccess.getField(EditingSupport.class,
				columnViewer, "editingSupport");
		Object value = null;
		if (es != null) {
			value = TeslaSWTAccess.callMethod(EditingSupport.class, es,
					"getValue", new Class[] { Object.class },
					((Item) widget).getData());
		}
		return value;
	}

	public static Set<Item> findItems(final String[][] paths,
			final Widget parent, boolean onePerPath) {
		return (parent instanceof Table) ? findTableItems(paths, (Table) parent, onePerPath)
				: findTreeItems(paths, (Tree) parent, onePerPath);
	}

	public static Item firstMatch(final String[][] paths, final Widget parent) {
		return first(findItems(paths, parent, true));
	}

	public static Item firstMatch(final String[] path, final Tree parent) {
		return first(findTreeItems(path, parent));
	}

	private static <T> T first(Iterable<T> c) {
		Iterator<T> items = c.iterator();
		return items.hasNext() ? items.next() : null;
	}

	private static Set<Item> findTableItems(final String[][] paths,
			final Table table, boolean onePerPath) {
		Set<Item> result = new LinkedHashSet<Item>();
		if (table == null || table.isDisposed()) {
			return result;
		}
		for (String[] path : paths) {
			if (path == null || path.length == 0) {
				continue;
			}
			String text = path[0];
			Set<Item> matchingItems = findMatchingItems(table, text);
			if (onePerPath) {
				Item first = first(matchingItems);
				if (first != null) {
					result.add(first);
				}
			} else {
				result.addAll(matchingItems);
			}
		}

		return result;
	}

	public static IViewerItem[] getViewerItems(Item[] items) {
		IViewerItem[] viewerItems = new IViewerItem[items.length];
		for (int i = 0; i < viewerItems.length; i++) {
			if (items[i] instanceof TableItem) {
				viewerItems[i] = new TableViewerItem((TableItem) items[i]);
			}
			if (items[i] instanceof TreeItem) {
				viewerItems[i] = new TreeViewerItem((TreeItem) items[i]);
			}
		}
		return viewerItems;
	}

	public static final Point UNSAFE_CLICK_POINT = null;

	private static Point makeColumnClickPoint(TreeItem item, int column) {
		// System.out.println(item.getParent().getColumns()[column].getText());
		Rectangle bounds = item.getBounds(column);
		return new Point(bounds.x + bounds.width - 1, bounds.y + bounds.height
				/ 2);
	}

	private static CellEditor getCellEditor(CellEditor[] editors, int column) {
		if (editors == null)
			return null;
		if (column >= editors.length)
			return null;
		return editors[column];
	}

	// safe point is the point that will not trigger editor activation
	public static Point getSafeToClickPoint(TreeItem item) {
		Rectangle bounds = item.getBounds();
		final Point DEFAULT_POINT = new Point(bounds.x + bounds.width - 1,
				bounds.y + bounds.height / 2);

		Tree tree = item.getParent();
		Viewer viewer = TeslaSWTAccess.getViewer(tree);
		if (!(viewer instanceof ColumnViewer))
			return DEFAULT_POINT;
		ColumnViewer columnViewer = (ColumnViewer) viewer;
		CellEditor[] editors = columnViewer.getCellEditors();

		TreeColumn[] columns = tree.getColumns();
		if (columns == null || columns.length == 0)
			return DEFAULT_POINT;

		for (int i : tree.getColumnOrder()) {
			TreeColumn c = columns[i];
			if (getCellEditor(editors, i) != null)
				continue;

			Object data = c.getData("org.eclipse.jface.columnViewer");
			if (data == null)
				return makeColumnClickPoint(item, i);
			if (!(data instanceof ViewerColumn))
				continue;

			ViewerColumn viewerColumn = (ViewerColumn) data;
			EditingSupport editingSupport = TeslaSWTAccess.getField(
					EditingSupport.class, viewerColumn, "editingSupport");

			if (editingSupport == null)
				return makeColumnClickPoint(item, i);
		}

		return UNSAFE_CLICK_POINT;
	}

	public static boolean setSelection(SWTUIElement element,
			String[] selection, String pattern, Integer index, boolean selectAll) {

		// Skip selection event if there is cell editor active and same
		// selection are tryed to be set
		CellEditor[] editors = TeslaCellEditorManager.getInstance()
				.getEditors();
		boolean checkForSameSelection = false;
		for (CellEditor cellEditor : editors) {
			Control ctrl = cellEditor.getControl();
			if (cellEditor.isActivated() && ctrl != null && !ctrl.isDisposed()) {
				if (element.unwrap() instanceof Control) {
					List<Widget> parents = SWTUIPlayer.collectParents(ctrl,
							null, ((Control) element.unwrap()).getParent());
					if (parents.contains(element.unwrap())) {
						checkForSameSelection = true;
						// Yes cell editor are active
						break;
					}
				}
			}
		}
		if (checkForSameSelection) {
			String[] currentSelection = getPathSelection(element);
			if (currentSelection != null) {
				if (Arrays.equals(selection, currentSelection)) {
					return true;// Already selected
				}
			}
		}
		Boolean result = null;
		Widget widget = unwrapWidget(element);
		if (widget instanceof Tree || widget instanceof Table) {
			if (selection == null && pattern != null) {
				selection = new String[] { pattern };
			}
			result = selectItem(element, new String[][] { selection },
					selectAll);
		}
		if (widget instanceof org.eclipse.swt.widgets.List) {
			if (pattern == null && selection != null && selection.length == 1) {
				pattern = selection[0];
			}
			result = selectListItem(element, new String[] { pattern });
		}
		if (result != null && !result.booleanValue()) {
			// makeScreenShot();
		}
		return result != null && result.booleanValue();
	}

	public static boolean checkItem(boolean state, SWTUIElement element,
			String[] selection, String pattern, Integer index) {
		Boolean result = null;
		Widget widget = unwrapWidget(element);
		if (widget instanceof Tree) {
			if (selection == null && pattern != null) {
				selection = new String[] { pattern };
			}
			result = checkTreeItem(state, element, selection);
		}
		if (widget instanceof Table) {
			result = checkTableItem(state, element, selection[0]);
		}
		if (result != null && !result.booleanValue()) {
			// makeScreenShot();
		}
		return result != null && result.booleanValue();
	}

	public static int expandSelection(SWTUIElement element, String[] selection,
			String pattern, Integer index) {
		int result = -1;
		Widget widget = unwrapWidget(element);
		if (widget instanceof Tree) {
			if (selection == null && pattern != null) {
				selection = new String[] { pattern };
			}
			result = expandTreeItem(element, selection);
		}
		if (widget instanceof Table
				|| widget instanceof org.eclipse.swt.widgets.List) {

			// Be sure to update all virtual items here.
			return -1;
		}
		if (result == -1) {
			// makeScreenShot();
		}
		return result;
	}

	public static boolean setSelection(SWTUIElement element,
			List<String[]> sels, boolean selectAll) {
		Widget widget = unwrapWidget(element);
		String[][] items = sels.toArray(new String[sels.size()][]);
		if (widget instanceof Tree || widget instanceof Table) {
			return selectItem(element, items, selectAll);
		}
		else if (widget instanceof org.eclipse.swt.widgets.List) {
			org.eclipse.swt.widgets.List l = (org.eclipse.swt.widgets.List) widget;
			Set<String> toSelect = new HashSet<String>();
			for (String[] ss : items) {
				toSelect.addAll(Arrays.asList(ss));
			}
			selectListItem(element, (String[]) toSelect.toArray(new String[toSelect.size()]));
			return true;
		}
		return false;
	}

	public static String[] getPathSelection(SWTUIElement uiElement) {
		Widget widget = unwrapWidget(uiElement);

		if (widget instanceof Tree) {
			Tree tree = (Tree) widget;
			TreeItem[] selection = tree.getSelection();
			if (selection != null && selection.length == 1) {
				return getPathByTreeItem(selection[0]);
			}
		}
		if (widget instanceof Table) {
			Table tree = (Table) widget;
			TableItem[] selection = tree.getSelection();
			if (selection != null && selection.length == 1) {
				return getPathByTableItem(selection[0]);
			}
		}
		if (widget instanceof org.eclipse.swt.widgets.List) {
			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) widget;
			String[] selection = list.getSelection();
			if (selection != null) {
				return getPathByListItem(selection);
			}
		}
		return null;
	}

	/**
	 * @return -1 on error, 0 if method should be called again, 1 on success
	 */
	public static int expandTreeItem(final SWTUIElement parent,
			final String[] path) {
		Widget widget = unwrapWidget(parent);
		if (!(widget instanceof Tree) || path == null) {
			return -1;
		}

		Tree tree = (Tree) widget;
		Set<Widget> parents = new LinkedHashSet<Widget>();
		parents.add(tree);
		for (int i = 0; i < path.length - 1; i++) {
			String part = path[i];
			Set<Item> itemsToExpand = new HashSet<Item>();
			for (Widget parentItem : parents) {
				itemsToExpand.addAll(findMatchingItems(parentItem, part));
			}

			for (Item item : itemsToExpand) {
				TreeItem treeItem = (TreeItem) item;
				if (treeItem.getExpanded()) {
					continue;
				}
				expandTreeItem(parent.getPlayer(), tree, (TreeItem) item);
				return 0; // Wait for expansion completion
			}

			if (itemsToExpand.isEmpty()) {
				return -1;
			}

			parents.clear();
			parents.addAll(itemsToExpand);
		}
		return 1;

	}

	public static void expandTreeItem(final SWTUIPlayer player,
			final Tree tree, final TreeItem treeItem) {
		player.exec("Run asyncs on tree", new Runnable() {
			public void run() {
				try {
					Object data = treeItem.getData();
					if (TeslaSWTAccess.ignoreMarkersView(data)) {
						return;
					}
					Rectangle imageBounds = treeItem.getImageBounds(0);
					Point clickPoint = new Point(imageBounds.x - 5,
							imageBounds.y + imageBounds.height / 2);
					Event down = Events.createMouseDown(clickPoint);
					Event up = Events.createMouseUp(clickPoint);
					up.widget = down.widget = tree;
					up.item = down.item = treeItem;
					player.getEvents().sendEvent(tree, down);
					player.getEvents().sendEvent(tree, treeItem, SWT.Expand);
					player.getEvents().sendEvent(tree, up);
					treeItem.setExpanded(true);
				} catch (Throwable e) {
					TeslaCore.log(e);
				}
			}
		});
	}

	public static void collapseTreeItem(final SWTUIPlayer player,
			final Tree tree, final TreeItem treeItem) {
		player.exec("Run asyncs on tree", new Runnable() {
			public void run() {
				try {
					Object data = treeItem.getData();
					if (TeslaSWTAccess.ignoreMarkersView(data)) {
						return;
					}
					player.getEvents().sendEvent(tree, treeItem, SWT.Collapse);
					treeItem.setExpanded(false);
				} catch (Throwable e) {
					TeslaCore.log(e);
				}
			}
		});
	}

	public static boolean checkTreeItem(final boolean newState,
			final SWTUIElement parent, final String[] path) {
		if (parent != null && unwrapWidget(parent) instanceof Tree
				&& path != null) {
			final SWTUIPlayer player = parent.getPlayer();
			final Tree tree = (Tree) unwrapWidget(parent);
			final TreeItem current = (TreeItem) firstMatch(path, tree);
			if (current != null) {
				tree.forceFocus();
				player.exec("checkTreeItem for tree", new Runnable() {
					public void run() {
						SWTEvents player = parent.getPlayer().getEvents();
						current.setChecked(newState);
						player.sendEvent(tree, current, SWT.Selection,
								SWT.CHECK);
					}
				});
				return true;
			}
		}
		return false;
	}

	public static boolean checkTableItem(final boolean newState,
			final SWTUIElement parent, final String part) {
		if (parent != null && unwrapWidget(parent) instanceof Table) {
			// Try to obtain tree viewer
			final CheckboxTableViewer viewer = TeslaSWTAccess.getCheckboxTableViewer((Table) unwrapWidget(parent));
			if (viewer != null) {
				IContentProvider provider = viewer.getContentProvider();
				IBaseLabelProvider labelProvider = viewer.getLabelProvider();
				Object input = viewer.getInput();
				if (provider instanceof IStructuredContentProvider) {
					IStructuredContentProvider treeProvider = (IStructuredContentProvider) provider;
					IBaseLabelProvider labels = labelProvider;
					Object current = null;
					Object[] children = treeProvider.getElements(input);
					boolean found = false;
					ITableLabelProvider tlp = null;
					if (labels instanceof ITableLabelProvider) {
						tlp = (ITableLabelProvider) labels;
					}
					String searchPath = part;
					int idx = findIndex(searchPath);
					if (idx > -1) {
						searchPath = stripIndex(searchPath);
					}

					if (labels instanceof CellLabelProvider) {
						Table table = viewer.getTable();
						return checkInStandardTable(newState, parent, part,
								table);

					}

					int currentIdx = 0;
					for (Object object : children) {
						if (tlp != null
								&& viewer.getTable().getColumnCount() > 0) {
							for (int i = 0; i < viewer.getTable()
									.getColumnCount(); i++) {
								String text = tlp.getColumnText(object, i);
								if (viewerMatchs(searchPath, text)) {
									if (idx == currentIdx) {
										current = object;
										found = true;
										break;
									}
									currentIdx++;
								}
							}
						} else if (tlp == null
								&& viewer.getTable().getColumnCount() > 0) {
							for (int i = 0; i < viewer.getTable()
									.getColumnCount(); i++) {
								CellLabelProvider cellLabelProvider = viewer
										.getLabelProvider(i);
								if (cellLabelProvider instanceof ILabelProvider) {
									String text = ((ILabelProvider) cellLabelProvider)
											.getText(object);
									if (viewerMatchs(searchPath, text)) {
										if (idx == currentIdx) {
											current = object;
											found = true;
											break;
										}
										currentIdx++;
									}
								}
							}
						} else {
							if (labels instanceof ILabelProvider) {
								String text = ((ILabelProvider) labels)
										.getText(object);
								if (viewerMatchs(searchPath, text)) {
									if (idx == currentIdx) {
										current = object;
										found = true;
										break;
									}
									currentIdx++;
								}
							}
						}
						if (found) {
							break;
						}
					}
					if (found && current != null) {
						final Object cur = current;
						final SWTUIPlayer player = parent.getPlayer();
						player.exec("checkTableItem for table with viewer",
								new Runnable() {
									public void run() {
										viewer.setChecked(cur, newState);

										Widget item = viewer.testFindItem(cur);
										player.getEvents().sendEvent(
												viewer.getTable(), item,
												SWT.Selection, SWT.CHECK);

										// TeslaSWTAccess.fireCheckStateChanged(viewer,
										// newState, cur);
									}
								});
						return true;
					}
				}
			}
		}
		/*
		 * This case work only with non dynamic tables.
		 */
		if (parent != null && unwrapWidget(parent) instanceof Table
				&& part != null) {
			return checkInStandardTable(newState, parent, part,
					(Table) unwrapWidget(parent));
		}
		return false;
	}

	private static boolean checkInStandardTable(final boolean newState,
			final SWTUIElement parent, final String part, final Table table) {
		Widget current = unwrapWidget(parent);
		Item[] items = TableTreeUtil.getItems(current);
		IViewerItem[] viewerItems = getViewerItems(items);
		if (items == null) {
			return false;
		}
		boolean found = false;
		final SWTUIPlayer player = parent.getPlayer();
		for (Item item : items) {
			final TableItem currentItem = (TableItem) item;
			int count = table.getColumnCount();
			if (count > 0) {
				String itemText = SWTUIPlayer.toSelectionItem(getTableItemText(
						new TableViewerItem((TableItem) item), part,
						viewerItems));
				if (viewerMatchs(part, itemText)) {
					current = item;
					player.exec("setSelection", new Runnable() {
						public void run() {
							currentItem.setChecked(newState);
							player.getEvents().sendEvent(table, currentItem,
									SWT.Selection, SWT.CHECK);
						}
					});
					found = true;
					break;
				}
			}
			if (count == 0) {
				String text = SWTUIPlayer.toSelectionItem(getTableItemText(
						new TableViewerItem((TableItem) item), part,
						viewerItems));
				if (viewerMatchs(part, text)) {
					current = item;
					player.exec("setSelection", new Runnable() {
						public void run() {
							currentItem.setChecked(newState);
							player.getEvents().sendEvent(table, currentItem,
									SWT.Selection, SWT.CHECK);
						}
					});
					found = true;
				}
			}
		}
		if (found == false) {
			return false;
		}
		return true;
	}

	public static void updateVirtualTableTree(final Widget ctrl) {
		if (ctrl instanceof Table) {
			int itemCount = ((Table) ctrl).getItemCount();
			for (int i = 0; i < itemCount; i++) {
				final int index = i;
				ctrl.getDisplay().asyncExec(new Runnable() {
					public void run() {
						((Table) ctrl).setTopIndex(index);
					}
				});
			}
		} else if (ctrl instanceof Tree) {
			scrollToTreeItems((Tree) ctrl, TableTreeUtil.getItems(ctrl));
		}
	}

	private static void scrollToTreeItems(final Tree control, Item[] items) {
		if (items == null) {
			return;
		}
		for (final Item item : items) {
			control.getDisplay().asyncExec(new Runnable() {
				public void run() {
					control.setTopItem((TreeItem) item);
				}
			});
			scrollToTreeItems(control, TableTreeUtil.getChildren(item));
		}
	}
}
