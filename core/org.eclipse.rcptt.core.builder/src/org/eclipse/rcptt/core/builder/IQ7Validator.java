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
package org.eclipse.rcptt.core.builder;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.core.model.IQ7NamedElement;

public interface IQ7Validator {
	/**
	 * Validate stored q7 element
	 */
	void validate(IQ7NamedElement element, IQ7ProblemReporter reporter,
			IProgressMonitor monitor);
	
	/**
	 * Reconcile working copy of q7 element
	 * @param string
	 * @param reporter
	 * @param nullProgressMonitor
	 */
	void reconcile(IQ7NamedElement content, String eclCode, IQ7ProblemReporter reporter,
			IProgressMonitor nullProgressMonitor);
}
