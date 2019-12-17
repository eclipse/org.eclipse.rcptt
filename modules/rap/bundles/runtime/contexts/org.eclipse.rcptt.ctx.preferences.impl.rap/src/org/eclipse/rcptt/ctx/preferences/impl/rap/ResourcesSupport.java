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
package org.eclipse.rcptt.ctx.preferences.impl.rap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import org.eclipse.rcptt.preferences.PrefNode;

public class ResourcesSupport {

	public static void checkProjectExistance(PrefNode child, Throwable e)
			throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(child.getName());
		if (!project.exists()) {
			throw new CoreException(Activator.createStatus(
					"Could not apply preferences for not existed project: "
							+ child.getName(), e));
		}
	}

}
