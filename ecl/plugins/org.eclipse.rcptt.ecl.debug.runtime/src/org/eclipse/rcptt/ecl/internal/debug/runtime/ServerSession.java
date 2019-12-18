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
package org.eclipse.rcptt.ecl.internal.debug.runtime;

import static org.eclipse.rcptt.ecl.debug.runtime.ModelUtils.createEvent;
import static org.eclipse.rcptt.ecl.debug.runtime.ModelUtils.createStackEvent;

import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.CommandStack;
import org.eclipse.rcptt.ecl.core.GetVal;
import org.eclipse.rcptt.ecl.core.IStackListener;
import org.eclipse.rcptt.ecl.core.ProcInstance;
import org.eclipse.rcptt.ecl.debug.model.BreakpointCmd;
import org.eclipse.rcptt.ecl.debug.model.DebugCmd;
import org.eclipse.rcptt.ecl.debug.model.EventType;
import org.eclipse.rcptt.ecl.debug.model.ModelFactory;
import org.eclipse.rcptt.ecl.debug.model.ResolveVariableCmd;
import org.eclipse.rcptt.ecl.debug.model.ResolveVariableEvent;
import org.eclipse.rcptt.ecl.debug.model.SkipAllCmd;
import org.eclipse.rcptt.ecl.debug.model.StackFrame;
import org.eclipse.rcptt.ecl.debug.model.Variable;
import org.eclipse.rcptt.ecl.debug.runtime.Session;
import org.eclipse.rcptt.ecl.debug.runtime.SuspendManager;
import org.eclipse.rcptt.ecl.gen.ast.AstExec;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;

public class ServerSession extends Session implements IStackListener {

	private int lastLine = -1;
	private int lastStackLevel = 0;
	private int stepOverStackLevel = 0;
	private EclStackSupport stackSupport = null;
	private List<StackFrame> currentFrame = null;
	private Map<String, Variable> currentVariables = new HashMap<String, Variable>();

	public ServerSession(Socket socket, String id) throws CoreException {
		super(socket);
		this.id = id;
		this.stackSupport = new EclStackSupport(this.id);
		CommandStack.addListener(this);

		request(createEvent(EventType.STARTED));
	}

	@Override
	public void terminate() {
		CommandStack.removeListener(this);
		super.terminate();
		latch.unlock();
	}

	public void enter(CommandStack stack) {
		try {
			List<StackFrame> frames = stackSupport.getFrames(stack);
			if (frames != null) {
				if (stack.getCommand() instanceof GetVal || stack.getCommand() instanceof AstExec) {
					// Skip some commands from processing.
					return;
				}
				if (lastLine != frames.get(0).getLine()) {
					lastLine = -1;
				}
				lastStackLevel = getStackLevel(stack);
				if (latch.isLocked()) {
					if (StepKind.StepOver.equals(step)) {
						if (lastLine != frames.get(0).getLine() && stepOverStackLevel >= lastStackLevel) {
							lastLine = frames.get(0).getLine();
							setCurrentState(frames);

							request(createStackEvent(EventType.STEP_ENDED, frames));
							await();
						}
					}
					else if (StepKind.StepReturn.equals(step)) {
						if (lastLine != frames.get(0).getLine()
								&& (stepOverStackLevel > lastStackLevel || lastStackLevel == 0)) {
							lastLine = frames.get(0).getLine();
							setCurrentState(frames);

							request(createStackEvent(EventType.STEP_ENDED, frames));
							await();
						}
					}
					else {
						setCurrentState(frames);
						if (StepKind.Step.equals(step)) {
							request(createStackEvent(EventType.STEP_ENDED, frames));
						} else {
							request(createStackEvent(EventType.SUSPENDED, frames));
						}
						await();
					}
				} else if (isHitBreakpoint(frames.get(0))) {
					if (lastLine != frames.get(0).getLine()) {
						lastLine = frames.get(0).getLine();
						setCurrentState(frames);
						latch.lock();
						request(createStackEvent(EventType.BREAKPOINT_HIT, frames));
						await();
					}
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (CoreException e) {
			CorePlugin.err(e.getMessage(), e);
			Thread.currentThread().interrupt();
		}
	}

	private int getStackLevel(CommandStack stack) {
		int level = 0;
		CommandStack st = stack.getParent();
		while (st != null) {
			if (st.getCommand() instanceof ProcInstance) {
				level++;
			}
			st = st.getParent();
		}
		return level;
	}

	private void setCurrentState(List<StackFrame> frames) {
		synchronized (currentVariables) {
			currentFrame = frames;
			currentVariables.clear();
			for (StackFrame stackFrame : frames) {
				EList<Variable> list = stackFrame.getVariables();
				storeVarIds(list);
			}
		}
	}

	private void storeVarIds(EList<Variable> list) {
		for (Variable var : list) {
			currentVariables.put(var.getId(), var);
			if (var.getChildren().size() > 0) {
				storeVarIds(var.getChildren());
			}
		}
	}

	private boolean isHitBreakpoint(StackFrame data) {
		if (skip) {
			// skip all breakpoints
			return false;
		}
		String file = data.getFile();
		Set<Integer> lines = breakpoints.get(file);
		if (lines != null) {
			return lines.contains(data.getLine());
		}
		return false;
	}

	private void await() throws InterruptedException {
		SuspendManager.INSTANCE.fireSuspend();
		try {
			latch.await();
		} finally {
			SuspendManager.INSTANCE.fireResume();
		}
	}

	public void exit(CommandStack stack) {
	}

	@Override
	protected void handle(EObject op) {
		if (op instanceof DebugCmd)
			switch (((DebugCmd) op).getType()) {
			case SUSPEND:
				suspend();
				break;
			case RESUME:
				resume();
				break;
			case STEP:
				step();
				break;
			case STEP_OVER:
				stepOver();
				break;
			case STEP_RETURN:
				stepReturn();
				break;
			case BREAKPOINT_ADD:
				addBreakpoint((BreakpointCmd) op);
				break;
			case BREAKPOINT_REMOVE:
				removeBreakpoint((BreakpointCmd) op);
				break;
			case SKIP_ALL:
				skip = ((SkipAllCmd) op).isSkip();
				break;
			case RESOLVE_VARIABLE:
				synchronized (currentVariables) {
					ResolveVariableCmd resolveCmd = (ResolveVariableCmd) op;
					Variable var = currentVariables.get(resolveCmd.getId());
					if (var != null) {
						stackSupport.resolveVariable(var);
					}
					ResolveVariableEvent event = ModelFactory.eINSTANCE.createResolveVariableEvent();
					event.setType(EventType.RESOLVE_VARIABLE);
					event.setVariable(var);
					if (var != null) {
						synchronized (currentVariables) {
							storeVarIds(var.getChildren());
						}
					}
					try {
						request(event);
					} catch (CoreException e) {
						CorePlugin.err(e.getMessage(), e);
						Thread.currentThread().interrupt();
					}
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected request: " + op);
			}
	}

	@Override
	protected void handle(Exception e) {
		Log.log(e);
	}

	private synchronized void suspend() {
		latch.lock();
	}

	private synchronized void resume() {
		step = StepKind.None;
		latch.unlock();
		try {
			request(createEvent(EventType.RESUMED));
		} catch (CoreException e) {
			CorePlugin.err(e.getMessage(), e);
		}
	}

	private void step() {
		step = StepKind.Step;
		latch.lockAfterUnlock();
	}

	private void stepOver() {
		step = StepKind.StepOver;
		stepOverStackLevel = lastStackLevel;
		latch.lockAfterUnlock();
	}

	private void stepReturn() {
		step = StepKind.StepReturn;
		stepOverStackLevel = lastStackLevel;
		latch.lockAfterUnlock();
	}

	private void addBreakpoint(BreakpointCmd event) {
		Set<Integer> set = breakpoints.get(event.getPath());
		if (set == null) {
			set = new HashSet<Integer>();
			breakpoints.put(event.getPath(), set);
		}
		set.add(event.getLine());
	}

	private void removeBreakpoint(BreakpointCmd event) {
		Set<Integer> set = breakpoints.get(event.getPath());
		if (set != null) {
			set.remove(event.getLine());
		}
		if (set.isEmpty()) {
			breakpoints.remove(event.getPath());
		}
	}

	private enum StepKind {
		None, Step, StepOver, StepReturn
	}

	private volatile StepKind step = StepKind.None;
	private volatile boolean skip = false;
	private final MultiLatch latch = new MultiLatch();

	private final String id;
	private final Map<String, Set<Integer>> breakpoints = new HashMap<String, Set<Integer>>();

}
