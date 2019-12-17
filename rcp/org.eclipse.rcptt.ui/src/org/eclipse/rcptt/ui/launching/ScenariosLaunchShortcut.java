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
package org.eclipse.rcptt.ui.launching;

import org.eclipse.core.resources.IResource;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.ui.navigator.Q7Explorer;

public class ScenariosLaunchShortcut implements ILaunchShortcut {

	public void launch(ISelection selection, String mode) {
		IResource[] resources;
		IWorkbenchPart part = getActiveWorkbenchPart();
		if (part instanceof Q7Explorer) {
			resources = ((Q7Explorer) part).filterSelectedResources();
		} else {
			resources = LaunchUtils.getContext(selection);
		}
		LaunchUtils.launchContext(resources, mode);
	}

	public void launch(IEditorPart editor, String mode) {
		IResource[] resources = LaunchUtils.getContext(editor);
		LaunchUtils.launchContext(resources, mode);
	}

	private IWorkbenchPart getActiveWorkbenchPart() {
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window != null) {
			IWorkbenchPage page = window.getActivePage();
			if (page != null) {
				return page.getActivePart();
			}
		}
		return null;
	}

}
