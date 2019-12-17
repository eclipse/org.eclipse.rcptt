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
package org.eclipse.rcptt.ui.debug;

import java.util.Iterator;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class ToggleBreakpointEnablementAction extends Action {

	private IVerticalRulerInfo ruler;
	private SourceViewer viewer;
	private IBreakpoint breakpoint;

	public ToggleBreakpointEnablementAction(SourceViewer viewer,
			IVerticalRulerInfo info) {
		this.viewer = viewer;
		ruler = info;
	}

	public void run() {
		if (breakpoint != null) {
			try {
				breakpoint.setEnabled(!breakpoint.isEnabled());
			} catch (CoreException e) {
				Q7UIPlugin.log(e);
			}
		}
	}

	public void update() {
		breakpoint = getBreakpoint();
		setEnabled(breakpoint != null);
		if (breakpoint != null) {
			try {
				if (breakpoint.isEnabled()) {
					setText("&Disable Breakpoint");
				} else {
					setText("&Enable Breakpoint");
				}
			} catch (CoreException e) {
				Q7UIPlugin.log(e);
			}
		} else {
			setText("Toggle Breakpoint Enablement");
		}
	}

	private IBreakpoint getBreakpoint() {
		IAnnotationModel annotationModel = viewer.getAnnotationModel();
		IDocument document = viewer.getDocument();
		Iterator<?> iterator = annotationModel.getAnnotationIterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			if (object instanceof SimpleMarkerAnnotation) {
				SimpleMarkerAnnotation markerAnnotation = (SimpleMarkerAnnotation) object;
				IMarker marker = markerAnnotation.getMarker();
				try {
					if (marker.isSubtypeOf(IBreakpoint.BREAKPOINT_MARKER)) {
						Position position = annotationModel
								.getPosition(markerAnnotation);
						int line = document.getLineOfOffset(position
								.getOffset());
						if (line == ruler.getLineOfLastMouseButtonActivity()) {
							IBreakpoint breakpoint = DebugPlugin.getDefault()
									.getBreakpointManager()
									.getBreakpoint(marker);
							if (breakpoint != null) {
								return breakpoint;
							}
						}
					}
				} catch (CoreException e) {
				} catch (BadLocationException e) {
				}
			}
		}
		return null;
	}

}
