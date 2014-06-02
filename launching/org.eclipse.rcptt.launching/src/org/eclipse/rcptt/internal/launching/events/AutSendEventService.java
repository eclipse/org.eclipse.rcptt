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
package org.eclipse.rcptt.internal.launching.events;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.core.launching.events.AutEvent;
import org.eclipse.rcptt.core.launching.events.AutEventPing;
import org.eclipse.rcptt.core.launching.events.AutSendEvent;
import org.eclipse.rcptt.core.launching.events.EventsFactory;
import org.eclipse.rcptt.internal.launching.aut.BaseAutManager;
import org.eclipse.rcptt.launching.AutLaunch;

public class AutSendEventService implements ICommandService {

	public AutSendEventService() {
	}

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		AutSendEvent cmd = (AutSendEvent) command;

		AutEvent event = cmd.getEvent();
		if (event instanceof AutEventPing) {
			context.getOutput().write(EventsFactory.eINSTANCE.createAutEventPingResponse());
			return Status.OK_STATUS;
		}

		AutLaunch launch = BaseAutManager.INSTANCE.getById(cmd.getId());
		if (launch != null) {
			launch.handleAutEvent(event);
		}
		return Status.OK_STATUS;
	}

}
