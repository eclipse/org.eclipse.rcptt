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
package org.eclipse.rcptt.util.swt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.util.Policy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class TableTreeUtil {
	/**
	 * Returns name for {@link TreeColumn} or {@link TableColumn}
	 *
	 * @param widget
	 * @return
	 */
	public static String getName(Widget widget) {
		return (widget instanceof TableColumn) ? ((TableColumn) widget)
				.getText() : ((TreeColumn) widget).getText();
	}

	/**
	 * Returns width for {@link TreeColumn} or {@link TableColumn}
	 *
	 * @param widget
	 * @return
	 */
	public static int getWidth(Widget widget) {
		return (widget instanceof TableColumn) ? ((TableColumn) widget)
				.getWidth() : ((TreeColumn) widget).getWidth();
	}

	/**
	 * Returns column order from {@link Tree} or {@link Table}
	 *
	 * @param widget
	 * @return
	 */
	public static int[] getColumnOrder(Widget widget) {
		return (widget instanceof Table) ? ((Table) widget).getColumnOrder()
				: ((Tree) widget).getColumnOrder();
	}

	/**
	 * Returns column from {@link Table} or {@link Tree} identified by index
	 *
	 * @param parent
	 * @param index
	 * @return
	 */
	public static Widget getColumn(Widget widget, int index) {
		return (widget instanceof Table) ? ((Table) widget).getColumn(index)
				: ((Tree) widget).getColumn(index);
	}

	/**
	 * Returns column index from {@link Table} or {@link Tree} identified by
	 * column name
	 *
	 * @param parent
	 * @param columnName
	 * @return
	 */
	public static int getColumnIndex(Widget widget, String columnName) {
		if (widget instanceof TableItem
				|| widget instanceof TreeItem)
			widget = getParent(widget);
		Widget column = findColumn(widget, columnName, 0);
		if (column == null) {
			return -1;
		}
		int count = getColumnCount(widget);
		for (int i = 0; i < count; i++) {
			if (column == getColumn(widget, i)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns {@link Table} by {@link TableColumn} or {@link Tree} by
	 * {@link TreeColumn}
	 *
	 * @param widget
	 * @return
	 */
	public static Widget getParent(Widget widget) {
		if (widget instanceof TableColumn) {
			return ((TableColumn) widget).getParent();
		}
		if (widget instanceof TreeColumn) {
			return ((TreeColumn) widget).getParent();
		}
		if (widget instanceof TableItem) {
			return ((TableItem) widget).getParent();
		}
		return ((TreeItem) widget).getParent();
	}

	/**
	 * Returns all columns from {@link Tree} or {@link Table} in display order
	 *
	 * @param widget
	 * @return
	 */
	public static Widget[] getColumns(Widget widget) {
		int[] columnOrder = getColumnOrder(widget);
		Widget[] result = new Widget[getColumnCount(widget)];
		for (int i = 0; i < result.length; i++) {
			result[i] = getColumn(widget, columnOrder[i]);
		}
		return result;
	}

	public static void showItem(Widget item) {
		if (item instanceof TableItem) {
			TableItem tableItem = (TableItem) item;
			tableItem.getParent().showItem(tableItem);
		} else if (item instanceof TreeItem) {
			TreeItem treeItem = (TreeItem) item;
			treeItem.getParent().showItem(treeItem);
		}
	}

	public static void showColumn(Widget column) {
		if (column instanceof TableColumn) {
			TableColumn tableColumn = (TableColumn) column;
			tableColumn.getParent().showColumn(tableColumn);
		} else if (column instanceof TreeColumn) {
			TreeColumn treeColumn = (TreeColumn) column;
			treeColumn.getParent().showColumn(treeColumn);
		}
	}

	public static int getColumnWidth(Widget widget) {
		return widget instanceof TreeColumn ? ((TreeColumn) widget).getWidth()
				: ((TableColumn) widget).getWidth();
	}

	/**
	 * Returns column count for {@link Table} or {@link Tree}
	 *
	 * @param widget
	 * @return
	 */
	public static int getColumnCount(Widget widget) {
		if (widget instanceof Table) {
			return ((Table) widget).getColumnCount();
		} else if (widget instanceof Tree) {
			return ((Tree) widget).getColumnCount();
		} else if (widget instanceof TableItem) {
			return ((TableItem) widget).getParent().getColumnCount();
		} else {
			return ((TreeItem) widget).getParent().getColumnCount();
		}
	}

	public static Item[] getItems(Widget widget) {
		if (widget instanceof TableItem) {
			return new Item[0];
		}
		return (widget instanceof Table) ? ((Table) widget).getItems()
				: (widget instanceof Tree) ? ((Tree) widget).getItems()
						: ((TreeItem) widget).getItems();
	}

	/**
	 * Returns all items including children, convenience method so that table
	 * and tree api looks identical
	 */
	public static Item[] getExpandedItems(Widget widget) {
		if (widget instanceof Table) {
			return ((Table) widget).getItems();
		}

		List<Item> result = new ArrayList<Item>();
		for (Item child : getItems(widget)) {
			result.add(child);
			result.addAll(Arrays.asList(getAllChildren(child)));
		}
		return result.toArray(new TreeItem[result.size()]);
	}

	/**
	 * Returns bounds of item in given column.
	 */
	public static Rectangle getBounds(Item item, int column) {
		if (item instanceof TableItem) {
			return ((TableItem) item).getBounds(column);
		}
		return ((TreeItem) item).getBounds(column);
	}

	public static Rectangle getBounds(Item item) {
		if (item instanceof TableItem) {
			return ((TableItem) item).getBounds();
		}
		return ((TreeItem) item).getBounds();
	}

	/**
	 * Returns index of top item in {@link #getExpandedItems(Widget)} result
	 */
	public static int getTopIndex(Widget widget) {
		if (widget instanceof Table) {
			return ((Table) widget).getTopIndex();
		}

		Item topItem = ((Tree) widget).getTopItem();
		Item[] items = getExpandedItems(widget);
		for (int i = 0; i < items.length; i++) {
			if (items[i] == topItem) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * (row, col) if found, <code>null</code> otherwise
	 *
	 * @param widget
	 * @param coords
	 * @return
	 */
	public static Point findCell(Widget widget, Point coords) {
		Item[] items = getExpandedItems(widget);
		int firstRow = getTopIndex(widget);
		int columnCount = getColumnCount(widget);

		for (int row = firstRow; row < items.length; row++) {
			Item item = items[row];
			for (int column = 0; column < columnCount; column++) {
				if (getBounds(item, column).contains(coords)) {
					return new Point(row, column);
				}
			}
		}

		return null;
	}

	/**
	 * row if found, <code>-1</code> otherwise
	 *
	 * @param widget
	 * @param coords
	 * @return
	 */
	public static int findRow(Widget widget, Point coords) {
		Item[] items = getExpandedItems(widget);
		int firstRow = getTopIndex(widget);

		for (int row = firstRow; row < items.length; row++) {
			Rectangle bounds = getBounds(items[row]);
			if (coords.y >= bounds.y && coords.y <= bounds.y + bounds.height
					&& coords.x >= bounds.x)
				return row;
		}

		return -1;
	}

	/**
	 * Returns item by given row as in {@link #getExpandedItems(Widget)}
	 */
	public static Item getItem(Widget widget, int row) {
		return getExpandedItems(widget)[row];
	}

	public static StyleRange[] getStyleRanges(Item item) {
		return getStyleRanges(item, 0);
	}

	public static String getRangeDataKey(int column) {
		return String.format("%sstyled_label_key_%d", Policy.JFACE, column);
	}

	public static StyleRange[] getStyleRanges(Item item, int column) {
		return (StyleRange[]) item.getData(getRangeDataKey(column));
	}

	public static Item[] getAllChildren(Item item) {
		if (item instanceof TableItem) {
			return new TableItem[0];
		}

		List<Item> result = new ArrayList<Item>();
		for (Item child : getChildren(item)) {
			result.add(child);
			result.addAll(Arrays.asList(getAllChildren(child)));
		}
		return result.toArray(new Item[result.size()]);
	}

	public static String[] getValues(Item item) {
		List<String> result = new ArrayList<String>();
		if (getColumnCount(getParent(item)) == 0) {
			return new String[] { getValue(item) };
		}
		for (int i : getColumnOrder(getParent(item))) {
			result.add(getValue(item, i));
		}

		return result.toArray(new String[result.size()]);
	}

	public static String getValue(Item item, int column) {
		return (item instanceof TreeItem) ? ((TreeItem) item).getText(column)
				: ((TableItem) item).getText(column);
	}

	public static Image getColumnImage(Widget column) {
		return (column instanceof TreeColumn) ? ((TreeColumn) column).getImage()
				: ((TableColumn) column).getImage();
	}

	public static Image getImage(Item item) {
		return (item instanceof TreeItem) ? ((TreeItem) item).getImage()
				: ((TableItem) item).getImage();
	}

	public static void setImage(Item item, Image image) {
		if (item instanceof TreeItem) {
			((TreeItem) item).setImage(image);
		} else {
			((TableItem) item).setImage(image);
		}
	}

	public static Image getImage(Item item, int column) {
		return (item instanceof TreeItem) ? ((TreeItem) item).getImage(column)
				: ((TableItem) item).getImage(column);
	}

	public static String getValue(Item item) {
		return (item instanceof TreeItem) ? ((TreeItem) item).getText()
				: ((TableItem) item).getText();
	}

	public static String getTooltip(Widget widget) {
		return (widget instanceof TableColumn) ? ((TableColumn) widget)
				.getToolTipText() : ((TreeColumn) widget).getToolTipText();
	}

	/**
	 * Convenince method - returns empty array for {@link TableItem} or childre
	 * for {@link TreeItem}
	 *
	 * @return
	 */
	public static Item[] getChildren(Widget item) {
		if (item instanceof TableItem) {
			return new Item[0];
		}

		TreeItem ti = (TreeItem) item;
		return ti.getExpanded() ? ti.getItems() : new Item[0];
	}

	public static boolean isChecked(Widget item) {
		return (item instanceof TableItem) ? ((TableItem) item).getChecked()
				: ((TreeItem) item).getChecked();
	}

	public static Rectangle getItemBounds(Widget item, int column) {
		if (item instanceof TableItem) {
			return ((TableItem) item).getBounds(column);
		}
		return ((TreeItem) item).getBounds(column);
	}

	public static Rectangle getItemBounds(Widget item) {
		if (item instanceof TableItem) {
			return ((TableItem) item).getBounds();
		}
		return ((TreeItem) item).getBounds();
	}

	/**
	 * Searches for a column in {@link Table} or {@link Tree}
	 *
	 * @param parent
	 * @param name
	 * @param index
	 * @return column if found
	 */
	private static Widget findColumn(Widget[] columns, String name, int index,
			boolean regex) {
		for (Widget column : columns) {
			if (!matches(getName(column), name, regex)) {
				String nameFromTooltip = getTooltip(column);
				if (nameFromTooltip == null) {
					continue;
				}
				if (!matches(nameFromTooltip, name, regex)) {
					continue;
				}
			}
			if (index == 0) {
				return column;
			}

			index--;
		}

		return null;
	}

	/**
	 * Searches for a column in {@link Table} or {@link Tree}
	 *
	 * @param parent
	 * @param name
	 * @param index
	 * @return Column if found
	 */
	public static Widget findColumn(Widget widget, String name, int index) {
		Widget[] columns = getColumns(widget);
		if (name == null || name.length() == 0) {
			return index < columns.length ? columns[index] : null;
		}
		Widget result = findColumn(columns, name, index, false);
		if (result == null) {
			result = findColumn(columns, name, index, true);
		}
		return result;
	}

	public static void setSelection(Widget parent, Widget item) {
		if (parent instanceof Tree) {
			((Tree) parent).setSelection((TreeItem) item);
		} else {
			((Table) parent).setSelection((TableItem) item);
		}

	}

	public static void deselectAll(Widget widget) {
		if (widget instanceof Table) {
			((Table) widget).deselectAll();
		} else {
			((Tree) widget).deselectAll();
		}
	}

	public static void setSelection(Widget parent, Widget[] items) {
		if (parent instanceof Tree) {
			TreeItem[] treeItems = new TreeItem[items.length];
			for (int i = 0; i < items.length; i++) {
				treeItems[i] = (TreeItem) items[i];
			}
			((Tree) parent).setSelection(treeItems);
		} else {
			TableItem[] tableItems = new TableItem[items.length];
			for (int i = 0; i < items.length; i++) {
				tableItems[i] = (TableItem) items[i];
			}
			((Table) parent).setSelection(tableItems);
		}
	}

	private static boolean matches(String name, String pattern, boolean useRegex) {
		return useRegex ? name.matches(pattern) : name.equals(pattern);
	}

	public static boolean isVirtual(Object item) {
		int style = 0;
		if (item instanceof TreeItem) {
			style = ((TreeItem) item).getParent().getStyle();
		} else if (item instanceof TableItem) {
			style = ((TreeItem) item).getParent().getStyle();
		} else if (item instanceof Tree) {
			style = ((Tree) item).getStyle();
		} else if (item instanceof Table) {
			style = ((Table) item).getStyle();
		}
		return (style & SWT.VIRTUAL) != 0;
	}

	public static void setRowChecked(Widget item, boolean checked) {
		if (item instanceof TableItem) {
			((TableItem) item).setChecked(checked);
		} else if (item instanceof TreeItem) {
			((TreeItem) item).setChecked(checked);
		}
	}

	public static void setRowGrayed(Widget item, boolean grayed) {
		if (item instanceof TableItem) {
			((TableItem) item).setGrayed(grayed);
		} else if (item instanceof TreeItem) {
			((TreeItem) item).setGrayed(grayed);
		}
	}

	public static Color getForeground(Widget item, int columnInd) {
		if (item instanceof TreeItem) {
			return ((TreeItem) item).getForeground(columnInd);
		} else {
			return ((TableItem) item).getForeground(columnInd);
		}
	}

	public static Color getForeground(Widget item) {
		if (item instanceof TreeItem) {
			return ((TreeItem) item).getForeground();
		} else {
			return ((TableItem) item).getForeground();
		}
	}

	public static void setForeground(Widget item, Color color) {
		if (item instanceof TreeItem) {
			((TreeItem) item).setForeground(color);
		} else {
			((TableItem) item).setForeground(color);
		}
	}

	public static Color getBackground(Widget item, int columnInd) {
		if (item instanceof TreeItem) {
			return ((TreeItem) item).getBackground(columnInd);
		} else {
			return ((TableItem) item).getBackground(columnInd);
		}
	}

	public static Color getBackground(Widget item) {
		if (item instanceof TreeItem) {
			return ((TreeItem) item).getBackground();
		} else {
			return ((TableItem) item).getBackground();
		}
	}

	public static void setBackground(Widget item, Color color) {
		if (item instanceof TreeItem) {
			((TreeItem) item).setBackground(color);
		} else {
			((TableItem) item).setBackground(color);
		}
	}

	public static boolean getGrayed(Widget item) {
		if (item instanceof TreeItem) {
			return ((TreeItem) item).getGrayed();
		} else {
			return ((TableItem) item).getGrayed();
		}
	}

	public static int getHorizontalScrollPos(Widget tableOrTree) {
		if (!(tableOrTree instanceof Scrollable))
			return 0;

		Scrollable scrollable = (Scrollable) tableOrTree;
		ScrollBar scrollBar = scrollable.getHorizontalBar();
		if (scrollBar == null)
			return 0;

		return scrollBar.getSelection();
	}

	public static boolean getEnabled(Widget tableOrTree) {
		if (tableOrTree instanceof Tree)
			return ((Tree) tableOrTree).getEnabled();
		return ((Table) tableOrTree).getEnabled();
	}

	public static boolean getHeaderVisible(Widget tableOrTree) {
		if (tableOrTree instanceof Tree)
			return ((Tree) tableOrTree).getHeaderVisible();
		return ((Table) tableOrTree).getHeaderVisible();
	}

	public static boolean getLinesVisible(Widget tableOrTree) {
		if (tableOrTree instanceof Tree)
			return ((Tree) tableOrTree).getLinesVisible();
		return ((Table) tableOrTree).getLinesVisible();
	}

	public static int getSortColumn(Widget tableOrTree) {
		Widget sortCol = null;
		if (tableOrTree instanceof Tree) {
			sortCol = ((Tree) tableOrTree).getSortColumn();
		} else if (tableOrTree instanceof Table) {
			sortCol = ((Table) tableOrTree).getSortColumn();
		}
		if (sortCol == null) {
			return -1;
		} else {
			Widget[] cols = getColumns(tableOrTree);
			for (int i = 0; i < cols.length; i++) {
				if (cols[i] == sortCol) {
					return i;
				}
			}
			return -1;
		}
	}

	public static int getSortDirection(Widget tableOrTree) {
		if (tableOrTree instanceof Tree)
			return ((Tree) tableOrTree).getSortDirection();
		return ((Table) tableOrTree).getSortDirection();
	}

	public static int getHeaderHeight(Widget tableOrTree) {
		if (tableOrTree instanceof Tree)
			return ((Tree) tableOrTree).getHeaderHeight();
		return ((Table) tableOrTree).getHeaderHeight();
	}

	public static Rectangle getColumnBounds(Widget column) {
		Widget tableOrTree = getParent(column);
		if (!getHeaderVisible(tableOrTree))
			return null;

		int h = getHeaderHeight(tableOrTree);
		int x = getHorizontalScrollPos(tableOrTree);
		for (Widget c : getColumns(tableOrTree)) {
			int w = getColumnWidth(c);
			if (c == column)
				return new Rectangle(x, -h, w, h);
			x += w;
		}

		return null;
	}

	public static Widget getColumnFromPoint(Widget tableOrTree, Point point) {
		if (!getHeaderVisible(tableOrTree))
			return null;

		for (Widget c : getColumns(tableOrTree)) {
			Rectangle bounds = getColumnBounds(c);
			if (bounds != null && bounds.contains(point))
				return c;
		}

		return null;
	}

	public static Object[] getSelection(Widget tableOrTree) {
		if (tableOrTree instanceof Table) {
			Table table = (Table) tableOrTree;
			return table.getSelection();
		} else {
			Tree tree = (Tree) tableOrTree;
			return tree.getSelection();
		}

	}
}
