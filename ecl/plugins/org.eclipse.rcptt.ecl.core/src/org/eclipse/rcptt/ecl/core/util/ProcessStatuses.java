package org.eclipse.rcptt.ecl.core.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.ecl.internal.core.ProcessStatusConverter;

public final class ProcessStatuses {
	private ProcessStatuses() {}
	
	public static ProcessStatus adapt(IStatus status) {
		return ProcessStatusConverter.toProcessStatus(status);
	}
	
	public static IStatus adapt(ProcessStatus status) {
		return ProcessStatusConverter.toIStatus(status);
	}

}
