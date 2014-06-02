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
package org.eclipse.rcptt.ctx.resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.DefaultContextMaker;
import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.ctx.internal.resources.Activator;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFileLink;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSFolderLink;
import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WSRoot;
import org.eclipse.rcptt.workspace.WorkspaceContext;
import org.eclipse.rcptt.workspace.WorkspaceFactory;

public class WorkspaceContextMaker extends DefaultContextMaker {

	@Override
	public Context create(Resource resource, ContextType type, String name) {
		WorkspaceContext context = (WorkspaceContext) super.create(resource,
				type, name);
		context.setContent(WorkspaceFactory.eINSTANCE.createWSRoot());
		return context;
	}

	@Override
	public void makeExecutable(Context context, IQ7NamedElement source)
			throws ModelException {
		makeSelfSufficientContext((WorkspaceContext) context,
				source.getModifiedPersistenceModel(), source);
	}

	public void makeSelfSufficientContext(WorkspaceContext context,
			IPersistenceModel model, IQ7NamedElement source)
			throws ModelException {
		if (model != null) {
			model.extractAll();
		}
		// Load and store all required resources into context object
		WSRoot root = context.getContent();
		if (root != null) {
			for (WSProject wsProject : root.getProjects()) {
				String location = source.getParent().getResource()
						.getLocation().toString();
				fillFilesContent(wsProject.getFiles(), location, model);
				fillFileLinksContent(wsProject.getFileLinks());

				EList<WSFolder> folders = wsProject.getFolders();
				processFolders(folders, location, model);

				fillFolderLinksContent(wsProject.getFolderLinks(), model);
			}

			fillFolderLinksContent(root.getProjectLinks(), model);
		}
	}

	private void processFolders(EList<WSFolder> folders, String location,
			IPersistenceModel model) throws ModelException {
		for (WSFolder wsFolder : folders) {
			EList<WSFolder> list = wsFolder.getFolders();
			processFolders(list, location, model);

			EList<WSFile> files = wsFolder.getFiles();
			fillFilesContent(files, location, model);

			EList<WSFileLink> fileLinks = wsFolder.getFileLinks();
			fillFileLinksContent(fileLinks);

			fillFolderLinksContent(wsFolder.getFolderLinks(), model);
		}
	}

	private void fillFilesContent(EList<WSFile> files, String location,
			IPersistenceModel model) {
		for (WSFile wsFile : files) {
			fillFile(location, wsFile, model);
		}
	}

	private void fillFileLinksContent(EList<WSFileLink> fileLinks)
			throws ModelException {
		for (WSFileLink fileLink : fileLinks)
			fillFileLink(fileLink);
	}

	private <T extends WSFolderLink> void fillFolderLinksContent(
			EList<T> folderLinks, IPersistenceModel model)
			throws ModelException {
		for (WSFolderLink folderLink : folderLinks)
			fillFolderLink(folderLink, model);
	}

	private void fillFolderLink(WSFolderLink folderLink, IPersistenceModel model)
			throws ModelException {
		try {
			WSUtils.loadFolderLinkWithContent(folderLink);
		} catch (IOException e) {
			Activator.log(e);
		} catch (CoreException e) {
			Activator.log(e);
		}
	}

	private void fillFile(String location, WSFile wsFile,
			IPersistenceModel model) {
		try {
			final byte[] content = WSUtils.getFileContent(location, wsFile,
					model);
			if (Q7Features.getInstance().isTrue(
					Q7Features.Q7_CONTEXTS_RESOURCES_ZIPPED_TRANSFER)) {

				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				ZipOutputStream zout = new ZipOutputStream(bout);
				zout.setLevel(9);
				zout.setMethod(ZipOutputStream.DEFLATED);
				ZipEntry entry = new ZipEntry("content");
				entry.setTime(1);
				zout.putNextEntry(entry);
				zout.write(content);

				zout.close();
				wsFile.setContent(bout.toByteArray());
			} else {
				wsFile.setContent(content);
			}
		} catch (IOException e) {
			Activator.log(e);
		}
	}

	private void fillFileLink(WSFileLink fileLink) throws ModelException {
		WSUtils.loadFileLinkWithContent(fileLink);
	}

	public void makeExecutableContext(WSFile child, IFile iFile) {
		if ("false".equals(Q7Features.getInstance().getValue(
				Q7Features.Q7_CONTEXTS_RESOURCES_TRANSFER_CONTENT))) {
			return;
		}
		try {
			InputStream contents = iFile.getContents();
			final byte[] content = WSUtils.getStreamContent(contents);
			contents.close();
			if (Q7Features.getInstance().isTrue(
					Q7Features.Q7_CONTEXTS_RESOURCES_ZIPPED_TRANSFER)) {

				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				ZipOutputStream zout = new ZipOutputStream(bout);
				zout.setLevel(9);
				zout.setMethod(ZipOutputStream.DEFLATED);
				ZipEntry entry = new ZipEntry("content");
				entry.setTime(1);
				zout.putNextEntry(entry);
				zout.write(content);
				zout.close();
				child.setContent(bout.toByteArray());
			} else {
				child.setContent(content);
			}
		} catch (IOException e) {
			Activator.log(e);
		} catch (CoreException e) {
			Activator.log(e);
		}
	}

	@Override
	public void captureContents(IContext context, Context data,
			IProgressMonitor monitor) throws CoreException {
		WorkspaceContext wsContext = (WorkspaceContext) data;
		WorkspaceContextImporter importer = new WorkspaceContextImporter(
				wsContext);

		IPersistenceModel model = context.getPersistenceModel();
		model.removeAll();
		try {
			WSRoot ownRoot = ((WorkspaceContext) context.getNamedElement())
					.getContent();
			ownRoot.getProjects().clear();
			List<WSProject> projects = wsContext.getContent().getProjects();
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
