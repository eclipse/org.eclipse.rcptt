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
package org.eclipse.rcptt.replace;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.search.internal.ui.SearchMessages;
import org.eclipse.search.ui.IReplacePage;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IWorkbenchPage;

import org.eclipse.rcptt.search.Q7SearchPageImpl;
import org.eclipse.rcptt.search.Q7SearchQuery;
import org.eclipse.rcptt.search.Q7SearchResult;
import org.eclipse.rcptt.search.Q7SearchResultPage;

@SuppressWarnings("restriction")
public class Q7SearchPageReplaceImpl extends Q7SearchPageImpl implements
		IReplacePage {

	private static final String REPLACE_NOT_SUPPORTED = "Could not perform replace."; //$NON-NLS-1$
	private static final String REPLACE_NOT_SUPPORTED_REASON = "Replace for tags, contexts and verifications is not supported."; //$NON-NLS-1$	

	public boolean performReplace() {

		if (getSearchFor() == Q7SearchQuery.TAGS
				|| getSearchFor() == Q7SearchQuery.CONTEXTS
				|| getSearchFor() == Q7SearchQuery.VERIFICATIONS) {
			ErrorDialog.openError(getShell(),
					SearchMessages.TextSearchPage_replace_searchproblems_title,
					REPLACE_NOT_SUPPORTED, new Status(Status.WARNING,
							PLUGIN_ID, REPLACE_NOT_SUPPORTED_REASON));
			return false;
		}

		try {
			IStatus status = NewSearchUI.runQueryInForeground(getContainer()
					.getRunnableContext(), newQuery());
			if (status.matches(IStatus.CANCEL)) {
				return false;
			}
			if (!status.isOK()) {
				ErrorDialog
						.openError(
								getShell(),
								SearchMessages.TextSearchPage_replace_searchproblems_title,
								SearchMessages.TextSearchPage_replace_runproblem_message,
								status);
			}

			ISearchResultViewPart view = NewSearchUI.activateSearchResultView();
			if (view != null) {
				ISearchResultPage page = view.getActivePage();
				if (page instanceof Q7SearchResultPage) {
					Q7SearchResultPage filePage = (Q7SearchResultPage) page;
					final Q7SearchResult searchResult = (Q7SearchResult) filePage
							.getInput();
					ReplaceDialog replaceDlg = new ReplaceDialog(getShell());
					String replaceHint = ReplaceSearchResult
							.getReplaceHint(searchResult);
					if (searchResult.getMatchCount() > 0
							&& replaceDlg.open(replaceHint, getPattern()) == Dialog.OK) {
						IWorkbenchPage wbPage = filePage.getSite().getPage();
						ReplaceSearchResult.ReplaceInBackground(searchResult,
								replaceDlg.getReplaceString(), wbPage);
					}
				}
			}

			return true;
		} catch (CoreException e) {
			ErrorDialog
					.openError(
							getShell(),
							SearchMessages.TextSearchPage_replace_searchproblems_title,
							SearchMessages.TextSearchPage_replace_querycreationproblem_message,
							e.getStatus());
			return false;
		}
	}
}
