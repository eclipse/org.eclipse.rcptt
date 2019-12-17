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
package org.eclipse.rcptt.replace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.ecl.context.EclContext;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Script;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.search.Q7SearchQuery;
import org.eclipse.rcptt.search.Q7SearchResult;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;
import org.eclipse.search.ui.text.Match;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;

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

			Shell shell = page.getWorkbenchWindow().getShell();
			WriteAccessChecker writeAccessChecker = new WriteAccessChecker(shell, false);
			if (!writeAccessChecker.makeResourceWritable(foundFiles(searchResult))) {
				return;
			}
			for (Object element : searchResult.getElements()) {
				IFile file = searchResult.getFile(element);
				if (file != null) {
					try {
						EclContainer scenario = adaptToEclContainer((IQ7NamedElement) RcpttCore.create(file));
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
		} catch (CoreException e) {
			Q7UIPlugin.log(e);
		} finally {
			monitor.done();
		}
	}

	private static IFile[] foundFiles(Q7SearchResult searchResult) {
		List<IFile> files = new ArrayList<IFile>();
		for (Object element : searchResult.getElements()) {
			if (element instanceof IFile) {
				files.add((IFile) element);
			}
		}
		return files.toArray(new IFile[0]);
	}

	interface EclContainer {
		IQ7NamedElement element();

		String getDescription() throws ModelException;

		Script getScript() throws ModelException;

		// Returns modified working copy
		IQ7NamedElement setScript(Script script) throws ModelException;
	}

	static EclContainer adaptToEclContainer(IQ7NamedElement element)
			throws ModelException {
		if (element instanceof ITestCase)
			return new TestCaseEclContainer((ITestCase) element);
		if (element instanceof IContext
				&& element.getNamedElement() instanceof EclContext)
			return new ContextEclContainer((IContext) element);
		throw new IllegalArgumentException("Can't extract ECL script from "
				+ element.getClass().getName());
	}

	static class TestCaseEclContainer implements EclContainer {
		private final ITestCase testCase;

		public TestCaseEclContainer(ITestCase testCase) {
			super();
			this.testCase = testCase;
		}

		@Override
		public String getDescription() throws ModelException {
			return testCase.getNamedElement().getDescription();
		}

		@Override
		public Script getScript() throws ModelException {
			return Scenarios.getEcl(testCase);
		}

		@Override
		public IQ7NamedElement element() {
			return testCase;
		}

		@Override
		public IQ7NamedElement setScript(Script script) throws ModelException {
			ITestCase rv = (ITestCase) testCase
					.getWorkingCopy(new NullProgressMonitor());
			rv.setContent(script);
			return rv;
		}
	}

	static class ContextEclContainer implements EclContainer {
		private final IContext context;

		public ContextEclContainer(IContext testCase) throws ModelException {
			super();
			this.context = testCase;
		}

		@Override
		public String getDescription() throws ModelException {
			return context.getNamedElement().getDescription();
		}

		@Override
		public Script getScript() throws ModelException {
			NamedElement element = context.getNamedElement();
			return ((EclContext) element).getScript();
		}

		@Override
		public IQ7NamedElement element() {
			return context;
		}

		@Override
		public IQ7NamedElement setScript(Script script) throws ModelException {
			IContext rv = (IContext) context
					.getWorkingCopy(new NullProgressMonitor());
			EclContext eclc = (EclContext) rv.getNamedElement();
			eclc.setScript(script);
			return rv;
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

	private static String getOriginalText(EclContainer scenario,
			int scenarioPart) throws ModelException {
		String originalText = null;
		switch (scenarioPart) {
		case Q7SearchQuery.DESCRIPTION:
			originalText = scenario.getDescription();
			break;
		case Q7SearchQuery.SCRIPT:
			originalText = scenario.getScript().getContent();
			break;
		}
		return originalText;
	}

	private static IQ7NamedElement setNewText(EclContainer scenario,
			int scenarioPart, String newText) throws ModelException {
		switch (scenarioPart) {
		case Q7SearchQuery.DESCRIPTION:
			IQ7NamedElement workingCopy = scenario.element().getWorkingCopy(
					new NullProgressMonitor());
			workingCopy.setDescription(newText);
			return workingCopy;
		case Q7SearchQuery.SCRIPT:
			Script script = CoreFactory.eINSTANCE.createScript();
			script.setContent(newText);
			return scenario.setScript(script);
		default:
			throw new IllegalArgumentException("" + scenarioPart);
		}
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
