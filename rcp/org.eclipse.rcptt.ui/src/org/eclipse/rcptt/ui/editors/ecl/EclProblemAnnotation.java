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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.jface.text.quickassist.IQuickFixableAnnotation;
import org.eclipse.jface.text.source.Annotation;

import org.eclipse.rcptt.core.builder.Q7ProblemSources;
import org.eclipse.rcptt.core.internal.builder.Q7Problem;

public class EclProblemAnnotation extends Annotation implements
		IQuickFixableAnnotation {
	private Q7Problem problem;

	public EclProblemAnnotation(String annotationType, Q7Problem problem) {
		super(annotationType, false, problem.getMessage());
		this.problem = problem;
	}

	public Q7Problem getProblem() {
		return problem;
	}

	@Override
	public void setQuickFixable(boolean state) {

	}

	@Override
	public boolean isQuickFixableStateSet() {
		return true;
	}

	@Override
	public boolean isQuickFixable() throws AssertionFailedException {
		return Q7ProblemSources.isQuickFixable(problem.getSourceId());
	}
}
