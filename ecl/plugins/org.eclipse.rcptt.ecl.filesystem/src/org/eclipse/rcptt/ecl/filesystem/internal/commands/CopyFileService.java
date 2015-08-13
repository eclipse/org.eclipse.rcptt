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
package org.eclipse.rcptt.ecl.filesystem.internal.commands;

import static org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin.createError;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.channels.FileChannel;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.filesystem.CopyFile;
import org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class CopyFileService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		CopyFile copyFile = (CopyFile) command;
		String src = copyFile.getSource();
		String dst = copyFile.getDestination();
		String name = copyFile.getName();

		if (src == null || src.length() == 0)
			return createError("Source file/directory is not specified.");

		if (dst == null || dst.length() == 0)
			return createError("Destination directory is not specified.");
		
		try {
			File srcFile = FileResolver.resolve(src).toFile().getCanonicalFile();
			if (!srcFile.exists())
				return createError("Source file/directory \"%s\" does not exist.",
						srcFile);

			File dstFile = FileResolver.resolve(dst).toFile().getCanonicalFile();
			if (dstFile.exists() && !dstFile.isDirectory())
				return createError("Destination \"%s\" must be a directory.", dstFile);

			if (!dstFile.exists() && !dstFile.mkdirs())
				return createError(
						"Unable to create the destination directory \"%s\".",
						dstFile);

			if (name != null && name.length() > 0)
				dstFile = new File(dstFile, name);
			else
				dstFile = new File(dstFile, srcFile.getName());

			if (srcFile.isFile())
				return copyFile(srcFile, dstFile);
			else if (srcFile.isDirectory())
				return copyDirectory(srcFile, dstFile);
			else
				return createError("Unsupported source type.");
		} catch (Exception e) {
			return createError(e.getMessage());
		}
	}

	private static IStatus copyFile(File src, File dst) throws IOException {
		if (dst.exists())
			return createError("Destination \"%s\" already exists.", dst);

		File parent = dst.getParentFile();
		if (parent != null && !parent.exists() && !parent.mkdirs())
			return createError("Unable to create the destination directory \"%s\".",
					parent);

		doCopyFile(src, dst);

		return Status.OK_STATUS;
	}

	private static void doCopyFile(File src, File dst) throws IOException {
		if (!dst.exists()) {
			dst.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {
			source = new FileInputStream(src).getChannel();
			destination = new FileOutputStream(dst).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
		try {
			if (src.canExecute() && !dst.setExecutable(true, true)) {
				EclFilesystemPlugin.logWarning(String.format(
						"Can't set executable permissions for %s",
						dst.getAbsolutePath()), null);
			}
		} catch (SecurityException e) {
			EclFilesystemPlugin.logWarning(String.format(
					"Can't set executable permissions for %s",
					dst.getAbsolutePath()), e);
		}
	}

	private static IStatus copyDirectory(File src, File dst) throws IOException {
		if (dst.exists())
			return createError("Destination \"%s\" already exists.", dst);

		if (isSourceIncludesDestination(dst, src))
			return createError("Destination \"%s\" is nested inside source \"%s\".",
					dst, src);

		if (!dst.mkdirs())
			return createError("Unable to create the destination directory \"%s\".",
					dst);

		copyFilesAndDirectories(src, dst);

		return Status.OK_STATUS;
	}

	private static boolean isSourceIncludesDestination(File dst, File src) {
		while (dst != null) {
			if (dst.equals(src))
				return true;
			dst = dst.getParentFile();
		}

		return false;
	}

	private static void copyFilesAndDirectories(File src, File dst)
			throws IOException {
		for (File f : src.listFiles()) {
			if (f.isFile())
				doCopyFile(f, new File(dst, f.getName()));
			else if (f.isDirectory()) {
				File dir = new File(dst, f.getName());
				if (!dir.exists() && !dir.mkdirs())
					throw new IOException(String.format(
							"Unable to create \"%s\" directory.", dir));
				copyFilesAndDirectories(f, dir);
			}
		}
	}

}
