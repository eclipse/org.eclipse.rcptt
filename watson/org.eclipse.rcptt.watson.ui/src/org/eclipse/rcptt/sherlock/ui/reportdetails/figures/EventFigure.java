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
package org.eclipse.rcptt.sherlock.ui.reportdetails.figures;

import org.eclipse.draw2d.RectangleFigure;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;

public class EventFigure extends RectangleFigure {

	private Event event;
	private Event endEvent;

	public EventFigure() {
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Event getEvent() {
		return event;
	}

	public void setEndEvent(Event endEvent) {
		this.endEvent = endEvent;
	}

	public Event getEndEvent() {
		return endEvent;
	}
}
