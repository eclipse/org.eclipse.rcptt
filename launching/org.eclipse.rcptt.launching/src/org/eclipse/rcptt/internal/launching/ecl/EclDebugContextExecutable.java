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
package org.eclipse.rcptt.internal.launching.ecl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.TestCaseDebugger;

public class EclDebugContextExecutable extends EclContextExecutable {

	public EclDebugContextExecutable(AutLaunch launch, IContext context,
			TestCaseDebugger debugger) {
		super(launch, context, true);
		this.debugger = debugger;
	}

	protected void doExecuteContext(IProgressMonitor monitor) throws CoreException {
		launch.debug(getActualElement(), monitor, debugger, getPhase());
	}

	private final TestCaseDebugger debugger;

}
