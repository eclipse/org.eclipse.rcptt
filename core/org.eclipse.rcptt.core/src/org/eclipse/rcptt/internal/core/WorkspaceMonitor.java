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
package org.eclipse.rcptt.internal.core;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.rcptt.core.persistence.PersistenceManager;

public class WorkspaceMonitor {

	public static final Object SAVE_JOB_FAMILY = "save_job_family";
	private static WorkspaceMonitor instance;

	private final Set<String> extensions = new HashSet<String>();
	private final Map<IFile, Long> fileToDate = new HashMap<IFile, Long>();

	public static WorkspaceMonitor getInstance() {
		if (instance == null) {
			instance = new WorkspaceMonitor();
		}
		return instance;
	}

	private WorkspaceMonitor() {
		extensions.add("ctx");
		extensions.add("scenario");
		extensions.add("test");
	}

	void stop() {
		PersistenceManager.shutdown();
	}

	public static boolean isFileEmpty(IFile file) {
		boolean fileIsEmpty = false;
		InputStream stream = null;
		try {
			stream = new BufferedInputStream(file.getContents());
			byte[] bb = new byte[4096];
			int read = stream.read(bb);
			if (read == 0 || read == -1) {
				fileIsEmpty = true;
			}
		} catch (Throwable ey) {
			if (ey instanceof EOFException) {
				fileIsEmpty = true;
			}
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					RcpttPlugin.log(e);
				}
			}
		}
		return fileIsEmpty;
	}

	public static boolean isIgnored(IResource resource) {
		// Ignore files that content of contexts
		IPath path = resource.getFullPath();
		if (resource instanceof IFile) {
			path = path.removeLastSegments(1);
		}
		for (int i = 0; i < path.segmentCount(); i++) {
			if (path.segment(i).startsWith(".")
					&& path.segment(i).endsWith("ctx")) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unused")
	private final ResourceSet resources = new ResourceSetImpl() {
		protected void handleDemandLoadException(Resource resource,
				IOException exception) throws RuntimeException {
			// Just ignore
		};
	};

	public Long removeFromFileToDate(IFile file) {
		return fileToDate.remove(file);
	}

	public void addToFileToDate(IFile file, Long timestamp) {
		fileToDate.put(file, timestamp);
	}
}
