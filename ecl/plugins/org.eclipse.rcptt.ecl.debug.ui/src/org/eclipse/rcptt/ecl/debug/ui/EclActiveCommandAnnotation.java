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
package org.eclipse.rcptt.ecl.debug.ui;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.jface.text.source.Annotation;

/**
 * Default instruction pointer annotation.
 */
public class EclActiveCommandAnnotation extends Annotation {

	private IStackFrame fStackFrame;

	public EclActiveCommandAnnotation(IStackFrame frame, String markerAnnotationSpecificationId, String text) {
		super(markerAnnotationSpecificationId, false, text);
		fStackFrame = frame;
	}

	public boolean equals(Object other) {
		if (other instanceof EclActiveCommandAnnotation) {
			return getStackFrame().equals(((EclActiveCommandAnnotation) other).getStackFrame());
		}
		return false;
	}

	public int hashCode() {
		return getStackFrame().hashCode();
	}

	private IStackFrame getStackFrame() {
		return fStackFrame;
	}
}
