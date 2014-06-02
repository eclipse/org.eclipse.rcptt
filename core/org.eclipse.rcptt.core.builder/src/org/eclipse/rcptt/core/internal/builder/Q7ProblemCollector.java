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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.SubProgressMonitor;

import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;

public class Q7ProblemCollector implements IQ7ProblemReporter {
	Map<IFile, List<Q7Problem>> problems = new HashMap<IFile, List<Q7Problem>>();

	public synchronized void reportProblem(IFile element, ProblemType type,
			String message, int line, int offset, int length, int sourceId) {
		Q7Problem pr = new Q7Problem(message, line, offset, type.getValue(), length, sourceId);
		List<Q7Problem> list = problems.get(element);
		if (list == null) {
			list = new ArrayList<Q7Problem>();
			problems.put(element, list);
		}
		if (!list.contains(pr)) {
			list.add(pr);
		}
	}

	public synchronized void flushProblems(SubProgressMonitor monitor) {
		monitor.beginTask("Flush problems", problems.size());
		for (IFile element : problems.keySet()) {
			List<Q7Problem> list = problems.get(element);
			for (Q7Problem q7Problem : list) {
				Q7Builder.addMarker(element, q7Problem.getMessage(),
						q7Problem.getLine(), q7Problem.getSeverity(),
						q7Problem.getOffset(), q7Problem.getLength(),
						q7Problem.getSourceId());
			}
		}
		monitor.done();
	}
}
