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
package org.eclipse.rcptt.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.Q7Status;
import org.eclipse.rcptt.core.model.Q7Status.Q7StatusCode;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;
import org.eclipse.rcptt.core.workspace.IWorkspaceFinder;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.core.workspace.Q7Utils;
import org.eclipse.rcptt.core.workspace.WorkspaceFinder;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.core.model.Q7InternalTestCase;

public final class ModelCycleDetector {

	private ModelCycleDetector() {
	}

	public static class CycleGraph {

		public Map<String, List<String>> graph;
		public boolean cycle;
		public HashMap<String, IQ7NamedElement> elementsMap;

	}

	public static boolean hasCycles(IQ7NamedElement[] elements) {
		return buildCycles(elements, null, new NullProgressMonitor()).cycle;
	}

	public static boolean hasCycles(NamedElement[] elements,
			IWorkspaceFinder finder) {
		IQ7NamedElement[] els = new IQ7NamedElement[elements.length];
		for (int i = 0; i < els.length; i++) {
			els[i] = (IQ7NamedElement) RcpttCore.create(Q7Utils
					.getLocation(elements[i]));
		}
		return hasCycles(els);
	}

	public static CycleGraph buildCycles(IQ7NamedElement[] elements,
			IWorkspaceFinder finder, IProgressMonitor monitor) {
		try {
			CycleGraph gr = new CycleGraph();
			gr.graph = new HashMap<String, List<String>>();
			gr.elementsMap = new HashMap<String, IQ7NamedElement>();

			monitor.beginTask("Check for circular dependencies",
					elements.length + 1);
			for (IQ7NamedElement element : elements) {
				if (monitor.isCanceled()) {
					return gr;
				}
				if (element instanceof ITestCase) {
					addScenarioToGraph((ITestCase) element, gr, finder);
				} else if (element instanceof IContext) {
					addGroupContextToGraph((IContext) element, gr, finder);
				} else if (element instanceof ITestSuite) {
					addTestSuiteToGraph((ITestSuite) element, gr, finder);
				}
				monitor.worked(1);
			}
			int prevVal = 0;
			while (true) {
				if (monitor.isCanceled()) {
					return gr;
				}
				processGraph(gr.graph);
				if (gr.graph.size() == prevVal) {
					break;
				}
				prevVal = gr.graph.size();
			}
			gr.cycle = (gr.graph.size() >= 2);
			return gr;
		} finally {
			monitor.done();
		}
	}

	private static void processGraph(Map<String, List<String>> graph) {
		Set<Entry<String, List<String>>> nodes = graph.entrySet();
		for (Iterator<Entry<String, List<String>>> it = nodes.iterator(); it
				.hasNext();) {
			Entry<String, List<String>> entry = it.next();
			List<String> childIds = entry.getValue();
			for (Iterator<String> it2 = childIds.iterator(); it2.hasNext();) {
				String childId = it2.next();
				if (!graph.containsKey(childId)) {
					it2.remove();
				}
			}

			if (childIds.size() == 0) {
				it.remove();
			}
		}
	}

	private static void addGroupContextToGraph(IContext context,
			CycleGraph graph, IWorkspaceFinder finder) {
		IContext[] childs = RcpttCore.getInstance().getContexts(context, finder, true);
		try {
			String cid = getIdBy(context);
			graph.elementsMap.put(cid, context);
			if (childs != null) {
				for (IContext child : childs) {
					if (RcpttCore.getInstance().isNotGroupContext(child)) {
						// Not a group context
						continue;
					}
					if (child.getNamedElement() instanceof GroupContext) {
						GroupContext gchild = (GroupContext) child
								.getNamedElement();
						if (gchild.getContextReferences().size() > 0) {
							List<String> childIds = graph.graph.get(cid);
							if (childIds != null
									&& childIds.contains(getIdBy(child))) {
								continue;
							} else {
								if (childIds == null) {
									childIds = new ArrayList<String>();
									graph.graph.put(cid, childIds);
								}
								childIds.add(getIdBy(child));
								addGroupContextToGraph(child, graph, finder);
							}
						}
					}
				}
			}
		} catch (ModelException e) {
			RcpttPlugin.log(e);
		}
	}

	private static void addTestSuiteToGraph(ITestSuite suite,
			CycleGraph graph, IWorkspaceFinder finder) {
		TestSuiteItem[] items;
		if (finder == null) {
			finder = WorkspaceFinder.getInstance();
		}
		try {
			items = suite.getItems();
			try {
				String cid = getIdBy(suite);
				graph.elementsMap.put(cid, suite);
				if (items != null) {
					if (items != null && items.length > 0) {
						List<String> childIds = graph.graph.get(cid);
						for (TestSuiteItem testSuiteItem : items) {
							String childID = testSuiteItem.getNamedElementId();
							if (childIds != null && childIds.contains(childID)) {
								continue;
							} else {
								if (childIds == null) {
									childIds = new ArrayList<String>();
									graph.graph.put(cid, childIds);
								}
								childIds.add(childID);
								ITestCase[] cases = finder.findTestcase(suite,
										childID);
								if (cases != null) {
									for (ITestCase iTestCase : cases) {
										addScenarioToGraph(iTestCase, graph,
												finder);
									}
								}
								ITestSuite[] suites = finder.findTestsuites(
										suite, childID);
								if (suites != null) {
									for (ITestSuite testSuite : suites) {
										addTestSuiteToGraph(testSuite, graph,
												finder);
									}
								}
							}
						}
					}
				}
			} catch (ModelException e) {
				RcpttPlugin.log(e);
			}
		} catch (ModelException e1) {
			RcpttPlugin.log(e1);
		}
	}

	private static String getIdBy(IQ7NamedElement context)
			throws ModelException {
		String cid = Q7SearchCore.findIDByDocument(context);
		if (cid == null) {
			cid = context.getID();
		}
		return cid;
	}

	private static void addScenarioToGraph(ITestCase scenario,
			CycleGraph graph, IWorkspaceFinder finder) {
		if (scenario instanceof Q7InternalTestCase) {
			return;
		}
		try {
			if( !scenario.exists()) {
				return;
			}
		} catch (Exception e) {
			RcpttPlugin.log(e);
			return;
		}
		try {
			IContext[] contexts = RcpttCore.getInstance().getContexts(scenario,
					finder, true);
			for (IContext c : contexts) {
				try {
					if (RcpttCore.getInstance().isNotGroupContext(c)) {
						// Not a group context
						continue;
					}
					if (c.getNamedElement() instanceof GroupContext) {
						addGroupContextToGraph(c, graph, finder);
					}
				} catch (ModelException e) {
					if (e.getStatus() instanceof Q7Status
							&& !((Q7Status) e.getStatus()).getStatusCode()
									.equals(Q7StatusCode.OK)) {
						// Skip this exception, file probable will be refreshed,
						// and re-updated later.
						return;
					}
					throw e;
				}
			}
		} catch (ModelException e) {
			RcpttPlugin.log(e);
		}
	}
}
