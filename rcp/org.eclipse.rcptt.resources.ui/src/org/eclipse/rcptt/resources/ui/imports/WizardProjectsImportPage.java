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
package org.eclipse.rcptt.resources.ui.imports;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.persistence.PersistenceManager;
import org.eclipse.rcptt.resources.ImportUtils;
import org.eclipse.rcptt.resources.WSUtils;
import org.eclipse.rcptt.ui.wizards.imports.BaseProjectsImportPage;
import org.eclipse.rcptt.ui.wizards.imports.ProjectRecord;
import org.eclipse.rcptt.util.FileUtil;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WorkspaceData;
import org.eclipse.rcptt.workspace.WorkspaceFactory;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.IImportStructureProvider;

public class WizardProjectsImportPage extends BaseProjectsImportPage {

	private WorkspaceData workspaceData;

	public WizardProjectsImportPage(WorkspaceData workspaceData) {
		this(workspaceData, null);
	}

	/**
	 * More (many more) parameters.
	 * 
	 * @param pageName
	 * @param initialPath
	 * @param currentSelection
	 * @since 3.5
	 */
	public WizardProjectsImportPage(WorkspaceData workspaceData, String initialPath) {
		super(initialPath);
		this.workspaceData = workspaceData;
	}

	@SuppressWarnings("restriction")
	protected boolean createExistingProject(final ProjectRecord record,
			IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		String projectName = record.getProjectName();
		WSProject project = WorkspaceFactory.eINSTANCE.createWSProject();
		project.setName(projectName);

		if (record.projectArchiveFile != null) {
			// import from archive
			List<?> fileSystemObjects = structureProvider
					.getChildren(record.parent);
			structureProvider.setStrip(record.level);
			workspaceData.getContent().getProjects().add(project);
			IPersistenceModel model = PersistenceManager.getInstance().getModel(
					workspaceData.eResource());
			if (model != null) {
				for (Object object : fileSystemObjects) {
					importFileSystemObject(object, structureProvider, project,
							model);
				}
			}
			return true;
		}
		// import from file system
		File importSource = null;
		URI locationURI = record.description.getLocationURI();
		// if location is null, project already exists in this location or
		// some error condition occured.
		if (locationURI != null) {
			importSource = new File(locationURI);
		}
		if (importSource == null) {
			importSource = record.projectSystemFile.getParentFile();
		}

		// import operation to import project files if copy checkbox is
		// selected
		if (importSource != null) {
			workspaceData.getContent().getProjects().add(project);
			FileSystemStructureProvider provider = FileSystemStructureProvider.INSTANCE;
			List<?> filesToImport = provider.getChildren(importSource);
			IPersistenceModel model = PersistenceManager.getInstance().getModel(
					workspaceData.eResource());
			if (model != null) {
				for (Object object : filesToImport) {
					importFileSystemObject(object, provider, project, model);
				}
			}
		}

		return true;
	}

	private void importFileSystemObject(Object object,
			IImportStructureProvider provider, WSProject project,
			IPersistenceModel model) {
		if (provider.isFolder(object)) {
			IPath fullPath = new Path(provider.getFullPath(object));
			WSFolder folder = WSUtils.getFolder(project,
					fullPath.lastSegment(), true);
			importFolder(folder, provider.getChildren(object), model, provider);
		} else {
			IPath fullPath = new Path(provider.getFullPath(object));
			WSFile file = WSUtils
					.getFile(project, fullPath.lastSegment(), true);
			String fName = ImportUtils.getName(file);
			OutputStream store = model.store(fName);
			InputStream inputStream = provider.getContents(object);
			try {
				FileUtil.copy(inputStream, store);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private void importFolder(WSFolder root, List children,
			IPersistenceModel model, IImportStructureProvider provider) {
		for (Object object : children) {
			if (provider.isFolder(object)) {
				IPath fullPath = new Path(provider.getFullPath(object));
				WSFolder folder = WSUtils.getFolder(root,
						fullPath.lastSegment(), true);
				importFolder(folder, provider.getChildren(object), model,
						provider);
			} else {
				IPath fullPath = new Path(provider.getFullPath(object));
				WSFile file = WSUtils.getFile(root, fullPath.lastSegment(),
						true);
				String fName = ImportUtils.getName(file);
				OutputStream store = model.store(fName);
				InputStream inputStream = provider.getContents(object);
				try {
					FileUtil.copy(inputStream, store);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected boolean isProjectExists(String projectName) {
		if (projectName == null) {
			return false;
		}
		for (WSProject project : workspaceData.getContent().getProjects()) {
			if (projectName.equals(project.getName())) {
				return true;
			}
		}
		return false;
	}

}
