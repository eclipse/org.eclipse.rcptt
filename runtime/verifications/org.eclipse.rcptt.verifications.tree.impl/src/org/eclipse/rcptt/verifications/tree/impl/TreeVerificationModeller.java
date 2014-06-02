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
package org.eclipse.rcptt.verifications.tree.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.util.swt.ImageUtil;
import org.eclipse.rcptt.util.swt.TableTreeUtil;
import org.eclipse.rcptt.verifications.tree.Cell;
import org.eclipse.rcptt.verifications.tree.Column;
import org.eclipse.rcptt.verifications.tree.ItemData;
import org.eclipse.rcptt.verifications.tree.Row;
import org.eclipse.rcptt.verifications.tree.Tree;
import org.eclipse.rcptt.verifications.tree.TreeFactory;
import org.eclipse.rcptt.verifications.tree.TreeVerificationUtils;
import org.eclipse.rcptt.tesla.core.ui.Image;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;

public class TreeVerificationModeller {

	public static Tree getTreeData(Widget widget, boolean includeRowsData) {
		Tree result = TreeFactory.eINSTANCE.createTree();
		Widget[] columns = TableTreeUtil.getColumns(widget);

		result.setStyle(widget.getStyle());
		result.setEnabled(TableTreeUtil.getEnabled(widget));
		result.setHeaderVisible(TableTreeUtil.getHeaderVisible(widget));
		result.setLinesVisible(TableTreeUtil.getLinesVisible(widget));
		result.setSortColumnInd(TableTreeUtil.getSortColumn(widget));
		result.setSortDirection(TableTreeUtil.getSortDirection(widget));

		for (int i = 0; i < columns.length; i++) {
			Column col = TreeFactory.eINSTANCE.createColumn();
			Widget column = columns[i];

			col.setImage(SWTModelMapper.mapImage(
					TableTreeUtil.getColumnImage(column)));
			col.setStyle(column.getStyle());
			col.setTooltip(TableTreeUtil.getTooltip(column));
			col.setName(TableTreeUtil.getName(column));
			col.setWidth(TableTreeUtil.getWidth(column));
			result.getColumns().add(col);
		}
		if (includeRowsData) {
			for (Item item : TableTreeUtil.getItems(widget)) {
				result.getRows().add(getRow(item, columns.length, true));
			}
		}
		return result;
	}

	public static Row getRow(Item item, int columnCount, boolean includeChildren) {
		Row result = TreeFactory.eINSTANCE.createRow();
		ItemData itemData = TreeFactory.eINSTANCE.createItemData();
		Image image = SWTModelMapper.mapImage(TableTreeUtil.getImage(item));

		result.setChecked(TableTreeUtil.isChecked(item));
		result.setGrayed(TableTreeUtil.getGrayed(item));
		itemData.setText(TableTreeUtil.getValue(item));
		itemData.setBackgroundColor(SWTModelMapper.makeColor(TableTreeUtil.getBackground(item)));
		itemData.setForegroundColor(SWTModelMapper.makeColor(TableTreeUtil.getForeground(item)));
		itemData.setImage(image);
		result.setData(itemData);

		if (columnCount == 0) {
			result.getValues().add(createCellfromItem(item, 0));
		} else {
			for (int i = 0; i < columnCount; i++) {
				result.getValues().add(createCellfromItem(item, i));
			}
		}
		if (includeChildren) {
			for (Item child : TableTreeUtil.getChildren(item)) {
				result.getChildren().add(
						getRow(child, columnCount, true));
			}
		}
		return result;
	}

	private static Cell createCellfromItem(Item item, int index) {
		Cell cell = TreeFactory.eINSTANCE.createCell();
		ItemData cellData = TreeFactory.eINSTANCE.createItemData();
		Image image = SWTModelMapper.mapImage(TableTreeUtil.getImage(item, index));
		List<StyleRangeEntry> styleRanges = new ArrayList<StyleRangeEntry>();
		StyleRange[] ranges = TableTreeUtil.getStyleRanges(item, index);

		if (ranges != null) {
			for (StyleRange styleRange : ranges) {
				styleRanges.add(SWTModelMapper.makeStyleRangeEntry(styleRange));
			}
			cell.getStyle().addAll(styleRanges);
		}
		cellData.setText(TableTreeUtil.getValue(item, index));
		cellData.setBackgroundColor(SWTModelMapper.makeColor(TableTreeUtil.getBackground(item, index)));
		cellData.setForegroundColor(SWTModelMapper.makeColor(TableTreeUtil.getForeground(item, index)));
		cellData.setImage(image);
		cell.setData(cellData);
		return cell;
	}

	public static Map<String, byte[]> extractImages(Widget widget) {
		Map<String, byte[]> images = new HashMap<String, byte[]>();
		for (Widget column : TableTreeUtil.getColumns(widget)) {
			insertImage(TableTreeUtil.getColumnImage(column), images);
		}
		for (Item item : TableTreeUtil.getItems(widget)) {
			extractImages(item, images);
		}
		return images;
	}

	private static void extractImages(Item item, Map<String, byte[]> imagesDest) {
		int columnsCount = TableTreeUtil.getColumnCount(item);
		List<org.eclipse.swt.graphics.Image> images = new ArrayList<org.eclipse.swt.graphics.Image>();

		if (columnsCount == 0) {
			images.add(TableTreeUtil.getImage(item));
		} else {
			for (int i = 0; i < columnsCount; i++) {
				images.add(TableTreeUtil.getImage(item, i));
			}
		}
		for (int i = 0; i < images.size(); i++) {
			insertImage(images.get(i), imagesDest);
		}
		for (Item child : TableTreeUtil.getChildren(item)) {
			extractImages(child, imagesDest);
		}
	}

	private static void insertImage(org.eclipse.swt.graphics.Image swtImage,
			Map<String, byte[]> imageDest) {
		Image image = SWTModelMapper.mapImage(swtImage);

		if (image != null) {
			String path = TreeVerificationUtils.getDecoratedImagePath(image);
			if (!imageDest.containsKey(path)) {
				imageDest.put(path, ImageUtil.serializeImage(swtImage));
			}
		}
	}
}
