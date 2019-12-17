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
package org.eclipse.rcptt.tesla.internal.jdt;

import org.eclipse.core.runtime.jobs.Job;

import org.eclipse.rcptt.tesla.jdt.JDTWaitJob;
import org.eclipse.rcptt.tesla.ui.IJobCollector;

public class JDTJobProcessor implements IJobCollector {
	public JobStatus testJob(Job job) {
		if (job instanceof JDTWaitJob) {
			return JobStatus.REQUIRED;
		}
		return JobStatus.UNKNOWN;
	}

}
