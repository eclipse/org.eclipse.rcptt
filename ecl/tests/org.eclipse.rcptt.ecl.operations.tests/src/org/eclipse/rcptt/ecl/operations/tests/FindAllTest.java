/*******************************************************************************
 * Copyright (c) 2018, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.operations.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.parser.test.TestWithSession;
import org.junit.Test;

public class FindAllTest extends TestWithSession {

	@Test
	public void testMatchedSubstring() throws CoreException {
		runScript("find-all \"one 1 two 2 three 3\" -regex \"(\\w+)\\W+(\\d+)\" | to-list | get 1 | get 0 | eq \"two 2\" | assert-true");
	}

	@Test
	public void testGroups() throws CoreException {
		runScript("find-all \"one 1 two 2 three 3\" -regex \"(\\w+)\\W+(\\d+)\" | to-list | get 2 | get 2 | eq \"3\" | assert-true");
	}

	@Test
	public void testFindAllFail() {
		try {
			runScript("find-all \"one 1 two 2 three 3\" -regex \"\" | to-list | get 2 | get 2");
		} catch (CoreException e) {
			assertEquals("Empty regex is not allowed", e.getStatus().getMessage());
			return;
		}
		fail();
	}

}
