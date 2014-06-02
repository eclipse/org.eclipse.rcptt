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
package org.eclipse.rcptt.core.internal.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;

import org.eclipse.rcptt.core.nature.RcpttNature;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class UpdateBuildersJob extends Job {
	public UpdateBuildersJob() {
		super("RCPTT: Update builders");
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		monitor.beginTask("Update RCPTT builders association",
				projects.length * 10);
		for (IProject iProject : projects) {
			if (iProject.isAccessible()) {
				try {
					if (RcpttNature.isRcpttProject(iProject)) {
						if (!Q7Builder.hasBuilder(iProject)) {
							Q7Builder.enableFor(iProject);
							iProject.build(BUILD, new SubProgressMonitor(
									monitor, 10));
							continue;
						}
					}
				} catch (CoreException e) {
					RcpttPlugin.log(e);
				}
			}
			monitor.worked(10);
		}
		monitor.done();

		return Status.OK_STATUS;
	}
	@Override
	public boolean belongsTo(Object family) {
		if( family != null && family.equals(UpdateBuildersJob.class)) {
			return true;
		}
		return super.belongsTo(family);
	}
}
