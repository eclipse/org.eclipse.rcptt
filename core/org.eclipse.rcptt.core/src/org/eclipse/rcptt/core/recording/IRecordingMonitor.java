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
package org.eclipse.rcptt.core.recording;

import org.eclipse.rcptt.tesla.internal.core.network.IConnectionMonitor;

public interface IRecordingMonitor extends IConnectionMonitor {
	public void recordMode();

	public void assertMode();
	
	public void startRecord();
	
	public void stopRecord();
	
	public void replay();
	
	public void assertAdded(CommandSet commands);
}
