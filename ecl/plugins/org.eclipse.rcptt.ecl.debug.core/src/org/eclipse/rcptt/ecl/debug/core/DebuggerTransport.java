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
package org.eclipse.rcptt.ecl.debug.core;

import java.io.Closeable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

public interface DebuggerTransport extends Closeable {

	public void request(EObject event) throws CoreException;

	public void setCallback(DebuggerCallback callback);

}
