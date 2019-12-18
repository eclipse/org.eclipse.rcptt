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

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.search.core.text.TextSearchEngine;
import org.eclipse.search.core.text.TextSearchMatchAccess;
import org.eclipse.search.core.text.TextSearchRequestor;
import org.eclipse.search.internal.core.text.PatternConstructor;
import org.eclipse.search.internal.ui.Messages;
import org.eclipse.search.internal.ui.SearchMessages;
import org.eclipse.search.internal.ui.text.FileMatch;
import org.eclipse.search.internal.ui.text.LineElement;
import org.eclipse.search.internal.ui.text.SearchResultUpdater;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.FileTextSearchScope;
import org.eclipse.search.ui.text.Match;

@SuppressWarnings("restriction")
public class Q7SearchQuery implements ISearchQuery {

	private final static class TextSearchResultCollector extends
			TextSearchRequestor {

		private final AbstractTextSearchResult fResult;
		private final boolean fIsFileSearchOnly;
		private final boolean fSearchInBinaries;
		private ArrayList<FileMatch> fCachedMatches;

		private TextSearchResultCollector(AbstractTextSearchResult result,
				boolean isFileSearchOnly, boolean searchInBinaries) {
			fResult = result;
			fIsFileSearchOnly = isFileSearchOnly;
			fSearchInBinaries = searchInBinaries;

		}

		@Override
		public boolean acceptFile(IFile file) throws CoreException {
			if (fIsFileSearchOnly) {
				fResult.addMatch(new FileMatch(file));
			}
			flushMatches();
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.search.core.text.TextSearchRequestor#reportBinaryFile
		 * (org.eclipse.core.resources.IFile)
		 */
		@Override
		public boolean reportBinaryFile(IFile file) {
			return fSearchInBinaries;
		}

		@Override
		public synchronized boolean acceptPatternMatch(
				TextSearchMatchAccess matchRequestor) throws CoreException {
			int matchOffset = matchRequestor.getMatchOffset();

			LineElement lineElement = getLineElement(matchOffset,
					matchRequestor);
			if (lineElement != null) {
				FileMatch fileMatch = new FileMatch(matchRequestor.getFile(),
						matchOffset, matchRequestor.getMatchLength(),
						lineElement);
				fCachedMatches.add(fileMatch);
			}
			return true;
		}

		private LineElement getLineElement(int offset,
				TextSearchMatchAccess matchRequestor) {
			int lineNumber = 1;
			int lineStart = 0;
			if (!fCachedMatches.isEmpty()) {
				// match on same line as last?
				FileMatch last = fCachedMatches.get(fCachedMatches
						.size() - 1);
				LineElement lineElement = last.getLineElement();
				if (lineElement.contains(offset)) {
					return lineElement;
				}
				// start with the offset and line information from the last
				// match
				lineStart = lineElement.getOffset() + lineElement.getLength();
				lineNumber = lineElement.getLine() + 1;
			}
			if (offset < lineStart) {
				return null; // offset before the last line
			}

			int i = lineStart;
			int contentLength = matchRequestor.getFileContentLength();
			while (i < contentLength) {
				char ch = matchRequestor.getFileContentChar(i++);
				if (ch == '\n' || ch == '\r') {
					if (ch == '\r' && i < contentLength
							&& matchRequestor.getFileContentChar(i) == '\n') {
						i++;
					}
					if (offset < i) {
						String lineContent = getContents(matchRequestor,
								lineStart, i); // include line delimiter
						return new LineElement(matchRequestor.getFile(),
								lineNumber, lineStart, lineContent);
					}
					lineNumber++;
					lineStart = i;
				}
			}
			if (offset < i) {
				String lineContent = getContents(matchRequestor, lineStart, i); // until
																				// end
																				// of
																				// file
				return new LineElement(matchRequestor.getFile(), lineNumber,
						lineStart, lineContent);
			}
			return null; // offset outside of range
		}

		private static String getContents(TextSearchMatchAccess matchRequestor,
				int start, int end) {
			StringBuffer buf = new StringBuffer();
			for (int i = start; i < end; i++) {
				char ch = matchRequestor.getFileContentChar(i);
				if (Character.isWhitespace(ch) || Character.isISOControl(ch)) {
					buf.append(' ');
				} else {
					buf.append(ch);
				}
			}
			return buf.toString();
		}

		@Override
		public void beginReporting() {
			fCachedMatches = new ArrayList<FileMatch>();
		}

		@Override
		public void endReporting() {
			flushMatches();
			fCachedMatches = null;
		}

		private void flushMatches() {
			if (!fCachedMatches.isEmpty()) {
				fResult.addMatches(fCachedMatches
						.toArray(new Match[fCachedMatches.size()]));
				fCachedMatches.clear();
			}
		}
	}

	public final static int SCRIPT = 0;
	public final static int DESCRIPTION = 1;
	public final static int TAGS = 2;
	public final static int CONTEXTS = 3;
	public final static int VERIFICATIONS = 4;
	public final static int CONTEXTS_BY_ID = 5;
	public final static int TESTCASE_BY_ID = 6;
	public final static int VERIFICATION_BY_ID = 7;

	private final FileTextSearchScope fScope;
	private final String fSearchText;
	private final boolean fIsRegEx;
	private final boolean fIsCaseSensitive;
	private int fSearchFor;

	private String fQ7ElementName;

	protected void setQ7ElementName(String q7ElementName) {
		this.fQ7ElementName = q7ElementName;
	}

	private Q7SearchResult fResult;

	public Q7SearchQuery(String searchText, boolean isRegEx,
			boolean isCaseSensitive, FileTextSearchScope scope, int searchFor) {
		this(searchText, isRegEx, isCaseSensitive, scope);
		fSearchFor = searchFor;

	}

	public Q7SearchQuery(String searchText, boolean isRegEx,
			boolean isCaseSensitive, FileTextSearchScope scope) {
		fSearchText = searchText;
		fIsRegEx = isRegEx;
		fIsCaseSensitive = isCaseSensitive;
		fScope = scope;
		fSearchFor = 0;
	}

	public FileTextSearchScope getSearchScope() {
		return fScope;
	}

	public boolean canRunInBackground() {
		return true;
	}

	public IStatus run(final IProgressMonitor monitor) {
		AbstractTextSearchResult textResult = (AbstractTextSearchResult) getSearchResult();
		textResult.removeAll();

		Pattern searchPattern = getSearchPattern();
		boolean searchInBinaries = !isScopeAllFileTypes();

		TextSearchResultCollector collector = new TextSearchResultCollector(
				textResult, isFileNameSearch(), searchInBinaries);
		return Q7SearchEngine.getDefault().search(fScope, collector,
				searchPattern, monitor, fSearchFor, fQ7ElementName);
	}

	private boolean isScopeAllFileTypes() {
		String[] fileNamePatterns = fScope.getFileNamePatterns();
		if (fileNamePatterns == null)
			return true;
		for (int i = 0; i < fileNamePatterns.length; i++) {
			if ("*".equals(fileNamePatterns[i])) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}

	public String getLabel() {
		return SearchMessages.FileSearchQuery_label;
	}

	public String getSearchString() {
		return fSearchText;
	}

	public String getResultLabel(int nMatches) {
		String searchString = getSearchString();
		if (getSearchFor() == CONTEXTS_BY_ID
				|| getSearchFor() == TESTCASE_BY_ID
				|| getSearchFor() == VERIFICATION_BY_ID) {
			searchString = fQ7ElementName;
		}
		if (searchString.length() > 0) {
			// text search
			// search selected file extensions
			if (nMatches == 1) {
				Object[] args = { searchString, fScope.getDescription(),
						getSearchForDescription() };
				return Messages
						.format(SearchMessages.FileSearchQuery_singularPatternWithFileExt,
								args);
			}
			Object[] args = { searchString, new Integer(nMatches),
					fScope.getDescription(), getSearchForDescription() };
			return Messages.format(
					SearchMessages.FileSearchQuery_pluralPatternWithFileExt,
					args);
		}
		// file search
		if (nMatches == 1) {
			Object[] args = { fScope.getFilterDescription(),
					fScope.getDescription() };
			return Messages
					.format(SearchMessages.FileSearchQuery_singularLabel_fileNameSearch,
							args);
		}
		Object[] args = { fScope.getFilterDescription(), new Integer(nMatches),
				fScope.getDescription() };
		return Messages.format(
				SearchMessages.FileSearchQuery_pluralPattern_fileNameSearch,
				args);
	}

	private String getSearchForDescription() {
		switch (fSearchFor) {
		case SCRIPT:
			return "Search in Scripts";
		case DESCRIPTION:
			return "Search in Descriptions";
		case TAGS:
			return "Search in Tags";
		case CONTEXTS:
			return "Search in Contexts";
		case VERIFICATIONS:
			return "Search in Verifications";
		case CONTEXTS_BY_ID:
			return "Context references";
		case TESTCASE_BY_ID:
			return "Test references";
		case VERIFICATION_BY_ID:
			return "Verification references";
		default:
			return "";
		}
	}

	/**
	 * @param result
	 *            all result are added to this search result
	 * @param monitor
	 *            the progress monitor to use
	 * @param file
	 *            the file to search in
	 * @return returns the status of the operation
	 */
	public IStatus searchInFile(final AbstractTextSearchResult result,
			final IProgressMonitor monitor, IFile file) {
		FileTextSearchScope scope = FileTextSearchScope.newSearchScope(
				new IResource[] { file }, new String[] { "*" }, true); //$NON-NLS-1$

		Pattern searchPattern = getSearchPattern();
		TextSearchResultCollector collector = new TextSearchResultCollector(
				result, isFileNameSearch(), true);

		return TextSearchEngine.create().search(scope, collector,
				searchPattern, monitor);
	}

	protected Pattern getSearchPattern() {
		return PatternConstructor.createPattern(fSearchText, fIsCaseSensitive,
				fIsRegEx);
	}

	public int getSearchFor() {
		return fSearchFor;
	}

	public boolean isFileNameSearch() {
		return fSearchText.length() == 0;
	}

	public boolean isRegexSearch() {
		return fIsRegEx;
	}

	public boolean isCaseSensitive() {
		return fIsCaseSensitive;
	}

	public boolean canRerun() {
		return true;
	}

	public ISearchResult getSearchResult() {
		if (fResult == null) {
			fResult = new Q7SearchResult(this);
			new SearchResultUpdater(fResult);
		}
		return fResult;
	}
}
