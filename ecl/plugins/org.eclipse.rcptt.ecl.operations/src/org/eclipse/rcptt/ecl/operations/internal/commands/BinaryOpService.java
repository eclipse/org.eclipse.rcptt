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
import static org.eclipse.rcptt.ecl.runtime.BoxedValues.toType;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.EclBoolean;
import org.eclipse.rcptt.ecl.core.EclDouble;
import org.eclipse.rcptt.ecl.core.EclFloat;
import org.eclipse.rcptt.ecl.core.EclInteger;
import org.eclipse.rcptt.ecl.core.EclLong;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.ecl.operations.BinaryOp;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public abstract class BinaryOpService implements ICommandService {

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		if (!(command instanceof BinaryOp)) {
			return Status.CANCEL_STATUS;
		}

		BinaryOp op = (BinaryOp) command;

		BoxedValue left = convertToNumber(op.getLeft());
		BoxedValue right = convertToNumber(op.getRight());
		EClass widestType = max(left.eClass(), right.eClass());
		left = toType(left, widestType);
		right = toType(right, widestType);
		// Now left and right are guaranteed to have the same type
		context.getOutput().write(doOp(left, right));

		return Status.OK_STATUS;
	}

	private static final EClass DOUBLE = CorePackage.Literals.ECL_DOUBLE;
	private static final EClass FLOAT = CorePackage.Literals.ECL_FLOAT;
	private static final EClass LONG = CorePackage.Literals.ECL_LONG;
	private static final EClass INT = CorePackage.Literals.ECL_INTEGER;
	private static final EClass[] DESCENDING = { DOUBLE, FLOAT, LONG, INT };

	public static EClass max(EClass... args) {
		List<EClass> argList = Arrays.asList(args);
		for (EClass clazz : DESCENDING) {
			if (argList.contains(clazz)) {
				return clazz;
			}
		}
		return INT;
	}

	protected final BoxedValue doOp(final BoxedValue left, final BoxedValue right) throws CoreException {
		if (left instanceof EclInteger) {
			return doIntOp(((EclInteger) left).getValue(), ((EclInteger) right).getValue());
		}

		if (left instanceof EclDouble) {
			return doDoubleOp(((EclDouble) left).getValue(), ((EclDouble) right).getValue());
		}

		if (left instanceof EclLong) {
			return doLongOp(((EclLong) left).getValue(), ((EclLong) right).getValue());
		}

		if (left instanceof EclFloat) {
			return doFloatOp(((EclFloat) left).getValue(), ((EclFloat) right).getValue());
		}
		throw new CoreException(createErr("Unexpected argument type: %s", left.eClass().getName()));
	}

	protected abstract BoxedValue doDoubleOp(double left, double right);

	protected abstract BoxedValue doFloatOp(float left, float right);

	protected abstract BoxedValue doIntOp(int left, int right);

	protected abstract BoxedValue doLongOp(long left, long right);

	public static BoxedValue convertToNumber(EObject arg) throws CoreException {
		if (!(arg instanceof BoxedValue)) {
			throw new CoreException(createErr("Cannot convert argument to number: '%s' ", arg));
		}

		if (arg instanceof EclString || arg instanceof EclBoolean) {
			return BoxedValues.toType((BoxedValue) arg, CorePackage.Literals.ECL_LONG);
		}
		return (BoxedValue) arg;
	}

}
