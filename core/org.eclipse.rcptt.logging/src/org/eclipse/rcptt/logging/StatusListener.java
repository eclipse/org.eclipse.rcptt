package org.eclipse.rcptt.logging;

import org.eclipse.core.runtime.IStatus;

public interface StatusListener {
	public abstract void log(IStatus status);
}