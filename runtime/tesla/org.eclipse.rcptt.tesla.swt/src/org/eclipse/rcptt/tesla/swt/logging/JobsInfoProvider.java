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
package org.eclipse.rcptt.tesla.swt.logging;

import org.eclipse.rcptt.sherlock.aspects.asyncs.AsyncEventManager;
import org.eclipse.rcptt.sherlock.aspects.jobs.internal.JobsEventManager;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.AbstractEventProvider;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;

public class JobsInfoProvider extends AbstractEventProvider {
	AsyncInfoSupport profilingListener = new AsyncInfoSupport(this);
	JobsInfoSupport profilingJobListener = new JobsInfoSupport(this);

	@Override
	public IReportBuilder[] getListeners() {
		return super.getListeners();
	}

	public JobsInfoProvider() {
	}

	public void storeSnapshot(INodeBuilder builder, String type) {
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
		AsyncEventManager.getDefault().addListener(profilingListener);
		JobsEventManager.getDefault().addListener(profilingJobListener);
		profilingJobListener.register();
	}

	@Override
	protected void doneBuilders() {
		AsyncEventManager.getDefault().removeListener(profilingListener);
		JobsEventManager.getDefault().removeListener(profilingJobListener);
		profilingJobListener.clear();
		profilingListener.clear();

		profilingJobListener.unregister();
	}

	public static String getID(Object async) {
		return Integer.toString(async.hashCode(), 16);
	}
}
