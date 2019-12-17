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
package org.eclipse.rcptt.sherlock.core;

public class SherlockTimerRunnable implements Runnable {
	private Runnable runnable;

	public SherlockTimerRunnable(Runnable run) {
		this.runnable = run;
	}

	public void run() {
		try {
			preExecute();
			runnable.run();
		} finally {
			postExecute();
		}
	}

	@Override
	public boolean equals(Object obj) {
		Object rr = obj;
		if (obj instanceof SherlockTimerRunnable) {
			rr = ((SherlockTimerRunnable) obj).getRunnable();
		}
		return getRunnable().equals(rr);
	}

	@Override
	public int hashCode() {
		return getRunnable().hashCode();
	}

	protected void preExecute() {
	}

	protected void postExecute() {

	}

	public Runnable getRunnable() {
		if( runnable instanceof SherlockTimerRunnable) {
			return ((SherlockTimerRunnable) runnable).getRunnable();
		}
		return runnable;
	}

	public Runnable getDirectChild() {
		return runnable;
	}
}