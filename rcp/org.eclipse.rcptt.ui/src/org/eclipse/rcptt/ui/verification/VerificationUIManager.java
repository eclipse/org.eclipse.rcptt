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
package org.eclipse.rcptt.ui.verification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class VerificationUIManager {

	private static VerificationUIManager instance;

	public synchronized static VerificationUIManager getInstance() {
		if (instance == null) {
			instance = new VerificationUIManager();
		}
		return instance;
	}

	private static final String EXPT_ID = Q7UIPlugin.PLUGIN_ID + ".verificationViewers"; //$NON-NLS-1$

	public ImageDescriptor getIcon(VerificationType type) {
		VerificationViewer viewer = getViewer(type);
		if (viewer != null) {
			return viewer.getIcon();
		}
		return null;
	}

	public VerificationViewer getViewer(VerificationType type) {
		init();
		return typeToViewer.get(type);
	}

	public VerificationViewer[] getViewers() {
		init();
		return viewers;
	}

	private synchronized void init() {
		if (typeToViewer != null) {
			return;
		}
		typeToViewer = new HashMap<VerificationType, VerificationViewer>();
		List<VerificationViewer> list = new ArrayList<VerificationViewer>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXPT_ID);
		for (IConfigurationElement element : elements) {
			try {
				VerificationViewer viewer = new VerificationViewer(element);
				list.add(viewer);
				typeToViewer.put(viewer.getType(), viewer);
			} catch (CoreException e) {
				Q7UIPlugin.log(e);
			}
		}
		viewers = list.toArray(new VerificationViewer[list.size()]);
	}

	private VerificationViewer[] viewers = null;

	private Map<VerificationType, VerificationViewer> typeToViewer;

}
