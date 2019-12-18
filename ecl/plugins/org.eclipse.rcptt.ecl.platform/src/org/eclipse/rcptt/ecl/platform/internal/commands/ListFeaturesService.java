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
import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.objects.Feature;
import org.eclipse.rcptt.ecl.platform.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ListFeaturesService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		for(IBundleGroupProvider provider : Platform.getBundleGroupProviders()) {
			for(IBundleGroup group : provider.getBundleGroups()) {
				Feature feature = ObjectsFactory.eINSTANCE.createFeature();
				feature.setId(group.getIdentifier());
				feature.setVersion(group.getVersion());
				feature.setProvider(group.getProviderName());
				feature.setName(group.getName());
				context.getOutput().write(feature);
			}
		}
		context.getOutput().close(Status.OK_STATUS);
		return Status.OK_STATUS;
	}
	
}
