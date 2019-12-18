/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.resources;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.util.FileUtil;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFolder;

public class ImportUtils {

	public static void importFiles(WSFolder ownFolder, EList<WSFile> files,
			IPersistenceModel model, WorkspaceDataImporter importer) {
		for (WSFile wsFile : files) {
			WSFile ownFile = WSUtils.getFile(ownFolder, wsFile.getName(), true);
			ownFile.setExecutable(wsFile.isExecutable());
			String name = getName(ownFile);
			InputStream stream = importer.getContents(wsFile);
			if (stream != null) {
				OutputStream result = model.store(name);
				if (result != null) {
					try {
						FileUtil.copy(stream, result);
					} catch (Exception e) {
						RcpttPlugin.log(e);
					}
				} else {
					RcpttPlugin.log("Failed to import: " + wsFile.getName()
							+ " node: " + name, new Exception());
				}
			}
		}
	}

	public static String getName(WSFile ownFile) {
		StringBuilder builder = new StringBuilder();
		builder.append(ownFile.getName());
		EObject ct = ownFile.eContainer();
		while (ct != null) {
			if (ct instanceof WSFolder) {
				builder.insert(0, ((WSFolder) ct).getName() + "/");
			}
			ct = ct.eContainer();
		}
		return "contents/" + builder.toString();
	}

	public static void importFolders(WSFolder ownProject,
			EList<WSFolder> folders, IPersistenceModel model,
			WorkspaceDataImporter importer) {
		for (WSFolder wsFolder : folders) {
			WSFolder ownFolder = WSUtils.getFolder(ownProject,
					wsFolder.getName(), true);
			importFolders(ownFolder, wsFolder.getFolders(), model, importer);
			importFiles(ownFolder, wsFolder.getFiles(), model, importer);
		}
	}

}
