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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.search.Matcher;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WSRoot;
import org.eclipse.rcptt.workspace.WorkspaceContext;
import org.eclipse.rcptt.workspace.util.WorkspaceSwitch;

public class WorkspaceContextMatcher implements Matcher {

	public boolean matches(IQ7NamedElement object, String query,
			SubMonitor monitor) {
		if (!(object instanceof IContext)) {
			return false;
		}
		String type = Q7SearchCore.findContextTypeByDocument((IContext)object);
		if (type == null && object instanceof IContext) {
			try {
				type = ((IContext) object).getType().getId();
			} catch (ModelException e) {
				RcpttPlugin.log(e);
			}
		}
		if (type != null && !type.equals("org.eclipse.rcptt.workspace.context")) {
			return false;
		}
		try {
			NamedElement ctx = object.getNamedElement();
			if (ctx instanceof WorkspaceContext) {
				final WorkspaceContext context = (WorkspaceContext) ctx;
				final SearchSwitch sw = new SearchSwitch(query, monitor);
				try {
					return sw.doSwitch(context.getContent());
				} catch (OperationCanceledException oce) {
					return false;
				}
			}
			return false;
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
			return false;
		}
	}

	private static class SearchSwitch extends WorkspaceSwitch<Boolean> {
		private final String query;
		private final IProgressMonitor monitor;

		public SearchSwitch(final String query, final IProgressMonitor monitor) {
			this.query = query.toLowerCase();
			this.monitor = monitor;
		}

		@Override
		public Boolean caseWSFile(WSFile object) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			return object.getName().toLowerCase().contains(query);
		}

		@Override
		public Boolean caseWSFolder(WSFolder object) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			if (object.getName().toLowerCase().contains(query)) {
				return true;
			}

			for (final WSFile file : object.getFiles()) {
				if (caseWSFile(file)) {
					return true;
				}
			}
			for (final WSFolder file : object.getFolders()) {
				if (caseWSFolder(file)) {
					return true;
				}
			}

			return false;
		}

		@Override
		public Boolean caseWSProject(WSProject object) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			if (object.getName().toLowerCase().contains(query)) {
				return true;
			}

			for (final WSFile file : object.getFiles()) {
				if (caseWSFile(file)) {
					return true;
				}
			}
			for (final WSFolder file : object.getFolders()) {
				if (caseWSFolder(file)) {
					return true;
				}
			}

			return false;
		}

		@Override
		public Boolean caseWSRoot(WSRoot object) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			for (final WSProject project : object.getProjects()) {
				if (caseWSProject(project)) {
					return true;
				}
			}
			return false;
		}

	}
}
