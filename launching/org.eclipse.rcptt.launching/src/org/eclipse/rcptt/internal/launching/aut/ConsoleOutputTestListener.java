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
package org.eclipse.rcptt.internal.launching.aut;

import java.util.List;

import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IFlushableStreamMonitor;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.rcptt.core.launching.events.AutBundleState;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutLaunchListener;
import org.eclipse.rcptt.launching.AutLaunchState;

public class ConsoleOutputTestListener implements AutLaunchListener {

	private ConsoleOutputListener listener;
	private StringBuilder log = null;

	public void startLogging(AutLaunch launch) {
		IProcess[] processes = launch.getLaunch().getProcesses();
		log = new StringBuilder();
		if (listener == null) {
			this.listener = new ConsoleOutputListener(log);
		}

		for (IProcess process : processes) {
			IStreamsProxy proxy = process.getStreamsProxy();
			if (proxy == null) {
				continue;
			}

			for (IStreamMonitor sm : new IStreamMonitor[] {
					proxy.getOutputStreamMonitor(),
					proxy.getErrorStreamMonitor() }) {
				listener.streamAppended(sm.getContents(), sm);
				sm.removeListener(listener);
				sm.addListener(listener);
			}
		}
	}

	public void stopLogging() {
		if (listener != null) {
			listener = null;
		}
	}

	@Override
	public void stateChanged(AutLaunch launch, AutLaunchState state) {
		if (state.equals(AutLaunchState.TERMINATE)) {
			stopLogging();
		}
	}

	private static class ConsoleOutputListener implements IStreamListener {
		public final StringBuilder log;

		public ConsoleOutputListener(StringBuilder log) {
			this.log = log;
		}

		public void streamAppended(String text, IStreamMonitor monitor) {
			if (log == null) {
				return;
			}
			log.append(text);
			if (monitor instanceof IFlushableStreamMonitor) {
				((IFlushableStreamMonitor) monitor).flushContents();
			}
		}
	}

	public String getLog() {
		return log.toString();
	}

	@Override
	public void autStarted(AutLaunch baseAutLaunch, int eclPort, int teslaPort) {
	}

	@Override
	public void autInit(AutLaunch baseAutLaunch, List<AutBundleState> bundleState) {
	}

	@Override
	public void autLocationChange(BaseAutLaunch baseAutLaunch, String location) {
	}

}
