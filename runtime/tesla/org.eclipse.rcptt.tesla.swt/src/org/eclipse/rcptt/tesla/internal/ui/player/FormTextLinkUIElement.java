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
package org.eclipse.rcptt.tesla.internal.ui.player;

import org.eclipse.swt.widgets.Control;

import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;

@SuppressWarnings("all")
public class FormTextLinkUIElement extends SWTUIElement {
	public Object segment;

	public FormTextLinkUIElement(Control parent, Object segment, SWTUIPlayer p) {
		super(parent, p);
		this.segment = segment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((segment == null) ? 0 : segment.hashCode());
		return result;
	}

	@Override
	public GenericElementKind getKind() {
		return SWTUIPlayer.getKind(segment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormTextLinkUIElement other = (FormTextLinkUIElement) obj;
		if (segment == null) {
			if (other.segment != null)
				return false;
		} else if (!segment.equals(other.segment))
			return false;
		return true;
	}

	public boolean match(Object c) {
		return segment != null && segment.equals(c);
	}

	public String toString() {
		return segment == null ? "Empty" : segment.getClass().getSimpleName()
				+ ":" + PlayerTextUtils.getText(this);
	}

	public String getClassName() {
		return segment == null ? "null" : segment.getClass().getSimpleName();
	}

}
