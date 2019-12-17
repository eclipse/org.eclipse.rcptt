/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.aspects;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public interface GTK {
	/* GTK signals data */
	static final int ACTIVATE = 1;
	static final int BUTTON_PRESS_EVENT = 2;
	static final int BUTTON_PRESS_EVENT_INVERSE = 3;
	static final int BUTTON_RELEASE_EVENT = 4;
	static final int BUTTON_RELEASE_EVENT_INVERSE = 5;
	static final int CHANGED = 6;
	static final int CHANGE_VALUE = 7;
	static final int CLICKED = 8;
	static final int COMMIT = 9;
	static final int CONFIGURE_EVENT = 10;
	static final int DELETE_EVENT = 11;
	static final int DELETE_RANGE = 12;
	static final int DELETE_TEXT = 13;
	static final int ENTER_NOTIFY_EVENT = 14;
	static final int EVENT = 15;
	static final int EVENT_AFTER = 16;
	static final int EXPAND_COLLAPSE_CURSOR_ROW = 17;
	static final int EXPOSE_EVENT = 18;
	static final int EXPOSE_EVENT_INVERSE = 19;
	static final int FOCUS = 20;
	static final int FOCUS_IN_EVENT = 21;
	static final int FOCUS_OUT_EVENT = 22;
	static final int GRAB_FOCUS = 23;
	static final int HIDE = 24;
	static final int INPUT = 25;
	static final int INSERT_TEXT = 26;
	static final int KEY_PRESS_EVENT = 27;
	static final int KEY_RELEASE_EVENT = 28;
	static final int LEAVE_NOTIFY_EVENT = 29;
	static final int MAP = 30;
	static final int MAP_EVENT = 31;
	static final int MNEMONIC_ACTIVATE = 32;
	static final int MOTION_NOTIFY_EVENT = 33;
	static final int MOTION_NOTIFY_EVENT_INVERSE = 34;
	static final int MOVE_FOCUS = 35;
	static final int OUTPUT = 36;
	static final int POPULATE_POPUP = 37;
	static final int POPUP_MENU = 38;
	static final int PREEDIT_CHANGED = 39;
	static final int REALIZE = 40;
	static final int ROW_ACTIVATED = 41;
	static final int SCROLL_CHILD = 42;
	static final int SCROLL_EVENT = 43;
	static final int SELECT = 44;
	static final int SHOW = 45;
	static final int SHOW_HELP = 46;
	static final int SIZE_ALLOCATE = 47;
	static final int STYLE_SET = 48;
	static final int SWITCH_PAGE = 49;
	static final int TEST_COLLAPSE_ROW = 50;
	static final int TEST_EXPAND_ROW = 51;
	static final int TEXT_BUFFER_INSERT_TEXT = 52;
	static final int TOGGLED = 53;
	static final int UNMAP = 54;
	static final int UNMAP_EVENT = 55;
	static final int UNREALIZE = 56;
	static final int VALUE_CHANGED = 57;
	static final int VISIBILITY_NOTIFY_EVENT = 58;
	static final int WINDOW_STATE_EVENT = 59;
	static final int ACTIVATE_INVERSE = 60;
	static final int DAY_SELECTED = 61;
	static final int MONTH_CHANGED = 62;
	static final int STATUS_ICON_POPUP_MENU = 63;
	static final int ROW_INSERTED = 64;
	static final int ROW_DELETED = 65;
	static final int DAY_SELECTED_DOUBLE_CLICK = 66;
	static final int ICON_RELEASE = 67;
	static final int SELECTION_DONE = 68;
	static final int START_INTERACTIVE_SEARCH = 69;
	static final int LAST_SIGNAL = 70;

	public static class RecordedEvent {
		int type;

		public RecordedEvent(int type) {
			this.type = type;
		}

		@Override
		public String toString() {
			Field[] fields = GTK.class.getDeclaredFields();
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
			return "event:" + t;
		}
	}
}
