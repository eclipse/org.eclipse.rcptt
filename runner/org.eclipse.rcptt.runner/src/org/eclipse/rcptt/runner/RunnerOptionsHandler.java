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
package org.eclipse.rcptt.runner;

import org.eclipse.rcptt.core.OptionsHandler;
import org.eclipse.rcptt.launching.Q7Launcher;

public class RunnerOptionsHandler extends OptionsHandler {

	private boolean restartAUTOnFailures = false;

	@Override
	protected boolean handleSpecialOption(String key, String value) {
		if (TEST_EXEC_TIMEOUT.equals(key)) {
			Q7Launcher.setLaunchTimeout(Integer.parseInt(value));
			return true;
		}
		if (RESTART_AUT_ON_FAILURE.equals(key)) {
			this.restartAUTOnFailures = ("true".equalsIgnoreCase(value));
			return true;
		}
		return false;
	}

	public boolean isRestartAUTOnFailures() {
		return restartAUTOnFailures;
	}
}
