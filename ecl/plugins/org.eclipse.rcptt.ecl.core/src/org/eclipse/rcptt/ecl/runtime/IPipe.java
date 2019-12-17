/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.ecl.runtime;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

public interface IPipe {
	/**
	 * Take an object from the pipe.
	 * 
	 * @param timeout
	 *            How long the client is willing to wait for a proper matching
	 *            entry.
	 * @return object or status
	 * @throws CoreException
	 */
	Object take(long timeout) throws CoreException;

	/**
	 * Write a new object into the pipe.
	 * 
	 * @param object
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws CoreException
	 * @throws CoreException
	 */
	IPipe write(Object object) throws CoreException;

	/**
	 * Close pipe. If status is null
	 * {@link org.eclipse.core.runtime.CoreExeption <em>CoreExeption</em>} will
	 * be thrown
	 * 
	 * @param status
	 * @throws CoreException
	 * @throws InterruptedException
	 */
	IPipe close(IStatus status) throws CoreException;

	void reinit();

	boolean isClosed();

}
