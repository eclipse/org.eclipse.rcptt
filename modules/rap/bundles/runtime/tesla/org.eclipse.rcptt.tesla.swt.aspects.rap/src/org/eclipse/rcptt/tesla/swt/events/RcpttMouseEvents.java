/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2019 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * https://www.eclipse.org/legal/epl-v20.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.events;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;

/**
 * RAP does not support mouse track events
 * (http://eclipse.org/rap/developers-guide/devguide.php?topic=key-and-mouse-events.html&version=2.1)
 * This class simulates such events for SWTAssertManager to show assertion
 * selections on mouse move events.
 *
 * Since 2.2+ RAP supports ClientScripting
 * (http://wiki.eclipse.org/RAP/ClientScripting). It's similar in concept to
 * org.eclipse.swt.widgets.Listener, but can only be executed on the client
 * side. With ClientScripting we can handle mouseEnter/mouseExit events on
 * client side and send notifications on server via js. For example, var
 * remoteObject = rap.getRemoteObject(this)), see more examples on rap js API
 * page.
 *
 * Since RAP2.2 with class should be removed
 *
 * @author zapletnev
 * @see org.eclipse.swt.events.MouseTrackListener
 * @see org.eclipse.swt.widgets.Listener
 * @see com.xored.tesla.recording.core.swt.SWTAssertManager
 */

public class RcpttMouseEvents {

	public static final int MouseEnter = 6;
	public static final int MouseExit = 7;

	private static Point cursor;
	private static Widget underMouse;

	public static synchronized void updateWidgetUnderMouse() {
		Display currentDisplay = Display.getCurrent();
		if (currentDisplay == null) {
			return;
		}

		Point newCursor = currentDisplay.getCursorLocation();
		if (newCursor == null) {
			setCursor(null);
			notifyMouseExit();
		} else if (newCursor.equals(cursor)) {
			return;
		} else {
			setCursor(newCursor);
		}

		Shell activeShell = currentDisplay.getActiveShell();
		if (activeShell == null) {
			return;
		}

		Point p = activeShell.toControl(cursor);
		WidgetInfo newUnderMouse = getChild(activeShell, p.x, p.y, true);
		if (newUnderMouse == null || newUnderMouse.widget == null) {
			notifyMouseExit();
		} else if (newUnderMouse.widget.equals(underMouse) && !(underMouse instanceof ToolBar)) {
			return;
		} else {
			notifyMouseExit();
			underMouse = newUnderMouse.widget;
			notifyMouseEnter(newUnderMouse.x, newUnderMouse.y);
		}
	}

	public static void reset() {
		underMouse = null;
		cursor = null;
	}

	private static void setCursor(Point newCursor) {
		cursor = newCursor;
	}

	private static void notifyMouseExit() {
		if (underMouse != null && !underMouse.isDisposed()) {
			underMouse.notifyListeners(MouseEnter, new Event());
		}
		underMouse = null;
	}

	private static void notifyMouseEnter(int x, int y) {
		if (!underMouse.isDisposed()) {
			Event event = new Event();
			event.x = x;
			event.y = y;
			underMouse.notifyListeners(MouseEnter, event);
		} else {
			underMouse = null;
		}
	}

	private static WidgetInfo getChild(Widget parent, int x, int y, boolean root) {
		if (!(parent instanceof Control)) {
			return info(parent);
		}
		Control control = (Control) parent;

		int relX = root ? x : x - control.getBounds().x;
		int relY = root ? y : y - control.getBounds().y;

		if (!(parent instanceof Composite)) {
			return info(parent);
		}
		Composite c = (Composite) parent;
		if (c instanceof Tree) {
			return info(((Tree) c).getItem(new Point(relX, relY)), relX, relY);
		} else if (c instanceof Table) {
			return info(((Table) c).getItem(new Point(relX, relY)), relX, relY);
		} else if (c instanceof ToolBar) {
			return info(((ToolBar) c).getItem(new Point(relX, relY)));
		}

		for (Control ctrl : c.getChildren()) {
			if (ctrl.getBounds().contains(relX, relY) && ctrl.isVisible()) {
				return getChild(ctrl, relX, relY, false);
			}
		}
		return info(parent);
	}

	private static WidgetInfo info(Widget w, int x, int y) {
		return new WidgetInfo(w, x, y);
	}

	private static WidgetInfo info(Widget w) {
		if (w instanceof Control) {
			Rectangle b = ((Control) w).getBounds();
			return new WidgetInfo(w, b.x, b.y);
		}
		return new WidgetInfo(w);
	}

	private static class WidgetInfo {
		public final Widget widget;
		public final int x;
		public final int y;

		public WidgetInfo(Widget w) {
			this(w, 0, 0);
		}

		public WidgetInfo(Widget w, int x, int y) {
			widget = w;
			this.x = x;
			this.y = y;
		}
	}
}
