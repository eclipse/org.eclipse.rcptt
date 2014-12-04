package org.eclipse.rcptt.ecl.parser.test;

import org.eclipse.core.runtime.CoreException;
import org.junit.Test;

public class ExecServiceTest extends TestWithSession {
	@Test
	public void letExpression() throws CoreException {
		runScript("let [val a 1] {\n\t$a | eq 1 | assert-true\n\t$a | eq 1 | assert-true}");
	}

}
