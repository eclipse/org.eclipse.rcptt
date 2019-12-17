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
package org.eclipse.rcptt.testing;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.testing.commands.ApplyContext;
import org.eclipse.rcptt.ui.launching.LaunchUtils;

public class ApplyContextService implements ICommandService {

	
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof ApplyContext)) {
			return Status.CANCEL_STATUS;
		}

		String path = ((ApplyContext) command).getPath();
		final IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(path));
		if (!file.exists()) {
			return TestingPlugin.createErrStatus(String.format(
					"Context %s does not exist", path));
		}

		LaunchUtils.execute(file, false);

		return Status.OK_STATUS;
	}

}
