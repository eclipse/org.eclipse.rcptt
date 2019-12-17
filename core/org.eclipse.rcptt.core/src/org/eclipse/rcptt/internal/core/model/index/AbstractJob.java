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
package org.eclipse.rcptt.internal.core.model.index;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.core.jobs.IJob;

public abstract class AbstractJob implements IJob {

	protected boolean isCancelled = false;

	public boolean belongsTo(String jobFamily) {
		return false;
	}

	public void cancel() {
		isCancelled = true;
	}

	// private Exception constructedAt;

	public void ensureReadyToRun() {
	}

	protected abstract String getName();

	protected void log(Object message) {
		System.out.println('[' + toString() + "] " + message); //$NON-NLS-1$
	}

	private final String getShortClassName() {
		return getClass().getSimpleName();
	}

	private String savedName;

	@Override
	public String toString() {
		final String shortClassName = getShortClassName();
		if (savedName == null) {
			try {
				savedName = getName();
			} catch (Exception e) {
				savedName = "<Unknown>"; //$NON-NLS-1$
			}
		}
		return shortClassName + '|' + savedName;
	}

	public final boolean execute(IProgressMonitor monitor) {
		try {
			run();
		} catch (Exception e) {
			RcpttPlugin.log(toString() + " error", e); //$NON-NLS-1$
			return FAILED;
		}
		return COMPLETE;
	}

	protected abstract void run() throws CoreException, IOException;

}
