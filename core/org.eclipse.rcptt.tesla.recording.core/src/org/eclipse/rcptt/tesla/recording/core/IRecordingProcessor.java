/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
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
