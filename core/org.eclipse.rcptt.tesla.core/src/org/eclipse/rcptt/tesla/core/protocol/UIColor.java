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
package org.eclipse.rcptt.tesla.core.protocol;

public class UIColor {
	public int r, g, b;

	public UIColor() {
	}

	public UIColor(int red, int blue, int green) {
		r = red;
		g = blue;
		b = green;
	}

	public UIColor(String color) {
		String[] colors = color.split(":");
		r = Integer.parseInt(colors[0]);
		g = Integer.parseInt(colors[1]);
		b = Integer.parseInt(colors[2]);
	}

	@Override
	public String toString() {
		return r + ":" + g + ":" + b;

	}
}
