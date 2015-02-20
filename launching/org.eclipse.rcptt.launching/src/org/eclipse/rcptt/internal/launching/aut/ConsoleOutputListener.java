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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.rcptt.core.launching.events.AutBundleState;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutLaunchListener;
import org.eclipse.rcptt.launching.AutLaunchState;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class ConsoleOutputListener implements AutLaunchListener {

	private final StringBuilder log = new StringBuilder();
	private AutLaunch launch = null;

	private IStreamListener listener = new IStreamListener() {
		public void streamAppended(String text, IStreamMonitor monitor) {
			assert launch != null;
			log.append(text);
		}
	};

	static Collection<IStreamMonitor> getMonitors(ILaunch launch) {
		if (launch == null)
			return Collections.emptyList();
		Builder<IStreamMonitor> builder = ImmutableList.<IStreamMonitor> builder();
		for (IProcess process : launch.getProcesses()) {
			IStreamsProxy proxy = process.getStreamsProxy();
			if (proxy == null) {
				continue;
			}
			builder.add(proxy.getOutputStreamMonitor());
			builder.add(proxy.getErrorStreamMonitor());
		}
		return builder.build();
	}

	public void startLogging(AutLaunch launch) {
		stopLogging();
		log.setLength(0);
		this.launch = launch;
		for (IStreamMonitor sm : getMonitors(launch.getLaunch())) {
			sm.addListener(listener);
		}
	}

	public void stopLogging() {
		AutLaunch launch2 = launch;
		if (launch2 == null)
			return;
		for (IStreamMonitor sm : getMonitors(launch2.getLaunch())) {
			sm.removeListener(listener);
		}
		launch = null;
	}

	@Override
	public void stateChanged(AutLaunch launch, AutLaunchState state) {
		if (state.equals(AutLaunchState.TERMINATE)) {
			stopLogging();
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
