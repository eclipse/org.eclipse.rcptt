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
package org.eclipse.rcptt.tesla.jdt;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class JDTWaitJob extends Job {
	private static boolean running = false;

	public JDTWaitJob() {
		super("Wait for JDT indexing");
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		synchronized (JDTWaitJob.class) {
			running = true;
		}
		// IndexManager index = JavaModelManager.getIndexManager();
		// while (index.awaitingJobsCount() > 0) {
		// index.performConcurrentJob(new EmptyJob(), IJob.WaitUntilReady,
		// monitor);
		// }
		synchronized (JDTWaitJob.class) {
			running = false;
		}
		return Status.OK_STATUS;
	}
}
