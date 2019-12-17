/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.tree.ui;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.rcptt.ui.utils.RangeUtils;
import org.eclipse.rcptt.util.swt.StyleRangeUtils;
import org.eclipse.rcptt.verifications.tree.Cell;
import org.eclipse.rcptt.verifications.tree.ItemData;
import org.eclipse.rcptt.verifications.tree.Row;
import org.eclipse.rcptt.verifications.tree.TreeVerificationUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class VerificationTreeLabelProvider extends StyledCellLabelProvider {
	
	private Map<String, Image> images;
	boolean drawIcons;
	boolean ignoreStyle;
	boolean skipStyledText;
	List<Integer> excludedColumns;

	public VerificationTreeLabelProvider(Map<String, Image> images,
			boolean drawIcons, boolean ignoreStyle, boolean skipStyledText, List<Integer> excludedColumns) {
		super();
		this.images = images;
		this.drawIcons = drawIcons;
		this.ignoreStyle = ignoreStyle;
		this.skipStyledText = skipStyledText;
		this.excludedColumns = excludedColumns;
	}

	public void setDrawIcons(boolean drawIcons) {
		this.drawIcons = drawIcons;
	}

	public void setIgnoreStyle(boolean ignoreStyle) {
		this.ignoreStyle = ignoreStyle;
	}

	public void setSkipStyledText(boolean skipStyledText) {
		this.skipStyledText = skipStyledText;
	}

	public void setExcludedColumns(List<Integer> excludedColumns) {
		this.excludedColumns = excludedColumns;
	}

	@Override
	public void update(ViewerCell cell) {
		if (cell.getElement() instanceof Row) {
			Row row = (Row) cell.getElement();
			int ind = cell.getColumnIndex();

			if (row.getValues().size() > ind) {
				Cell cellValue = row.getValues().get(ind);
				ItemData cellData = cellValue.getData();

				if (ignoreStyle) {
					cell.setStyleRanges(null);
					cell.setText(cellData.getText());
				} else {
					StyleRange[] ranges = RangeUtils.fromEMF(
							cellValue.getStyle(), cell.getItem().getDisplay());

					if (skipStyledText) {
						cell.setStyleRanges(null);
						cell.setText(StyleRangeUtils.getNonStyledText(ranges, cellData.getText()));
					} else {
						cell.setStyleRanges(ranges);
						cell.setText(cellData.getText());
					}
				}
				if (excludedColumns.contains(ind)) {
					cell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
					cell.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND));
				} else {
					cell.setBackground(RangeUtils.colorFromEMF(
							cellData.getBackgroundColor(), cell.getItem().getDisplay()));
					cell.setForeground(RangeUtils.colorFromEMF(
							cellData.getForegroundColor(), cell.getItem().getDisplay()));
				}
				if (drawIcons) {
					String imgPath = TreeVerificationUtils.getDecoratedImagePath(cellData.getImage());
					if (images.containsKey(imgPath)) {
						cell.setImage(images.get(imgPath));
					}
				} else {
					cell.setImage(null);
				}
			}
		}
	}

}
