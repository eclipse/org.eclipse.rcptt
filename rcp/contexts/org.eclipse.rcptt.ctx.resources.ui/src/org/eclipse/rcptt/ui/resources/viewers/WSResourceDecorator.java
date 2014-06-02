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
package org.eclipse.rcptt.ui.resources.viewers;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.ui.internal.resources.WSValidators;
import org.eclipse.rcptt.workspace.WSLink;

public class WSResourceDecorator implements ILightweightLabelDecorator {

	private static final ImageDescriptor LINK;
	private static final ImageDescriptor BROKEN;

	static {
		LINK = Images.getImageDescriptor(Images.LINK_OVERLAY);
		BROKEN = Images.getImageDescriptor(Images.LINK_BROKEN);
	}

	
	public void addListener(ILabelProviderListener listener) {
	}

	
	public void dispose() {
	}

	
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	
	public void removeListener(ILabelProviderListener listener) {
	}

	
	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof WSLink) {
			if (WSValidators.validateLink((WSLink) element, null, null))
				decoration.addOverlay(LINK, IDecoration.BOTTOM_RIGHT);
			else
				decoration.addOverlay(BROKEN, IDecoration.BOTTOM_RIGHT);
		}
	}
}
