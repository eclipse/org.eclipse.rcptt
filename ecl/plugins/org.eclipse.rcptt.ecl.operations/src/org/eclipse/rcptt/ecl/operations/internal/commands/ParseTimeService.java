/*******************************************************************************
 * Copyright (c) 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.operations.internal.commands;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import static org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin.createErr;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.operations.ParseTime;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ParseTimeService implements ICommandService {
	@Override
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof ParseTime)) {
			return Status.CANCEL_STATUS;
		}
		String format = ((ParseTime) command).getFormat();
		Object value = BoxedValues.unbox(context.getInput().take(10000));
		if (!(value instanceof String)) {
			return createErr(
					"Expected string value from input pipe, but got '%s'",
					value);
		}
		context.getOutput().write(
				new SimpleDateFormat(format).parse((String) value, new ParsePosition(0)).getTime());
		return Status.OK_STATUS;
	}
}

