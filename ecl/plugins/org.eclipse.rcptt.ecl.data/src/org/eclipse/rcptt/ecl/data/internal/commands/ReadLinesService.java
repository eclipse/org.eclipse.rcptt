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
package org.eclipse.rcptt.ecl.data.internal.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.ReadLines;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ReadLinesService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof ReadLines)) {
			return Status.CANCEL_STATUS;
		}

		BufferedReader br = null;
		try {
			URI uri = new URI(((ReadLines) command).getUri());
			EclFile file = FileResolver.resolve(uri);
			br = new BufferedReader(new InputStreamReader(file.read()));
			String line = "";
			while ((line = br.readLine()) != null) {
				context.getOutput().write(line);
			}
		} catch (Exception e) {
			return new Status(IStatus.ERROR, EclDataPlugin.PLUGIN_ID, e.getMessage(), e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}

		return Status.OK_STATUS;
	}

}
