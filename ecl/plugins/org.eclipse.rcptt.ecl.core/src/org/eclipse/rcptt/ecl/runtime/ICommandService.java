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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.Command;

/** Executes a command
 * Handles a set of supported commands.
 * */
public interface ICommandService {
	
	/**
	 * Executes a command.
	 * @param command - a command supported by this service. Usually a service is explicitly registered to handle specific commands. See {@link org.eclipse.rcptt.ecl.internal.core.CorePlugin.getScriptletManager}. 
	 * @param context - provides support for command's input, output and context
	 * @return execution status
	 */
	IStatus service(Command command, IProcess context) throws InterruptedException, CoreException;

}
