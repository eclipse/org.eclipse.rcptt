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
package org.eclipse.rcptt.core.model;

import org.eclipse.rcptt.core.scenario.TestSuite;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;

public interface ITestSuite extends IQ7NamedElement {

	TestSuiteItem[] getItems() throws ModelException;

	TestSuite getTestSuite() throws ModelException;

	// Modifications, valid only for working copies
	void setItems(TestSuiteItem[] items) throws ModelException;
}
