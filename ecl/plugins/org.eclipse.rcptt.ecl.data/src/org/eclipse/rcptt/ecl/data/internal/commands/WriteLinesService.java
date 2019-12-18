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
package org.eclipse.rcptt.ecl.data.internal.commands;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.WriteLines;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.filesystem.Util;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.ecl.model.Wrapper;

public class WriteLinesService implements ICommandService {

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		if (!(command instanceof WriteLines)) {
			return Status.CANCEL_STATUS;
		}

		WriteLines cmd = (WriteLines) command;
		EclFile out = FileResolver.resolve(cmd.getUri());
		PrintStream ps = null;
		try {
			Writer fileWriter = Util.getWriter(out, cmd.isAppend(), cmd.getEncode());
			BufferedWriter writer = new BufferedWriter(fileWriter);
			for (Object obj : CoreUtils.readPipeContent(context.getInput())) {
				if (obj instanceof Wrapper) {
					obj = ((Wrapper) obj).getObject();
				}

				writer.write("" + BoxedValues.unbox(obj));
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			throw new CoreException(EclDataPlugin.createErr(e, "Cannot write to %s", out.toURI()));
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		return Status.OK_STATUS;
	}

}
