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

import java.util.List;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.launching.ILaunchListener;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;

public class LaunchListener implements ILaunchListener {

	public void started(final IExecutionSession session) {
		if (PlatformUI.isWorkbenchRunning()) {
			exec(new Runnable() {
				public void run() {
					List<ExecutionView> views = ExecutionView.views;
					synchronized (views) {
						showActivateView(views);
						for (ExecutionView ew : views) {
							ew.setInput(session);
						}
					}
				}
			});
		}
	}

	public void finished() {
		if (PlatformUI.isWorkbenchRunning()) {
			exec(new Runnable() {
				public void run() {
					// ExecutionView view = getView();
					// if (view != null) {
					// view.finished();
					// }
					List<ExecutionView> views = ExecutionView.views;
					synchronized (views) {
						for (ExecutionView ew : views) {
							ew.finished();
						}
					}
				}
			});
		}
	}

	public void launchStatusChanged(final IExecutable... executable) {
		if (PlatformUI.isWorkbenchRunning()) {
			exec(new Runnable() {
				public void run() {
					// ExecutionView view = getView();
					// if (view != null) {
					// view.update(executable);
					// }
					List<ExecutionView> views = ExecutionView.views;
					synchronized (views) {
						for (ExecutionView ew : views) {
							ew.update(executable);
						}
					}
				}
			});
		}
	}

	// private ExecutionView getView() {
	// IWorkbenchPage page = WorkbenchUtils.getPage();
	// if (page == null) {
	// return null;
	// }
	// return (ExecutionView) page.findView(ExecutionView.ID);
	// }

	private void exec(Runnable runnable) {
		WorkbenchUtils.uiRun(runnable);
	}

	private void showActivateView(List<ExecutionView> views) {
		if (views.size() == 0) {
			try {
				IWorkbenchWindow window = PlatformUI
						.getWorkbench()
						.getActiveWorkbenchWindow();
				if (window != null) {
					IWorkbenchPage page = window
							.getActivePage();
					if (page != null) {
						page.showView(ExecutionView.ID);
					}
				}
			} catch (PartInitException e) {
				Q7UIPlugin.log(e);
			}
		}
	}

}
