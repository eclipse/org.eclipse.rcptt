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
package org.eclipse.rcptt.internal.core.model.index;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;
import org.eclipse.rcptt.core.utils.SortingUtils;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class TestSuiteElementCollector extends NamedElementCollector {
	private final List<IQ7NamedElement> manualyOrderedElements = new ArrayList<IQ7NamedElement>();
	private final List<IQ7NamedElement> elementsToSort = new ArrayList<IQ7NamedElement>();
	private final List<String> names;
	private final boolean respectManualOrder;

	private List<IQ7NamedElement> result;

	public TestSuiteElementCollector(List<String> names, boolean respectManualOrder) {
		this.names = names;
		this.respectManualOrder = respectManualOrder;
	}

	public boolean visit(IQ7Element element) {
		try {
			if (element instanceof ITestSuite
					&& (names.contains("*") || names
							.contains(((IQ7NamedElement) element)
									.getElementName()))) {
				processSuite((ITestSuite) element);
				return false;
			}
		} catch (ModelException e) {
		}
		return true;
	}

	public boolean endVisit(IQ7Element element) {
		return false;
	}

	public List<IQ7NamedElement> getElements() {
		if (result == null) {
			if (respectManualOrder) {
				result = new ArrayList<IQ7NamedElement>();

				result.addAll(elementsToSort);
				SortingUtils.sortNamedElements(result);
				result.addAll(manualyOrderedElements);
			} else {
				result = elementsToSort;
				SortingUtils.sortNamedElements(result);
			}
		}

		return result;
	}

	private void processSuite(ITestSuite suite) {
		try {
			final boolean ordered = respectManualOrder && suite.getTestSuite().isManuallyOrdered();

			EList<TestSuiteItem> items;
			items = suite.getTestSuite().getItems();
			for (TestSuiteItem testSuiteItem : items) {
				String id = testSuiteItem.getNamedElementId();
				IQ7NamedElement[] childs = suite.getQ7Project()
						.findNamedElement(id);
				if (childs != null && childs.length > 0) {
					for (IQ7NamedElement tcase : childs) {
						if (tcase == null) {
							RcpttPlugin.log(
									String.format("Can't resolve reference %s in %s", id,
											testSuiteItem.getNamedElemetName()), null);
						}
						if (tcase instanceof ITestCase) {
							if (ordered)
								manualyOrderedElements.add(tcase);
							else
								elementsToSort.add(tcase);
						} else if (tcase instanceof ITestSuite) {
							processSuite((ITestSuite) tcase);
						}
					}
				}
			}

			result = null;
		} catch (ModelException e) {
			RcpttPlugin.log("Failed to locate testsuite testcases:"
					+ suite.getPath().toString(), e);
		}
	}
}