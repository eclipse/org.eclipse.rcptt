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
package org.eclipse.rcptt.ui.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class ContextUIManager {

	private static ContextUIManager instance;

	public synchronized static ContextUIManager getInstance() {
		if (instance == null) {
			instance = new ContextUIManager();
		}
		return instance;
	}

	private static final String EXPT_ID = Q7UIPlugin.PLUGIN_ID + ".viewers"; //$NON-NLS-1$

	public ImageDescriptor getIcon(ContextType type) {
		ContextViewer viewer = getViewer(type);
		if (viewer != null) {
			return viewer.getIcon();
		}
		return null;
	}

	public ContextViewer getViewer(ContextType type) {
		init();
		return typeToViewer.get(type);
	}

	public ContextViewer[] getViewers() {
		init();
		return viewers;
	}

	private synchronized void init() {
		if (typeToViewer != null) {
			return;
		}
		typeToViewer = new HashMap<ContextType, ContextViewer>();
		List<ContextViewer> list = new ArrayList<ContextViewer>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXPT_ID);
		for (IConfigurationElement element : elements) {
			try {
				ContextViewer viewer = new ContextViewer(element);
				list.add(viewer);
				typeToViewer.put(viewer.getType(), viewer);
			} catch (CoreException e) {
				Q7UIPlugin.log(e);
			}
		}
		viewers = list.toArray(new ContextViewer[list.size()]);
	}

	private ContextViewer[] viewers = null;

	private Map<ContextType, ContextViewer> typeToViewer;

}
