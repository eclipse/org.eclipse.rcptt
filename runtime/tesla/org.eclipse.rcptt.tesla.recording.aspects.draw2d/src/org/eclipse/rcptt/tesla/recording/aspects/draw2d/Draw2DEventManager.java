/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.aspects.draw2d;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.swt.events.MouseEvent;

public final class Draw2DEventManager {
	private Draw2DEventManager() {
	}

	private static Set<IDraw2DEventListener> listeners = new HashSet<IDraw2DEventListener>();

	public static void addListener(IDraw2DEventListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(IDraw2DEventListener listener) {
		listeners.remove(listener);
	}

	public static void mousePressed(SWTEventDispatcher disp, MouseEvent event) {
		for (IDraw2DEventListener listener : listeners) {
			listener.mousePressed(disp, event);
		}
	}

	public static void mouseReleased(SWTEventDispatcher disp, MouseEvent event) {
		for (IDraw2DEventListener listener : listeners) {
			listener.mouseReleased(disp, event);
		}
	}

	public static void mouseEntered(SWTEventDispatcher disp, MouseEvent event) {
		for (IDraw2DEventListener listener : listeners) {
			listener.mouseEntered(disp, event);
		}
	}

	public static void mouseExited(SWTEventDispatcher disp, MouseEvent event) {
		for (IDraw2DEventListener listener : listeners) {
			listener.mouseExited(disp, event);
		}
	}

	public static void mouseHover(SWTEventDispatcher disp, MouseEvent event) {
		for (IDraw2DEventListener listener : listeners) {
			listener.mouseHover(disp, event);
		}
	}

	public static void mouseDoubleClick(SWTEventDispatcher disp,
			MouseEvent event) {
		for (IDraw2DEventListener listener : listeners) {
			listener.mouseDoubleClick(disp, event);
		}
	}

	public static void mouseMoved(SWTEventDispatcher disp, MouseEvent event) {
		for (IDraw2DEventListener listener : listeners) {
			listener.mouseMoved(disp, event);
		}
	}
}
