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
package org.eclipse.jface.viewers;

import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

public class UpdateViewerCell extends ViewerCell {

	private Object item;

	public UpdateViewerCell(Object item) {
		super(null, 0, null);
		this.item = item;
	}

	private String text;

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	public Rectangle getBounds() {
		return null;
	}

	public Object getElement() {
		return item;
	}

	public Image getImage() {
		return null;
	}

	public void setBackground(Color background) {

	}

	public void setForeground(Color foreground) {
	}

	public void setFont(Font font) {
	}

	public void setImage(Image image) {
	}

	public void setStyleRanges(StyleRange[] styleRanges) {
	}

	public StyleRange[] getStyleRanges() {
		return null;
	}

	void update(ViewerRow rowItem, int column, Object element) {
	}

	public Widget getItem() {
		return null;
	}

	public Control getControl() {
		return null;
	}

	public int getVisualIndex() {
		return getColumnIndex();
	}

	public ViewerCell getNeighbor(int directionMask, boolean sameLevel) {
		return null;
	}

	public ViewerRow getViewerRow() {
		return null;
	}

	public Rectangle getTextBounds() {
		return null;
	}

	public Rectangle getImageBounds() {
		return null;
	}

	public Color getForeground() {
		return null;
	}

	public Color getBackground() {
		return null;
	}

	public Font getFont() {
		return null;
	}

	public boolean scrollIntoView() {
		return false;
	}
}
