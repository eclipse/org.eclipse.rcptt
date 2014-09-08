package org.eclipse.rcptt.ecl.filesystem.internal;

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
	public Collection<EclFile> getChildren() throws IOException {
		File[] array = file.listFiles();
		if (array == null)
			throw new IOException("" + file + " is not a directory");
		List<EclFile> rv = new ArrayList<EclFile>(array.length);
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
	 * @throws FileNotFoundException
	 */
	private static boolean deleteRecursive(File path) throws FileNotFoundException {
		if (!path.exists())
			throw new FileNotFoundException(path.getAbsolutePath());
		boolean ret = true;
		if (path.isDirectory()) {
			for (File f : path.listFiles()) {
				ret = ret && deleteRecursive(f);
			}
		}
		return ret && path.delete();
	}

	@Override
	public void delete() throws IOException {
		if (!deleteRecursive(file)) {
			throw new IOException("Failed to delete " + file);
		}
	}

	public static void copy(JavaFile src, JavaFile dst) throws IOException {
		doCopyFile(src.file, dst.file);
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

	private void copyStream(InputStream input, OutputStream output) throws IOException {
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
	public void append(InputStream is) throws IOException {
		mkdirs();
		FileOutputStream os = new FileOutputStream(file, true);
		copyStream(is, os);
	}

	@Override
	public void write(InputStream is) throws IOException {
		mkdirs();
		FileOutputStream os = new FileOutputStream(file, false);
		copyStream(is, os);
	}

	private void mkdirs() throws IOException {
		File parent = file.getParentFile();
		if (parent != null)
			if (!parent.mkdirs())
				throw new IOException("Failed to create directory " + parent);
	}


	@Override
	public InputStream read() throws IOException {
		return new FileInputStream(file);
	}
}
