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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.rcptt.internal.launching.PrepareExecutionWrapper;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.ui.launching.LaunchUtils;

public class RunSelectedAction extends Q7ExecutionViewAction {

	public RunSelectedAction(ISelectionProvider selectionProvider) {
		setToolTipText(Messages.RunSelectedAction_ToolTip);
		setText("&Run");
		setImageDescriptor(Images.getImageDescriptor(Images.PLAY));
		setDisabledImageDescriptor(Images.getImageDescriptor(Images.PLAY_D));
		this.selectionProvider = selectionProvider;
	}

	@Override
	public void run() {
		List<IExecutable> toExecute = getExecutables();

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

	private List<IExecutable> getExecutables() {
		List<IExecutable> topExecutables = new ArrayList<IExecutable>();

		IStructuredSelection selection = (IStructuredSelection) selectionProvider
				.getSelection();
		for (Iterator<?> it = selection.iterator(); it.hasNext();) {
			processExecutable((IExecutable) it.next(), topExecutables);
		}

		return topExecutables;
	}

	private void processExecutable(IExecutable executable,
			List<IExecutable> topExecutables) {
		for (Iterator<IExecutable> it = topExecutables.iterator(); it.hasNext();) {
			IExecutable topExecutable = it.next();
			if (isInChilds(topExecutable, executable)) {
				return;
			} else if (isInChilds(executable, topExecutable)) {
				it.remove();
				break;
			}
		}
		IExecutable parent = executables.getParent(executable);
		if (parent != null && !(executable instanceof PrepareExecutionWrapper)) {
			topExecutables.add(parent);
		} else {
			topExecutables.add(executable);
		}
	}

	private boolean isInChilds(IExecutable parent, IExecutable executable) {
		for (IExecutable child : parent.getChildren()) {
			if (executable.equals(child)) {
				return true;
			} else if (isInChilds(child, executable)) {
				return true;
			}
		}
		return false;
	}
}
