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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.rcptt.ui.launching.LaunchUtils;

public class GeneratePomAction extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IResource[] resources = LaunchUtils.getContext(HandlerUtil
				.getCurrentSelection(event));
		if (resources.length == 0) {
			return null;
		}
		IProject project = resources[0].getProject();
		IFile pomFile = project.getFile("pom.xml");
		try {
			// Refreshing just in case it has been created outside of Q7 on file
			// system
			pomFile.refreshLocal(IResource.DEPTH_ZERO, null);

			if (!pomFile.exists()) {
				pomFile.create(getClass().getResourceAsStream("pom.xml"), true,
						null);

			} else {
				MessageDialog.openError(null, "Error generating POM file",
						String.format("pom.xml already exists in project '%s'",
								project.getName()));
			}
		} catch (CoreException e) {
			// Should not happen
			throw new ExecutionException("Error creating pom.xml", e);
		}
		return null;
	}
}
