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
package org.eclipse.rcptt.extensions.ecl.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.IViewDescriptor;

import commands.CommandsFactory;
import commands.View;

public class ShowViewsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final List<View> views = new ArrayList<View>();
		workbench.getDisplay().syncExec(new Runnable() {
			public void run() {
				for (IViewDescriptor descriptor : workbench.getViewRegistry()
						.getViews()) {
					View view = CommandsFactory.eINSTANCE.createView();
					view.setId(descriptor.getId());
					view.setLabel(descriptor.getLabel());
					view.setDescription(descriptor.getLabel());
					views.add(view);
				}
			}
		});
		IPipe output = context.getOutput();
		for (View view : views) {
			output.write(view);
		}
		return Status.OK_STATUS;
	}

}
