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
package org.eclipse.rcptt.sherlock.ui.reportdetails.figures;

import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.RectangleFigure;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;

public class NodeFigure extends RectangleFigure {

	private Node node;
	private Map<EventSource, List<Event>> sources;

	public void setNode(Node node) {
		this.node = node;
	}

	public Node getNode() {
		return node;
	}

	public void setSources(Map<EventSource, List<Event>> localSourceEvents) {
		this.sources = localSourceEvents;
	}

	public Map<EventSource, List<Event>> getSources() {
		return sources;
	}
}
