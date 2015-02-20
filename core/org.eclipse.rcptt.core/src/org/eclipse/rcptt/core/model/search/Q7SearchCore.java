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
package org.eclipse.rcptt.core.model.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.index.IQ7IndexConstants;
import org.eclipse.rcptt.core.scenario.TestSuite;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.jobs.IJob;
import org.eclipse.rcptt.internal.core.model.ModelManager;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;
import org.eclipse.rcptt.internal.core.model.index.Index;
import org.eclipse.rcptt.internal.core.model.index.IndexManager;

public class Q7SearchCore {
	public static IQ7NamedElement[] findById(String id, ISearchScope scope,
			IProgressMonitor monitor) {
		return findById(id, scope, monitor, -1);
	}

	public static IQ7NamedElement findById(String id) {
		IQ7NamedElement[] result = findById(id, new AllProjectScope(), new NullProgressMonitor());
		if (result.length != 1) {
			return null;
		}
		return result[0];
	}

	public static IQ7NamedElement[] findById(String id, ISearchScope scope,
			IProgressMonitor monitor, long timeout) {

		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();

		Q7NamedElementCollector collector = new Q7NamedElementCollector();

		indexManager.performConcurrentJob(new PatternSearchJob(new IDSearchPattern(id),
				scope, collector), IJob.WaitUntilReady, monitor, timeout);

		List<IQ7NamedElement> elements = new ArrayList<IQ7NamedElement>();
		for (IQ7Element e : collector.getElements()) {
			if (e instanceof IQ7NamedElement) {
				elements.add((IQ7NamedElement) e);
			}
		}
		return elements.toArray(new IQ7NamedElement[elements.size()]);
	}

	public static IQ7NamedElement[] findByName(String name, ISearchScope scope,
			IProgressMonitor monitor) {

		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();

		Q7NamedElementCollector collector = new Q7NamedElementCollector();

		indexManager.performConcurrentJob(new PatternSearchJob(
				new NameSearchPattern(name), scope, collector), IJob.WaitUntilReady,
				monitor);

		List<IQ7NamedElement> elements = new ArrayList<IQ7NamedElement>();
		for (IQ7Element e : collector.getElements()) {
			if (e instanceof IQ7NamedElement) {
				elements.add((IQ7NamedElement) e);
			}
		}
		return elements.toArray(new IQ7NamedElement[elements.size()]);
	}

	public static IQ7NamedElement[] findContextUsage(String cid, ISearchScope scope,
			IProgressMonitor monitor) {

		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();

		Q7NamedElementCollector collector = new Q7NamedElementCollector();

		indexManager.performConcurrentJob(new PatternSearchJob(
				new ContextRefSearchPattern(cid), scope, collector), IJob.WaitUntilReady,
				monitor);

		List<IQ7NamedElement> elements = new ArrayList<IQ7NamedElement>();
		for (IQ7Element e : collector.getElements()) {
			if (e instanceof IQ7NamedElement) {
				elements.add((IQ7NamedElement) e);
			}
		}
		return elements.toArray(new IQ7NamedElement[elements.size()]);
	}

	public static IQ7NamedElement[] findVerificationUsage(String id, ISearchScope scope,
			IProgressMonitor monitor) {

		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();

		Q7NamedElementCollector collector = new Q7NamedElementCollector();

		indexManager.performConcurrentJob(new PatternSearchJob(
				new VerificationRefSearchPattern(id), scope, collector), IJob.WaitUntilReady,
				monitor);

		List<IQ7NamedElement> elements = new ArrayList<IQ7NamedElement>();
		for (IQ7Element e : collector.getElements()) {
			if (e instanceof IQ7NamedElement) {
				elements.add((IQ7NamedElement) e);
			}
		}
		return elements.toArray(new IQ7NamedElement[elements.size()]);
	}

	public static IQ7NamedElement[] findElementsWithUnusedReferences(ISearchScope scope, IProgressMonitor monitor) {
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		Set<String> ids = new HashSet<String>(Arrays.asList(findAllIDs(scope)));

		final List<IQ7NamedElement> result = new ArrayList<IQ7NamedElement>();
		indexManager.performConcurrentJob(new PatternSearchJob(
				new AllReferenceQueryPattern(ids, IQ7IndexConstants.CONTEXT_REF,
						IQ7IndexConstants.VERIFICATION_REF),
				scope, new IIndexRequestor() {
					public void acceptMatch(IQ7Element q7Element, String key, String value) {
						result.add((IQ7NamedElement) q7Element);
					}
				}), IJob.WaitUntilReady, new NullProgressMonitor());

		return result.toArray(new IQ7NamedElement[result.size()]);
	}

	public static IContext[] findContextsWithLinks(ISearchScope scope, Set<IPath> changed,
			IProgressMonitor monitor) {
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		final List<IContext> result = new ArrayList<IContext>();
		indexManager.performConcurrentJob(new PatternSearchJob(
				new AllContextWithLinksQueryPattern(changed), scope, new IIndexRequestor() {
					public void acceptMatch(IQ7Element q7Element, String key, String value) {
						// Could also collect all refernced files here.
						if (q7Element instanceof IContext) {
							result.add((IContext) q7Element);
						}
					}
				}), IJob.WaitUntilReady, new NullProgressMonitor());
		return result.toArray(new IContext[result.size()]);
	}

	public static String findNameByDocument(final IQ7Element element) {
		if (element.getParent() != null) {
			final List<String> names = new ArrayList<String>();
			if (element.getQ7Project() == null) {
				return null;
			}

			IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
			final IPath path = element.getQ7Project().getPath();
			try {
				indexManager.performConcurrentJob(
						new PatternSearchJob(new PathNameSearchPattern(element.getPath()
								.removeFirstSegments(path.segmentCount()).toString()),
								new ISearchScope() {
									public IPath[] getPaths() {
										return new IPath[] { path };
									}

									public boolean contains(IPath path) {
										return false;
									}
								}, new IIndexRequestor() {
									public void acceptMatch(IQ7Element q7Element,
											String key, String value) {
										names.add(value);
									}
								}), IJob.CancelIfNotReady, new NullProgressMonitor());
			} catch (OperationCanceledException e) {
				return null;
			}
			if (names.size() == 1) {
				return names.get(0);
			}
		}
		return null;
	}

	public static String[] findContextsByDocument(final IQ7Element element) {
		if (element.getParent() != null) {
			String id = IQ7IndexConstants.CONTEXT_REF;
			final List<String> names = findItemByDocument(element, id, false);
			return names.toArray(new String[names.size()]);
		}
		return null;
	}

	public static String[] findVerificationsByDocument(final IQ7Element element) {
		if (element.getParent() != null) {
			String id = IQ7IndexConstants.VERIFICATION_REF;
			final List<String> names = findItemByDocument(element, id, false);
			return names.toArray(new String[names.size()]);
		}
		return null;
	}

	private static List<String> findItemByDocument(final IQ7Element element, String id,
			boolean allowCancel) {
		final List<String> names = new ArrayList<String>();
		if (element.getQ7Project() == null) {
			return names;
		}
		final IPath path = element.getQ7Project().getPath();
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		try {
			indexManager.performConcurrentJob(new PatternSearchJob(new KeyQueryPattern(
					element.getPath(), id), new ISearchScope() {
				public IPath[] getPaths() {
					return new IPath[] { path };
				}

				public boolean contains(IPath path) {
					return false;
				}
			}, new IIndexRequestor() {
				public void acceptMatch(IQ7Element q7Element, String key, String value) {
					names.add(value);
				}
			}), allowCancel ? IJob.CancelIfNotReady : IJob.WaitUntilReady,
					new NullProgressMonitor());
		} catch (OperationCanceledException e) {
			return names;
		}
		return names;
	}

	private static List<String> findItemByPath(final IPath elementPath, String id) {
		final List<String> names = new ArrayList<String>();
		final IPath path = new Path("/"+elementPath.segment(0));
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		indexManager.performConcurrentJob(new PatternSearchJob(new KeyQueryPattern(
				elementPath, id), new ISearchScope() {
			public IPath[] getPaths() {
				return new IPath[] { path };
			}

			public boolean contains(IPath path) {
				return false;
			}
		}, new IIndexRequestor() {
			public void acceptMatch(IQ7Element q7Element, String key, String value) {
				names.add(value);
			}
		}), IJob.WaitUntilReady, new NullProgressMonitor());
		return names;
	}

	public static String findIDByDocument(final IQ7Element element) {
		String id = IQ7IndexConstants.ID;
		List<String> names = findItemByDocument(element, id, true);

		if (names.size() == 1) {
			return names.get(0);
		}
		return null;
	}

	public static String findIDByPath(final IPath path) {
		String id = IQ7IndexConstants.ID;
		List<String> names = findItemByPath(path, id);
		if (names.size() == 1) {
			return names.get(0);
		}
		return null;
	}

	public static Boolean findIsEmptyByDocument(final IQ7Element element) {
		String id = IQ7IndexConstants.IS_EMPTY;
		List<String> names = findItemByDocument(element, id, true);

		if (names.size() == 1) {
			return Boolean.valueOf(names.get(0));
		}
		return null;
	}

	public static String findContextTypeByDocument(final IContext element) {
		String id = IQ7IndexConstants.CONTEXT_TYPE;
		List<String> names = findItemByDocument(element, id, true);
		if (names.size() == 1) {
			return names.get(0);
		}
		return null;
	}

	public static String findVerificationTypeByDocument(final IQ7Element element) {
		String id = IQ7IndexConstants.VERIFICATION_TYPE;
		List<String> names = findItemByDocument(element, id, true);
		return names.size() == 1 ? names.get(0) : null;
	}

	public static String[] findTagsByDocument(final IQ7Element element) {
		String id = IQ7IndexConstants.TAG;
		List<String> names = findItemByDocument(element, id, false);
		return names.toArray(new String[names.size()]);
	}

	public static String[] findAllNames(ISearchScope scope) {
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		final List<String> names = new ArrayList<String>();
		indexManager.performConcurrentJob(new PatternSearchJob(new AllNameQueryPattern(),
				scope, new IIndexRequestor() {
					public void acceptMatch(IQ7Element q7Element, String key, String value) {
						names.add(value);
					}
				}), IJob.WaitUntilReady, new NullProgressMonitor());
		return names.toArray(new String[names.size()]);
	}

	public static String[] findAllIDs(ISearchScope scope) {
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		final List<String> ids = new ArrayList<String>();
		indexManager.performConcurrentJob(new PatternSearchJob(new AllIDQueryPattern(),
				scope, new IIndexRequestor() {
					public void acceptMatch(IQ7Element q7Element, String key, String value) {
						ids.add(value);
					}
				}), IJob.WaitUntilReady, new NullProgressMonitor());
		return ids.toArray(new String[ids.size()]);
	}

	public static Map<IQ7NamedElement, List<String>> findAllTagReferences() {
		ISearchScope scope = new AllProjectScope();
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		final Map<IQ7NamedElement, List<String>> tagsRefs = new HashMap<IQ7NamedElement, List<String>>();
		indexManager.performConcurrentJob(new PatternSearchJob(new AllTagQueryPattern(),
				scope, new IIndexRequestor() {
					public void acceptMatch(IQ7Element q7Element, String key, String value) {
						if (q7Element instanceof IQ7NamedElement) {
							IQ7NamedElement q7NamedElement = (IQ7NamedElement) q7Element;
							List<String> tagList = tagsRefs.get(q7NamedElement);
							if (tagList == null) {
								tagList = new ArrayList<String>();
							}
							tagList.add(value);
							tagsRefs.put(q7NamedElement, tagList);
						}
					}
				}), IJob.WaitUntilReady, new NullProgressMonitor());
		return tagsRefs;
	}

	public static IQ7NamedElement[] findAllElements() {
		return findAllElements(new AllProjectScope());
	}

	public static IQ7NamedElement[] findAllElements(ISearchScope scope) {
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		final List<IQ7NamedElement> names = new ArrayList<IQ7NamedElement>();
		indexManager.performConcurrentJob(new PatternSearchJob(new ISearchPattern() {
			public void findIndexMatches(Index index, IProgressMonitor monitor,
					IIndexRequestor requestor) {
				IPath path = index.getPath();
				String[] names = index.queryDocumentNames();
				for (String name : names) {
					IQ7Element q7Element = RcpttCore.create(root.findMember(path
							.append(new Path(name))));
					requestor.acceptMatch(q7Element, null, null);
				}
			}
		}, scope, new IIndexRequestor() {
			public void acceptMatch(IQ7Element q7Element, String key, String value) {
				if (q7Element instanceof IQ7NamedElement) {
					names.add((IQ7NamedElement) q7Element);
				}
			}
		}), IJob.WaitUntilReady, new NullProgressMonitor());
		return names.toArray(new IQ7NamedElement[names.size()]);
	}

	public static ITestSuite[] findAllTestSuites(ISearchScope scope) {
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		final List<ITestSuite> result = new ArrayList<ITestSuite>();
		indexManager.performConcurrentJob(new PatternSearchJob(new ISearchPattern() {
			public void findIndexMatches(Index index, IProgressMonitor monitor,
					IIndexRequestor requestor) {
				IPath path = index.getPath();
				String[] names = index.queryDocumentNames();
				for (String name : names) {
					IQ7Element q7Element = RcpttCore.create(root.findMember(path
							.append(new Path(name))));
					requestor.acceptMatch(q7Element, null, null);
				}
			}
		}, scope, new IIndexRequestor() {
			public void acceptMatch(IQ7Element q7Element, String key, String value) {
				if (q7Element instanceof ITestSuite) {
					result.add((ITestSuite) q7Element);
				}
			}
		}), IJob.WaitUntilReady, new NullProgressMonitor());
		return result.toArray(new ITestSuite[result.size()]);
	}

	public static IContext[] findAllContexts() {
		return findAllContexts(new AllProjectScope());
	}

	public static IContext[] findAllContexts(ISearchScope scope) {
		IndexManager indexManager = ModelManager.getModelManager().getIndexManager();
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		final List<IContext> result = new ArrayList<IContext>();
		indexManager.performConcurrentJob(new PatternSearchJob(new ISearchPattern() {
			public void findIndexMatches(Index index, IProgressMonitor monitor,
					IIndexRequestor requestor) {
				IPath path = index.getPath();
				String[] names = index.queryDocumentNames();
				for (String name : names) {
					IQ7Element q7Element = RcpttCore.create(root.findMember(path
							.append(new Path(name))));
					requestor.acceptMatch(q7Element, null, null);
				}
			}
		}, scope, new IIndexRequestor() {
			public void acceptMatch(IQ7Element q7Element, String key, String value) {
				if (q7Element instanceof IContext)
					result.add((IContext) q7Element);
			}
		}), IJob.WaitUntilReady, new NullProgressMonitor());
		return result.toArray(new IContext[result.size()]);
	}

	public static IQ7NamedElement getTestSuiteItemElement(TestSuiteItem item,
			ISearchScope scope) {
		IQ7NamedElement[] elements = findById(item.getNamedElementId(), scope,
				new NullProgressMonitor());
		if (elements.length == 1) {
			return elements[0];
		}
		return null;
	}

	public static IQ7NamedElement[] getTestSuiteContent(ITestSuite testSuite)
			throws ModelException {
		ISearchScope scope = getSearchScope(testSuite);
		TestSuite modifiedTestSuite = (TestSuite) testSuite.getModifiedNamedElement();
		IQ7NamedElement[] content = new IQ7NamedElement[modifiedTestSuite.getItems()
				.size()];
		for (int i = 0; i < modifiedTestSuite.getItems().size(); i++) {
			IQ7NamedElement q7Element = Q7SearchCore.getTestSuiteItemElement(
					modifiedTestSuite.getItems().get(i), scope);
			content[i] = q7Element;
		}
		return content;
	}

	public static ISearchScope getSearchScope(ITestSuite testSuite) {
		IQ7Project testSuiteProject = testSuite.getQ7Project();
		ISearchScope scope = testSuiteProject != null ? new ReferencedProjectScope(
				testSuiteProject) : new AllProjectScope();
		return scope;
	}

}
