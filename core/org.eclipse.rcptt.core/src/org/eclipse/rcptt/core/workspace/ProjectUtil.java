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
package org.eclipse.rcptt.core.workspace;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import org.eclipse.rcptt.core.nature.RcpttNature;

/**
 * Utility class for importing all prjects from workspace directory which are
 * not already imported
 * 
 * @author ivaninozemtsev
 * 
 */
public class ProjectUtil {
	public static IProject[] projects() {
		return ResourcesPlugin.getWorkspace().getRoot().getProjects();
	}

	private static void openProjects(PrintStream out) throws CoreException {
		print(out, "Refreshing projects:%n");
		for (IProject project : projects()) {
			print(out, "    %s... ", project.getName());
			if (project.isOpen()) {
				print(out, "OK%n");
				continue;
			}

			try {
				project.open(new NullProgressMonitor());
				RcpttNature.updateProjectNature(project, true);
				project.refreshLocal(IResource.DEPTH_INFINITE,
						new NullProgressMonitor());
			} catch (CoreException e) {
				throw printAndThrow(out, e.getStatus());
			}

			print(out, "OK%n");
		}
	}

	public static void importProjects(File[] projectDirs, PrintStream out)
			throws CoreException {
		importProjects(Arrays.asList(projectDirs), out);
	}

	public static void importProjects(List<File> projectDirs, PrintStream out)
			throws CoreException {
		Set<File> projectsToImport = new LinkedHashSet<File>();
		Set<File> existingProjects = new HashSet<File>(existingProjects());
		print(out, "Existing projects in workspace:%n");
		printFiles(out, existingProjects);
		for (File file : projectDirs) {
			collectProjects(file, projectsToImport, existingProjects);
		}

		if (projectsToImport.isEmpty()) {
			print(out, "No projects to import%n");
			return;
		}

		print(out, "Importing projects to workspace:%n");
		for (File file : projectsToImport) {
			print(out, "    %s... ", file.getAbsolutePath());
			IStatus result = importProject(file);

			if (result.isOK()) {
				print(out, "OK%n");
				continue;
			}

			throw printAndThrow(out, result);
		}

		openProjects(out);
	}

	private static void printFiles(PrintStream out, Collection<File> files) {
		if (files.isEmpty()) {
			print(out, "    <none>%n");
			return;
		}

		for (File file : files) {
			print(out, "    %s%n", file.getAbsolutePath());
		}
	}

	private static void print(PrintStream out, String format, Object... args) {
		if (out == null) {
			return;
		}

		out.print(String.format(format, args));
	}

	private static CoreException printAndThrow(PrintStream out, IStatus status) {
		print(out, "ERROR %s%n", status.getMessage());
		if (status.getException() != null) {
			status.getException().printStackTrace(out);
		}
		return new CoreException(status);
	}

	private static void collectProjects(File dir, Set<File> result,
			Set<File> ignore) {
		if (dir == null || !dir.isDirectory()) {
			return;
		}

		if (ignore.contains(dir)) {
			return;
		}

		if (isProject(dir)) {
			result.add(dir);
			return;
		}

		for (File child : dir.listFiles()) {
			collectProjects(child, result, ignore);
		}
	}

	private static File getDescriptor(File projectDir) {
		return new File(projectDir, IProjectDescription.DESCRIPTION_FILE_NAME);
	}

	private static boolean isDefaultLocation(IPath path) {
		if (path.segmentCount() < 2)
			return false;
		return path.removeLastSegments(2).toFile()
				.equals(Platform.getLocation().toFile());
	}

	private static IStatus importProject(File dir) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		File descriptorFile = getDescriptor(dir);
		IPath descriptorPath = new Path(descriptorFile.getAbsolutePath());
		IPath locationPath = new Path(dir.getAbsolutePath());

		IProjectDescription description;
		String projectName;
		if (isDefaultLocation(descriptorPath)) {
			projectName = descriptorPath
					.segment(descriptorPath.segmentCount() - 2);
			description = workspace.newProjectDescription(projectName);
		} else {
			try {
				description = workspace.loadProjectDescription(descriptorPath);
			} catch (CoreException e) {
				return e.getStatus();
			}
			projectName = description.getName();
		}

		description.setLocation(locationPath);
		IProject project = workspace.getRoot().getProject(projectName);
		try {
			project.create(description, new NullProgressMonitor());
		} catch (CoreException e) {
			return e.getStatus();
		}
		return Status.OK_STATUS;
	}

	private static boolean isProject(File file) {
		return file.isDirectory() && getDescriptor(file).exists();
	}

	private static List<File> existingProjects() {
		List<File> result = new ArrayList<File>();
		for (IProject project : ResourcesPlugin.getWorkspace().getRoot()
				.getProjects()) {
			result.add(new File(project.getLocation().toOSString()));
		}
		return result;
	}
}
