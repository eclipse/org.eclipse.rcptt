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
package org.eclipse.rcptt.ecl.platform.internal.commands;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.commands.FindInWorkspace;
import org.eclipse.rcptt.ecl.platform.util.EclPlatformUtil;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class FindInWorkspaceService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		FindInWorkspace cmd = (FindInWorkspace) command;
		String path = cmd.getPath();
		boolean findAll = cmd.isAll();

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IContainer[] rootResources = root.findContainersForLocationURI(root.getLocationURI());
		List<String> paths = EclPlatformUtil.getWorkspaceResources(rootResources[0], path, findAll);
		for (String resultPath : paths) {
			context.getOutput().write(resultPath);
		}
		return Status.OK_STATUS;
	}

}
