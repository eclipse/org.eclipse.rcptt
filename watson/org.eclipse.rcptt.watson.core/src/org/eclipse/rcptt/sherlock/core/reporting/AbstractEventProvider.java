/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.sherlock.core.reporting;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;

public abstract class AbstractEventProvider implements IEventProvider {

	private List<IReportBuilder> listeners = new ArrayList<IReportBuilder>();

	public AbstractEventProvider() {
		super();
	}

	public void addListener(IReportBuilder builder) {
		synchronized (listeners) {
			listeners.add(builder);
		}
		initializeBuilder(builder);
	}

	protected abstract void initializeBuilder(IReportBuilder builder);

	public void removeListener(IReportBuilder builder) {
		synchronized (listeners) {
			listeners.remove(builder);
			if (listeners.isEmpty()) {
				doneBuilders();
			}
		}
	}

	protected void doneBuilders() {
	}

	protected IReportBuilder[] getListeners() {
		IReportBuilder[] result = null;
		synchronized (listeners) {
			result = (IReportBuilder[]) listeners
					.toArray(new IReportBuilder[listeners.size()]);
		}
		return result;
	}
	
	protected void logEvent(Event event) {
		for (IReportBuilder builder: getListeners()) {
			builder.getCurrent().createEvent(event);
		}
	}

	@Override
	public void storeSnapshot(INodeBuilder builder) {
	}
}