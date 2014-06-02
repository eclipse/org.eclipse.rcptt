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
package org.eclipse.rcptt.tesla.recording.core;

import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;

public interface IRecordingProcessor {

	void initialize(TeslaRecorder teslaRecorder);

	void clear();

	void setFreeze(boolean value, SetMode command);

	void resetAssertSelection();

	IRecordingHelper<?> getHelper();

	int getInitLevel(); // Return initialization level.
}
