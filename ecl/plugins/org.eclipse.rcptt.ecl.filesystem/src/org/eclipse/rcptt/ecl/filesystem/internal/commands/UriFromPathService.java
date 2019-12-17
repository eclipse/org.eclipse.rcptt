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
package org.eclipse.rcptt.ecl.filesystem.internal.commands;

import static org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin.createError;

import java.io.File;
import java.net.MalformedURLException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin;
import org.eclipse.rcptt.ecl.filesystem.UriFromPath;
import org.eclipse.rcptt.ecl.runtime.SingleCommandService;

public class UriFromPathService extends SingleCommandService<UriFromPath> {

	public UriFromPathService() {
		super(UriFromPath.class);
	}

	@Override
	protected Object serviceTyped(UriFromPath command)
			throws InterruptedException, CoreException {
		String path = command.getPath();
		if (path == null)
			throw new CoreException(createError("No path argument for uri-from-path."));
		try {
			return new File(path).toURI().toURL().toExternalForm();
		} catch (MalformedURLException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					EclFilesystemPlugin.PLUGIN_ID,
					"Failed to parse filesystem path " + path, e));
		}
	}
}
