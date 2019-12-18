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
package org.eclipse.rcptt.tesla.gmf;

import org.eclipse.core.runtime.jobs.Job;

import org.eclipse.rcptt.tesla.ui.IJobCollector;

public class GMFJobCollector implements IJobCollector {

	public GMFJobCollector() {
	}

	public JobStatus testJob(Job job) {
		if (job.getClass()
				.getName()
				.equals("org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy$HideDiagramAssistantJob")) {
			return JobStatus.IGNORED;
		}
		return JobStatus.UNKNOWN;
	}

	public boolean noSkipMode(Job job) {
		return false;
	}

}
