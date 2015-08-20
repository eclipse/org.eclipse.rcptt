/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.recording;

import java.io.IOException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.recording.CommandSet;
import org.eclipse.rcptt.core.recording.IRecordingMonitor;
import org.eclipse.rcptt.core.recording.NetworkRecorder;
import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.utils.TeslaUtils;
import org.eclipse.rcptt.util.swt.ShellUtilsProvider;
import org.eclipse.rcptt.tesla.core.protocol.Type;
import org.eclipse.rcptt.tesla.internal.core.network.DefaultConnectionMonitor;

public class WidgetPicker {

	private static WidgetPicker picker;
	private static WidgetPickerWindow window;
	private static Shell lastMainWindow;
	private static volatile String result;
	private static Shell parentShell;

	public static synchronized String activate(Shell parentShell, final BaseAutLaunch launch,
			final VerificationType type) {
		WidgetPicker.parentShell = parentShell;
		result = null;

		if (picker != null)
			deactivate(true);
		else {
			lastMainWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			lastMainWindow.setMinimized(true);
		}

		picker = new WidgetPicker(launch, type);
		try {
			picker.start();
		} catch (IOException ex) {
			Q7UIPlugin.log("Error while activating picker", ex);
		}

		window = new WidgetPickerWindow(lastMainWindow, parentShell, type);
		window.open();
		deactivate(false);

		return result;
	}

	private static synchronized void deactivate(boolean activating) {
		if (picker != null) {
			picker.stop();
			picker = null;
		}

		if (window != null && window.getShell() != null) {
			window.getShell().getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					window.close();
					window = null;
				}
			});
		}

		if (!activating && lastMainWindow != null) {
			lastMainWindow.getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					lastMainWindow.setMinimized(false);
					if (parentShell != null) {
						try {
							ShellUtilsProvider.getShellUtils().forceActive(parentShell);
						} catch (CoreException e) {
							throw new RuntimeException(e);
						}
						parentShell.setFocus();
					} else {
						try {
							ShellUtilsProvider.getShellUtils().forceActive(lastMainWindow);
						} catch (CoreException e) {
							throw new RuntimeException(e);
						}
						lastMainWindow.setFocus();
					}
				}
			});
			lastMainWindow = null;
		}
	}

	private final BaseAutLaunch launch;
	private final NetworkRecorder recorder;
	private final VerificationType type;

	private WidgetPicker(BaseAutLaunch launch, VerificationType type) {
		this.launch = launch;
		this.type = type;
		this.recorder = new NetworkRecorder(
				launch.getHost(), launch.getTeslaPort(), new RecordingMonitor()) {

			@Override
			protected boolean isStopRecordRequest(Type command) {
				// the only defined shortcut is 'stop record',
				// so it is always true
				return true;
			}

		};
	}

	public void start() throws IOException {
		recorder.start();
		new WaitForConnectionAndActivateAssertModeJob(
				"Activating assert mode", launch, recorder, type.getWidgets()).
				schedule();
	}

	public void stop() {
		recorder.cancelConnection();
		recorder.close();
	}

	private class RecordingMonitor extends DefaultConnectionMonitor implements IRecordingMonitor {

		@Override
		public void tryToConnect() {
		}

		@Override
		public void connectFailed(Exception exception) {
		}

		@Override
		public void connected() {
		}

		@Override
		public void timeout() {
		}

		@Override
		public long getPause() {
			return super.getPause();
		}

		@Override
		public long getTimeout() {
			return super.getTimeout();
		}

		@Override
		public void recordMode() {
		}

		@Override
		public void assertMode() {
		}

		@Override
		public void startRecord() {
		}

		@Override
		public void stopRecord() {
			result = null;

			if (window != null && window.getShell() != null) {
				window.getShell().getDisplay().syncExec(new Runnable() {
					@Override
					public void run() {
						window.close();
					}
				});
			}
		}

		@Override
		public void replay() {
		}

		@Override
		public void assertAdded(CommandSet commandSet) {
			if (commandSet == null)
				return;

			final String selector = TeslaUtils.selectorOf(commandSet);

			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					Display.getDefault().timerExec(150, new Runnable() {
						@Override
						public void run() {
							result = selector;
							deactivate(false);
						}
					});
				}
			});
		}
	}
}
