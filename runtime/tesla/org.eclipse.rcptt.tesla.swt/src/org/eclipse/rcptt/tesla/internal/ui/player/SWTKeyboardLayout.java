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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.SWT;

public class SWTKeyboardLayout {
    private final Map<Character, KeyStroke> keyStrokes = new HashMap<Character, KeyStroke>();

    private SWTKeyboardLayout() {
        initialiseDefaults();
    }

    private static SWTKeyboardLayout INSTANCE = null;

    public static SWTKeyboardLayout getKeyboardLayout() {
        if (INSTANCE == null) {
            INSTANCE = new SWTKeyboardLayout();
        }
        return INSTANCE;
    }

    /**
     * Returns the keystroke for typing the specified character.
     * <p>
     * E.g. 'T' will correspond to SHIFT+T. 't' will correspond to 'T'. '!' will
     * correspond to SHIFT+1 on the US keyboard.
     * </p>
     * 
     * @param ch
     *            a character.
     * @return the keystroke applicable corresponding to the character.
     */
    public KeyStroke keyStrokeFor(char ch) {
        KeyStroke keyStroke = keyStrokes.get(ch);
        if (keyStroke != null) {
            return keyStroke;
        }
        return KeyStroke.getInstance(ch);
    }

    private void initialiseDefaults() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            keyStrokes.put(ch, KeyStroke.getInstance(SWT.SHIFT, Character.toLowerCase(ch)));
        }

        keyStrokes.put('~', KeyStroke.getInstance(SWT.SHIFT, '`'));
        keyStrokes.put('!', KeyStroke.getInstance(SWT.SHIFT, '1'));
        keyStrokes.put('@', KeyStroke.getInstance(SWT.SHIFT, '2'));
        keyStrokes.put('#', KeyStroke.getInstance(SWT.SHIFT, '3'));
        keyStrokes.put('$', KeyStroke.getInstance(SWT.SHIFT, '4'));
        keyStrokes.put('%', KeyStroke.getInstance(SWT.SHIFT, '5'));
        keyStrokes.put('^', KeyStroke.getInstance(SWT.SHIFT, '6'));
        keyStrokes.put('&', KeyStroke.getInstance(SWT.SHIFT, '7'));
        keyStrokes.put('*', KeyStroke.getInstance(SWT.SHIFT, '8'));
        keyStrokes.put('(', KeyStroke.getInstance(SWT.SHIFT, '9'));
        keyStrokes.put(')', KeyStroke.getInstance(SWT.SHIFT, '0'));
        keyStrokes.put('_', KeyStroke.getInstance(SWT.SHIFT, '-'));
        keyStrokes.put('+', KeyStroke.getInstance(SWT.SHIFT, '='));
        keyStrokes.put('{', KeyStroke.getInstance(SWT.SHIFT, '['));
        keyStrokes.put('}', KeyStroke.getInstance(SWT.SHIFT, ']'));
        keyStrokes.put('|', KeyStroke.getInstance(SWT.SHIFT, '\\'));
        keyStrokes.put(':', KeyStroke.getInstance(SWT.SHIFT, ';'));
        keyStrokes.put('"', KeyStroke.getInstance(SWT.SHIFT, '\''));
        keyStrokes.put('<', KeyStroke.getInstance(SWT.SHIFT, ','));
        keyStrokes.put('>', KeyStroke.getInstance(SWT.SHIFT, '.'));
        keyStrokes.put('?', KeyStroke.getInstance(SWT.SHIFT, '/'));
    }
}
