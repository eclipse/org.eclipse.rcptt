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
package org.eclipse.rcptt.ecl.internal.debug.core;

import static org.eclipse.rcptt.ecl.debug.runtime.ModelUtils.createBreakpointCmd;
import static org.eclipse.rcptt.ecl.debug.runtime.ModelUtils.createDebugCmd;
import static org.eclipse.rcptt.ecl.debug.runtime.ModelUtils.createSkipAllEvent;
import static org.eclipse.rcptt.ecl.debug.runtime.ModelUtils.createVariableCmd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.IBreakpointManagerListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.debug.core.Debugger;
import org.eclipse.rcptt.ecl.debug.core.DebuggerCallback;
import org.eclipse.rcptt.ecl.debug.core.DebuggerTransport;
import org.eclipse.rcptt.ecl.debug.core.EclDebug;
import org.eclipse.rcptt.ecl.debug.core.NullDebuggerTransport;
import org.eclipse.rcptt.ecl.debug.model.DebugType;
import org.eclipse.rcptt.ecl.debug.model.ResolveVariableEvent;
import org.eclipse.rcptt.ecl.debug.model.StackEvent;
import org.eclipse.rcptt.ecl.debug.model.StackFrame;
import org.eclipse.rcptt.ecl.debug.model.Variable;

public class EclDebugTarget extends EclDebugElement implements IDebugTarget,
		IBreakpointManagerListener, Debugger, DebuggerCallback {

	private final IProcess process;
	private final EclDebugThread thread;
	private final IThread[] threads;

	private volatile DebuggerTransport transport;
	private volatile IStackFrame[] frames = new IStackFrame[0];
	private volatile boolean suspended = true;
	private volatile boolean stepping = false;
	private volatile AtomicBoolean initialized = new AtomicBoolean();
	private Map<String, IValue> resolveRequests = new HashMap<String, IValue>();

	public EclDebugTarget(IProcess process) throws CoreException {
		this.process = process;
		thread = new EclDebugThread(this);
		threads = new IThread[] { thread };
	}

	public void setTransport(DebuggerTransport transport) {
		if( transport == null) {
			transport = new NullDebuggerTransport();
		}
		if (this.transport != null) {
			this.transport.setCallback(null);
		}
		this.transport = transport;
		transport.setCallback(this);
	}

	@Override
	public ILaunch getLaunch() {
		return process.getLaunch();
	}

	public IProcess getProcess() {
		return process;
	}

	public boolean hasThreads() throws DebugException {
		return true;
	}

	public IThread[] getThreads() throws DebugException {
		return threads;
	}

	public IStackFrame[] getFrames() {
		return frames;
	}

	public IDebugTarget getDebugTarget() {
		return this;
	}

	public String getName() throws DebugException {
		ILaunchConfiguration configuration = getLaunch().getLaunchConfiguration();
		return configuration != null ? configuration.getName() : "Unknown";
	}

	public boolean canTerminate() {
		return getProcess().canTerminate();
	}

	public boolean isTerminated() {
		return getProcess().isTerminated();
	}

	public void terminate() throws DebugException {
		if (process.canTerminate()) {
			getBreakpointManager().removeBreakpointListener(this);
			getBreakpointManager().removeBreakpointManagerListener(this);
			frames = new IStackFrame[0];
			process.terminate();
			fireTerminateEvent();
		}
	}

	public boolean canResume() {
		return !isTerminated() && isSuspended();
	}

	public boolean canSuspend() {
		return !isTerminated() && !isSuspended();
	}

	public boolean isSuspended() {
		return suspended;
	}

	public boolean isStepping() {
		return stepping;
	}

	public void suspend() {
		request(createDebugCmd(DebugType.SUSPEND));
	}

	public void resume() {
		request(createDebugCmd(DebugType.RESUME));
	}

	public void step() {
		// TODO actually we need to add real response from server for step
		// started
		stepStarted();
		request(createDebugCmd(DebugType.STEP));
	}

	public void stepOver() {
		stepOverStarted();
		request(createDebugCmd(DebugType.STEP_OVER));
	}
	public void stepReturn() {
		stepReturnStarted();
		request(createDebugCmd(DebugType.STEP_RETURN));
	}

	public void breakpointAdded(IBreakpoint breakpoint) {
		try {
			if (supportsBreakpoint(breakpoint) && breakpoint.isEnabled()) {
				int line = ((ILineBreakpoint) breakpoint).getLineNumber();
				String path = breakpoint.getMarker().getResource()
						.getFullPath().toString();
				request(createBreakpointCmd(DebugType.BREAKPOINT_ADD, path, line));
			}
		} catch (CoreException e) {
			Plugin.log(e);
		}
	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				int line = ((ILineBreakpoint) breakpoint).getLineNumber();
				String path = breakpoint.getMarker().getResource()
						.getFullPath().toString();
				request(createBreakpointCmd(DebugType.BREAKPOINT_REMOVE, path, line));
			} catch (CoreException e) {
				Plugin.log(e);
			}
		}
	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled()) {
					breakpointAdded(breakpoint);
				} else {
					breakpointRemoved(breakpoint, null);
				}
			} catch (CoreException e) {
				Plugin.log(e);
			}
		}
	}

	public void breakpointManagerEnablementChanged(boolean enabled) {
		request(createSkipAllEvent(!enabled));
	}

	public boolean canDisconnect() {
		return false;
	}

	public void disconnect() throws DebugException {
	}

	public boolean isDisconnected() {
		return false;
	}

	public boolean supportsStorageRetrieval() {
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length)
			throws DebugException {
		return null;
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		if (breakpoint.getModelIdentifier().equals(EclDebug.MODEL)) {
			try {
				IMarker marker = breakpoint.getMarker();
				if (marker != null) {
					IResource[] resources = getLaunch()
							.getLaunchConfiguration().getMappedResources();
					if (resources != null) {
						for (IResource resource : resources) {
							if (marker.getResource().equals(resource)) {
								return true;
							}
						}
					}
				}
			} catch (CoreException e) {
				Plugin.log(e);
			}
		}
		return false;
	}

	private IBreakpointManager getBreakpointManager() {
		return DebugPlugin.getDefault().getBreakpointManager();
	}

	private void request(EObject event) {
		try {
			transport.request(event);
		} catch (CoreException e) {
			Plugin.log(e.getMessage(), e);
		}
	}

	public void handleResponse(EObject event) {
		thread.setBreakpoints(null);
		if (!(event instanceof org.eclipse.rcptt.ecl.debug.model.Event)) {
			return;
		}
		switch (((org.eclipse.rcptt.ecl.debug.model.Event) event).getType()) {
		case STARTED:
			started();
			break;
		case SUSPENDED:
			suspended((StackEvent) event);
			break;
		case STEP_ENDED:
			stepEnded((StackEvent) event);
			break;
		case BREAKPOINT_HIT:
			breakpointHit((StackEvent) event);
			break;
		case RESUMED:
			resumed();
			break;
		case RESOLVE_VARIABLE:
			variableResolved((ResolveVariableEvent) event);
			break;
		}
	}

	private void started() {
		if (initialized.compareAndSet(false, true)) {
			getBreakpointManager().addBreakpointManagerListener(this);
			getBreakpointManager().addBreakpointListener(this);
			fireCreationEvent();
		}
		installDeferredBreakpoints();
		if (!getBreakpointManager().isEnabled()) {
			request(createSkipAllEvent(true));
		}
		if (isStepping()) {
			request(createDebugCmd(DebugType.STEP));
		} else {
			resume();
		}
	}

	private void suspended(StackEvent event) {
		suspended(event, DebugEvent.CLIENT_REQUEST);
	}

	private void resumed() {
		suspended = false;
		frames = new IStackFrame[0];
		thread.fireResumeEvent(DebugEvent.CLIENT_REQUEST);
	}

	private void stepStarted() {
		stepping = true;
		thread.fireResumeEvent(DebugEvent.STEP_INTO);
	}

	private void stepOverStarted() {
		stepping = true;
		thread.fireResumeEvent(DebugEvent.STEP_OVER);
	}
	private void stepReturnStarted() {
		stepping = true;
		thread.fireResumeEvent(DebugEvent.STEP_RETURN);
	}

	private void stepEnded(StackEvent event) {
		suspended(event, DebugEvent.STEP_END);
	}

	private void breakpointHit(StackEvent event) {
		StackFrame data = event.getStackFrame().get(0);
		IBreakpoint breakpoint = getBreakpoint(data);
		if (breakpoint != null && supportsBreakpoint(breakpoint)) {
			thread.setBreakpoints(new IBreakpoint[] { breakpoint });
		}
		suspended(event, DebugEvent.BREAKPOINT);
	}

	private IBreakpoint getBreakpoint(StackFrame frame) {
		IBreakpoint[] breakpoints = DebugPlugin.getDefault()
				.getBreakpointManager().getBreakpoints(EclDebug.MODEL);
		for (int i = 0; i < breakpoints.length; i++) {
			IBreakpoint breakpoint = breakpoints[i];
			if (breakpoint instanceof ILineBreakpoint) {
				ILineBreakpoint lb = (ILineBreakpoint) breakpoint;
				try {
					IPath bp = breakpoint.getMarker().getResource()
							.getFullPath();
					IPath sp = new Path(frame.getFile());
					if (lb.getLineNumber() == frame.getLine() && sp.equals(bp)) {
						return breakpoint;
					}
				} catch (CoreException e) {
					Plugin.log(e);
				}
			}
		}
		return null;
	}

	private void installDeferredBreakpoints() {
		IBreakpoint[] breakpoints = DebugPlugin.getDefault()
				.getBreakpointManager().getBreakpoints(EclDebug.MODEL);
		for (int i = 0; i < breakpoints.length; i++) {
			breakpointAdded(breakpoints[i]);
		}
	}

	private void suspended(StackEvent event, int details) {
		suspended = true;
		stepping = false;
		updateStack(event);
		thread.fireSuspendEvent(details);
	}

	private void updateStack(StackEvent event) {
		synchronized (resolveRequests) {
			resolveRequests.clear();
		}
		List<StackFrame> eventFrames = event.getStackFrame();
		IStackFrame[] newFrames = new IStackFrame[eventFrames.size()];
		for (int i = 0; i < eventFrames.size(); i++) {
			newFrames[i] = new EclStackFrame(thread, eventFrames.get(i));
		}
		frames = newFrames;
	}

	public void resolveVariable(Variable arg, EclValue eclValue) {
		synchronized (resolveRequests) {
			resolveRequests.put(arg.getId(), eclValue);
		}
		request(createVariableCmd(arg.getId()));
	}

	private void variableResolved(ResolveVariableEvent event) {
		EclValue value = null;
		Variable var = event.getVariable();
		if(var == null) {
			return;
		}
		synchronized (resolveRequests) {
			value = (EclValue) resolveRequests.get(var.getId());
			resolveRequests.remove(var.getId());
		}
		if (value != null) {
			value.setVariable(var);
			DebugEvent de = new DebugEvent(value, DebugEvent.CHANGE | DebugEvent.CONTENT);
			fireEvent(de);
		}
	}
}
