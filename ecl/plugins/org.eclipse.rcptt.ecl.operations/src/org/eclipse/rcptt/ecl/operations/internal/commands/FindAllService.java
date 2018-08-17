/*******************************************************************************
 * Copyright (c) 2018 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.operations.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.operations.FindAll;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin.createErr;

public class FindAllService implements ICommandService {
	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		if (!(command instanceof FindAll)) {
			return Status.CANCEL_STATUS;
		}

		final FindAll findAll = (FindAll) command;
		final String input = findAll.getStr();
		final String regex = findAll.getRegex();

		int regexLength = regex.length();
		if (regexLength == 0) {
			throw new CoreException(createErr("Empty regex is not allowed"));
		}
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			final EclList result = CoreFactory.eINSTANCE.createEclList();

			for (int i = 0; i <= matcher.groupCount(); ++i) {
				result.getElements().add(BoxedValues.box(matcher.group(i)));
			}

			context.getOutput().write(result);
		}

		return Status.OK_STATUS;
	}
}
