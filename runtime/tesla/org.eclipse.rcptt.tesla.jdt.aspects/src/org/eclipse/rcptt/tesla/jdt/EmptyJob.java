/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.jdt;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.internal.core.search.processing.IJob;

public class EmptyJob implements IJob {
	public String getJobFamily() {
		return null;
	}

	public boolean execute(IProgressMonitor progress) {
		return true;
	}

	public void ensureReadyToRun() {
	}

	public void cancel() {
	}

	public boolean belongsTo(String jobFamily) {
		return false;
	}
}
