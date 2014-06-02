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
package org.eclipse.rcptt.util.swt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.SWT;

import org.eclipse.rcptt.util.StringUtils;
import org.eclipse.rcptt.util.swt.internal.SwtUtilPlugin;

public class KeysAndButtons {
	public static final String BUTTON_LEFT = "Left";
	public static final String BUTTON_RIGHT = "Right";
	public static final String BUTTON_MIDDLE = "Middle";
	public static final String BUTTON_4 = "Button4";
	public static final String BUTTON_5 = "Button5";
	public static final Map<Integer, String> MODIFIERS = new LinkedHashMap<Integer, String>();

	static {
		MODIFIERS.put(SWT.MOD1, "M1");
		MODIFIERS.put(SWT.MOD2, "M2");
		MODIFIERS.put(SWT.MOD3, "M3");
		MODIFIERS.put(SWT.MOD4, "M4");
	};

	public static final int[] ORDERED_MODIFIERS = { SWT.MOD1, SWT.MOD2,
			SWT.MOD3, SWT.MOD4 };
	public static final int[] REVERSE_MODIFIERS = { SWT.MOD4, SWT.MOD3,
			SWT.MOD2, SWT.MOD1 };

	public static final Map<Integer, String> BUTTON_NAMES_BY_MASK = new LinkedHashMap<Integer, String>();
	static {
		BUTTON_NAMES_BY_MASK.put(SWT.BUTTON1, BUTTON_LEFT);
		BUTTON_NAMES_BY_MASK.put(SWT.BUTTON2, BUTTON_MIDDLE);
		BUTTON_NAMES_BY_MASK.put(SWT.BUTTON3, BUTTON_RIGHT);
		BUTTON_NAMES_BY_MASK.put(SWT.BUTTON4, BUTTON_4);
		BUTTON_NAMES_BY_MASK.put(SWT.BUTTON5, BUTTON_5);
	}

	private static final Map<String, Integer> STATES_BY_NAME = new HashMap<String, Integer>();
	static {
		for (Entry<Integer, String> entry : MODIFIERS.entrySet()) {
			STATES_BY_NAME.put(entry.getValue(), entry.getKey());
		}
		for (Entry<Integer, String> entry : BUTTON_NAMES_BY_MASK.entrySet()) {
			STATES_BY_NAME.put(entry.getValue(), entry.getKey());
		}
	}

	private static final Map<String, Integer> BUTTON_NUMBERS = new HashMap<String, Integer>();
	static {
		BUTTON_NUMBERS.put(BUTTON_LEFT, 1);
		BUTTON_NUMBERS.put(BUTTON_MIDDLE, 2);
		BUTTON_NUMBERS.put(BUTTON_RIGHT, 3);
		BUTTON_NUMBERS.put(BUTTON_4, 4);
		BUTTON_NUMBERS.put(BUTTON_5, 5);
	}

	private static final String[] BUTTON_NAMES = { null, BUTTON_LEFT,
			BUTTON_MIDDLE, BUTTON_RIGHT, BUTTON_4, BUTTON_5 };

	private static final int[] BUTTON_MASKS_BY_NUMBER = { 0, SWT.BUTTON1,
			SWT.BUTTON2, SWT.BUTTON3, SWT.BUTTON4, SWT.BUTTON5 };

	public static int getButtonMask(int button) throws CoreException {
		if (button <= 0 || button >= BUTTON_MASKS_BY_NUMBER.length) {
			throw new CoreException(new Status(IStatus.ERROR,
					SwtUtilPlugin.PLUGIN_ID, String.format(
							"Cannot find button mast for button #%d", button)));
		}
		return BUTTON_MASKS_BY_NUMBER[button];
	}

	public static int getButtonMaskSafe(int button) {
		if (button <= 0 || button >= BUTTON_MASKS_BY_NUMBER.length) {
			return 0;
		}
		return BUTTON_MASKS_BY_NUMBER[button];
	}

	public static String getButtonName(int button) throws CoreException {
		if (button <= 0 || button >= BUTTON_NAMES.length) {
			throw new CoreException(new Status(IStatus.ERROR,
					SwtUtilPlugin.PLUGIN_ID, String.format(
							"Cannot find button name for button #%d", button)));
		}
		return BUTTON_NAMES[button];
	}

	public static String getButtonNameSafe(int button, String def) {
		if (button <= 0 || button >= BUTTON_NAMES.length) {
			return def;
		}
		return BUTTON_NAMES[button];
	}

	public static String getButtonNameSafe(int button) {
		return getButtonNameSafe(button, BUTTON_LEFT);
	}

	public static int getButtonNumber(String name) throws CoreException {
		if (name != null && name.length() > 0) {
			// format name to pascal case
			name = String.format("%c%s", name.charAt(0), name.substring(1)
					.toLowerCase());
		}
		if (!BUTTON_NUMBERS.containsKey(name)) {
			throw new CoreException(new Status(IStatus.ERROR,
					SwtUtilPlugin.PLUGIN_ID, String.format(
							"Unknown button name '%s'", name)));
		}
		return BUTTON_NUMBERS.get(name);
	}

	public static String stateMaskToStr(int stateMask) {
		List<String> result = new ArrayList<String>();
		processMap(MODIFIERS, stateMask, result);
		processMap(BUTTON_NAMES_BY_MASK, stateMask, result);
		return StringUtils.join('+', result);
	}

	/**
	 * Returns string like
	 * 
	 * @param str
	 * @param safe
	 * @return
	 * @throws CoreException
	 */
	public static int stateMaskFromStr(String str) throws CoreException {
		if (str == null || str.length() == 0) {
			return 0;
		}
		String errorMessage = validateStateStr(str);
		if (errorMessage != null) {
			throw new CoreException(new Status(IStatus.ERROR, "org.eclipse.ui",
					errorMessage));
		}
		int result = 0;
		for (String entry : StringUtils.split('+', str)) {
			result |= STATES_BY_NAME.get(entry);
		}
		return result;
	}

	public static String validateStateStr(String state) {
		if (state == null || state.length() == 0) {
			return null;
		}
		for (String entry : StringUtils.split('+', state)) {
			if (!STATES_BY_NAME.containsKey(entry)) {
				return String.format(
						"Cannot parse state '%s': unknown entry '%s'", state,
						entry);
			}
		}
		return null;
	}

	private static void processMap(Map<Integer, String> map, int stateMask,
			List<String> acc) {
		for (Entry<Integer, String> entry : map.entrySet()) {
			if ((stateMask & entry.getKey()) != 0) {
				acc.add(entry.getValue());
			}
		}
	}

}
