/*******************************************************************************
 * Copyright (c) 2009, 2020 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.ecl.runtime;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

public interface IProcess {

	public static final int TIMEOUT_CODE = 123130;
	public static final int INTERNAL_AUT_FAILURE = 123131;

	IPipe getInput();

	IPipe getOutput();

	ISession getSession();

	IStatus waitFor() throws InterruptedException;

	IStatus waitFor(long timeout, IProgressMonitor monitor) throws InterruptedException;

	boolean isAlive();
}
