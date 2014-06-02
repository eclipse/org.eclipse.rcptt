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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import static org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin.createErr;
import static org.eclipse.rcptt.ecl.operations.internal.commands.BinaryOpService.convertToNumber;
import static org.eclipse.rcptt.ecl.operations.internal.commands.BinaryOpService.max;
import static org.eclipse.rcptt.ecl.runtime.BoxedValues.toType;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclDouble;
import org.eclipse.rcptt.ecl.core.EclFloat;
import org.eclipse.rcptt.ecl.core.EclInteger;
import org.eclipse.rcptt.ecl.core.EclLong;
import org.eclipse.rcptt.ecl.operations.Between;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class BetweenService implements ICommandService {

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		if (!(command instanceof Between)) {
			return Status.CANCEL_STATUS;
		}

		Between bw = (Between) command;
		BoxedValue input = convertToNumber(bw.getInput());
		BoxedValue from = convertToNumber(bw.getLeft());
		BoxedValue to = convertToNumber(bw.getRight());

		EClass widestType = max(input.eClass(), from.eClass(), to.eClass());
		input = toType(input, widestType);
		from = toType(from, widestType);
		to = toType(to, widestType);

		context.getOutput().write(isBetween(input, from, to));
		return Status.OK_STATUS;
	}

	private static boolean isBetween(BoxedValue input, BoxedValue from, BoxedValue to) throws CoreException {
		if (input instanceof EclInteger) {
			int i = ((EclInteger) input).getValue();
			int f = ((EclInteger) from).getValue();
			int t = ((EclInteger) to).getValue();
			return i <= t && i >= f;
		}

		if (input instanceof EclLong) {
			long i = ((EclLong) input).getValue();
			long f = ((EclLong) from).getValue();
			long t = ((EclLong) to).getValue();
			return i <= t && i >= f;
		}

		if (input instanceof EclFloat) {
			float i = ((EclFloat) input).getValue();
			float f = ((EclFloat) from).getValue();
			float t = ((EclFloat) to).getValue();
			return i <= t && i >= f;
		}

		if (input instanceof EclDouble) {
			double i = ((EclDouble) input).getValue();
			double f = ((EclLong) from).getValue();
			double t = ((EclLong) to).getValue();
			return i <= t && i >= f;
		}

		throw new CoreException(createErr("Unexpected argument type: %s", input.eClass().getName()));

	}

}
