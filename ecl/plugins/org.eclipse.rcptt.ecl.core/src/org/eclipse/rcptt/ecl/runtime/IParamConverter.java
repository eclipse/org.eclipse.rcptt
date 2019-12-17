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

package org.eclipse.rcptt.ecl.runtime;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.LiteralParameter;

public interface IParamConverter<T> {

	Class<T> forType();

	T convert(LiteralParameter literal, List<String> allowedTypes)
			throws CoreException;

	String convertToCode(Object value) throws CoreException;
}
