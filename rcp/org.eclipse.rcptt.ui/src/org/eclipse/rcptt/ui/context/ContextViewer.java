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
package org.eclipse.rcptt.ui.context;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.editors.IQ7Viewer;

public class ContextViewer {

	private static final String ATTR_TYPE = "type"; //$NON-NLS-1$
	private static final String ATTR_CLASS = "class"; //$NON-NLS-1$
	private static final String ATTR_ICON = "icon"; //$NON-NLS-1$

	private ContextType type;
	private IQ7Viewer<Context> viewer;
	private ImageDescriptor icon;

	@SuppressWarnings("unchecked")
	public ContextViewer(IConfigurationElement element) throws CoreException {
		String typeId = getVal(element, ATTR_TYPE);
		type = ContextTypeManager.getInstance().getTypeById(typeId);
		if (type == null) {
			throw new IllegalArgumentException(Messages.bind(
					Messages.ContextViewer_InvalidTypeErrorMsg, typeId));
		}
		viewer = (IQ7Viewer<Context>) element.createExecutableExtension(ATTR_CLASS);
		String iconPath = element.getAttribute(ATTR_ICON);
		if (iconPath != null && iconPath.length() > 0) {
			String plugin = element.getContributor().getName();
			icon = AbstractUIPlugin.imageDescriptorFromPlugin(plugin, iconPath);
		}
	}

	public ContextType getType() {
		return type;
	}

	public IQ7Viewer<Context> getViewer() {
		return viewer;
	}

	public ImageDescriptor getIcon() {
		return icon;
	}

	private String getVal(IConfigurationElement element, String attr) {
		String val = element.getAttribute(attr);
		if (val == null || val.length() == 0)
			throw new IllegalArgumentException(Messages.bind(
					Messages.ContextViewer_EmptyErrorMsg, attr));
		return val;
	}
}
