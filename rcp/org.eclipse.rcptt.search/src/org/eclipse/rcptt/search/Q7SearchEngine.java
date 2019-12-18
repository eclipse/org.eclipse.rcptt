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
package org.eclipse.rcptt.search;

import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.search.core.text.TextSearchEngine;
import org.eclipse.search.core.text.TextSearchRequestor;
import org.eclipse.search.core.text.TextSearchScope;

/**
 * Search engine for Q7 scenarios, class is singleton by default search in
 * scenario script, specify searchFor for search in other scenario part
 * (description, tags, contexts)
 */
public class Q7SearchEngine extends TextSearchEngine {

	private static Q7SearchEngine instance;

	protected Q7SearchEngine() {
	}

	public static Q7SearchEngine getDefault() {
		if (instance == null) {
			instance = new Q7SearchEngine();
		}
		return instance;
	}

	@Override
	public IStatus search(TextSearchScope scope, TextSearchRequestor requestor,
			Pattern searchPattern, IProgressMonitor monitor) {
		return new Q7SearchVisitor(requestor, searchPattern).search(scope,
				monitor);
	}

	public IStatus search(TextSearchScope scope, TextSearchRequestor requestor,
			Pattern searchPattern, IProgressMonitor monitor, int searchFor,
			String contextName) {
		return new Q7SearchVisitor(requestor, searchPattern, searchFor,
				contextName).search(scope, monitor);
	}

	@Override
	public IStatus search(IFile[] scope, TextSearchRequestor requestor,
			Pattern searchPattern, IProgressMonitor monitor) {
		return new Q7SearchVisitor(requestor, searchPattern).search(scope,
				monitor);
	}

	public IStatus search(IFile[] scope, TextSearchRequestor requestor,
			Pattern searchPattern, IProgressMonitor monitor, int searchFor,
			String contextName) {
		return new Q7SearchVisitor(requestor, searchPattern, searchFor,
				contextName).search(scope, monitor);
	}

}
