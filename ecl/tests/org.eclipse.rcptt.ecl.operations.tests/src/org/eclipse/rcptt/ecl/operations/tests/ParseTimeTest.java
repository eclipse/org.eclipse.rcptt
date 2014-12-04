package org.eclipse.rcptt.ecl.operations.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.parser.test.TestWithSession;
import org.junit.Test;

public class ParseTimeTest extends TestWithSession {

	@Test
	public void testNormal() throws InterruptedException, CoreException {
		assertEquals(1325437320000L, runScript("parse-time \"2012-02-02 +0700\" -format \"yyyy-mm-dd Z\""));
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
