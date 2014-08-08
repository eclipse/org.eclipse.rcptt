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

import static org.eclipse.rcptt.core.nature.RcpttNature.LEGACY_NATURE_ID;
import static org.eclipse.rcptt.core.nature.RcpttNature.NATURE_ID;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.workspace.ProjectUtil;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class MigrateProjectsJob extends Job {
	private static final IWorkspaceRoot ROOT = ResourcesPlugin.getWorkspace().getRoot();
	private final IContainer resource;

	public MigrateProjectsJob(IContainer resource) {
		super("RCPTT: Migrate Q7 projects");
		this.resource = resource;
		setRule(ROOT);
	}

	private final IResourceVisitor resourceVisitor = new IResourceVisitor() {
		@Override
		public boolean visit(IResource resource) throws CoreException {
			if (resource instanceof IProject) {
				migrate((IProject) resource);
				return false;
			}
			return true;
		}
	};

	void migrate(IProject iProject) {
		try {
			if (!iProject.isAccessible())
				return;
			if (!iProject.hasNature(LEGACY_NATURE_ID))
				return;
			iProject.refreshLocal(IResource.DEPTH_ONE, null);
			if (!iProject.hasNature(LEGACY_NATURE_ID))
				return;
			migrateProperties(iProject);
			migrateNatures(iProject);
		} catch (Throwable e) {
			RcpttPlugin.log(new RuntimeException("Migration of "
					+ iProject.getName() + " failed", e));
		}
	}

	private void migrateNatures(IProject iProject) throws CoreException {
		IProjectDescription description = iProject.getDescription();
		List<String> natures = Lists.newArrayList(description.getNatureIds());
		natures.remove(LEGACY_NATURE_ID);
		if (!natures.contains(NATURE_ID))
			natures.add(NATURE_ID);
		description.setNatureIds(Iterables.toArray(natures, String.class));
		iProject.setDescription(description, null);
	}

	void migrateProperties(IProject project) throws CoreException {
		IFile q7Metadata = project.getFile(new Path(
				IQ7Project.LEGACY_METADATA_NAME));
		if (!q7Metadata.exists())
			return;
		IFile rcpttMetadata = project
				.getFile(new Path(IQ7Project.METADATA_NAME));
		if (!rcpttMetadata.exists())
			q7Metadata.move(rcpttMetadata.getFullPath(), true, null);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			if (!resource.isAccessible())
				return Status.OK_STATUS;
			resource.accept(resourceVisitor);
			return Status.OK_STATUS;
		} catch (CoreException e) {
			return e.getStatus();
		}
	}

	public IStatus runSync() {
		try {
			ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					MigrateProjectsJob.this.run(monitor);
				}
			}, null);
			return Status.OK_STATUS;
		} catch (CoreException e) {
			return e.getStatus();
		}
	}

	@Override
	public boolean belongsTo(Object family) {
		if (family != null && family.equals(ProjectUtil.MIGRATION_FAMILY)) {
			return true;
		}
		return super.belongsTo(family);
	}
}
