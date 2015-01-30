package org.eclipse.rcptt.reporting.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.reporting.Q7Info;

public enum SimpleSeverity {
	OK,
	CANCEL,
	ERROR;
	
	private static SimpleSeverity create(int severity) {
		if ((severity & ~IStatus.INFO) == 0) {
			return OK;
		} else if ((severity & IStatus.CANCEL) != 0) {
			return CANCEL;
		} else {
			return ERROR;
		}
	}

	public static SimpleSeverity create(IStatus status) {
		if (status == null)
			return ERROR;
		return create(status.getSeverity());
	}

	public static SimpleSeverity create(ProcessStatus status) {
		if (status == null)
			return ERROR;
		return create(status.getSeverity());
	}

	public static SimpleSeverity create(Q7Info info) {
		if (info == null)
			return ERROR;
		return create(info.getResult());
	}

}
