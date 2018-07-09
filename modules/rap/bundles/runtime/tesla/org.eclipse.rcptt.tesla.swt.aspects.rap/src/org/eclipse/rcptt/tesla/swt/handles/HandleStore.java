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
package org.eclipse.rcptt.tesla.swt.handles;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;

/**
 * Class is intended to hold information about all created Widgets and other SWT
 * resources.
 */
public class HandleStore {
	private static HandleStore store = null;
	private Map<Widget, Context> widgets = new WeakHashMap<Widget, Context>();
	private Map<Resource, Context> resources = new WeakHashMap<Resource, Context>();

	public static HandleStore getStore() {
		if (store == null) {
			store = new HandleStore();
		}
		return store;
	}

	public void registerWidget(Widget widget, Context context) {
		widgets.put(widget, context);
	}

	public void releaseWidget(Widget widget) {
	}

	public void registerResource(Resource res, Context context) {
		if (context.contains(
				"org.eclipse.jface.resource.AbstractResourceManager", "create")
				|| context
						.containsClass("org.eclipse.jface.resource.FontRegistry")
				|| context.contains("org.eclipse.swt.widgets.Display",
						"getSystemColor")) {
			return;
		}
		resources.put(res, context);
	}

	public void releaseResource(Resource res) {
		resources.remove(res);
	}

	public Map<Widget, Context> getWidgets() {
		return new HashMap<Widget, Context>(widgets);
	}

	public Map<Resource, Context> getResources() {
		return new HashMap<Resource, Context>(resources);
	}

	public void printInfo() {
		Map<Widget, Context> widgets = HandleStore.getStore().getWidgets();
		Map<Resource, Context> ress = HandleStore.getStore().getResources();
		Map<String, Integer> items = new HashMap<String, Integer>();

		for (Map.Entry<Widget, Context> ctx : widgets.entrySet()) {
			if (!ctx.getKey().isDisposed()) {
				String clName = ctx.getKey().getClass().getName();
				Integer count = items.get(clName);
				if (count == null) {
					items.put(clName, Integer.valueOf(1));
				} else {
					items.put(clName, Integer.valueOf(1 + count.intValue()));
				}
			}
		}
		for (Map.Entry<Resource, Context> ctx : ress.entrySet()) {
			if (!ctx.getKey().isDisposed()) {
				String clName = ctx.getKey().getClass().getName();
				Integer count = items.get(clName);
				if (count == null) {
					items.put(clName, Integer.valueOf(1));
				} else {
					items.put(clName, Integer.valueOf(1 + count.intValue()));
				}
			}
		}
		System.out.println("-------------------------------------------------------------------------");
		for (Map.Entry<String, Integer> v : items.entrySet()) {
			System.out.println("class: " + v.getKey() + " instance count: "
					+ v.getValue());
		}
	}
}
