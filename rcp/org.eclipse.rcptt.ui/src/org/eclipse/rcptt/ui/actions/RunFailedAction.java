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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.ui.launching.LaunchUtils;

public class RunFailedAction extends Q7ExecutionViewAction {

	private List<IExecutable> toExecute = new ArrayList<IExecutable>();

	public RunFailedAction() {
		setToolTipText(Messages.RunFailedAction_ToolTip);
		setImageDescriptor(Images.getImageDescriptor(Images.RUN_FAILED));
		setDisabledImageDescriptor(Images
				.getImageDescriptor(Images.RUN_FAILED_D));
	}

	public void updateEnablement(IExecutionSession session) {
		toExecute = new ArrayList<IExecutable>();
		if (session != null) {
			IExecutable[] executables = session.getTestCases();
			for (IExecutable iExecutable : executables) {
				if (iExecutable.getStatus() != IExecutable.PASSED) {
					toExecute.add(iExecutable);
				}
			}
		}
		setEnabled(toExecute.size() > 0 && !session.isRunning());
	}

	@Override
	public void run() {
		List<IFile> files = new ArrayList<IFile>();
		Map<String, List<List<String>>> variants = new HashMap<String, List<List<String>>>();
		for (IExecutable executable : toExecute) {
			IFile file = (IFile) executable.getActualElement().getResource();
			if (file != null && !files.contains(file)) {
				files.add(file);
			}
			updateVariant(variants, executable);
		}
		if (files.size() > 0) {
			LaunchUtils
					.launchContext(files.toArray(new IResource[files.size()]),
							"run", variants); //$NON-NLS-1$
		}
	}

}
