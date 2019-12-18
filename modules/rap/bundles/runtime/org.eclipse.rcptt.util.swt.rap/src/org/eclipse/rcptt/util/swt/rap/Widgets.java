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
package org.eclipse.rcptt.util.swt.rap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Widget;

public class Widgets {
	public static boolean isToggleButton(Widget widget) {
		return widget instanceof Button && hasStyle(widget, SWT.TOGGLE);
	}

	public static boolean hasStyle(Widget widget, int styleBit) {
		return (widget.getStyle() & styleBit) != 0;
	}
}
