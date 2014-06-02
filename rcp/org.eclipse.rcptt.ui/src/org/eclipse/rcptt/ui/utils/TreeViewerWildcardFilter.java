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
package org.eclipse.rcptt.ui.utils;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public abstract class TreeViewerWildcardFilter extends ViewerFilter {

	private static final Pattern PATTERN_BACK_SLASH = Pattern.compile("\\\\"); //$NON-NLS-1$

	private static final Pattern PATTERN_QUESTION = Pattern.compile("\\?"); //$NON-NLS-1$

	private static final Pattern PATTERN_STAR = Pattern.compile("\\*"); //$NON-NLS-1$

	private static final Pattern PATTERN_LBRACKET = Pattern.compile("\\("); //$NON-NLS-1$

	private static final Pattern PATTERN_RBRACKET = Pattern.compile("\\)"); //$NON-NLS-1$

	private final TreeViewer treeViewer;

	public TreeViewerWildcardFilter(TreeViewer viewer) {
		this.treeViewer = viewer;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (isIgnoredElement(parentElement, element)) {
			ITreeContentProvider contentProvider = (ITreeContentProvider) treeViewer
					.getContentProvider();
			for (Object child : contentProvider.getChildren(element)) {
				if (select(viewer, element, child)) {
					return true;
				}
			}
			return false;
		}
		String filterText = getFilterText();
		if (filterText.length() == 0)
			return true;
		String wMatch = '*' + filterText + '*';
		Pattern pattern = null;
		try {
			pattern = Pattern.compile(asRegEx(wMatch, false),
					Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		} catch (PatternSyntaxException e) {
			return false;
		}
		String text = getElementText(parentElement, element);
		return pattern.matcher(text).matches();
	}

	protected boolean isIgnoredElement(Object parentElement, Object element) {
		return false;
	}

	protected abstract String getFilterText();

	protected abstract String getElementText(Object parentElement,
			Object element);

	private String asRegEx(String pattern, boolean group) {
		// Replace \ with \\, * with .* and ? with .
		// Quote remaining characters
		String result1 = PATTERN_BACK_SLASH.matcher(pattern).replaceAll(
				"\\\\E\\\\\\\\\\\\Q"); //$NON-NLS-1$
		String result2 = PATTERN_STAR.matcher(result1).replaceAll(
				"\\\\E.*\\\\Q"); //$NON-NLS-1$
		String result3 = PATTERN_QUESTION.matcher(result2).replaceAll(
				"\\\\E.\\\\Q"); //$NON-NLS-1$
		if (group) {
			result3 = PATTERN_LBRACKET.matcher(result3).replaceAll(
					"\\\\E(\\\\Q"); //$NON-NLS-1$
			result3 = PATTERN_RBRACKET.matcher(result3).replaceAll(
					"\\\\E)\\\\Q"); //$NON-NLS-1$
		}
		return "\\Q" + result3 + "\\E"; //$NON-NLS-1$ //$NON-NLS-2$
	}

}