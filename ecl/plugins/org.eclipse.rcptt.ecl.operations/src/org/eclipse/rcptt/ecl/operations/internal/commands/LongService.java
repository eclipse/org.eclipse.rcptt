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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;

public class LongService extends ConvertService {
	Object doConvert(BoxedValue input) throws CoreException {
		if( input instanceof EclString) {
			Long longValue = Long.decode(((EclString) input).getValue());
			return BoxedValues.box(longValue);
		}
		return BoxedValues.toLong(input);
	}
}
