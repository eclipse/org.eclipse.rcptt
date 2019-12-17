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
package org.eclipse.rcptt.ui.controls;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressIndicator;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class StatusBarComposite {
	private String message;
	private Label messageLabel;
	private ProgressIndicator progressIndicator;
	private Composite parent;
	private Composite composite;
	private Shell shell;

	public void createControl(Composite parent) {
		shell = parent.getShell();
		this.parent = parent;
		composite = new Composite(parent, SWT.NONE);
		messageLabel = new Label(composite, SWT.NONE);
		progressIndicator = new ProgressIndicator(composite);
		composite.addControlListener(new ControlListener() {
			public void controlMoved(ControlEvent e) {
			}

			public void controlResized(ControlEvent e) {
				if (messageLabel != null && messageLabel.isVisible()
						&& message != null) {
					messageLabel.setText(Dialog.shortenText(message,
							messageLabel));
				}
			}
		});
		setMessageLayout();
		hide();
	}

	public Control getControl() {
		return composite;
	}

	public void showMessage(final String message) {
		asyncExec(new Runnable() {
			public void run() {
				if (message != null) {
					setMessageLayout();
					show();
					layout();
					setMessage(message, true);
				} else {
					hide();
					layout();
				}
			}
		});
	}

	private void setMessage(String messageString, boolean force) {
		// must not set null text in a label
		message = messageString == null ? "" : messageString; //$NON-NLS-1$
		if (messageLabel == null || messageLabel.isDisposed()) {
			return;
		}
		if (force || messageLabel.isVisible()) {
			messageLabel.setToolTipText(message);
			messageLabel.setText(Dialog.shortenText(message, messageLabel));
			layout();
		}
	}

	private void update() {
		if (messageLabel == null || messageLabel.isDisposed()) {
			return;
		}
		messageLabel.update();
		layout();
	}

	public void runWithProgress(String name,
			final IRunnableWithProgress runnable, boolean fork) {
		if (name == null || name.length() <= 0) {
			name = DEFAULT_TASKNAME;
		}
		final String message = name;
		asyncExec(new Runnable() {
			public void run() {
				setProgressBarLayout();
				show();
				layout();
				setMessage(message, false);
			}
		});
		final ProgressMonitor monitor = new ProgressMonitor();
		try {
			ModalContext.run(runnable, fork, monitor, shell.getDisplay());
		} catch (final InvocationTargetException e) {
			handleError(message, e.getTargetException());
		} catch (InterruptedException e) {
			// Canceled
		}
	}

	protected void handleError(final String taskMessage, final Throwable e) {
		Q7UIPlugin.getDisplay().asyncExec(new Runnable() {
			public void run() {
				IStatus status;
				if (e instanceof CoreException) {
					status = ((CoreException) e).getStatus();
				} else {
					status = Q7UIPlugin.createStatus(e);
				}
				ErrorDialog.openError(shell, Messages.StatusBarComposite_ErrorDialogTitle,
						Messages.bind(
								Messages.StatusBarComposite_ErrorDialogMsg,
								taskMessage), status);
			}
		});
	}

	private void setMessageLayout() {
		GridLayoutFactory.fillDefaults().margins(2, 2).applyTo(composite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(messageLabel);
		GridDataFactory.fillDefaults().exclude(true).applyTo(progressIndicator);
	}

	private void setProgressBarLayout() {
		GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(true)
				.margins(2, 2).applyTo(composite);
		GridDataFactory.fillDefaults().grab(false, false).applyTo(messageLabel);
		GridDataFactory.fillDefaults().span(3, 1).grab(true, false)
				.applyTo(progressIndicator);
	}

	private void show() {
		GridDataFactory.fillDefaults().grab(true, false).applyTo(composite);
	}

	private void hide() {
		GridDataFactory.fillDefaults().exclude(true).applyTo(composite);
	}

	protected void layout() {
		composite.layout(true);
		parent.layout(true);
	}

	private static String DEFAULT_TASKNAME = "Operation in progress..."; //$NON-NLS-1$

	private void asyncExec(Runnable runnable) {
		if (Display.getDefault().getThread() != Thread.currentThread()) {
			Display.getDefault().asyncExec(runnable);
		} else {
			runnable.run();
		}
	}

	private class ProgressMonitor implements IProgressMonitor {
		private volatile boolean canceled;
		protected boolean forked = false;

		public void beginTask(String name, int totalWork) {
			if (progressIndicator.isDisposed()) {
				return;
			}
			if (name == null || name.length() <= 0) {
				name = DEFAULT_TASKNAME;
			}
			setMessage(name, false);
			if (!forked) {
				update();
			}
			if (totalWork == UNKNOWN) {
				progressIndicator.beginAnimatedTask();
			} else {
				progressIndicator.beginTask(totalWork);
			}
		}

		public void done() {
			if (!progressIndicator.isDisposed()) {
				progressIndicator.sendRemainingWork();
				progressIndicator.done();
			}
			if (composite != null && !composite.isDisposed()) {
				hide();
				layout();
			}
		}

		public void setTaskName(String name) {
			if (name == null || name.length() <= 0) {
				name = DEFAULT_TASKNAME;
			}
			setMessage(name, false);
			if (!forked) {
				update();
			}
		}

		public boolean isCanceled() {
			return canceled;
		}

		public void setCanceled(boolean b) {
			canceled = b;
		}

		public void subTask(String name) {
			// Do nothing
		}

		public void worked(int work) {
			internalWorked(work);
		}

		public void internalWorked(double work) {
			if (!progressIndicator.isDisposed()) {
				progressIndicator.worked(work);
			}
		}
	}
}