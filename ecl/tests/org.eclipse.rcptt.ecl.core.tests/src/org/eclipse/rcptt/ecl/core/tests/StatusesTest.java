package org.eclipse.rcptt.ecl.core.tests;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.util.Statuses;
import org.junit.Assert;
import org.junit.Test;

public class StatusesTest {

	private static IStatus status(int severity, int code) {
		return new Status(severity, "plugin", code, "", null);
	}

	private static MultiStatus multiStatus(int code) {
		return new MultiStatus("plugin", code, "OK", null);
	}

	@Test
	public void testHasCode() {
		MultiStatus status = multiStatus(0);
		status.add(status(0, 0));
		Assert.assertFalse(Statuses.hasCode(status, 1));
		status = multiStatus(0);
		status.add(status(0, 1));
		Assert.assertTrue(Statuses.hasCode(status, 1));
		status = multiStatus(1);
		Assert.assertTrue(Statuses.hasCode(status, 1));
	}

}
