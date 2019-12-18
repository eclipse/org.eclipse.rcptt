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

import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.dev.ui.ScenariosUi;

public class ScenarioPropertySource implements IPropertySource {
	private final Object TYPE_ID = new Object();
	private final IPropertyDescriptor[] descriptors;
	private final Scenario scenario;

	public ScenarioPropertySource(Scenario scenario) {
		this.scenario = scenario;
		String[] supportedModes = Scenarios.hasObsoleteEclFormat(scenario) ? new String[] { "ECL" }
				: new String[] { "ECL", "Tesla" };
		descriptors = new IPropertyDescriptor[] { new ComboBoxPropertyDescriptor(
				TYPE_ID, "Mode", supportedModes) };
	}

	public Object getEditableValue() {
		return null;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		return descriptors;
	}

	public Object getPropertyValue(Object id) {
		if (TYPE_ID.equals(id)) {
			if (Scenarios.isEclMode(scenario))
				return 0;
			else if (Scenarios.isTeslaMode(scenario))
				return 1;
		}
		return null;
	}

	public boolean isPropertySet(Object id) {
		return false;
	}

	public void resetPropertyValue(Object id) {
	}

	public void setPropertyValue(Object id, Object value) {
		if (TYPE_ID.equals(id)) {
			switch ((Integer) value) {
			case 0:
				ScenariosUi.setTypeToEcl(scenario);
				break;
			case 1:
				ScenariosUi.setTypeToTesla(scenario);
				break;
			}
		}
	}
}