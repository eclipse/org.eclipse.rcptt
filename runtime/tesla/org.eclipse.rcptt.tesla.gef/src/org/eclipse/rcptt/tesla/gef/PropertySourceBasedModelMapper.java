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
package org.eclipse.rcptt.tesla.gef;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.rcptt.tesla.core.ui.DiagramItem;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.swt.properties.PropertySourceSupport;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

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
		return (IPropertySource) getAdapter(selection,
				IPropertySource.class, false);
	}
	public static Object getAdapter(Object sourceObject, Class<?> adapter, boolean activatePlugins) {
    	Assert.isNotNull(adapter);
        if (sourceObject == null) {
            return null;
        }
        if (adapter.isInstance(sourceObject)) {
			return adapter.cast(sourceObject);
        }

        if (sourceObject instanceof IAdaptable) {
            IAdaptable adaptable = (IAdaptable) sourceObject;

			Object result = adaptable.getAdapter(adapter);
            if (result != null) {
                // Sanity-check
                Assert.isTrue(adapter.isInstance(result));
                return result;
            }
        }

        if (!(sourceObject instanceof PlatformObject)) {
        	Object result;
        	if (activatePlugins) {
				result = adapter.cast(Platform.getAdapterManager().loadAdapter(sourceObject, adapter.getName()));
        	} else {
        		result = Platform.getAdapterManager().getAdapter(sourceObject, adapter);
        	}
            if (result != null) {
                return result;
            }
        }

        return null;
    }
}
