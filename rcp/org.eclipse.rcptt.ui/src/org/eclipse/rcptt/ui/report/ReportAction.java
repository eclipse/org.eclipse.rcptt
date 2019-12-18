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
package org.eclipse.rcptt.ui.report;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.rcptt.internal.launching.reporting.ReportMaker;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.reporting.util.Q7ReportIterator;
import org.eclipse.rcptt.sherlock.core.streams.SherlockReportOutputStream;

public class ReportAction extends Action {
	private final IShellProvider shell;
	private IExecutionSession session;

	public ReportAction(final IShellProvider shell) {
		super(Messages.ReportAction_Name, Images.getImageDescriptor(Images.REPORT));

		this.shell = shell;
		setEnabled(false);
	}

	public void setSession(final IExecutionSession session) {
		this.session = session;
		setEnabled(session != null);
	}

	@Override
	public void run() {
		File root = Q7UIPlugin.getDefault().getStateLocation()
				.append("reporting").toFile(); //$NON-NLS-1$
		root.mkdirs();
		File reportFile = new File(root, "current.report"); //$NON-NLS-1$
		if (reportFile.exists()) {
			reportFile.delete();
		}

		final SherlockReportOutputStream out;
		try {
			out = new SherlockReportOutputStream(new BufferedOutputStream(
					new FileOutputStream(reportFile)));
		} catch (FileNotFoundException e1) {
			Q7UIPlugin.log(e1);
			return;
		}

		ProgressMonitorDialog monDialog = new ProgressMonitorDialog(
				shell.getShell());
		try {
			monDialog.run(false, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					new ReportMaker(out).make(session, monitor);
					out.close();
					monitor.done();
				}
			});
		} catch (Throwable e) {
			Q7UIPlugin.log(e);
		}
		ReportWizard wizard = new ReportWizard(
				new Q7ReportIterator(reportFile), session.getName() + "_" //$NON-NLS-1$
						+ new SimpleDateFormat("yyyy_MM_dd").format(new Date())); //$NON-NLS-1$
		IDialogSettings ds = Q7UIPlugin.getDefault().getDialogSettings()
				.getSection("q7.reporting"); //$NON-NLS-1$
		if (ds == null) {
			ds = Q7UIPlugin.getDefault().getDialogSettings()
					.addNewSection("q7.reporting"); //$NON-NLS-1$
		}
		wizard.setNeedsProgressMonitor(true);
		wizard.setDialogSettings(ds);
		WizardDialog dialog = new WizardDialog(shell.getShell(), wizard);
		dialog.open();
	}
}
