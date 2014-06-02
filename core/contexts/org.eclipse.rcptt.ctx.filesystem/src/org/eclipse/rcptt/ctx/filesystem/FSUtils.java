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
package org.eclipse.rcptt.ctx.filesystem;

import static org.eclipse.rcptt.ctx.filesystem.FilesystemContextPlugin.createErr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.rcptt.filesystem.FSFile;
import org.eclipse.rcptt.filesystem.FSFolder;
import org.eclipse.rcptt.filesystem.FSResource;
import org.eclipse.rcptt.filesystem.FilesystemContext;
import org.eclipse.rcptt.filesystem.FilesystemFactory;
import org.eclipse.rcptt.util.FileUtil;

public class FSUtils {

	private static final FilesystemFactory factory = FilesystemFactory.eINSTANCE;

	public static void apply(FilesystemContext context,
			FileSystemResolver resolver) throws CoreException {
		String path = context.getPath();
		if (path == null)
			path = "";

		if (path.equals(PrefixScheme.WORKSPACE))
			throw new CoreException(
					createErr("Cannot clear entire workspace. Please use workspace context for that purpose."));
		if (path.equals(PrefixScheme.HOME)) {
			throw new CoreException(
					createErr("Cannot clear user's home directory. Please use more detailed root path."));
		}
		String resolved = resolver.resolve(path);
		if (resolved == null)
			resolved = path;

		try {
			File filePath = new File(resolved);

			if (context.isClear() && filePath.exists()) {
				if (filePath.isDirectory())
					FileUtil.deleteFile(filePath, false);
				if (filePath.exists()
						&& (filePath.isFile() || (filePath.isDirectory() && filePath
								.listFiles().length > 0)))
					throw new CoreException(createErr("Unable to clear '%s'",
							resolved));
			}

			if (!filePath.exists() && !filePath.mkdirs())
				throw new CoreException(createErr("Unable to create '%s'",
						resolved));

			if (context.getRoot() != null)
				apply(context.getRoot(), filePath);
		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(createErr(e, "Error while applying '%s'",
					resolved));
		}
	}

	private static void apply(FSFolder folder, File path) throws CoreException {
		try {
			for (FSFile f : folder.getFiles()) {
				File filePath = new File(path, f.getName());
				if ((!filePath.exists() && !filePath.createNewFile())
						|| !filePath.isFile())
					throw new CoreException(new Status(IStatus.ERROR,
							FilesystemContextPlugin.PLUGIN_ID,
							"Unable to create " + filePath));

				save(f, filePath);
			}

			for (FSFolder f : folder.getFolders()) {
				File folderPath = new File(path, f.getName());
				if ((!folderPath.exists() && !folderPath.mkdirs())
						|| !folderPath.isDirectory())
					throw new CoreException(new Status(IStatus.ERROR,
							FilesystemContextPlugin.PLUGIN_ID,
							"Unable to create " + folderPath));

				apply(f, folderPath);
			}
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR,
					FilesystemContextPlugin.PLUGIN_ID, "Error while applying "
							+ path.toString(), e));
		}
	}

	public static void capture(FilesystemContext context, String path,
			FileSystemResolver resolver) throws CoreException {
		if (path == null)
			path = "";

		FSFolder root = factory.createFSFolder();
		String resolved = resolver.resolve(path);
		if (resolved == null)
			resolved = path;

		capture(root, new File(resolved));

		context.setRoot(root);
	}

	private static final FSFile[] EMPTY_FILES = new FSFile[0];

	public static FSFile[] addFiles(FSFolder parent, File[] files)
			throws CoreException {
		String parentName = parent.getName() == null ? "Context" : parent
				.getName();
		File duplicate = findFirstDuplicate(files);
		if (duplicate != null)
			throw new CoreException(createErr("Name collision detected: '%s'",
					duplicate.getName()));

		List<FSFile> result = new ArrayList<FSFile>();
		for (File f : files) {
			if (findResource(f.getName(), parent) != null)
				throw new CoreException(createErr(
						"%s already contains file '%s'", parentName,
						f.getName()));

			FSFile file = factory.createFSFile();
			file.setName(f.getName());
			load(file, f);
			parent.getFiles().add(file);
			result.add(file);
		}
		return result.toArray(EMPTY_FILES);
	}

	public static FSResource findResource(String name, FSFolder folder) {
		for (FSResource r : folder.getFolders())
			if (r.getName().equalsIgnoreCase(name))
				return r;

		for (FSResource r : folder.getFiles())
			if (r.getName().equalsIgnoreCase(name))
				return r;

		return null;
	}

	public static FSFolder addFolder(FSFolder parent, String path)
			throws CoreException {
		File folderPath = new File(path);
		String name = folderPath.getName();
		String parentName = parent.getName() == null ? "Context" : parent
				.getName();
		if (findResource(folderPath.getName(), parent) != null) {
			throw new CoreException(createErr(
					"%s already contains folder '%s'", parentName, name));
		}

		FSFolder newFolder = factory.createFSFolder();
		newFolder.setName(folderPath.getName());
		capture(newFolder, folderPath);
		parent.getFolders().add(newFolder);
		return newFolder;
	}

	public static void remove(FSResource resource) {
		EReference ref = resource.eContainmentFeature();
		List<?> list = (List<?>) resource.eContainer().eGet(ref);
		list.remove(resource);
	}

	private static File findFirstDuplicate(File[] list) {
		Set<String> members = new HashSet<String>();
		for (File f : list)
			if (!members.add(f.getName().toLowerCase()))
				return f;
		return null;
	}

	private static void capture(FSFolder folder, File path)
			throws CoreException {
		try {
			if (!path.exists() || !path.isDirectory()) {
				throw new CoreException(
						createErr("Directory '%s' does not exist",
								path.getAbsolutePath()));
			}

			File[] files = path.listFiles();
			if (files == null)
				return;

			File duplicate = findFirstDuplicate(files);
			if (duplicate != null)
				throw new CoreException(createErr(
						"Name collision detected: '%s'", duplicate.getName()));

			for (File f : files) {
				if (f.isDirectory()) {
					FSFolder newFolder = factory.createFSFolder();
					newFolder.setName(f.getName());
					capture(newFolder, f);
					folder.getFolders().add(newFolder);
				} else if (f.isFile() /* ;) */) {
					FSFile newFile = factory.createFSFile();
					newFile.setName(f.getName());
					load(newFile, f);
					folder.getFiles().add(newFile);
				}
			}
		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(createErr(e,
					"Error while capturing '%s':\n\n%s",
					path.getAbsolutePath(), e.getMessage()));
		}

	}

	private static void save(FSFile f, File file) throws FileNotFoundException,
			IOException {
		byte[] data = f.getData();
		if (data != null) {
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(file));
			stream.write(data, 0, data.length);
			stream.close();
		}
	}

	private static void load(FSFile file, File path) throws CoreException {
		if (!path.exists()) {
			throw new CoreException(createErr("File '%s' does not exist",
					path.getAbsolutePath()));
		}
		try {
			file.setData(getStreamContent(new BufferedInputStream(
					new FileInputStream(path))));
		} catch (IOException e) {
			throw new CoreException(createErr("Error reading file '%s'",
					path.getAbsolutePath()));
		}
	}

	private static byte[] getStreamContent(InputStream stream)
			throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			byte[] buffer = new byte[4096];
			int len = 0;
			while ((len = stream.read(buffer)) > 0) {
				output.write(buffer, 0, len);
			}
		} finally {
			safeClose(stream);
		}
		return output.toByteArray();
	}

	private static void safeClose(Closeable closeable) {
		try {
			closeable.close();
		} catch (Exception e) {
		}
	}

}
