package org.eclipse.rcptt.tesla.nebula.nattable.ecl.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class NatTablePlugin {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.tesla.nebula.nattable.ecl.impl"; //$NON-NLS-1$

	public static IStatus err(String message) {
		return err(message, null);
	}

	public static IStatus err(String message, Throwable throwable) {
		return new Status(IStatus.ERROR, PLUGIN_ID, message, throwable);
	}

}
