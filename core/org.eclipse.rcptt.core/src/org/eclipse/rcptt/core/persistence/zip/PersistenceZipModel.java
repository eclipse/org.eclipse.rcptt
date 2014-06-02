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
package org.eclipse.rcptt.core.persistence.zip;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.rcptt.core.persistence.BasePersistenceModel;
import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.util.FileUtil;

/**
 * Contains attachment files map in .metadata for given named element
 * attachments.
 * 
 */
public class PersistenceZipModel extends BasePersistenceModel implements
		IPersistenceModel {
	public PersistenceZipModel(Resource element) {
		super(element);
	}

	@Override
	protected synchronized void doStoreTo(File file) throws FileNotFoundException,
			IOException {
		ZipOutputStream zout = new ZipOutputStream(new BufferedOutputStream(
				new FileOutputStream(file)));
		for (Map.Entry<String, File> fileEntry : files.entrySet()) {
			if (fileEntry.getValue().exists()) {
				ZipEntry entry = new ZipEntry(fileEntry.getKey());
				entry.setTime(1);
				zout.putNextEntry(entry);
				InputStream in = getInput(fileEntry.getValue());
				FileUtil.copyNoClose(in, zout);
				zout.closeEntry();
			}
		}
		zout.close();
	}

	@Override
	protected synchronized void doReadIndex(InputStream contents) {
		ZipInputStream zin = new ZipInputStream(contents);
		try {
			while (true) {
				ZipEntry entry = zin.getNextEntry();
				if (entry != null) {
					String name = entry.getName();
					IPath filePath = rootPath.append(new Path(name));
					putFileItem(name, filePath);
				} else {
					break;
				}
			}
		} catch (IOException e) {
			RcpttPlugin.log(e);
		} finally {
			try {
				zin.close();
			} catch (IOException e) {

			}
		}
	}

	@Override
	protected synchronized void doExtractFile(String fName, InputStream contents)
			throws IOException {
		ZipInputStream zin = new ZipInputStream(contents);
		while (true) {
			ZipEntry entry = zin.getNextEntry();
			if (entry != null) {
				String name = entry.getName();
				if (name.equals(fName)) {
					// copy
					OutputStream outputStream = internalStore(fName);
					FileUtil.copy(zin, outputStream);
					outputStream.close();
					break;
				}
			} else {
				break;
			}
		}
	}

	@Override
	protected synchronized void doExtractAll(InputStream contents) throws IOException {
		ZipInputStream zin = new ZipInputStream(contents);
		while (true) {
			ZipEntry entry = zin.getNextEntry();
			if (entry != null) {
				String name = entry.getName();
				File file = files.get(name);
				if (file != null && !file.exists()) {
					OutputStream outputStream = internalStore(name);
					FileUtil.copyNoClose(zin, outputStream);
					outputStream.close();
				}
			} else {
				break;
			}
		}
	}

	public boolean isSupportMultiItems() {
		return true;
	}

	public void updateAttributes(Resource element) {
		// TODO Auto-generated method stub
		
	}

	public void updateMetadata(Resource resource) {
		// TODO Auto-generated method stub
		
	}
}
