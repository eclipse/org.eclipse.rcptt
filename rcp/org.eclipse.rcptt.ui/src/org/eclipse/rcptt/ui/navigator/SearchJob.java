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
package org.eclipse.rcptt.ui.navigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.search.Matcher;

public class SearchJob extends Job {
	public interface ResultListener {
		public void resultAdded(final IQ7NamedElement result);
	}

	private final List<ResultListener> listeners = new ArrayList<ResultListener>();
	private final List<Matcher> matchers;

	private String query = ""; //$NON-NLS-1$

	public SearchJob() {
		super(Messages.SearchJob_Name);
		setRule(ResourcesPlugin.getWorkspace().getRoot());
		setUser(true);

		matchers = new ArrayList<Matcher>();
		for (final IConfigurationElement el : Platform.getExtensionRegistry()
				.getConfigurationElementsFor("org.eclipse.rcptt.ui.searchMatchers")) { //$NON-NLS-1$

			try {
				matchers.add((Matcher) el.createExecutableExtension("class")); //$NON-NLS-1$
			} catch (CoreException e) {
				Q7UIPlugin.log(e);
			}
		}
	}

	@Override
	protected IStatus run(IProgressMonitor pm) {
		final SubMonitor monitor = SubMonitor.convert(pm);
		// monitor.beginTask(Messages.SearchJob_TaskName, 1);
		try {
			doSearch(monitor);
		} finally {
			pm.done();
		}

		return Status.OK_STATUS;
	}

	private void doSearch(final SubMonitor monitor) {
		IQ7NamedElement[] allElements = Q7SearchCore.findAllElements();
		monitor.beginTask(Messages.SearchJob_TaskName, allElements.length);
		for (IQ7NamedElement iq7NamedElement : allElements) {
			if (searchInObject(iq7NamedElement, monitor.newChild(1))) {
				fireAdded(iq7NamedElement);
			}
		}
	}

	private void fireAdded(IQ7NamedElement o) {
		for (final ResultListener listener : listeners) {
			listener.resultAdded(o);
		}
	}

	private boolean searchInObject(final IQ7NamedElement o,
			final SubMonitor monitor) {
		monitor.beginTask(Messages.SearchJob_TaskName, matchers.size());

		for (final Matcher matcher : matchers) {
			if (monitor.isCanceled()) {
				return false;
			}

			SubMonitor child = monitor.newChild(1);
			child.beginTask("Match", 100);
			try {
				if (matcher.matches(o, query, child)) {
					return true;
				}
			} finally {
				child.done();
			}
		}
		monitor.done();
		return false;
	}

	public void addResultListener(final ResultListener listener) {
		this.listeners.add(listener);
	}

	public void setQuery(final String query) {
		this.query = query.toLowerCase();
	}
}
