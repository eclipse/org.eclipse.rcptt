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

package org.eclipse.rcptt.ecl.runtime;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;

public interface ISession {

	public final static long DEFAULT_TAKE_TIMEOUT = 1000;

	IProcess execute(Command command) throws CoreException;

	IProcess execute(Command command, IPipe in, IPipe out) throws CoreException;

	IPipe createPipe();

	/**
	 * FIXME This is temporary method. Need to rethink this
	 */
	//void reconnect() throws CoreException;

	void close() throws CoreException;

	boolean isClosed();
	
	/**
	 * Return property associated with session. Could be used with chained ECL command execution.
	 * @param key
	 * @return
	 */
	Object getProperty(String key);
	/**
	 * Set property associated with session.
	 * @param key
	 * @param value
	 */
	void putProperty( String key, Object value);
}
