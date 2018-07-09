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
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.jface.TeslaCellEditorManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.ui.SWTTeslaActivator;
import org.eclipse.rcptt.util.ShellUtilsProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

public class SWTEvents {
	private Display display;

	public SWTEvents(Display display) {
		this.display = display;
	}

	public Event createEvent(SWTUIElement wrap) {
		return createEvent(PlayerWrapUtils.unwrapWidget(wrap));
	}

	public Event createEvent(Widget w) {
		Event e = new Event();
		e.widget = w;
		e.display = display;
		e.time = (int) System.currentTimeMillis();
		return e;
	}

	public Event createMouseEvent(Display display, Widget widget, int x, int y,
			int button, int stateMask, int count) {
		Event event = new Event();
		event.time = (int) System.currentTimeMillis();
		event.widget = widget;
		event.display = display;
		event.x = x;
		event.y = y;
		event.button = button;
		event.stateMask = stateMask;
		event.count = count;
		return event;
	}

	public Event sendEvent(final SWTUIElement w, final int event) {
		if (PlayerWrapUtils.unwrapWidget(w).isDisposed()) {
			return null;
		}
		try {
			Event e = createEvent(w);
			sendEventRaw(event, e);
			return e;
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
		return null;
	}

	private static int lastStamp = -1;

	public void sendEventRaw(final int event, Event e) {
		// Update timestamp if last was the same.
		if (e.time == 0) {
			e.time = (int) System.currentTimeMillis();
		}
		if (e.time == lastStamp) {
			e.time++;
		}
		lastStamp = e.time;
		e.widget.notifyListeners(event, e);
	}

	public Event sendEvent(final SWTUIElement w, final int event, int x, int y) {
		if (PlayerWrapUtils.unwrapWidget(w).isDisposed()) {
			return null;
		}
		try {
			Event e = createEvent(w);
			e.x = x;
			e.y = y;
			e.type = event;
			sendEventRaw(event, e);
			return e;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Event sendEvent(final SWTUIElement w, final int event, Point point,
			int button) {
		return sendEvent(w, event, point.x, point.y, button);
	}

	public Event sendEvent(final SWTUIElement w, final int event, int x, int y,
			int button) {
		if (PlayerWrapUtils.unwrapWidget(w).isDisposed()) {
			return null;
		}
		try {
			Event e = createEvent(w);
			e.x = x;
			e.y = y;
			e.button = button;
			e.type = event;
			sendEventRaw(event, e);
			return e;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Event sendEvent(final Widget w, final int event, Point point,
			int button) {
		return sendEvent(w, event, point.x, point.y, button);
	}

	public Event sendEvent(final Widget w, final int event, int x, int y,
			int button) {
		try {
			Event e = createEvent(w);
			e.x = x;
			e.y = y;
			e.button = button;
			e.type = event;
			sendEventRaw(event, e);
			return e;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Event sendEvent(final Widget w, final int event, int x, int y,
			int button, int mask) {
		try {
			Event e = createEvent(w);
			e.x = x;
			e.y = y;
			e.type = event;
			e.button = button;
			e.stateMask = mask;
			sendEventRaw(event, e);
			return e;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Event sendEvent(final SWTUIElement w, Event event) {
		Widget unwrapWidget = PlayerWrapUtils.unwrapWidget(w);
		if (unwrapWidget.isDisposed()) {
			return null;
		}
		try {
			event.widget = unwrapWidget;
			sendEventRaw(event.type, event);
			return event;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Event sendEvent(final Widget w, Event event) {
		if (w.isDisposed()) {
			return null;
		}
		try {
			event.widget = w;
			sendEventRaw(event.type, event);
			return event;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public void sendAll(final Widget w, final Event[] events) {
		for (Event event : events) {
			sendEvent(w, event);
		}
	}

	public Event sendEvent(final Widget w, final int event) {
		try {
			Event e = createEvent(w);
			sendEventRaw(event, e);
			return e;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Event sendEvent(final SWTUIElement w, final Widget item,
			final int event) {
		try {
			Event e = createEvent(w);
			e.item = item;
			sendEventRaw(event, e);
			return e;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Event sendEvent(final SWTUIElement w, final Widget item,
			final int event, final int button, final int x, final int y) {
		try {
			Event e = createEvent(w);
			e.item = item;
			e.button = button;
			e.x = x;
			e.y = y;
			e.type = event;
			sendEventRaw(event, e);
			return e;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Event sendEvent(final Widget w, final Widget item, final int event) {
		try {
			Event e = createEvent(w);
			e.item = item;
			sendEventRaw(event, e);
			return e;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Event sendEvent(final Widget w, final Widget item, final Event event) {
		if (w.isDisposed() || (item != null && item.isDisposed())) {
			return null;
		}
		try {
			event.widget = w;
			event.item = item;
			sendEventRaw(event.type, event);
			return event;
		} catch (Exception e) {
			TeslaCore.log(e);
			return null;
		}
	}

	public Event sendEvent(final Widget w, final Widget item, final int event,
			int detail) {
		try {
			Event e = createEvent(w);
			e.item = item;
			e.detail = detail;
			sendEventRaw(event, e);
			return e;
		} catch (SecurityException e) {
			TeslaCore.log(e);
		} catch (IllegalArgumentException e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public void sendAll(final Widget w, final Widget item, final Event[] events) {
		for (Event event : events) {
			sendEvent(w, item, event);
		}
	}

	public static Event clone(Event other) {
		Event result = new Event();
		for (Field field : Event.class.getDeclaredFields()) {
			if ((field.getModifiers() & Modifier.PUBLIC) != 0) {
				try {
					field.set(result, field.get(other));
				} catch (Exception e) {
					SWTTeslaActivator.log(e);
				}
			}
		}
		return result;
	}

	private Control lastFocusControl = null;

	// private Control lastForceFocusControl = null;

	public synchronized void sendFocus(Widget widget) {
		if (widget.isDisposed()) {
			return;
		}
		if (!(widget instanceof Control)) {
			return;
		}
		Control ctrl = (Control) widget;

		boolean sendUnfocus = TeslaCellEditorManager.getInstance().getEditors().length > 0;

		if (sendUnfocus) {
			if (ctrl != lastFocusControl) {
				// new focus control
				// send focusOut for real last focused control
				if (ctrl == lastFocusControl) {
					return;
				}
				if (lastFocusControl != null && !lastFocusControl.isDisposed()) {
					if (lastFocusControl.isFocusControl()) {
						sendEvent(lastFocusControl, SWT.FocusOut);
						if (!lastFocusControl.isDisposed()) {
							sendEvent(lastFocusControl, SWT.Deactivate);
						}
						if (!lastFocusControl.isDisposed()) {
							sendEvent(lastFocusControl, SWT.MouseExit);
						}
					}
				}
				lastFocusControl = ctrl;
				if (!ctrl.isFocusControl()) {
					ctrl.setFocus();
					sendEvent(lastFocusControl, SWT.MouseEnter);
					sendEvent(lastFocusControl, SWT.MouseMove);
					sendEvent(lastFocusControl, SWT.Activate);
					sendEvent(lastFocusControl, SWT.FocusIn);
				}
			}
		} else {
			// ctrl.getShell().forceActive();
			if (!ctrl.isFocusControl()) {
				try {
					ShellUtilsProvider.getShellUtils().forceActive(ctrl.getShell());
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
				ctrl.setFocus();
				ctrl.forceFocus();
				sendEvent(ctrl, SWT.MouseEnter);
				sendEvent(ctrl, SWT.MouseMove);
				sendEvent(ctrl, SWT.Activate);
				sendEvent(ctrl, SWT.FocusIn);
			}
			lastFocusControl = ctrl;
		}
	}

	public synchronized void sendUnfocus(Widget widget) {
		if (widget.isDisposed()) {
			return;
		}
		if (!(widget instanceof Control)) {
			return;
		}
		Control ctrl = (Control) widget;
		boolean sendUnfocus = TeslaCellEditorManager.getInstance().getEditors().length > 0;

		if (!sendUnfocus) {
			if (ctrl.isFocusControl() || widget == lastFocusControl) {
				if (!ctrl.isDisposed()) {
					sendEvent(ctrl, SWT.FocusOut);
				}
				if (!ctrl.isDisposed()) {
					sendEvent(ctrl, SWT.Deactivate);
				}
				if (!ctrl.isDisposed()) {
					sendEvent(ctrl, SWT.MouseMove);
				}
				if (!ctrl.isDisposed()) {
					sendEvent(ctrl, SWT.MouseExit);
				}
			}
			lastFocusControl = null;
			TeslaEventManager.getManager().setForceFocusControl(null);
		}
	}
}
