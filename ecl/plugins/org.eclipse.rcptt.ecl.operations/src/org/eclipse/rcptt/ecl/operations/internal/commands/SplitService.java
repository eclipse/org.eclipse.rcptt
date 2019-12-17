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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import static org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin.createErr;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.operations.Split;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class SplitService implements ICommandService {
	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		if (!(command instanceof Split)) {
			return Status.CANCEL_STATUS;
		}

		Split split = (Split) command;
		String input = split.getStr();
		String sep = split.getSep();
		PipeWriter writer = new PipeWriter(context.getOutput(), split.isTrimResults(), split.isOmitEmptyStrings());

		int sepLength = sep.length();
		if (sepLength == 0) {
			throw new CoreException(createErr("Empty separator is not allowed"));
		}
		int searchStart = 0;
		while (true) {
			int sepStart = input.indexOf(sep, searchStart);
			if (sepStart == -1) {
				writer.write(input.substring(searchStart));
				break;
			}

			writer.write(input.substring(searchStart, sepStart));
			searchStart = sepStart + sepLength;
		}
		return Status.OK_STATUS;
	}

	private static class PipeWriter {
		private boolean trim;
		private boolean omit;
		private IPipe out;

		public PipeWriter(IPipe out, boolean trim, boolean omit) {
			this.out = out;
			this.trim = trim;
			this.omit = omit;
		}

		public void write(String result) throws CoreException {
			if (result.length() == 0 && omit) {
				return;
			}

			if (trim) {
				result = result.trim();
			}

			out.write(result);
		}
	}
}
