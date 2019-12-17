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
package org.eclipse.rcptt.ecl.internal.debug.runtime;

import java.util.concurrent.CountDownLatch;

public class MultiLatch {

	public void await() throws InterruptedException {
		latch.await();
	}

	public synchronized void lockAfterUnlock() {
		unlock();
		lock();
	}

	public synchronized boolean isLocked() {
		return latch.getCount() > 0;
	}

	public synchronized void lock() {
		if (!isLocked()) {
			latch = new CountDownLatch(1);
		}
	}

	public synchronized void unlock() {
		latch.countDown();
	}

	private volatile CountDownLatch latch = new CountDownLatch(1);

}
