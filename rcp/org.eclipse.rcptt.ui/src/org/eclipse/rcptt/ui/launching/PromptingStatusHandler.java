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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class PromptingStatusHandler implements IStatusHandler {

	public Object handleStatus(final IStatus status, Object source)	throws CoreException {
		final Boolean result[] = { Boolean.TRUE };
		final Shell shell = LaunchUtils.getShell();
		LaunchUtils.runInUI(shell.getDisplay(), new Runnable() {
			public void run() {
				result[0] = Boolean.valueOf(MessageDialog.openQuestion(
						shell, "RCPTT Debug",
						status.getMessage() + "\n"
						+ "Continue anyway?"));

			}
		});
		return result[0];
	}
}
