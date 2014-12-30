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
package org.eclipse.rcptt.ecl.operations.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.parser.test.TestWithSession;
import org.junit.Test;

public class ParseTimeTest extends TestWithSession {

	@Test
	public void testDate() throws InterruptedException, CoreException {
		assertEquals(1325437320000L, runScript("parse-time \"2012-02-02 +0700\" -format \"yyyy-mm-dd Z\""));
	}

	@Test
	public void testTime() throws InterruptedException, CoreException {
		assertEquals(1325491200000L, runScript("parse-time \"2012-02-02 15:00 +0700\" -format \"yyyy-mm-dd HH:mm Z\""));
	}

	@Test
	public void testParseFail() {
		try {
			runScript("parse-time \"2012\" -format \"yyyy-mm-dd\"");
		} catch (CoreException e) {
			assertEquals("Failed to parse date: 2012 of format: yyyy-mm-dd", e.getStatus().getMessage());
			return;
		}
		fail();
	}

}
