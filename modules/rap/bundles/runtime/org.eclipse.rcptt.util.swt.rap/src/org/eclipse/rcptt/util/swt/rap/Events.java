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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.util.KeysAndButtons;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;

public class Events {
	public static final int DEFAULT_BUTTON = 1;
	public static final int NO_BUTTON = 0;
	public static final int EMPTY_MASK = 0;
	public static final int SINGLE_COUNT = 1;
	public static final int ZERO_COUNT = 0;

	public static Event[] createDoubleClick() {
		return createDoubleClick(0, 0);
	}

	public static Event[] createDoubleClick(Point point) {
		return createDoubleClick(point.x, point.y);
	}

	public static Event[] createDoubleClick(int x, int y) {
		return createDoubleClick(DEFAULT_BUTTON, EMPTY_MASK, x, y);
	}

	public static Event[] createDoubleClick(int button, int mask, int x, int y) {
		List<Event> result = new ArrayList<Event>();
//		result.add(createActivate());
//		result.add(createFocusIn());
		result.add(createMouseEnter(mask, x, y));

		result.addAll(modifiersDown(mask));

		result.add(createMouseDown(button, SINGLE_COUNT, mask, x, y));
		result.add(createMouseUp(button, SINGLE_COUNT, mask, x, y));
		result.add(createMouseDown(button, 2, mask, x, y));
		result.add(createMouseDoubleClick(button, mask, x, y));
		result.add(createMouseUp(button, 2, mask, x, y));

		result.addAll(modifiersDown(mask));

		result.add(createSelection(true));
//		result.add(createMouseExit(mask, x, y));
//		result.add(createFocusOut());
//		result.add(createDeactivate());
		return result.toArray(new Event[result.size()]);
	}

	public static List<Event> modifiersUp(int stateMask) {
		int currentMask = stateMask;
		List<Event> result = new ArrayList<Event>();
		stateMask = SWT.MODIFIER_MASK & stateMask;
		for (int modifier : KeysAndButtons.getReverseModifiers()) {
			if ((stateMask & modifier) == 0) {
				continue;
			}
			Event event = new Event();
			event.type = SWT.KeyUp;
			event.keyCode = modifier;
			event.stateMask = currentMask;
			currentMask ^= modifier;
			result.add(event);
		}
		return result;
	}

	public static List<Event> modifiersDown(int stateMask) {
		List<Event> result = new ArrayList<Event>();
		stateMask = SWT.MODIFIER_MASK & stateMask;

		int currentMask = 0;
		for (int modifier : KeysAndButtons.getOrderedModifiers()) {
			if ((stateMask & modifier) == 0) {
				continue;
			}
			Event event = new Event();
			event.type = SWT.KeyDown;
			event.keyCode = modifier;
			event.stateMask = currentMask;
			currentMask |= modifier;
			result.add(event);
		}

		return result;
	}

	public static Event[] createClick(Point point) {
		return createClick(point.x, point.y);
	}

	public static Event[] createClick(int x, int y) {
		return createClick(DEFAULT_BUTTON, EMPTY_MASK, x, y);
	}

	public static Event[] createClick(int button, int mask, int x, int y) {
		List<Event> result = new ArrayList<Event>();
//		result.add(createActivate());
//		result.add(createFocusIn());
		result.add(createMouseEnter(mask, x, y));

		result.addAll(modifiersDown(mask));

		result.add(createMouseDown(button, SINGLE_COUNT, mask, x, y));
		result.add(createMouseUp(button, SINGLE_COUNT, mask, x, y));

		result.addAll(modifiersUp(mask));

//		result.add(createMouseExit(mask, x, y));
//		result.add(createFocusOut());
//		result.add(createDeactivate());

		return result.toArray(new Event[result.size()]);
	}

	public static Event createActivate() {
		return createSimple(SWT.Activate);
	}

	public static Event createDeactivate() {
		return createSimple(SWT.Deactivate);
	}

	public static Event createFocusIn() {
		return createSimple(SWT.FocusIn);
	}

	public static Event createFocusOut() {
		return createSimple(SWT.FocusOut);
	}

	public static Event createSelection() {
		return createSelection(false);
	}

	public static Event createSelection(boolean isDefault) {
		return createSimple(isDefault ? SWT.DefaultSelection : SWT.Selection);
	}

	public static Event createSimple(int type) {
		Event event = new Event();
		event.type = type;
		return event;
	}

	public static Event createMouseEnter(int mask, int x, int y) {
		return createMouseEvent(SWT.MouseEnter, NO_BUTTON, ZERO_COUNT, mask, x,
				y);
	}

	public static Event createMouseMove(int mask, int x, int y) {
		return createMouseEvent(SWT.MouseMove, NO_BUTTON, ZERO_COUNT, mask, x,
				y);
	}

	public static Event createMouseExit(int mask, int x, int y) {
		return createMouseEvent(SWT.MouseExit, NO_BUTTON, ZERO_COUNT, mask, x,
				y);
	}

	public static Event createMouseDown(int button, int count, int mask, int x,
			int y) {
		return createMouseEvent(SWT.MouseDown, button, count, mask, x, y);
	}

	public static Event createMouseDown() {
		return createMouseDown(new Point(0, 0));
	}

	public static Event createMouseDown(Point point) {
		return createMouseDown(DEFAULT_BUTTON, SINGLE_COUNT, EMPTY_MASK,
				point.x, point.y);
	}

	public static Event createMouseUp() {
		return createMouseUp(new Point(0, 0));
	}

	public static Event createMouseUp(Point point) {
		return createMouseUp(DEFAULT_BUTTON, SINGLE_COUNT, EMPTY_MASK, point.x,
				point.y);
	}

	/**
	 * Automatically adds button mask to specified mask
	 */
	public static Event createMouseUp(int button, int count, int mask, int x,
			int y) {
		return createMouseEvent(SWT.MouseUp, button, count, mask
				| KeysAndButtons.getButtonMaskSafe(button), x, y);
	}

	public static Event createMouseDoubleClick(int button, int mask, int x,
			int y) {
		return createMouseEvent(SWT.MouseDoubleClick, button, 2, mask, x, y);
	}

	public static Event createMouseEvent(int type, int button, int count,
			int mask, int x, int y) {
		Event event = new Event();
		event.type = type;
		event.button = button;
		event.count = count;
		event.stateMask = mask;
		event.x = x;
		event.y = y;
		return event;

	}

	public static Point pointFrom(Event event) {
		return new Point(event.x, event.y);
	}

}
