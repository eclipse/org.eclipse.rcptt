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
package org.eclipse.rcptt.tesla.recording.core.swt;

import java.lang.reflect.Field;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

public class CComboSupport {

	public static boolean isComboWidget(CCombo combo, Widget widget) {
		if (!(widget instanceof Control)) {
			return false;
		}
		Control ctrl = (Control) widget;
		if (ctrl.getParent() != null && ctrl.getParent().equals(combo)) {
			return true;
		}
		try {
			Field field = CCombo.class.getDeclaredField("popup");
			field.setAccessible(true);
			Shell sh = (Shell) field.get(combo);
			if (ctrl.getShell().equals(sh)) {
				return true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			Field field = CCombo.class.getDeclaredField("arrow");
			field.setAccessible(true);
			Button sh = (Button) field.get(combo);
			if (ctrl.equals(sh)) {
				return true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			Field field = CCombo.class.getDeclaredField("text");
			field.setAccessible(true);
			Text sh = (Text) field.get(combo);
			if (ctrl.equals(sh)) {
				return true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			Field field = CCombo.class.getDeclaredField("list");
			field.setAccessible(true);
			List sh = (List) field.get(combo);
			if (ctrl.equals(sh)) {
				return true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return false;
	}
}
