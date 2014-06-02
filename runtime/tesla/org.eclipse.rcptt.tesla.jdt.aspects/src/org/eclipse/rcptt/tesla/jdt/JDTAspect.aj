package org.eclipse.rcptt.tesla.jdt;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.internal.core.search.processing.IJob;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

@SuppressWarnings("restriction")
public privileged aspect JDTAspect {
	public JDTAspect() {
		AspectManager.activateAspect(JDTAspectsActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.jdt.internal.core.search.processing.JobManager mgr): 
		execution(void org.eclipse.jdt.internal.core.search.processing.JobManager.request(IJob))
		&& target( mgr ) {
		synchronized (JDTWaitJob.class) {
			if (JDTWaitJob.running) {
				return;
			}
		}
		Job jdtWaitJob = new JDTWaitJob();
		jdtWaitJob.setSystem(true);
		jdtWaitJob.schedule();
	}
}
