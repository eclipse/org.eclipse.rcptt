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
package org.eclipse.rcptt.search.utils;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.ui.launching.LaunchUtils;

public class Q7ElementTester extends PropertyTester {

	private static final String IS_Q7ELEMENT_PROP = "isQ7Element"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if (IS_Q7ELEMENT_PROP.equals(property)) {
			ISelection selection = new StructuredSelection(receiver);
			IResource[] resources = LaunchUtils.getContext(selection);
			if (resources.length == 1 && resources[0] instanceof IFile) {
				IQ7NamedElement element = (IQ7NamedElement) RcpttCore
						.create(resources[0]);
				return element instanceof IContext
						|| element instanceof ITestCase
						|| element instanceof ITestSuite
						|| element instanceof IVerification;
			}
		}
		return false;
	}

}
