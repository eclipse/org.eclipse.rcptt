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
package org.eclipse.rcptt.ui.utils;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.ui.PlatformUI;

public abstract class UIContentAdapter extends EContentAdapter {

	protected Set<EStructuralFeature> getIgnoreFeatures() {
		return new HashSet<EStructuralFeature>();
	}

	private Set<EStructuralFeature> features;

	protected boolean isIgnoreFeature(Object feature) {
		if (features == null) {
			features = getIgnoreFeatures();
		}
		return features.contains(feature);
	}

	@Override
	public void notifyChanged(final Notification notification) {
		super.notifyChanged(notification);
		if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
			return;
		}
		if (isIgnoreFeature(notification.getFeature())) {
			return;
		}
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				changed(notification);
			}
		});
	}

	protected abstract void changed(Notification notification);

}
