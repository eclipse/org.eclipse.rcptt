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
package org.eclipse.rcptt.runtime.ui.rap;

import org.eclipse.rcptt.core.launching.events.AutEventPingResponse;
import org.eclipse.rcptt.core.launching.events.EventsFactory;
import org.eclipse.rcptt.internal.runtime.ui.rap.Activator;

public class Q7Monitor extends Thread {

	public Q7Monitor() {
		setDaemon(true);
		setName("Q7 Runner Monitor");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// sorry, dude, this thread can't be interrupted
			}
			try {
				if (!ping()) {
					Activator.log("Error connecting to Q7 on port " + AutEventManager.getQ7EclPort()
							+ ". Shutting down ", null);
					shutdown();
					break;
				}
			} catch (Exception e) {
				Activator
						.log("Error connecting to Q7 on port " + AutEventManager.getQ7EclPort() + ". Shutting down", e);
				// Q7 die. Terminate
				shutdown();
				break;
			}
		}
	}

	public boolean ping() throws Exception {
		Object object = AutEventManager.getInstance().sendEvent(EventsFactory.eINSTANCE.createAutEventPing());
		if (object instanceof AutEventPingResponse) {
			return true;
		}
		return false;
	}

	public void shutdown() {
		// shutdown AUT
		Runtime.getRuntime().exit(0);
	}

}
