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
package org.eclipse.rcptt.sherlock.aspects.jobs.internal;

import org.eclipse.core.internal.jobs.InternalJob;
import org.eclipse.core.runtime.IStatus;

public interface IJobsEventListener {

	void jobSchedule(InternalJob job, long delay, boolean reshedule);

	void jobChangeStatus(InternalJob job, int newState);

	void endJob(InternalJob job, IStatus status, boolean notify);

	void jobCanceled(InternalJob job);
}
