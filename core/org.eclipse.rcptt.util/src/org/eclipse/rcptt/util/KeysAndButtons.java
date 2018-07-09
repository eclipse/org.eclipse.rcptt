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
package org.eclipse.rcptt.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

public class KeysAndButtons {

	private static String POINT_ID = UtilPlugin.PLUGIN_ID + ".keysExtension"; //$NON-NLS-1$
	private static IKeysAndButtonExtension extension;

	public static final String BUTTON_LEFT = "Left";
	public static final String BUTTON_RIGHT = "Right";
	public static final String BUTTON_MIDDLE = "Middle";
	public static final String BUTTON_4 = "Button4";
	public static final String BUTTON_5 = "Button5";

	private static Map<Integer, String> MODIFIERS = null;
	private static int[] ORDERED_MODIFIERS = null;
	private static int[] REVERSE_MODIFIERS = null;
	private static Map<Integer, String> BUTTON_NAMES_BY_MASK = null;
	private static Map<String, Integer> BUTTON_NUMBERS = null;
	private static int[] BUTTON_MASKS_BY_NUMBER = null;

	public static int[] getOrderedModifiers() {
		if (ORDERED_MODIFIERS == null) {
			IKeysAndButtonExtension extension = getExtension();
			ORDERED_MODIFIERS = new int[] { extension.getMod1(), extension.getMod2(), extension.getMod3(),
					extension.getMod4() };
		}

		return ORDERED_MODIFIERS;
	}

	public static int[] getReverseModifiers() {
		if (REVERSE_MODIFIERS == null) {
			int[] ordered = getOrderedModifiers();
			int size = ordered.length - 1;

			REVERSE_MODIFIERS = new int[ordered.length];
			for (int i = size; i >= 0; i--) {
				REVERSE_MODIFIERS[size - i] = ordered[i];
			}
		}

		return REVERSE_MODIFIERS;
	}

	public static Map<Integer, String> getModifiers() {
		if (MODIFIERS == null) {
			final IKeysAndButtonExtension extension = getExtension();
			final Map<Integer, String> current = new LinkedHashMap<Integer, String>();
			current.put(extension.getMod1(), "M1"); //$NON-NLS-1$
			current.put(extension.getMod2(), "M2"); //$NON-NLS-1$
			current.put(extension.getMod3(), "M3"); //$NON-NLS-1$
			current.put(extension.getMod4(), "M4"); //$NON-NLS-1$

			MODIFIERS = Collections.unmodifiableMap(current);
		}
		return MODIFIERS;
	}

	private static Map<Integer, String> getButtonNamesByMask() {
		if (BUTTON_NAMES_BY_MASK == null) {
			final IKeysAndButtonExtension extension = getExtension();
			final Map<Integer, String> current = new LinkedHashMap<Integer, String>();

			current.put(extension.getButton1(), BUTTON_LEFT);
			current.put(extension.getButton2(), BUTTON_MIDDLE);
			current.put(extension.getButton3(), BUTTON_RIGHT);
			current.put(extension.getButton4(), BUTTON_4);
			current.put(extension.getButton5(), BUTTON_5);
			BUTTON_NAMES_BY_MASK = Collections.unmodifiableMap(current);
		}

		return BUTTON_NAMES_BY_MASK;
	}

	private static final Map<String, Integer> STATES_BY_NAME = new HashMap<String, Integer>();
	static {
		for (Entry<Integer, String> entry : getModifiers().entrySet()) {
			STATES_BY_NAME.put(entry.getValue(), entry.getKey());
		}
		for (Entry<Integer, String> entry : getButtonNamesByMask().entrySet()) {
			STATES_BY_NAME.put(entry.getValue(), entry.getKey());
		}
	}
	private static final String[] BUTTON_NAMES = { null, BUTTON_LEFT,
			BUTTON_MIDDLE, BUTTON_RIGHT, BUTTON_4, BUTTON_5 };

	private static Map<String, Integer> getButtonNumbers() {
		if (BUTTON_NUMBERS == null) {
			final Map<String, Integer> current = new HashMap<String, Integer>();
			current.put(BUTTON_LEFT, 1);
			current.put(BUTTON_MIDDLE, 2);
			current.put(BUTTON_RIGHT, 3);
			current.put(BUTTON_4, 4);
			current.put(BUTTON_5, 5);

			BUTTON_NUMBERS = Collections.unmodifiableMap(current);
		}
		return BUTTON_NUMBERS;
	}

	private static int[] getButtonMasksByNumber() {
		if (BUTTON_MASKS_BY_NUMBER == null) {
			final IKeysAndButtonExtension extension = getExtension();
			BUTTON_MASKS_BY_NUMBER = new int[] { 0, extension.getButton1(), extension.getButton2(),
					extension.getButton3(), extension.getButton4(), extension.getButton5() };
		}

		return BUTTON_MASKS_BY_NUMBER;
	}

	public static int getButtonMask(int button) throws CoreException {
		if (button <= 0 || button >= getButtonMasksByNumber().length) {
			throw new CoreException(new Status(IStatus.ERROR,
					UtilPlugin.PLUGIN_ID, String.format(
							"Cannot find button mast for button #%d", button)));
		}
		return getButtonMasksByNumber()[button];
	}

	public static int getButtonMaskSafe(int button) {
		if (button <= 0 || button >= getButtonMasksByNumber().length) {
			return 0;
		}
		return getButtonMasksByNumber()[button];
	}

	public static String getButtonName(int button) throws CoreException {
		if (button <= 0 || button >= BUTTON_NAMES.length) {
			throw new CoreException(new Status(IStatus.ERROR,
					UtilPlugin.PLUGIN_ID, String.format(
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
		if (!getButtonNumbers().containsKey(name)) {
			throw new CoreException(new Status(IStatus.ERROR,
					UtilPlugin.PLUGIN_ID, String.format(
							"Unknown button name '%s'", name)));
		}
		return getButtonNumbers().get(name);
	}

	public static String stateMaskToStr(int stateMask) {
		List<String> result = new ArrayList<String>();
		processMap(getModifiers(), stateMask, result);
		processMap(getButtonNamesByMask(), stateMask, result);
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

	private static IKeysAndButtonExtension getExtension() {
		if (extension == null) {
			IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(POINT_ID);
			if (elements.length < 1) {
				return null;
			}
			try {
				extension = (IKeysAndButtonExtension) elements[0].createExecutableExtension("class");//$NON-NLS-1$
			} catch (CoreException e) {
				UtilPlugin.log("Error while get key stroke extension.", e); //$NON-NLS-1$
			}
		}

		return extension;
	}

	public interface IKeysAndButtonExtension {
		int getMod1();

		int getMod2();

		int getMod3();

		int getMod4();

		int getButton1();

		int getButton2();

		int getButton3();

		int getButton4();

		int getButton5();
	}

}
