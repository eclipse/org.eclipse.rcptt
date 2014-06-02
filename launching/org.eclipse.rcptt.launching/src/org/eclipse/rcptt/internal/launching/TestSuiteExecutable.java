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
import org.eclipse.core.runtime.Status;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.IExecutable;

public class TestSuiteExecutable extends Executable {

	private final AutLaunch launch;
	private final ITestSuite testSuite;
	private final Executable[] kids;

	public TestSuiteExecutable(AutLaunch launch, ITestSuite testSuite,
			Executable[] children, boolean debug) {
		super(debug);
		this.launch = launch;
		this.testSuite = testSuite;
		kids = new Executable[children.length];
		if (children.length > 0) {
			System.arraycopy(children, 0, kids, 0, children.length);
		}
		for (Executable child : kids) {
			child.setParent(this);
		}
	}

	public String getName() {
		String nameByDocument = Q7SearchCore.findNameByDocument(testSuite);
		if (nameByDocument != null) {
			return nameByDocument;
		}

		try {
			return testSuite.getElementName();
		} catch (ModelException e) {
			return "Unresolved element";
		}
	}

	public AutLaunch getAut() {
		return launch;
	}

	public IQ7NamedElement getActualElement() {
		return testSuite;
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

	public boolean isTerminated() {
		for (IExecutable child : kids) {
			if (child.isTerminated())
				return true;
		}
		return false;
	}

	public int getStatus() {
		int status = 0;
		for (IExecutable child : kids) {
			status = Math.max(status, child.getStatus());
		}
		return status;
	}

	public int getType() {
		return TYPE_TESTSUITE;
	}

	public long getTime() {
		long total = 0;
		for (IExecutable child : kids) {
			total += child.getTime();
		}
		return total;
	}

	@Override
	public Executable[] getChildren() {
		return kids;
	}

	@Override
	public void startLaunching() {
		if (kids.length > 0) {
			kids[0].startLaunching();
		}
	}

	@Override
	public void terminate(boolean user) {
	}

	@Override
	public IStatus execute() throws InterruptedException {
		return Status.OK_STATUS;
	}

	@Override
	public void postExecute() {
	}

}
