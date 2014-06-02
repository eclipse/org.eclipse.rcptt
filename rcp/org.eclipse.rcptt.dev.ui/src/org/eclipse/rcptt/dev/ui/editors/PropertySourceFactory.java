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
package org.eclipse.rcptt.dev.ui.editors;

import org.eclipse.ui.views.properties.IPropertySource;

import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.ui.editors.IPropertySourceFactory;

public class PropertySourceFactory implements IPropertySourceFactory {

	public IPropertySource createPropertySource(NamedElement scenario) {
		if (scenario instanceof Scenario) {
			return new ScenarioPropertySource((Scenario) scenario);
		}
		return null;
	}

}
