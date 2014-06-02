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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.p2.engine.IProfile;
import org.eclipse.equinox.p2.engine.IProfileRegistry;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.operations.ProvisioningJob;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.UpdateOperation;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.commands.UpdateFeature;
import org.eclipse.rcptt.ecl.platform.internal.PlatformPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class UpdateFeatureService implements ICommandService {

	
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		UpdateFeature updateFeature = (UpdateFeature) command;
		String featureId = updateFeature.getId();
		
		ProvisioningSession session = PlatformPlugin.createProvisioningSession();
		
		IProfile profile = PlatformPlugin.getProfileRegistry().getProfile(IProfileRegistry.SELF);
		IQuery<IInstallableUnit> query = QueryUtil.createLatestQuery(QueryUtil.createIUQuery(featureId));
		IQueryResult<IInstallableUnit> result = profile.query(query, new NullProgressMonitor());
		
		if(result.isEmpty()) {
			return Status.OK_STATUS;
		}
		
		UpdateOperation op = new UpdateOperation(session, result.toSet());
		IStatus status = op.resolveModal(new NullProgressMonitor());
		
		if (status.getCode() == UpdateOperation.STATUS_NOTHING_TO_UPDATE) {
			return Status.OK_STATUS;
		}
		if (status.getSeverity() == IStatus.CANCEL) {
			//should not happen, 
			throw new CoreException(status);
		}
		
		if (status.getSeverity() == IStatus.ERROR) {
			throw new CoreException(status);
		}
		
		ProvisioningJob job = op.getProvisioningJob(null);
		if(job == null) {
			return Status.OK_STATUS;
		}
		
		status = job.runModal(new NullProgressMonitor());
		if (status.getSeverity() == IStatus.CANCEL)
			throw new CoreException(status);
		
		return Status.OK_STATUS;
	}

}
