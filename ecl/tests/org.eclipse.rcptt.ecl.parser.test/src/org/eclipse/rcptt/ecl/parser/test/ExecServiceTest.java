package org.eclipse.rcptt.ecl.parser.test;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.parser.EclCoreParser;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;
import org.eclipse.rcptt.ecl.runtime.EclRuntime;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

import junit.framework.TestCase;

public class ExecServiceTest extends TestCase {
	private ISession session = null;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		session = EclRuntime.createSession();
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
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
	
	public void testLetExpression() throws InterruptedException, CoreException {
		runScript("let [val a 1] {\n\t$a | eq 1 | assert-true\n\t$a | eq 1 | assert-true}");
	}

}
