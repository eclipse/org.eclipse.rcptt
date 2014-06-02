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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.persistence.IPersistenceModelFactory;
import org.eclipse.rcptt.core.persistence.PersistenceManager;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.util.FileUtil;

public class PersistenceZipModelFactory implements IPersistenceModelFactory {
	public IPersistenceModel createModel(Resource resource) {
		return new PersistenceZipModel(resource);
	}

	public boolean isSupported(InputStream contents) {
		try {
			ZipInputStream zin = new ZipInputStream(new BufferedInputStream(
					contents));
			int entries = 0;
			boolean hasMeta = false;
			while (true) {
				ZipEntry entry = zin.getNextEntry();
				if (entry == null) {
					break;
				}
				entries++;
				if (entry.getName().equalsIgnoreCase(
						PersistenceManager.CONTENT_ENTRY)) {
					hasMeta = true;
				}
			}
			return hasMeta && entries > 0;
		} catch (ZipException zex) {
			return false;
		} catch (Throwable e) {
			RcpttPlugin.log(e);
		} finally {
			FileUtil.safeClose(contents);
		}
		return false;
	}

	public boolean isSupported(File file) {
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(file);
			ZipEntry entry = zipFile.getEntry(PersistenceManager.CONTENT_ENTRY);
			if (entry != null) {
				return true;
			}
		} catch (ZipException e) {
			// ignore
		} catch (IOException e) {
			// ignore
		} finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
		return false;
	}
}
