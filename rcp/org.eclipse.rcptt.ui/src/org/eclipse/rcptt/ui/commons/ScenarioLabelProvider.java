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
package org.eclipse.rcptt.ui.commons;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.ui.utils.ModelUtils;

public class ScenarioLabelProvider extends BaseLabelProvider implements
		ILabelProvider {

	public Image getImage(Object element) {
		Scenario scenario = (Scenario) element;
		return ModelUtils.getImage(scenario);
	}

	public String getText(Object element) {
		Scenario scenario = (Scenario) element;
		return scenario.getName();
	}

}
