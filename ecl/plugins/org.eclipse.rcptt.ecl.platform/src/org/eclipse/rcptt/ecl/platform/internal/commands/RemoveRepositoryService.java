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
package org.eclipse.rcptt.ecl.platform.internal.commands;

import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.commands.RemoveRepository;
import org.eclipse.rcptt.ecl.platform.util.EclPlatformUtil;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class RemoveRepositoryService extends RepositoryService {

	
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		RemoveRepository removeSite = (RemoveRepository) command;
		URI uri = getUri(removeSite.getUri()); 
		EclPlatformUtil.removeRepository(uri);
		return Status.OK_STATUS;
	}

}
