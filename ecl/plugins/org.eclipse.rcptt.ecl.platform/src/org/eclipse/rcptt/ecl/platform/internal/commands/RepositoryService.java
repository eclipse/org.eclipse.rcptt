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
package org.eclipse.rcptt.ecl.platform.internal.commands;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.platform.internal.PlatformPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;

/**
 * Base class for repository-related commands
 * @author ivaninozemtsev
 *
 */
public abstract class RepositoryService implements ICommandService {
	protected URI getUri(String uriStr) throws CoreException {
		URI repoUri = null;
		try {
			repoUri = new URI(uriStr);
		} catch (URISyntaxException e) {
			throw new CoreException(PlatformPlugin.err("Invalid repo URI", e));
		}
		return repoUri;
	}
}
