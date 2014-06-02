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
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.bindings.keys.IKeyLookup;
import org.eclipse.jface.bindings.keys.KeyLookupFactory;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

public class SWTKeyboard {
    private static final Set<Integer> specialKeys = new HashSet<Integer>();

    static {
        /* function keys */
        specialKeys.add(SWT.F1);
        specialKeys.add(SWT.F2);
        specialKeys.add(SWT.F3);
        specialKeys.add(SWT.F4);
        specialKeys.add(SWT.F5);
        specialKeys.add(SWT.F6);
        specialKeys.add(SWT.F7);
        specialKeys.add(SWT.F8);
        specialKeys.add(SWT.F9);
        specialKeys.add(SWT.F10);
        specialKeys.add(SWT.F11);
        specialKeys.add(SWT.F12);

        specialKeys.add((int) SWT.DEL);

        /* direction and page navigation keys */
        specialKeys.add(SWT.HOME);
        specialKeys.add(SWT.END);
        specialKeys.add(SWT.PAGE_UP);
        specialKeys.add(SWT.PAGE_DOWN);
        specialKeys.add(SWT.ARROW_RIGHT);
        specialKeys.add(SWT.ARROW_DOWN);
        specialKeys.add(SWT.ARROW_LEFT);
        specialKeys.add(SWT.ARROW_UP);

        /* whitespace keys */
        specialKeys.add((int) SWT.BS);
        specialKeys.add((int) SWT.CR);
        specialKeys.add((int) SWT.DEL);
        specialKeys.add((int) SWT.ESC);
        // specialKeys.add((int) SWT.LF);
        // specialKeys.add((int) SWT.TAB);
    }

    public void typeKeys(Widget w, boolean fromDisplay, KeyStroke... keys) {
        if (w.isDisposed()) {
            return;
        }
        for (KeyStroke keyStroke : keys) {
            if (fromDisplay) {
                KeyStroke[] splittedKeyStrokes = splitToKeys(keyStroke).toArray(new KeyStroke[0]);
                pressKeys(w, fromDisplay, splittedKeyStrokes);
                releaseKeys(w, fromDisplay, reverse(splittedKeyStrokes));
            } else {
                Event createEvent = createEvent(keyStroke, 0);
                w.notifyListeners(SWT.KeyDown, createEvent);
                createEvent = createEvent(keyStroke, 0);
                w.notifyListeners(SWT.KeyUp, createEvent);
            }
        }
    }

    public void pressKeys(Widget w, boolean fromDisplay, KeyStroke... keys) {
        if (w.isDisposed()) {
            return;
        }
        for (KeyStroke keyStroke : keys) {
            Event createEvent = createEvent(keyStroke, 0);
            if (fromDisplay) {
                createEvent.widget = w;
                createEvent.type = SWT.KeyDown;
                w.getDisplay().post(createEvent);
            } else
                w.notifyListeners(SWT.KeyDown, createEvent);
        }
    }

    public void releaseKeys(Widget w, boolean fromDisplay, KeyStroke... keys) {
        if (w.isDisposed()) {
            return;
        }
        for (KeyStroke keyStroke : keys) {
            Event createEvent = createEvent(keyStroke, 0);
            if (fromDisplay) {
                createEvent.widget = w;
                createEvent.type = SWT.KeyUp;
                w.getDisplay().post(createEvent);
            } else
                w.notifyListeners(SWT.KeyUp, createEvent);
        }
    }

    private char character(KeyStroke key, int modifier) {
        int naturalKey = key.getNaturalKey();
        int mod = key.getModifierKeys();
        char ch = (char) naturalKey;

        // if (specialKeys.contains(naturalKey))
        // return 0;
        if (mod == SWT.SHIFT)
            ch = Character.toUpperCase(ch);
        if (modifier == SWT.SHIFT) {
            if (Character.isLowerCase(ch))
                ch = Character.toUpperCase(ch);
            else
                ch = Character.toLowerCase(ch);
        } else if (modifier != 0)
            return 0;
        return ch;
    }

    private int keycode(KeyStroke key) {
        int naturalKey = key.getNaturalKey();
        int modifierKeys = key.getModifierKeys();
        if (naturalKey == 0)
            return modifierKeys;
        return naturalKey;
    }

    public Event createEvent(KeyStroke key, int modifier) {
        Event e = new Event();
        e.keyCode = keycode(key);
        e.stateMask = key.getModifierKeys();
        e.character = character(key, modifier);
        return e;
    }

    public Event createEvent(int code, int mask, char character) {
        Event e = new Event();
        e.keyCode = code;
        e.stateMask = mask;
        e.character = character;
        return e;
    }

    private KeyStroke[] reverse(KeyStroke... keys) {
        ArrayList<KeyStroke> copy = new ArrayList<KeyStroke>(Arrays.asList(keys));
        Collections.reverse(copy);
        return copy.toArray(new KeyStroke[0]);
    }

    private static int[] sortModifierKeys(final int modifierKeys) {
        final IKeyLookup lookup = KeyLookupFactory.getDefault();
        final int[] sortedKeys = new int[4];
        int index = 0;

        if ((modifierKeys & lookup.getAlt()) != 0) {
            sortedKeys[index++] = lookup.getAlt();
        }
        if ((modifierKeys & lookup.getCommand()) != 0) {
            sortedKeys[index++] = lookup.getCommand();
        }
        if ((modifierKeys & lookup.getCtrl()) != 0) {
            sortedKeys[index++] = lookup.getCtrl();
        }
        if ((modifierKeys & lookup.getShift()) != 0) {
            sortedKeys[index++] = lookup.getShift();
        }

        return sortedKeys;
    }

    /**
     * @param keyStroke
     *            splited to combination of
     * @return the keystrokes corresponding to the modification keys and
     *         character.
     */
    public List<KeyStroke> splitToKeys(KeyStroke keyStroke) {
        int modificationKeys = keyStroke.getModifierKeys();
        List<KeyStroke> keys = new ArrayList<KeyStroke>();
        if (modificationKeys != 0) {
            int[] sortModifierKeys = sortModifierKeys(modificationKeys);
            for (int modifierKey : sortModifierKeys) {
                if (modifierKey != KeyStroke.NO_KEY)
                    keys.add(KeyStroke.getInstance(modifierKey, 0));
            }
        }
        int naturalKey = keyStroke.getNaturalKey();
        if (naturalKey != KeyStroke.NO_KEY) {
            keys.add(KeyStroke.getInstance(0, keyStroke.getNaturalKey()));
        }
        return keys;
    }
}
