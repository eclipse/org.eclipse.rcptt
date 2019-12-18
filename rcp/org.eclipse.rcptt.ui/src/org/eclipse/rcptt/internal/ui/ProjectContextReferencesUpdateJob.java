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
package org.eclipse.rcptt.internal.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.eclipse.rcptt.core.model.IQ7Element.HandleType;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.search.ISearchScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.core.model.OneProjectScope;
import org.eclipse.rcptt.ui.dialogs.RemoveAllProjectReferencesDialog;

public class ProjectContextReferencesUpdateJob extends Job {
	private IQ7Project project;

	public ProjectContextReferencesUpdateJob(IQ7Project project) {
		super("Update Project Context/Verification references");
		this.project = project;
	}

	@Override
	public boolean belongsTo(Object family) {
		return super.belongsTo(family);
	}

	private static Collection<IQ7NamedElement> filterOutProjectMetadata(IQ7NamedElement[] elements) {
		return Collections2.filter(Arrays.asList(elements),
				new Predicate<IQ7NamedElement>() {
					public boolean apply(IQ7NamedElement input) {
						return input.getElementType() != HandleType.ProjectMetadata;
					}
				});
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			IQ7ProjectMetadata metadata = project.getMetadata();
			final Set<IQ7NamedElement> elementsToProceed = new HashSet<IQ7NamedElement>();
			ISearchScope scope = new OneProjectScope(project);

			String[] contexts = metadata.exists()?metadata.getContexts():new String[0];
			for (String el : contexts) {
				IQ7NamedElement[] elements = Q7SearchCore.findContextUsage(el,
						scope, new NullProgressMonitor());
				if (elements != null) {
					elementsToProceed.addAll(filterOutProjectMetadata(elements));
				}

			}

			String[] verifications = metadata.getVerifications();
			for (String el : verifications) {
				IQ7NamedElement[] elements = Q7SearchCore.findVerificationUsage(el,
						scope, new NullProgressMonitor());
				if (elements != null) {
					elementsToProceed.addAll(filterOutProjectMetadata(elements));
				}

			}

			if (elementsToProceed.size() > 0) {
				PlatformUI.getWorkbench().getDisplay()
						.asyncExec(new Runnable() {
							public void run() {
								RemoveAllProjectReferencesDialog.open(
										PlatformUI.getWorkbench()
												.getWorkbenchWindows()[0]
												.getShell(), project,
										new ArrayList<IQ7NamedElement>(
												elementsToProceed));
							}
						});
			}
		} catch (Exception e) {
			RcpttPlugin.log(e);
		}
		return Status.OK_STATUS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectContextReferencesUpdateJob other = (ProjectContextReferencesUpdateJob) obj;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}

	public Object getFamily() {
		return this;
	}
}
