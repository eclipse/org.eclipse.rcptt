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
package org.eclipse.rcptt.tesla.ecl.impl;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

import org.eclipse.swt.widgets.Widget;

public final class BoundControlHandleRuntime {

	private BoundControlHandleRuntime() {
	}

	private static final Map<Widget, Long> widgetToId = new WeakHashMap<Widget, Long>();
	private static final Map<Long, WeakReference<Widget>> idToWidget = new HashMap<Long, WeakReference<Widget>>();

	private static long serial = 0;

	public static synchronized Long put(Widget widget) {
		if (widget == null)
			return null;

		Long id = widgetToId.get(widget);
		if (id != null)
			return id;

		id = serial++;
		widgetToId.put(widget, id);
		idToWidget.put(id, new WeakReference<Widget>(widget));

		// clean every 50 puts
		if (serial % 50 == 0)
			clean();

		return id;
	}

	public static synchronized Widget get(long id) {
		WeakReference<Widget> ref = idToWidget.get(id);
		if (ref == null)
			return null;

		Widget widget = ref.get();
		if (widget == null) {
			idToWidget.remove(id);
			return null;
		}

		return widget;
	}

	private static void clean() {
		Iterator<Entry<Long, WeakReference<Widget>>> iter = idToWidget.entrySet().iterator();
		while (iter.hasNext())
			if (iter.next().getValue().get() == null)
				iter.remove();
	}
}
