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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.objects.LaunchConfiguration;
import org.eclipse.rcptt.ecl.platform.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ListLaunchConfigurationsService implements ICommandService {

	
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		for (ILaunchConfiguration c : DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurations()) {
			LaunchConfiguration conf = ObjectsFactory.eINSTANCE.createLaunchConfiguration();
			
			conf.setName(c.getName());
			
			context.getOutput().write(conf);
		}
		
		context.getOutput().close(Status.OK_STATUS);
		return Status.OK_STATUS;
	}
	
}
