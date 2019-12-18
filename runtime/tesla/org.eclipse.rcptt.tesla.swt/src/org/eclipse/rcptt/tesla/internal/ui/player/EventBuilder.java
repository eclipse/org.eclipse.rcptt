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
package org.eclipse.rcptt.tesla.internal.ui.player;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

public class EventBuilder {

	private Event e;

	public EventBuilder(int type) {
		e = new Event();
		e.type = type;
	}

	public EventBuilder(Event event) {
		e = event;
	}

	private static int lastStamp = -1;

	public void send(Widget widget) {
		e.widget = widget;

		if (e.time == 0) {
			e.time = (int) System.currentTimeMillis();
		}
		if (e.time == lastStamp) {
			e.time++;
		}
		lastStamp = e.time;
		e.widget.notifyListeners(e.type, e);
	}

	public EventBuilder button(int button) {
		e.button = button;
		return this;
	}

	public EventBuilder x(int x) {
		e.x = x;
		return this;
	}

	public EventBuilder y(int y) {
		e.y = y;
		return this;
	}

	public EventBuilder xy(int x, int y) {
		e.x = x;
		e.y = y;
		return this;
	}

	public EventBuilder xy(Point point) {
		e.x = point.x;
		e.y = point.y;
		return this;
	}

	public EventBuilder widget(Widget widget) {
		e.widget = widget;
		return this;
	}

	public EventBuilder item(Widget item) {
		e.item = item;
		return this;
	}

	public EventBuilder type(int type) {
		e.type = type;
		return this;
	}

	public EventBuilder stateMask(int stateMask) {
		e.stateMask = stateMask;
		return this;
	}

	public EventBuilder detail(int detail) {
		e.detail = detail;
		return this;
	}

	public EventBuilder doit(boolean doit) {
		e.doit = doit;
		return this;
	}

	public EventBuilder data(Object data) {
		e.data = data;
		return this;
	}
}
