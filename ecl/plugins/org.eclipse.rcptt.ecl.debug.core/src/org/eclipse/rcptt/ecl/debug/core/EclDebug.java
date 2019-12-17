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
package org.eclipse.rcptt.ecl.debug.core;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.LineBreakpoint;
import org.eclipse.rcptt.ecl.internal.debug.core.EclBreakpoint;
import org.eclipse.rcptt.ecl.internal.debug.core.EclDebugTarget;
import org.eclipse.rcptt.ecl.internal.debug.core.Plugin;

public class EclDebug {

	public static final String MODEL = Plugin.ID;

	public static final String MARKER = Plugin.ID + ".breakpoint.marker";

	public static LineBreakpoint createBreakpoint(IResource resource,
			int lineNumber) throws CoreException {
		return new EclBreakpoint(resource, lineNumber);
	}

	public static Debugger createDebugger(IProcess process)
			throws CoreException {
		return new EclDebugTarget(process);
	}

}
