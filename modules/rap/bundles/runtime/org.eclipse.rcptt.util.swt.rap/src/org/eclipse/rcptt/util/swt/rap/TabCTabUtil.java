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
package org.eclipse.rcptt.util.swt.rap;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class TabCTabUtil {
	public static Composite getParent(Item item) {
		if (item instanceof CTabItem) {
			return ((CTabItem) item).getParent();
		}
		return ((TabItem) item).getParent();
	}

	public static void setSelection(Composite parent, Item item) {
		if (parent instanceof CTabFolder) {
			((CTabFolder) parent).setSelection((CTabItem) item);
		} else {
			((TabFolder) parent).setSelection((TabItem) item);
		}
	}

	public static Rectangle getBounds(Item item) {
		if (item instanceof CTabItem) {
			return ((CTabItem) item).getBounds();
		}
		return ((TabItem) item).getBounds();
	}
}
