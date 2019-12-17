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
package org.eclipse.rcptt.search;

import org.eclipse.core.resources.IResource;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.text.FileTextSearchScope;
import org.eclipse.search.ui.text.TextSearchQueryProvider;
import org.eclipse.ui.IWorkingSet;

import org.eclipse.rcptt.search.Q7SearchPageImpl.Q7SearchPageInput;

public class Q7SearchQueryProvider extends TextSearchQueryProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.text.TextSearchQueryProvider#createQuery(
	 * TextSearchInput)
	 */
	public ISearchQuery createQuery(Q7SearchPageInput input) {
		FileTextSearchScope scope = input.getScope();
		String text = input.getSearchText();
		boolean regEx = input.isRegExSearch();
		boolean caseSensitive = input.isCaseSensitiveSearch();
		int searchFor = input.getSearchFor();

		return new Q7SearchQuery(text, regEx, caseSensitive, scope, searchFor);
	}

	@Override
	public ISearchQuery createQuery(TextSearchInput input) {
		FileTextSearchScope scope = input.getScope();
		String text = input.getSearchText();
		boolean regEx = input.isRegExSearch();
		boolean caseSensitive = input.isCaseSensitiveSearch();

		return new Q7SearchQuery(text, regEx, caseSensitive, scope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.search.ui.text.TextSearchQueryProvider#createQuery(java.lang
	 * .String)
	 */
	public ISearchQuery createQuery(String searchForString) {
		FileTextSearchScope scope = FileTextSearchScope.newWorkspaceScope(
				getPreviousFileNamePatterns(), false);
		return new Q7SearchQuery(searchForString, false, true, scope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.search.ui.text.TextSearchQueryProvider#createQuery(java.lang
	 * .String, org.eclipse.core.resources.IResource[])
	 */
	public ISearchQuery createQuery(String selectedText, IResource[] resources) {
		FileTextSearchScope scope = FileTextSearchScope.newSearchScope(
				resources, getPreviousFileNamePatterns(), false);
		return new Q7SearchQuery(selectedText, false, true, scope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.search.ui.text.TextSearchQueryProvider#createQuery(java.lang
	 * .String, org.eclipse.ui.IWorkingSet[])
	 */
	public ISearchQuery createQuery(String selectedText, IWorkingSet[] ws) {
		FileTextSearchScope scope = FileTextSearchScope.newSearchScope(ws,
				getPreviousFileNamePatterns(), false);
		return new Q7SearchQuery(selectedText, false, true, scope);
	}

	private String[] getPreviousFileNamePatterns() {
		return new String[] { "*.scenario" }; //$NON-NLS-1$
	}

}
