package org.eclipse.rcptt.ecl.operations.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.parser.EclCoreParser;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;
import org.eclipse.rcptt.ecl.runtime.EclRuntime;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParseTimeTest {

	private ISession session = null;

	@Before
	public void setUp() throws Exception {
		session = EclRuntime.createSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
		session = null;
	}

	IStatus unwrap(IStatus status) {
		if (status instanceof ScriptErrorStatus) {
			return unwrap(((ScriptErrorStatus) status).getCause());
		}
		return status;
	}

	public Object runScript(String script) throws InterruptedException, CoreException {
		IPipe out = session.createPipe();
		IProcess process = session.execute(EclCoreParser.newCommand(script), null, out);
		IStatus status = process.waitFor();
		if (!status.isOK())
			throw new CoreException(unwrap(status));
		return out.take(1000);
	}

	@Test
	public void testNormal() throws InterruptedException, CoreException {
		assertEquals(1325437320000L, runScript("parse-time \"2012-02-02 +0700\" -format \"yyyy-mm-dd Z\""));
	}

	@Test
	public void testParseFail() throws InterruptedException, CoreException {
		try {
			runScript("parse-time \"2012\" -format \"yyyy-mm-dd\"");
		} catch (CoreException e) {
			assertEquals("Failed to parse date: 2012 of format: yyyy-mm-dd", e.getStatus().getMessage());
			return;
		}
		fail();
	}

}
