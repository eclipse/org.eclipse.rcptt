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
package org.eclipse.rcptt.ui.debug;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.rcptt.ecl.debug.core.EclDebug;
import org.eclipse.ui.IWorkbenchPart;

import org.eclipse.rcptt.ui.editors.context.ContextEditor;
import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class EclLineBreakpointAdapter implements IToggleBreakpointsTarget {

	private final IResource resource;

	public EclLineBreakpointAdapter(IResource resource) {
		this.resource = resource;
	}

	public void toggleLineBreakpoints(IWorkbenchPart part, ISelection selection)
			throws CoreException {
		if (part instanceof ContextEditor) {
			part = ((ContextEditor) part).getEditor();
		}
		ITextSelection textSelection = (ITextSelection) selection;
		int lineNumber = textSelection.getStartLine();
		IBreakpoint[] breakpoints = DebugPlugin.getDefault()
				.getBreakpointManager().getBreakpoints(EclDebug.MODEL);
		for (int i = 0; i < breakpoints.length; i++) {
			IBreakpoint breakpoint = breakpoints[i];
			if (resource.equals(breakpoint.getMarker().getResource())) {
				if (((ILineBreakpoint) breakpoint).getLineNumber() == (lineNumber + 1)) {
					// remove
					breakpoint.delete();
					return;
				}
			}
		}
		// create line breakpoint (doc line numbers start at 0)
		IBreakpoint breakpoint = EclDebug.createBreakpoint(resource,
				lineNumber + 1);
		DebugPlugin.getDefault().getBreakpointManager()
				.addBreakpoint(breakpoint);
	}

	public boolean canToggleLineBreakpoints(IWorkbenchPart part,
			ISelection selection) {
		if (part instanceof ContextEditor) {
			part = ((ContextEditor) part).getEditor();
		}
		if (part instanceof EclEditor) {
			return true;
		}
		return false;
	}

	public void toggleMethodBreakpoints(IWorkbenchPart part,
			ISelection selection) throws CoreException {
	}

	public boolean canToggleMethodBreakpoints(IWorkbenchPart part,
			ISelection selection) {
		return false;
	}

	public void toggleWatchpoints(IWorkbenchPart part, ISelection selection)
			throws CoreException {
	}

	public boolean canToggleWatchpoints(IWorkbenchPart part,
			ISelection selection) {
		return false;
	}
}