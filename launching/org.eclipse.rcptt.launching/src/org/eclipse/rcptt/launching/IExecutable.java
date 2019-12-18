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
package org.eclipse.rcptt.launching;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

public interface IExecutable {
	enum State {
		COMPLETED,
		WAITING,
		RUNNING
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

	public State getStatus();

	public int getType();

	public long getTime();

	public String getId();

	public ExecutionPhase getPhase();
}
