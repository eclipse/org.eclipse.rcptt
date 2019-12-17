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
package org.eclipse.rcptt.launching.autdetails;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.google.common.io.Closeables;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.util.FileUtil;

public class ZipAutDetailsProcessor implements IAutDetailsProcessor {
	private ZipOutputStream zout;

	public ZipAutDetailsProcessor(String pathToZip) {
		if (pathToZip != null) {
			try {
				File file = new File(pathToZip);
				if (!file.exists()) {
					file.createNewFile();
				}
				zout = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			} catch (IOException e) {
				Q7LaunchingPlugin.log(e);
			}
		}
	}

	public void addFile(String name, InputStream in) {
		try {
			zout.putNextEntry(new ZipEntry(name));
			FileUtil.copyNoClose(in, zout);
			zout.closeEntry();
		} catch (IOException e) {
			Q7LaunchingPlugin.log(e);
		} finally {
			Closeables.closeQuietly(in);
		}
	}

	public void addFile(String name, Properties properties) {
		try {
			zout.putNextEntry(new ZipEntry(name));
			properties.store(zout, "");
			zout.closeEntry();
		} catch (IOException e) {
			Q7LaunchingPlugin.log(e);
		}
	}

	public void closeStream() {
		try {
			zout.close();
		} catch (IOException e) {
			Q7LaunchingPlugin.log(e);
		}
	}
}
