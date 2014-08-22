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
package org.eclipse.rcptt.ecl.data.internal.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.WriteLines;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class WriteLinesService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof WriteLines)) {
			return Status.CANCEL_STATUS;
		}

		WriteLines cmd = (WriteLines) command;
		File out = FileResolver.resolve(cmd.getUri());
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream(out, cmd.isAppend()));
			for (Object obj : CoreUtils.readPipeContent(context.getInput())) {
				ps.println(obj);
			}
			ps.close();
			FileResolver.refresh(out);
		} catch (FileNotFoundException e) {
			throw new CoreException(EclDataPlugin.createErr(e,
					"Cannot write to %s", out.getAbsolutePath()));
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		return Status.OK_STATUS;
	}

}
