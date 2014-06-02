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
package org.eclipse.rcptt.tesla.swt.properties;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

import org.eclipse.rcptt.tesla.core.ui.DiagramItem;
import org.eclipse.rcptt.tesla.core.ui.PropertyNode;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeType;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;

public class PropertySourceSupport {

	public static boolean map(IWorkbenchPart part, IPropertySource source,
			DiagramItem diagramItem) {
		for (IPropertyDescriptor d : source.getPropertyDescriptors()) {
			PropertyNode entry = UiFactory.eINSTANCE.createPropertyNode();
			entry.setName(d.getDisplayName());

			entry.setType(PropertyNodeType.PROPERTY);
			entry.setValue(getStringValue(source, d));

			diagramItem.getModelPropertyNodes().add(entry);
		}

		return true;
	}

	public static boolean isSourcePropertiesMapped(IWorkbenchPart part,
			IPropertySource source) {
		return true;
	}

	public static PropertyNodeList getPropertyNodes(IWorkbenchPart part,
			IPropertySource source, String nodePath) {
		// not supported yet
		return null;
	}

	public static String getPropertyValue(IWorkbenchPart part,
			IPropertySource source, String nodePath) {
		for (IPropertyDescriptor d : source.getPropertyDescriptors())
			if (d.getDisplayName().equals(nodePath))
				return getStringValue(source, d);

		return null;
	}

	private static String getStringValue(IPropertySource source,
			IPropertyDescriptor descriptor) {
		Object value = source.getPropertyValue(descriptor.getId());
		if (value == null)
			return "";

		ILabelProvider labelProvider = descriptor.getLabelProvider();
		if (labelProvider == null)
			return value.toString();

		String text = labelProvider.getText(value);
		if (text == null)
			return "";

		return text;
	}

}
