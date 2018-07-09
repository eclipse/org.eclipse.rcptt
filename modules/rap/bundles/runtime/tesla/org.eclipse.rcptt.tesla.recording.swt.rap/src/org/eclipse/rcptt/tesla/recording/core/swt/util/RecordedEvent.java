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
package org.eclipse.rcptt.tesla.recording.core.swt.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.eclipse.rcptt.tesla.core.ui.Browser;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

public class RecordedEvent {
	public final int type;
	public final Widget widget;
	public final Event event;
	private final SWTUIPlayer player;

	public RecordedEvent(SWTUIPlayer player, Event event, int type, Widget widget) {
		this.player = player;
		this.event = event;
		this.type = type;
		this.widget = widget;
	}

	public String toString() {
		Field[] fields = SWT.class.getDeclaredFields();
		String opName = null;
		for (Field field : fields) {
			if ((field.getModifiers() & Modifier.STATIC) != 0
					&& field.getType().getName().equals("int")) {
				try {
					Integer value = (Integer) field.get(null);
					if (value.intValue() == type) {
						opName = field.getName();
						break;
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		String t = "" + type;
		if (opName != null) {
			t = opName + "(" + type + ")";
		}
		String text = "";

		if (!(/* widget instanceof StyledText || */ widget instanceof Browser)) {
			text = player.wrap(widget).getText();
		}

		if (text != null && text.length() > 1024) {
			text = text.substring(0, 1024);
		}
		return widget != null ? (widget.getClass().getSimpleName() + "("
				+ text + ") event:" + t) : "Null";
	}
}