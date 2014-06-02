/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.VerificationTypeManager;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.core.scenario.WidgetVerification;
import org.eclipse.rcptt.core.ecl.core.model.CreateVerification;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.ecl.core.model.SetQ7Features;
import org.eclipse.rcptt.internal.launching.Q7LaunchManager;
import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.ui.editors.IQ7Editor;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.recording.WidgetPicker;
import org.eclipse.rcptt.util.StringUtils;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;

public class VerificationSnapshotAction extends Action {

	private final IQ7Editor<Verification> editor;
	private boolean join = false;
	private IStatus status = Status.OK_STATUS;
	private final Shell parentShell;
	private final String selector;

	public VerificationSnapshotAction(Shell parentShell, IQ7Editor<Verification> editor, String selector) {
		this.parentShell = parentShell;
		this.selector = selector;
		setImageDescriptor(Images.getImageDescriptor(Images.SNAPSHOT));
		setToolTipText(Messages.VerificationSnapshotAction_ToolTip);
		this.editor = editor;
	}

	@Override
	public void run() {
		final AutLaunch aut = LaunchUtils.selectAutLaunch();

		if (editor.getElement() instanceof IVerification) {
			NamedElement namedElement;
			try {
				namedElement = editor.getElement().getNamedElement();
			} catch (ModelException e1) {
				status = e1.getStatus();
				return;
			}

			if (namedElement instanceof WidgetVerification) {
				final WidgetVerification verification = (WidgetVerification) namedElement;
				if (selector != null)
					verification.setSelector(selector);

				if (StringUtils.isBlank(verification.getSelector())) {
					VerificationType type = VerificationTypeManager.getInstance().
							getTypeByVerification(verification);
					String selector = WidgetPicker.activate(parentShell,
							(BaseAutLaunch) aut, type);
					if (selector != null)
						verification.setSelector(selector);
					else {
						status = Status.CANCEL_STATUS;
						return;
					}
				}
			}
		}

		final Job job = new Job(Messages.VerificationSnapshotAction_Job) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("", 2); //$NON-NLS-1$

				final EObject verificationParam;
				try {
					verificationParam = editor.getCreateParam(aut);
				} catch (CoreException ex) {
					return ex.getStatus();
				}

				IVerification verification = (IVerification) editor.getElement();
				try {
					VerificationType type = verification.getType();
					monitor.worked(1);
					final Verification newVerification = createSnapshot(aut,
							type.getId(), verificationParam);
					if (newVerification != null) {
						final IWorkspaceRunnable operation = new IWorkspaceRunnable() {
							public void run(IProgressMonitor monitor)
									throws CoreException {
								editor.copyContentFrom(newVerification,
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
		IVerification verification = (IVerification) editor.getElement();
		VerificationType type;
		try {
			type = verification.getType();
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

	public static Verification createSnapshot(AutLaunch aut, String verificationType,
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
			CreateVerification cc = Q7CoreFactory.eINSTANCE.createCreateVerification();
			cc.setType(verificationType);
			cc.setParam(param);
			Object object = aut.execute(cc);
			if (!(object instanceof Verification)) {
				throw new CoreException(Q7UIPlugin.createStatus(Messages
						.bind(Messages.VerificationSnapshotAction_UnexpectedObject,
								object)));
			}
			return (Verification) object;
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
				msg.setText(Messages.VerificationSnapshotAction_ErrorDialogTitle);
				msg.setMessage(Messages.VerificationSnapshotAction_ErrorDialogMsg);
				msg.open();
			}
		});
	}

}
