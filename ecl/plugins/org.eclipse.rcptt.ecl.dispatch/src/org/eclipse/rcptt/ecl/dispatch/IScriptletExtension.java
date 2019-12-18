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
package org.eclipse.rcptt.ecl.dispatch;

import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;

public interface IScriptletExtension extends ICommandService {

	/** Tests the command for compatibility with this extension
	 * Only one extension should be compatible with any given command
	 * @return true if this extension can (and is designed to) handle a command
	 */
	boolean canHandle(Command command);

}
