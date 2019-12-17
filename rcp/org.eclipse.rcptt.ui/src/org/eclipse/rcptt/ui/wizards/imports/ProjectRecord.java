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
package org.eclipse.rcptt.ui.wizards.imports;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.internal.wizards.datatransfer.ILeveledImportStructureProvider;
import org.eclipse.ui.internal.wizards.datatransfer.TarEntry;

import org.eclipse.rcptt.internal.ui.Messages;

@SuppressWarnings("restriction")
public class ProjectRecord {
	public File projectSystemFile;

	public Object projectArchiveFile;

	String projectName;

	public Object parent;

	public int level;

	boolean hasConflicts;

	public IProjectDescription description;

	ILeveledImportStructureProvider structureProvider;

	/**
	 * Create a record for a project based on the info in the file.
	 * 
	 * @param file
	 */
	ProjectRecord(File file) {
		projectSystemFile = file;
		setProjectName();
	}

	/**
	 * @param file
	 *            The Object representing the .project file
	 * @param parent
	 *            The parent folder of the .project file
	 * @param level
	 *            The number of levels deep in the provider the file is
	 */
	public ProjectRecord(ILeveledImportStructureProvider structureProvider,
			Object file, Object parent, int level) {
		this.structureProvider = structureProvider;
		this.projectArchiveFile = file;
		this.parent = parent;
		this.level = level;
		setProjectName();
	}

	/**
	 * Set the name of the project based on the projectFile.
	 */
	private void setProjectName() {
		try {
			if (projectArchiveFile != null) {
				InputStream stream = structureProvider
						.getContents(projectArchiveFile);

				// If we can get a description pull the name from there
				if (stream == null) {
					if (projectArchiveFile instanceof ZipEntry) {
						IPath path = new Path(((ZipEntry) projectArchiveFile)
								.getName());
						projectName = path.segment(path.segmentCount() - 2);
					} else if (projectArchiveFile instanceof TarEntry) {
						IPath path = new Path(((TarEntry) projectArchiveFile)
								.getName());
						projectName = path.segment(path.segmentCount() - 2);
					}
				} else {
					description = ResourcesPlugin.getWorkspace()
							.loadProjectDescription(stream);
					stream.close();
					projectName = description.getName();
				}

			}

			// If we don't have the project name try again
			if (projectName == null) {
				IPath path = new Path(projectSystemFile.getPath());
				// if the file is in the default location, use the directory
				// name as the project name
				if (isDefaultLocation(path)) {
					projectName = path.segment(path.segmentCount() - 2);
					description = ResourcesPlugin.getWorkspace()
							.newProjectDescription(projectName);
				} else {
					description = ResourcesPlugin.getWorkspace()
							.loadProjectDescription(path);
					projectName = description.getName();
				}

			}
		} catch (CoreException e) {
			// no good couldn't get the name
		} catch (IOException e) {
			// no good couldn't get the name
		}
	}

	/**
	 * Returns whether the given project description file path is in the default
	 * location for a project
	 * 
	 * @param path
	 *            The path to examine
	 * @return Whether the given path is the default location for a project
	 */
	private boolean isDefaultLocation(IPath path) {
		// The project description file must at least be within the project,
		// which is within the workspace location
		if (path.segmentCount() < 2)
			return false;
		return path.removeLastSegments(2).toFile().equals(
				Platform.getLocation().toFile());
	}

	/**
	 * Get the name of the project
	 * 
	 * @return String
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Gets the label to be used when rendering this project record in the UI.
	 * 
	 * @return String the label
	 * @since 3.4
	 */
	public String getProjectLabel() {
		if (description == null)
			return projectName;

		String path = projectSystemFile == null ? structureProvider
				.getLabel(parent) : projectSystemFile.getParent();

		return NLS.bind(Messages.ProjectRecord_ProjectLabelFormat, projectName, path);
	}

	/**
	 * @return Returns the hasConflicts.
	 */
	public boolean hasConflicts() {
		return hasConflicts;
	}

}
