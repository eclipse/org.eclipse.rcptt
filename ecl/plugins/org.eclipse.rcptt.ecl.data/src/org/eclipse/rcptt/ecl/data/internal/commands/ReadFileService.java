/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.internal.commands;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.ReadFile;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ReadFileService implements ICommandService {
	public IStatus service(Command command, IProcess context)
		throws InterruptedException, CoreException
	{
		if (!(command instanceof ReadFile)) {
			return Status.CANCEL_STATUS;
		}
		InputStream input = null;
		try {
			URI uri = new URI(((ReadFile) command).getUri());
			final EclFile file = FileResolver.resolve(uri);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			input = file.read();
			int b = -1;
			while ((b = input.read())!=-1) {
				 out.write(b);
			}
			context.getOutput().write(out.toString());
		} catch (Exception e) {
			return new Status(IStatus.ERROR, EclDataPlugin.PLUGIN_ID, e.getMessage(), e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
				}
			}
		}
		return Status.OK_STATUS;
	}
}
