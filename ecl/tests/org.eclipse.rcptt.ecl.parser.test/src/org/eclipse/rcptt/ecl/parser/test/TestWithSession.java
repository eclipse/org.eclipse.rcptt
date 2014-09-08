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