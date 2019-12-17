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
package org.eclipse.rcptt.ui.actions;

import java.io.EOFException;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.ecl.core.model.CreateContext;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.ecl.core.model.SetQ7Features;
import org.eclipse.rcptt.internal.launching.Q7LaunchManager;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.ui.editors.IQ7Editor;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;

public class ContextSnapshotAction extends Action {

	private final IQ7Editor<Context> editor;
	private boolean join = false;
	private IStatus status = Status.OK_STATUS;

	public ContextSnapshotAction(IQ7Editor<Context> editor) {
		setImageDescriptor(Images.getImageDescriptor(Images.SNAPSHOT));
		setToolTipText(Messages.ContextSnapshotAction_ToolTip);
		this.editor = editor;
	}

	@Override
	public void run() {
		final AutLaunch aut = LaunchUtils.selectAutLaunch();
		final EObject contextParam;
		try {
			contextParam = editor.getCreateParam(aut);
		} catch (CoreException ex) {
			status = ex.getStatus();
			return;
		}
		Job job = new Job(Messages.ContextSnapshotAction_Job) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("", 2); //$NON-NLS-1$
				IContext context = (IContext) editor.getElement();
				try {
					ContextType type = context.getType();
					monitor.worked(1);
					final Context newContext = createSnapshot(aut,
							type.getId(), contextParam);
					if (newContext != null) {
						final IWorkspaceRunnable operation = new IWorkspaceRunnable() {
							public void run(IProgressMonitor monitor)
									throws CoreException {
								editor.copyContentFrom(newContext,
										new SubProgressMonitor(monitor, 1));
							}
						};
						ResourcesPlugin.getWorkspace().run(operation, monitor);
						monitor.done();
					}
				} catch (InterruptedException ie) {
					status = Status.CANCEL_STATUS;
					return status;
				} catch (CoreException e) {
					return e.getStatus();
				} catch (Exception e) {
					return Q7UIPlugin.createStatus(e);
				}
				status = Status.OK_STATUS;
				return status;
			}
		};
		job.setUser(true);
		job.schedule();
		if (isJoin()) {
			try {
				job.join();
			} catch (InterruptedException e) {
				// Ignore
			}
		}
	}

	@Override
	public boolean isEnabled() {
		IContext context = (IContext) editor.getElement();
		ContextType type;
		try {
			type = context.getType();
			return type.canCreate();
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
			return false;
		}
	}

	public IStatus getStatus() {
		return status;
	}

	public boolean isJoin() {
		return join;
	}

	public void setJoin(boolean join) {
		this.join = join;
	}

	public static Context createSnapshot(AutLaunch aut, String contextType,
			EObject param) throws CoreException, InterruptedException {
		if (aut == null) {
			aut = LaunchUtils.selectAutLaunch();
		}
		if (aut == null) {
			return null;
		}

		if (!Q7LaunchManager.getInstance().cancelDebugExecution(aut, null)) {
			return null;
		}

		SetQ7Features setQ7Features = Q7CoreFactory.eINSTANCE
				.createSetQ7Features();
		TeslaFeatures.getInstance().storeValues(setQ7Features.getFeatures());
		Q7Features.getInstance().storeValues(setQ7Features.getFeatures());
		aut.execute(setQ7Features);

		try {
			CreateContext cc = Q7CoreFactory.eINSTANCE.createCreateContext();
			cc.setType(contextType);
			cc.setParam(param);
			Object object = aut.execute(cc);
			if (!(object instanceof Context)) {
				throw new CoreException(Q7UIPlugin.createStatus(Messages
						.bind(Messages.ContextSnapshotAction_UnexpectedObject,
								object)));
			}
			Context context = (Context) object;
			ContextType type = ContextTypeManager.getInstance()
					.getTypeByContext(context);
			if (type == null || !contextType.equals(type.getId())) {
				throw new CoreException(Q7UIPlugin.createStatus(Messages.bind(
						Messages.ContextSnapshotAction_UnexpectedContextType,
						type, contextType)));
			}
			return context;
		} catch (CoreException e) {
			if (e.getStatus().getException() instanceof EOFException) {
				showPossibleMemoryError();
				return null;
			} else {
				throw e;
			}
		}
	}

	private static void showPossibleMemoryError() {
		Q7UIPlugin.getDisplay().asyncExec(new Runnable() {
			public void run() {
				MessageBox msg = new MessageBox(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), SWT.ERROR);
				msg.setText(Messages.ContextSnapshotAction_ErrorDialogTitle);
				msg.setMessage(Messages.ContextSnapshotAction_ErrorDialogMsg);
				msg.open();
			}
		});
	}

}
