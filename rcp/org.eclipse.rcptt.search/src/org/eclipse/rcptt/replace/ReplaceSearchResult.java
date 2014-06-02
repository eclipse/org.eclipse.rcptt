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

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Script;
import org.eclipse.search.ui.text.Match;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;

import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.search.Q7SearchQuery;
import org.eclipse.rcptt.search.Q7SearchResult;

public class ReplaceSearchResult {

	public static void ReplaceInBackground(Q7SearchResult searchResult,
			String replaceString, IWorkbenchPage page) {

		InternalReplaceJob replaceJob = new InternalReplaceJob(searchResult,
				replaceString, page);

		replaceJob.setUser(true);
		replaceJob.schedule();
	}

	public static void Replace(Q7SearchResult searchResult,
			String replaceString, IWorkbenchPage page, IProgressMonitor monitor)
			throws IOException {
		try {
			monitor.beginTask(getReplaceHint(searchResult),
					searchResult.getMatchCount());
			int scenarioPart = ((Q7SearchQuery) searchResult.getQuery())
					.getSearchFor();
			String searchPattern = ((Q7SearchQuery) searchResult.getQuery())
					.getSearchString();
			boolean IsRegEx = ((Q7SearchQuery) searchResult.getQuery())
					.isRegexSearch();

			for (Object element : searchResult.getElements()) {
				IFile file = searchResult.getFile(element);
				if (file != null) {
					ITestCase scenario = (ITestCase) RcpttCore.create(file);
					try {
						String originalText = getOriginalText(scenario,
								scenarioPart);

						StringBuilder strBuilder = new StringBuilder();
						int currentOffset = 0;
						for (Match match : searchResult.getMatches(element)) {
							String beforeMatch = originalText.substring(
									currentOffset, match.getOffset());
							strBuilder.append(beforeMatch);

							String replacedStr = replaceString;
							if (IsRegEx) {
								String matchStr = originalText.substring(
										match.getOffset(), match.getOffset()
												+ match.getLength());

								replacedStr = matchStr.replaceAll(
										searchPattern, replaceString);
							}
							strBuilder.append(replacedStr);

							currentOffset = match.getOffset()
									+ match.getLength();
							monitor.worked(1);
						}
						String afterMatch = originalText
								.substring(currentOffset);
						strBuilder.append(afterMatch);
						IQ7NamedElement workingCopy = setNewText(scenario,
								scenarioPart, strBuilder.toString());
						try {
							// Don't save scenario if it opened in editor
							IEditorInput input = new FileEditorInput(file);
							IEditorPart editor = page.findEditor(input);
							if (editor == null) {
								workingCopy.commitWorkingCopy(true,
										new NullProgressMonitor());
							}
						} finally {
							workingCopy.discardWorkingCopy();
						}
					} catch (ModelException e) {
						Q7UIPlugin.log(e);
					}
				}
			}
			searchResult.removeAll();
		} finally {
			monitor.done();
		}
	}

	public static String getReplaceHint(Q7SearchResult searchResult) {
		String replaceHint = "Replacing " + searchResult.getMatchCount()
				+ " matches";
		int scenarioPart = ((Q7SearchQuery) searchResult.getQuery())
				.getSearchFor();
		switch (scenarioPart) {
		case Q7SearchQuery.SCRIPT:
			replaceHint += " in scripts";
			break;
		case Q7SearchQuery.DESCRIPTION:
			replaceHint += " in descriptions";
			break;
		}
		return replaceHint;
	}

	private static String getOriginalText(ITestCase scenario, int scenarioPart)
			throws ModelException {
		String originalText = null;
		switch (scenarioPart) {
		case Q7SearchQuery.DESCRIPTION:
			originalText = scenario.getDescription();
			break;
		case Q7SearchQuery.SCRIPT:
			originalText = Scenarios.getScriptContent((Scenario) scenario
					.getNamedElement());
			break;
		}
		return originalText;
	}

	private static IQ7NamedElement setNewText(ITestCase scenario,
			int scenarioPart, String newText) throws ModelException {
		ITestCase workingCopy = (ITestCase) scenario
				.getWorkingCopy(new NullProgressMonitor());
		switch (scenarioPart) {
		case Q7SearchQuery.DESCRIPTION:
			workingCopy.setDescription(newText);
			break;
		case Q7SearchQuery.SCRIPT:
			// Switch to ECL mode to store script modification
			Scenario namedElement = (Scenario) workingCopy.getNamedElement();
			if (Scenarios.isTeslaMode(namedElement)) {
				Scenarios.setTypeToEcl(namedElement);
			}
			Script script = CoreFactory.eINSTANCE.createScript();
			script.setContent(newText);
			workingCopy.setContent(script);
			break;
		}
		return workingCopy;
	}

	private static class InternalReplaceJob extends Job {

		private Q7SearchResult fSearchResult;
		private String fReplaceString;
		private IWorkbenchPage fPage;

		public InternalReplaceJob(Q7SearchResult searchResult,
				String replaceString, IWorkbenchPage page) {
			super(getReplaceHint(searchResult));
			fSearchResult = searchResult;
			fReplaceString = replaceString;
			fPage = page;
		}

		protected IStatus run(IProgressMonitor monitor) {
			int origPriority = Thread.currentThread().getPriority();
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

			try {
				try {
					Replace(fSearchResult, fReplaceString, fPage, monitor);
				} catch (IOException e) {
					final String PLUGINID = "org.eclipse.rcptt.search";
					IStatus status = new Status(IStatus.ERROR, PLUGINID,
							e.getMessage());
					return status;
				}
				return Status.OK_STATUS;
			} finally {
				Thread.currentThread().setPriority(origPriority);
			}
		}

	}

}
