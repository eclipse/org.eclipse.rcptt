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
package org.eclipse.rcptt.runner.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.utils.SortingUtils;
import org.eclipse.rcptt.launching.IExecutable;

public class TestSuite {

	private int limit = -1;

	public TestSuite(final IProject project) {
		this.project = project;
		executables = new ArrayList<IQ7NamedElement>();
	}

	public void add(ITestCase tcase) {
		if (!executables.contains(tcase)) {
			executables.add(tcase);
		}
	}

	public void sort() {
		SortingUtils.sortNamedElements(executables);
	}

	public void setLimit(int limit) {
		if (this.limit == -1) {
			this.limit = limit;
		} else {
			// Make sure command-line settings do not override limit set by licensing
			if (limit == -1) {
				limit = Integer.MAX_VALUE;
			}
			this.limit = Math.min(limit, this.limit);
		}
	}

	public int getLimit() {
		return limit;
	}
	public IProject getProject() {
		return project;
	}

	public List<IQ7NamedElement> getScenarios() {
		if (limit == -1) {
			return executables;
		} else {
			int to = limit;
			if (to > executables.size()) {
				to = executables.size();
			}
			return new ArrayList<IQ7NamedElement>(executables.subList(0, to));
		}
	}

	private final IProject project;

	private final List<IQ7NamedElement> executables;

	/**
	 * this field is accessed by ScenarioRunnable, potentially from different
	 * threads (??)
	 */
	public final Map<IQ7NamedElement, IExecutable[]> executablesMap = Collections
			.synchronizedMap(new HashMap<IQ7NamedElement, IExecutable[]>());

	private boolean opensource = false;

	public boolean isOpensource() {
		return opensource;
	}

	public void setOpensource(boolean opensource) {
		this.opensource = opensource;
	}
}
