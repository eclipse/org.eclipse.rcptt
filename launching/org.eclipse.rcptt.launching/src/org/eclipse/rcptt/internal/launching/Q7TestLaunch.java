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
package org.eclipse.rcptt.internal.launching;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.Launch;

import org.eclipse.rcptt.launching.IExecutionSession;

public class Q7TestLaunch extends Launch {

	public Q7TestLaunch(ILaunchConfiguration launchConfiguration, String mode) {
		super(launchConfiguration, mode, null);
	}

	public void setSession(IExecutionSession session) {
		this.session = session;
		if (session != null) {
			this.session.setLaunch(this);
		}
	}

	public IExecutionSession getClearSession() {
		IExecutionSession result = session;
		this.session = null;
		return result;
	}

	private IExecutionSession session;

}
