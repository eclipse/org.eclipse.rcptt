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
package org.eclipse.rcptt.launching;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

public interface IExecutable {
	enum State {
		PASSED,
		WAITING,
		LAUNCHING,
		FAILED
	}
	
	public static final int TYPE_SCENARIO = 0;

	public static final int TYPE_CONTEXT = 1;

	public static final int TYPE_TESTSUITE = 2;

	public static final int TYPE_VERIFICATION = 3;

	public String getName();

	public AutLaunch getAut();

	public boolean isDebug();

	public IQ7NamedElement getActualElement();

	public IExecutable[] getChildren();

	public IStatus getResultStatus();

	public Report getResultReport();

	public boolean isTerminated();

	public State getStatus();

	public int getType();

	public long getTime();

	public String getId();

	public ExecutionPhase getPhase();
}
