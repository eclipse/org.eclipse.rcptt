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
package org.eclipse.rcptt.tesla.recording.aspects.gmf;

import java.util.HashSet;
import java.util.Set;

public final class GMFEventManager {
	private GMFEventManager() {
	}

	private static Set<IGMFEventListener> listeners = new HashSet<IGMFEventListener>();

	public static void addListener(IGMFEventListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(IGMFEventListener listener) {
		listeners.remove(listener);
	}
}
