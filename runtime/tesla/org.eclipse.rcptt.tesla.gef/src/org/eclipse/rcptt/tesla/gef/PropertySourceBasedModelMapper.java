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
package org.eclipse.rcptt.tesla.gef;

import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.views.ViewsPlugin;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import org.eclipse.rcptt.tesla.core.ui.DiagramItem;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.swt.properties.PropertySourceSupport;

@SuppressWarnings("restriction")
public class PropertySourceBasedModelMapper {

	public static boolean map(IWorkbenchPart part, Object selection,
			DiagramItem diagramItem) {
		try {
			IPropertySource source = getSource(selection);
			if (source == null)
				return false;

			if (PropertySourceSupport.map(part, source, diagramItem))
				return true;
		} catch (Throwable e) {
			TeslaCore.log(e);
		}

		return false;
	}

	public static boolean isPropertyBasedMapped(IWorkbenchPart part,
			Object selection) {
		IPropertySource source = getSource(selection);
		if (source == null)
			return false;

		if (PropertySourceSupport.isSourcePropertiesMapped(part, source))
			return true;

		return false;
	}

	public static PropertyNodeList getPropertyNodes(IWorkbenchPart part,
			Object selection, String nodePath) {
		IPropertySource source = getSource(selection);
		if (source == null)
			return null;

		if (PropertySourceSupport.isSourcePropertiesMapped(part, source)) {
			return PropertySourceSupport.getPropertyNodes(part, source,
					nodePath);
		}
		return null;
	}

	public static String getPropertyValue(IWorkbenchPart part,
			Object selection, String nodePath) {
		IPropertySource source = getSource(selection);
		if (source == null)
			return null;

		if (PropertySourceSupport.isSourcePropertiesMapped(part, source)) {
			return PropertySourceSupport.getPropertyValue(part, source,
					nodePath);
		}
		return null;
	}

	private static IPropertySource getSource(Object selection) {
		if (selection instanceof IPropertySource)
			return (IPropertySource) selection;
		if (selection instanceof IPropertySourceProvider)
			return ((IPropertySourceProvider) selection)
					.getPropertySource(selection);
		return (IPropertySource) ViewsPlugin.getAdapter(selection,
				IPropertySource.class, false);
	}
}
