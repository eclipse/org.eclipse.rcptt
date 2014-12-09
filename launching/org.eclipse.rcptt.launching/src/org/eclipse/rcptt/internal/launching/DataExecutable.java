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
package org.eclipse.rcptt.internal.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.launching.AutLaunch;

public abstract class DataExecutable extends Executable {

	protected IQ7NamedElement element;

	private long time;
	private IStatus resultStatus;

	private boolean terminated;

	protected State status = State.WAITING;
	protected AutLaunch launch;
	protected boolean terminateUser = false;
	protected NullProgressMonitor executionMonitor;

	public DataExecutable(AutLaunch launch, IQ7NamedElement element,
			boolean debug) {
		this(launch, element, debug, ExecutionPhase.AUTO);
	}

	public DataExecutable(AutLaunch launch, IQ7NamedElement element,
			boolean debug, ExecutionPhase phase) {
		super(debug, phase);
		this.element = element;
		this.launch = launch;
		executionMonitor = new NullProgressMonitor();
	}

	public AutLaunch getAut() {
		return launch;
	}

	public String getName() {
		String nameByDocument = Q7SearchCore.findNameByDocument(element);
		if (nameByDocument != null) {
			return nameByDocument;
		}

		try {
			return element.getElementName();
		} catch (ModelException e) {
			if (!element.getResource().exists()) {
				return "Resource: "
						+ element.getResource().getFullPath()
						+ " doesn't exist.";
			}
			// Q7Plugin.log(e);
			return "Unresolved element";
		}
	}

	@Override
	public String getId() {
		try {
			String id = Q7SearchCore.findIDByDocument(element);
			if (id == null) {
				id = element.getID();
			}
			return id;
		} catch (ModelException e) {
			Q7LaunchingPlugin.log(e);
		}
		return null;
	}

	@Override
	public Executable[] getChildren() {
		return EMPTY;
	}

	public State getStatus() {
		return status;
	}

	@Override
	public void startLaunching() {
		status = State.LAUNCHING;
	}

	@Override
	public IStatus execute() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		try {
			resultStatus = doExecute();
		} catch (CoreException ce) {
			resultStatus = ce.getStatus();
		} catch (Exception e) {
			resultStatus = Q7LaunchingPlugin.createStatus(e.getMessage(), e);
		} catch (Throwable e) {
			resultStatus = Q7LaunchingPlugin.createStatus(e.getMessage(), e);
		} finally {
			time = System.currentTimeMillis() - startTime;
			status = resultStatus.getSeverity() == IStatus.OK ? State.PASSED
					: State.FAILED;
		}
		return resultStatus;
	}

	@Override
	public void terminate(boolean user) {
		terminated = true;
		terminateUser = user;
		if (executionMonitor != null) {
			executionMonitor.setCanceled(true);
		}
	}

	public boolean isTerminated() {
		return terminated;
	}

	public boolean isTerminateUser() {
		return terminateUser;
	}

	protected abstract IStatus doExecute() throws CoreException,
			InterruptedException;

	public IStatus getResultStatus() {
		return resultStatus;
	}

	public long getTime() {
		return time;
	}

	public IQ7NamedElement getActualElement() {
		return element;
	}

	public void updateStatus(State newStatus) {
		status = newStatus;
	}

	@Override
	public void postExecute() {
	}
}
