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
package org.eclipse.rcptt.verifications.tree.ui;

import java.util.Map;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import org.eclipse.rcptt.ui.utils.RangeUtils;
import org.eclipse.rcptt.util.swt.StyleRangeUtils;
import org.eclipse.rcptt.util.swt.TableTreeUtil;
import org.eclipse.rcptt.verifications.tree.Cell;
import org.eclipse.rcptt.verifications.tree.ItemData;
import org.eclipse.rcptt.verifications.tree.Row;
import org.eclipse.rcptt.verifications.tree.TreeVerificationUtils;

public class VerificationTreeLabelProvider extends StyledCellLabelProvider {
	private Map<String, Image> images;
	boolean drawIcons;
	boolean ignoreStyle;
	boolean skipStyledText;

	public VerificationTreeLabelProvider(Map<String, Image> images,
			boolean drawIcons, boolean ignoreStyle, boolean skipStyledText) {
		super();
		this.images = images;
		this.drawIcons = drawIcons;
		this.ignoreStyle = ignoreStyle;
		this.skipStyledText = skipStyledText;
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

	@Override
	public void update(ViewerCell cell) {
		if (cell.getElement() instanceof Row) {
			Row row = (Row) cell.getElement();
			int ind = cell.getColumnIndex();

			if (ind == 0) {
				ItemData data = row.getData();
				Display display = cell.getItem().getDisplay();

				TableTreeUtil.setRowChecked(cell.getItem(), row.isChecked());
				TableTreeUtil.setRowGrayed(cell.getItem(), row.isGrayed());
				TableTreeUtil.setBackground(cell.getItem(),
						RangeUtils.colorFromEMF(data.getBackgroundColor(), display));
				TableTreeUtil.setForeground(cell.getItem(),
						RangeUtils.colorFromEMF(data.getForegroundColor(), display));
			}
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
				cell.setBackground(RangeUtils.colorFromEMF(
						cellData.getBackgroundColor(), cell.getItem().getDisplay()));
				cell.setForeground(RangeUtils.colorFromEMF(
						cellData.getForegroundColor(), cell.getItem().getDisplay()));
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
