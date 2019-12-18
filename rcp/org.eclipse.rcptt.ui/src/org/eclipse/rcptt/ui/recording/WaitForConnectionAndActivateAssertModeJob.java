/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.recording;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.progress.UIJob;

import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.core.recording.NetworkRecorder;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.ecl.core.model.SetQ7Features;
import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.features.IMLFeatures;
import org.eclipse.rcptt.tesla.recording.core.internal.TeslaRecordingNetworkClientProcessor;

public class WaitForConnectionAndActivateAssertModeJob extends UIJob {

	private static final int TIMEOUT = 30 * 5;
	private NetworkRecorder recorder;
	private final BaseAutLaunch launch;
	private final String[] classes;

	public WaitForConnectionAndActivateAssertModeJob(String name,
			BaseAutLaunch launch, NetworkRecorder recorder, String... classes) {
		super(name);
		this.launch = launch;
		this.recorder = recorder;
		this.classes = classes;
	}

	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		try {
			monitor.beginTask(Messages.RecordingSupport_ConnectingOp,
					TIMEOUT);
			long start = System.currentTimeMillis();
			while (true) {
				synchronized (this) {
					if (recorder.isConnected()) {
						return Status.OK_STATUS;
					}
				}
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return Status.CANCEL_STATUS;
				}
				if ((System.currentTimeMillis() - start) < TIMEOUT * 1000) {
					monitor.worked(1);
				} else {
					IStatus status = new Status(
							Status.ERROR,
							Q7UIPlugin.PLUGIN_ID,
							Messages.RecordingSupport_ConnectionTimeoutMsg);
					return status;
				}
			}
		} finally {
			synchronized (this) {
				if (recorder.isConnected()) {
					recorder.enableRawEvents(false);
					try {
						recorder.toAssertMode(classes);

						TeslaFeatures.getInstance().getOption(IMLFeatures.USE_IMAGING)
								.setValue("false"); //$NON-NLS-1$						
						SetQ7Features setQ7Features = Q7CoreFactory.eINSTANCE
								.createSetQ7Features();
						TeslaFeatures.getInstance().storeValues(setQ7Features.getFeatures());
						Q7Features.getInstance().storeValues(setQ7Features.getFeatures());
						try {
							launch.execute(setQ7Features);
						} catch (Exception e) {
							Q7UIPlugin.log(e);
						}

						recorder.setFeature(TeslaRecordingNetworkClientProcessor.STOP_RECORD_SHORTCUTS_FEATURE,
								"ESC");

					} catch (IOException e) {
						return new Status(IStatus.ERROR, Q7UIPlugin.PLUGIN_ID,
								"IO error while activating assert mode.", e);
					}
				} else {
					recorder.cancelConnection();
					recorder.close();
					recorder = null;
				}
			}
		}
	}
}
