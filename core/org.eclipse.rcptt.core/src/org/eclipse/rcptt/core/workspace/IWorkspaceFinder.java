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
package org.eclipse.rcptt.core.workspace;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.IVerification;

public interface IWorkspaceFinder {
	IContext[] findContext(IQ7NamedElement dependant, String id);

	IVerification[] findVerification(IQ7NamedElement dependant, String id);

	ITestCase[] findTestcase(IQ7NamedElement dependant, String id);

	ITestSuite[] findTestsuites(IQ7NamedElement dependant, String id);
}
