/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.reporting.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IPath;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.reporting.core.IReportRenderer.IContentFactory;
import org.eclipse.rcptt.reporting.util.internal.Plugin;
import org.eclipse.rcptt.util.FileUtil;

public class FileContentFactory implements IContentFactory {
	private File root;

	public FileContentFactory(IPath folder) {
		this.root = folder.toFile();
	}

	public FileContentFactory(File folder) {
		this.root = folder;
	}

	public IContentFactory createFolder(String name) {
		return new FileContentFactory(new File(root, name));
	}

	public OutputStream createFileStream(String fname) {
		File fName = getFile(fname);
		try {
			return new BufferedOutputStream(new FileOutputStream(fName));
		} catch (FileNotFoundException e) {
			Plugin.UTILS.log(e);
		}
		return null;
	}

	public boolean isFileExist(String fname) {
		return getFile(fname).exists();
	}

	private File getFile(String fname) {
		File folder = root;
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File fName = new File(folder, fname);
		return fName;
	}

	public List<String> matchFiles(String fname) {
		Set<String> result = new HashSet<String>();
		if (isFileExist(fname)) {
			result.add(fname);
		}
		// Match with regular expression
		try {
			traverse(root, fname, result);
		} catch (Exception e) {
			RcpttPlugin.log(e);
		}

		return new ArrayList<String>(result);
	}

	private void traverse(File dir, String fname, Set<String> result) {
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			String name = root.toURI().relativize(file.toURI()).toString();
			if (Pattern.matches(fname, name)) {
				result.add(name);
			}
			if (file.isDirectory()) {
				traverse(new File(dir.getAbsolutePath(), name), fname, result);
			}
		}
	}

	public void removeFileOrFolder(String name) {
		File file = getFile(name);
		if (file.exists()) {
			FileUtil.deleteFile(file, true);
		}
	}
}
