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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.client.service.JavaScriptExecutor;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.ui.RWTUtils;
import org.eclipse.swt.widgets.Display;

public class ShutdownAutService implements ICommandService {

	private static final String SLOSE_BROWSER_WINDOWS_SCRIPT = "window.open('', '_self', ''); window.close()"; //$NON-NLS-1$
	private static final long SLEEP_BEFORE_DESTROY_RUNTIME = TimeUnit.SECONDS.toMillis(7);

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		try {
			closeClient();
		} catch (Throwable e) {
			CorePlugin.log(e);
		}
		return Status.OK_STATUS;
	}

	private void closeClient() {
		Display display = RWTUtils.findDisplay();
		final AtomicBoolean browserClose = new AtomicBoolean(false);
		if (display != null) {
			display.asyncExec(new Runnable() {
				@Override
				public void run() {
					JavaScriptExecutor executor = RWT.getClient().getService(JavaScriptExecutor.class);
					executor.execute(SLOSE_BROWSER_WINDOWS_SCRIPT);
					browserClose.set(true);
				}
			});
		}
		waitingCloseBrowser(browserClose);
		Runtime.getRuntime().exit(IStatus.OK);
	}

	private void waitingCloseBrowser(AtomicBoolean browserClose) {
		while (!browserClose.get()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				//nothing
			}
		}
		try {
			Thread.sleep(SLEEP_BEFORE_DESTROY_RUNTIME);
		} catch (InterruptedException e) {
			//nothing
		}
	}
}
