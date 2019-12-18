/*******************************************************************************
 * Copyright (c) 2000, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.rcptt.ui.editors.ecl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Color manager.
 */
public class ColorManager {

	protected Map<String, RGB> keyTable = new HashMap<String, RGB>(10);
	protected Map<Display, Map<RGB, Color>> displayTable = new HashMap<Display, Map<RGB, Color>>(
			2);

	/**
	 * Flag which tells if the colors are automatically disposed when the
	 * current display gets disposed.
	 */
	private final boolean fAutoDisposeOnDisplayDispose;

	/**
	 * Creates a new color manager which automatically disposes the allocated
	 * colors when the current display gets disposed.
	 */
	public ColorManager() {
		this(true);
	}

	/**
	 * Creates a new color manager.
	 */
	public ColorManager(boolean autoDisposeOnDisplayDispose) {
		fAutoDisposeOnDisplayDispose = autoDisposeOnDisplayDispose;
	}

	public void dispose(Display display) {
		Map<?, Color> colorTable = displayTable.get(display);
		if (colorTable != null) {
			for (Color color : colorTable.values()) {
				if (color != null && !color.isDisposed())
					color.dispose();
			}
		}
	}

	public Color getColor(RGB rgb) {
		if (rgb == null)
			return null;
		final Display display = Display.getCurrent();
		Map<RGB, Color> colorTable = displayTable.get(display);
		if (colorTable == null) {
			colorTable = new HashMap<RGB, Color>(10);
			displayTable.put(display, colorTable);
			if (fAutoDisposeOnDisplayDispose) {
				display.disposeExec(new Runnable() {
					public void run() {
						dispose(display);
					}
				});
			}
		}
		Color color = colorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			colorTable.put(rgb, color);
		}
		return color;
	}

	public void dispose() {
		if (!fAutoDisposeOnDisplayDispose)
			dispose(Display.getCurrent());
	}

	public Color getColor(String key) {
		if (key == null)
			return null;
		RGB rgb = keyTable.get(key);
		return getColor(rgb);
	}

	public void bindColor(String key, RGB rgb) {
		Object value = keyTable.get(key);
		if (value != null)
			throw new UnsupportedOperationException();
		keyTable.put(key, rgb);
	}

	public void unbindColor(String key) {
		keyTable.remove(key);
	}
}
