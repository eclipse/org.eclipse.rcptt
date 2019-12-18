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
package org.eclipse.rcptt.ui.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.internal.launching.AutStatusConstants;

public class AutStatusHandler implements IStatusHandler {

	public Object handleStatus(IStatus status, Object source)
			throws CoreException {
		if (status.getCode() == AutStatusConstants.SELECT_AUT_CODE) {
			return LaunchUtils.selectAutLaunch();
		} else if (status.getCode() == AutStatusConstants.CANCEL_DEBUG_SESSIONS_CODE) {
			Shell shell = (source instanceof Shell) ? (Shell) source : null;
			return LaunchUtils.checkCancelDebugSessions(shell);
		}
		return null;
	}

}
