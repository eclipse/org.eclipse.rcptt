/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.profiling;

public interface IProfilingListener {
	// Async methods
	void asyncAdded(Runnable async, boolean sync);

	void timerAdded(Runnable async);
	
	void asyncRunning(Runnable async);

	void asyncDone(Runnable async);

}
