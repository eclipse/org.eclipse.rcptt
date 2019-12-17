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
package org.eclipse.rcptt.internal.launching.ext.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Display;

public class SyncProgressMonitor implements IProgressMonitor {

	private IProgressMonitor monitor;
	private Display display;

	public SyncProgressMonitor(IProgressMonitor monitor, Display display) {
		this.monitor = monitor;
		this.display = display;
	}

	public void beginTask(final String name, final int totalWork) {
		display.asyncExec(new Runnable() {
			public void run() {
				monitor.beginTask(name, totalWork);
			}
		});
	}

	public void done() {
		display.asyncExec(new Runnable() {
			public void run() {
				monitor.done();
			}
		});
	}

	public void internalWorked(final double work) {
		display.asyncExec(new Runnable() {
			public void run() {
				monitor.internalWorked(work);
			}
		});
	}

	public boolean isCanceled() {
		return monitor.isCanceled();
	}

	public void setCanceled(final boolean value) {
		display.asyncExec(new Runnable() {
			public void run() {
				monitor.setCanceled(value);
			}
		});
	}

	public void setTaskName(final String name) {
		display.asyncExec(new Runnable() {
			public void run() {
				monitor.setTaskName(name);
			}
		});
	}

	public void subTask(final String name) {
		display.asyncExec(new Runnable() {
			public void run() {
				monitor.subTask(name);
			}
		});
	}

	public void worked(final int work) {
		display.asyncExec(new Runnable() {
			public void run() {
				monitor.worked(work);
			}
		});
	}

}
