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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclDouble;
import org.eclipse.rcptt.ecl.core.EclFloat;
import org.eclipse.rcptt.ecl.core.EclInteger;
import org.eclipse.rcptt.ecl.core.EclLong;
import org.eclipse.rcptt.ecl.operations.Eq;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class EqService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof Eq)) {
			return Status.CANCEL_STATUS;
		}
		Eq eq = (Eq) command;
		boolean result = EcoreUtil.equals(eq.getLeft(), eq.getRight());
		if (!result) {
			result = compareAsNumbers(eq.getLeft(), eq.getRight());
		}
		context.getOutput().write(result);
		context.getOutput().close(Status.OK_STATUS);
		return Status.OK_STATUS;
	}

	private boolean compareAsNumbers(EObject left, EObject right) {
		try {
			BoxedValue leftNumber = BinaryOpService.convertToNumber(left);
			BoxedValue rightNumber = BinaryOpService.convertToNumber(right);
			EClass widest = BinaryOpService.max(leftNumber.eClass(), rightNumber.eClass());
			leftNumber = BoxedValues.toType(leftNumber, widest);
			rightNumber = BoxedValues.toType(rightNumber, widest);

			if (leftNumber instanceof EclInteger) {
				return ((EclInteger) leftNumber).getValue() == ((EclInteger) rightNumber).getValue();
			}
			if (leftNumber instanceof EclLong) {
				return ((EclLong) leftNumber).getValue() == ((EclLong) rightNumber).getValue();
			}
			if (leftNumber instanceof EclFloat) {
				return ((EclFloat) leftNumber).getValue() == ((EclFloat) rightNumber).getValue();
			}
			if (leftNumber instanceof EclDouble) {
				return ((EclDouble) leftNumber).getValue() == ((EclDouble) rightNumber).getValue();
			}
			return false;
		} catch (CoreException e) {
			return false;
		}
	}

}
