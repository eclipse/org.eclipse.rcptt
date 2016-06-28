package org.eclipse.rcptt.util;

public interface DisplayUtils {
	boolean isWidget(Object object);

	void asyncExec(Object widget, Runnable runnable);

	void syncExec(Object widget, Runnable runnable);
}
