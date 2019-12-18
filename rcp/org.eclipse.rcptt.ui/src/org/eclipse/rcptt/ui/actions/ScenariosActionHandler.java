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
package org.eclipse.rcptt.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.utils.TestSuiteUtils;
import org.eclipse.rcptt.ui.editors.INamedElementEditor;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.utils.ModelUtils;

public abstract class ScenariosActionHandler extends AbstractHandler {
	private final String title;

	protected ScenariosActionHandler(String title) {
		this.title = title;
	}

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		Job job = new Job(title) {
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				onStart();

				ISelection selection = HandlerUtil.getCurrentSelection(event);
				IResource[] resources = LaunchUtils.getContext(selection);
				IQ7NamedElement[] scenarios = TestSuiteUtils.getElements(
						resources, true);

				monitor.beginTask(title, scenarios.length);

				List<IStatus> errors = new ArrayList<IStatus>();

				for (IQ7NamedElement ne : scenarios) {
					if (monitor.isCanceled())
						break;
					ITestCase scenario = null;
					scenario = (ITestCase) RcpttCore.create((IFile) ne
							.getResource());
					try {
						final INamedElementEditor editor = ModelUtils
								.findEditor(ne);
						if (editor != null) {
							boolean wasDirty = editor.isDirty();
							scenario = (ITestCase) editor
									.getAdapter(ITestCase.class);
							boolean changed = doExecute(scenario);
							if (changed && !wasDirty) {
								Display.getDefault().asyncExec(new Runnable() {
									public void run() {
										editor.doSave(monitor);
									}
								});
							}
						} else {
							doExecute(scenario);
						}
					} catch (Throwable e) {
						errors.add(Q7UIPlugin.createStatus(e));
					}
					monitor.worked(1);
				}

				onFinish();

				if (errors.isEmpty())
					return Status.OK_STATUS;
				return new MultiStatus(Q7UIPlugin.PLUGIN_ID, IStatus.OK,
						errors.toArray(new IStatus[0]), null, null);

			}
		};
		job.setUser(true);
		job.schedule();
		return null;
	}

	protected void onStart() {
	}

	protected void onFinish() {
	}

	/**
	 * Performs action under scenario
	 * 
	 * @param scenario
	 * @return true if execution changes scenario or false otherwise
	 */
	protected abstract boolean doExecute(ITestCase scenario);
}
