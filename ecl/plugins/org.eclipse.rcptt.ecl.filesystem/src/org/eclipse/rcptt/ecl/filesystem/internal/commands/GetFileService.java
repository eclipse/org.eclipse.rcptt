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
package org.eclipse.rcptt.ecl.filesystem.internal.commands;


import static org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin.createError;

import java.net.URISyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.rcptt.ecl.filesystem.File;
import org.eclipse.rcptt.ecl.filesystem.FilesystemFactory;
import org.eclipse.rcptt.ecl.filesystem.GetFile;
import org.eclipse.rcptt.ecl.runtime.SingleCommandService;


public class GetFileService extends SingleCommandService<GetFile> {

	public GetFileService() {
		super(GetFile.class);
	}

	@Override
	protected Object serviceTyped(GetFile command)
			throws InterruptedException, CoreException {
		if ( command.getUri() == null)
			throw new CoreException(createError("No uri argument for get-file command."));
		File rv = FilesystemFactory.eINSTANCE.createFile();
		try {
			URIUtil.fromString(command.getUri());
		} catch (URISyntaxException e) {
			throw new CoreException(createError("Failed to parse file URI: %s", command.getUri()));
		}
		rv.setUri(command.getUri());
		return rv;
	}
}
