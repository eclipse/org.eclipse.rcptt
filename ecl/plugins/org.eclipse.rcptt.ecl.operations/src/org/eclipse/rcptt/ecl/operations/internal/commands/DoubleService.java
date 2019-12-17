/*******************************************************************************
 * Copyright (c) 2018, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.operations.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;

public class DoubleService extends ConvertService {

	@Override
	Object doConvert(BoxedValue input) throws CoreException {
		if (input instanceof EclString) {
			final String value = ((EclString) input).getValue();
			if (value.equals("inf") || value.equals("+inf")) {
				return Double.POSITIVE_INFINITY;
			}
			if (value.equals("-inf")) {
				return Double.NEGATIVE_INFINITY;
			}
		}
		return BoxedValues.toDouble(input);
	}

}
