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
package org.eclipse.rcptt.ecl.operations.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;

public class OpUtils {

	public static boolean asBoolean(EObject o) throws CoreException {
		try {
			return BoxedValues.toBoolean((BoxedValue) o);
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR,
					OperationsPlugin.PLUGIN_ID,
					"Expected Boolean-convertible argument but got "
							+ o.getClass()));
		}
	}
}
