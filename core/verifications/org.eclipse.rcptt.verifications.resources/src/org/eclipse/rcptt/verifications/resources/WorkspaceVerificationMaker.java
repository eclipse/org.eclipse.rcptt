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
package org.eclipse.rcptt.verifications.resources;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.rcptt.core.DefaultVerificationMaker;
import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.resources.ImportUtils;
import org.eclipse.rcptt.resources.WSUtils;
import org.eclipse.rcptt.resources.WorkspaceDataImporter;
import org.eclipse.rcptt.resources.WorkspaceDataMaker;
import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WSRoot;
import org.eclipse.rcptt.workspace.WorkspaceFactory;
import org.eclipse.rcptt.workspace.WorkspaceVerification;

public class WorkspaceVerificationMaker extends DefaultVerificationMaker {

	private WorkspaceDataMaker maker;

	public WorkspaceVerificationMaker() {
		this.maker = new WorkspaceDataMaker();
	}

	@Override
	public Verification create(Resource resource, VerificationType type, String name) {
		WorkspaceVerification verification = (WorkspaceVerification) super.create(resource,
				type, name);
		verification.setContent(WorkspaceFactory.eINSTANCE.createWSRoot());
		return verification;
	}

	@Override
	public void makeExecutable(Verification verification, IQ7NamedElement source)
			throws ModelException {
		maker.makeSelfSufficientData((WorkspaceVerification) verification,
				source.getModifiedPersistenceModel(), source);
	}

	@Override
	public void captureContents(IVerification verifiacion, Verification data,
			IProgressMonitor monitor) throws CoreException {
		WorkspaceVerification verification = (WorkspaceVerification) data;
		WorkspaceDataImporter importer = new WorkspaceDataImporter(verification);

		IPersistenceModel model = verifiacion.getPersistenceModel();
		model.removeAll();
		try {
			WSRoot ownRoot = ((WorkspaceVerification) verifiacion.getNamedElement())
					.getContent();
			ownRoot.getProjects().clear();
			List<WSProject> projects = verification.getContent().getProjects();
			if (projects.size() > 0) {
				monitor.beginTask("Copy projects...", projects.size());
				for (WSProject project : projects) {
					WSProject ownProject = WSUtils.getProject(ownRoot,
							project.getName(), true);
					ImportUtils.importFiles(ownProject, project.getFiles(),
							model, importer);
					ImportUtils.importFolders(ownProject, project.getFolders(),
							model, importer);
				}
			}
		} catch (Exception e) {
			throw new CoreException(RcpttPlugin.createStatus(e));
		}
	}

}
