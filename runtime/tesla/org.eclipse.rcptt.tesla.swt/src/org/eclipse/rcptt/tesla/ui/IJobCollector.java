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
package org.eclipse.rcptt.tesla.ui;

import org.eclipse.core.runtime.jobs.Job;

public interface IJobCollector {
	enum JobStatus {
		REQUIRED, 
		IGNORED, 
		UNKNOWN
	}

	JobStatus testJob(Job job);

//  Return value of this method was ignored (due to trivial implementation of EclJobCollector which never returned false). 
//  To make RCPTT wait for a job, return JobStatus.REQUIRED from testJob()
//  
//	boolean noSkipMode(Job job);

}
