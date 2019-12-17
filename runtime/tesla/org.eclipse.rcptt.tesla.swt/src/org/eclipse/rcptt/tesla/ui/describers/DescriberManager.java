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
package org.eclipse.rcptt.tesla.ui.describers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.ui.SWTTeslaActivator;

public class DescriberManager {
	private static class Entry {
		IDescriberExtension ext;
		int priority = 0;
	}

	private List<Entry> extensions = null;
	private static DescriberManager descManager = null;

	private DescriberManager() {
	}

	private synchronized void initialize() {
		if (extensions != null) {
			return;
		}
		extensions = new ArrayList<Entry>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						SWTTeslaActivator.PLUGIN_ID + ".describerExtensions");
		for (IConfigurationElement cfg : elements) {
			IDescriberExtension provider;
			try {
				provider = (IDescriberExtension) cfg
						.createExecutableExtension("class");
				int priority = 0;
				try {
					String attribute = cfg.getAttribute("priority");
					priority = Integer.valueOf(attribute);
				} catch (NumberFormatException e) {

				}
				Entry e = new Entry();
				e.ext = provider;
				e.priority = priority;
				extensions.add(e);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(extensions, new Comparator<Entry>() {
			public int compare(Entry o1, Entry o2) {
				return Integer.valueOf(o1.priority).compareTo(
						Integer.valueOf(o2.priority));
			}
		});
	}

	IDescriberExtension[] getExtensions() {
		initialize();

		IDescriberExtension[] ar = new IDescriberExtension[extensions.size()];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = extensions.get(i).ext;
		}
		return ar;
	}

	public static IWidgetDescriber getDescriber(Widget widget, int x, int y) {
		init();
		IDescriberExtension[] extensions = descManager.getExtensions();
		IWidgetDescriber current = new WidgetDescriber(widget);
		for (IDescriberExtension ext : extensions) {
			current = ext.getDescriber(widget, current, x, y);
		}
		return current;
	}

	public static IWidgetDescriber getDescriber(Element element,
			AbstractTeslaClient client) {
		init();
		IDescriberExtension[] extensions = descManager.getExtensions();
		for (IDescriberExtension ext : extensions) {
			IWidgetDescriber descr = ext.getDescriber(element, client);
			if (descr != null) {
				return descr;
			}
		}
		return null;
	}

	private synchronized static void init() {
		if (descManager == null) {
			descManager = new DescriberManager();
		}
	}
}
