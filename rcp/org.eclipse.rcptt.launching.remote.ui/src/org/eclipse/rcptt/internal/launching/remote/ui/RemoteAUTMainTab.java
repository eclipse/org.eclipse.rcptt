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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class RemoteAUTMainTab extends AbstractLaunchConfigurationTab {

	private AUTArgumentsBlock fLocationBlock;
	// private ILaunchConfigurationTab[] tabs;
	// private RemoteTabGroup group;
	private final Job validateJob = new Job("Connection validate job") {
		{
			setSystem(true);
		}
		@Override
		protected IStatus run(IProgressMonitor monitor) {
			String lastMessage = getErrorMessage();
			String msg = fLocationBlock.validate();
			if ((msg == null && lastMessage == null) || msg != null && msg.equals(lastMessage)) {
				return Status.OK_STATUS;
			}
			setErrorMessage(msg);
			final Control control = RemoteAUTMainTab.super.getControl();
			if (control.isDisposed()) {
				return Status.OK_STATUS;
			}
			control.getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					if (!control.isDisposed()) {
						updateLaunchConfigurationDialog();
					}
				}
			});
			return Status.OK_STATUS;
		}
		
	};


	public RemoteAUTMainTab() {
		super();
		createLocationBlock();
	}

	@Override
	protected long getUpdateJobDelay() {
		return 200;
	}

	@Override
	protected void updateLaunchConfigurationDialog() {
		validateJob.cancel();
		validateJob.schedule();
		super.updateLaunchConfigurationDialog();
	}

	private void createLocationBlock() {
		fLocationBlock = new AUTArgumentsBlock(this);
	}

	@Override
	public void createControl(Composite parent) {
		final ScrolledComposite scrollContainer = new ScrolledComposite(parent,
				SWT.V_SCROLL);
		scrollContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite composite = new Composite(scrollContainer, SWT.NONE);
		scrollContainer.setContent(composite);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		fLocationBlock.createControl(composite);

		// Add listener for each control to recalculate scroll bar when it is
		// entered.
		// This results in scrollbar scrolling when user tabs to a control that
		// is not in the field of view.
		Listener listener = new Listener() {
			@Override
			public void handleEvent(Event e) {
				Control child = (Control) e.widget;
				Rectangle bounds = child.getBounds();
				Rectangle area = scrollContainer.getClientArea();
				Point origin = scrollContainer.getOrigin();
				if (origin.x > bounds.x)
					origin.x = Math.max(0, bounds.x);
				if (origin.y > bounds.y)
					origin.y = Math.max(0, bounds.y);
				if (origin.x + area.width < bounds.x + bounds.width)
					origin.x = Math
							.max(0, bounds.x + bounds.width - area.width);
				if (origin.y + area.height < bounds.y + bounds.height)
					origin.y = Math.max(0, bounds.y + bounds.height
							- area.height);
				scrollContainer.setOrigin(origin);
			}
		};
		Control[] controls = composite.getChildren();
		for (int i = 0; i < controls.length; i++)
			controls[i].addListener(SWT.Activate, listener);

		Dialog.applyDialogFont(composite);
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrollContainer.setExpandHorizontal(true);
		setControl(scrollContainer);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration config) {
		fLocationBlock.initializeFrom(config);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy config) {
		fLocationBlock.performApply(config);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		fLocationBlock.setDefaults(config);
	}

	@Override
	public String getName() {
		return "Remote AUT Launch configuration";
	}
}
