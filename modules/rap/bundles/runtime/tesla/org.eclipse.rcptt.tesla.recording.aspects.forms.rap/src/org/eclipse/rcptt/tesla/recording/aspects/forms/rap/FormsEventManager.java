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
package org.eclipse.rcptt.tesla.recording.aspects.forms.rap;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ui.forms.widgets.ExpandableComposite;

public final class FormsEventManager {
	private FormsEventManager() {
	}

	private static Set<IFormsEventListener> listeners = new HashSet<IFormsEventListener>();

	public static void addListener(IFormsEventListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(IFormsEventListener listener) {
		listeners.remove(listener);
	}

	public static void clickOnExpandable(ExpandableComposite composite) {
		for (IFormsEventListener listener : listeners) {
			listener.clickOnExpandable(composite);
		}
	}
}
