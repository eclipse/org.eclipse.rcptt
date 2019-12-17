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
package org.eclipse.rcptt.ecl.filesystem.internal;

import static org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin.PLUGIN_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin;

public class JavaFile implements EclFile {
	private final File file;

	public JavaFile(File file) {
		if (file == null)
			throw new NullPointerException();
		this.file = file;
	}

	@Override
	public String getName() {
		return file.getName();
	}

	@Override
	public boolean exists() {
		return file.exists();
	}

	@Override
	public Collection<JavaFile> getChildren() throws CoreException {
		File[] array = file.listFiles();
		if (array == null)
			throw new CoreException(err("%s is not a directory", null));
		List<JavaFile> rv = new ArrayList<JavaFile>(array.length);
		for (File f : array) {
			rv.add(new JavaFile(f));
		}
		return rv;
	}

	@Override
	public URI toURI() {
		return file.toURI();
	}

	@Override
	public boolean isDirectory() {
		return file.isDirectory();
	}

	/**
	 * By default File#delete fails for non-empty directories, it works like "rm".
	 * We need something a little more brutual - this does the equivalent of "rm -r"
	 * 
	 * @param path
	 *            Root File Path
	 * @return true iff the file and all sub files/directories have been removed
	 * @throws IOException
	 */
	private static void deleteRecursive(File path) throws IOException {
		if (!path.exists())
			throw new FileNotFoundException(path.getAbsolutePath());
		if (path.isDirectory()) {
			for (File f : path.listFiles()) {
				deleteRecursive(f);
			}
		}
		if (!path.delete()) {
			throw new IOException("Failed to delete " + path);
		}
	}

	@Override
	public void delete() throws CoreException {
		try {
			deleteRecursive(file);
		} catch (FileNotFoundException e) {
			throw new CoreException(err("Failed to delete %s", e));
		} catch (IOException e) {
			throw new CoreException(err("Failed to delete %s", e));
		}
	}

	public static void copy(JavaFile src, JavaFile dst) throws CoreException, IOException {
		doCopyFile(src.file, dst.file);
	}

	private static void doCopyFile(File src, File dst) throws CoreException, IOException {
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

	private void copyStream(InputStream input, OutputStream output) throws CoreException, IOException {
		try {
			byte[] buffer = new byte[1024 * 1024];
			while (true) {
				int count = input.read(buffer);
				assert count != 0;
				if (count > 0) {
					output.write(buffer, 0, count);
				} else {
					// count < 0, eof
					return;
				}
			}
		} finally {
			input.close();
			output.close();
		}
	}

	@Override
	public void append(InputStream is) throws CoreException {
		mkdirs();

		try {
			FileOutputStream os = new FileOutputStream(file, true);
			copyStream(is, os);
		} catch (FileNotFoundException e) {
			throw new CoreException(err("Failed to append %s", e));
		} catch (IOException e) {
			throw new CoreException(err("Failed to append %s", e));
		}
	}

	@Override
	public void write(InputStream is) throws CoreException {
		mkdirs();

		try {
			FileOutputStream os = new FileOutputStream(file, false);
			copyStream(is, os);
		} catch (FileNotFoundException e) {
			throw new CoreException(err("Failed to write %s", e));
		} catch (IOException e) {
			throw new CoreException(err("Failed to write %s", e));
		}
	}

	private void mkdirs() throws CoreException {
		File parent = file.getParentFile();
		if (parent == null)
			return;
		parent.mkdirs();
	}

	@Override
	public InputStream read() throws CoreException {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new CoreException(err("Failed to read %s", e));
		}
	}

	private Status err(String message, Throwable e) {
		return new Status(IStatus.ERROR, PLUGIN_ID, String.format(message, this.toString()), e);
	}

	@Override
	public String toString() {
		return file.toString();
	}

	@Override
	public File toFile() {
		return file;
	}

}
