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
package org.eclipse.rcptt.ecl.internal.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.runtime.IPipe;

public interface IMarkeredPipe extends IPipe {
	void writeCloseMarker() throws CoreException;

	void closeNoWait();
}
