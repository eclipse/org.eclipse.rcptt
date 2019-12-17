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
package org.eclipse.rcptt.ui.verification;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.VerificationTypeManager;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.editors.IQ7Viewer;

public class VerificationViewer {

	private static final String ATTR_TYPE = "type"; //$NON-NLS-1$
	private static final String ATTR_CLASS = "class"; //$NON-NLS-1$
	private static final String ATTR_ICON = "icon"; //$NON-NLS-1$

	private VerificationType type;
	private IQ7Viewer<Verification> viewer;
	private ImageDescriptor icon;

	@SuppressWarnings("unchecked")
	public VerificationViewer(IConfigurationElement element) throws CoreException {
		String typeId = getVal(element, ATTR_TYPE);
		type = VerificationTypeManager.getInstance().getTypeById(typeId);
		if (type == null) {
			throw new IllegalArgumentException(Messages.bind(
					Messages.ContextViewer_InvalidTypeErrorMsg, typeId));
		}
		viewer = (IQ7Viewer<Verification>) element.createExecutableExtension(ATTR_CLASS);
		String iconPath = element.getAttribute(ATTR_ICON);
		if (iconPath != null && iconPath.length() > 0) {
			String plugin = element.getContributor().getName();
			icon = AbstractUIPlugin.imageDescriptorFromPlugin(plugin, iconPath);
		}
	}

	public VerificationType getType() {
		return type;
	}

	public IQ7Viewer<Verification> getViewer() {
		return viewer;
	}

	public ImageDescriptor getIcon() {
		return icon;
	}

	private String getVal(IConfigurationElement element, String attr) {
		String val = element.getAttribute(attr);
		if (val == null || val.length() == 0)
			throw new IllegalArgumentException(Messages.bind(
					Messages.VerificationViewer_EmptyErrorMsg, attr));
		return val;
	}
}
