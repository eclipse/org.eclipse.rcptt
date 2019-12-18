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
package org.eclipse.rcptt.core.model;

import org.eclipse.rcptt.core.scenario.TestSuite;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;

public interface ITestSuite extends IQ7NamedElement {

	TestSuiteItem[] getItems() throws ModelException;

	TestSuite getTestSuite() throws ModelException;

	// Modifications, valid only for working copies
	void setItems(TestSuiteItem[] items) throws ModelException;
}
