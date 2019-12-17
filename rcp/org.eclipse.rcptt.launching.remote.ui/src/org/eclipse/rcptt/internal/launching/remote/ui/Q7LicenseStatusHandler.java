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
package org.eclipse.rcptt.internal.launching.remote.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

public class Q7LicenseStatusHandler implements IStatusHandler {

	public Object handleStatus(IStatus status, Object source)
			throws CoreException {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

			public void run() {
				MessageDialog
						.openError(
								null,
								"License Error",
								"Connection to remote AUTs is prohibited in Q7 Community Edition. Please use Q7 Professional.");
			}
		});

		return Boolean.FALSE;
	}

}
