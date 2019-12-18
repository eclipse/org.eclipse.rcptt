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
package org.eclipse.rcptt.ecl.platform.internal.commands;

import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.commands.AddRepository;
import org.eclipse.rcptt.ecl.platform.util.EclPlatformUtil;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class AddRepositoryService extends RepositoryService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		AddRepository addSite = (AddRepository) command;
		
		URI uri = getUri(addSite.getUri());
		String name = addSite.getName();
		
		EclPlatformUtil.addRepository(uri, name);
		
		return Status.OK_STATUS;
	}

}
