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
package org.eclipse.rcptt.tesla.internal.core.queue;

import org.eclipse.rcptt.tesla.core.protocol.TeslaStream;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

public class TeslaQClient extends AbstractTeslaClient {
	TeslaQStream qStream = new TeslaQStream(null);

	@Override
	protected TeslaStream stream() {
		return qStream;
	}

	public TeslaQClient() {
		super("myid:" + System.currentTimeMillis());
	}

	@Override
	public boolean hasCommand() {
		return qStream.hasCommand();
	}

	@Override
	public String getID() {
		return null;
	}

	@Override
	public void logException(Throwable t) {
		TeslaCore.log(t);
	}
}
