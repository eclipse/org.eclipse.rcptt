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
package org.eclipse.rcptt.ui.internal.resources;

import static java.util.Arrays.asList;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;

import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7ProblemReporter.ProblemType;
import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.persistence.PersistenceManager;
import org.eclipse.rcptt.ctx.resources.ImportUtils;
import org.eclipse.rcptt.ctx.resources.WSUtils;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSLink;
import org.eclipse.rcptt.workspace.WSResource;
import org.eclipse.rcptt.workspace.WorkspaceContext;

public class WSValidators {

	public static void validateContent(final WorkspaceContext ctx,
			final IFile resource, final IQ7ProblemReporter reporter,
			final SubMonitor monitor) {
		final IPersistenceModel model = PersistenceManager.getInstance()
				.getModel(ctx.eResource());
		model.extractAll();
		WSUtils.visitWorkspace(ctx, monitor, new Predicate<WSResource>() {
			@Override
			public boolean apply(WSResource input) {
				if (monitor.isCanceled())
					return true;
				if (input instanceof WSFile) {
					
					String name = ImportUtils.getName((WSFile) input);
					try {
						WSUtils.getFileStream(null, (WSFile) input, model)
								.close();
					} catch (IOException e) {
						String message = String
								.format("File %s is absent in workspace %s. Please recapture the context or delete broken file.",
										name, ctx.getName());
						reporter.reportProblem(resource, ProblemType.Error,
								message, -1, -1, -1, -1);
					}
				}				
				return false;
			}
		});
	}

	public static boolean validateLink(WSLink link, IFile resource,
			IQ7ProblemReporter reporter) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(link.getProject());
		if (project == null || !project.exists()) {
			if (reporter != null)
				reporter.reportProblem(
						resource,
						ProblemType.Error,
						String.format(
								"Can not resolve \"%s\" project from link \"%s/%s\".",
								link.getProject(), link.getProject(),
								link.getPath()), -1, -1, -1, -1);
			return false;
		}

		if (resource != null)
			try {
				IProject thisProject = resource.getProject();
				if (!project.equals(thisProject)
						&& !asList(thisProject.getReferencedProjects())
								.contains(project)) {
					if (reporter != null)
						reporter.reportProblem(
								resource,
								ProblemType.Error,
								String.format(
										"\"%s\" project from link \"%s/%s\" is not referenced by project \"%s\".",
										link.getProject(), link.getProject(),
										link.getPath(), thisProject.getName()),
								-1, -1, -1, -1);
					return false;
				}
			} catch (CoreException e) {
				RcpttPlugin.log(e);
				if (reporter != null)
					reporter.reportProblem(resource, ProblemType.Error, String
							.format(e.getMessage(), link.getProject(),
									link.getProject(), link.getPath()), -1, -1,
							-1, -1);
				return false;
			}

		IResource member = project.findMember(link.getPath());
		if (member == null || !member.exists()) {
			if (reporter != null)
				reporter.reportProblem(
						resource,
						ProblemType.Error,
						String.format(
								"Can not resolve \"%s\" file or directory from link \"%s/%s\".",
								link.getPath(), link.getProject(),
								link.getPath()), -1, -1, -1, -1);
			return false;
		}

		return true;
	}

	public static void validateLinks(WorkspaceContext ctx,
			final IFile resource, final IQ7ProblemReporter reporter,
			SubMonitor monitor) {
		WSUtils.visitWorkspace(ctx, monitor, new Predicate<WSResource>() {
			@Override
			public boolean apply(WSResource input) {
				if (input instanceof WSLink) {
					validateLink((WSLink) input, resource, reporter);
				}
				return false;
			}
		});
	}

}
