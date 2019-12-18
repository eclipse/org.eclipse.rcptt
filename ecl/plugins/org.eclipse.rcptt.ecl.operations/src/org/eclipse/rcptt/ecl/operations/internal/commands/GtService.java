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

import static org.eclipse.rcptt.ecl.runtime.BoxedValues.box;

import org.eclipse.rcptt.ecl.core.BoxedValue;

public class GtService extends BinaryOpService {
	protected BoxedValue doDoubleOp(double left, double right) {
		return box(left > right);
	}

	protected BoxedValue doFloatOp(float left, float right) {
		return box(left > right);
	}

	@Override
	protected BoxedValue doIntOp(int left, int right) {
		return box(left > right);
	}

	@Override
	protected BoxedValue doLongOp(long left, long right) {
		return box(left > right);
	}
}
