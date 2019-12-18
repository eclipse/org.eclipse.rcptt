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
package org.eclipse.rcptt.tesla.recording.core.swt.rap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Widget;

public class RecordingDescriberManager {
	private static class Entry {
		IRecorderDescriberExtension ext;
		int priority = 0;
	}

	private List<Entry> extensions = null;
	private static RecordingDescriberManager descManager = null;

	private RecordingDescriberManager() {
	}

	private synchronized void initialize() {
		if (extensions != null) {
			return;
		}
		extensions = new ArrayList<Entry>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						Activator.PLUGIN_ID + ".describerExtensions");
		for (IConfigurationElement cfg : elements) {
			IRecorderDescriberExtension provider;
			try {
				provider = (IRecorderDescriberExtension) cfg
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

	IRecorderDescriberExtension[] getExtensions() {
		initialize();

		IRecorderDescriberExtension[] ar = new IRecorderDescriberExtension[extensions
				.size()];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = extensions.get(i).ext;
		}
		return ar;
	}

	public static IRecordingDescriber getDescriber(Widget widget, int x, int y,
			boolean fromAssert) {
		if (descManager == null) {
			descManager = new RecordingDescriberManager();
		}
		IRecorderDescriberExtension[] extensions = descManager.getExtensions();
		IRecordingDescriber current = new RecordingWidgetDescriber(widget);
		for (IRecorderDescriberExtension ext : extensions) {
			current = ext.getDescriber(widget, current, x, y, fromAssert);
		}
		return current;
	}
}
