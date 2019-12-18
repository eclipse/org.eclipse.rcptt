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
package org.eclipse.rcptt.dev.ui.editors;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.ui.views.properties.IPropertySource;

public class PropertySourceFactory implements IAdapterFactory {
	private static final Class<?>[] ADAPTER_LIST = new Class<?>[] { IPropertySource.class };

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof Scenario && adapterType == IPropertySource.class) {
			return new ScenarioPropertySource((Scenario) adaptableObject);
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return ADAPTER_LIST;
	}

}
