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
package org.eclipse.rcptt.core;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class Q7 {

	public static final int DEFAULT_COMMANDS_EXECUTION_DELAY = 0;

	public static final Q7 INSTANCE = new Q7();

	private Q7() {
	}

	public void setCommandsExecutionDelay(int delay) {
		setCommandsExecutionDelay(delay, true);
	}

	public synchronized void setCommandsExecutionDelay(int delay, boolean store) {
		commandsExecutionDelay = delay;
		if (store) {
			IEclipsePreferences preferences = RcpttPlugin.getPreferences();
			preferences.putInt(RcpttPlugin.COMMANDS_EXECUTION_DELAY,
					commandsExecutionDelay);
			try {
				preferences.flush();
			} catch (Exception e) {
				RcpttPlugin.log(e);
			}
		}
	}

	public synchronized int getCommandsExecutionDelay() {
		if (commandsExecutionDelay < 0) {
			IEclipsePreferences preferences = RcpttPlugin.getPreferences();
			return preferences.getInt(RcpttPlugin.COMMANDS_EXECUTION_DELAY,
					DEFAULT_COMMANDS_EXECUTION_DELAY);
		}
		return commandsExecutionDelay;

	}

	private int commandsExecutionDelay = -1;

}
