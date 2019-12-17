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
package org.eclipse.rcptt.ui.resources.viewers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.rcptt.core.internal.builder.Q7Builder;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.resources.ui.WSValidators;
import org.eclipse.rcptt.workspace.WSLink;
import org.eclipse.swt.widgets.Display;

public class WSResourceDecorator implements ILightweightLabelDecorator {

	private static final ImageDescriptor LINK;
	private static final ImageDescriptor BROKEN;

	static {
		LINK = Images.getImageDescriptor(Images.LINK_OVERLAY);
		BROKEN = Images.getImageDescriptor(Images.LINK_BROKEN);
	}

	Runnable buildListener = new Runnable() {
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					for (ILabelProviderListener listener : listeners) {
						listener.labelProviderChanged(new LabelProviderChangedEvent(
								WSResourceDecorator.this));
					}
				}
			});
		}
	};

	private List<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();

	public synchronized  void addListener(ILabelProviderListener listener) {
		if (listeners.size() == 0)
			Q7Builder.addListener(buildListener);
		listeners.add(listener);
	}

	public void dispose() {
		Q7Builder.removeListener(buildListener);
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public synchronized  void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
		if (listeners.isEmpty())
			Q7Builder.removeListener(buildListener);
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
