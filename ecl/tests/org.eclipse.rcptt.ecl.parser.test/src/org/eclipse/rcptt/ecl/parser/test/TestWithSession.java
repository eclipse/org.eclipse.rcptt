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
package org.eclipse.rcptt.ecl.parser.test;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.junit.After;
import org.junit.Before;

public class TestWithSession {

	private TestSession session = null;

	public TestWithSession() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		session = new TestSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
		session = null;
	}

	public Object runScript(String string) throws CoreException {
		return session.runScript(string);
	}

	public Object runScript(String string, Object... parameters) throws CoreException {
		return runScript(String.format(string, parameters));
	}

	public IStatus unwrap(IStatus status) {
		return TestSession.unwrap(status);
	}
}