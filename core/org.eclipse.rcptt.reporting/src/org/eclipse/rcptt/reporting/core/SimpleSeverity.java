/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.reporting.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.reporting.Q7Info;

public enum SimpleSeverity {
	OK,
	CANCEL,
	ERROR;
	
	public static SimpleSeverity create(int severity) {
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
