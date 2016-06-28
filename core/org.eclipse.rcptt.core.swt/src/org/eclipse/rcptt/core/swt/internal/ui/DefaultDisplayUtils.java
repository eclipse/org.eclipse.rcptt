package org.eclipse.rcptt.core.swt.internal.ui;

import org.eclipse.rcptt.util.DisplayUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

public class DefaultDisplayUtils implements DisplayUtils {

	@Override
	public boolean isWidget(Object object) {
		return object instanceof Widget;
	}

	@Override
	public void asyncExec(Object widget, Runnable runnable) {
		Display display = widget instanceof Widget ? ((Widget) widget).getDisplay() : Display.getDefault();
		display.asyncExec(runnable);
	}

	@Override
	public void syncExec(Object widget, Runnable runnable) {
		Display display = widget instanceof Widget ? ((Widget) widget).getDisplay() : Display.getDefault();
		display.syncExec(runnable);
	}

}
