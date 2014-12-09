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

import org.eclipse.core.runtime.IStatus;

import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

public abstract class Executable implements IExecutable {

	protected static final Executable[] EMPTY = new Executable[0];

	public abstract Executable[] getChildren();

	public abstract void startLaunching();

	public abstract void terminate(boolean user);

	protected abstract IStatus execute() throws InterruptedException;

	private Executable parent;
	private final ExecutionPhase phase;

	protected Executable getParent() {
		return parent;
	}

	protected void setParent(Executable parent) {
		this.parent = parent;
	}

	protected Executable(boolean debug) {
		this(debug, ExecutionPhase.AUTO);
	}

	protected Executable(boolean debug, ExecutionPhase phase) {
		this.debug = debug;
		this.phase = phase;
	}

	public boolean isDebug() {
		return debug;
	}

	public void dispose() {
		Executable[] childs = getChildren();
		if (childs != null) {
			for (Executable child : childs) {
				child.dispose();
			}
		}
	}

	public abstract void postExecute();

	public Report getResultReport() {
		return null;
	}

	public String getId() {
		return null;
	}

	private final boolean debug;

	public ExecutionPhase getPhase() {
		return phase;
	}

	public static State max(State a, State b) {
		return a.ordinal() >= b.ordinal() ? a : b;
	}
}
