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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;

public interface ILaunchExecutor {

	public ILaunch launch(String mode, ILaunchConfiguration config,
			IProgressMonitor monitor) throws CoreException;

	public void waitForRestart(BaseAutLaunch launch, IProgressMonitor monitor)
			throws CoreException;

}
