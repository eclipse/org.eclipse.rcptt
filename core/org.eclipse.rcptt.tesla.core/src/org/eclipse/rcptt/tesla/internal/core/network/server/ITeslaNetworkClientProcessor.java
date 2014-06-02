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
package org.eclipse.rcptt.tesla.internal.core.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;

public interface ITeslaNetworkClientProcessor {
	void activateMode(SetMode command, TeslaMode oldMode);

	void initialize(TeslaNetworkClientConnection teslaNetworkClientConnection,
			DataInputStream din, DataOutputStream dout,
			NetworkTeslaClient teslaClient);

	void terminate(boolean last);

	void setFeature(String name, String value);

	void resetAssertSelection();
}
