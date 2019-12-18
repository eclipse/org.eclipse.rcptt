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
package org.eclipse.rcptt.core.persistence.emf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.persistence.IPersistenceModelFactory;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.util.FileUtil;

public class PersistenceEMFModelFactory implements IPersistenceModelFactory {
	public IPersistenceModel createModel(Resource resource) {
		return new PersistenceEMFModel(resource);
	}

	public boolean isSupported(InputStream contents) {
		try {
			byte[] content = FileUtil.getStreamContent(
					new BufferedInputStream(contents), 100);
			String s = new String(content);
			if (s.contains("<?xml")) {
				return true;
			}
		} catch (Throwable e) {
			RcpttPlugin.log(e);
		} finally {
			FileUtil.safeClose(contents);
		}
		return false;
	}

	public boolean isSupported(File file) {
		return false;
	}
}
