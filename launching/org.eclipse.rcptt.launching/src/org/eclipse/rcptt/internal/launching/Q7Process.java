/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.launching;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.rcptt.ecl.debug.core.DebuggerTransport;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.TestCaseDebugger;

public class Q7Process implements IProcess {

	private final ILaunch launch;
	private final AutLaunch aut;
	private final AtomicBoolean terminated = new AtomicBoolean();
	private final TestCaseDebugger debugger;

	public Q7Process(ILaunch launch, AutLaunch aut, BiFunction<String, Integer, DebuggerTransport> debugTransport) throws CoreException {
		if (launch == null)
			throw new NullPointerException("null launch");
		this.launch = launch;
		if (aut == null)
			throw new NullPointerException("null autLaunch");
		this.aut = aut;
		launch.addProcess(this);

		// start ECL debug server in debug mode
		if (ILaunchManager.DEBUG_MODE.equals(launch.getLaunchMode())) {
			debugger = new TestCaseDebugger(aut, this, debugTransport);
			launch.addDebugTarget(debugger.getDebugTarget());
		} else {
			debugger = null;
		}
	}

	public TestCaseDebugger getDebugger() {
		return debugger;
	}

	public String getAttribute(String key) {
		return null;
	}

	public int getExitValue() throws DebugException {
		return 0;
	}

	public String getLabel() {
		return "Q7Connection";
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public AutLaunch getAutLaunch() {
		return aut;
	}

	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	public void setAttribute(String key, String value) {
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		return null;
	}

	public boolean canTerminate() {
		return !isTerminated();
	}

	public boolean isTerminated() {
		return terminated.get();
	}

	public void terminate() throws DebugException {
		if (terminated.compareAndSet(false, true)) {
			if (debugger != null) {
				debugger.terminate();
			}
			DebugEvent event = new DebugEvent(this, DebugEvent.TERMINATE);
			DebugPlugin.getDefault().fireDebugEventSet(
					new DebugEvent[] { event });
		}
	}

}
