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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.IExecutable;

public class GroupExecutable extends Executable {

	private final Executable[] kids;
	private String name;
	private final Executable root;

	public GroupExecutable(Executable root, List<Executable> group) {
		super(root.isDebug());

		this.root = root;
		this.kids = group.toArray(new Executable[group.size()]);
	}

	public boolean isTerminated() {
		for (IExecutable child : kids) {
			if (child.isTerminated())
				return true;
		}
		return false;
	}

	public AutLaunch getAut() {
		return getRoot().getAut();
	}

	@Override
	public void terminate(boolean user) {
	}

	@Override
	public void startLaunching() {
		if (kids.length > 0) {
			kids[0].startLaunching();
		}
	}

	public IQ7NamedElement getActualElement() {
		return getRoot().getActualElement();
	}

	public Executable getRoot() {
		return root;
	}

	@Override
	public Executable[] getChildren() {
		return kids;
	}

	@Override
	public IStatus execute() throws InterruptedException {
		return Status.OK_STATUS;
	}

	public String getName() {
		if (name != null) {
			return name;
		}
		return getRoot().getName();
	}

	public IStatus getResultStatus() {
		for (IExecutable child : kids) {
			IStatus status = child.getResultStatus();
			if (status != null && !status.isOK()) {
				return status;
			}
		}
		return Status.OK_STATUS;
	}

	public int getType() {
		return getRoot().getType();
	}

	public long getTime() {
		long total = 0;
		for (IExecutable child : kids) {
			total += child.getTime();
		}
		return total;
	}

	public int getStatus() {
		int status = 0;
		for (IExecutable child : kids) {
			status = Math.max(status, child.getStatus());
		}
		return status;
	}

	@Override
	public void postExecute() {
	}

	@Override
	public String getId() {
		return getRoot().getId();
	}

	public void setName(String name) {
		this.name = name;
	}
}
