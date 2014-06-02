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
package org.eclipse.rcptt.internal.core.model;


/** Element info for IOpenable elements. */
public class OpenableElementInfo extends Q7ElementInfo {
	protected boolean isStructureKnown = false;

	public boolean isStructureKnown() {
		return this.isStructureKnown;
	}
	
	public void setIsStructureKnown(boolean newIsStructureKnown) {
		this.isStructureKnown = newIsStructureKnown;
	}
}
