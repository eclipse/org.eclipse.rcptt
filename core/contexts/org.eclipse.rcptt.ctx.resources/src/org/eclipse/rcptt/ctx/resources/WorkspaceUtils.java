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
package org.eclipse.rcptt.ctx.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

import org.eclipse.rcptt.core.scenario.NamedElement;

public class WorkspaceUtils {

	public static IFile getLocation(String uri) {
		return getLocation(new ResourceImpl(URI.createPlatformResourceURI(uri,
				true)));
	}

	public static IFile getLocation(NamedElement executable) {
		if (executable == null) {
			return null;
		}
		return getLocation(executable.eResource());
	}

	public static IFile getLocation(Resource resource) {
		if (resource == null || resource.getResourceSet() == null) {
			return null;
		}
		return WorkspaceSynchronizer.getFile(resource);
	}
}
