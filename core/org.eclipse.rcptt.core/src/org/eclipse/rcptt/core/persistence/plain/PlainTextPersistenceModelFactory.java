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
package org.eclipse.rcptt.core.persistence.plain;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.persistence.IPersistenceModelFactory;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class PlainTextPersistenceModelFactory implements
		IPersistenceModelFactory {

	public PlainTextPersistenceModelFactory() {
	}

	public IPersistenceModel createModel(Resource resource) {
		return new PlainTextPersistenceModel(resource);
	}

	public boolean isSupported(InputStream stream) {
		PlainReader reader = null;
		try {
			reader = new PlainReader(stream);
			Map<String, String> header = reader.readHeader();
			if (header != null) {
				String version = header.get(IPlainConstants.ATTR_FORMAT_VERSION);
				if (version != null
						&& version.equals(IPlainConstants.FORMAT_VERSION)) {
					return true;
				}
			}
		} catch (Exception e) {
			RcpttPlugin.log(e);
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return false;
	}

	public boolean isSupported(File file) {
		return false;
	}
}
