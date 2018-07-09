/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.report.internal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Iterator;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.rcptt.ecl.internal.core.EMFConverterManager;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.util.Q7ReportIterator;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.ui.report.Q7UIReportPlugin;
import org.eclipse.rcptt.util.FileUtil;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;

public class RcpttReportEditor extends FormEditor {
	private final WritableValue reportListObservable = new WritableValue(null, Q7ReportIterator.class);
	private String initialWorkspaceLocation;

	public RcpttReportEditor() {
	}

	@Override
	protected void addPages() {
		try {
			addPage(new ReportInformationPage(this, reportListObservable, "rcptt.report.info.page",
					"General"));
		} catch (PartInitException e) {
			Q7UIReportPlugin.log(e);
		}
	}

	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);

		// Copy file into .metadata
		IPath path = Q7UIReportPlugin.getDefault().getStateLocation()
				.append("temporary");
		path.toFile().mkdirs();

		File reportFile = path.append("report_" + System.currentTimeMillis())
				.toFile();
		while (reportFile.exists()) {
			reportFile = path.append("report_" + System.currentTimeMillis())
					.toFile();
		}

		if (input instanceof IStorageEditorInput) {
			InputStream source;
			try {
				source = ((IStorageEditorInput) input).getStorage()
						.getContents();
				FileUtil.copy(new BufferedInputStream(source),
						new BufferedOutputStream(new FileOutputStream(
								reportFile)));
			} catch (Throwable e) {
				Q7UIReportPlugin.log(e);
			}
		}
		if (input instanceof IURIEditorInput) {
			URI uri = ((IURIEditorInput) input).getURI();
			InputStream stream;
			try {
				stream = uri.toURL().openStream();
				FileUtil.copy(new BufferedInputStream(stream),
						new BufferedOutputStream(new FileOutputStream(
								reportFile)));
			} catch (Exception e) {
				Q7UIReportPlugin.log(e);
			}
		}
		if (input instanceof IFileEditorInput) {
			initialWorkspaceLocation = ((IFileEditorInput) input).getFile()
					.getFullPath().removeLastSegments(1).toString();
		}
		closeList();
		reportListObservable.setValue(new Q7ReportIterator(reportFile));

		setPartName(new Path(input.getName()).removeFileExtension().toString());
	}

	private void closeList() {
		final Q7ReportIterator reportList = (Q7ReportIterator) reportListObservable.getValue();
		reportListObservable.setValue(null);
		if (reportList != null) {
			new Job("Closing report file") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					synchronized (reportList) {
						reportList.close();
					}
					return Status.OK_STATUS;
				}
			};
		}
	}

	public String getInitialWorkspaceLocation() {
		return initialWorkspaceLocation;
	}

	@Override
	public void dispose() {
		closeList();
		reportListObservable.dispose();
		super.dispose();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	public void openReport(final String id, final String title) {
		final ProgressMonitorDialog dialog = new ProgressMonitorDialog(
				getSite().getShell());
		try {
			final Q7ReportIterator reportList = (Q7ReportIterator) reportListObservable.getValue();
			if (reportList == null)
				return;
			dialog.run(true, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					monitor.beginTask("Opening report...",
							IProgressMonitor.UNKNOWN);
					Iterator<Report> iterator = reportList.iterator();
					while (iterator.hasNext()) {
						monitor.worked(1);
						final Report next = iterator.next();
						Node root = next.getRoot();
						EMap<String, EObject> properties = root.getProperties();
						final Q7Info info = (Q7Info) properties
								.get(IQ7ReportConstants.ROOT);

						if (info != null) {
							if (info.getId().equals(id)) {
								dialog.getShell().getDisplay()
										.asyncExec(new Runnable() {
											public void run() {
												openReportPage(id, title, next,
														info);

											}
										});
								return;
							}
						}
					}
					monitor.done();
				}

			});
		} catch (Throwable e) {
			Q7UIReportPlugin.log(e);
		}
	}

	private void openReportPage(final String id, final String title,
			Report next, Q7Info info) {
		String pageId = "report:" + id;

		IFormPage existingPage = findPage(pageId);
		if (existingPage != null) {
			setActivePage(pageId);
			return;
		}

		ReportPage page = new ReportPage(RcpttReportEditor.this, pageId, title, next);
		try {
			int item = addPage(page);
			if (getContainer() instanceof CTabFolder) {
				CTabItem tabItem = ((CTabFolder) getContainer()).getItem(item);
				tabItem.setShowClose(true);
				IStatus status;
				try {
					status = (IStatus) EMFConverterManager.INSTANCE.fromEObject(info.getResult());
				} catch (ClassCastException e) {
					status = new Status(IStatus.ERROR, Q7UIReportPlugin.PLUGIN_ID, "Invalid test result", e);
				} catch (CoreException e) {
					status = e.getStatus();
				}
				if (status.isOK()) {
					tabItem.setImage(Images.getImageDescriptor(
							Images.SCENARIO_PASS).createImage());
				} else if (status.matches(IStatus.ERROR)) {
					tabItem.setImage(Images.getImageDescriptor(
							Images.SCENARIO_FAIL).createImage());
				} else {
					tabItem.setImage(Images.getImageDescriptor(Images.SCENARIO)
							.createImage());
				}
			}
			setActivePage(item);
		} catch (PartInitException e) {
			Q7UIReportPlugin.log(e);
		}
	}
}
