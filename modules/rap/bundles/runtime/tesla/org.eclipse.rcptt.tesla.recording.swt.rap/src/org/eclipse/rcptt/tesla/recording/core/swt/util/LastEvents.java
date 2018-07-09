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
package org.eclipse.rcptt.tesla.recording.core.swt.util;


import static org.eclipse.rcptt.util.ListUtil.reverse;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Widget;

public class LastEvents {

	private List<RecordedEvent> eventsList = new ArrayList<RecordedEvent>();
	
	public void add(RecordedEvent event) {
		eventsList.add(event);
	}

	public void clear() {
		eventsList.clear();
	}
	
	//

	public RecordedEvent getEvent(Widget widget, int... events) {
		for (RecordedEvent e : eventsList) {
			if (e.widget == widget) {
				for (int i : events) {
					if (e.type == i) {
						return e;
					}
				}
			}
		}
		return null;
	}

	public boolean checkType(Widget widget, int... events) {
		return getEvent(widget, events) != null;
	}

	public RecordedEvent lastRecorded() {
		if (eventsList.size() > 0)
			return eventsList.get(eventsList.size() - 1);
		return null;
	}

	public Iterable<RecordedEvent> fromMostRecent() {
		return reverse(eventsList);
	}
		
}
